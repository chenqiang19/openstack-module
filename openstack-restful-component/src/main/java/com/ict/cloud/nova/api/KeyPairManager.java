package com.ict.cloud.nova.api;

import java.util.List;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.nova.model.KeyPair;

public interface KeyPairManager {
	KeyPair create(String name, String type) throws OperationException;
	KeyPair create(String name, String publicKey, String type) throws OperationException;
	void delete(String name) throws OperationException;
	List<KeyPair> list() throws OperationException;
	KeyPair get(String name) throws OperationException;
	
}
