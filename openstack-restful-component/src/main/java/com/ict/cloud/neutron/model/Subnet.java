package com.ict.cloud.neutron.model;

import com.ict.cloud.common.annotation.Entity;
import com.ict.cloud.common.annotation.Property;
import com.ict.cloud.common.model.AbstractEntity;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


@Entity("subnet")
public class Subnet extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    @Property("project_id")
    private String projectId;
    @Property("updated_at")
    private String updatedAt;
    @Property("created_at")
    private String createdAt;
    @Property
    private Boolean shared;
    @Property("is_default")
    private Boolean isDefault;
    @Property("network_id")
    private String networkId;
    @Property("enable_dhcp")
    private Boolean enableDhcp;
    @Property("gateway_ip")
    private String gatewayIp;
    @Property
    private String cidr;
    @Property("segment_id")
    private String segmentId;
    @Property("dns_nameservers")
    private List<String> dnsNameservers;
    @Property("ip_version")
    private Integer ipVersion;

    public Subnet(){
        super();
    }
    public Subnet(JSONObject entity) {
        super(entity);
    }

    public Subnet(Object obj) {
        super(obj);
    }

    public Subnet(String s) {
        super(s);
    }

    public Subnet(JSONObject header, JSONObject body) {
        super(body);
        JSONObject subnet = body.getJSONObject("subnet");
        this.id = subnet.getString("id");
        this.networkId = subnet.getString("network_id");
        this.enableDhcp = subnet.getBoolean("enable_dhcp");
        this.gatewayIp = subnet.getString("gateway_ip");
        JSONArray dnsNames = subnet.getJSONArray("dns_nameservers");
        if (dnsNames != null) {
            this.dnsNameservers = new ArrayList<>();
            for (int i=0; i<dnsNames.length(); ++i) {
                this.dnsNameservers.add(dnsNames.getString(i));
            }
        }

        this.cidr = subnet.getString("cidr");
        this.name = subnet.getString("name");
        this.createdAt = subnet.getString("created_at");
        this.updatedAt = subnet.getString("updated_at");
        this.projectId = subnet.getString("project_id");
        this.ipVersion = subnet.getInt("ip_version");
    }

    public String getUpdated() {
        return updatedAt;
    }

    public String getCreated() {
        return createdAt;
    }

    public String getProjectId() { return this.projectId; }
    public void setProjectId(String projectId) { this.projectId = projectId; }

    public Boolean getIsShared() { return this.shared; }
    public void setIsShared(Boolean isShared) { this.shared = isShared; }

    public Boolean getIsDefault() { return this.isDefault; }
    public void setIsDefault(Boolean isDefault) { this.isDefault = isDefault; }

    public String getNetworkId() { return this.networkId; }
    public void setNetworkId(String network_id) { this.networkId = network_id; }

    public Boolean getEnableDhcp() { return this.enableDhcp; }
    public void setEnableDhcp(Boolean enable_dhcp) { this.enableDhcp = enable_dhcp; }

    public String getGatewayIp() { return this.gatewayIp; }
    public void setGatewayIp(String gateway_ip) { this.gatewayIp = gateway_ip; }

    public String getCidr() { return this.cidr; }
    public void setCidr(String cidr) { this.cidr = cidr; }

    public String getSegmentId() { return this.segmentId; }
    public void setSegmentId(String segment_id) { this.segmentId = segment_id; }

    public List<String> getDnsNameservers() { return this.dnsNameservers; }
    public void setDnsNameservers(List<String> dnsNameservers) { this.dnsNameservers = dnsNameservers; }

    public Integer getIpVersion() { return this.ipVersion; }
    public void setIpvVersion(Integer ip_version) { this.ipVersion = ip_version; }

    @Override
    public boolean isValid() {
        return false;
    }
}
