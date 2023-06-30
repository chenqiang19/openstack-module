package com.ict.cloud.nova.api;

import java.util.List;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.common.model.AbstractEntity;

public interface ReadOnlyManager<T extends AbstractEntity> extends BaseManager{
	T get(String id) throws OperationException;
	List<T> list() throws OperationException;
}
