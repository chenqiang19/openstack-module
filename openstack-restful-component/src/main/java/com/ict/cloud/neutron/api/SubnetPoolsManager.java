package com.ict.cloud.neutron.api;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.neutron.model.Subnet;

import java.util.List;

public interface SubnetPoolsManager {
    List<Subnet> list() throws OperationException;
    Subnet get(String id) throws OperationException;
    void delete(String id) throws OperationException;
    Subnet create(Subnet network) throws OperationException;
    Subnet update(Subnet network) throws OperationException;
}
