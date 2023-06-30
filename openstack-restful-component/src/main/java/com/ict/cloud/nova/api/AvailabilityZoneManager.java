package com.ict.cloud.nova.api;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.nova.model.AvailableZone;

import java.util.List;

public interface AvailabilityZoneManager {

    List<AvailableZone> list() throws OperationException;

    AvailableZone get() throws OperationException;
}
