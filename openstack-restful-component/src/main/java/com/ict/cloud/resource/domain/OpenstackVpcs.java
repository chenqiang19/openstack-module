package com.ict.cloud.resource.domain;

import lombok.Data;

@Data
public class OpenstackVpcs {
    /** 自增ID */
    private Integer id;
    /** 虚拟私有云名称 */
    private String name;
    /** 虚拟私有云IPv4网段 */
    private String segment;
    /** 虚拟私有云IPv4状态 */
    private String status;
    /** 虚拟私有云IPv4路由表 */
    private String routerName;
    /** 虚拟私有云所在区域 */
    private String region;
    /** 虚拟私有云IPv4扩展字段 */
    private Integer tenantId;
}
