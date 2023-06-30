package com.ict.cloud.resource.service;

import com.ict.cloud.model.ServerGroupDTO;
import com.ict.cloud.nova.model.ServerGroup;

import java.util.List;

public interface IOpenstackServerGroupService {

    int insertServerGroupToDB(ServerGroup serverGroup, Integer tenantId);

    List<ServerGroupDTO> getServerGroup(Integer tenantId);

}
