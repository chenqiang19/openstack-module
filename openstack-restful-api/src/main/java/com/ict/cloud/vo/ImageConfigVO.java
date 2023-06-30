package com.ict.cloud.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ImageConfigVO implements Serializable {

    private static final long serialVersionUID = 5768599775355508462L;

    private Integer id;

    private String osAdminUser;

    private String imageName;

    private String type;

    private String imageStatus;

    private String imageVisibility;

    private Boolean protectedFlag;

    private String diskFormat;

    private String imageSize;

    private Integer minDiskSize;

    private Integer maxRamSize;

    private String imageId;
}
