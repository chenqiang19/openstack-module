package com.ict.cloud.resource.service.impl;

import com.ict.cloud.common.exception.ServiceException;
import com.ict.cloud.resource.domain.OpenstackSecurityGroupCriteria;
import com.ict.cloud.resource.domain.OpenstackSecurityGroupRules;
import com.ict.cloud.resource.mapper.OpenstackSecurityGroupRulesMapper;
import com.ict.cloud.resource.service.IOpenstackSecurityGroupRuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OpenstackSecurityGroupRulesImpl implements IOpenstackSecurityGroupRuleService {
    @Resource
    private OpenstackSecurityGroupRulesMapper openstackSecurityGroupRulesMapper;
    @Override
    public int insert(OpenstackSecurityGroupRules openstackSecurityGroupRules) throws ServiceException {
        int count = openstackSecurityGroupRulesMapper.insert(openstackSecurityGroupRules);
        if(count > 0) {
            return count;
        }
        throw new ServiceException("安全组规则插入失败");
    }

    @Override
    public int batchInsertSecurityGroupRules(List<OpenstackSecurityGroupRules> openstackSecurityGroupRulesList) throws ServiceException {
        int count = openstackSecurityGroupRulesMapper.batchInsertSecurityGroupRules(openstackSecurityGroupRulesList);
        if(count > 0) {
            return count;
        }
        throw new ServiceException("安全组规则插入失败");
    }

    @Override
    public List<OpenstackSecurityGroupRules> getSecurityGroupRules(Integer tenantId, String securityGroupId) {
        return openstackSecurityGroupRulesMapper.getSecurityGroupRules(tenantId, securityGroupId);
    }

    @Override
    public void removeSecurityGroupRule(String securityGroupRuleId) {
        openstackSecurityGroupRulesMapper.removeSecurityGroupRule(securityGroupRuleId);
        return;
    }
}
