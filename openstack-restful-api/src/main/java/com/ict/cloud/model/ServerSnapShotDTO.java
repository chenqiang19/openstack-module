package com.ict.cloud.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ServerSnapShotDTO implements Serializable {
    private static final long serialVersionUID = 6225930902805014861L;
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
