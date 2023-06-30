package com.ict.cloud.nova.api.v2;

import java.util.List;

import com.ict.cloud.common.cache.EntityCacheManager;
import com.ict.cloud.common.cache.GroupCache;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.nova.model.Flavor;
import com.ict.cloud.nova.api.FlavorManager;

public class FlavorCached implements FlavorManager {
	private FlavorManager flavorManager;
	private GroupCache cache = EntityCacheManager.getInstance();
	public FlavorCached(FlavorManager flavorManager) {
		this.flavorManager = flavorManager;
	}
	@Override
	public List<Flavor> list() throws OperationException {
		return flavorManager.list();
	}
	@Override
	public Flavor get(String id) throws OperationException {
		return get(id, true);
	}
	public Flavor get(String id, boolean fromCache) throws OperationException {
		Flavor flavor = null;
		if (fromCache) {
			flavor = (Flavor)cache.get(id);
		}
		if (flavor == null) {
			flavor = flavorManager.get(id);
		}
		return flavor;
	}
	@Override
	public Flavor create(Flavor flavor) throws OperationException {
		return flavorManager.create(flavor);
	}
	@Override
	public void delete(String id) throws OperationException {
		flavorManager.delete(id);
	}

	@Override
	public Flavor update(Flavor flavor) throws OperationException {
		return flavorManager.update(flavor);
	}
}
