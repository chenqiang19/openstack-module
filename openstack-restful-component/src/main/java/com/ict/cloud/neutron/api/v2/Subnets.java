package com.ict.cloud.neutron.api.v2;


import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.neutron.api.SubnetPoolsManager;
import com.ict.cloud.neutron.model.Subnet;

import java.util.List;
import java.util.Objects;

public class Subnets extends AbstractManager<Subnet> implements SubnetPoolsManager {

    private static final String PREFIX = "/v2.0/subnets";
    public Subnets(Authenticated credentical) {
        super(credentical, Subnet.class);
    }
    @Override
    public List<Subnet> list() throws OperationException {
        return super._list(PREFIX);
    }
    @Override
    public Subnet create(Subnet subnet) throws OperationException {
        return super._create(PREFIX , subnet.toJSONObject(false));
    }
    @Override
    public void delete(String id) throws OperationException {
        super._delete(PREFIX + "/" + id);
    }
    @Override
    public Subnet get(String id) throws OperationException {
        return super._get(PREFIX + "/" + id);
    }

    @Override
    public Subnet update(Subnet subnet) throws OperationException {
        Objects.requireNonNull(subnet);
        Objects.requireNonNull(subnet.getId());
        String id = subnet.getId();
        Subnet t = new Subnet();
        t.setName(subnet.getName());
        //t.setExternal(network.isExternal());
        //t.setShared(network.isShared());
        //t.setUp(network.isUp());
        return super._update(PREFIX, t.toJSONObject(false));
    }
}
