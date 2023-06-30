package com.ict.cloud.nova.api;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.nova.model.ExtraSpec;

public interface ExtraSpecsManager {
    ExtraSpec getFlavorExtraSpecs(String flavorId) throws OperationException;

    ExtraSpec createFlavorExtraSpecs(ExtraSpec extraSpec, String flavorId) throws OperationException;
}
