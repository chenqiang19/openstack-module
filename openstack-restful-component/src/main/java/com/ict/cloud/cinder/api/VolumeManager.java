package com.ict.cloud.cinder.api;

import com.ict.cloud.cinder.model.MountMode;
import com.ict.cloud.cinder.model.Snapshot;
import com.ict.cloud.cinder.model.Volume;
import com.ict.cloud.common.exception.OperationException;

import java.util.List;

public interface VolumeManager {
    List<Volume> list() throws OperationException;
    Volume get(String id) throws OperationException;
    Volume create(String name, int size, String description) throws OperationException;
    Volume create(Volume volume) throws OperationException;
    void delete(String id) throws OperationException;
    Volume update(String id, String name, String desc) throws OperationException;
    Volume rename(String id, String name) throws OperationException;
    Volume updateDescription(String id, String desc) throws OperationException;
    void mount(String devId, String serverId, String mountpoint, MountMode mode) throws OperationException;
    void mount(String devId, String serverId) throws OperationException;
    void umount(String devId) throws OperationException;
    void resize(String id, int size) throws OperationException;
    void resetState(String id, String state) throws OperationException;
    Snapshot snapshot(String id, String name, String desc) throws OperationException;
}
