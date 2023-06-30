package com.ict.cloud.keystone.model;

import com.ict.cloud.common.annotation.Entity;
import com.ict.cloud.common.annotation.Property;
import com.ict.cloud.common.model.AbstractEntity;
import org.json.JSONObject;


@Entity
public class Project extends AbstractEntity {

    private static final long serialVersionUID = -8649087054687944504L;
    @Property
    private boolean isDomain;
    @Property
    private String description;
    @Property
    private String domain_id;
    @Property
    private boolean enabled;
    @Property
    private String id;
    @Property
    private String parent_id;
    public Project() {
        super();
        this.enabled = true;
    }

    public Project(String name, String description, String domain_id, Boolean enabled){
        this.name = name;
        this.description = description;
        this.domain_id = domain_id;
        this.enabled = enabled;
    }

    public Project(JSONObject header, JSONObject body) {
        JSONObject project = body.getJSONObject("project");
        this.isDomain = project.getBoolean("is_domain");
        this.description = project.getString("description");
        this.domain_id = project.getString("domain_id");
        this.id = project.getString("id");
        this.enabled = project.getBoolean("enabled");
        this.name = project.getString("name");
        this.parent_id = project.getString("parent_id");
    }

    public Project(JSONObject project) {
        super(project);
        this.isDomain = project.getBoolean("is_domain");
        this.description = project.getString("description");
        this.domain_id = project.getString("domain_id");
        this.id = project.getString("id");
        this.name = getName();
        this.parent_id = project.getString("parent_id");
    }
    public Project(Object o) {
        this(new JSONObject(o.toString()));
    }
    public Project(String s) {
        this(new JSONObject(s));
    }

    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnabled() {
        return this.enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getDomainId() { return this.domain_id; }
    public void setDomainId(String domain_id) { this.domain_id = domain_id; }

    public String getId() { return this.id; }
    public void setId(String id) { this.id = id; }
    @Override
    public boolean isValid() {
        return false;
    }

    public Boolean getIsDomain(){ return this.isDomain; }
    public void setIsDomain(Boolean is_domain) { this.isDomain = is_domain; }
}
