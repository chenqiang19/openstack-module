package com.ict.cloud.resource.service.impl;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.resource.domain.OpenstackNetworks;
import com.ict.cloud.resource.domain.OpenstackNetworksCriteria;
import com.ict.cloud.resource.mapper.OpenstackNetworksMapper;
import com.ict.cloud.resource.service.IOpenstackNetworksService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OpenstackNetworksImpl implements IOpenstackNetworksService {
    @Resource
    private OpenstackNetworksMapper openstackNetworksMapper;

    public OpenstackNetworks getOpenstackNetworkByPrimaryKey(Integer id) {
        return openstackNetworksMapper.selectByPrimaryKey(id);
    }

    public void insertOpenstackNetwork(OpenstackNetworks resource) throws OperationException {
        int answer = openstackNetworksMapper.insert(resource);
        if(answer < 0) {
            throw new OperationException("insertOpenstackNetwork failed！");
        }
    }

    public List<OpenstackNetworks> getNetworks(Integer tenantId) {
        OpenstackNetworksCriteria example = new OpenstackNetworksCriteria();
        OpenstackNetworksCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(tenantId);
        return openstackNetworksMapper.selectByExample(example);
    }

    public List<OpenstackNetworks> getAllNetwork() {
        return openstackNetworksMapper.selectAllNetwork();
    }

    public void deleteNetwork(Integer tenantId, String networkId) {
        OpenstackNetworksCriteria example = new OpenstackNetworksCriteria();
        OpenstackNetworksCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(tenantId);
        criteria.andNetworkIdEqualTo(networkId);
        openstackNetworksMapper.deleteByExample(example);
    }
}
