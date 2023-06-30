package com.ict.cloud.keystone.api;

import com.ict.cloud.keystone.model.Tenant;
import com.ict.cloud.keystone.model.User;
import com.ict.cloud.common.exception.OperationException;

import java.util.List;

public interface TenantManager {
    List<Tenant> list() throws OperationException;
    Tenant get(String id) throws OperationException;
    Tenant create(Tenant tenant) throws OperationException;
    Tenant create(String name, String description) throws OperationException;
    Tenant update(String id, Tenant tenant) throws OperationException;
    Tenant rename(String id, String name) throws OperationException;
    Tenant enabled(String id) throws OperationException;
    Tenant disabled(String id) throws OperationException;
    List<User> listUsers(String id) throws OperationException;
    void  addUser(String tenantId, String userId, String roleId) throws OperationException;
    void removeUser(String tenantId, String userId, String roleId) throws OperationException;
    void delete(String id) throws OperationException;
}


