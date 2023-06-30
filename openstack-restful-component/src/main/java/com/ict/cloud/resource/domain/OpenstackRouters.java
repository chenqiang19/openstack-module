package com.ict.cloud.resource.domain;

import lombok.Data;

import java.util.Date;

@Data
public class OpenstackRouters {
    /**  唯一标识ID  **/
    private Integer id;

    /**  项目id  **/
    private String projectId;

    /**  路由ID  **/
    private String routerId;

    /**  路由名称  **/
    private String routerName;

    /**  创建时间  **/
    private Date createAt;

    /**  更新时间  **/
    private Date updatedAt;

    /**  管理状态  **/
    private Boolean adminStateUp;

    /**  额外的网关信息  **/
    private String externalGatewayInfo;

    /**  规格id  **/
    private String flavorId;

    /**  状态  **/
    private String status;

    /**  高可用路由标识  **/
    private Boolean ha;

    /**  是否共享  **/
    private String availalityZones;

    /**  是否为默认网络池  **/
    private Boolean isDefault;

    /**  租户ID  **/
    private Integer tenantId;
}
