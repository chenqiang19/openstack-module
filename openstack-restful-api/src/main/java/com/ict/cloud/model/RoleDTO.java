package com.ict.cloud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO implements Serializable {
    private static final long serialVersionUID = -2787617459658638268L;
    private String name;
    private String domain_id;
    private String description;
    private Integer id;
    private String roleId;
    private String domainId;
    private String roleName;
}
