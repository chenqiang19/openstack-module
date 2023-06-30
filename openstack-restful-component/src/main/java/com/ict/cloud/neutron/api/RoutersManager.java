package com.ict.cloud.neutron.api;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.neutron.model.Router;
import com.ict.cloud.neutron.model.Subnet;

import java.util.List;

public interface RoutersManager {
    List<Router> list() throws OperationException;
    Router get(String id) throws OperationException;
    void delete(String id) throws OperationException;
    Router create(Router router) throws OperationException;
    Router update(Router router) throws OperationException;
    Router addExternalGateway(String routerId, Router router) throws OperationException;
    Router addRouterInterface(String routerId, String subnetId) throws OperationException;
    void removeRouterInterface(String routerId, String subnetId, String portId) throws OperationException;
}
