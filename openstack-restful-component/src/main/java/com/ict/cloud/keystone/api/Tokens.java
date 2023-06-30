package com.ict.cloud.keystone.api;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.common.Bean.SpringBeanUtils;
import com.ict.cloud.configure.OpenstackConfig;
import com.ict.cloud.keystone.model.*;

import java.util.Set;

import com.ict.cloud.common.exception.AuthenticationException;
import com.ict.cloud.common.exception.OperationException;

public class Tokens extends AbstractManager<Access> implements TokenManager{

    private OpenstackConfig openStackConfig = SpringBeanUtils.getBean(OpenstackConfig.class);

    public Tokens() {
        /** 还没有认证，无法获取证书，所以创建了一个伪证书 **/
        super(new FakeCredentical(), Access.class);
    }
    public Tokens(Authenticated credentical) {
        super(credentical, Access.class);
    }
    @Override
    public Access authenticate(Secret secret) throws OperationException{
        if (!secret.isValid()) {
            throw new AuthenticationException("The secret is invalid!");
        }
        return super._create("/auth/tokens", secret);
    }
    @Override
    public void destroy(String id) throws OperationException {
        /* FIXME 每次请求，无论成功还是失败，都会抛出异常，直接忽略 */
        try {
            super._delete("/tokens/" + id);
        } catch (Exception ignore) {

        }
    }
    /** 返回认证url，由配置文件指定 **/
    @Override
    public String getEndpoint() {
        String value = openStackConfig.getUrl();
        if (value == null) {
            throw new RuntimeException("Failed to get auth url!");
        }
        return value;
    }
    /** 伪证书，请勿使用！！！  **/
    private static class FakeCredentical implements Authenticated {
        @Override
        public String getTokenId() {
            return null;
        }

        @Override
        public User getUser() {
            return null;
        }

        @Override
        public Tenant getTenant() {
            return null;
        }

        @Override
        public String getEndpoint(CatalogType type) {
            return null;
        }

        @Override
        public String getWorkRegion() {
            return null;
        }

        @Override
        public void setWorkRegion(String region) {

        }

        @Override
        public Token getToken() {
            return null;
        }

        @Override
        public Set<String> getRegions() {
            return null;
        }

        @Override
        public String getServerId(String key) { return null; }

        @Override
        public String getBareMetalID() { return null; }
    }
}
