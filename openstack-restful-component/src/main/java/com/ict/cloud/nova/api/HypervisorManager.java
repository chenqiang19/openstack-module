package com.ict.cloud.nova.api;

import java.util.List;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.nova.model.Hypervisor;
import com.ict.cloud.nova.model.HypervisorStatistics;

public interface HypervisorManager 	{
	List<Hypervisor> list() throws OperationException;
	Hypervisor get(String id) throws OperationException;
	Hypervisor.Uptime uptime(String id) throws OperationException;
	HypervisorStatistics stats() throws OperationException;
}
