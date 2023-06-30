package com.ict.cloud.nova.api.v2;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.nova.api.ServerGroupManager;
import com.ict.cloud.nova.model.ServerGroup;

import java.util.List;

public class ServerGroups extends AbstractManager<ServerGroup> implements ServerGroupManager {

    private final String PREFIX = "/os-server-groups";
    public ServerGroups(Authenticated credentical) {
        super(credentical, ServerGroup.class);
    }
    @Override
    public List<ServerGroup> listServerGroup() throws OperationException {
        return _list(PREFIX);
    }

    @Override
    public ServerGroup getServerGroup(String serverGroupId) throws OperationException {
        return _get(PREFIX + "/" + serverGroupId);
    }

    @Override
    public void deleteServerGroup(String serverGroupId) throws OperationException {
        _delete(PREFIX + "/" + serverGroupId);
    }

    @Override
    public ServerGroup createServerGroup(ServerGroup serverGroup) throws OperationException {
        return _create(PREFIX, serverGroup);
    }
}
