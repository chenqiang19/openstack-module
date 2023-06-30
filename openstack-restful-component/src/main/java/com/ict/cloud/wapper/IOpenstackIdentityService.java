package com.ict.cloud.wapper;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.baremetal.BareMetal;
import com.ict.cloud.cinder.Cinder;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.image.Image;
import com.ict.cloud.keystone.Keystone;
import com.ict.cloud.model.ProjectDTO;
import com.ict.cloud.model.RoleDTO;
import com.ict.cloud.model.UserDTO;
import com.ict.cloud.neutron.Neutron;
import com.ict.cloud.nova.Nova;
import com.ict.cloud.resource.domain.*;

public interface IOpenstackIdentityService {

    String checkUserAuthenticated(Integer tenantId);
    boolean checkAdminAuthenticated();

    boolean userConnectOpenstack(String projectName,String userName, String password) throws OperationException;
    boolean connectOpenstack() throws OperationException;
    Keystone getKeyStone(String userName);
    Nova getNova(String userName) throws OperationException;
    Cinder getCinder(String userName);
    Authenticated getAuthenticated(String userName);
    BareMetal getBareMetal(String userName);
    Neutron getNeutron(String userName) throws OperationException;

    Keystone getAdminKeyStone();
    Nova getAdminNova() throws OperationException;
    Image getAdminImage() throws OperationException;
    Cinder getAdminCinder();
    Authenticated getAdminAuthenticated();
    BareMetal getAdminBareMetal() throws OperationException;
    Neutron getAdminNeutron();

    OpenstackProjects createProjectByTenant(ProjectDTO projectDTO) throws OperationException;

    OpenstackRoles createRolesByProjectId(RoleDTO roleDTO) throws OperationException;

    OpenstackUsers createUserByProjectId(UserDTO userDTO) throws OperationException;

    OpenstackUsers getUserByName(String name) throws OperationException;

    String getProjectIdByUserId(Integer tenantId);

    void removeTenant(Integer tenantId) throws OperationException;

    Boolean addUserRoles(String projectId, String userId, String roleId) throws OperationException;

    OpenstackUsers getUserByTenantId(Integer tenantId);

    void modifiedPassword(Integer tenantId, String newPwd) throws OperationException;
}
