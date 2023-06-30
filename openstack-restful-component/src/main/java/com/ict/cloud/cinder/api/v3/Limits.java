package com.ict.cloud.cinder.api.v3;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.cinder.model.Limit;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.cinder.api.LimitManager;

public class Limits extends AbstractManager<Limit> implements LimitManager {

    public Limits(Authenticated credentical) {
        super(credentical, Limit.class);
    }

    @Override
    public Limit get() throws OperationException {
        return _get("/limits");
    }

}
