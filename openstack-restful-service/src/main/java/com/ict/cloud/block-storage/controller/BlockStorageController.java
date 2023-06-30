package com.ict.cloud.blockStorage.controller;

import com.ict.cloud.cinder.model.Volume;
import com.ict.cloud.common.analzye.ApiResult;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.model.SnapShotDTO;
import com.ict.cloud.model.VolumeDTO;
import com.ict.cloud.resource.domain.OpenstackVolumes;
import com.ict.cloud.wapper.IOpenstackObjectStorageService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/v1/openstack-management/block_storage")
@Api(tags = "块存储管理")
public class BlockStorageController {

    @Resource
    private IOpenstackObjectStorageService iOpenstackObjectStorageService;

    @PutMapping("/updateVolumeQuotaSets")
    public ApiResult updateVolumeQuotaSets(@RequestParam("adminProjectId") String adminProjectId,
                                           @RequestParam("projectId") String projectId) {
        try {
            iOpenstackObjectStorageService.updateVolumeQuotaSets(adminProjectId, projectId);
            return ApiResult.success();
        } catch (OperationException e) {
            return ApiResult.failed(e.getMessage());
        }
    }

    @PostMapping("/releaseTenantVolume")
    public ApiResult<List<String>> releaseTenantVolume(@RequestParam("tenantId") Integer tenantId) {
        try {
            List<String> instanceIds = iOpenstackObjectStorageService.releaseTenantVolume(tenantId);
            return ApiResult.success(instanceIds);
        } catch (OperationException e) {
            e.printStackTrace();
            return ApiResult.failed(e.getMessage());
        }
    }

    @PostMapping("/releaseTenantVolumeByServerName")
    public ApiResult releaseTenantVolumeByServerName(@RequestParam("tenantId") Integer tenantId,
                                                     @RequestParam("serverName") String serverName) {
        try {
            iOpenstackObjectStorageService.releaseTenantVolumeByServerName(tenantId, serverName);
            return ApiResult.success();
        } catch (OperationException e) {
            e.printStackTrace();
            return ApiResult.failed(e.getMessage());
        }
    }

    @PostMapping("/addDataVolume")
    public ApiResult addDataVolume(@RequestParam("tenantId") Integer tenantId,
                                   @RequestParam("volumes") List<Volume> volumes) {
        try {
            iOpenstackObjectStorageService.createDataVolume(tenantId, volumes);
            return ApiResult.success();
        } catch (OperationException e) {
            e.printStackTrace();
            return ApiResult.failed(e.getMessage());
        }
    }

    @PutMapping("/extendDataVolume")
    public ApiResult extendDataVolume(@RequestParam("tenantId")Integer tenantId,
                                      @RequestParam("volumeDTOS")List<VolumeDTO> volumeDTOS) {
        try {
            iOpenstackObjectStorageService.extendDataVolume(tenantId, volumeDTOS);
            return ApiResult.success();
        } catch (OperationException e) {
            e.printStackTrace();
            return ApiResult.failed(e.getMessage());
        }
    }

    @PostMapping("/createSnapShot")
    public ApiResult createSnapShot(@RequestParam("tenantId") Integer tenantId,
                                    @RequestParam("snapShptDTOS") List<SnapShotDTO> snapShptDTOS) {
        try {
            iOpenstackObjectStorageService.createSnapShot(tenantId, snapShptDTOS);
            return ApiResult.success();
        } catch (OperationException e) {
            e.printStackTrace();
            return ApiResult.failed(e.getMessage());
        }
    }

    @GetMapping("/listVolumes")
    public ApiResult<List<OpenstackVolumes>> listVolumes(@RequestParam("tenantId") Integer tenantId) {
        try {
            List<OpenstackVolumes> volumesList = iOpenstackObjectStorageService.listVolumes(tenantId);
            return ApiResult.success(volumesList);
        } catch (OperationException e) {
            e.printStackTrace();
            return ApiResult.failed(e.getMessage());
        }

    }

    @DeleteMapping("/deleteVolume")
    public ApiResult deleteVolume(@RequestParam("tenantId") Integer tenantId,
                                  @RequestParam("volumeIdList") List<String> volumeIdList) {
        try {
            iOpenstackObjectStorageService.deleteVolume(tenantId, volumeIdList);
            return ApiResult.success();
        } catch (OperationException e) {
            e.printStackTrace();
            return ApiResult.failed(e.getMessage());
        }
    }

    @DeleteMapping("/deleteSnapShot")
    public ApiResult deleteSnapShot(@RequestParam("tenantId")Integer tenantId,
                                    @RequestParam("snapShotIdList")List<String> snapShotIdList) {
        try {
            iOpenstackObjectStorageService.deleteSnapShot(tenantId, snapShotIdList);
            return ApiResult.success();
        } catch (OperationException e) {
            e.printStackTrace();
            return ApiResult.failed(e.getMessage());
        }
    }
}
