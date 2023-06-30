package com.ict.cloud.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SecurityGroupVO implements Serializable {
    private static final long serialVersionUID = 8424418210671506221L;
    private String name;
    private String securityId;
}
