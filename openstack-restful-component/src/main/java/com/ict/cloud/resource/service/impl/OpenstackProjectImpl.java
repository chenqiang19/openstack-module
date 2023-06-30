package com.ict.cloud.resource.service.impl;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.resource.domain.OpenstackProjects;
import com.ict.cloud.resource.domain.OpenstackProjectsCriteria;
import com.ict.cloud.resource.mapper.OpenstackProjectsMapper;
import com.ict.cloud.resource.service.IOpenstackProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("openstack_projects")
public class OpenstackProjectImpl implements IOpenstackProjectService {
    @Autowired
    private OpenstackProjectsMapper openstackProjectMapper;
    //一期因为使用的一个admin账号，所以这里先不需要判断
    public Date getTokenExpiredTime(){
        OpenstackProjectsCriteria example = new OpenstackProjectsCriteria();
        OpenstackProjectsCriteria.Criteria criteria = example.createCriteria();
        //criteria.andExpiresAtIsNotNull();
        //return openstackProjectMapper.selectOneByExample(example).getExpiresAt();
        return null;
    }

    @Override
    public void insertOpenstackProject(OpenstackProjects openstackProjects) throws OperationException {
        int answer = openstackProjectMapper.insert(openstackProjects);
        if(answer < 0) {
            throw new OperationException("insertOpenstackProject failed！");
        }
    }

    @Override
    public void deleteProjectByProjectId(String projectId){
        OpenstackProjectsCriteria example = new OpenstackProjectsCriteria();
        OpenstackProjectsCriteria.Criteria criteria = example.createCriteria();
        criteria.andProjectIdEqualTo(projectId);
        openstackProjectMapper.deleteByExample(example);
    }
}
