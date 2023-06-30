package com.ict.cloud.neutron.model;

import com.ict.cloud.common.annotation.Entity;
import com.ict.cloud.common.annotation.Property;
import com.ict.cloud.common.model.AbstractEntity;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Entity("router")
public class Router extends AbstractEntity {
    public static final long serialVersionUID = 1L;

    @Property
    private String id;
    @Property
    private String project_id;
    @Property
    private Boolean admin_state_up;
    @Property
    private String status;
    @Property
    private GatewayInfo external_gateway_info;
    @Property
    private JSONArray external_gateways;
    @Property
    private JSONArray routes;
    @Property
    private String nethop;
    @Property
    private Boolean distributed;
    @Property
    private String flavor_id;
    @Property
    private String created_at;
    @Property
    private String updated_at;
    @Property
    private String service_type_id;
    @Property
    private List<String> subnetId;
    @Property
    private List<String> portId;

    public Router() {
        super();
    }

    public Router(JSONObject entity) {
        super(entity);
        this.id = entity.getString("id");
//        this.admin_state_up = entity.getBoolean("admin_state_up");
//        if(entity.has("external_gateway_info") && entity.get("external_gateway_info")!=JSONObject.NULL){
//            JSONObject object = entity.getJSONObject("external_gateway_info");
//            this.external_gateway_info = new GatewayInfo();
//            this.external_gateway_info.setNetworkId(object.getString("network_id"));
//            this.external_gateway_info.setEnableSnat(object.getBoolean("enable_snat"));
//            this.external_gateway_info.setEnternal_fixed_ips(object.getJSONArray("external_fixed_ips"));
//        }
//        if(this.external_gateway_info!=null) {
//            JSONArray array = this.external_gateway_info.getEnternal_fixed_ips();
//            this.subnetId = new ArrayList<>();
//            this.portId = new ArrayList<>();
//            for(int i=0; i<array.length(); i++) {
//                JSONObject jsonObject = array.getJSONObject(i);
//                if(jsonObject.has("subnet_id")){
//                    this.subnetId.add(jsonObject.optString("subnet_id", null));
//                }
//
//                if(jsonObject.has("port_id")){
//                    this.portId.add(jsonObject.optString("port_id", null));
//                }
//            }
//        }
        if(entity.has("subnet_ids")){
            JSONArray array = entity.getJSONArray("subnet_ids");
            this.subnetId = new ArrayList<>();
            for(int i=0; i<array.length(); i++) {
                this.subnetId.add(array.getString(i));
            }
        }
        if(entity.has("port_id")){
            this.portId = new ArrayList<>();
            this.portId.add(entity.getString("port_id"));
        }
    }

    public Router(Router.GatewayInfo gatewayInfo) {
        this.external_gateways = new JSONArray();
        this.external_gateways.put(gatewayInfo);
    }

    public Router(JSONObject header, JSONObject body) {
        JSONObject router = body.getJSONObject("router");
        this.id = router.getString("id");
        this.admin_state_up = router.getBoolean("admin_state_up");
        if(router.has("external_gateway_info") && router.get("external_gateway_info")!=JSONObject.NULL){
            JSONObject object = router.getJSONObject("external_gateway_info");
            this.external_gateway_info = new GatewayInfo();
            this.external_gateway_info.setNetworkId(object.getString("network_id"));
            this.external_gateway_info.setEnableSnat(object.getBoolean("enable_snat"));
            this.external_gateway_info.setEnternal_fixed_ips(object.getJSONArray("external_fixed_ips"));
        }
        if(router.has("flavor") && router.get("flavor_id")!=null){
            this.flavor_id = router.getJSONObject("flavor_id").toString();
        }
        //this.distributed = router.getBoolean("distributed");
        this.status = router.getString("status");
        this.name = router.getString("name");
        this.created_at = router.getString("created_at");
        this.updated_at = router.getString("updated_at");
        this.project_id = router.getString("project_id");
        if(this.external_gateway_info!=null) {
            JSONArray array = this.external_gateway_info.getEnternal_fixed_ips();
            this.subnetId = new ArrayList<>();
            this.portId = new ArrayList<>();
            for(int i=0; i<array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                if(jsonObject.has("subnet_id")){
                    this.subnetId.add(jsonObject.optString("subnet_id", null));
                }

                if(jsonObject.has("port_id")){
                    this.portId.add(jsonObject.optString("port_id", null));
                }
            }
        }
    }

    public String getId() { return this.id; }

    public String getProject_id() { return this.project_id; }
    public void setProject_id(String project_id) { this.project_id = project_id; }

    public Boolean getAdmin_state_up() { return this.admin_state_up; }
    public void setAdmin_state_up(Boolean admin_state_up) { this.admin_state_up = admin_state_up; }

    public String getStatus() { return this.status; }
    public void setStatus(String status) { this.status = status; }

    public String getCreated_at() { return this.created_at; }
    public void setCreated_at(String created_at) { this.created_at = created_at; }

    public String getUpdated_at() { return this.updated_at; }
    public void setUpdated_at(String updated_at) { this.updated_at = updated_at; }

    public List<String> getSubnetId() { return this.subnetId; }
    public void setSubnetId(List<String> subnetId) { this.subnetId = subnetId; }

    public List<String> getPortId() { return this.portId; }
    public void setPortId(List<String> portId) { this.portId = portId; }

    public GatewayInfo getExternal_gateway_info() { return this.external_gateway_info; }
    public void setExternal_gateway_info(GatewayInfo gatewayInfo) { this.external_gateway_info = gatewayInfo; }

    @Override
    public boolean isValid() {
        return false;
    }

    public static class GatewayInfo extends AbstractEntity {
        private static final long serialVersionUID = 1L;
        private String networkId;
        private Boolean enable_snat;
        private JSONArray enternal_fixed_ips;
        public GatewayInfo() {}
        public GatewayInfo(JSONObject entity) {
            super(entity);
        }

        public GatewayInfo(Object obj) {
            super(obj);
        }
        @Override
        public boolean isValid() {
            return this.name != null;
        }

        @Override
        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }

        public String getNetworkId() { return this.networkId; }
        public void setNetworkId(String networkId) {
            this.networkId=networkId;
        }

        public Boolean getEnableSnat() { return this.enable_snat; }
        public void setEnableSnat(Boolean enable_snat){ this.enable_snat = enable_snat; }

        public JSONArray getEnternal_fixed_ips() { return this.enternal_fixed_ips; }
        public void setEnternal_fixed_ips(JSONArray enternal_fixed_ips) { this.enternal_fixed_ips = enternal_fixed_ips; }

        @Override
        public String toString() {
            JSONObject json = new JSONObject();
            json.put("network_id", this.networkId);
            json.put("enable_snat", this.enable_snat);
            json.put("enternal_fixed_ips", this.enternal_fixed_ips);
            return json.toString();
        }
    }
}
