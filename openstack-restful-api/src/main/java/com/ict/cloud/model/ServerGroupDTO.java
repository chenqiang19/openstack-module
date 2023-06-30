package com.ict.cloud.model;

import lombok.Data;

@Data
public class ServerGroupDTO {
    private String name;
    private String policy;
    private Integer instanceNum;
    private String members;
    private Integer tenantId;
    private String serverGroupId;
}
