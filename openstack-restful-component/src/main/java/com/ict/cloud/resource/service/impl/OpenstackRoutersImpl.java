package com.ict.cloud.resource.service.impl;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.resource.domain.OpenstackRouters;
import com.ict.cloud.resource.domain.OpenstackRoutersCriteria;
import com.ict.cloud.resource.mapper.OpenstackRoutersMapper;
import com.ict.cloud.resource.service.IOpenstackRouterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OpenstackRoutersImpl implements IOpenstackRouterService {
    @Resource
    private OpenstackRoutersMapper openstackRouterMapper;

    @Override
    public void insertOpenstackRouters(OpenstackRouters resource) throws OperationException {
        int answer = openstackRouterMapper.insert(resource);
        if(answer < 0) {
            throw new OperationException("insertOpenstackRouters failed");
        }
    }

    @Override
    public List<OpenstackRouters> getRouters(Integer tenantId) {
        OpenstackRoutersCriteria example = new OpenstackRoutersCriteria();
        OpenstackRoutersCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(tenantId);
        return openstackRouterMapper.selectByExample(example);
    }

    @Override
    public List<OpenstackRouters> getAllRouters() {
        return null;
    }

    @Override
    public void deleteRouter(Integer tenantId, String routerId) {
        OpenstackRoutersCriteria example = new OpenstackRoutersCriteria();
        OpenstackRoutersCriteria.Criteria criteria = example.createCriteria();
        criteria.andRouterIdEqualTo(routerId);
        criteria.andTenantIdEqualTo(tenantId);
        openstackRouterMapper.deleteByExample(example);
    }

    @Override
    public OpenstackRouters getRouterByName(String name) {
        OpenstackRoutersCriteria example = new OpenstackRoutersCriteria();
        OpenstackRoutersCriteria.Criteria criteria = example.createCriteria();
        criteria.andRouterNameEqualTo(name);
        return openstackRouterMapper.selectOneByExample(example);
    }

    @Override
    public void updateGatewayInfo(String routerId, String gatewayInfo) {
        openstackRouterMapper.updateGatewayInfo(routerId, gatewayInfo);
    }
}
