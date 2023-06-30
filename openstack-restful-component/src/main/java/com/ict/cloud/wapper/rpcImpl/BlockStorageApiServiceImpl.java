package com.ict.cloud.wapper.rpcImpl;

import com.ict.cloud.cinder.model.Volume;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.model.SnapShotDTO;
import com.ict.cloud.model.VolumeDTO;
import com.ict.cloud.resource.domain.OpenstackVolumes;
import com.ict.cloud.result.Result;
import com.ict.cloud.rpc.BlockStorageApiService;
import com.ict.cloud.wapper.IOpenstackObjectStorageService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlockStorageApiServiceImpl implements BlockStorageApiService {
    @Resource
    private IOpenstackObjectStorageService iOpenstackObjectStorageService;
    @Override
    public Result<Boolean> updateVolumeQuotaSets(String adminProjectId, String projectId) {
        try{
            iOpenstackObjectStorageService.updateVolumeQuotaSets(adminProjectId, projectId);
            return Result.Success(Boolean.TRUE);
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<List<String>> releaseTenantVolume(Integer tenantId) {
        try {
            List<String> instanceIds = iOpenstackObjectStorageService.releaseTenantVolume(tenantId);
            return Result.Success(instanceIds);
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<Boolean> releaseTenantVolumeByServerName(Integer tenantId, String serverName) {
        try {
            iOpenstackObjectStorageService.releaseTenantVolumeByServerName(tenantId, serverName);
            return Result.Success(Boolean.TRUE);
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<Boolean> releaseTenantVolumeByServerIDS(Integer tenantId, List<String> serverIDS) {
        try {
            iOpenstackObjectStorageService.releaseTenantVolumeByServerIDS(tenantId,  serverIDS);
            return Result.Success(Boolean.TRUE);
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<List<VolumeDTO>> createDataVolume(Integer tenantId, List<VolumeDTO> volumeDTOS) {
        List<Volume> volumeList = new ArrayList<>();
        for (VolumeDTO volumeDTO : volumeDTOS) {
            Volume volume = new Volume();
            if (volumeDTO != null) {
                BeanUtils.copyProperties(volumeDTO, volume);
            }
            volumeList.add(volume);
        }
        try {
            List<VolumeDTO> volumeDTOList = iOpenstackObjectStorageService.createDataVolume(tenantId, volumeList);
            return Result.Success(volumeDTOList);
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<Boolean> extendDataVolume(Integer tenantId, List<VolumeDTO> volumeDTOS) {
        try {
            iOpenstackObjectStorageService.extendDataVolume(tenantId, volumeDTOS);
            return Result.Success(Boolean.TRUE);
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<Boolean> createSnapShot(Integer tenantId, List<SnapShotDTO> snapShptDTOS) {
        try {
            iOpenstackObjectStorageService.createSnapShot(tenantId, snapShptDTOS);
            return Result.Success(Boolean.TRUE);
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<List<VolumeDTO>> listVolumes(Integer tenantId) {
        try {
            List<OpenstackVolumes> openstackVolumesList = iOpenstackObjectStorageService.listVolumes(tenantId);
            List<VolumeDTO> volumeDTOS = new ArrayList<>();
            for (OpenstackVolumes volume : openstackVolumesList) {
                VolumeDTO volumeDTO = new VolumeDTO();
                if (volume != null) {
                    BeanUtils.copyProperties(volume, volumeDTO);
                }
                volumeDTOS.add(volumeDTO);
            }
            return Result.Success(volumeDTOS);
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<Boolean> deleteVolume(Integer tenantId, List<String> volumeIdList) {
        try {
            iOpenstackObjectStorageService.deleteVolume(tenantId, volumeIdList);
            return Result.Success(Boolean.TRUE);
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<Boolean> deleteSnapShot(Integer tenantId, List<String> snapShotIdList) {
        try {
            iOpenstackObjectStorageService.deleteSnapShot(tenantId, snapShotIdList);
            return Result.Success(Boolean.TRUE);
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<Boolean> updateOpenstackSnapshotToDB() {
        try {
            boolean updateStatus = iOpenstackObjectStorageService.updateOpenstackSnapshotToDB();
            return Result.Success(updateStatus);
        } catch (ParseException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }
}
