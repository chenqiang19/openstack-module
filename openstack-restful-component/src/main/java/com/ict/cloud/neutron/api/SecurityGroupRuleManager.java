package com.ict.cloud.neutron.api;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.neutron.model.SecurityGroupRule;

import java.util.List;

public interface SecurityGroupRuleManager {
    List<SecurityGroupRule> list() throws OperationException;
    SecurityGroupRule get(String id) throws OperationException;
    void delete(String id) throws OperationException;
    SecurityGroupRule create(SecurityGroupRule securityGroupRule) throws OperationException;
    SecurityGroupRule update(SecurityGroupRule securityGroupRule) throws OperationException;
}
