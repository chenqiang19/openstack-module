package com.ict.cloud.nova.api;

import java.util.List;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.nova.model.Flavor;

public interface FlavorManager{
	List <Flavor> list() throws OperationException;
	Flavor get(String id)throws OperationException;
	Flavor update(Flavor entity) throws OperationException;
	Flavor create(Flavor entity) throws OperationException;
	void delete(String id) throws OperationException;
}
