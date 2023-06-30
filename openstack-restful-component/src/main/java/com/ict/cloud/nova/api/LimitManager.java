package com.ict.cloud.nova.api;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.nova.model.Limit;

public interface LimitManager {
	Limit get() throws OperationException;
}
