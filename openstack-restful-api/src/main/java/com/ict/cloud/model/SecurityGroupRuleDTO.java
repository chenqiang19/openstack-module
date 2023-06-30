package com.ict.cloud.model;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;

import java.io.Serializable;

@Data
public class SecurityGroupRuleDTO implements Serializable {
    private static final long serialVersionUID = 9030326215770051655L;
    private String id;
    private String project_id;
    private String remote_group_id;
    private String direction;
    private String protocol;
    private String ethertype;
    private JSONArray routes;
    private Integer port_range_max;
    private String security_group_id;
    private Integer port_range_min;
    private String remote_ip_prefix;
    private String updated_at;
    private String created_at;
    private Integer revision_number;
}
