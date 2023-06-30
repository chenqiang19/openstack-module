package com.ict.cloud.resource.service;


import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.common.exception.ServiceException;
import com.ict.cloud.resource.domain.OpenstackFloatips;

import java.util.List;

public interface IOpenstackFloatIpService {
    void insertOpenstackFloatIp(OpenstackFloatips openstackFloatips) throws OperationException;

    List<String> getFloatIpByTenantId(Integer tenantId);

    List<OpenstackFloatips> getFloatIpByTenantAndOrderId(Integer tenantId, Integer detailId, String orderId);

    void deleteFloatIp(Integer tenantId, Integer detailId, String orderId);

    List<OpenstackFloatips> getFloatIpsByTenantId(Integer tenantId);

    void updateFloatIpStatusByIp(String floatIp, String status, Integer detailId, String orderId) throws ServiceException;

    int countFloatIpByTenantId(Integer tenantId);

    List<OpenstackFloatips> getFloatIpByTenantIdAndIP(Integer tenantId, String ip);
}
