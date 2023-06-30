package com.ict.cloud.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AggregateVO implements Serializable {
    private static final long serialVersionUID = 8563961271857789745L;
    private String id;
    private String name;
    private String availabilityZone;
    private List<String> hosts;
    private String metadata;
}
