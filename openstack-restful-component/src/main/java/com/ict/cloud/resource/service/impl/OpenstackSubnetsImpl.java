package com.ict.cloud.resource.service.impl;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.resource.domain.*;
import com.ict.cloud.resource.mapper.OpenstackSubnetsMapper;
import com.ict.cloud.resource.service.IOpenstackSubnetsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OpenstackSubnetsImpl implements IOpenstackSubnetsService {

    @Resource
    private OpenstackSubnetsMapper openstackSubnetsMapper;

    @Override
    public void insertOpenstackSubnets(OpenstackSubnets subnet) throws OperationException {
        int answer = openstackSubnetsMapper.insert(subnet);
        if(answer < 0) {
            throw new OperationException("insertOpenstackSubnets failed！");
        }
    }

    @Override
    public List<OpenstackSubnets> getSubnets(Integer tenantId) {
        OpenstackSubnetsCriteria example = new OpenstackSubnetsCriteria();
        OpenstackSubnetsCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(tenantId);
        return openstackSubnetsMapper.selectByExample(example);
    }

    @Override
    public List<OpenstackSubnets> getAllSubnets() {
        return openstackSubnetsMapper.getAllSubnets();
    }

    @Override
    public void deleteSubnet(Integer tenantId, String subnetId) {
        OpenstackSubnetsCriteria example = new OpenstackSubnetsCriteria();
        OpenstackSubnetsCriteria.Criteria criteria = example.createCriteria();
        criteria.andSubnetIdEqualTo(subnetId);
        criteria.andTenantIdEqualTo(tenantId);
        openstackSubnetsMapper.deleteByExample(example);
    }
}
