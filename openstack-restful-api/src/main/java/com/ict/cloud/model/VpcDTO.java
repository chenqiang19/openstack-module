package com.ict.cloud.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class VpcDTO implements Serializable {
    private static final long serialVersionUID = -6084580988924244587L;
    private String region;
    private String name;
    private String vpcId;
    private String status;
    private Integer subnetNum;
    private String routerName;
    private Integer serverNum;
    private String operate;
    private String segment;
    private SubnetDTO subnetDTO;
    private Integer tenantId;
    private String userName;
    private String subnetId;
}
