package com.ict.cloud.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ServerDTO implements Serializable {
    private static final long serialVersionUID = -6490434709781749L;
    private String id;

    private String name;

    private String status;

    private String updated;

    private String hostId;

    private String host;

    private String keyName;

    private String taskState;

    private String vmState;

    private String instanceName;

    private String launchedAt;

    private String hypervisorHostname;

    private String terminatedAt;

    private String availabilityZone;

    private String userId;

    private String created;

    private String tenantId;

    private String diskConfig;

    private List<String> volumesAttached;

    private String accessIPv4;

    private String accessIPv6;

    private Integer powerState;

    private Boolean configDrive;

    private String imageRef;

    private String flavorRef;

    private String adminPass;

    private int minCount = 1;

    private int maxCount = 1;

    private String userData;

    private String instance_uuid;

    private List<AddressDTO> addresses;

    private List<ServerSnapShotDTO> snapShots;

    private List<ServerNetworkDTO> serverNetworks;

    private List<ServerGroupDTO> serverGroupDTOS;
}
