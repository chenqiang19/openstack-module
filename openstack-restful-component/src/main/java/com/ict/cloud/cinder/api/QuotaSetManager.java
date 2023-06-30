package com.ict.cloud.cinder.api;

import com.ict.cloud.cinder.model.QuotaSet;
import com.ict.cloud.common.exception.OperationException;

import java.util.List;

public interface QuotaSetManager {
    List<QuotaSet> list(String adminProjectId, String projectId) throws OperationException;
    QuotaSet update(String adminProjectId, String projectId, QuotaSet quota) throws OperationException;
    void delete(String adminProjectId, String projectId) throws OperationException;
}
