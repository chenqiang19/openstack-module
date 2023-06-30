package com.ict.cloud.resource.service.impl;


import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.resource.domain.OpenstackRoles;
import com.ict.cloud.resource.mapper.OpenstackRolesMapper;
import com.ict.cloud.resource.service.IOpenstackRolesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("openstack_roles")
public class OpenstackRolesImpl implements IOpenstackRolesService {
    @Resource
    private OpenstackRolesMapper openstackRolesMapper;

    @Override
    public void insertOpenstackRoles(OpenstackRoles openstackRoles) throws OperationException {
        int answer = openstackRolesMapper.insert(openstackRoles);
        if(answer < 0) {
            throw new OperationException("insertOpenstackRoles failed！");
        }
    }
}
