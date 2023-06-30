package com.ict.cloud.nova.api.v2;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.nova.model.Quota;
import com.ict.cloud.tools.StringUtils;
import com.ict.cloud.nova.api.QuotaManager;

public class Quotas extends AbstractManager<Quota> implements QuotaManager {
	private static final String PREFIX = "/os-quota-sets";
	public Quotas(Authenticated credentical) {
		super(credentical, Quota.class);
	}
	@Override
	public Quota getDefault() throws OperationException {
		//String url = PREFIX + "/" + credentical.getTenant().getId() + "/defaults";
		StringBuilder url = new StringBuilder();
		url.append(PREFIX).append("/").append(credentical.getTenant().getId()).append("/defaults");
		return super._get(String.valueOf(url));
	}
	private String format(String projectId, String userId) {
//		String url = PREFIX + "/" + projectId;
//		if (StringUtils.isNotBlank(userId)) {
//			url += "?user_id=" + userId;
//		}
		StringBuilder url = new StringBuilder();
		url.append(PREFIX).append("/").append(projectId);
		if (StringUtils.isNotBlank(userId)) {
			url.append("?user_id=").append(userId);
		}
		return String.valueOf(url);
	}
	@Override
	public Quota get(String tenantName, String username) throws OperationException {
		String url = format(tenantName, username);
		return _get(url);
	}

	@Override
	public void delete(String tenantName, String username)
			throws OperationException {
		String url = format(tenantName, username);
		_delete(url);
	}

	@Override
	public Quota update(String projectId, String userId, Quota quota) throws OperationException {
		String url = format(projectId, userId);
		return super._update(url, quota);
	}

	@Override
	public Quota create(String projectId, String userId, Quota quota) throws OperationException {
		return update(projectId, userId, quota);
	}
	@Override
	public Quota get(String projectId) throws OperationException {
		return get(projectId, null);
	}
	@Override
	public void delete(String projectId) throws OperationException {
		delete(projectId, null);
		
	}
	@Override
	public Quota update(String projectId, Quota quota) throws OperationException {
		return update(projectId, null, quota);
	}
	@Override
	public Quota update(Quota quota) throws OperationException {
		return update(credentical.getTenant().getName(), credentical.getUser().getName(), quota);
	}
	@Override
	public Quota create(String projectId, Quota quota) throws OperationException {
		return create(projectId, null, quota);
	}
	
}
