package com.ict.cloud.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SubnetDTO implements Serializable {
    private static final long serialVersionUID = 3517509153942712578L;
    /**  唯一标识ID  **/
    private Integer id;

    /**  项目id  **/
    private String projectId;

    /**  子网ID  **/
    private String subnetId;

    /**  创建时间  **/
    private Date createAt;

    /**  更新时间  **/
    private Date updatedAt;

    /**  DNS域  **/
    private String dnsNameservers;

    /**  网络ID  **/
    private String networkId;

    /**  网关ID  **/
    private String gatewayId;

    /**  子网/掩码  **/
    private String cidr;

    /**  vlan标识符  **/
    private Integer segmentId;

    /**  租户ID  **/
    private Integer tenantId;

    /**  子网名称  **/
    private String subnetName;

    /** 网关 */
    private String networkGateway;
}
