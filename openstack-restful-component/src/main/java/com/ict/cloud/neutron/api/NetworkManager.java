package com.ict.cloud.neutron.api;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.neutron.model.Network;
import com.ict.cloud.neutron.model.SecurityGroup;

import java.util.List;

public interface NetworkManager {
    List<Network> list() throws OperationException;
    Network get(String id) throws OperationException;
    void delete(String id) throws OperationException;
    Network create(Network network) throws OperationException;
    Network update(Network network) throws OperationException;
}
