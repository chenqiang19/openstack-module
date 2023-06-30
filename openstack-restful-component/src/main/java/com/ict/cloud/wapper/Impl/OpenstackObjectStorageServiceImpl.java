package com.ict.cloud.wapper.Impl;

import com.ict.cloud.cinder.Cinder;
import com.ict.cloud.cinder.model.QuotaSet;
import com.ict.cloud.cinder.model.Snapshot;
import com.ict.cloud.cinder.model.Volume;
import com.ict.cloud.common.constants.OpenstackConstants;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.model.SnapShotDTO;
import com.ict.cloud.model.VolumeDTO;
import com.ict.cloud.nova.Nova;
import com.ict.cloud.nova.model.Server;
import com.ict.cloud.resource.domain.OpenstackSnapshots;
import com.ict.cloud.resource.domain.OpenstackUsers;
import com.ict.cloud.resource.domain.OpenstackVolumes;
import com.ict.cloud.resource.service.IOpenstackSnapshotsService;
import com.ict.cloud.resource.service.IOpenstackVolumeService;
import com.ict.cloud.wapper.IOpenstackIdentityService;
import com.ict.cloud.wapper.IOpenstackObjectStorageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service("block_storage")
public class OpenstackObjectStorageServiceImpl implements IOpenstackObjectStorageService {

    @Resource
    private IOpenstackIdentityService iOpenstackIdentityService;
    @Resource
    private IOpenstackVolumeService iOpenstackVolumeService;
    @Autowired
    private IOpenstackSnapshotsService openstackSnapshotsService;

    @Override
    public void updateVolumeQuotaSets(String adminProjectId, String projectId) throws OperationException {
        boolean valid = iOpenstackIdentityService.connectOpenstack();
        if(!valid){
            throw new OperationException("Openstack Connect failed!");
        }
        try{
            Cinder cinder = iOpenstackIdentityService.getAdminCinder();
            QuotaSet quotaSet = new QuotaSet();
            cinder.quotasets.update(adminProjectId, projectId, quotaSet);
        }catch (Exception e){
            throw new OperationException("修改Volume配额失败！");
        }
    }

    @Override
    public void releaseTenantVolumeByServerName(Integer tenantId, String serverName) throws OperationException {
        try{
            OpenstackUsers openstackUsers = iOpenstackIdentityService.getUserByTenantId(tenantId);
            boolean valid = iOpenstackIdentityService.userConnectOpenstack(openstackUsers.getUserName(),
                    openstackUsers.getUserName(), new String(Base64.getDecoder().decode(openstackUsers.getPassword())));
            if (!valid) {
                throw new OperationException("OpenStack connect failed!");
            }
            final Nova nova = iOpenstackIdentityService.getNova(openstackUsers.getUserName());
            List<Server> servers = nova.servers.list().stream().filter(server -> server.getName().equals(serverName))
                    .collect(Collectors.toList());
            for (Server server : servers) {
                List<Server.VolumeAttachment> volumeAttachments = nova.servers.listServerVolume(server.getId());
                if(volumeAttachments.size()>0) {
                    for (Server.VolumeAttachment volume : volumeAttachments) {
                        nova.servers.disconnectVolume(server.getId(), volume.getVolumeId());
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new OperationException(e.getMessage());
        }
    }

    @Override
    public void releaseTenantVolumeByServerIDS(Integer tenantId, List<String> serverIDS) throws OperationException {
        try{
            OpenstackUsers openstackUsers = iOpenstackIdentityService.getUserByTenantId(tenantId);
            boolean valid = iOpenstackIdentityService.userConnectOpenstack(openstackUsers.getUserName(),
                    openstackUsers.getUserName(), new String(Base64.getDecoder().decode(openstackUsers.getPassword())));
            if (!valid) {
                throw new OperationException("OpenStack connect failed!");
            }
            final Nova nova = iOpenstackIdentityService.getNova(openstackUsers.getUserName());
            for (String serverId : serverIDS) {
                List<Server.VolumeAttachment> volumeAttachments = nova.servers.listServerVolume(serverId);
                if(volumeAttachments.size()>0) {
                    for (Server.VolumeAttachment volume : volumeAttachments) {
                        nova.servers.disconnectVolume(serverId, volume.getVolumeId());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new OperationException("删除数据集失败");
        }
    }

    @Override
    public List<String> releaseTenantVolume(Integer tenantId) throws OperationException {
        try {
            OpenstackUsers openstackUsers = iOpenstackIdentityService.getUserByTenantId(tenantId);
            boolean valid = iOpenstackIdentityService.userConnectOpenstack(openstackUsers.getUserName(), openstackUsers.getUserName(),
                    new String(Base64.getDecoder().decode(openstackUsers.getPassword())));
            if (!valid) {
                throw new OperationException("OpenStack connect failed!");
            }
            Cinder cinder = iOpenstackIdentityService.getCinder(openstackUsers.getUserName());
            Nova nova = iOpenstackIdentityService.getNova(openstackUsers.getUserName());
            List<Volume> volumes = cinder.volumes.list();
            List<String> instanceIDS = new ArrayList<>();
            volumes.forEach(volume->{
                if(volume.getAttachment()!=null && volume.getAttachment().size()>0) {
                    for (Volume.Attachment attach : volume.getAttachment()) {
                        try {
                            if(!attach.getDevice().toLowerCase(Locale.ROOT).contains("vda")) {
                                nova.servers.disconnectVolume(attach.getInstanceId(), attach.getVolumeId());
                                cinder.volumes.delete(attach.getVolumeId());
                                instanceIDS.add(attach.getInstanceId());
                            }
                        } catch (OperationException e) {
                            e.printStackTrace();
                        }
                    }
                }else{
                    try {
                        cinder.volumes.delete(volume.getId());
                    } catch (OperationException e) {
                        e.printStackTrace();
                    }
                }
            });
            return instanceIDS.stream().distinct().collect(Collectors.toList());
        } catch (OperationException e) {
            e.printStackTrace();
            throw new OperationException(e.getMessage());
        }
    }

    @Override
    public List<VolumeDTO> createDataVolume(Integer tenantId, List<Volume> volumes) throws OperationException {
        try {
            OpenstackUsers openstackUsers = iOpenstackIdentityService.getUserByTenantId(tenantId);
            boolean valid = iOpenstackIdentityService.userConnectOpenstack(openstackUsers.getUserName(), openstackUsers.getUserName(),
                    new String(Base64.getDecoder().decode(openstackUsers.getPassword())));
            if (!valid) {
                throw new OperationException("OpenStack connect failed!");
            }
            Cinder cinder = iOpenstackIdentityService.getCinder(openstackUsers.getUserName());
            List<OpenstackVolumes> openstackVolumesList = new ArrayList<>();
            List<VolumeDTO> volumeDTOS = new ArrayList<>();
            for (Volume volume : volumes) {
                Volume retVolume = cinder.volumes.create(volume);
                if (retVolume != null) {
                    VolumeDTO volumeDTO = new VolumeDTO();
                    OpenstackVolumes openstackVolumes = new OpenstackVolumes();
                    openstackVolumes.setVolumeId(retVolume.getId());
                    openstackVolumes.setUserId(retVolume.getUserId());
                    openstackVolumes.setStatus(retVolume.getStatus());
                    openstackVolumes.setMigrationStatus(retVolume.getMigstat());
                    openstackVolumes.setVolumeName(retVolume.getName());
                    openstackVolumes.setVolumeType(retVolume.getVolumeType());
                    //openstackVolumes.setReplicationStatus(re);
                    openstackVolumes.setSize(retVolume.getSize());
                    //openstackVolumes.setVolumeTypeId(ret);
                    openstackVolumes.setCreateAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(retVolume.getCreatedAt()));
                    openstackVolumes.setDescription(retVolume.getDescription());
                    //openstackVolumes.setEncrypted(retVolume.g);
                    openstackVolumes.setAvailableZone(retVolume.getAvailabilityZone());
                    openstackVolumes.setSnapShotId(retVolume.getSnapshotId());
                    //openstackVolumes.setConsumesQuota(retVolume.);
                    openstackVolumes.setBootable(retVolume.getBootable());
                    //openstackVolumes.setSharedTargets();
                    Optional<Volume.Attachment> attachment = retVolume.getAttachment().stream().findFirst();
                    if (attachment.isPresent()) {
                        Volume.Attachment attachmentInfo = attachment.get();
                        openstackVolumes.setDevice(attachmentInfo.getDevice());
                        openstackVolumes.setServerId(attachmentInfo.getInstanceId());
                        openstackVolumes.setAttachmentId(attachmentInfo.getId());
                    }
                    BeanUtils.copyProperties(openstackVolumes, volumeDTO);
                    openstackVolumesList.add(openstackVolumes);
                    volumeDTOS.add(volumeDTO);
                }
                iOpenstackVolumeService.batchInsertVolumes(openstackVolumesList);
            }
            return volumeDTOS;
        }catch (Exception e) {
            e.printStackTrace();
            throw new OperationException(e.getMessage());
        }
    }

    @Override
    public void extendDataVolume(Integer tenantId, List<VolumeDTO> volumeDTOS) throws OperationException {
        try {
            OpenstackUsers openstackUsers = iOpenstackIdentityService.getUserByTenantId(tenantId);
            boolean valid = iOpenstackIdentityService.userConnectOpenstack(openstackUsers.getUserName(), openstackUsers.getUserName(),
                    new String(Base64.getDecoder().decode(openstackUsers.getPassword())));
            if (!valid) {
                throw new OperationException("OpenStack connect failed!");
            }
            Cinder cinder = iOpenstackIdentityService.getCinder(openstackUsers.getUserName());
            volumeDTOS.forEach(volume -> {
                try {
                    cinder.volumes.resize(volume.getVolumeId(), volume.getNewSize());
                } catch (OperationException e) {
                    e.printStackTrace();
                }
            });

        }catch (Exception e) {
            e.printStackTrace();
            throw new OperationException(e.getMessage());
        }
    }

    @Override
    public void createSnapShot(Integer tenantId, List<SnapShotDTO> snapShotDTOS) throws OperationException {
        try {
            OpenstackUsers openstackUsers = iOpenstackIdentityService.getUserByTenantId(tenantId);
            boolean valid = iOpenstackIdentityService.userConnectOpenstack(openstackUsers.getUserName(), openstackUsers.getUserName(),
                    new String(Base64.getDecoder().decode(openstackUsers.getPassword())));
            if (!valid) {
                throw new OperationException("OpenStack connect failed!");
            }
            Cinder cinder = iOpenstackIdentityService.getCinder(openstackUsers.getUserName());
            snapShotDTOS.forEach(snapShot -> {
                try {
                    cinder.snapshots.create(snapShot.getVolumeId(), snapShot.getName(), snapShot.getDescription());
                } catch (OperationException e) {
                    e.printStackTrace();
                }
            });
        }catch (Exception e) {
            e.printStackTrace();
            throw new OperationException(e.getMessage());
        }
    }

    @Override
    public List<OpenstackVolumes> listVolumes(Integer tenantId) throws OperationException {
        try {
            OpenstackUsers openstackUsers = iOpenstackIdentityService.getUserByTenantId(tenantId);
            boolean valid = iOpenstackIdentityService.userConnectOpenstack(openstackUsers.getUserName(), openstackUsers.getUserName(),
                    new String(Base64.getDecoder().decode(openstackUsers.getPassword())));
            if (!valid) {
                throw new OperationException("OpenStack connect failed!");
            }
            Cinder cinder = iOpenstackIdentityService.getCinder(openstackUsers.getUserName());
            List<Volume> volumes = cinder.volumes.list();
            List<OpenstackVolumes> openstackVolumesList = new ArrayList<>();
            for (Volume volume : volumes) {
                OpenstackVolumes openstackVolumes = new OpenstackVolumes();
                openstackVolumes.setVolumeId(volume.getId());
                openstackVolumes.setUserId(volume.getUserId());
                openstackVolumes.setStatus(volume.getStatus());
                openstackVolumes.setMigrationStatus(volume.getMigstat());
                openstackVolumes.setVolumeName(volume.getName());
                openstackVolumes.setVolumeType(volume.getVolumeType());
                openstackVolumes.setSize(volume.getSize());
                openstackVolumes.setCreateAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(volume.getCreatedAt()));
                openstackVolumes.setDescription(volume.getDescription());
                openstackVolumes.setAvailableZone(volume.getAvailabilityZone());
                openstackVolumes.setSnapShotId(volume.getSnapshotId());
                openstackVolumes.setBootable(volume.getBootable());
                Optional<Volume.Attachment> attachment = volume.getAttachment().stream().findFirst();
                if (attachment.isPresent()) {
                    Volume.Attachment attachmentInfo = attachment.get();
                    openstackVolumes.setDevice(attachmentInfo.getDevice());
                    openstackVolumes.setServerId(attachmentInfo.getInstanceId());
                    openstackVolumes.setAttachmentId(attachmentInfo.getId());
                }
                openstackVolumesList.add(openstackVolumes);
            }
            return openstackVolumesList;
        }catch (Exception e) {
            e.printStackTrace();
            throw new OperationException(e.getMessage());
        }
    }

    @Override
    public void deleteVolume(Integer tenantId, List<String> volumeIdList) throws OperationException {
        try {
            OpenstackUsers openstackUsers = iOpenstackIdentityService.getUserByTenantId(tenantId);
            boolean valid = iOpenstackIdentityService.userConnectOpenstack(openstackUsers.getUserName(), openstackUsers.getUserName(),
                    new String(Base64.getDecoder().decode(openstackUsers.getPassword())));
            if (!valid) {
                throw new OperationException("OpenStack connect failed!");
            }
            Cinder cinder = iOpenstackIdentityService.getCinder(openstackUsers.getUserName());
            volumeIdList.forEach(volumeId -> {
                try {
                    cinder.volumes.delete(volumeId);
                } catch (OperationException e) {
                    e.printStackTrace();
                }
            });
        }catch (Exception e) {
            e.printStackTrace();
            throw new OperationException(e.getMessage());
        }
    }

    @Override
    public void deleteSnapShot(Integer tenantId, List<String> snapShotIdList) throws OperationException {
        try {
            OpenstackUsers openstackUsers = iOpenstackIdentityService.getUserByTenantId(tenantId);
            boolean valid = iOpenstackIdentityService.userConnectOpenstack(openstackUsers.getUserName(), openstackUsers.getUserName(),
                    new String(Base64.getDecoder().decode(openstackUsers.getPassword())));
            if (!valid) {
                throw new OperationException("OpenStack connect failed!");
            }
            Cinder cinder = iOpenstackIdentityService.getCinder(openstackUsers.getUserName());
            snapShotIdList.forEach(snapShotId -> {
                try {
                    cinder.snapshots.delete(snapShotId);
                } catch (OperationException e) {
                    e.printStackTrace();
                }
            });
        }catch (Exception e) {
            e.printStackTrace();
            throw new OperationException(e.getMessage());
        }
    }

    @Override
    public boolean updateOpenstackSnapshotToDB() throws OperationException {
        boolean valid = iOpenstackIdentityService.connectOpenstack();
        if(!valid){
            throw new OperationException("Openstack Connect failed!");
        }
        try{
            final Cinder cinder = iOpenstackIdentityService.getAdminCinder();
            List<Snapshot> snapshots = cinder.snapshots.list();
            OpenstackSnapshots openstackSnapShots = new OpenstackSnapshots();
            for(Snapshot snapShot : snapshots) {
                if(snapShot.getCreateAt()!=null){
                    String dateCreate = snapShot.getCreateAt().replace("T", " ");
                    openstackSnapShots.setCreateAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateCreate));
                }
                if(snapShot.getUpdatedAt()!=null) {
                    String dateUpdate = snapShot.getUpdatedAt().replace("T", " ");
                    openstackSnapShots.setUpdatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateUpdate));
                }
                //openstackSnapShots.setParentId(Integer.parseInt(hypervisor.getId()));
                openstackSnapShots.setSnapshotSize(snapShot.getSize());
                openstackSnapShots.setSnapshotProjectId(snapShot.getTenantId());
                openstackSnapShots.setSnapshotsName(snapShot.getName());
                openstackSnapShots.setSnapshotsStatus(snapShot.getStatus());
                openstackSnapShots.setSnapshotsId(snapShot.getId());
                openstackSnapShots.setSnapshotsVolumeId(snapShot.getVolumeId());
                openstackSnapshotsService.insertOpenstackSnapshot(openstackSnapShots);
            }
        }catch(Exception e) {
            throw new OperationException("updateOpenstackSnapshotToDB failed!");
        }
        return true;
    }
}
