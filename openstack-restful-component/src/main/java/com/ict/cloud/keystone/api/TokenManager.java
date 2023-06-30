package com.ict.cloud.keystone.api;

import com.ict.cloud.keystone.model.Access;
import com.ict.cloud.keystone.model.Secret;
import com.ict.cloud.common.exception.OperationException;

public interface TokenManager {
    /**
     * 认证接口，返回一个Access实例，Access封装了token
     * @param secret 封装用户名、密码、token
     * @return 返回Access实例
     * @throws OperationException
     */
    Access authenticate(Secret secret) throws OperationException;
    /**
     * 销毁证书
     * @param id 证书的id
     * @throws OperationException
     */
    void destroy(String id) throws OperationException;
}
