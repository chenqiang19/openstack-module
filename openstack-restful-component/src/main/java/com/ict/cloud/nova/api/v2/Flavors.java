package com.ict.cloud.nova.api.v2;

import java.util.List;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.nova.model.Flavor;
import com.ict.cloud.nova.api.FlavorManager;

public class Flavors extends AbstractManager<Flavor> implements FlavorManager{
	private final String PREFIX = "/flavors";
	public Flavors(Authenticated credentical) {
		super(credentical, Flavor.class);
	}
	/**
	 * Get a list of all flavors
	 * @return A List , which holds flavors
	 * @throws OperationException
	 */
	@Override
	public List<Flavor> list() throws OperationException {
		//return _list(PREFIX + "/detail");
		return _list(PREFIX);
	}
	/**
	 * Get a specific Flavor.
	 * @param id The ID of Flavor to get. 
	 * @return Flavor
	 * @throws OperationException
	 */
	@Override
	public Flavor get(String id) throws OperationException {
		return _get(PREFIX + "/" + id);
	}
	/**
	 * Delete a specific Flavor.
	 * @param id The ID of Flavor to delete.
	 * @throws OperationException
	 */
	@Override
	public void delete(String id) throws OperationException {
		_delete("/flavors/" + id);
	}

	/**
	 * create a new flavor for a tenant
	 * @param flavor The flavor to create
	 * @return The new flavor
	 * @throws OperationException
	 */
	@Override
	public Flavor create(Flavor flavor) throws OperationException {
		return _create("/flavors", flavor);
	}
	/**
	 * update a flavor
	 * @param flavor the flavor to update, with a some new property except id.
	 * @return The updated flavor
	 * @throws OperationException
	 */
	@Override
	public Flavor update(Flavor flavor) throws OperationException {
		return _update(PREFIX+"/"+flavor.getId(), flavor);
	}

}
