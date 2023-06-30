package com.ict.cloud.resource.service;

import com.ict.cloud.common.exception.ServiceException;
import com.ict.cloud.resource.domain.OpenstackKeyPairs;

import java.util.List;

public interface IOpenstackKeyPairService {

    int insert(OpenstackKeyPairs openstackKeyPairs) throws ServiceException;

    List<OpenstackKeyPairs> getKeyPairsByTenantId(Integer tenantId, String keyPairName);
}
