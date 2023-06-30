package com.ict.cloud.baremetal.api;

import com.ict.cloud.baremetal.model.Node;
import com.ict.cloud.common.exception.OperationException;
import org.json.JSONObject;

import java.util.List;

public interface NodesManager {

    /**
     * create a bare metal node
     * @param json is request body.
     * @return BareMetalServer
     * @throws OperationException
     */
    Node create(JSONObject json) throws OperationException;

    /**
     * list bare metal nodes
     * @return BareMetal servers
     * @throws OperationException
     */
    List<Node> list(String type) throws OperationException;

    /**
     * list bare metal nodes details
     * @return BareMetal servers
     * @throws OperationException
     */
    List<Node> detail(String type) throws OperationException;

    /**
     * get bare metal nodes
     * @return BareMetal servers
     * @throws OperationException
     */
    Node get(String node_ident) throws OperationException;

    /**
     * update bare metal node
     * @return BareMetal servers
     * @throws OperationException
     */
    Node update(String node_ident, JSONObject json) throws OperationException;

    /**
     * delete bare metal node
     * @return BareMetal servers
     * @throws OperationException
     */
     void delete(String node_ident) throws OperationException;

    /**
     * validate bare metal node
     * @return BareMetal server maintenance
     * @throws OperationException
     */
    Node validate(String node_ident) throws OperationException;

    /**
     * set maintenance flag for bare metal node
     * @return void
     * @throws OperationException
     */
    void setMaintenanceFlag(String node_ident, String info) throws OperationException;

    /**
     * clear maintenance flag for bare metal node
     * @return void
     * @throws OperationException
     */
    void clearMaintenanceFlag(String node_ident) throws OperationException;

    /**
     * get current boot device for the given node
     * @return device info
     * @throws OperationException
     */
    JSONObject getBootDevice(String node_ident) throws OperationException;

    /**
     * set current boot device for the given node
     * @return device info
     * @throws OperationException
     */
    void setBootDevice(String node_ident, JSONObject json) throws OperationException;

    /**
     * change node power state
     * @return device info
     * @throws OperationException
     */
    void changeNodeState(String node_ident, String state, Integer timeout) throws OperationException;

    /**
     * create deploy template
     * @return deploy template info
     * @throws OperationException
     */
    JSONObject createDeployTemplate(JSONObject json) throws OperationException;

    /**
     * list deploy template
     * @return deploy template info
     * @throws OperationException
     */
    List<JSONObject> listDeployTemplate(JSONObject reqirue) throws OperationException;

    /**
     * update deploy template
     * @return void
     * @throws OperationException
     */
    void updateDeployTemplate(String deploy_template_id) throws OperationException;

    /**
     * delete deploy template
     * @return void
     * @throws OperationException
     */
    void delteDeployTemplate(String deploy_template_id) throws OperationException;
}
