package com.ict.cloud.common.cache;

public interface GroupCache extends Cache{
    Object get(Object id, String group);
    Object put(Object id, Object obj, String group);
}
