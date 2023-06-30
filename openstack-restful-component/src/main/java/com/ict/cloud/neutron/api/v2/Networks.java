package com.ict.cloud.neutron.api.v2;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.neutron.api.NetworkManager;
import com.ict.cloud.neutron.model.Network;

import java.util.List;
import java.util.Objects;

public class Networks extends AbstractManager<Network> implements NetworkManager {
    private static final String PREFIX = "/v2.0/networks";
    public Networks(Authenticated credentical) {
        super(credentical, Network.class);
    }
    @Override
    public List<Network> list() throws OperationException {
        return super._list(PREFIX);
    }
    @Override
    public synchronized Network create(Network network) throws OperationException {
        return super._create(PREFIX , network.toJSONObject(false));
    }
    @Override
    public void delete(String id) throws OperationException {
        super._delete(PREFIX + "/" + id);
    }
    @Override
    public Network get(String id) throws OperationException {
        return super._get(PREFIX + "/" + id);
    }

    @Override
    public Network update(Network network) throws OperationException {
        Objects.requireNonNull(network);
        Objects.requireNonNull(network.getId());
        String id = network.getId();
        Network t = new Network();
        t.setName(network.getName());
        //t.setExternal(network.isExternal());
        //t.setShared(network.isShared());
        //t.setUp(network.isUp());
        return super._update(PREFIX + "/networks/" + id + ".json", t.toJSONObject(false));
    }
}
