package com.ict.cloud.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class AvailabilityZoneVO implements Serializable {
    private static final long serialVersionUID = -1576789623991144641L;

    private Boolean status;
    private String zoneName;
}
