package com.ict.cloud.keystone.api;

import com.ict.cloud.keystone.model.Project;
import com.ict.cloud.common.exception.OperationException;

import java.util.List;

public interface ProjectManager {
    List<Project> list() throws OperationException;
    Project create(Project project) throws OperationException;
    Project update(String project_id, Project project) throws OperationException;
    void delete(String project_id) throws OperationException;
    Project get(String project_id) throws OperationException;
}
