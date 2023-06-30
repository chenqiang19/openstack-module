package com.ict.cloud.nova.api.v2;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.nova.model.Limit;
import com.ict.cloud.nova.api.LimitManager;

public class Limits extends AbstractManager<Limit> implements LimitManager{
	public Limits(Authenticated credentical) {
		super(credentical, Limit.class);
	}

	@Override
	public Limit get() throws OperationException {
		return super._get("/limits", "limits");
	}
}
