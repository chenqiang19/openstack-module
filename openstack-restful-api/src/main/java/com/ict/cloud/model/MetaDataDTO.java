package com.ict.cloud.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class MetaDataDTO implements Serializable {
    private String key;
    private String value;
}
