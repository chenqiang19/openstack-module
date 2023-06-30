package com.ict.cloud.keystone.api;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.keystone.model.Project;
import com.ict.cloud.common.exception.OperationException;

import java.util.List;

public class Projects extends AbstractManager<Project> implements ProjectManager{
    private static final String PREFIX = "/v3/projects";
    public Projects(Authenticated credentical) {
        super(credentical, Project.class);
    }
    @Override
    public List<Project> list() throws OperationException{
        return super._list(PREFIX);
    }
    @Override
    public Project create(Project project) throws OperationException{
        return _create(PREFIX, project);
    }
    @Override
    public Project update(String project_id, Project project) throws OperationException{
        return _update(PREFIX + "/" + project_id, project);
    }
    @Override
    public void delete(String project_id) throws OperationException{
        super._delete(PREFIX + "/" + project_id);
    }
    @Override
    public Project get(String project_id) throws OperationException{
        return super._get(PREFIX + "/" + project_id);
    }
}
