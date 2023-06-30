package com.ict.cloud.nova.api.v2;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.nova.api.AvailabilityZoneManager;
import com.ict.cloud.nova.model.AvailableZone;

import java.util.List;

public class AvailabilityZones extends AbstractManager<AvailableZone> implements AvailabilityZoneManager {
    private static final String PREFIX = "/os-availability-zone";
    public AvailabilityZones(Authenticated credentical) {
        super(credentical, AvailableZone.class);
    }
    @Override
    public List<AvailableZone> list() throws OperationException {
        return _list(PREFIX);
    }

    @Override
    public AvailableZone get() throws OperationException {
        return _get(PREFIX + "/" + "detail");
    }
}
