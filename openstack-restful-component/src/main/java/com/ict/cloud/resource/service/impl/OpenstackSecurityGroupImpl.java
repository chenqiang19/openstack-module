package com.ict.cloud.resource.service.impl;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.resource.domain.OpenstackSecurityGroup;
import com.ict.cloud.resource.domain.OpenstackSecurityGroupCriteria;
import com.ict.cloud.resource.mapper.OpenstackSecurityGroupMapper;
import com.ict.cloud.resource.service.IOpenstackSecurityGroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OpenstackSecurityGroupImpl implements IOpenstackSecurityGroupService {
    @Resource
    private OpenstackSecurityGroupMapper openstackSecurityGroupMapper;

    public OpenstackSecurityGroup getOpenstackSecurityGroupByPrimaryKey(Integer id) {
        return openstackSecurityGroupMapper.selectByPrimaryKey(id);
    }

    public void insertOpenstackSecurityGroup(OpenstackSecurityGroup resource) throws OperationException {
        int answer = openstackSecurityGroupMapper.insert(resource);
        if(answer < 0) {
            throw new OperationException("insertOpenstackSecurityGroup failed！");
        }
    }

    public List<OpenstackSecurityGroup> getSecurityGroupIds() {
        OpenstackSecurityGroupCriteria example = new OpenstackSecurityGroupCriteria();
        OpenstackSecurityGroupCriteria.Criteria criteria = example.createCriteria();
        return openstackSecurityGroupMapper.selectByExample(example);
    }

    public List<OpenstackSecurityGroup> getSecurityGroupByTenantId(Integer tenantId) {
        OpenstackSecurityGroupCriteria example = new OpenstackSecurityGroupCriteria();
        OpenstackSecurityGroupCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(tenantId);
        return openstackSecurityGroupMapper.selectByExample(example);
    }

    public OpenstackSecurityGroup getSecurityGroupBySecurityGroupId(String securityGroupId) {
        OpenstackSecurityGroupCriteria example = new OpenstackSecurityGroupCriteria();
        OpenstackSecurityGroupCriteria.Criteria criteria = example.createCriteria();
        criteria.andSecurityGroupIdEqualTo(securityGroupId);
        return openstackSecurityGroupMapper.selectOneByExample(example);
    }
}
