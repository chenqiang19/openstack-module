package com.ict.cloud.resource.domain;

import java.util.Date;
import lombok.Data;

@Data
public class OpenstackUsers {
    private Integer id;

    private String userId;

    private String domainId;

    private Boolean enabled;

    private String userName;

    private String password;

    private String defaultProjectId;

    private Date passwordExpiresAt;

    private Integer tenantId;
}