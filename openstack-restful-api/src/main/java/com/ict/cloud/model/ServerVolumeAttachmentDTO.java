package com.ict.cloud.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ServerVolumeAttachmentDTO implements Serializable {
    private static final long serialVersionUID = 3161611418751779076L;
    private String volumeId;

    private String device;

    private String attachmentId;
}
