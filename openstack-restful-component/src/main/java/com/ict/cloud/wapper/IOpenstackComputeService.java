package com.ict.cloud.wapper;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.common.exception.ServiceException;
import com.ict.cloud.model.*;
import com.ict.cloud.nova.model.Aggregate;
import com.ict.cloud.nova.model.Server;
import com.ict.cloud.resource.domain.OpenstackFlavors;
import com.ict.cloud.resource.domain.OpenstackResource;
import com.ict.cloud.vo.*;

import java.text.ParseException;
import java.util.List;

public interface IOpenstackComputeService {

    void removeInstance(Integer tenantId, String serverId) throws OperationException;

    void stopInstance(Integer tenantId, String serverId) throws OperationException;

    void rebootInstance(Integer tenantId, String serverId) throws OperationException;

    void bootInstance(Integer tenantId, String serverId) throws OperationException;

    void changeInstancePassword(Integer tenantId, String serverId, String newPassword) throws OperationException;

    Server getServerById(Integer tenantId, String serverId) throws OperationException;

    Server getServerById(String serverId) throws OperationException;

    String getSpiceConsole(Integer tenantId, String serverId, String type) throws OperationException;

    void createKeyPair(KeyPairDTO keyPairDTO, Integer tenantId) throws OperationException, ServiceException;

    List<KeyPairDTO> getKeyPairs(Integer tenantId, String keyPairName);

    void releaseTenantInstance(Integer tenantId, List<String> instanceIDS, Boolean logoutFlag) throws OperationException;

    boolean updateOpenstackResourceToDB() throws OperationException, ParseException;

    boolean updateOpenstackFlavorToDB() throws OperationException, ParseException;

    List<OpenstackResource> getOpenstackResources();

    ResourceDTO getResourceTotal();

    void updateNovaQuotaSets(String projectId) throws OperationException;

    int countServerByTenantAndServerName(Integer tenantId, String serverName);

    List<OpenstackFlavors> getFlavors();

    FlavorDTO getFlavorById(String flavorId, String categoryCode);

    List<FlavorDTO> getFlavorByIds(List<String> flavorId);

    void updateFlavor(FlavorDTO flavorDTO) throws OperationException;

    List<ServerDTO> listServers(Integer tenantId) throws OperationException;

    Boolean createServer(Integer tenantId, ServerDTO serverDTO, String instanceType) throws OperationException;

    void connectVolume(String serverId, String volumeInfo, Integer tenantId) throws OperationException;

    Boolean createServerGroup(Integer tenantId, String name, String strategy);

    List<ServerGroupVO> getServerGroup(Integer tenantId);

    Boolean removeServerGroup(Integer tenantId, String serverGroupId);

    List<AvailabilityZoneVO> getAvailableZone(Integer tenantId);

    AggregateVO createAggregate(AggregateDTO aggregateDTO);

    AggregateVO updateAggregate(AggregateDTO aggregateDTO);

    List<HypervisorVO> getAllHypervisors(String filterItem) throws OperationException;

    void addAggregateHost(String aggregateId, List<String> hostList);

    void removeAggregateHost(String aggregateId, List<String> hostList);

    AggregateVO createAggregateMetaDate(String aggregateId, List<MetaDataDTO> metaDataDTOS);

    String getAggregateMetaDate(String aggregateId);

    void removeAggregateById(String aggregateId);

    AggregateVO listAggregates(String id);

    String createFlavor(FlavorDTO flavorDTO) throws OperationException;

    boolean removeFlavor(String flavorId) throws OperationException;

    void operateHosts(AggregateDTO aggregateDTO);

    AggregateVO getAggregateById(String id);
}
