package com.ict.cloud.resource.domain;

import lombok.Data;

/**
                * Openstack安全组
                **/
@Data
public class OpenstackSecurityGroup {
    /**  唯一标识ID  **/
    private Integer id;

    /**  Openstack资源管理ID  **/
    private String templateName;

    /**  安全组ID  **/
    private String securityGroupId;

    /**  安全组名  **/
    private String securityGroupName;

    /**  安全组用户名  **/
    private String securityGroupTenantId;

    /**  用户ID  **/
    private Integer tenantId;
}