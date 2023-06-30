package com.ict.cloud.neutron.api.v2;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.neutron.api.PortsManager;
import com.ict.cloud.neutron.model.Port;

import java.util.List;

public class Ports extends AbstractManager<Port> implements PortsManager {
    private static final String PREFIX = "/v2.0/ports";
    public Ports(Authenticated credentical) {
        super(credentical, Port.class);
    }

    @Override
    public Port getPorts(String portId) throws OperationException {
        return super._get(PREFIX+"/"+portId);
    }

    @Override
    public void deletePorts(String portId) throws OperationException {
        super._delete(PREFIX+"/"+portId);
    }

    @Override
    public List<Port> listPorts() throws OperationException {
        return super._list(PREFIX);
    }
}
