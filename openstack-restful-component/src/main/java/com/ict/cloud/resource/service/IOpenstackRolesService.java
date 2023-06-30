package com.ict.cloud.resource.service;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.resource.domain.OpenstackRoles;

public interface IOpenstackRolesService {
    void insertOpenstackRoles(OpenstackRoles openstackRoles) throws OperationException;
}
