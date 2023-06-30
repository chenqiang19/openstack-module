package com.ict.cloud.resource.domain;

import lombok.Data;

@Data
public class OpenstackProjects {
    private Integer id;

    private String projectId;

    private String descript;

    private Boolean isDomain;

    private String domainId;

    private Boolean enabled;

    private String projectName;

    private String parentId;

    private String extend;
}