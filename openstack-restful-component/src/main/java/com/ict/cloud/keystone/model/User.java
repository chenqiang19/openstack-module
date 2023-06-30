package com.ict.cloud.keystone.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONObject;

import com.ict.cloud.common.annotation.Entity;
import com.ict.cloud.common.annotation.Property;
import com.ict.cloud.common.model.AbstractEntity;
@Entity
public class User extends AbstractEntity{
    private static final long serialVersionUID = 1497888419304968741L;
    @Property
    private String email;
    @Property
    private String password;
    @Property
    private boolean enabled;
    @Property
    private String username;
    private List<String> tenantNames = new ArrayList<>();
    @Property("default_project_id")
    private String default_project_id;
    @Property
    private String domainId;
    @Property
    private String description;
    public User() {
        super();
        enabled = true;
    }
    public User(JSONObject user) {
        super(user);
        if (username == null) {
            username = name;
        }
    }

    public User(JSONObject header, JSONObject body) {
        JSONObject user = body.getJSONObject("user");
        this.id = user.getString("id");
        this.enabled = user.getBoolean("enabled");
        this.name = user.getString("name");
        this.default_project_id = user.getString("default_project_id");
        this.domainId = user.getString("domain_id");
    }

    public User(Object o) {
        this(new JSONObject(o.toString()));
    }
    public User(String s) {
        this(new JSONObject(s));
    }
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<String> getTenantNemes() {
        return Collections.unmodifiableList(tenantNames);
    }

    public void setTenantNames(List<String> ids) {
        tenantNames.addAll(ids);
    }
    public String getUsername() {
        return username;
    }
    public void setProjectId (String projectId) {
        this.default_project_id = projectId;
    }
    public String getProjectId() {
        return this.default_project_id;
    }

    public void setDomainId (String domainId) {
        this.domainId = domainId;
    }
    public String getDomainId() {
        return this.domainId;
    }

    public String getDescription() { return this.description; }
    public void setDescription(String description) { this.description = description; }
    @Override
    public boolean isValid() {
        return true;
    }
}
