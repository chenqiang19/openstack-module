package com.ict.cloud.resource.service.impl;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.resource.domain.OpenstackUsers;
import com.ict.cloud.resource.domain.OpenstackUsersCriteria;
import com.ict.cloud.resource.mapper.OpenstackUsersMapper;
import com.ict.cloud.resource.service.IOpenstackUsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("openstack_users")
public class OpenstackUsersImpl implements IOpenstackUsersService {

    @Resource
    private OpenstackUsersMapper openstackUsersMapper;

    @Override
    public void insertOpenstackUsers(OpenstackUsers openstackUsers) throws OperationException{
        int answer = openstackUsersMapper.insert(openstackUsers);
        if(answer < 0) {
            throw new OperationException("insertOpenstackUsers failed！");
        }
    }

    @Override
    public String getProjectIdByUserId(String userId){
        OpenstackUsersCriteria example = new OpenstackUsersCriteria();
        OpenstackUsersCriteria.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return openstackUsersMapper.selectOneByExample(example).getDefaultProjectId();
    }

    @Override
    public void deleteUserByUserId(String userId){
        OpenstackUsersCriteria example = new OpenstackUsersCriteria();
        OpenstackUsersCriteria.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        openstackUsersMapper.deleteByExample(example);
    }

    @Override
    public OpenstackUsers getUserByTenantId(Integer tenantId) {
        OpenstackUsersCriteria example = new OpenstackUsersCriteria();
        OpenstackUsersCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(tenantId);
        return openstackUsersMapper.selectOneByExample(example);
    }

    @Override
    public OpenstackUsers getUserByName(String userName) {
        OpenstackUsersCriteria example = new OpenstackUsersCriteria();
        OpenstackUsersCriteria.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        return openstackUsersMapper.selectOneByExample(example);
    }

    @Override
    public void updateUser(OpenstackUsers openstackUsers) {
        OpenstackUsersCriteria example = new OpenstackUsersCriteria();
        OpenstackUsersCriteria.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(openstackUsers.getUserId());
        openstackUsersMapper.updateByExample(openstackUsers, example);
    }
}
