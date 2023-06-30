package com.ict.cloud.nova.api.v2;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.nova.api.ExtraSpecsManager;
import com.ict.cloud.nova.model.ExtraSpec;

public class ExtraSpecs extends AbstractManager<ExtraSpec> implements ExtraSpecsManager {
    public ExtraSpecs(Authenticated credentical) {
        super(credentical, ExtraSpec.class);
    }

    @Override
    public ExtraSpec getFlavorExtraSpecs(String flavorId) throws OperationException {
        StringBuilder url = new StringBuilder();
        url.append("/flavors/");
        url.append(flavorId);
        url.append("/os-extra_specs");
        return _get(String.valueOf(url));
    }

    @Override
    public ExtraSpec createFlavorExtraSpecs(ExtraSpec extraSpec, String flavorId) throws OperationException {
        StringBuilder url = new StringBuilder();
        url.append("/flavors/");
        url.append(flavorId);
        url.append("/os-extra_specs");
        return _create(String.valueOf(url), extraSpec);
    }
}
