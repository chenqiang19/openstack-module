package com.ict.cloud.cinder.model;

import com.ict.cloud.common.annotation.Entity;
import com.ict.cloud.common.annotation.Property;
import com.ict.cloud.common.model.AbstractEntity;
import org.json.JSONObject;

@Entity("snapshot")
public class Snapshot extends AbstractEntity {
    private static final long serialVersionUID = 4603567375812289164L;

    @Property("volume_id")
    private String volumeId;
    @Property("display_description")
    private String description;
    @Property("display_name")
    private String name;
    @Property
    private boolean force;
    @Property
    private String status;
    @Property("create_at")
    private String createAt;
    @Property("updated_at")
    private String updatedAt;
    @Property("os-extended-snapshot-attributes:project_id")
    private String tenantId;
    @Property
    private int size;
    @Property
    private JSONObject metadata;
    @Property("os-extended-snapshot-attributes:progress")
    private String progress;
    public Snapshot() {
        this.force = false;
    }
    public Snapshot(JSONObject json) {
        super(json);
    }
    public Snapshot(Object obj) {
        this(new JSONObject(obj.toString()));
    }
    public Snapshot(String s) {
        this(new JSONObject(s));
    }
    @Override
    public boolean isValid() {
        return true;
    }
    public String getVolumeId() {
        return volumeId;
    }
    public String getDescription() {
        return description;
    }
    @Override
    public String getName() {
        return super.getName();
    }
    public boolean isForce() {
        return force;
    }
    public void setVolumeId(String volumeId) {
        this.volumeId = volumeId;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    public void setForce(boolean force) {
        this.force = force;
    }
    public String getStatus() {
        return status;
    }
    public String getCreateAt() {
        return createAt;
    }
    public String getUpdatedAt() {return updatedAt; }
    public String getTenantId() {
        return tenantId;
    }
    public int getSize() {
        return size;
    }
    public JSONObject getMetadata() {
        return metadata;
    }
    public String getProgress() {
        return progress;
    }
    public void setSize(Integer size) { this.size=size; }
    public void setStatus(String status) { this.status= status; }
}
