package com.ict.cloud.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddressDTO implements Serializable {
    private static final long serialVersionUID = 8848886749081752353L;
    private String macAddr;

    private String addr;

    private int version;

    private String type;
}
