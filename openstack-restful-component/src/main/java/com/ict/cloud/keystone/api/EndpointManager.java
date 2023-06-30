package com.ict.cloud.keystone.api;

import java.util.List;

import com.ict.cloud.keystone.model.Endpoint;
import com.ict.cloud.common.exception.OperationException;

public interface EndpointManager {
    List<Endpoint> list() throws OperationException;
    Endpoint create(Endpoint endpoint) throws OperationException;
    Endpoint create(String region, String serviceId, String publicurl, String adminurl, String internalurl) throws OperationException;
    void delete(String id) throws OperationException;
}
