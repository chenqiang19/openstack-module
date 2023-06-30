package com.ict.cloud.neutron.model;

import com.ict.cloud.common.annotation.Entity;
import com.ict.cloud.common.annotation.Property;
import com.ict.cloud.common.model.AbstractEntity;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

@Entity("network")
public class Network extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    @Property
    private String project_id;
    @Property
    private String updated_at;
    @Property
    private String created_at;
    @Property
    private Boolean shared;
    @Property("provider:network_type")
    private String network_type;
    @Property("provider:segmentation_id")
    private Integer segment_id;
    @Property
    private Integer mtu;
    @Property
    private String status;
    @Property
    private Boolean admin_state_up;
    @Property
    private String dsn_domain;
    @Property
    private Boolean is_default;
    @Property
    private List<String> availability_zone_hints;
    @Property
    private Boolean port_security_enabled;
    @Property("provider:physical_network")
    private String physical_network;
    @Property
    private List<String> subnets;


    public Network() {
        super();
    }

    public Network(JSONObject entity) {
        super(entity);
    }

    public Network(Object obj) {
        super(obj);
    }

    public Network(String s) {
        super(s);
    }

    public Network(JSONObject header, JSONObject body) {
        JSONObject network = body.getJSONObject("network");
        this.id = network.getString("id");
        //this.network_type = network.getString("provider:network_type");
        this.admin_state_up = network.getBoolean("admin_state_up");
        this.shared = network.getBoolean("shared");
        //this.dsn_domain = network.getString("dsn_domain");
        this.is_default = network.getBoolean("is_default");
        this.status = network.getString("status");
        this.name = network.getString("name");
        this.created_at = network.getString("created_at");
        this.updated_at = network.getString("updated_at");
        this.project_id = network.getString("project_id");
//        if (network.has("subnets")) {
//            this.subnets = network.getJSONArray("subnets");
//        }
        //this.segment_id = network.getInt("provider:segmentation_id");
    }

    @Override
    public boolean isValid() {
        return true;
    }

    public String getUpdated() {
        return updated_at;
    }

    public String getCreated() {
        return created_at;
    }

    public String getProjectId() { return this.project_id; }
    public void setProjectId(String projectId) { this.project_id = projectId; }

    public String getNetworkType() { return this.network_type; }
    public void setNetworkType(String networkType) { this.network_type = networkType; }

    public String getDsnDomain() { return this.dsn_domain; }
    public void setDsnDomain(String dsnDomain) { this.dsn_domain = dsnDomain; }

    public String getStatus() { return this.status; }
    public void setStatus(String status) { this.status = status; }

    public Boolean getAdminStateUp() { return this.admin_state_up; }
    public void setAdminStateUp(Boolean adminStateUp) { this.admin_state_up = adminStateUp; }

    public Boolean getIsShared() { return this.shared; }
    public void setIsShared(Boolean isShared) { this.shared = isShared; }

    public Boolean getIsDefault() { return this.is_default; }
    public void setIsDefault(Boolean isDefault) { this.is_default = isDefault; }

    public List<String> getAvailabilityZoneHints() { return this.availability_zone_hints; }
    public void setAvailabilityZoneHints(List<String> availability_zone_hints) { this.availability_zone_hints = availability_zone_hints; }

    public Boolean getPortSecurityEnabled() { return this.port_security_enabled; }
    public void setPortSecurityEnabled(Boolean port_security_enabled) { this.port_security_enabled = port_security_enabled; }

    public String getPhysicalNetwork() { return this.physical_network; }
    public void setPhysicalNetwork(String physical_network) { this.physical_network = physical_network; }

    public Integer getMtu() { return this.mtu; }
    public void setMtu(Integer mtu) { this.mtu = mtu; }

    public Integer getSegmentId() { return this.segment_id; }
    public void setSegmentId(Integer segment_id) { this.segment_id = segment_id; }

    public List<String> getSubnets() { return this.subnets; }
}
