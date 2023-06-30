package com.ict.cloud.neutron.api.v2;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.neutron.api.RoutersManager;
import com.ict.cloud.neutron.model.Router;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Routers extends AbstractManager<Router> implements RoutersManager {
    private static final String PREFIX = "/v2.0/routers";
    public Routers(Authenticated credentical){ super(credentical, Router.class); }
    @Override
    public List<Router> list() throws OperationException {
        return super._list(PREFIX);
    }

    @Override
    public Router get(String id) throws OperationException {
        return super._get(PREFIX+"/"+ id);
    }

    @Override
    public void delete(String id) throws OperationException {
        super._delete(PREFIX+"/"+id);
    }

    @Override
    public Router create(Router router) throws OperationException {
        return super._create(PREFIX, router.toJSONObject());
    }

    @Override
    public Router update(Router router) throws OperationException {
        return super._update(PREFIX, router.toJSONObject());
    }

    @Override
    public Router addExternalGateway(String routerId, Router router) throws OperationException {
        return super._update(PREFIX+"/"+routerId+"/add_external_gateways", router);
    }

    @Override
    public Router addRouterInterface(String routerId, String subnetId) throws OperationException {
        JSONObject body = new JSONObject();
        body.put("subnet_id", subnetId);
        return super._update(PREFIX+"/"+routerId+"/add_router_interface", body);
    }

    @Override
    public void removeRouterInterface(String routerId, String subnetId, String portId) throws OperationException {
        JSONObject body = new JSONObject();
        if(subnetId!=null) {
            body.put("subnet_id", subnetId);
        }
        if(portId!=null) {
            body.put("port_id", portId);
        }
        super._update(PREFIX+"/"+routerId+"/remove_router_interface", body);
    }
}
