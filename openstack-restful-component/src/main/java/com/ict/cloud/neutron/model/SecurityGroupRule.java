package com.ict.cloud.neutron.model;

import com.ict.cloud.common.annotation.Entity;
import com.ict.cloud.common.annotation.Property;
import com.ict.cloud.common.model.AbstractEntity;
import lombok.Data;
import org.json.JSONArray;
import org.json.JSONObject;

@Entity("security_group_rule")
@Data
public class SecurityGroupRule extends AbstractEntity {
    public static final long serialVersionUID = 1L;

    @Property
    private String id;
    @Property("project_id")
    private String projectId;
    @Property("remote_group_id")
    private String remoteGroupId;
    @Property
    private String direction;
    @Property
    private String protocol;
    @Property
    private String ethertype;
    @Property
    private JSONArray routes;
    @Property("port_range_max")
    private Integer portRangeMax;
    @Property("security_group_id")
    private String securityGroupId;
    @Property("port_range_min")
    private Integer portRangeMin;
    @Property("remote_ip_prefix")
    private String remoteIpPrefix;
    @Property("updated_at")
    private String updatedAt;
    @Property("create_at")
    private String createdAt;
    @Property("revision_number")
    private Integer revisionNumber;

    public SecurityGroupRule() {
        super();
    }

    public SecurityGroupRule(JSONObject entity) {
        super(entity);
    }

    @Override
    public boolean isValid() {
        return false;
    }

    public SecurityGroupRule(JSONObject header, JSONObject body) {
        JSONObject securityGroupRule = body.getJSONObject("security_group_rule");
        this.id = securityGroupRule.getString("id");
        this.direction = securityGroupRule.getString("direction");
        this.ethertype = securityGroupRule.getString("ethertype");
        this.createdAt = securityGroupRule.getString("created_at");
        this.updatedAt = securityGroupRule.getString("updated_at");
        this.projectId = securityGroupRule.getString("project_id");
        this.protocol = securityGroupRule.getString("protocol");
        this.securityGroupId = securityGroupRule.getString("security_group_id");
        if (securityGroupRule.has("port_range_max")) {
            String rangeMax = securityGroupRule.optString("port_range_max", null);
            if (rangeMax != null) {
                this.portRangeMax = Integer.parseInt(rangeMax);
            }
        }
        if (securityGroupRule.has("port_range_min")) {
            String rangeMin = securityGroupRule.optString("port_range_min", null);
            if (rangeMin != null) {
                this.portRangeMin = Integer.parseInt(rangeMin);
            }
        }
    }

    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        json.put("direction", this.direction);
        json.put("ethertype", this.ethertype);
        json.put("protocol", this.protocol);
        json.put("security_group_id", this.securityGroupId);
        if(this.portRangeMax!=null) {
            json.put("port_range_max", this.portRangeMax);
        }
        if(this.portRangeMin!=null) {
            json.put("port_range_min", this.portRangeMin);
        }
        return json.toString();
    }
}
