package com.ict.cloud.rpc;

import com.ict.cloud.model.SnapShotDTO;
import com.ict.cloud.model.VolumeDTO;
import com.ict.cloud.result.Result;

import java.util.List;

/**
 * @Author CQ
 * @Date 2022/06/08
 * @Description Openstack块存储对外RPC接口定义
 * */
public interface BlockStorageApiService {
    /**
     * function: 更新卷的配额
     * @param adminProjectId 管理员的项目ID
     * @param projectId 操作用户的项目ID
     * */
    Result<Boolean> updateVolumeQuotaSets(String adminProjectId, String projectId);

    /**
     * function: 释放租户的数据卷
     * @param tenantId 租户ID，运营注册时分配
     * */
    Result<List<String>> releaseTenantVolume(Integer tenantId);

    /**
     * function: 释放租户的数据卷
     * @param tenantId 租户ID，运营注册时分配
     * @param serverName 根据机器实例的名称释放机器挂载的数据卷
     * */
    Result<Boolean> releaseTenantVolumeByServerName(Integer tenantId, String serverName);

    /**
     * function: 释放租户的数据卷
     * @param tenantId 租户ID，运营注册时分配
     * @param serverIDS 根据机器实例的名称释放机器挂载的数据卷
     * */
    Result<Boolean> releaseTenantVolumeByServerIDS(Integer tenantId,  List<String> serverIDS);

    /**
     * function: 新增云硬盘
     * @param tenantId 租户ID，运营注册时分配
     * @param volumes
     * */
    Result<List<VolumeDTO>> createDataVolume(Integer tenantId, List<VolumeDTO> volumes);

    /**
     * function: 扩展云硬盘
     * @param tenantId 租户ID，运营注册时分配
     * @param volumeDTOS
     * */
    Result<Boolean> extendDataVolume(Integer tenantId, List<VolumeDTO> volumeDTOS);

    /**
     * function: 创建数据盘的快照
     * @param tenantId 租户ID，运营注册时分配
     * @param snapShptDTOS
     * */
    Result<Boolean> createSnapShot(Integer tenantId, List<SnapShotDTO> snapShptDTOS);

    /**
     * function: 获取用户的数据卷列表
     * @param tenantId 租户ID，运营注册时分配
     * */
    Result<List<VolumeDTO>> listVolumes(Integer tenantId);

    /**
     * function: 删除卷
     * @param tenantId 租户ID，运营注册时分配
     * @param volumeIdList 卷的ID列表
     * */
    Result<Boolean> deleteVolume(Integer tenantId, List<String> volumeIdList);

    /**
     * function: 删除快照
     * @param tenantId 租户ID，运营注册时分配
     * @param snapShotIdList 快照的ID列表
     * */
    Result<Boolean> deleteSnapShot(Integer tenantId, List<String> snapShotIdList);

    /**
     * function: 同步底层的快照
     * */
    Result<Boolean> updateOpenstackSnapshotToDB();
}
