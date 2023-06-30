package com.ict.cloud.resource.service.impl;

import com.ict.cloud.model.ServerGroupDTO;
import com.ict.cloud.nova.model.ServerGroup;
import com.ict.cloud.resource.domain.OpenstackServerGroups;
import com.ict.cloud.resource.mapper.OpenstackServerGroupsMapper;
import com.ict.cloud.resource.service.IOpenstackServerGroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OpenstackServerGroupServiceImpl implements IOpenstackServerGroupService {

    @Resource
    private OpenstackServerGroupsMapper openstackServerGroupMapper;

    @Override
    public int insertServerGroupToDB(ServerGroup serverGroup, Integer tenantId) {
        OpenstackServerGroups openstackServerGroups = new OpenstackServerGroups();
        openstackServerGroups.setServerGroupId(serverGroup.getId());
        openstackServerGroups.setName(serverGroup.getName());
        openstackServerGroups.setTenantId(tenantId);
        openstackServerGroups.setPolicy(serverGroup.getPolicy());
        openstackServerGroups.setMembers(serverGroup.getMembers().toString());
        openstackServerGroups.setInstanceNum(serverGroup.getMembers().size());
        int count = openstackServerGroupMapper.insert(openstackServerGroups);
        if (count > 0) {
            return count;
        }
        return 0;
    }

    @Override
    public List<ServerGroupDTO> getServerGroup(Integer tenantId) {
        return openstackServerGroupMapper.getServerGroup(tenantId);
    }
}
