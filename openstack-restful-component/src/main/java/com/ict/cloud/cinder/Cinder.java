package com.ict.cloud.cinder;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.cinder.api.*;
import com.ict.cloud.cinder.api.v3.*;
import com.ict.cloud.common.Client;

public class Cinder extends Client {
    public final VolumeManager volumes;
    public final VolumeTypeManager types;
    public final ServiceManager services;
    public final SnapshotManager snapshots;
    public final LimitManager limits;
    public final QuotaSetManager quotasets;
    public Cinder(Authenticated credentical) {
        super(credentical);
        volumes = new Volumes(credentical);
        types = new Types(credentical);
        services = new Services(credentical);
        snapshots = new Snapshots(credentical);
        limits = new Limits(credentical);
        quotasets = new QuotaSets(credentical);
    }
}