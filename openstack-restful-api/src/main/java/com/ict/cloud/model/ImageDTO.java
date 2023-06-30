package com.ict.cloud.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ImageDTO implements Serializable {
    private static final long serialVersionUID = -367946498453781365L;
    public String imageId;
    public String imageName;
    public String imageVersion;
    public String imageStatus;
    /**  唯一标识ID  **/
    private Integer id;

    /**  Openstack资源管理ID  **/
    private Integer parentId;

    /**  镜像可见性  **/
    private String imageVisibility;

    /**  创建时间  **/
    private Date createAt;

    /**  更新时间  **/
    private Date updatedAt;

    /**  镜像架构  **/
    private String imageArch;

    /**  镜像类型  **/
    private String imageType;
}
