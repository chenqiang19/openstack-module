package com.ict.cloud.keystone.model;

import com.ict.cloud.common.annotation.Entity;
import com.ict.cloud.common.annotation.Property;
import com.ict.cloud.common.model.AbstractEntity;
import org.json.JSONObject;

@Entity
public class Role extends AbstractEntity {
    private static final long serialVersionUID = 6781304741592751481L;
    @Property
    private String description;
    @Property
    private boolean enabled;
    public Role() {
        super();
        this.enabled = true;
    }
    public Role(JSONObject role) {
        super(role);
        if (role.has("enabled")) {
            this.enabled = role.getBoolean("enabled");
        } else {
            this.enabled = true;
        }
    }



    public Role(Object o) {
        this(new JSONObject(o.toString()));
    }
    public Role(String s) {
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

    @Override
    public boolean isValid() {
        return true;
    }
}
