package com.ict.cloud.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class MetaDataVO implements Serializable {
    private static final long serialVersionUID = 867115754473875952L;
    private String key;
    private String value;
}
