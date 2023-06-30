package com.ict.cloud.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BackUpDTO implements Serializable {
    private static final long serialVersionUID = 4120587932300643594L;
    private String name;
    private String description;
    private String volumeId;
    private Boolean incremental;
}
