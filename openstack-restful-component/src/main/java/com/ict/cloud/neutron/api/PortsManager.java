package com.ict.cloud.neutron.api;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.neutron.model.Port;

import java.util.List;

public interface PortsManager {

    Port getPorts(String portId) throws OperationException;

    void deletePorts(String portId) throws OperationException;

    List<Port> listPorts() throws OperationException;
}
