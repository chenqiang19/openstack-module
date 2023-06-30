package com.ict.cloud.wapper;

import com.ict.cloud.cinder.model.Volume;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.model.SnapShotDTO;
import com.ict.cloud.model.VolumeDTO;
import com.ict.cloud.resource.domain.OpenstackVolumes;

import java.text.ParseException;
import java.util.List;

public interface IOpenstackObjectStorageService {
    /**
     * function: 更新卷的配额
     * @param adminProjectId 管理员的项目ID
     * @param projectId 操作用户的项目ID
     * */
    void updateVolumeQuotaSets(String adminProjectId, String projectId) throws OperationException;

    /**
     * function: 释放租户的数据卷
     * @param tenantId 租户ID，运营注册时分配
     * */
    List<String> releaseTenantVolume(Integer tenantId) throws OperationException;

    /**
     * function: 释放租户的数据卷
     * @param tenantId 租户ID，运营注册时分配
     * @param serverName 根据机器实例的名称释放机器挂载的数据卷
     * */
    void releaseTenantVolumeByServerName(Integer tenantId, String serverName) throws OperationException;

    /**
     * function: 释放租户的数据卷
     * @param tenantId 租户ID，运营注册时分配
     * @param serverIDS 根据机器实例的名称释放机器挂载的数据卷
     * */
    void releaseTenantVolumeByServerIDS(Integer tenantId, List<String> serverIDS) throws OperationException;

    /**
     * function: 新增云硬盘
     * @param tenantId 租户ID，运营注册时分配
     * @param volumes
     * */
    List<VolumeDTO> createDataVolume(Integer tenantId, List<Volume> volumes) throws OperationException;

    /**
     * function: 扩展云硬盘
     * @param tenantId 租户ID，运营注册时分配
     * @param volumeDTOS
     * */
    void extendDataVolume(Integer tenantId, List<VolumeDTO> volumeDTOS) throws OperationException;

    /**
     * function: 创建数据盘的快照
     * @param tenantId 租户ID，运营注册时分配
     * @param snapShptDTOS
     * */
    void createSnapShot(Integer tenantId, List<SnapShotDTO> snapShptDTOS) throws OperationException;

    /**
     * function: 获取用户的数据卷列表
     * @param tenantId 租户ID，运营注册时分配
     * */
    List<OpenstackVolumes> listVolumes(Integer tenantId) throws OperationException;

    /**
     * function: 删除卷
     * @param tenantId 租户ID，运营注册时分配
     * @param volumeIdList 卷的ID列表
     * */
    void deleteVolume(Integer tenantId, List<String> volumeIdList) throws OperationException;

    /**
     * function: 删除快照
     * @param tenantId 租户ID，运营注册时分配
     * @param snapShotIdList 快照的ID列表
     * */
    void deleteSnapShot(Integer tenantId, List<String> snapShotIdList) throws OperationException;

    /**
     * function: 同步底层的快照
     * */
    boolean updateOpenstackSnapshotToDB() throws OperationException, ParseException;
}
