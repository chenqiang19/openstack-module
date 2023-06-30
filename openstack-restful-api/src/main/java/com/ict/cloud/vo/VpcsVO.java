package com.ict.cloud.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class VpcsVO implements Serializable {
    private static final long serialVersionUID = 2717790203545208965L;

    private String name;
    private String segment;
    private String status;
    private Integer subnetNum;
    private String routerName;
    private Integer instanceNum;
    private String operate;
}
