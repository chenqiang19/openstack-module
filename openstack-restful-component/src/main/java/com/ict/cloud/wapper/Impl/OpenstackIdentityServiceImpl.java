package com.ict.cloud.wapper.Impl;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.baremetal.BareMetal;
import com.ict.cloud.cinder.Cinder;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.image.Image;
import com.ict.cloud.keystone.Keystone;
import com.ict.cloud.keystone.model.Project;
import com.ict.cloud.keystone.model.Role;
import com.ict.cloud.keystone.model.User;
import com.ict.cloud.model.ProjectDTO;
import com.ict.cloud.model.RoleDTO;
import com.ict.cloud.model.UserDTO;
import com.ict.cloud.neutron.Neutron;
import com.ict.cloud.nova.Nova;
import com.ict.cloud.resource.domain.OpenstackProjects;
import com.ict.cloud.resource.domain.OpenstackRoles;
import com.ict.cloud.resource.domain.OpenstackUsers;
import com.ict.cloud.resource.service.IOpenstackProjectService;
import com.ict.cloud.resource.service.IOpenstackRolesService;
import com.ict.cloud.resource.service.IOpenstackUsersService;
import com.ict.cloud.wapper.Configure.ConfigLoader;
import com.ict.cloud.wapper.IOpenstackIdentityService;
import com.ict.cloud.session.OpenStackSession;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Hashtable;

@Service("identity")
public class OpenstackIdentityServiceImpl implements IOpenstackIdentityService {
    @Resource
    private ConfigLoader configLoader;
    @Autowired
    private IOpenstackUsersService iOpenstackUsersService;
    @Autowired
    private IOpenstackProjectService iOpenstackProjectService;
    @Resource
    private IOpenstackRolesService iOpenstackRolesService;

    private OpenStackSession openStackSession = null;
    private Hashtable<String, OpenStackSession> userSession = new Hashtable<>();
    private OpenStackSession openStackUserSession = null;

    @Override
    public String checkUserAuthenticated(Integer tenantId) {
        try {
            OpenstackUsers openstackUsers = this.getUserByTenantId(tenantId);
            boolean valid = this.userConnectOpenstack(openstackUsers.getUserName(), openstackUsers.getUserName(),
                    new String(Base64.getDecoder().decode(openstackUsers.getPassword())));
            if (!valid) {
                throw new OperationException("OpenStack connect failed!");
            }
            return openstackUsers.getUserName();
        } catch (OperationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean checkAdminAuthenticated() {
        try {
            boolean valid = this.connectOpenstack();
            if(!valid){
                throw new OperationException("Openstack Connect failed!");
            }
            return Boolean.TRUE;
        } catch (OperationException e) {
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }

    @Override
    public void modifiedPassword(Integer tenantId, String newPwd) throws OperationException {
        OpenstackUsers openstackUsers = this.getUserByTenantId(tenantId);
        boolean valid = this.connectOpenstack();
        if(!valid){
            throw new OperationException("Openstack Connect failed!");
        }
        Keystone keystone = this.getAdminKeyStone();
        keystone.users.changePassword(openstackUsers.getUserId(), new String(Base64.getDecoder().decode(openstackUsers.getPassword())),newPwd);
        openstackUsers.setPassword(newPwd);
        iOpenstackUsersService.updateUser(openstackUsers);
    }

    public boolean connectOpenstack() throws OperationException {
        if(openStackSession == null){
            openStackSession = OpenStackSession.getSession(configLoader.getName(), configLoader.getUser(), configLoader.getPassword());
            if(this.getAdminAuthenticated()==null){
                return false;
            }else{
                //userSession.put(configLoader.getName(), openStackUserSession);
                return true;
            }
        }else if(openStackSession.getKeystoneClient().getCredentical().getToken().isExpired()){
            openStackSession = OpenStackSession.getSession(configLoader.getName(), configLoader.getUser(), configLoader.getPassword());
            if(this.getAdminAuthenticated()==null){
                return false;
            }else{
                //userSession.put(configLoader.getName(), openStackUserSession);
                return true;
            }
        }else{
            return true;
        }
    }

    @Synchronized
    public boolean userConnectOpenstack(String userName, String projectName, String password) throws OperationException {
        if(userSession.size()==0 && !userSession.containsKey(userName)){
            openStackUserSession = OpenStackSession.getSession(projectName+ "_project", userName, password);
            userSession.put(userName, openStackUserSession);
            if(this.getAuthenticated(userName)==null){
                return false;
            }else{
                return true;
            }
        }else if(userSession.containsKey(userName) && userSession.get(userName).getKeystoneClient().getCredentical().getToken().isExpired()){
            openStackUserSession = OpenStackSession.getSession(projectName+ "_project", userName, password);
            userSession.put(userName, openStackUserSession);
            if(this.getAuthenticated(userName)==null){
                return false;
            }else{
                return true;
            }
        }else if(userSession.containsKey(userName)){
            return true;
        }else {
            openStackUserSession = OpenStackSession.getSession(projectName+ "_project", userName, password);
            userSession.put(userName, openStackUserSession);
            if(this.getAuthenticated(userName)==null){
                return false;
            }else{
                return true;
            }
        }
    }

    public Keystone getAdminKeyStone() {
        return openStackSession.getKeystoneClient();
    }
    public Nova getAdminNova() throws OperationException {
        Nova nova = null;
        if(openStackSession==null) {
            this.connectOpenstack();
            nova = openStackSession.getNovaClient();
        }else{
            nova = openStackSession.getNovaClient();
        }
        return nova;
    }
    public BareMetal getAdminNode() { return openStackSession.getBareMetal(); }
    public Authenticated getAdminAuthenticated() {
        return openStackSession.getCredentical();
    }
    public Cinder getAdminCinder() { return openStackSession.getCinderClient(); }
    public BareMetal getAdminBareMetal() throws OperationException {
        BareMetal bareMetal = null;
        if(openStackSession==null){
            this.connectOpenstack();
            bareMetal = openStackSession.getBareMetal();
        }else {
            bareMetal = openStackSession.getBareMetal();
        }
        return bareMetal;
    }
    public Neutron getAdminNeutron() { return openStackSession.getNeutron(); }

    public Keystone getKeyStone(String userName) {
        return openStackUserSession.getKeystoneClient();
    }
    public Nova getNova(String userName) throws OperationException {
        Nova nova = null;
        if (userSession.containsKey(userName) || openStackSession.getKeystoneClient().getCredentical().getToken().isExpired()) {
            OpenstackUsers users = iOpenstackUsersService.getUserByName(userName);
            this.userConnectOpenstack(userName, userName, users.getPassword());
            nova = userSession.get(userName).getNovaClient();
        }else {
            nova = userSession.get(userName).getNovaClient();
        }
        return nova;
    }
    public Image getAdminImage() throws OperationException {
        Image image = null;
        if(openStackSession==null) {
            this.connectOpenstack();
            image = openStackSession.getImage();
        }else{
            image = openStackSession.getImage();
        }
        return image;
    }
    public BareMetal getNode(String userName) { return userSession.get(userName).getBareMetal(); }
    public Authenticated getAuthenticated(String userName) {
        return userSession.get(userName).getCredentical();
    }
    public Cinder getCinder(String userName) { return userSession.get(userName).getCinderClient(); }
    public BareMetal getBareMetal(String userName) { return userSession.get(userName).getBareMetal(); }
    public Neutron getNeutron(String userName) throws OperationException {
        Neutron neutron;
        if (userSession.containsKey(userName) || openStackSession.getKeystoneClient().getCredentical().getToken().isExpired()) {
            OpenstackUsers users = iOpenstackUsersService.getUserByName(userName);
            this.userConnectOpenstack(userName, userName, users.getPassword());
            neutron = userSession.get(userName).getNeutron();
        }else {
            neutron = userSession.get(userName).getNeutron();
        }
        return neutron;
    }
    @Override
    public OpenstackProjects createProjectByTenant(ProjectDTO projectDTO) throws OperationException {
        boolean valid = this.connectOpenstack();
        if(!valid){
            throw new OperationException("Openstack Connect failed!");
        }
        Keystone keystone = this.getAdminKeyStone();
        Project project = new Project();
        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
        project.setDomainId(projectDTO.getDomainId());
        project.setIsDomain(false);
        project.setEnabled(projectDTO.getEnabled());
        try{
            Project dataProject = keystone.projects.create(project);
            OpenstackProjects openstackProject = new OpenstackProjects();
            openstackProject.setProjectId(dataProject.getId());
            openstackProject.setDomainId(dataProject.getDomainId());
            openstackProject.setProjectName(dataProject.getName());
            openstackProject.setEnabled(dataProject.isEnabled());
            openstackProject.setDescript(dataProject.getDescription());
            openstackProject.setIsDomain(dataProject.getIsDomain());
            iOpenstackProjectService.insertOpenstackProject(openstackProject);
            return openstackProject;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public OpenstackRoles createRolesByProjectId(RoleDTO roleDTO) throws OperationException {
        boolean valid = this.connectOpenstack();
        if(!valid){
            throw new OperationException("Openstack Connect failed!");
        }
        Keystone keystone = this.getAdminKeyStone();
        try{
            Role role = keystone.roles.create(roleDTO.getName());
            OpenstackRoles openstackRoles = new OpenstackRoles();
            openstackRoles.setRoleId(role.getId());
            openstackRoles.setRoleName(role.getName());
            openstackRoles.setDescription(role.getDescription());
            iOpenstackRolesService.insertOpenstackRoles(openstackRoles);
            return openstackRoles;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public OpenstackUsers createUserByProjectId(UserDTO userDTO) throws OperationException {
        boolean valid = this.connectOpenstack();
        if(!valid){
            throw new OperationException("Openstack Connect failed!");
        }
        Keystone keystone = this.getAdminKeyStone();
        User user = new User();
        user.setProjectId(userDTO.getProjectId());
        user.setPassword(userDTO.getPassword());
        user.setName(userDTO.getName());
        user.setDescription("This is " + userDTO.getName());
        user.setEnabled(true);
        try{
            User dataUser = keystone.users.create(user);
            if(dataUser==null){
                throw new OperationException("创建用户失败！");
            }
            OpenstackUsers openstackUsers = new OpenstackUsers();
            openstackUsers.setUserName(userDTO.getName());
            openstackUsers.setPassword(Base64.getEncoder().encodeToString(userDTO.getPassword().getBytes(StandardCharsets.UTF_8)));
            openstackUsers.setUserId(dataUser.getId());
            openstackUsers.setEnabled(dataUser.isEnabled());
            openstackUsers.setDefaultProjectId(dataUser.getProjectId());
            openstackUsers.setDomainId(dataUser.getDomainId());
            openstackUsers.setTenantId(userDTO.getTenantId());
            iOpenstackUsersService.insertOpenstackUsers(openstackUsers);
            return openstackUsers;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public String getProjectIdByUserId(Integer tenantId) {
        OpenstackUsers openstackUsers = this.getUserByTenantId(tenantId);
        return iOpenstackUsersService.getProjectIdByUserId(openstackUsers.getUserId());
    }

    @Override
    public Boolean addUserRoles(String projectId, String userId, String roleId) throws OperationException {
        boolean valid = this.connectOpenstack();
        if(!valid){
            throw new OperationException("Openstack Connect failed!");
        }
        Keystone keystone = this.getAdminKeyStone();
        return keystone.roles.addUserRole(projectId, userId, roleId);
    }

    @Override
    public OpenstackUsers getUserByTenantId(Integer userId) {
        return iOpenstackUsersService.getUserByTenantId(userId);
    }

    @Override
    public void removeTenant(Integer tenantId) throws OperationException {
        boolean valid = this.connectOpenstack();
        if(!valid){
            throw new OperationException("Openstack Connect failed!");
        }
        OpenstackUsers openstackUsers = this.getUserByTenantId(tenantId);
        Keystone keystone = this.getAdminKeyStone();
        try {
            keystone.users.delete(openstackUsers.getUserId());
            String projectId = iOpenstackUsersService.getProjectIdByUserId(openstackUsers.getUserId());
            keystone.projects.delete(projectId);

            iOpenstackUsersService.deleteUserByUserId(openstackUsers.getUserId());
            iOpenstackProjectService.deleteProjectByProjectId(projectId);
        }catch (Exception e){
            throw new OperationException("用户注销失败！");
        }
    }

    @Override
    public OpenstackUsers getUserByName(String name) throws OperationException {
        return iOpenstackUsersService.getUserByName(name);
    }
}
