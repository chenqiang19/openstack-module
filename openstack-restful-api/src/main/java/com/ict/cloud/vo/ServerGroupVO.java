package com.ict.cloud.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ServerGroupVO implements Serializable {
    private static final long serialVersionUID = -5565417480811402931L;
    private String name;
    private String policy;
    private Integer instanceNum;
}
