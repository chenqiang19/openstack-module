package com.ict.cloud.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class FloatIpDTO implements Serializable {
    private static final long serialVersionUID = 3431285098826659418L;
    private String router_id;
    private String status;
    private String dns_name;
    private String port_details;
    private String project_id;
    private String created_at;
    private String updated_at;
    private String floating_network_id;
    private String fixed_ip_address;
    private String floating_ip_address;
    private String port_id;
    private String id;
    private String tags;
    private String qos_network_policy_id;
    private String qos_policy_id;
    private String description;
}
