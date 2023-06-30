package com.ict.cloud.resource.domain;

import lombok.Data;

import java.util.Date;

@Data
public class OpenstackVolumes {
    /** 数据表唯一标识 */
    private Integer id;
    /** 底层用户ID */
    private String userId;
    /** 卷ID */
    private String volumeId;
    /** 卷状态 */
    private String status;
    /** 卷迁移状态 */
    private String migrationStatus;
    /** 卷名称 */
    private String volumeName;
    /** 卷类型 */
    private String volumeType;
    /** 卷复制状态 */
    private String replicationStatus;
    /** 卷大小 */
    private Integer size;
    /** 卷provider ID */
    private String providerId;
    /** 卷类型ID */
    private String volumeTypeId;
    /** 卷创建时间 */
    private Date createAt;
    /** 卷更新时间 */
    private Date updateAt;
    /** 卷描述 */
    private String description;
    /** 卷是否加密*/
    private char encrypted;
    /** 卷所在的可用区 */
    private String availableZone;
    /** 卷快照ID */
    private String snapShotId;

    private char consumesQuota;
    /** 卷组ID */
    private String groupId;
    /** 卷组服务ID，唯一标识 */
    private String serviceUUID;
    /** 是否可启动实例 */
    private Boolean bootable;
    /** 是否可以被共享 */
    private Boolean sharedTargets;
    /** 挂载的实例ID */
    private String serverId;
    /** 挂载的节点ID */
    private String attachmentId;
    /** 挂在的设备 */
    private String device;
}
