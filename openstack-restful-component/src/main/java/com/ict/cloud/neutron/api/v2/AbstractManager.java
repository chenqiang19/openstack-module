package com.ict.cloud.neutron.api.v2;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.common.Bean.SpringBeanUtils;
import com.ict.cloud.common.Manager;
import com.ict.cloud.common.model.AbstractEntity;
import com.ict.cloud.configure.OpenstackConfig;
import com.ict.cloud.keystone.model.CatalogType;

public abstract class AbstractManager<T extends AbstractEntity> extends Manager<T> {

    private OpenstackConfig openStackConfig = SpringBeanUtils.getBean(OpenstackConfig.class);

    public AbstractManager(Authenticated credential, Class<T> objClass) { super(credential,objClass); }

    @Override
    public String getEndpoint() {
        String endpoint = credentical.getEndpoint(CatalogType.network);
        if(endpoint.contains("controller")){
            return endpoint.replace("controller",openStackConfig.getIp()).replace("10.101.1.253", "192.20.4.253");
        }else {
            return endpoint.replace("10.101.1.253", "192.20.4.253");
        }
    }
}
