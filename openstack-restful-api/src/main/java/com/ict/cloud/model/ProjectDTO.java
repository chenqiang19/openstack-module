package com.ict.cloud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO implements Serializable {
    private static final long serialVersionUID = -462665159607244537L;
    private String name;
    private Boolean isDomain;
    private String description;
    private String domainId;
    private Boolean enabled;
    private String parentId;
    private Integer id;
    private String projectId;
    private String descript;
}
