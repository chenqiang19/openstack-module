package com.ict.cloud.common.request;

import java.util.Set;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.authentication.AuthenticatedRequest;
import com.ict.cloud.keystone.model.CatalogType;
import com.ict.cloud.keystone.model.Tenant;
import com.ict.cloud.keystone.model.Token;
import com.ict.cloud.keystone.model.User;

public class OpenstackHTTPClient  extends HTTPRequest implements AuthenticatedRequest {
	protected Authenticated session = null;
	public OpenstackHTTPClient(Authenticated session) {
		this.session = session;
	}
	@Override
	public String getTokenId() {
		return session.getTokenId();
	}
	@Override
	public User getUser() {
		return session.getUser();
	}
	@Override
	public Tenant getTenant() {
		return session.getTenant();
	}
	@Override
	public String getBareMetalID(){
		return session.getBareMetalID();
	}
	@Override
	public void before() {
		clean();
		setHeader("Content-Type", "application/json");
		setHeader("Accept", "application/json");
		setHeader("Accept-Encoding", "gzip,deflate,br");
		setHeader("X-OpenStack-Nova-API-Version", "2.79");
		if (getTenant() != null) {
			setHeader("X-Auth-Token", getTokenId());
		}
	}
	@Override 
	public void before(Header header) {
		clean();
		setHeader(header);
		if (getTenant() != null) {
			setHeader("X-Auth-Token", getTokenId());
		}
	}
	@Override
	public void close() throws Exception {
		super.close();
		if (session instanceof AutoCloseable) {
			((AutoCloseable) session).close();
		}
	}
	@Override
	public String getEndpoint(CatalogType type) {
		return session.getEndpoint(type);
	}
	@Override
	public String getWorkRegion() {
		return session.getWorkRegion();
	}
	@Override
	public void setWorkRegion(String region) {
		session.setWorkRegion(region);
	}
	@Override
	public Set<String> getRegions() {
		return session.getRegions();
	}
	@Override
	public  String getServerId(String key) { return session.getServerId(key); }
	@Override
	public Token getToken() { return session.getToken(); }
}
