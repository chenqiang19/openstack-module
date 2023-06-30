package com.ict.cloud.neutron.model;

import com.ict.cloud.common.annotation.Entity;
import com.ict.cloud.common.annotation.Property;
import com.ict.cloud.common.model.AbstractEntity;
import lombok.Data;
import org.json.JSONObject;

@Data
@Entity("floatingip")
public class FloatIp extends AbstractEntity {
    private static final long serialVersionUID= 1L;

    @Property
    private String router_id;
    @Property
    private String status;
    @Property
    private String dns_name;
    @Property
    private String port_details;
    @Property
    private String project_id;
    @Property
    private String created_at;
    @Property
    private String updated_at;
    @Property
    private String floating_network_id;
    @Property
    private String fixed_ip_address;
    @Property
    private String floating_ip_address;
    @Property
    private String port_id;
    @Property
    private String id;
    @Property
    private String tags;
    @Property
    private String qos_network_policy_id;
    @Property
    private String qos_policy_id;
    @Property
    private String description;

    public FloatIp() {
        super();
    }

    public FloatIp(JSONObject entity) {
        super(entity);
    }

    public FloatIp(Object obj) {
        super(obj);
    }

    public FloatIp(String s) {
        super(s);
    }

    public FloatIp(JSONObject header, JSONObject body) {
        JSONObject floatingip = body.getJSONObject("floatingip");
        this.id = floatingip.getString("id");
        this.floating_network_id = floatingip.getString("floating_network_id");
        this.floating_ip_address = floatingip.getString("floating_ip_address");
        this.status = floatingip.getString("status");
    }

    @Override
    public boolean isValid() {
        return false;
    }
}
