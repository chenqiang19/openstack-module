package com.ict.cloud.cinder.api;

import com.ict.cloud.cinder.model.VolumeType;
import com.ict.cloud.common.exception.OperationException;

import java.util.List;
import java.util.Map;

public interface VolumeTypeManager {
    List<VolumeType> list() throws OperationException;
    VolumeType get(String id) throws OperationException;
    void delete(String id) throws OperationException;
    VolumeType create(String name) throws OperationException;
    void setKey(String id, String key, String value) throws OperationException;
    Map<String, String> getKeys(String id) throws OperationException;
    void unsetKey(String id, String key) throws OperationException;
}

