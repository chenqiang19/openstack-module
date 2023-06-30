package com.ict.cloud.keystone.api;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.keystone.model.CatalogType;
import com.ict.cloud.common.Manager;
import com.ict.cloud.common.model.AbstractEntity;

public abstract class AbstractManager<T extends AbstractEntity> extends Manager<T> {
    public AbstractManager(Authenticated credentical, Class<T> objClass) {
        super(credentical, objClass);
    }
    @Override
    public String getEndpoint() {
        return credentical.getEndpoint(CatalogType.identity).replace("10.101.1.253", "192.20.4.253");
    }
}
