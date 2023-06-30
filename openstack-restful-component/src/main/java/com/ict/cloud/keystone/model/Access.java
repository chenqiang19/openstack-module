package com.ict.cloud.keystone.model;

import java.util.*;
import com.ict.cloud.authentication.Authenticated;
import org.json.JSONArray;
import org.json.JSONObject;

import com.ict.cloud.common.annotation.Entity;
import com.ict.cloud.common.annotation.Property;
import com.ict.cloud.common.model.AbstractEntity;
import com.ict.cloud.tools.StringUtils;

@Entity("access")
public class Access extends AbstractEntity implements Authenticated {
    private static final long serialVersionUID = 5310000130056732695L;
    @Property
    private Token token;
    @Property("catalog")
    private Map<String, Catalog> catalogs = new HashMap<>();
    @Property
    private Map<String, String> rolesMap = new HashMap<>();
    @Property
    private User user;
    @Property
    private List<String> roles;
    @Property
    private JSONObject metadata;
    private String workRegion;
    public Access(JSONObject json) {
        /** Process token **/
        if (!json.has("token")) {
            throw new RuntimeException("Failed to get token from access!");
        }
        this.token = new Token(json.getJSONObject("token"));
        /** process user **/
        JSONObject _user = json.getJSONObject("user");
        user = new User();
        user.setId(_user.getString("id"));
        user.setName(_user.getString("username"));
        /** process service Catalog **/
        JSONArray cs = json.getJSONArray("serviceCatalog");
        if (cs == null) {
            throw new RuntimeException("Failed to get service catalog from access");
        }
        for (int i = 0; i < cs.length(); ++i) {
            JSONObject c = cs.getJSONObject(i);
            String type = c.getString("type");
            JSONArray es = c.getJSONArray("endpoints");
            if (es != null) {
                for (int j = 0; j < es.length(); ++j) {
                    JSONObject e = es.getJSONObject(j);
                    String region = e.getString("region");
                    String url = e.getString("adminURL");
                    Catalog catalog = catalogs.get(region);
                    if (catalog == null) {
                        catalog = new Catalog(region);
                        catalogs.put(region, catalog);
                    }
                    CatalogType catalogType = CatalogType.of(type);
                    catalog.addEndpoint(catalogType, url);
                }
            }
        }
        /** Process Role **/
        JSONArray _roles = json.getJSONObject("metadata").getJSONArray("roles");
        roles = new ArrayList<>();
        for (int i = 0; i < _roles.length(); ++i) {
            roles.add(_roles.getString(i));
        }
        /** Process metadata **/
        this.metadata = json.getJSONObject("metadata");
    }
    public Access(JSONObject header, JSONObject body) {
        /** process token **/
        if(header.has("x-subject-token") && header.getString("x-subject-token")==null) {
            throw new RuntimeException("Failed to get token from access!");
        }else if (header.has("X-Subject-Token") && header.getString("X-Subject-Token")==null) {
            throw new RuntimeException("Failed to get token from access!");
        }else if (!header.has("x-subject-token") && !header.has("X-Subject-Token")) {
            throw new RuntimeException("Failed to get token from access!");
        }

        this.token = new Token(header, body.getJSONObject("token"));
        /** process user **/
        JSONObject _user = body.getJSONObject("token").getJSONObject("user");
        user = new User();
        user.setId(_user.getString("id"));
        user.setName(_user.getString("name"));
        /** process service Catalog **/
        JSONArray cs = body.getJSONObject("token").getJSONArray("catalog");
        if (cs == null) {
            throw new RuntimeException("Failed to get service catalog from access");
        }
        for (int i = 0; i < cs.length(); ++i) {
            JSONObject c = cs.getJSONObject(i);
            String type = c.getString("type");
            String id = c.getString("id");
            JSONArray es = c.getJSONArray("endpoints");

            //object-store enum is not support
            if(type.equals("object-store")){
                type = "object_store";
            }
            if(type.equals("baremetal-introspection")){
                type = "baremetal_introspection";
            }
            if(type.equals("application-catalog")) {
                type = "application_catalog";
            }
            if(type.equals("heat-cfn")){
                type = "heat_cfn";
            }
            if(type.equals("load-balancer")){
                type = "load_balancer";
            }
            if(type.equals("infra-optim")){
                type = "infra_optim";
            }
            if(type.equals("instance-ha")){
                type = "instance_ha";
            }
            if(type.equals("key-manager")){
                type = "key_manager";
            }
            if(type.equals("data-processing")){
                type = "data_processing";
            }
            if(type.equals("image-builder")){
                type = "image_builder";
            }
            if(type.equals("container-infra")){
                type = "container_infra";
            }
            if(type.equals("application-deployment")){
                type = "application_deployment";
            }
            if(type.equals("nfv-orchestration")){
                type = "nfv_orchestration";
            }

            if (es != null) {
                for (int j = 0; j < es.length(); ++j) {
                    JSONObject e = es.getJSONObject(j);
                    String region = e.getString("region");
                    String url = e.getString("url");
                    String accessPermission = e.getString("interface");
                    if(!accessPermission.toLowerCase(Locale.ROOT).equals("public")) {
                        continue;
                    }
                    Catalog catalog = catalogs.get(region);
                    if (catalog == null) {
                        catalog = new Catalog(region);
                        catalogs.put(region, catalog);
                    }

                    CatalogType catalogType = CatalogType.of(type);
                    catalog.addEndpoint(catalogType, url);
                    catalog.addIds(catalogType, id);
                }
            }
        }
        /** Process Role **/
        JSONArray _roles = body.getJSONObject("token").getJSONArray("roles");
        roles = new ArrayList<>();
        for (int i = 0; i < _roles.length(); ++i) {
            JSONObject r = _roles.getJSONObject(i);
            roles.add(r.getString("name"));
            rolesMap.put(r.getString("name"), r.getString("id"));
        }
    }

    @Override
    public String getTokenId() {
        return token.getId();
    }
    @Override
    public Token getToken() {
        return this.token;
    }
    @Override
    public User getUser() {
        return user;
    }
    @Override
    public Tenant getTenant() {
        return token.getTenant();
    }
    @Override
    public String getEndpoint(CatalogType type) {
        String region = getWorkRegion();
        return catalogs.get(region).getURL(type);
    }
    @Override
    public String getWorkRegion() {
        if (workRegion == null && catalogs.size() > 0) {
            workRegion = catalogs.keySet().toArray()[0].toString();
        }
        return workRegion;
    }

    @Override
    public String getBareMetalID(){
        if (catalogs.size()>0){
            return catalogs.get("RegionOne").getID(CatalogType.baremetal);
        }else {
            return null;
        }
    }

    @Override
    public void setWorkRegion(String region) {
        if (!catalogs.containsKey(region)) {
            throw new RuntimeException("The target region '" + region + "' Not Found!");
        }
        this.workRegion = region;
    }
    @Override
    public Set<String> getRegions() {
        return catalogs.keySet();
    }

    @Override
    public String getServerId(String key) { return catalogs.get(getWorkRegion()).getID(CatalogType.of(key)); }

    public JSONObject getMetadata() {
        return this.metadata;
    }
    @Override
    public boolean isValid() {
        boolean hasToken = (token != null && StringUtils.isNotBlank(token.getId()));
        boolean hasRegion = (getWorkRegion() != null);
        boolean hasCatalog = (catalogs != null && catalogs.size() > 0);
        return hasToken && hasRegion && hasCatalog;
    }
}
