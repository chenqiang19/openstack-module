package com.ict.cloud.keystone.model;

import java.util.EnumMap;
import java.util.Map;

import org.json.JSONObject;

import com.ict.cloud.common.annotation.Entity;
@Entity("catalog")
public class Catalog {
    private final Map<CatalogType, String> endpoints = new EnumMap<>(CatalogType.class);
    private final Map<CatalogType, String> ids = new EnumMap<>(CatalogType.class);
    private final String region;
    public Catalog(String region) {
        this.region = region;
    }
    public void addEndpoint(CatalogType type, String url) {
        endpoints.put(type, url);
    }
    public void addIds(CatalogType type, String id) {
        ids.put(type, id);
    }
    public String getRegion() {
        return this.region;
    }
    public String getURL(String type) {
        CatalogType catalogType = CatalogType.of(type);
        return endpoints.get(catalogType);
    }
    public String getURL(CatalogType type) {
        return endpoints.get(type);
    }
    public String getID(CatalogType type) { return ids.get(type); }
    public JSONObject toJSONObject() {
        JSONObject json = new JSONObject();
        json.put("region", region);
        json.put("endpoints", endpoints);
        json.put("ids", ids);
        return json;
    }
    @Override
    public String toString() {
        return toJSONObject().toString();
    }
    public String toString(int indent) {
        return toJSONObject().toString(indent);
    }
}
