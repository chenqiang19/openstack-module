package com.ict.cloud.cinder.api.v3;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.cinder.model.Service;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.common.request.HttpMethod;
import com.ict.cloud.common.request.Response;
import com.ict.cloud.cinder.api.ServiceManager;
import com.ict.cloud.tools.JSONConverter;
import org.json.JSONObject;

import java.util.List;

public class Services extends AbstractManager<Service> implements ServiceManager {
    private static final String PREFIX = "/os-services";

    public Services(Authenticated credentical) {
        super(credentical, Service.class);
    }

    private Service doAction(String host, String name, String action) throws OperationException {
        JSONObject body = new JSONObject();
        body.put("host", host);
        body.put("binary", name);
        Response response = null;
        try {
            response = super.request(PREFIX + "/" + action, HttpMethod.PUT, body);
        } catch (Exception e) {
            throw new OperationException(e);
        }
        if (!response.isSuccess())
            throw new OperationException(response.getBody());
        return JSONConverter.responseToEntity(response.getBody(), "", Service.class, getRegion());
    }

    @Override
    public List<Service> list() throws OperationException {
        return _list(PREFIX);
    }

    @Override
    public Service enable(String host, String name) throws OperationException {
        return doAction(host, name, "enable");
    }

    @Override
    public Service disalbe(String host, String name) throws OperationException {
        return doAction(host, name, "disable");
    }
}
