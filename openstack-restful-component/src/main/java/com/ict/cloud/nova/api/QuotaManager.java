package com.ict.cloud.nova.api;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.nova.model.Quota;

public interface QuotaManager {
	Quota getDefault() throws OperationException;
	Quota get(String tenantName, String username) throws OperationException;
	Quota get(String tenantName) throws OperationException;
	void delete(String tenantName, String username) throws OperationException;
	void delete(String tenantName) throws OperationException;
	Quota update(String tenantName, String username, Quota quota) throws OperationException;
	Quota update(String tenantName, Quota quota) throws OperationException;
	Quota update(Quota quota) throws OperationException;
	Quota create(String tenantName, String username, Quota quota) throws OperationException;
	Quota create(String tenantName, Quota quota) throws OperationException;
}
