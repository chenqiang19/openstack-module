package com.ict.cloud.nova.api;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.common.model.AbstractEntity;

public interface ReadWriteManager<T extends AbstractEntity> extends ReadOnlyManager<T> {
	T create(T entity) throws OperationException;
	void update(T entity) throws OperationException;
	void delete(String id) throws OperationException;
}
