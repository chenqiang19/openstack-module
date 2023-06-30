package com.ict.cloud.resource.domain;

import java.util.Date;
import lombok.Data;

/**
                * Openstack快照
                **/
@Data
public class OpenstackSnapshots {
    /**  唯一标识ID  **/
    private Integer id;

    /**  Openstack管理的机器ID  **/
    private Integer parentId;

    /**  快照ID  **/
    private String snapshotsId;

    /**  快照名  **/
    private String snapshotsName;

    /**  快照状态  **/
    private String snapshotsStatus;

    /**  快照关联的卷ID  **/
    private String snapshotsVolumeId;

    /**  创建时间  **/
    private Date createAt;

    /**  更新时间  **/
    private Date updatedAt;

    /**  用户密码  **/
    private String metadataAdminPass;

    /**  SnapShot大小  **/
    private Integer snapshotSize;

    /**  快照关联的项目名  **/
    private String snapshotProjectId;

    /**  扩展字段  **/
    private String extend;
}