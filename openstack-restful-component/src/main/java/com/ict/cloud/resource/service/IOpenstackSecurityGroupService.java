package com.ict.cloud.resource.service;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.resource.domain.OpenstackSecurityGroup;

import java.util.List;

public interface IOpenstackSecurityGroupService {
    /**
     * 方法实现说明
     * @author      cq
     * @param id
     * @return
     * @exception
     * @date        2021/5/25 17:52
     */
    OpenstackSecurityGroup getOpenstackSecurityGroupByPrimaryKey(Integer id);

    /**
     * 方法实现说明
     * @author      cq
     * @return
     * @exception
     * @date        2021/5/25 17:52
     */
    void insertOpenstackSecurityGroup(OpenstackSecurityGroup resource) throws OperationException;

    List<OpenstackSecurityGroup> getSecurityGroupIds();

    List<OpenstackSecurityGroup> getSecurityGroupByTenantId(Integer tenantId);

    OpenstackSecurityGroup getSecurityGroupBySecurityGroupId(String securityGroupId);
}
