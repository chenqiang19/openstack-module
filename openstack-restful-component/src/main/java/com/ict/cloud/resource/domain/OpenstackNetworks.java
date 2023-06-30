package com.ict.cloud.resource.domain;

import java.util.Date;
import lombok.Data;

/**
 * Openstack网络
 **/
@Data
public class OpenstackNetworks {
    /**  唯一标识ID  **/
    private Integer id;

    /**  项目id  **/
    private String projectId;

    /**  网络ID  **/
    private String networkId;

    /**  管理员状态  **/
    private Boolean adminStateUp;

    /**  创建时间  **/
    private Date createAt;

    /**  更新时间  **/
    private Date updatedAt;

    /**  DNS域  **/
    private String dsnDomain;

    /**  网络名  **/
    private String networkName;

    /**  网络类型  **/
    private String networkType;

    /**  是否共享  **/
    private Boolean shared;

    /**  网络状态ACTIVE.DOWN.BUILD,ERROR  **/
    private String status;

    /**  是否为默认网络池  **/
    private Boolean isDefault;

    /**  租户ID  **/
    private Integer tenantId;

    /**  VLAN表示符  **/
    private Integer segmentationId;
}