package com.ict.cloud.nova;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.common.Client;
import com.ict.cloud.image.api.v2.Images;
import com.ict.cloud.nova.api.*;
import com.ict.cloud.nova.api.v2.*;

public class Nova extends Client {
	public final FlavorManager flavors;
	public final HypervisorManager hypervisors;
	public final ServiceManager services;
	public final ServerManager servers;
	public final KeyPairManager keypairs;
	public final VersionManager versions;
	public final LimitManager limits;
	public final QuotaManager quotas;
	public final AggregateManager aggregates;
	public final ExtraSpecsManager extraSpecs;
	public final ServerGroupManager serverGroups;
	public final AvailabilityZoneManager availabilityZones;
	public Nova(Authenticated credentical) {
		super(credentical);
		flavors = new Flavors(credentical);
		hypervisors = new Hypervisors(credentical);
		services = new Services(credentical);
		servers = new Servers(credentical);
		keypairs = new KeyPairs(credentical);
		versions = new Versions(credentical);
		limits = new Limits(credentical);
		quotas = new Quotas(credentical);
		aggregates = new Aggregates(credentical);
		extraSpecs = new ExtraSpecs(credentical);
		serverGroups = new ServerGroups(credentical);
		availabilityZones = new AvailabilityZones(credentical);
	}
}

