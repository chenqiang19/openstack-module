package com.ict.cloud.nova.api.v2;

import java.util.List;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.nova.model.Hypervisor;
import com.ict.cloud.nova.model.HypervisorStatistics;
import com.ict.cloud.nova.api.HypervisorManager;

public class Hypervisors extends AbstractManager<Hypervisor> implements HypervisorManager {
	private final String PREFIX = "/os-hypervisors";
	public Hypervisors(Authenticated credentical) {
		super(credentical, Hypervisor.class);
	}
	@Override
	public List<Hypervisor> list() throws OperationException {
		return _list(PREFIX + "/detail");
	}
	@Override
	public Hypervisor get(String id) throws OperationException {
		return _get(PREFIX + "/" + id);
	}
	@Override
	public Hypervisor.Uptime uptime(String id) throws OperationException {
		return new Uptimes(credentical).uptime(id);
	}
	@Override
	public HypervisorStatistics stats() throws OperationException {
		return new Statistics(credentical).stats();
	}
	public static class Uptimes extends AbstractManager<Hypervisor.Uptime> {
		public Uptimes(Authenticated credentical) {
			super(credentical, Hypervisor.Uptime.class);
		}
		public Hypervisor.Uptime uptime(String id) throws OperationException {
			String api = "/os-hypervisors/%s/uptime";
			return _get(String.format(api, id), "hypervisor");
		}
	}
	public static class Statistics extends AbstractManager<HypervisorStatistics> {
		public Statistics(Authenticated credentical) {
			super(credentical,HypervisorStatistics.class);
		}
		public HypervisorStatistics stats() throws OperationException {
			return _get("/os-hypervisors/statistics");
		}
	}
}
