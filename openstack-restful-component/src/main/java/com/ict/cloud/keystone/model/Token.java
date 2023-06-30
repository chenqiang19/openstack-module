package com.ict.cloud.keystone.model;

import java.util.Date;

import org.json.JSONObject;

import com.ict.cloud.common.annotation.Entity;
import com.ict.cloud.common.annotation.Property;
import com.ict.cloud.common.model.AbstractEntity;
import com.ict.cloud.tools.DateConverter;
@Entity("token")
public class Token extends AbstractEntity {
    private static final long serialVersionUID = -733311016900606838L;
    @Property
    private Date expires;
    @Property("issued_at")
    private Date issuedAt;
    @Property
    private Tenant tenant;
    public Token(JSONObject json) {
        this.issuedAt = DateConverter.parse(json.getString("issued_at"));
        this.expires = DateConverter.parse(json.getString("expires"));
        this.tenant = new Tenant(json.getJSONObject("tenant"));
        this.id = json.getString("id");
        this.name = tenant.getName();
    }
    public Token(JSONObject header, JSONObject body) {
        this.issuedAt = (body.getString("issued_at").equals(""))? this.issuedAt : DateConverter.parse(body.getString("issued_at"));
        this.expires = (body.getString("expires_at").equals(""))? this.expires : DateConverter.parse(body.getString("expires_at"));
        this.tenant = new Tenant(body.getJSONObject("project"));
        if (header.has("x-subject-token")) {
            this.id = header.getString("x-subject-token");
        }else if (header.has("X-Subject-Token")) {
            this.id = header.getString("X-Subject-Token");
        }

        this.name = tenant.getName();
    }
    public Date getExpires() {
        return this.expires;
    }
    public boolean isExpired() {
        if (expires == null)
            return true;
        return new Date().getTime() >= expires.getTime();
    }

    public Date getIssuedAt() {
        return this.issuedAt;
    }
    public Tenant getTenant() {
        return this.tenant;
    }
    @Override
    public boolean isValid() {
        return !isExpired();
    }
}
