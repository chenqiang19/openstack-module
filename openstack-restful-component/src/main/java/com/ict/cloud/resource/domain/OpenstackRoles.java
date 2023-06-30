package com.ict.cloud.resource.domain;

import lombok.Data;

@Data
public class OpenstackRoles {
    private Integer id;

    private String roleId;

    private String domainId;

    private String roleName;

    private String description;

    private String extend;
}