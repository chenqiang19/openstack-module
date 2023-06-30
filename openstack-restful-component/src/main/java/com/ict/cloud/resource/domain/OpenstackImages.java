package com.ict.cloud.resource.domain;

import java.util.Date;
import lombok.Data;

/**
                * Openstack镜像
                **/
@Data
public class OpenstackImages {
    /**  唯一标识ID  **/
    private Integer id;

    /**  镜像ID  **/
    private String imageId;

    /**  镜像名  **/
    private String imageName;

    /**  镜像状态  **/
    private String imageStatus;

    /**  镜像可见性  **/
    private String imageVisibility;

    /**  创建时间  **/
    private Date createAt;

    /**  更新时间  **/
    private Date updatedAt;

    /**  镜像版本  **/
    private String imageVersion;

    /**  镜像架构  **/
    private String imageArch;

    /**  镜像类型  **/
    private String imageType;

    /**  镜像所有者  **/
    private String osAdminUser;

    /**  硬盘格式  **/
    private String diskFormat;

    /**  大小  **/
    private String imageSize;

    /**  是否受保护  **/
    private Boolean protectedFlag;
}