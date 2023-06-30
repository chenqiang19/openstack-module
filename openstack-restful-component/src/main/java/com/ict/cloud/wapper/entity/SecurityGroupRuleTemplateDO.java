package com.ict.cloud.wapper.entity;

import lombok.Data;

@Data
public class SecurityGroupRuleTemplateDO {
    private Integer templateId;
    private String name;
    private String context;
    private String description;
    private Integer status;
}
