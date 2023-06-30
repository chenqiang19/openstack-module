package com.ict.cloud.nova.api;

import java.util.List;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.nova.model.Version;

public interface VersionManager {
	List<Version> list() throws OperationException;
}
