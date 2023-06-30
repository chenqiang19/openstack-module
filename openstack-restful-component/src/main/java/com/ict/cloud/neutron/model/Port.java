package com.ict.cloud.neutron.model;

import com.ict.cloud.common.annotation.Entity;
import com.ict.cloud.common.annotation.Property;
import com.ict.cloud.common.model.AbstractEntity;
import com.ict.cloud.tools.JSONConverter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

@Entity("port")
public class Port extends AbstractEntity {
    private static final long serialVersionUID = 4534783245606627479L;
    @Property("admin_state_up")
    private Boolean adminStateUp;
    @Property("allowed_address_pairs")
    private List<String> allowedAddressPairs;
    @Property("binding:host_id")
    private String hostId;
    @Property("binding:profile")
    private JSONObject profile;
    @Property("binding:vif_type")
    private String vifType;
    @Property("create_at")
    private String createdAt;
    @Property("data_plane_status")
    private String dataPlaneStatus;
    @Property
    private String description;
    @Property
    private String deviceId;
    @Property
    private String deviceOwner;
    @Property("dns_assignment")
    private JSONObject dnsAssignment;
    @Property
    private String dnsDomain;
    @Property
    private String dnsName;
    @Property
    private List<FloatIps> fixedIps;
    @Property
    private String ipAllocation;
    @Property
    private String macAddress;
    @Property
    private String networkId;
    @Property
    private String status;
    @Property
    private String projectId;

    public Port() {
        super();
    }

    public Port(JSONObject entity) {
        super(entity);
        this.projectId = entity.getString("project_id");
        this.deviceId = entity.getString("device_id");
        this.networkId = entity.getString("network_id");
        this.status = entity.getString("status");
        JSONArray fixedIps = entity.getJSONArray("fixed_ips");
        this.fixedIps = new ArrayList<>();
        for (int i=0; i<fixedIps.length(); ++i) {
            JSONObject floatIp = fixedIps.getJSONObject(i);
            FloatIps floatIps = new FloatIps(floatIp.getString("subnet_id"), floatIp.getString("ip_address"));
            this.fixedIps.add(floatIps);
        }
        this.adminStateUp = entity.getBoolean("admin_state_up");
    }

    public Port(Object obj) {
        super(obj);
    }

    public Port(String s) {
        super(s);
    }

    public Port(JSONObject header, JSONObject body) {
        JSONObject port = body.getJSONObject("port");
        this.id = port.getString("id");
        this.status = port.getString("status");
    }

    public String getProjectId() { return this.projectId; }

    public String getNetworkId() { return this.networkId; }

    @Override
    public boolean isValid() {
        return false;
    }

    public static class FloatIps {
        private String subnetId;
        private String ipAddress;

        public FloatIps(String subnetId, String ipAddress) {
            this.subnetId = subnetId;
            this.ipAddress = ipAddress;
        }
    }
}
