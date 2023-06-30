package com.ict.cloud.nova.api.v2;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.common.Bean.SpringBeanUtils;
import com.ict.cloud.common.Manager;
import com.ict.cloud.common.model.AbstractEntity;
import com.ict.cloud.configure.OpenstackConfig;
import com.ict.cloud.keystone.model.CatalogType;

public class AbstractManager<T extends AbstractEntity> extends Manager<T> {

	private OpenstackConfig openStackConfig = SpringBeanUtils.getBean(OpenstackConfig.class);

	public AbstractManager(Authenticated credentical, Class<T> objClass) {
		super(credentical, objClass);
	}
	@Override
	public String getEndpoint() {
		String endpoint = credentical.getEndpoint(CatalogType.compute);
		if(endpoint.contains("controller")){
			return endpoint.replace("controller",openStackConfig.getIp()).replace("10.101.1.253", "192.20.4.253");
		}else {
			return endpoint.replace("10.101.1.253", "192.20.4.253");
		}
	}
}
