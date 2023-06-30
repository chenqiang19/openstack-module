package com.ict.cloud.resource.domain;

import lombok.Data;

import java.util.List;

@Data
public class OpenstackServerGroups {
    /** 云服务组id */
    private String serverGroupId;
    /** 策略 */
    private String policy;
    /** 名称 */
    private String name;
    /** 底层用户Id */
    private String userId;
    /** 用户Id */
    private Integer tenantId;
    /** 成员列表 */
    private String members;
    /** 成员数量 */
    private Integer instanceNum;
}
