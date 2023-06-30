package com.ict.cloud.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class HypervisorVO implements Serializable {

    private String hostName;

    private String type;

    private String status;

    private String state;

    private Boolean valid;

    private String hostIp;

    private String region;

}
