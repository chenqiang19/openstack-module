package com.ict.cloud.resource.service.impl;

import com.ict.cloud.model.VpcDTO;
import com.ict.cloud.resource.domain.OpenstackVpcs;
import com.ict.cloud.resource.mapper.OpenstackVpcsMapper;
import com.ict.cloud.resource.service.IOpenstackVPCService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OpenstackVPCImpl implements IOpenstackVPCService {
    @Resource
    private OpenstackVpcsMapper openstackVpcsMapper;

    @Override
    public int insertVPC(OpenstackVpcs openstackVpcs) {
        int count = openstackVpcsMapper.insert(openstackVpcs);
        if (count > 0) {
            return count;
        }
        return -1;
    }

    @Override
    public void updateStatus(Integer vpcId, String vpcStatus) {
        openstackVpcsMapper.updateStatus(vpcId, vpcStatus);
    }

    @Override
    public List<OpenstackVpcs> getVpcsByTenantId(Integer tenantId) {
        return openstackVpcsMapper.getVpcsByTenantId(tenantId);
    }

    @Override
    public void update(VpcDTO vpcDTO, Integer id) {
        openstackVpcsMapper.update(vpcDTO, id);
    }
}
