package com.ict.cloud.resource.service;

import com.ict.cloud.common.exception.ServiceException;
import com.ict.cloud.resource.domain.OpenstackSecurityGroupRules;

import java.util.List;

public interface IOpenstackSecurityGroupRuleService {

    int insert(OpenstackSecurityGroupRules openstackSecurityGroupRules) throws ServiceException;

    int batchInsertSecurityGroupRules(List<OpenstackSecurityGroupRules> openstackSecurityGroupRulesList) throws ServiceException;

    List<OpenstackSecurityGroupRules> getSecurityGroupRules(Integer tenantId, String securityGroupId);

    void removeSecurityGroupRule(String securityGroupRuleId);
}
