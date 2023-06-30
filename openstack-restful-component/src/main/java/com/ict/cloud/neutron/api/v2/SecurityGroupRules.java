package com.ict.cloud.neutron.api.v2;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.neutron.api.SecurityGroupRuleManager;
import com.ict.cloud.neutron.model.SecurityGroupRule;

import java.util.List;

public class SecurityGroupRules extends AbstractManager<SecurityGroupRule> implements SecurityGroupRuleManager {
    private static final String PREFIX = "/v2.0/security-group-rules";
    public SecurityGroupRules(Authenticated credentical) {
        super(credentical, SecurityGroupRule.class);
    }
    @Override
    public List<SecurityGroupRule> list() throws OperationException {
        return super._list(PREFIX);
    }
    @Override
    public SecurityGroupRule create(SecurityGroupRule securityGroupRule) throws OperationException {
        return super._create(PREFIX , securityGroupRule.toJSONObject(false));
    }
    @Override
    public void delete(String id) throws OperationException {
        super._delete(PREFIX + '/' + id);
    }
    @Override
    public SecurityGroupRule get(String id) throws OperationException {
        return super._get(PREFIX + "/" + id);
    }

    @Override
    public SecurityGroupRule update(SecurityGroupRule securityGroupRule) throws OperationException {
        SecurityGroupRule t = new SecurityGroupRule();
        t.setName(securityGroupRule.getName());
        //t.setExternal(network.isExternal());
        //t.setShared(network.isShared());
        //t.setUp(network.isUp());
        return super._update(PREFIX, t.toJSONObject(false));
    }
}
