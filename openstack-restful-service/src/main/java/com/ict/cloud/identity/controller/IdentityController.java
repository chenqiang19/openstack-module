package com.ict.cloud.identity.controller;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.baremetal.BareMetal;
import com.ict.cloud.cinder.Cinder;
import com.ict.cloud.common.analzye.ApiResult;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.keystone.Keystone;
import com.ict.cloud.model.ProjectDTO;
import com.ict.cloud.model.RoleDTO;
import com.ict.cloud.model.UserDTO;
import com.ict.cloud.neutron.Neutron;
import com.ict.cloud.nova.Nova;
import com.ict.cloud.resource.domain.OpenstackProjects;
import com.ict.cloud.resource.domain.OpenstackRoles;
import com.ict.cloud.resource.domain.OpenstackUsers;
import com.ict.cloud.wapper.IOpenstackIdentityService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/v1/openstack-management/identity")
public class IdentityController {
    @Resource
    IOpenstackIdentityService iOpenstackIdentityService;

    @PostMapping("/userConnectOpenstack")
    public ApiResult<Boolean> userConnectOpenstack(@RequestParam("projectName") String projectName,
                                                   @RequestParam("userName") String userName,
                                                   @RequestParam("password") String password) {
        try {
            boolean connectStatus = iOpenstackIdentityService.userConnectOpenstack(projectName, userName, password);
            return ApiResult.success(new Boolean(connectStatus));
        } catch (OperationException e) {
            return ApiResult.failed(e.getMessage());
        }
    }

    @PostMapping("/connectOpenstack")
    public ApiResult<Boolean> connectOpenstack() {
        try {
            boolean connectStatus = iOpenstackIdentityService.connectOpenstack();
            return ApiResult.success(new Boolean(connectStatus));
        } catch (OperationException e) {
            return ApiResult.failed(e.getMessage());
        }
    }

    @GetMapping("/getKeyStone/{userName}")
    public ApiResult<Keystone> getKeyStone(@PathVariable("userName") String userName) {
        Keystone keystone = iOpenstackIdentityService.getKeyStone(userName);
        return ApiResult.success(keystone);
    }

    @PutMapping("/modifiedPassword")
    public ApiResult modifiedPassword(@RequestParam("tenantId") Integer tenantId,
                                      @RequestParam("newPwd") String newPwd) {
        try {
            iOpenstackIdentityService.modifiedPassword(tenantId, newPwd);
            return ApiResult.success();
        } catch (OperationException e) {
            return ApiResult.failed(e.getMessage());
        }
    }

    @GetMapping("/getNova/{userName}")
    public ApiResult<Nova> getNova(@PathVariable("userName") String userName) {
        try {
            Nova nova = iOpenstackIdentityService.getNova(userName);
            return ApiResult.success(nova);
        } catch (OperationException e) {
            return ApiResult.failed(e.getMessage());
        }
    }

    @GetMapping("/getCinder/{userName}")
    public ApiResult<Cinder> getCinder(@PathVariable("userName") String userName) {
        Cinder cinder = iOpenstackIdentityService.getCinder(userName);
        return ApiResult.success(cinder);
    }

    @GetMapping("/getAuthenticated/{userName}")
    public ApiResult<Authenticated> getAuthenticated(@PathVariable("userName") String userName) {
        Authenticated authenticated = iOpenstackIdentityService.getAuthenticated(userName);
        return ApiResult.success(authenticated);
    }

    @GetMapping("/getBareMetal/{userName}")
    public ApiResult<BareMetal> getBareMetal(String userName) {
        BareMetal bareMetal = iOpenstackIdentityService.getBareMetal(userName);
        return ApiResult.success(bareMetal);
    }

    @GetMapping("/getNeutron")
    public ApiResult<Neutron> getNeutron(String userName) throws OperationException {
        Neutron neutron = iOpenstackIdentityService.getNeutron(userName);
        return ApiResult.success(neutron);
    }

    @GetMapping("/getAdminKeyStone")
    public ApiResult<Keystone> getAdminKeyStone() {
        Keystone adminKeystone = iOpenstackIdentityService.getAdminKeyStone();
        return ApiResult.success(adminKeystone);
    }

    @GetMapping("/getAdminNova")
    public ApiResult<Nova> getAdminNova() {
        try {
            Nova adminNova = iOpenstackIdentityService.getAdminNova();
            return ApiResult.success(adminNova);
        } catch (OperationException e) {
            return ApiResult.failed(e.getMessage());
        }
    }

    @GetMapping("/getAdminCinder")
    public ApiResult<Cinder> getAdminCinder() {
        Cinder adminCinder = iOpenstackIdentityService.getAdminCinder();
        return ApiResult.success(adminCinder);
    }

    @GetMapping("/getAdminAuthenticated")
    public ApiResult<Authenticated> getAdminAuthenticated() {
        Authenticated adminAuthenticated = iOpenstackIdentityService.getAdminAuthenticated();
        return ApiResult.success(adminAuthenticated);
    }

    @GetMapping("/getAdminBareMetal")
    public ApiResult<BareMetal> getAdminBareMetal() {
        try {
            BareMetal adminBareMetal = iOpenstackIdentityService.getAdminBareMetal();
            return ApiResult.success(adminBareMetal);
        } catch (OperationException e) {
            return ApiResult.failed(e.getMessage());
        }
    }

    @GetMapping("getAdminNeutron")
    public ApiResult<Neutron> getAdminNeutron() {
        Neutron adminNeutron = iOpenstackIdentityService.getAdminNeutron();
        return ApiResult.success(adminNeutron);
    }

    @PostMapping("/createProjectByTenant")
    public ApiResult<OpenstackProjects> createProjectByTenant(@Validated @RequestBody ProjectDTO projectDTO) {
        try{
            OpenstackProjects projects = iOpenstackIdentityService.createProjectByTenant(projectDTO);
            return ApiResult.success(projects);
        } catch (OperationException e) {
            return ApiResult.failed(e.getMessage());
        }
    }

    @PostMapping("/createRolesByProjectId")
    public ApiResult<OpenstackRoles> createRolesByProjectId(@Validated @RequestBody RoleDTO roleDTO) {
        try {
            OpenstackRoles roles = iOpenstackIdentityService.createRolesByProjectId(roleDTO);
            return ApiResult.success(roles);
        } catch (OperationException e) {
            return ApiResult.failed(e.getMessage());
        }
    }

    @PostMapping("/createUserByProjectId")
    public ApiResult<OpenstackUsers> createUserByProjectId(@Validated @RequestBody UserDTO userDTO) {
        try {
            OpenstackUsers openstackUsers = iOpenstackIdentityService.createUserByProjectId(userDTO);
            return ApiResult.success(openstackUsers);
        } catch (OperationException e) {
            return ApiResult.failed(e.getMessage());
        }
    }

    @GetMapping("/getProjectIdByUserId/{tenantId}")
    public ApiResult<String> getProjectIdByUserId(@PathVariable("tenantId") Integer tenantId) {
        String projectId = iOpenstackIdentityService.getProjectIdByUserId(tenantId);
        return ApiResult.success(projectId);
    }

    @PostMapping("/addUserRoles")
    public ApiResult<Boolean> addUserRoles(@RequestParam("projectId") String projectId,
                                           @RequestParam("userId") String userId,
                                           @RequestParam("roleId") String roleId) {
        try {
            Boolean addStatus = iOpenstackIdentityService.addUserRoles(projectId, userId, roleId);
            return ApiResult.success(addStatus);
        } catch (OperationException e) {
            return ApiResult.failed(e.getMessage());
        }
    }

    @GetMapping("/getUserByUserId/{tenantId}")
    public ApiResult<OpenstackUsers> getUserByUserId(@PathVariable("tenantId") Integer tenantId) {
        OpenstackUsers users = iOpenstackIdentityService.getUserByTenantId(tenantId);
        return ApiResult.success(users);
    }
}
