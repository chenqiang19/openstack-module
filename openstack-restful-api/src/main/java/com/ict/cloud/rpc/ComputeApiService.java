package com.ict.cloud.rpc;

import com.ict.cloud.model.*;
import com.ict.cloud.result.Result;
import com.ict.cloud.vo.AggregateVO;
import com.ict.cloud.vo.ImageConfigVO;

import java.util.List;

/**
 * @Author CQ
 * @Date 2022/06/08
 * @Description Openstack计算组件对外RPC接口定义
 * */
public interface ComputeApiService {
    /**
     * function: 开机
     * @param serverId 机器实例id
     * */
    Result bootInstance(Integer tenantId, String serverId);
    /**
     * function: 重启
     * @param serverId 机器实例id
     * */
    Result rebootInstance(Integer tenantId, String serverId);
    /**
     * function: 关机
     * @param serverId 机器实例id
     * */
    Result stopInstance(Integer tenantId, String serverId);
    /**
     * function: 删除机器
     * @param serverId 机器实例id
     * */
    Result removeInstance(Integer tenantId, String serverId);
    /**
     * function: 修改机器密码
     * @param serverId 机器实例id
     * */
    Result<Boolean> changeInstancePassword(Integer tenantId, String serverId, String newPassword);

    /**
     * function: 获取计算服务
     * @param serverId 机器实例id
     * */
    Result<ServerDTO> getServerById(Integer tenantId, String serverId);

    /**
     * function: 获取Spice类型的控制台界面
     * @param serverId 机器实例id
     * @param type 获取的类型
     * */
    Result<String> getSpiceConsole(Integer tenantId, String serverId, String type);

    /**
     * function: 创建密钥对
     * @param keyPairDTO 密钥对信息
     * */
    Result createKeyPair(KeyPairDTO keyPairDTO, Integer tenantId);

    /**
     * function: 获取密钥对
     * @param tenantId 用户ID
     * @param keyPairName 密钥名称
     * */
    Result<List<KeyPairDTO>> getKeyPairs(Integer tenantId, String keyPairName);

    /**
     * function: 释放用户的机器
     * @param tenantId 用户ID
     * @param instanceIDS 待释放的机器ID，可同时释放多台
     * @param logoutFlag 区分是不是注销，注销除了释放已选择的，还需要释放其余的
     * */
    Result releaseTenantInstance(Integer tenantId, List<String> instanceIDS, Boolean logoutFlag);

    /**
     * function: 同步底层的资源
     * */
    Result<Boolean> updateOpenstackResourceToDB();

    /**
     * function: 同步底层的规格
     * */
    Result<Boolean> updateOpenstackFlavorToDB();

    /**
     * function: 获取底层的资源
     * */
    Result<List<ResourceDTO>> getOpenstackResources();

    Result<ResourceDTO> getResourceTotal();

    /**
     * function: 更新计算配额
     * @param projectId 项目id
     * */
    Result<Boolean> updateNovaQuotaSets(String projectId);

    /**
     * function: 统计指定服务名称的机器数量
     * @param tenantId
     * @param serverName
     * */
    Result<Integer> countServerByTenantAndServerName(Integer tenantId, String serverName);

    /**
     * function: 获取底层规格
     * */
    Result<List<FlavorDTO>> getFlavors();

    /**
     * function: 获取底层机器实例
     * */
    Result<List<ServerDTO>> listServers(Integer tenantId);

    /**
     * function: 创建底层机器
     * */
    Result<Boolean> createServer(Integer tenantId, ServerDTO serverDTO, String instanceType);

    /**
     * function: 连接数据卷
     * */
    Result connectVolume(String serverId, String volumeInfo, Integer tenantId);

    Result<ServerDTO> getServerById(String serverId);

    Result<AggregateVO> createAggregateRPC(AggregateDTO aggregateDTO);

    Result updateAggregateRPC(AggregateDTO aggregateDTO);

    Result removeAggregateRPC(String aggregateId);

    Result<String> createFlavorRPC(FlavorDTO flavorDTO);

    Result<FlavorDTO> getFlavorByIdRPC(String flavorId,String categoryCode);

    Result updateFlavorRPC(FlavorDTO flavorDTO);

    Result removeFlavorRPC(String flavorId);

    Result<List<FlavorDTO>> getFlavorByIdsRPC(List<String> flavorIds);

    Result<AggregateVO> getAggregateByIdRPC(String id);
}
