package com.ict.cloud.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class NodesDTO implements Serializable {
    private static final long serialVersionUID = -1813683114693865908L;
    /**  id  **/
    private Integer id;

    /**  实例UUID  **/
    private String instanceUuid;

    /**  UUID  **/
    private String uuid;

    /**  机器状态  **/
    private String provisionState;

    /**  电源状态  **/
    private String powerState;

    /**  CPU总数  **/
    private Integer vcpus;

    /**  内存总大小  **/
    private Integer memoryMb;

    /**  本地硬盘大小  **/
    private Integer localGb;

    /**  cpu架构  **/
    private String cpuArch;

    /**  GPU判断符  **/
    private Integer gpuFlag;

    /**  机器标示  **/
    private String machineFlag;
}
