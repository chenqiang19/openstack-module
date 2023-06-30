package com.ict.cloud.wapper.rpcImpl;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.model.ProjectDTO;
import com.ict.cloud.model.RoleDTO;
import com.ict.cloud.model.UserDTO;
import com.ict.cloud.resource.domain.OpenstackProjects;
import com.ict.cloud.resource.domain.OpenstackRoles;
import com.ict.cloud.resource.domain.OpenstackUsers;
import com.ict.cloud.result.Result;
import com.ict.cloud.rpc.IdentityApiService;
import com.ict.cloud.wapper.IOpenstackIdentityService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

@Service
public class IdentityApiServiceImpl implements IdentityApiService {
    @Resource
    private IOpenstackIdentityService iOpenstackIdentityService;

    @Override
    public Result<ProjectDTO> createProjectByTenant(ProjectDTO projectDTO) {
        try {
            OpenstackProjects openstackProjects = iOpenstackIdentityService.createProjectByTenant(projectDTO);
            ProjectDTO retProject = new ProjectDTO();
            if (openstackProjects != null) {
                BeanUtils.copyProperties(openstackProjects, retProject);
            }
            return Result.Success(retProject);
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<RoleDTO> createRolesByProjectId(RoleDTO roleDTO) {
        try {
            OpenstackRoles openstackRoles = iOpenstackIdentityService.createRolesByProjectId(roleDTO);
            RoleDTO retRole = new RoleDTO();
            if (openstackRoles != null) {
                BeanUtils.copyProperties(openstackRoles, retRole);
            }
            return Result.Success(retRole);
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<UserDTO> createUserByProjectId(UserDTO userDTO) {
        try {
            OpenstackUsers openstackUsers = iOpenstackIdentityService.createUserByProjectId(userDTO);
            if(openstackUsers == null) {
                return Result.Failure(-1, "CreateUser Failed!");
            }
            UserDTO retUser = new UserDTO();
            if (openstackUsers != null) {
                BeanUtils.copyProperties(openstackUsers, retUser);
            }
            return Result.Success(retUser);
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<String> getProjectIdByUserId(Integer tenantId) {
        String projectId = iOpenstackIdentityService.getProjectIdByUserId(tenantId);
        return Result.Success(projectId);
    }

    @Override
    public Result removeTenant(Integer tenantId) {
        try {
            iOpenstackIdentityService.removeTenant(tenantId);
            return Result.Success();
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<Boolean> addUserRoles(String projectId, String userId, String roleId) {
        try {
            Boolean addStatus = iOpenstackIdentityService.addUserRoles(projectId, userId, roleId);
            return Result.Success(addStatus);
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<UserDTO> getUserByUserId(Integer tenantId) {
        OpenstackUsers openstackUsers = iOpenstackIdentityService.getUserByTenantId(tenantId);
        UserDTO userDTO = new UserDTO();
        if (openstackUsers != null) {
            BeanUtils.copyProperties(openstackUsers, userDTO);
        }
        return Result.Success(userDTO);
    }

    @Override
    public Result modifiedPassword(Integer tenantId, String newPwd) {
        try {
            iOpenstackIdentityService.modifiedPassword(tenantId, newPwd);
            return Result.Success();
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }
}
