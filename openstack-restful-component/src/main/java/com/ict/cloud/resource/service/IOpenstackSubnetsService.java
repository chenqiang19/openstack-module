package com.ict.cloud.resource.service;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.resource.domain.OpenstackSubnets;

import java.util.List;

public interface IOpenstackSubnetsService {
    void insertOpenstackSubnets(OpenstackSubnets resource) throws OperationException;

    List<OpenstackSubnets> getSubnets(Integer tenantId);

    List<OpenstackSubnets> getAllSubnets();

    void deleteSubnet(Integer tenantId, String subnetId);
}
