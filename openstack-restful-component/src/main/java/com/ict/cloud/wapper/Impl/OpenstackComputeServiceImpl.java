package com.ict.cloud.wapper.Impl;

import com.alibaba.fastjson.JSONObject;
import com.ict.cloud.common.constants.OpenstackConstants;
import com.ict.cloud.common.constants.ServerGroupAffinity;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.model.*;
import com.ict.cloud.nova.Nova;
import com.ict.cloud.nova.model.*;
import com.ict.cloud.resource.domain.*;
import com.ict.cloud.resource.service.IOpenstackFlavorsService;
import com.ict.cloud.resource.service.IOpenstackKeyPairService;
import com.ict.cloud.resource.service.IOpenstackResourceService;
import com.ict.cloud.resource.service.IOpenstackServerGroupService;
import com.ict.cloud.vo.*;
import com.ict.cloud.wapper.IOpenstackComputeService;
import com.ict.cloud.wapper.IOpenstackIdentityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service("compute")
public class OpenstackComputeServiceImpl implements IOpenstackComputeService {
    @Resource
    private IOpenstackIdentityService iOpenstackIdentityService;
    @Resource
    private IOpenstackKeyPairService iOpenstackKeyPairService;
    @Resource
    private IOpenstackResourceService iOpenstackResourceService;
    @Autowired
    private IOpenstackFlavorsService iOpenstackFlavorsService;
    @Resource
    private IOpenstackServerGroupService iOpenstackServerGroupService;


    @Override
    public String getSpiceConsole(Integer tenantId, String serverId, String type) throws OperationException {
        String userName = iOpenstackIdentityService.checkUserAuthenticated(tenantId);
        if (StringUtils.isEmpty(userName) || userName == null) {
            return null;
        }
        final Nova nova = iOpenstackIdentityService.getNova(userName);
        if (type.toLowerCase(Locale.ROOT).equals("novnc")) {
            Console console = nova.servers.getConsole(serverId, "novnc", "os-getVNCConsole");
            return console.getUrl();
        } else if (type.toLowerCase(Locale.ROOT).equals("serial")) {
            Console console = nova.servers.getConsole(serverId, "serial", "os-getSerialConsole");
            return console.getUrl();
        } else {
            return null;
        }
    }

    @Override
    public void createKeyPair(KeyPairDTO keyPairDTO, Integer tenantId) throws OperationException {
        String checkInfo = iOpenstackIdentityService.checkUserAuthenticated(tenantId);
        if (StringUtils.isEmpty(checkInfo) || checkInfo == null) {
            throw new OperationException("CheckUserAuthenticated Failed!");
        }
        if (keyPairDTO.getName() != null) {
            KeyPair keyPair;
            try {
                final Nova nova = iOpenstackIdentityService.getNova(checkInfo);
                if (keyPairDTO.getPublicKey() != null) {
                    keyPair = nova.keypairs.create(keyPairDTO.getName(), keyPairDTO.getPublicKey());
                } else {
                    keyPair = nova.keypairs.create(keyPairDTO.getName(), keyPairDTO.getType());
                }
                if (keyPair != null) {
                    OpenstackKeyPairs openstackKeyPairs = new OpenstackKeyPairs();
                    openstackKeyPairs.setKeypairName(keyPair.getName());
                    openstackKeyPairs.setKeypairPublicKey(keyPair.getPublicKey());
                    openstackKeyPairs.setTenantId(keyPairDTO.getTenantId());
                    openstackKeyPairs.setKeypairFingerprint(keyPair.getFingerPrint());
                    openstackKeyPairs.setKeypairType(keyPairDTO.getType());
                    iOpenstackKeyPairService.insert(openstackKeyPairs);
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new OperationException(e.getMessage());
            }
        }
    }

    @Override
    public List<KeyPairDTO> getKeyPairs(Integer tenantId, String keyPairName) {
        List<OpenstackKeyPairs> openstackKeyPairs = iOpenstackKeyPairService.getKeyPairsByTenantId(tenantId, keyPairName);
        List<KeyPairDTO> keyPairDTOS = new ArrayList<>();
        for (OpenstackKeyPairs keyPair : openstackKeyPairs) {
            KeyPairDTO keyPairDTO = new KeyPairDTO();
            keyPairDTO.setName(keyPair.getKeypairName());
            keyPairDTO.setPublicKey(keyPair.getKeypairPublicKey());
            keyPairDTO.setType(keyPair.getKeypairType());
            keyPairDTOS.add(keyPairDTO);
        }
        return keyPairDTOS;
    }

    @Override
    public void releaseTenantInstance(Integer tenantId, List<String> instanceIDS, Boolean logoutFlag) throws OperationException {
        try {
            String checkInfo = iOpenstackIdentityService.checkUserAuthenticated(tenantId);
            if (StringUtils.isEmpty(checkInfo) || checkInfo == null) {
                return;
            }
            final Nova nova = iOpenstackIdentityService.getNova(checkInfo);
            instanceIDS.forEach(instance -> {
                try {
                    nova.servers.delete(instance);
                } catch (OperationException e) {
                    e.printStackTrace();
                }
            });
            if (logoutFlag) { //flag标识注销用户
                List<Server> instances = nova.servers.list();
                instances = instances.stream().filter(instance -> !instanceIDS.contains(instance.getId())).collect(Collectors.toList());
                instances.forEach(instance -> {
                    try {
                        nova.servers.delete(instance.getId());
                    } catch (OperationException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (OperationException e) {
            e.printStackTrace();
            throw new OperationException(e.getMessage());
        }
    }

    //同步虚拟机资源
    public boolean updateOpenstackResourceToDB() throws OperationException {
        boolean valid = iOpenstackIdentityService.checkAdminAuthenticated();
        if (!valid) {
            throw new OperationException("Openstack Connect failed!");
        }

        try {
            final Nova nova = iOpenstackIdentityService.getAdminNova();
            List<Hypervisor> listHypervisor = nova.hypervisors.list();
            for (Hypervisor hypervisor : listHypervisor) {
                if (hypervisor.getType().equals("QEMU")) {
                    OpenstackResource openstackResource = new OpenstackResource();
                    openstackResource.setInstanceId(Integer.parseInt(hypervisor.getId()));
                    openstackResource.setCurrentWorkload(hypervisor.getCurrentWorkload());
                    openstackResource.setDiskAvailableLeast(hypervisor.getDiskAvailableLeast());
                    openstackResource.setFreeDiskGb(hypervisor.getFreeDisk());
                    openstackResource.setHostIp(hypervisor.getHostIp());
                    openstackResource.setStatus(hypervisor.getStatus());
                    openstackResource.setFreeRamMb(hypervisor.getFreeRam());
                    openstackResource.setHypervisorHostname(hypervisor.getHostname());
                    openstackResource.setLocalGb(hypervisor.getDisk());
                    openstackResource.setLocalGbUsed(hypervisor.getRamUsed());
                    openstackResource.setMemoryMb(hypervisor.getRam());
                    openstackResource.setMemoryMbUsed(hypervisor.getRamUsed());
                    openstackResource.setVcpus(hypervisor.getVcpus());
                    openstackResource.setVcpusUsed(hypervisor.getVcpusUsed());
                    openstackResource.setHypervisorType(hypervisor.getType());
                    openstackResource.setHypervisorVersion(String.valueOf(hypervisor.getVersion()));
                    openstackResource.setState(hypervisor.getState());
                    openstackResource.setRunningVms(hypervisor.getRunningVms());
                    //插入openstack hypervisor的Info到openstack_resource表中
                    iOpenstackResourceService.insertOpenstackResource(openstackResource);
                }
            }
        } catch (OperationException e) {
            throw new OperationException("updateOpenstackResourceToDB failed!");
        }
        return true;
    }

    public boolean updateOpenstackFlavorToDB() throws OperationException {
        boolean valid = iOpenstackIdentityService.checkAdminAuthenticated();
        if (!valid) {
            throw new OperationException("Openstack Connect failed!");
        }
        try {
            final Nova nova = iOpenstackIdentityService.getAdminNova();
            List<Flavor> flavors = nova.flavors.list();
            OpenstackFlavors openstackFlavors = new OpenstackFlavors();
            for (Flavor flavor : flavors) {
                Flavor flavorDetail = nova.flavors.get(flavor.getId());
                OpenstackFlavors flavorsInDB = iOpenstackFlavorsService.getFlavorByFlavorId(flavorDetail.getId());
                if (flavorsInDB != null) {
                    continue;
                }
                openstackFlavors.setFlavorId(flavorDetail.getId());
                openstackFlavors.setFlavorRam(flavorDetail.getRam());
                openstackFlavors.setFlavorDisk(flavorDetail.getDisk());
                openstackFlavors.setFlavorName(flavorDetail.getName());
                openstackFlavors.setFlavorVcpu(flavorDetail.getVcpus());
                ExtraSpec extraSpec = nova.extraSpecs.getFlavorExtraSpecs(flavorDetail.getId());
                if (flavorDetail.getName() != null && flavorDetail.getName().contains(OpenstackConstants.BARE_METAL_FLAVOR_TYPE)) {
                    openstackFlavors.setFlavorType(OpenstackConstants.CATEGORYCODE_PHYSICALSERVER);
                    openstackFlavors.setExtraSpecs(JSONObject.toJSONString(extraSpec));
                } else if (flavorDetail.getName() != null) {
                    openstackFlavors.setFlavorType(OpenstackConstants.CATEGORYCODE_VMWARESERVER);
                    openstackFlavors.setExtraSpecs(JSONObject.toJSONString(extraSpec));
                }
                iOpenstackFlavorsService.insertOpenstackFlavor(openstackFlavors);
            }
        } catch (Exception e) {
            throw new OperationException("updateOpenstackFlavorToDB failed!");
        }
        return true;
    }

    public List<OpenstackResource> getOpenstackResources() {
        return iOpenstackResourceService.getOpenstackResource();
    }

    @Override
    public synchronized ResourceDTO getResourceTotal() {
        List<OpenstackResource> openstackResources = this.getOpenstackResources();
        ResourceDTO resourceDTO = new ResourceDTO();
        Integer vcpus = 0;
        Integer vcpusUsed = 0;
        Long ram = 0L;
        Long ramUsed = 0L;
        for (OpenstackResource resource : openstackResources) {
            vcpus += resource.getVcpus();
            vcpusUsed += resource.getVcpusUsed();
            ram += resource.getMemoryMb();
            ramUsed += resource.getMemoryMbUsed();
        }
        resourceDTO.setVCPUs(vcpus);
        resourceDTO.setVCPUsUsed(vcpusUsed);
        resourceDTO.setVCPUsFree(vcpus - vcpusUsed);
        resourceDTO.setRam(ram);
        resourceDTO.setRamUsed(ramUsed);
        BigDecimal freeRam = BigDecimal.valueOf(ram).subtract(BigDecimal.valueOf(ramUsed)).multiply(BigDecimal.valueOf(0.8));
        resourceDTO.setRamFree(freeRam.setScale(0, BigDecimal.ROUND_DOWN).longValue());
        return resourceDTO;
    }

    @Override
    public void updateNovaQuotaSets(String projectId) throws OperationException {
        boolean valid = iOpenstackIdentityService.checkAdminAuthenticated();
        if (!valid) {
            throw new OperationException("Openstack Connect failed!");
        }
        try {
            final Nova nova = iOpenstackIdentityService.getAdminNova();
            Quota quota = new Quota();
            nova.quotas.update(projectId, quota);
        } catch (Exception e) {
            throw new OperationException("修改Nova配额失败！");
        }
    }

    @Override
    public int countServerByTenantAndServerName(Integer tenantId, String serverName) {
        try {
            String checkInfo = iOpenstackIdentityService.checkUserAuthenticated(tenantId);
            if (StringUtils.isEmpty(checkInfo) || checkInfo == null) {
                return Integer.valueOf(-1);
            }
            final Nova nova = iOpenstackIdentityService.getNova(checkInfo);
            List<Server> servers = nova.servers.list().stream().filter(server -> server.getName().equals(serverName))
                    .collect(Collectors.toList());
            return servers.size();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<OpenstackFlavors> getFlavors() {
        return iOpenstackFlavorsService.getFlavorsFromDB();
    }

    @Override
    public Server getServerById(String serverId) throws OperationException {
        boolean valid = iOpenstackIdentityService.checkAdminAuthenticated();
        if (!valid) {
            throw new OperationException("Openstack Connect failed!");
        }
        final Nova adminNova = iOpenstackIdentityService.getAdminNova();
        return adminNova.servers.get(serverId);
    }

    @Override
    public Server getServerById(Integer tenantId, String serverId) throws OperationException {
        String userName = iOpenstackIdentityService.checkUserAuthenticated(tenantId);
        if (userName == null || userName.isEmpty()) {
            throw new OperationException("Openstack Connect failed!");
        }
        final Nova nova = iOpenstackIdentityService.getNova(userName);
        return nova.servers.get(serverId);
    }

    @Override
    public void changeInstancePassword(Integer tenantId, String serverId, String newPassword) throws OperationException {
        String checkInfo = iOpenstackIdentityService.checkUserAuthenticated(tenantId);
        if (StringUtils.isEmpty(checkInfo) || checkInfo == null) {
            return;
        }
        final Nova nova = iOpenstackIdentityService.getNova(checkInfo);
        nova.servers.changePassword(serverId, newPassword);
        return;
    }

    @Override
    public void stopInstance(Integer tenantId, String serverId) throws OperationException {
        String checkInfo = iOpenstackIdentityService.checkUserAuthenticated(tenantId);
        if (StringUtils.isEmpty(checkInfo) || checkInfo == null) {
            return;
        }
        final Nova nova = iOpenstackIdentityService.getNova(checkInfo);
        nova.servers.stop(serverId);
        return;
    }

    @Override
    public void rebootInstance(Integer tenantId, String serverId) throws OperationException {
        String checkInfo = iOpenstackIdentityService.checkUserAuthenticated(tenantId);
        if (StringUtils.isEmpty(checkInfo) || checkInfo == null) {
            return;
        }
        final Nova nova = iOpenstackIdentityService.getNova(checkInfo);
        nova.servers.reboot(serverId);
        return;
    }

    @Override
    public void bootInstance(Integer tenantId, String serverId) throws OperationException {
        String checkInfo = iOpenstackIdentityService.checkUserAuthenticated(tenantId);
        if (StringUtils.isEmpty(checkInfo) || checkInfo == null) {
            return;
        }
        final Nova nova = iOpenstackIdentityService.getNova(checkInfo);
        nova.servers.start(serverId);
        return;
    }

    @Override
    public void removeInstance(Integer tenantId, String serverId) throws OperationException {
        String checkInfo = iOpenstackIdentityService.checkUserAuthenticated(tenantId);
        if (checkInfo == null || checkInfo.isEmpty()) {
            return;
        }
        final Nova nova = iOpenstackIdentityService.getNova(checkInfo);
        nova.servers.delete(serverId);
        return;
    }

    @Override
    public List<ServerDTO> listServers(Integer tenantId) throws OperationException {
        String checkInfo = iOpenstackIdentityService.checkUserAuthenticated(tenantId);
        if (StringUtils.isEmpty(checkInfo) || checkInfo == null) {
            throw new OperationException("CheckUserAuthenticated Failed!");
        }
        final Nova nova = iOpenstackIdentityService.getNova(checkInfo);
        List<Server> serverList = nova.servers.list();
        List<ServerDTO> serverDTOS = new ArrayList<>();
        for (Server server : serverList) {
            ServerDTO serverDTO = new ServerDTO();
            BeanUtils.copyProperties(server, serverDTO);
            serverDTOS.add(serverDTO);
        }
        return serverDTOS;
    }

    @Override
    public Boolean createServer(Integer tenantId, ServerDTO serverDTO, String instanceType) throws OperationException {
        try {
            String checkInfo = iOpenstackIdentityService.checkUserAuthenticated(tenantId);
            if (checkInfo == null || checkInfo.isEmpty()) {
                return Boolean.FALSE;
            }
            final Nova nova = iOpenstackIdentityService.getNova(checkInfo);
            Server server = new Server();
            if (instanceType.equals(OpenstackConstants.CATEGORYCODE_VMWARESERVER)) {
                List<Server.SnapshotInfo> snapshotInfos = new ArrayList<>();
                Server.SnapshotInfo snapshotInfo = new Server.SnapshotInfo();
                List<Server.SnapshotInfo> snapshotInfoList = new ArrayList<>();
                BeanUtils.copyProperties(serverDTO.getSnapShots(), snapshotInfoList);
                server.setDiskConfig(serverDTO.getDiskConfig());
                server.setAvailabilityZone(serverDTO.getAvailabilityZone());
            } else if (instanceType.equals(OpenstackConstants.CATEGORYCODE_PHYSICALSERVER)) {
                server.setImageRef(serverDTO.getImageRef());
                server.setMinCount(serverDTO.getMinCount());
                server.setMaxCount(serverDTO.getMaxCount());
                server.setConfigDrive(server.getConfigDrive());
            }
            server.setUserData(serverDTO.getUserData());
            server.setFlavorRef(serverDTO.getFlavorRef());
            //设置网络
            Server.Network network = new Server.Network();
            network.setUuid(serverDTO.getServerNetworks().get(0).getUuid());
            List<Server.Network> networks = new ArrayList<>();
            networks.add(network);
            server.setNetworks(networks);
            //设置安全组
            Server.Group group = new Server.Group();
            if (serverDTO.getServerGroupDTOS().size() == 0) {
                group.setName("default");
            } else {
                group.setName(serverDTO.getServerGroupDTOS().get(0).getName());
            }
            List<Server.Group> listGroup = new ArrayList<>();
            listGroup.add(group);
            server.setSecurityGroups(listGroup);
            nova.servers.create(server);
        } catch (OperationException e) {
            e.printStackTrace();
            throw new OperationException(e.getMessage());
        }
        return Boolean.TRUE;
    }

    @Override
    public void connectVolume(String serverId, String volumeInfo, Integer tenantId) throws OperationException {
        try {
            String checkInfo = iOpenstackIdentityService.checkUserAuthenticated(tenantId);
            if (checkInfo == null || checkInfo.isEmpty()) {
                return;
            }
            final Nova nova = iOpenstackIdentityService.getNova(checkInfo);
            nova.servers.connectVolume(serverId, volumeInfo);
        } catch (OperationException e) {
            e.printStackTrace();
            throw new OperationException(e.getMessage());
        }
        return;
    }

    @Override
    public Boolean createServerGroup(Integer tenantId, String name, String policy) {
        try {
            String checkInfo = iOpenstackIdentityService.checkUserAuthenticated(tenantId);
            if (checkInfo == null || checkInfo.isEmpty()) {
                return false;
            }
            final Nova nova = iOpenstackIdentityService.getNova(checkInfo);
            ServerGroup serverGroup = new ServerGroup();
            serverGroup.setName(name);
            serverGroup.setPolicy(ServerGroupAffinity.valueOf(policy).name());
            ServerGroup retServerGroup = nova.serverGroups.createServerGroup(serverGroup);
            int count = iOpenstackServerGroupService.insertServerGroupToDB(retServerGroup, tenantId);
            if (count > 0) {
                return true;
            }
            return false;
        } catch (OperationException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ServerGroupVO> getServerGroup(Integer tenantId) {
        List<ServerGroupDTO> serverGroupDTOS = iOpenstackServerGroupService.getServerGroup(tenantId);
        List<ServerGroupVO> serverGroupVOS = new ArrayList<>();
        for (ServerGroupDTO serverGroup : serverGroupDTOS) {
            ServerGroupVO serverGroupVO = new ServerGroupVO();
            serverGroupVO.setName(serverGroup.getName());
            serverGroupVO.setPolicy(ServerGroupAffinity.valueOf(serverGroup.getPolicy()).toString());
            serverGroupVO.setInstanceNum(serverGroup.getInstanceNum());
            serverGroupVOS.add(serverGroupVO);
        }
        return serverGroupVOS;
    }

    @Override
    public Boolean removeServerGroup(Integer tenantId, String serverGroupId) {
        try {
            String checkInfo = iOpenstackIdentityService.checkUserAuthenticated(tenantId);
            if (checkInfo == null || checkInfo.isEmpty()) {
                return false;
            }
            final Nova nova = iOpenstackIdentityService.getNova(checkInfo);
            nova.serverGroups.deleteServerGroup(serverGroupId);
            return true;
        } catch (OperationException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<AvailabilityZoneVO> getAvailableZone(Integer tenantId) {
        List<AvailabilityZoneVO> availableZones = new ArrayList<>();
        try {
            String checkInfo = iOpenstackIdentityService.checkUserAuthenticated(tenantId);
            if (checkInfo == null || checkInfo.isEmpty()) {
                return availableZones;
            }
            final Nova nova = iOpenstackIdentityService.getNova(checkInfo);
            List<AvailableZone> availableZonesList = nova.availabilityZones.list();
            for (AvailableZone availableZone : availableZonesList) {
                AvailabilityZoneVO availabilityZoneVO = new AvailabilityZoneVO();
                availabilityZoneVO.setZoneName(availableZone.getName());
                availabilityZoneVO.setStatus(availableZone.isAvailable());
                availableZones.add(availabilityZoneVO);
            }
        } catch (OperationException e) {
            e.printStackTrace();
        }
        return availableZones;
    }

    @Override
    public AggregateVO createAggregate(AggregateDTO aggregateDTO) {
        AggregateVO aggregateVO = null;
        try {
            boolean valid = iOpenstackIdentityService.checkAdminAuthenticated();
            if (!valid) {
                return null;
            }
            final Nova nova = iOpenstackIdentityService.getAdminNova();
            Aggregate aggregate = nova.aggregates.create(aggregateDTO.getAggregateName(), aggregateDTO.getAvailabilityZone());
            aggregateVO = new AggregateVO();
            aggregateVO.setId(aggregate.getId());
            aggregateVO.setName(aggregate.getName());
            aggregateVO.setAvailabilityZone(aggregate.getAvailabilityZone());
        } catch (OperationException e) {
            e.printStackTrace();
        }
        return aggregateVO;
    }

    @Override
    public List<HypervisorVO> getAllHypervisors(String filterItem) {
        List<HypervisorVO> hypervisorVOList = new ArrayList<>();
        try {
            boolean valid = iOpenstackIdentityService.checkAdminAuthenticated();
            if (!valid) {
                return null;
            }

            final Nova nova = iOpenstackIdentityService.getAdminNova();
            List<Hypervisor> listHypervisor = nova.hypervisors.list();
            if (!filterItem.isEmpty() || !filterItem.equals("")) {
                listHypervisor = listHypervisor.stream().filter(vmm -> vmm != null && vmm.getHostname()
                        .contains(filterItem)).collect(Collectors.toList());
            }
            for (Hypervisor hyper : listHypervisor) {
                if (hyper.isValid()) {
                    HypervisorVO hypervisorVO = new HypervisorVO();
                    if (hyper.getRegion() != null) {
                        hypervisorVO.setRegion(hyper.getRegion());
                    }
                    if (hyper.getHostname() != null) {
                        hypervisorVO.setHostName(hyper.getHostname());
                    }
                    hypervisorVO.setType(hyper.getType());
                    hypervisorVO.setState(hyper.getState());
                    hypervisorVO.setValid(hyper.isValid());
                    hypervisorVO.setStatus(hyper.getStatus());
                    if (hyper.getHostIp() != null) {
                        hypervisorVO.setHostIp(hyper.getHostIp());
                    }

                    hypervisorVOList.add(hypervisorVO);
                }
            }
            return hypervisorVOList;
        } catch (OperationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addAggregateHost(String aggregateId, List<String> hostList) {
        try {
            boolean valid = iOpenstackIdentityService.checkAdminAuthenticated();
            if (!valid) {
                return;
            }
            final Nova nova = iOpenstackIdentityService.getAdminNova();
            for (String host : hostList) {
                nova.aggregates.addHost(aggregateId, host);
            }

        } catch (OperationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeAggregateHost(String aggregateId, List<String> hostList) {
        try {
            boolean valid = iOpenstackIdentityService.checkAdminAuthenticated();
            if (!valid) {
                return;
            }
            final Nova nova = iOpenstackIdentityService.getAdminNova();
            for (String host : hostList) {
                nova.aggregates.removeHost(aggregateId, host);
            }

        } catch (OperationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public AggregateVO updateAggregate(AggregateDTO aggregateDTO) {
        AggregateVO aggregateVO = new AggregateVO();
        try {
            boolean valid = iOpenstackIdentityService.checkAdminAuthenticated();
            if (!valid) {
                return aggregateVO;
            }
            final Nova nova = iOpenstackIdentityService.getAdminNova();
            Aggregate aggregate = nova.aggregates.update(String.valueOf(aggregateDTO.getAggregateId()),
                    aggregateDTO.getAggregateName(), aggregateDTO.getAvailabilityZone());
            aggregateVO.setId(aggregate.getId());
            return aggregateVO;
        } catch (OperationException e) {
            e.printStackTrace();
        }
        return aggregateVO;
    }

    @Override
    public AggregateVO createAggregateMetaDate(String aggregateId, List<MetaDataDTO> metaDataDTOS) {
        AggregateVO aggregateVO;
        try {
            if (metaDataDTOS.size() == 0) {
                return null;
            }

            Map<String, String> metaData = new HashMap<>();
            for (MetaDataDTO meta : metaDataDTOS) {
                metaData.put(meta.getKey(), meta.getValue());
            }

            boolean valid = iOpenstackIdentityService.checkAdminAuthenticated();
            if (!valid) {
                return null;
            }
            final Nova nova = iOpenstackIdentityService.getAdminNova();

            Aggregate aggregate = nova.aggregates.setMetaData(aggregateId, metaData);
            if (aggregate != null) {
                aggregateVO = new AggregateVO();
                aggregateVO.setId(aggregate.getId());
                return aggregateVO;
            }
        } catch (OperationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getAggregateMetaDate(String aggregateId) {
        try {
            boolean valid = iOpenstackIdentityService.checkAdminAuthenticated();
            if (!valid) {
                return "";
            }
            final Nova nova = iOpenstackIdentityService.getAdminNova();
            Aggregate aggregate = nova.aggregates.get(aggregateId);
            return JSONObject.toJSONString(aggregate.getMetadata());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public void removeAggregateById(String aggregateId) {
        try {
            boolean valid = iOpenstackIdentityService.checkAdminAuthenticated();
            if (!valid) {
                return;
            }
            final Nova nova = iOpenstackIdentityService.getAdminNova();
            Aggregate aggregate = nova.aggregates.get(aggregateId);
            if (aggregate == null) {
                return;
            }
            List<String> hosts = aggregate.getHosts();
            for (String host : hosts) {
                nova.aggregates.removeHost(aggregateId, host);
            }
            nova.aggregates.delete(aggregateId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    @Override
    public AggregateVO listAggregates(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        AggregateVO aggregateVO = null;
        try {
            boolean valid = iOpenstackIdentityService.checkAdminAuthenticated();
            if (!valid) {
                return null;
            }
            final Nova nova = iOpenstackIdentityService.getAdminNova();
            Aggregate aggregate = nova.aggregates.get(id);
            aggregateVO = new AggregateVO();
            aggregateVO.setId(aggregate.getId());
            aggregateVO.setHosts(aggregate.getHosts());
            aggregateVO.setMetadata(JSONObject.toJSONString(aggregate.getMetadata()));
            aggregateVO.setName(aggregate.getName());
            aggregateVO.setAvailabilityZone(aggregate.getAvailabilityZone());
            return aggregateVO;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String createFlavor(FlavorDTO flavorDTO) throws OperationException {
        try {
            boolean valid = iOpenstackIdentityService.checkAdminAuthenticated();
            if (!valid) {
                return null;
            }
            final Nova nova = iOpenstackIdentityService.getAdminNova();
            Flavor flavor = new Flavor();
            flavor.setName(flavorDTO.getFlavorName());
            flavor.setRam(flavorDTO.getFlavorRam() * 1024);
            flavor.setDisk(flavorDTO.getFlavorDisk() * 1024);
            flavor.setVcpus(flavorDTO.getFlavorVcpu());
            flavor.setId(flavorDTO.getFlavorId());
            flavor.setRxtxFactor(1.0);
            Flavor flavorDetail = nova.flavors.create(flavor);
            if (flavorDTO.getExtraSpecs() != null && !flavorDTO.getExtraSpecs().isEmpty()) {
                ExtraSpec extraSpec = new ExtraSpec();
                extraSpec.setAggregateInstanceExtraSpecs(flavorDTO.getExtraSpecs());
                nova.extraSpecs.createFlavorExtraSpecs(extraSpec, flavorDetail.getId());
            }
            if (flavorDetail != null) {
                //插入数据库
                OpenstackFlavors openstackFlavors = new OpenstackFlavors();
                openstackFlavors.setFlavorId(flavorDetail.getId());
                openstackFlavors.setFlavorName(flavorDetail.getName());
                openstackFlavors.setFlavorRam(flavorDetail.getRam());
                openstackFlavors.setFlavorDisk(flavorDetail.getDisk());
                openstackFlavors.setFlavorVcpu(flavorDetail.getVcpus());
                ExtraSpec extraSpec = nova.extraSpecs.getFlavorExtraSpecs(flavorDetail.getId());
                openstackFlavors.setFlavorType(flavorDTO.getCategoryCode());
                openstackFlavors.setExtraSpecs(JSONObject.toJSONString(extraSpec));
                iOpenstackFlavorsService.insertOpenstackFlavor(openstackFlavors);
                return flavorDetail.getId();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new OperationException(e.getMessage());
        }
    }

    @Override
    public FlavorDTO getFlavorById(String flavorId, String categoryCode) {
        OpenstackFlavors openstackFlavors = iOpenstackFlavorsService.getFlavorByFlavorId(flavorId);
        FlavorDTO flavorDTO = new FlavorDTO();
        flavorDTO.setFlavorId(openstackFlavors.getFlavorId());
        flavorDTO.setFlavorName(openstackFlavors.getFlavorName());
        if (categoryCode.equals(OpenstackConstants.CATEGORYCODE_VMWARESERVER)) {
            flavorDTO.setFlavorVcpu(openstackFlavors.getFlavorVcpu());
            flavorDTO.setFlavorRam(openstackFlavors.getFlavorRam());
            flavorDTO.setFlavorDisk(openstackFlavors.getFlavorDisk());
        }

        flavorDTO.setExtraSpecs(openstackFlavors.getExtraSpecs());
        return flavorDTO;
    }

    @Override
    public void updateFlavor(FlavorDTO flavorDTO) throws OperationException {
        /**底层目前不支持更新规格类型，需要先将规格信息删除，然后在重建规格*/
        boolean status = this.removeFlavor(flavorDTO.getFlavorOriginId());
        if (!status) {
            return;
        }
        iOpenstackFlavorsService.deleteFlavorById(flavorDTO.getFlavorOriginId());
        this.createFlavor(flavorDTO);
//        try {
//            boolean valid = iOpenstackIdentityService.checkAdminAuthenticated();
//            if (!valid) {
//                return;
//            }
//            final Nova nova = iOpenstackIdentityService.getAdminNova();
//            Flavor flavor = new Flavor();
//            flavor.setName(flavorDTO.getFlavorName());
//            flavor.setRam(flavorDTO.getFlavorRam());
//            flavor.setDisk(flavorDTO.getFlavorDisk());
//            flavor.setVcpus(flavorDTO.getFlavorVcpu());
//            flavor.setId(flavorDTO.getFlavorId());
//            flavor.setRxtxFactor(1.0);
//            Flavor flavorDetail = nova.flavors.update(flavor);
//            if (flavorDetail != null) {
//                //插入数据库
//                OpenstackFlavors openstackFlavors = new OpenstackFlavors();
//                openstackFlavors.setFlavorId(flavorDetail.getId());
//                openstackFlavors.setFlavorName(flavorDetail.getName());
//                if (flavorDTO.getCategoryCode().equals(OpenstackConstants.CATEGORYCODE_VMWARESERVER)) {
//                    openstackFlavors.setFlavorRam(flavorDetail.getRam());
//                    openstackFlavors.setFlavorDisk(flavorDetail.getDisk());
//                    openstackFlavors.setFlavorVcpu(flavorDetail.getVcpus());
//                }
//                ExtraSpec extraSpec = nova.extraSpecs.getFlavorExtraSpecs(flavorDetail.getId());
//                if(flavorDetail.getName()!=null && flavorDetail.getName().contains(OpenstackConstants.BARE_METAL_FLAVOR_TYPE)) {
//                    openstackFlavors.setFlavorType(OpenstackConstants.CATEGORYCODE_PHYSICALSERVER);
//                    openstackFlavors.setExtraSpecs(JSONObject.toJSONString(extraSpec));
//                }else if(flavorDetail.getName()!=null) {
//                    openstackFlavors.setFlavorType(OpenstackConstants.CATEGORYCODE_VMWARESERVER);
//                    openstackFlavors.setExtraSpecs(JSONObject.toJSONString(extraSpec));
//                }
//                iOpenstackFlavorsService.updateOpenstackFlavor(openstackFlavors);
//                return;
//            }
//        }catch (Exception e) {
//            e.printStackTrace();
//            throw new OperationException(e.getMessage());
//        }
    }

    @Override
    public boolean removeFlavor(String flavorId) throws OperationException {
        if (flavorId == null || flavorId.isEmpty()) {
            return false;
        }
        try {
            boolean valid = iOpenstackIdentityService.checkAdminAuthenticated();
            if (!valid) {
                return false;
            }
            final Nova nova = iOpenstackIdentityService.getAdminNova();
            nova.flavors.delete(flavorId);
            iOpenstackFlavorsService.deleteFlavorById(flavorId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new OperationException(e.getMessage());
        }
    }

    @Override
    public List<FlavorDTO> getFlavorByIds(List<String> flavorId) {
        try {
            List<OpenstackFlavors> openstackFlavors = iOpenstackFlavorsService.getFlavorByFlavorIds(flavorId);
            List<FlavorDTO> flavorDTOS = new ArrayList<>();
            for (OpenstackFlavors flavor : openstackFlavors) {
                FlavorDTO flavorDTO = new FlavorDTO();
                flavorDTO.setFlavorId(flavor.getFlavorId());
                flavorDTO.setFlavorName(flavor.getFlavorName());
                flavorDTO.setFlavorVcpu(flavor.getFlavorVcpu());
                flavorDTO.setFlavorRam(flavor.getFlavorRam());
                flavorDTO.setFlavorDisk(flavor.getFlavorDisk());
                flavorDTO.setExtraSpecs(flavor.getExtraSpecs());
                flavorDTOS.add(flavorDTO);
            }
            return flavorDTOS;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void operateHosts(AggregateDTO aggregateDTO) {
        if (aggregateDTO == null ||
                aggregateDTO.getAggregateId() == null ||
                aggregateDTO.getHostList() == null) {
            return;
        }
        try {
            boolean valid = iOpenstackIdentityService.checkAdminAuthenticated();
            if (!valid) {
                return;
            }
            final Nova nova = iOpenstackIdentityService.getAdminNova();
            Aggregate aggregate = nova.aggregates.get(String.valueOf(aggregateDTO.getAggregateId()));
            List<String> hostList = aggregate.getHosts();
            List<String> hosts = aggregateDTO.getHostList();
            //交集公共部分
            List<String> intersection = hosts.stream().filter(item -> hostList.contains(item)).collect(Collectors.toList());
            //需要新增的部分
            List<String> reduceToAdd = hosts.stream().filter(item -> !intersection.contains(item)).collect(Collectors.toList());
            //需要删除的部分
            List<String> reduceToRemove = hostList.stream().filter(item -> !intersection.contains(item)).collect(Collectors.toList());
            for (String host : reduceToAdd) {
                nova.aggregates.addHost(String.valueOf(aggregateDTO.getAggregateId()), host);
            }
            for (String host : reduceToRemove) {
                nova.aggregates.removeHost(String.valueOf(aggregateDTO.getAggregateId()), host);
            }

        } catch (OperationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public AggregateVO getAggregateById(String id) {
        try {
            boolean valid = iOpenstackIdentityService.checkAdminAuthenticated();
            if (!valid) {
                return null;
            }
            final Nova nova = iOpenstackIdentityService.getAdminNova();
            Aggregate aggregate = nova.aggregates.get(id);
            AggregateVO aggregateVO = new AggregateVO();
            BeanUtils.copyProperties(aggregate, aggregateVO);
            return aggregateVO;
        } catch (OperationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
