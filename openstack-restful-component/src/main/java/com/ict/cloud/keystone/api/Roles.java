package com.ict.cloud.keystone.api;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.keystone.model.Role;
import com.ict.cloud.common.exception.OperationException;

import java.util.List;

public class Roles extends AbstractManager<Role> implements RoleManager {
    private static final String PREFIX = "/v3/roles";
    public Roles(Authenticated credentical) {
        super(credentical, Role.class);
    }

    @Override
    public Role get(String id) throws OperationException {
        return super._get(PREFIX + "/" + id);
    }

    @Override
    public List<Role> list() throws OperationException {
        return super._list(PREFIX);
    }

    @Override
    public List<Role> list(String userId, String tenantId)
            throws OperationException {
        String route;
        if (tenantId != null) {
            route = String.format("/v3/projects/%s/users/%s/roles", tenantId, userId);
        } else {
            route = String.format("/v3/users/%s/roles", userId);
        }
        return super._list(route);
    }
    @Override
    public Boolean addUserRole(String projectId, String userId, String roleId)
            throws OperationException {
        String route;
        if (projectId != null) {
            route = String.format("/v3/projects/%s/users/%s/roles/%s", projectId, userId, roleId);
        } else {
            route = String.format("/v3/users/%s/roles/%s", userId, roleId);
        }
        return super._update(route);
    }

    @Override
    public void removeUserRole(String roleId, String userId, String tenantId)
            throws OperationException {
        String route;
        if (tenantId != null) {
            route = String.format("/v3/projects/%s/users/%s/roles/%s", tenantId, userId, roleId);
        } else {
            route = String.format("/v3/users/%s/roles/%s", userId, roleId);
        }
        super._delete(route);
    }

    @Override
    public Role create(String name) throws OperationException {
        Role role = new Role();
        role.setName(name);
        return super._create(PREFIX, role);
    }
    /**
     * FIXME 无论成功还是失败，都会抛出异常
     */
    @Override
    public void delete(String id) throws OperationException {
        try {
            super._delete(PREFIX + "/" + id);
        } catch (Exception e) {

        }
    }

}
