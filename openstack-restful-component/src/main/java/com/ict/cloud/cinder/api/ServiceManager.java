package com.ict.cloud.cinder.api;

import com.ict.cloud.cinder.model.Service;
import com.ict.cloud.common.exception.OperationException;

import java.util.List;

public interface ServiceManager {
    List<Service> list() throws OperationException;
    Service enable(String host, String name) throws OperationException;
    Service disalbe(String host, String name) throws OperationException;
}

