package com.ict.cloud.resource.service;


import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.resource.domain.OpenstackNetworks;

import java.util.List;

public interface IOpenstackNetworksService {
    /**
     * 方法实现说明
     * @author      cq
     * @param id
     * @return
     * @exception
     * @date        2021/5/25 17:52
     */
    OpenstackNetworks getOpenstackNetworkByPrimaryKey(Integer id);

    /**
     * 方法实现说明
     * @author      cq
     * @return
     * @exception
     * @date        2021/5/25 17:52
     */
    void insertOpenstackNetwork(OpenstackNetworks resource) throws OperationException;

    List<OpenstackNetworks> getNetworks(Integer tenantId);

    List<OpenstackNetworks> getAllNetwork();

    void deleteNetwork(Integer tenantId, String networkId);
}
