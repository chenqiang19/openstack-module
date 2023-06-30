package com.ict.cloud.neutron.api;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.neutron.model.SecurityGroup;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface SecurityGroupManager {
    List<SecurityGroup> list() throws OperationException;
    SecurityGroup get(String id) throws OperationException;
    SecurityGroup create(String name, String description) throws OperationException;
    SecurityGroup create(SecurityGroup securityGroup) throws OperationException;
    SecurityGroup update(SecurityGroup securityGroup) throws OperationException;
    void delete(String id) throws OperationException;
    /**
     * Create a security group rule
     * @param id the id of security group
     * @param rule the rule to add.
     * @return rule.
     * @throws OperationException
     */
    SecurityGroup.Rule addRule(String id, SecurityGroup.Rule rule) throws OperationException;
    /**
     * remove a security group rule
     * @param ruleId The id of rule to remove.
     * @throws OperationException
     */
    void removeRule(String ruleId) throws OperationException;
}
