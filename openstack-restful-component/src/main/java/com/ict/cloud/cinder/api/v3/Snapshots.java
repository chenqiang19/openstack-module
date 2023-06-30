package com.ict.cloud.cinder.api.v3;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.cinder.model.Snapshot;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.common.request.HttpMethod;
import com.ict.cloud.common.request.Response;
import com.ict.cloud.cinder.api.SnapshotManager;
import org.json.JSONObject;

import java.util.List;

public class Snapshots extends AbstractManager<Snapshot> implements
        SnapshotManager {
    private static final String PREFIX = "/snapshots";
    public Snapshots(Authenticated credentical) {
        super(credentical, Snapshot.class);
    }

    @Override
    public List<Snapshot> list() throws OperationException {
        StringBuilder stringBuilder = new StringBuilder();
        String url = String.valueOf(stringBuilder.append("/").append(PREFIX).append("/detail"));
        return _list(url);
    }

    @Override
    public Snapshot create(String volumeId, String name, String description)
            throws OperationException {
        Snapshot snapshot = new Snapshot();
        snapshot.setVolumeId(volumeId);
        snapshot.setName(name);
        snapshot.setDescription(description);
        StringBuilder stringBuilder = new StringBuilder();
        return _create(PREFIX, snapshot);
    }

    @Override
    public Snapshot get(String id) throws OperationException {
        StringBuilder stringBuilder = new StringBuilder();
        String url = String.valueOf(stringBuilder.append("/").append(PREFIX).append("/").append(id));
        return _get(url);
    }

    @Override
    public void delete(String id) throws OperationException {
        StringBuilder stringBuilder = new StringBuilder();
        String url = String.valueOf(stringBuilder.append("/").append(PREFIX).append("/").append(id));
        _delete(url);
    }

    @Override
    public Snapshot update(String id, String name, String description)
            throws OperationException {
        Snapshot shot = new Snapshot();
        shot.setId(id);
        shot.setName(name);
        shot.setDescription(description);
        StringBuilder stringBuilder = new StringBuilder();
        String url = String.valueOf(stringBuilder.append("/").append(PREFIX).append("/").append(id));
        return _update(url, shot);
    }

    @Override
    public Snapshot rename(String id, String name) throws OperationException {
        return update(id, name, null);
    }

    @Override
    public Snapshot updateDescription(String id, String description)
            throws OperationException {
        return update(id, null, description);
    }

    @Override
    public void resetState(String id, String state) throws OperationException {
        JSONObject info = new JSONObject();
        JSONObject body = new JSONObject();
        info.put("status", state);
        body.put("os-reset_status", info);
        Response response = null;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String url = String.valueOf(stringBuilder.append("/").append(PREFIX).append("/").append(id).append("/action"));
            response = super.request(url, HttpMethod.POST, body);
        } catch (Exception e) {
            throw new OperationException(e);
        }
        if (!response.isSuccess()) {
            throw new OperationException(response.getBody());
        }
    }

    @Override
    public void setMetadata(String id, String key, String value)
            throws OperationException {
        JSONObject body = new JSONObject();
        JSONObject data = new JSONObject();
        data.put(key, value);
        body.put("metadata", data);
        Response response = null;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String url = String.valueOf(stringBuilder.append("/").append(PREFIX).append("/").append(id).append("/metadata"));
            response = super.request(url, HttpMethod.POST, body);
        } catch (Exception e) {
            throw new OperationException(e);
        }
        if (!response.isSuccess()) {
            throw new OperationException(response.getBody());
        }
    }

    @Override
    public void deleteMetadata(String id, String key) throws OperationException {
        StringBuilder stringBuilder = new StringBuilder();
        String url = String.valueOf(stringBuilder.append("/").append(PREFIX).append("/").append(id).append("/metadata/").append(id));
        _delete(url);
    }

    @Override
    public void updateMetadata(String id, String key, String value)
            throws OperationException {
        setMetadata(id, key, value);
    }
}

