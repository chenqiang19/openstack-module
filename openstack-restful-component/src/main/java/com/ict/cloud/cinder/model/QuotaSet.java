package com.ict.cloud.cinder.model;

import com.ict.cloud.common.annotation.Entity;
import com.ict.cloud.common.annotation.Property;
import com.ict.cloud.common.model.AbstractEntity;
import org.json.JSONObject;

@Entity("quota_set")
public class QuotaSet extends AbstractEntity {

    public static final Integer DEFAULT_VALUE = -1;

    @Property
    private Integer volumes;
    @Property
    private Integer snapshots;
    @Property
    private Integer backups;
    @Property
    private Integer groups;
    @Property
    private Integer per_volume_gigabytes;
    @Property
    private Integer gigabytes;
    @Property
    private Integer backup_gigabytes;

    public QuotaSet() {
        super();
        this.volumes = DEFAULT_VALUE;
        this.gigabytes = DEFAULT_VALUE;
        this.groups = DEFAULT_VALUE;
        this.backups = DEFAULT_VALUE;
        this.backup_gigabytes =DEFAULT_VALUE;
        this.snapshots = DEFAULT_VALUE;
    }
    public QuotaSet(JSONObject json) {
        super(json);
    }
    public QuotaSet(Object obj) {
        this(new JSONObject(obj.toString()));
    }

    public Integer getVolumes() { return this.volumes; }
    public void setVolumes(Integer volumes) { this.volumes = volumes; }

    public Integer getSnapshots() { return this.snapshots; }
    public void setSnapshots(Integer snapshots) { this.snapshots = snapshots; }

    public Integer getBackups() { return this.backups; }
    public void setBackups(Integer backups) { this.backups = backups; }

    public Integer getGroups() { return this.groups; }
    public void setGroups(Integer groups) { this.groups = groups; }

    public Integer getPer_volume_gigabytes() { return this.per_volume_gigabytes; }
    public void setPer_volume_gigabytes(Integer per_volume_gigabytes) { this.per_volume_gigabytes = per_volume_gigabytes; }

    public Integer getGigabytes() { return this.gigabytes; }
    public void setGigabytes(Integer gigabytes) { this.gigabytes = gigabytes; }

    public Integer getBackup_gigabytes() { return this.backup_gigabytes; }
    public void setBackup_gigabytes(Integer backup_gigabytes) { this.backup_gigabytes = backup_gigabytes; }

    @Override
    public boolean isValid() {
        return false;
    }
}
