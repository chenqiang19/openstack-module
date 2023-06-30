package com.ict.cloud.resource.service;

import com.ict.cloud.model.VpcDTO;
import com.ict.cloud.resource.domain.OpenstackVpcs;

import java.util.List;

public interface IOpenstackVPCService {
    int insertVPC(OpenstackVpcs openstackVpcs);

    void updateStatus(Integer vpcId, String vpcStatus);

    List<OpenstackVpcs> getVpcsByTenantId(Integer tenantId);

    void update(VpcDTO vpcDTO, Integer id);
}
