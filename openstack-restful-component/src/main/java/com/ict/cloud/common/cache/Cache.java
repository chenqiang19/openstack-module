package com.ict.cloud.common.cache;

public interface Cache {
    Object get(Object id);
    Object put(Object id, Object obj);
}

