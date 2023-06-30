package com.ict.cloud.cinder.api.v3;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.cinder.model.VolumeType;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.common.request.HttpMethod;
import com.ict.cloud.common.request.Response;
import com.ict.cloud.cinder.api.VolumeTypeManager;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Types extends AbstractManager<VolumeType> implements VolumeTypeManager {
    public Types(Authenticated credentical) {
        super(credentical, VolumeType.class);
    }

    @Override
    public List<VolumeType> list() throws OperationException {
        return _list("/types");
    }

    @Override
    public VolumeType get(String id) throws OperationException {
        return _get("/types/" + id);
    }

    @Override
    public void delete(String id) throws OperationException {
        _delete("/types/" + id);
    }

    @Override
    public VolumeType create(String name) throws OperationException {
        VolumeType type = new VolumeType();
        type.setName(name);
        return _create("/types", type);
    }

    @Override
    public void setKey(String id, String key, String value)
            throws OperationException {
        JSONObject body = new JSONObject();
        JSONObject info = new JSONObject();
        info.put(key, value);
        body.put("extra_specs", info);
        Response response = null;
        String url = String.format("/types/%s/extra_specs", id);
        try {
            response = super.request(url, HttpMethod.POST, body);
        } catch(Exception e) {
            throw new OperationException(e);
        }
        if (!response.isSuccess())
            throw new OperationException(response.getBody());
    }

    @Override
    public Map<String, String> getKeys(String id) throws OperationException {
        Response response = null;
        String url = String.format("/types/%s/extra_specs", id);
        try {
            response = super.request(url, HttpMethod.GET, null);
        } catch(Exception e) {
            throw new OperationException(e);
        }
        if (!response.isSuccess())
            throw new OperationException(response.getBody());
        JSONObject json = new JSONObject(response.getBody()).getJSONObject("extra_specs");
        Map<String, String> values = new HashMap<>();
        for (Object key : json.keySet()) {
            values.put(key.toString(), json.get(key.toString()).toString());
        }
        return values;
    }

    @Override
    public void unsetKey(String id, String key) throws OperationException {
        String url = String.format("/types/%s/extra_specs/%s", id, key);
        _delete(url);
    }

}

