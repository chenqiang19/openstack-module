package com.ict.cloud.neutron.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ict.cloud.common.annotation.Entity;
import com.ict.cloud.common.annotation.Property;
import com.ict.cloud.common.model.AbstractEntity;
import com.ict.cloud.nova.model.Protocol;
import org.json.JSONArray;
import org.json.JSONObject;

@Entity("security_group")
public class SecurityGroup extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7144841024631780777L;
	@Property
	private List<Rule> rules;
	@Property("tenant_id")
	private String tenantId;
	@Property
	private String description;
	
	public SecurityGroup() {
		super();
	}
	public SecurityGroup(JSONObject secGroup) {
		super(secGroup);
		if (secGroup.has("rules")) {
			JSONArray s = secGroup.optJSONArray("rules");
			if (s != null) {
				for (int i = 0; i < s.length(); ++i) {
					Rule rule = new Rule(s.get(i));
					rules.add(rule);
				}
			}
		}
	}
	public SecurityGroup(Object obj) {
		this(new JSONObject(obj.toString()));
	}
	public SecurityGroup(String s) {
		this(new JSONObject(s));
	}
	public SecurityGroup(JSONObject header, JSONObject body) {
		JSONObject securityGroup = body.getJSONObject("security_group");
		this.id = securityGroup.getString("id");
		this.tenantId = securityGroup.getString("tenant_id");
		this.name = securityGroup.getString("name");
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Rule> getRules() {
		if (rules == null)
			rules = new ArrayList<>();
		return Collections.unmodifiableList(rules);
	}
	public String getTenantId() {
		return tenantId;
	}
	@Override
	public String getId() { return id; }
	@Override
	public void setName(String name) { this.name = name; }
	@Override
	public boolean isValid() {
		return true;
	}
	@Entity("security_group_rule")
	public static class Rule extends AbstractEntity {
		/**
		 * 
		 */
		private static final long serialVersionUID = 3098829954553030067L;
		@Property("from_port")
		private int fromPort;
		@Property("to_port")
		private int toPort;
		@Property("ip_protocol")
		private Protocol protocol;
		@Property("parent_group_id")
		private int parentgroupId;
		@Property
		private String id;
		@Property("ip_range")
		private String ip;
		@Property("group_id")
		private String groupId;
		public Rule() {
			super();
		}
		public Rule(JSONObject rule) {
			super(rule);
			if (rule.has("ip_range")) {
				if(rule.getJSONObject("ip_range")!=null) {
					JSONObject ip_range = rule.getJSONObject("ip_range");
					//.getJSONObject("ip_range").getString();
					if(ip_range.has("cidr")) {
						this.ip = ip_range.getString("cidr");
					} else { this.ip = null; }
				}
			}
			if (rule.has("id")) {
				this.id = rule.getString("id");
			}
		}
		public Rule(Object rule) {
			this(new JSONObject(rule.toString()));
		}
		public Rule(String s) {
			this(new JSONObject(s));
		}
		@Override
		public boolean isValid() {
			if (fromPort < -1 || fromPort > 65535)
				return false;
			if (toPort < -1 || toPort > 65535) {
				return false;
			}
			if (protocol.equals("tcp") || protocol.equals("udp") || protocol.equals("icmp")) {
				return true;
			}
			return false;
		}
		
		public int getFromPort() {
			return fromPort;
		}
		public void setFromPort(int fromPort) {
			this.fromPort = fromPort;
		}
		public int getToPort() {
			return toPort;
		}
		public void setToPort(int toPort) {
			this.toPort = toPort;
		}
		public Protocol getProtocol() {
			return protocol;
		}
		public void setProtocol(Protocol protocol) {
			this.protocol = protocol;
		}
		public int getParentgroupId() {
			return parentgroupId;
		}
		public void setParentgroupId(int parentgroupId) {
			this.parentgroupId = parentgroupId;
		}
		public void setParentgroupId(String parentgroupId) {
			this.parentgroupId = new Integer(parentgroupId);
		}
		public String getIp() {
			return ip;
		}
		public void setIp(String ip) {
			this.ip = ip;
		}
		public String getGroupId() {
			return groupId;
		}
		public void setGroupId(String groupId) {
			this.groupId = groupId;
		}
		@Override
		public String getId() {
			return new Integer(id).toString();
		}
		@Override
		public JSONObject toJSONObject() {
			JSONObject json = new JSONObject();
			json.put("from_port", fromPort);
			json.put("ip_protocol", protocol);
			json.put("to_port", toPort);
			json.put("parent_group_id", parentgroupId);
			json.put("cidr", ip);
			json.put("id", id);
			if (groupId != null) {
				json.put("group_id", groupId);
			} else {
				json.put("group_id", JSONObject.NULL);
			}
			JSONObject rule = new JSONObject();
			rule.put("security_group_rule", json);
			return rule;
		}
	}

}
