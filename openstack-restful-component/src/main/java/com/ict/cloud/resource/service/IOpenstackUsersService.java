package com.ict.cloud.resource.service;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.resource.domain.OpenstackUsers;

public interface IOpenstackUsersService {
    void insertOpenstackUsers(OpenstackUsers openstackUsers) throws OperationException;

    String getProjectIdByUserId(String userId);

    void deleteUserByUserId(String userId);

    OpenstackUsers getUserByTenantId(Integer tenantId);

    OpenstackUsers getUserByName(String userName);

    void updateUser(OpenstackUsers openstackUsers);
}
