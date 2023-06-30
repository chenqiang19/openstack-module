package com.ict.cloud.compute.controller;

import com.ict.cloud.common.analzye.ApiResult;
import com.ict.cloud.common.constants.ServerGroupAffinity;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.common.exception.ServiceException;
import com.ict.cloud.model.AggregateDTO;
import com.ict.cloud.model.KeyPairDTO;
import com.ict.cloud.model.MetaDataDTO;
import com.ict.cloud.nova.model.Hypervisor;
import com.ict.cloud.vo.*;
import com.ict.cloud.wapper.IOpenstackComputeService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/openstack-management/compute")
@Api("计算管理")
public class ComputeController {

    @Resource
    private IOpenstackComputeService iOpenstackComputeService;

    @GetMapping("/getSpiceConsole")
    public ApiResult<String> getSpiceConsole(@RequestParam("tenantId") Integer tenantId,
                                             @RequestParam("serverId") String serverId,
                                             @RequestParam("type") String type) {
        try {
            String url = iOpenstackComputeService.getSpiceConsole(tenantId, serverId, type);
            return ApiResult.success(url);
        } catch (OperationException e) {
            return ApiResult.failed(e.getMessage());
        }
    }



    @PostMapping("/createKeyPair")
    public ApiResult createKeyPair(@RequestParam("keyPairDTO") KeyPairDTO keyPairDTO,
                                   @RequestParam("tenantId") Integer tenantId) {
        try {
            iOpenstackComputeService.createKeyPair(keyPairDTO, tenantId);
            return ApiResult.success();
        } catch (OperationException | ServiceException e) {
            return ApiResult.failed(e.getMessage());
        }
    }

    @GetMapping("/getKeyPairs")
    public ApiResult<List<KeyPairDTO>> getKeyPairs(@RequestParam("tenantId") Integer tenantId,
                                                   @RequestParam("keyPairName") String keyPairName) {
        List<KeyPairDTO> keyPairDTOS = iOpenstackComputeService.getKeyPairs(tenantId, keyPairName);
        return ApiResult.success(keyPairDTOS);
    }

    @PostMapping("/releaseTenantInstance")
    public ApiResult releaseTenantInstance(@RequestParam("tenantId") Integer tenantId,
                                           @RequestParam("instanceIDS") List<String> instanceIDS,
                                           @RequestParam("logoutFlag") Boolean logoutFlag) {
        try {
            iOpenstackComputeService.releaseTenantInstance(tenantId, instanceIDS, logoutFlag);
            return ApiResult.success();
        } catch (OperationException e) {
            e.printStackTrace();
            return ApiResult.failed(e.getMessage());
        }
    }

    @GetMapping("/getServerGroupAffinity")
    public ApiResult<List<String>> getServerGroupAffinity() {
        List<String> affinityList = new ArrayList<>();
        for(ServerGroupAffinity affinity : ServerGroupAffinity.values()) {
            affinityList.add(affinity.getName());
        }
        return ApiResult.success(affinityList);
    }

    @PostMapping("/createServerGroup")
    public ApiResult createServerGroup(@RequestParam("tenantId") Integer tenantId,
                                           @RequestParam("name") String name,
                                           @RequestParam("policy") String policy) {
        Boolean createStatus = iOpenstackComputeService.createServerGroup(tenantId, name, policy);
        if (createStatus) {
            return ApiResult.success("创建成功");
        }else {
            return ApiResult.failed("创建失败");
        }
    }

    @GetMapping("/getServerGroup/{tenantId}")
    public ApiResult<List<ServerGroupVO>> getServerGroup(@PathVariable("tenantId") Integer tenantId) {
        return ApiResult.success(iOpenstackComputeService.getServerGroup(tenantId));
    }

    @DeleteMapping("/removeServerGroup/{tenantId}")
    public ApiResult removeServerGroup(@PathVariable("tenantId") Integer tenantId,
                                       @RequestParam("serverGroupId") String serverGroupId) {
        Boolean status = iOpenstackComputeService.removeServerGroup(tenantId, serverGroupId);
        if (status) {
            return ApiResult.success("删除成功");
        }else {
            return ApiResult.failed("删除失败");
        }
    }

    @GetMapping("/getAvailabilityZone/{tenantId}")
    public ApiResult<List<AvailabilityZoneVO>> getAvailabilityZone(@PathVariable("tenantId") Integer tenantId) {
        return ApiResult.success(iOpenstackComputeService.getAvailableZone(tenantId));
    }

    @GetMapping("/getAllHypervisors")
    public ApiResult<List<HypervisorVO>> getAllHypervisors(@RequestParam(value = "filterItem", defaultValue = "") String filterItem) throws OperationException {
        return ApiResult.success(iOpenstackComputeService.getAllHypervisors(filterItem));
    }

    @GetMapping("/listAggregates")
    public ApiResult<AggregateVO> listAggregates(@RequestParam(value = "id") String id) {
        AggregateVO aggregateVO = iOpenstackComputeService.listAggregates(id);
        return ApiResult.success(aggregateVO);
    }

    @PostMapping("/addAggregateHost")
    public ApiResult addAggregateHost(@RequestParam("aggregateId") String aggregateId,
                                      @RequestParam("hostList") List<String> hostList) {
        iOpenstackComputeService.addAggregateHost(aggregateId, hostList);
        return ApiResult.success();
    }

    @PostMapping("/operateHosts")
    public ApiResult operateHosts(@RequestBody AggregateDTO aggregateDTO) {
        iOpenstackComputeService.operateHosts(aggregateDTO);
        return ApiResult.success();
    }

    @DeleteMapping("/removeAggregateHost")
    public ApiResult removeAggregateHost(@RequestParam("aggregateId") String aggregateId,
                                         @RequestParam("hostList") List<String> hostList) {
        iOpenstackComputeService.removeAggregateHost(aggregateId, hostList);
        return ApiResult.success();
    }

    @GetMapping("/getAggregateMetaDate")
    public ApiResult<String> getAggregateMetaDate(@RequestParam("aggregateId") String aggregateId) {
        String metaDataVOS = iOpenstackComputeService.getAggregateMetaDate(aggregateId);
        return ApiResult.success(metaDataVOS);
    }

    @PostMapping("/createAggregateMetaDate")
    public ApiResult createAggregateMetaDate(@RequestParam("aggregateId") String aggregateId,
                                             @RequestParam("metaDataDTOS") List<MetaDataDTO> metaDataDTOS) {
        iOpenstackComputeService.createAggregateMetaDate(aggregateId, metaDataDTOS);
        return ApiResult.success();
    }

    @DeleteMapping("/removeAggregateById")
    public ApiResult removeAggregateById(@RequestParam("aggregateId") String aggregateId) {
        iOpenstackComputeService.removeAggregateById(aggregateId);
        return ApiResult.success();
    }
}
