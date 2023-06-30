package com.ict.cloud.cinder.model;

import com.ict.cloud.common.annotation.Entity;
import com.ict.cloud.common.annotation.Property;
import com.ict.cloud.common.model.AbstractEntity;
import org.json.JSONObject;

@Entity("volume_type")
public class VolumeType extends AbstractEntity {
    /**
     *
     */
    private static final long serialVersionUID = -6539238104579991330L;
    @Property("extra_specs")
    private JSONObject metadata;
    public VolumeType() {
        super();
    }
    public VolumeType(JSONObject json) {
        super(json);
    }
    public VolumeType(Object obj) {
        this(new JSONObject(obj.toString()));
    }
    public VolumeType(String s) {
        this(new JSONObject(s));
    }
    @Override
    public boolean isValid() {
        return true;
    }
    public JSONObject getMetadata() {
        return metadata;
    }
}
