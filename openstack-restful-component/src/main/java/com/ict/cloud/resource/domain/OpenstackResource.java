package com.ict.cloud.resource.domain;

import lombok.Data;

/**
                * Openstack资源管理
                **/
@Data
public class OpenstackResource {
    /**  唯一标识ID  **/
    private Integer id;

    /**  实例机ID  **/
    private Integer instanceId;

    /**  状态  **/
    private String status;

    /**  已经使用CPU数  **/
    private Integer vcpusUsed;

    /**  监视器类型  **/
    private String hypervisorType;

    /**  已使用的本地硬盘数  **/
    private Integer localGbUsed;

    /**  CPU总数  **/
    private Integer vcpus;

    /**  监视器名  **/
    private String hypervisorHostname;

    /**  已使用的内存数  **/
    private Integer memoryMbUsed;

    /**  内存总大小  **/
    private Integer memoryMb;

    /**  当前工作量  **/
    private Integer currentWorkload;

    /**  机器状态  **/
    private String state;

    /**  机器IP  **/
    private String hostIp;

    /**  启动的实例数  **/
    private Integer runningVms;

    /**  可用硬盘空间  **/
    private Integer freeDiskGb;

    /**  监视器版本号  **/
    private String hypervisorVersion;

    /**  硬盘可用量  **/
    private Integer diskAvailableLeast;

    /**  本地硬盘大小  **/
    private Integer localGb;

    /**  可用内存大小  **/
    private Integer freeRamMb;
}