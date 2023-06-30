package com.ict.cloud.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class SecurityGroupDTO implements Serializable {
    private static final long serialVersionUID = -172906494448878533L;
    /**  唯一标识ID  **/
    private Integer id;

    /**  Openstack资源管理ID  **/
    private Integer parentId;

    /**  安全组ID  **/
    private String securityGroupId;

    /**  安全组名  **/
    private String securityGroupName;

    /**  安全组用户名  **/
    private String securityGroupTenantId;

    /**  用户ID  **/
    private Integer tenantId;
}
