package com.ict.cloud.neutron.api;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.neutron.model.FloatIp;

import java.util.List;

public interface FloatingIPsManager {
    List<FloatIp> list() throws OperationException;
    FloatIp get(String id) throws OperationException;
    void delete(String id) throws OperationException;
    FloatIp create(FloatIp floatIp) throws OperationException;
    FloatIp update(FloatIp floatIp) throws OperationException;
}
