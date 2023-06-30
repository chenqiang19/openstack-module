package com.ict.cloud.baremetal.api.v1;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.baremetal.model.Node;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.common.request.HttpMethod;
import com.ict.cloud.common.request.Response;
import com.ict.cloud.baremetal.api.NodesManager;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class Nodes extends AbstractManager<Node> implements NodesManager {
    private final String NODEPREFIX = "/v1/nodes";
    private final String TEMPLATEPREFIX = "/v1/deploy_templates";
    public Nodes(Authenticated credentical) {
        super(credentical, Node.class);
    }

    //*********************** Nodes ***********************//
    @Override
    public Node create(JSONObject instance) throws OperationException {
        return _create(NODEPREFIX, instance);
    }

    @Override
    public List<Node> list(String type) throws OperationException {
        if(type.equals("node")){
            return _list(NODEPREFIX);
        }else{
            return _list(TEMPLATEPREFIX);
        }
    }

    @Override
    public List<Node> detail(String type) throws OperationException{
        if(type.equals("node")){
            return _list(NODEPREFIX+ "/detail");
        }else{
            return _list(TEMPLATEPREFIX+ "/detail");
        }
    }

    @Override
    public Node get(String node_ident) throws OperationException {
        return _get(NODEPREFIX + "/" +node_ident);
    }

    @Override
    public Node update(String node_ident, JSONObject json) throws OperationException {
        return _update(NODEPREFIX+"/"+node_ident, json);
    }

    @Override
    public void delete(String node_ident) throws OperationException {
        _delete(NODEPREFIX + "/" + node_ident);
    }

    //*********************** Node Management ***********************//
    @Override
    public Node validate(String node_ident) throws OperationException {
        return _get(NODEPREFIX+"/" +node_ident+"validate");
    }

    @Override
    public void setMaintenanceFlag(String node_ident, String info) throws OperationException {
        JSONObject body = new JSONObject();
        body.put("reason", info);
        try {
            super.request(NODEPREFIX + "/" + node_ident + "/maintenance", HttpMethod.POST, body);
        } catch (Exception e) {
            throw new OperationException(e);
        }
    }

    @Override
    public void clearMaintenanceFlag(String node_ident) throws OperationException {
        _delete(NODEPREFIX + "/" + node_ident + "/maintenance");
    }

    @Override
    public JSONObject getBootDevice(String node_ident) throws OperationException {
        Response resp = null;
        try{
            resp = super.request(NODEPREFIX + "/" + node_ident + "/maintenance", HttpMethod.GET, null);
        }catch (Exception e){
            throw new OperationException(e);
        }
        JSONObject data = new JSONObject(resp.getBody());
        return data;
    }

    @Override
    public void setBootDevice(String node_ident, JSONObject json) throws OperationException {
        try{
             super.request(NODEPREFIX + "/" + node_ident + "/maintenance", HttpMethod.GET, json);
        }catch (Exception e){
            throw new OperationException(e);
        }
    }

    @Override
    public void changeNodeState(String node_ident, String state, Integer timeout) throws OperationException {
        if(state==null) {
            throw new OperationException("state is required!");
        }
        JSONObject body = new JSONObject();
        body.put("target", state);
        if(timeout>0) {
            body.put("timeout", timeout);
        }
        try{
            super.request(NODEPREFIX + "/" + node_ident + "/states/power", HttpMethod.PUT, body);
        }catch (Exception e){
            throw new OperationException(e);
        }
    }

    //*********************** Deploy Templates ***********************//
    @Override
    public JSONObject createDeployTemplate(JSONObject json) throws OperationException {
        Response resp = null;
        try{
            resp = super.request(TEMPLATEPREFIX + "/deploy_templates", HttpMethod.POST, json);
        }catch (Exception e){
            throw new OperationException(e);
        }
        JSONObject data = new JSONObject(resp.getBody());
        return data;
    }

    @Override
    public List<JSONObject> listDeployTemplate(JSONObject body) throws OperationException {
        Response resp = null;
        try{
            resp = super.request(TEMPLATEPREFIX + "/deploy_templates", HttpMethod.GET, body);
        }catch (Exception e){
            throw new OperationException(e);
        }
        JSONObject data = new JSONObject(resp.getBody());
        JSONArray array = data.getJSONArray("deploy_templates");
        List<JSONObject> json = new ArrayList<JSONObject>();
        for(int i=0; i< array.length(); i++) {
            json.add(array.getJSONObject(i));
        }
        return json;
    }

    @Override
    public void updateDeployTemplate(String deploy_template_id) throws OperationException {
        //
    }

    @Override
    public void delteDeployTemplate(String deploy_template_id) throws OperationException {
        _delete(TEMPLATEPREFIX + "/" + deploy_template_id);
    }
}
