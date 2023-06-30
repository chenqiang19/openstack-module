package com.ict.cloud.authentication;

import java.util.Set;

import com.ict.cloud.keystone.model.CatalogType;
import com.ict.cloud.keystone.model.Tenant;
import com.ict.cloud.keystone.model.Token;
import com.ict.cloud.keystone.model.User;

public interface Authenticated {
    String getTokenId();
    User getUser();
    Tenant getTenant();
    String getEndpoint(CatalogType type);
    String getWorkRegion();
    void setWorkRegion(String region);
    Set<String> getRegions();
    String getServerId(String key);
    String getBareMetalID();
    Token getToken();
}