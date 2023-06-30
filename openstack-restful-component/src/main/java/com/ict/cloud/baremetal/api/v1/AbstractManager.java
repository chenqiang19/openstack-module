package com.ict.cloud.baremetal.api.v1;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.common.Bean.SpringBeanUtils;
import com.ict.cloud.common.Manager;
import com.ict.cloud.common.model.AbstractEntity;
import com.ict.cloud.configure.OpenstackConfig;
import com.ict.cloud.keystone.model.CatalogType;

public class AbstractManager<T extends AbstractEntity> extends Manager<T> {

    private OpenstackConfig openstackConfig = SpringBeanUtils.getBean(OpenstackConfig.class);

    public AbstractManager(Authenticated credentical, Class<T> objClass) {
        super(credentical, objClass);
    }
    @Override
    public String getEndpoint() {
        String endpoint = credentical.getEndpoint(CatalogType.baremetal);
        if(endpoint.contains("baremetal")){
            return endpoint.replace("baremetal",openstackConfig.getIp());
        }else {
            return endpoint;
        }
    }
}
