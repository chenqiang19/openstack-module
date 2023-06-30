package com.ict.cloud.resource.domain;

import lombok.Data;

/**
                * Openstack模板
                **/
@Data
public class OpenstackFlavors {
    /**  唯一标识ID  **/
    private Integer id;

    /**  模板类型  **/
    private String flavorType;

    /**  模板ID  **/
    private String flavorId;

    /**  模板内存大小  **/
    private Integer flavorRam;

    /**  模板硬盘大小  **/
    private Integer flavorDisk;

    /**  模板名  **/
    private String flavorName;

    /**  模板占用的CPU数  **/
    private Integer flavorVcpu;

    /**  额外的规格  **/
    private String extraSpecs;
}