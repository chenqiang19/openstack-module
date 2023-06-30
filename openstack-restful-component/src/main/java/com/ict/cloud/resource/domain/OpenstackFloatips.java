package com.ict.cloud.resource.domain;

import lombok.Data;

@Data
public class OpenstackFloatips {
    private Integer id;

    private String floatipId;

    private String status;

    private Integer tenantId;

    private String floatNetworkId;

    private String fixedIpAddress;

    private Integer detailId;

    private String orderId;
}
