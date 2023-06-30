package com.ict.cloud.neutron.api.v2;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.common.model.AbstractEntity;
import com.ict.cloud.neutron.api.FloatingIPsManager;
import com.ict.cloud.neutron.model.FloatIp;

import java.util.List;

public class FloatIps extends AbstractManager<FloatIp> implements FloatingIPsManager {
    private static final String PREFIX = "/v2.0/floatingips";
    public FloatIps(Authenticated credentical) {
        super(credentical, FloatIp.class);
    }
    @Override
    public List<FloatIp> list() throws OperationException {
        return super._list(PREFIX);
    }

    @Override
    public FloatIp get(String id) throws OperationException {
        return super._get(PREFIX+"/"+id);
    }

    @Override
    public void delete(String id) throws OperationException {
        super._delete(PREFIX+"/"+id);
    }

    @Override
    public FloatIp create(FloatIp floatIp) throws OperationException {
        return super._create(PREFIX, floatIp.toJSONObject());
    }

    @Override
    public FloatIp update(FloatIp floatIp) throws OperationException {
        return super._update(PREFIX, floatIp.toJSONObject());
    }
}
