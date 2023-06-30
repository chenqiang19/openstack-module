package com.ict.cloud.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AggregateDTO implements Serializable {
    private static final long serialVersionUID = 4391384308610392842L;

    private String id;

    private String aggregateName;

    private String availabilityZone;

    private Integer aggregateId;

    private List<String> hostList;
}
