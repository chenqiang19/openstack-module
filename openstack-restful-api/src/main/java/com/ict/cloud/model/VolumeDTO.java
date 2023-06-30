package com.ict.cloud.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class VolumeDTO implements Serializable {
    private static final long serialVersionUID = -6080229487102961089L;
    private String projectId;
    private String volumeId;
    private Integer newSize;
    private String name;
    private String volumeType;
    private String availabilityZone;
    private String description;
    private Integer size;
    private Integer id;
    private String userId;
    private String status;
    private String migrationStatus;
    private String volumeName;
    private String replicationStatus;
    private String providerId;
    private String volumeTypeId;
    private Date createAt;
    private Date updateAt;
    private char encrypted;
    private String availableZone;
    private String snapShotId;
    private char consumesQuota;
    private String groupId;
    private String serviceUUID;
    private Boolean bootable;
    private Boolean sharedTargets;
    private String serverId;
    private String attachmentId;
    private String device;
    private String imageRef;
}
