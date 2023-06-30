package com.ict.cloud.nova.api;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.nova.model.ServerGroup;

import java.util.List;

public interface ServerGroupManager {

    /**
     * Lists all server groups for the tenant
     * Administrative users can use the all_projects query parameter to list all server groups for all projects.
     * Normal response codes: 200
     * Error response codes: unauthorized(401), forbidden(403)
     * */
    List<ServerGroup> listServerGroup() throws OperationException;

    /**
     * Shows detail for a server group
     * Normal response codes: 200
     * Error response codes: unauthorized(401), forbidden(403), itemNotFound(404)
     * */
    ServerGroup getServerGroup(String serverGroupId) throws OperationException;

    /**
     * Deletes a server group
     * Normal response codes: 204
     * Error response codes: unauthorized(401), forbidden(403), itemNotFound(404)
     * */
    void deleteServerGroup(String serverGroupId) throws OperationException;

    /**
     *  Create a server group
     *  Normal response codes: 200
     *  Error response codes: badRequest(400), unauthorized(401), forbidden(403), conflict(409)
     * */
    ServerGroup createServerGroup(ServerGroup serverGroup) throws OperationException;
}
