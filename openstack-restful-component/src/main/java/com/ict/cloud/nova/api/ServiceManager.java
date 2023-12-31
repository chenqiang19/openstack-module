package com.ict.cloud.nova.api;
import java.util.List;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.nova.model.Service;

public interface ServiceManager {
	List<Service> list() throws OperationException;
	Service enable(String host, String binary) throws OperationException;
	Service disable(String host, String binary) throws OperationException;
	Service disableReason(String host, String binary, String reason) throws OperationException;
}
