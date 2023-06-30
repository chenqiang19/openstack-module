package com.ict.cloud.cinder.model;

import com.ict.cloud.common.annotation.Entity;
import com.ict.cloud.common.annotation.Property;
import com.ict.cloud.common.model.AbstractEntity;
import org.json.JSONObject;

@Entity("service")
public class CinderService extends AbstractEntity {
    /**
     *
     */
    private static final long serialVersionUID = 342499758253086031L;
    @Property
    private String binary;
    @Property
    private String status;
    @Property
    private String zone;
    @Property
    private String state;
    @Property
    private String updatedAt;
    @Property
    private String host;
    public CinderService(JSONObject json) {
        super(json);
        this.name = this.binary;
        this.id = this.name + "@" + host;
    }
    public CinderService(Object obj) {
        this(new JSONObject(obj.toString()));
    }
    public CinderService(String s) {
        this(new JSONObject(s));
    }

    public String getBinary() {
        return binary;
    }
    public String getStatus() {
        return status;
    }
    public String getZone() {
        return zone;
    }
    public String getState() {
        return state;
    }
    public String getUpdatedAt() {
        return updatedAt;
    }
    public String getHost() {
        return host;
    }
    @Override
    public boolean isValid() {
        return true;
    }
}