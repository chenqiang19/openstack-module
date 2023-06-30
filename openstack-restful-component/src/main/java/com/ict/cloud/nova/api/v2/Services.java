package com.ict.cloud.nova.api.v2;

import java.util.List;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.nova.model.Service;
import org.json.JSONObject;

import com.ict.cloud.nova.api.ServiceManager;

public class Services extends AbstractManager<Service> implements ServiceManager {
	private final String PREFIX = "/os-services";
	public Services(Authenticated credentical) {
		super(credentical, Service.class);
	}
	@Override
	public List<Service> list() throws OperationException {
		return _list(PREFIX);
	}
	@Override
	public Service enable(String host, String binary) throws OperationException {
		JSONObject body = new JSONObject();
		body.put("host", host);
		body.put("binary", binary);
		return _update(PREFIX + "/enable", body);
	}
	@Override
	public Service disable(String host, String binary) throws OperationException {
		JSONObject body = new JSONObject();
		body.put("host", host);
		body.put("binary", binary);
		return _update(PREFIX + "/disable", body);
	}
	@Override
	public Service disableReason(String host, String binary, String reason) throws OperationException {
		JSONObject body = new JSONObject();
		body.put("host", host);
		body.put("binary", binary);
		body.put("disabled_reason", reason);
		return _update("PREFIX" + "disable-log-reason", body);
	}
}
