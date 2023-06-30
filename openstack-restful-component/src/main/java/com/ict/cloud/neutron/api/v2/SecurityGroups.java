package com.ict.cloud.neutron.api.v2;

import java.util.List;
import java.util.Objects;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.neutron.api.SecurityGroupManager;
import com.ict.cloud.neutron.model.SecurityGroup;
import org.json.JSONObject;

public class SecurityGroups extends AbstractManager<SecurityGroup> implements SecurityGroupManager {
	private static final String PREFIX = "/v2.0/security-groups";
	private RuleManager ruleManager;
	public SecurityGroups(Authenticated credentical) {
		super(credentical, SecurityGroup.class);
		ruleManager = new RuleManager(credentical);
	}
	@Override
	public List<SecurityGroup> list() throws OperationException {
		return super._list(PREFIX);
	}

	@Override
	public SecurityGroup get(String id) throws OperationException {
		return super._get(PREFIX + "/" + id);
	}

	@Override
	public SecurityGroup create(String name, String description)
			throws OperationException {
		JSONObject object = new JSONObject();
		JSONObject property = new JSONObject();
		property.put("name", name);
		property.put("description", description);
		object.put("security_group", property);
		return super._create(PREFIX, object);
	}

	@Override
	public SecurityGroup create(SecurityGroup securityGroup) throws OperationException {
		return super._create(PREFIX, securityGroup);
	}

	@Override
	public SecurityGroup update(SecurityGroup group)
			throws OperationException {
		Objects.requireNonNull(group);
		Objects.requireNonNull(group.getId());
		return super._update(PREFIX + "/" + group.getId(), group);
	}
	@Override
	public void delete(String id) throws OperationException {
		_delete(PREFIX + "/" + id);
	}
	@Override
	public SecurityGroup.Rule addRule(String id, SecurityGroup.Rule rule) throws OperationException {
		return ruleManager.create(id, rule);
	}
	@Override
	public void removeRule(String ruleId) throws OperationException {
		ruleManager.delete(ruleId);
		
	}
	private class RuleManager extends AbstractManager<SecurityGroup.Rule> {
		private static final String PREFIX = "/v2.0/security-group-rules";
		public RuleManager(Authenticated credentical) {
			super(credentical, SecurityGroup.Rule.class);
		}
		public SecurityGroup.Rule create(String groupId, SecurityGroup.Rule rule) throws OperationException {
			rule.setParentgroupId(groupId);
			return super._create(PREFIX, rule);
		}
		public void delete(String ruleId) throws OperationException {
			_delete(PREFIX + "/" + ruleId);
		}
	}

}
