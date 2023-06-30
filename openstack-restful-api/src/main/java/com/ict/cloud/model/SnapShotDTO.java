package com.ict.cloud.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class SnapShotDTO implements Serializable {
    private static final long serialVersionUID = -6426962720035463180L;
    private String name;
    private String description;
    private String volumeId;
    private String uuid;
    private Integer bootIndex;
    private String volumeSize;
    private String sourceType;
    private String destinationType;
    private Boolean deleteOnTermination;
    private String deviceType;
    private String diskBus;
    private Boolean noDevice;
}
