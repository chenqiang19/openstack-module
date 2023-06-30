package com.ict.cloud.cinder.api;

import com.ict.cloud.cinder.model.Limit;
import com.ict.cloud.common.exception.OperationException;

public interface LimitManager {
    Limit get() throws OperationException;
}
