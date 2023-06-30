package com.ict.cloud.resource.domain;

import lombok.Data;

/**
 * Openstack模板
 **/
@Data
public class OpenstackKeyPairs {
    /**  唯一标识ID  **/
    private Integer id;

    /**  密钥对名称  **/
    private String keypairName;

    /**  密钥对公钥  **/
    private String keypairPublicKey;

    /**  密钥对指纹  **/
    private String keypairFingerprint;

    /**  密钥对用户ID  **/
    private String keypairUserId;

    /**  密钥对私钥  **/
    private String keypairPrivateKey;

    /**  密钥对类型  **/
    private String keypairType;

    /**  用户ID  **/
    private Integer tenantId;

    /**  扩展字段  **/
    private Integer extend;
}
