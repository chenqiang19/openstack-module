package com.ict.cloud.resource.domain;

import lombok.Data;

/**
 * 安全组规则模板
 **/
@Data
public class OpenstackSecurityGroupRules {
    /**  唯一标识ID  **/
    private Integer id;

    /**  安全组规则规则  **/
    private String direction;

    /**  安全组规则协议  **/
    private String protocol;

    /**  安全组规则以太网类型  **/
    private String etherType;

    /**  安全组ID  **/
    private String securityGroupId;

    /**  安全组规则ID  **/
    private String securityGroupRuleId;

    /**  安全组描述  **/
    private String description;

    /**  用户ID  **/
    private Integer tenantId;

    /**  端口最小值  **/
    private Integer portRangeMin;

    /**  端口最大值  **/
    private Integer portRangeMax;

    /**  动作  **/
    private String action;
}
