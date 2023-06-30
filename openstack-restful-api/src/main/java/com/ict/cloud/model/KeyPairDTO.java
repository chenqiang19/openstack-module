package com.ict.cloud.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class KeyPairDTO implements Serializable {
    private static final long serialVersionUID = 6577490592885900559L;
    /** 密钥对名称 */
    String name;
    /** 密钥对公钥 */
    String publicKey;
    /** 密钥对类型 */
    String type;
    /** 密钥对用户ID，支持管理员给制定的用户分配密钥对 */
    String userId;
    /** 密钥对的指纹 */
    String fingerPrint;
    /** 用户私钥 */
    String privateKey;
    /** 用户ID */
    Integer tenantId;
    /** 扩展字段 */
    Integer extend;
}
