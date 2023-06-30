package com.ict.cloud.cinder.api.v3;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.cinder.api.QuotaSetManager;
import com.ict.cloud.cinder.model.QuotaSet;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.tools.StringUtils;

import java.util.List;

public class QuotaSets extends AbstractManager<QuotaSet> implements QuotaSetManager {
    private static final String PREFIX = "/os-quota-sets/%s";

    public QuotaSets(Authenticated credentical) {
        super(credentical, QuotaSet.class);
    }

    private String format(String adminProjectId, String projectId, String usage) {
        String url = String.format(PREFIX, projectId);
        if (StringUtils.isNotBlank(usage)) {
            url += usage + "=True";
        }
        return url;
    }
    @Override
    public List<QuotaSet> list(String adminProjectId, String projectId) throws OperationException {
        return super._list(format(adminProjectId, projectId, null));
    }

    @Override
    public QuotaSet update(String adminProjectId, String projectId, QuotaSet quota) throws OperationException {
        return super._update(format(adminProjectId, projectId, null), quota);
    }

    @Override
    public void delete(String adminProjectId, String projectId) throws OperationException {
        super._delete(format(adminProjectId, projectId, null));
    }
}
