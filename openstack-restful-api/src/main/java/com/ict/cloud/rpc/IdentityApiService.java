package com.ict.cloud.rpc;

import com.ict.cloud.model.ProjectDTO;
import com.ict.cloud.model.RoleDTO;
import com.ict.cloud.model.UserDTO;
import com.ict.cloud.result.Result;

/**
 * @Author CQ
 * @Date 2022/06/08
 * @Description Openstack身份验证组件对外RPC接口定义
 * */
public interface IdentityApiService {
    Result<ProjectDTO> createProjectByTenant(ProjectDTO projectDTO);

    Result<RoleDTO> createRolesByProjectId(RoleDTO roleDTO);

    Result<UserDTO> createUserByProjectId(UserDTO userDTO);

    Result<String> getProjectIdByUserId(Integer tenantId);

    Result removeTenant(Integer tenantId);

    Result<Boolean> addUserRoles(String projectId, String userId, String roleId);

    Result<UserDTO> getUserByUserId(Integer tenantId);

    /**
     * function: 修改租户的密码
     * @param userId 用户的id
     * @param newPwd 新密码
     * */
    Result modifiedPassword(Integer tenantId, String newPwd);
}
