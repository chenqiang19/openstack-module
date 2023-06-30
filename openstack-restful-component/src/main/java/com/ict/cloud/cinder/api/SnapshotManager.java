package com.ict.cloud.cinder.api;

import com.ict.cloud.cinder.model.Snapshot;
import com.ict.cloud.common.exception.OperationException;

import java.util.List;

public interface SnapshotManager {
    List<Snapshot> list() throws OperationException;
    Snapshot create(String volumeId, String name, String description) throws OperationException;
    Snapshot get(String id) throws OperationException;
    void delete(String id) throws OperationException;
    Snapshot update(String id, String name, String description) throws OperationException;
    Snapshot rename( String id, String name) throws OperationException;
    Snapshot updateDescription(String id, String description) throws OperationException;
    void resetState(String id, String state) throws OperationException;
    void setMetadata(String id, String key, String value) throws OperationException;
    void deleteMetadata(String id, String key) throws OperationException;
    void updateMetadata(String id, String key, String value) throws OperationException;
}