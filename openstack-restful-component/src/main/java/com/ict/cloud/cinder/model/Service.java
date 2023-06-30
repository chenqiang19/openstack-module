package com.ict.cloud.cinder.model;

import com.ict.cloud.common.annotation.Entity;
import com.ict.cloud.common.annotation.Property;
import com.ict.cloud.common.model.AbstractEntity;
import org.json.JSONObject;

@Entity("service")
public class Service extends AbstractEntity {

    private static final long serialVersionUID = 1842209721982574472L;
    @Property
    private String status;
    @Property
    private String binary;
    @Property
    private String zone;
    @Property
    private String state;
    @Property("udpated_at")
    private String updatedAt;
    @Property
    private String host;
    @Property("disabled_reason")
    private String disabledReason;

    public Service() {
        super();
    }

    public Service(JSONObject service) {
        super(service);
        name = binary;
        id = name + "@" + host;
    }

    public Service(Object obj) {
        this(new JSONObject(obj.toString()));
    }

    public Service(String s) {
        this(new JSONObject(s));
    }

    public String getStatus() {
        return status;
    }

    public String getBinary() {
        return binary;
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

    public String getDisabledReason() {
        return disabledReason;
    }

    @Override
    public boolean isValid() {
        return true;
    }
}