package com.ict.cloud.wapper.rpcImpl;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.common.exception.ServiceException;
import com.ict.cloud.model.*;
import com.ict.cloud.nova.model.Server;
import com.ict.cloud.resource.domain.OpenstackFlavors;
import com.ict.cloud.resource.domain.OpenstackResource;
import com.ict.cloud.result.Result;
import com.ict.cloud.rpc.ComputeApiService;
import com.ict.cloud.vo.AggregateVO;
import com.ict.cloud.vo.ImageConfigVO;
import com.ict.cloud.wapper.IOpenstackComputeService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ComputeApiServiceImpl implements ComputeApiService {
    @Resource
    private IOpenstackComputeService iOpenstackComputeService;

    @Override
    public Result bootInstance(Integer tenantId, String serverId) {
        try {
            iOpenstackComputeService.bootInstance(tenantId, serverId);
            return Result.Success();
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }
    @Override
    public Result rebootInstance(Integer tenantId, String serverId) {
        try {
            iOpenstackComputeService.rebootInstance(tenantId, serverId);
            return Result.Success();
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }
    @Override
    public Result stopInstance(Integer tenantId, String serverId) {
        try {
            iOpenstackComputeService.stopInstance(tenantId, serverId);
            return Result.Success();
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<Boolean> changeInstancePassword(Integer tenantId, String serverId, String newPassword) {
        try {
            iOpenstackComputeService.changeInstancePassword(tenantId, serverId, newPassword);
            return Result.Success(Boolean.TRUE);
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<ServerDTO> getServerById(Integer tenantId, String serverId) {
        try {
            Server server = iOpenstackComputeService.getServerById(tenantId, serverId);
            ServerDTO serverDTO = new ServerDTO();
            if (server != null) {
                BeanUtils.copyProperties(server, serverDTO);
            }
            return Result.Success(serverDTO);
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<ServerDTO> getServerById(String serverId) {
        try {
            Server server = iOpenstackComputeService.getServerById(serverId);
            ServerDTO serverDTO = new ServerDTO();
            if (server != null) {
                BeanUtils.copyProperties(server, serverDTO);
            }
            return Result.Success(serverDTO);
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<String> getSpiceConsole(Integer tenantId, String serverId, String type) {
        try {
            String url = iOpenstackComputeService.getSpiceConsole(tenantId, serverId, type);
            return Result.Success(url);
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result createKeyPair(KeyPairDTO keyPairDTO, Integer tenantId) {
        try {
            iOpenstackComputeService.createKeyPair(keyPairDTO, tenantId);
            Result.Success();
        } catch (ServiceException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
        return Result.Failure(-1, "CreateKeyPair Failed!");
    }

    @Override
    public Result<List<KeyPairDTO>> getKeyPairs(Integer tenantId, String keyPairName) {
        List<KeyPairDTO> keyPairDTOS = iOpenstackComputeService.getKeyPairs(tenantId, keyPairName);
        return Result.Success(keyPairDTOS);
    }

    @Override
    public Result releaseTenantInstance(Integer tenantId, List<String> instanceIDS, Boolean logoutFlag) {
        try {
            iOpenstackComputeService.releaseTenantInstance(tenantId, instanceIDS, logoutFlag);
            return Result.Success();
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<Boolean> updateOpenstackResourceToDB() {
        try {
            boolean updateStatu = iOpenstackComputeService.updateOpenstackResourceToDB();
            return Result.Success(updateStatu);
        } catch (ParseException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<Boolean> updateOpenstackFlavorToDB() {
        try {
            boolean updateStatus = iOpenstackComputeService.updateOpenstackFlavorToDB();
            return Result.Success(updateStatus);
        } catch (ParseException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<List<ResourceDTO>> getOpenstackResources() {
        List<OpenstackResource> openstackResources = iOpenstackComputeService.getOpenstackResources();
        List<ResourceDTO> resourceDTOS = new ArrayList<>();
        for (OpenstackResource resource : openstackResources) {
            ResourceDTO resourceDTO = new ResourceDTO();
            if (resource != null) {
                BeanUtils.copyProperties(resource, resourceDTO);
            }
            resourceDTOS.add(resourceDTO);
        }
        return Result.Success(resourceDTOS);
    }

    @Override
    public Result<ResourceDTO> getResourceTotal() {
        ResourceDTO resourceDTO = iOpenstackComputeService.getResourceTotal();
        return Result.Success(resourceDTO);
    }

    @Override
    public Result<Boolean> updateNovaQuotaSets(String projectId) {
        try {
            iOpenstackComputeService.updateNovaQuotaSets(projectId);
            return Result.Success(Boolean.TRUE);
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<Integer> countServerByTenantAndServerName(Integer tenantId, String serverName) {
        int count = iOpenstackComputeService.countServerByTenantAndServerName(tenantId, serverName);
        return Result.Success(count);
    }

    @Override
    public Result<List<FlavorDTO>> getFlavors() {
        List<OpenstackFlavors> openstackFlavorsList = iOpenstackComputeService.getFlavors();
        List<FlavorDTO> flavorDTOS = new ArrayList<>();
        for (OpenstackFlavors flavor : openstackFlavorsList) {
            FlavorDTO flavorDTO = new FlavorDTO();
            if (flavor != null) {
                BeanUtils.copyProperties(flavor, flavorDTO);
            }
            flavorDTOS.add(flavorDTO);
        }
        return Result.Success(flavorDTOS);
    }

    @Override
   public Result removeInstance(Integer tenantId, String serverId) {
        try {
            iOpenstackComputeService.removeInstance(tenantId, serverId);
            return Result.Success();
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<List<ServerDTO>> listServers(Integer tenantId) {
        try {
            List<ServerDTO> serverDTOS = iOpenstackComputeService.listServers(tenantId);
            return Result.Success(serverDTOS);
        } catch (OperationException e) {
            e.printStackTrace();
            Result.Failure(-1 ,e.getMessage());
        }
        return Result.Failure(-1, "ListServers Failed!");
    }

    @Override
    public Result<Boolean> createServer(Integer tenantId, ServerDTO serverDTO, String instanceType) {
        try {
            Boolean createStatus = iOpenstackComputeService.createServer(tenantId, serverDTO, instanceType);
            return Result.Success(createStatus);
        } catch (OperationException e) {
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result connectVolume(String serverId, String volumeInfo, Integer tenantId) {
        try {
            iOpenstackComputeService.connectVolume(serverId, volumeInfo, tenantId);
            return Result.Success();
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<AggregateVO> createAggregateRPC(AggregateDTO aggregateDTO) {
        AggregateVO aggregateVO = iOpenstackComputeService.createAggregate(aggregateDTO);
        if (aggregateVO == null) {
            return Result.Failure(-1, "创建主机聚合失败");
        }
        return Result.Success(aggregateVO);
    }

    @Override
    public Result updateAggregateRPC(AggregateDTO aggregateDTO) {
        AggregateVO aggregateVO = iOpenstackComputeService.updateAggregate(aggregateDTO);
        if (aggregateVO.getId() != null) {
            return Result.Success();
        }
        return Result.Failure(-1, "UpdateAggregate failed!");
    }

    @Override
    public Result removeAggregateRPC(String aggregateId) {
        iOpenstackComputeService.removeAggregateById(aggregateId);
        return Result.Success();
    }

    @Override
    public Result<String> createFlavorRPC(FlavorDTO flavorDTO) {
        try {
            String flavorId = iOpenstackComputeService.createFlavor(flavorDTO);
            if (flavorId != null) {
                return Result.Success(flavorId);
            }
            return Result.Failure(-1, "创建规格失败！");
        } catch (OperationException e) {
            e.printStackTrace();
        }
        return Result.Failure(-1, "创建规格失败！");
    }

    @Override
    public Result<FlavorDTO> getFlavorByIdRPC(String flavorId, String categoryCode) {
        FlavorDTO flavorDTO = iOpenstackComputeService.getFlavorById(flavorId, categoryCode);
        if (flavorDTO != null) {
            return Result.Success(flavorDTO);
        }
        return Result.Failure(-1, "创建规格失败");
    }

    @Override
    public Result updateFlavorRPC(FlavorDTO flavorDTO) {
        try {
            iOpenstackComputeService.updateFlavor(flavorDTO);
            return Result.Success();
        } catch (OperationException e) {
            e.printStackTrace();
        }
        return Result.Failure(-1, "更新规格失败");
    }

    @Override
    public Result removeFlavorRPC(String flavorId) {
        try {
            iOpenstackComputeService.removeFlavor(flavorId);
            return Result.Success();
        } catch (OperationException e) {
            e.printStackTrace();
        }
        return Result.Failure(-1, "删除规格失败");
    }

    @Override
    public Result<List<FlavorDTO>> getFlavorByIdsRPC(List<String> flavorIds) {
        List<FlavorDTO> flavorDTOS = iOpenstackComputeService.getFlavorByIds(flavorIds);
        if (flavorDTOS != null) {
            return Result.Success(flavorDTOS);
        }
        return Result.Failure(-1, "查询规格失败！");
    }

    @Override
    public Result<AggregateVO> getAggregateByIdRPC(String id) {
        AggregateVO aggregateVO = iOpenstackComputeService.getAggregateById(id);
        if (aggregateVO != null) {
            return Result.Success(aggregateVO);
        }
        return Result.Failure(-1, "主机聚合为空！");
    }
}
