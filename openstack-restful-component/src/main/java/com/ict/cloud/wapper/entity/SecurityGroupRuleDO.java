package com.ict.cloud.wapper.entity;

import lombok.Data;

@Data
public class SecurityGroupRuleDO {
    private String securityGroupId;

    private String direction;

    private String ethertype;

    private String protocal;

    private Integer portRangeMin;

    private Integer portRangeMax;

    public SecurityGroupRuleDO(String groupId, String direction, String ethertype, String protocal,
                               Integer portRangeMax, Integer portRangeMin) {
        this.securityGroupId = groupId;
        this.direction = direction;
        this.ethertype = ethertype;
        this.protocal = protocal;
        if (portRangeMax != null) { this.portRangeMax = portRangeMax; }
        if (portRangeMin != null) { this.portRangeMin = portRangeMin; }
    }
}
