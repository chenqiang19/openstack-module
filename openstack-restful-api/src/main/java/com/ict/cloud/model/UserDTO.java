package com.ict.cloud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
    private static final long serialVersionUID = -1823221445683993783L;
    private String projectId;

    private String domain_id;

    private Boolean enabled;

    private String name;

    private String password;

    private Integer id;

    private String userId;

    private String domainId;

    private String userName;

    private String defaultProjectId;

    private Date passwordExpiresAt;

    private Integer tenantId;
}
