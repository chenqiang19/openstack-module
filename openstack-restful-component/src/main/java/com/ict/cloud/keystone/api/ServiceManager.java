package com.ict.cloud.keystone.api;

import com.ict.cloud.keystone.model.Service;
import com.ict.cloud.common.exception.OperationException;

import java.util.List;

public interface ServiceManager {
    List<Service> list() throws OperationException;
    Service get(String id) throws OperationException;
    Service create(String name, String type, String description) throws OperationException;
    Service create(Service service) throws OperationException;
    void delete(String id) throws OperationException;
}
