package com.ict.cloud.resource.service;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.resource.domain.OpenstackRouters;

import java.util.List;

public interface IOpenstackRouterService {
    void insertOpenstackRouters(OpenstackRouters resource) throws OperationException;

    List<OpenstackRouters> getRouters(Integer tenantId);

    List<OpenstackRouters> getAllRouters();

    void deleteRouter(Integer tenantId, String routerId);

    OpenstackRouters getRouterByName(String name);

    void updateGatewayInfo(String router, String gatewayInfo);
}
