package com.ict.cloud.resource.service;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.resource.domain.OpenstackProjects;

import java.util.Date;

public interface IOpenstackProjectService {
    Date getTokenExpiredTime();

    void insertOpenstackProject(OpenstackProjects openstackProjects) throws OperationException;

    void deleteProjectByProjectId(String projectId);
}
