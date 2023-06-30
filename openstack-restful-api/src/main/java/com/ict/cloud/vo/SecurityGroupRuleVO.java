package com.ict.cloud.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SecurityGroupRuleVO implements Serializable {
    private static final long serialVersionUID = 8996474486934946182L;

    private String direction;
    private String etherType;
    private String protocol;
    private Integer portRangeMin;
    private Integer portRangeMax;
    private String description;
    private String action;
}
