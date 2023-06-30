package com.ict.cloud.wapper.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ict.cloud.common.constants.NetworkConstants;
import com.ict.cloud.common.constants.OpenstackConstants;
import com.ict.cloud.common.constants.ServerInstanceConstant;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.common.exception.ServiceException;
import com.ict.cloud.model.FloatIpDTO;
import com.ict.cloud.model.NetworkDTO;
import com.ict.cloud.model.SubnetDTO;
import com.ict.cloud.model.VpcDTO;
import com.ict.cloud.neutron.Neutron;
import com.ict.cloud.neutron.model.*;
import com.ict.cloud.nova.Nova;
import com.ict.cloud.neutron.model.SecurityGroup;
import com.ict.cloud.resource.domain.*;
import com.ict.cloud.resource.service.*;
import com.ict.cloud.result.Result;
import com.ict.cloud.vo.SecurityGroupRuleTemplateVO;
import com.ict.cloud.vo.SecurityGroupRuleVO;
import com.ict.cloud.vo.SecurityGroupVO;
import com.ict.cloud.vo.VpcsVO;
import com.ict.cloud.wapper.IOpenstackIdentityService;
import com.ict.cloud.wapper.IOpenstackNetworkingService;
import com.ict.cloud.wapper.entity.SecurityGroupDO;
import com.ict.cloud.wapper.entity.SecurityGroupRuleDO;
import com.ict.cloud.wapper.entity.SecurityGroupRuleTemplateDO;
import com.ict.cloud.wapper.mapper.SecurityGroupRuleTemplateMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service("networking")
public class OpenstackNetworkingServiceImpl implements IOpenstackNetworkingService {
    @Autowired
    private IOpenstackNetworksService iOpenstackNetworksService;
    @Resource
    private IOpenstackSecurityGroupService iOpenstackSecurityGroupService;
    @Resource
    private IOpenstackFloatIpService iOpenstackFloatIpService;
    @Resource
    private IOpenstackSubnetsService iOpenstackSubnetsService;
    @Resource
    private IOpenstackRouterService iOpenstackRouterService;
    @Autowired
    private IOpenstackSecurityGroupService openstackSecurityGroupService;
    @Resource
    private IOpenstackIdentityService iOpenstackIdentityService;
    @Resource
    private IOpenstackSecurityGroupRuleService iOpenstackSecurityGroupRuleService;
    @Resource
    private IOpenstackVPCService iOpenstackVPCService;
    @Resource
    private SecurityGroupRuleTemplateMapper securityGroupRuleTemplateMapper;

    public boolean updateOpenstackNetworkToDB() throws OperationException, ParseException {
        boolean valid = iOpenstackIdentityService.connectOpenstack();
        if(!valid){
            throw new OperationException("Openstack Connect failed!");
        }
        try{
            final Neutron neutron = iOpenstackIdentityService.getAdminNeutron();
            List<Network> networks = neutron.networks.list();
            OpenstackNetworks openstackNetworks = new OpenstackNetworks();
            List<String> existNetwork = iOpenstackNetworksService.getAllNetwork().stream().map(OpenstackNetworks::
                    getNetworkId).collect(Collectors.toList());
            for (Network network : networks) {
                //openstackNetworks.setParentId(Integer.parseInt(hypervisor.getId()));
                if (existNetwork.contains(network.getId())){
                    continue;
                }
                openstackNetworks.setNetworkId(network.getId());
                if (network.getCreated() == null) {
                    openstackNetworks.setCreateAt(null);
                } else {
                    String dateCreate = network.getCreated().replace("T", " ").replace("Z", "");
                    openstackNetworks.setCreateAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateCreate));
                }
                if (network.getUpdated() == null) {
                    openstackNetworks.setUpdatedAt(null);
                } else {
                    String dateUpdate = network.getUpdated().replace("T", " ").replace("Z", "");
                    openstackNetworks.setUpdatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateUpdate));
                }
                iOpenstackNetworksService.insertOpenstackNetwork(openstackNetworks);
            }
        }catch(Exception e) {
            throw new OperationException("updateOpenstackNetworkToDB failed!");
        }
        return true;
    }

    public boolean updateOpenstackSecurityGroupToDB() throws OperationException {
        boolean valid = iOpenstackIdentityService.connectOpenstack();
        if(!valid){
            throw new OperationException("Openstack Connect failed!");
        }
        try{
            final Neutron neutron = iOpenstackIdentityService.getAdminNeutron();
            List<SecurityGroup> securityGroups = neutron.securityGroups.list();
            OpenstackSecurityGroup openstackSecurityGroup = new OpenstackSecurityGroup();
            for (SecurityGroup securityGroup : securityGroups) {
                //openstackSecurityGroup.setParentId(Integer.parseInt(hypervisor.getId()));
                openstackSecurityGroup.setSecurityGroupId(securityGroup.getId());
                openstackSecurityGroup.setSecurityGroupName(securityGroup.getName());
                openstackSecurityGroup.setSecurityGroupTenantId(securityGroup.getTenantId());
                openstackSecurityGroupService.insertOpenstackSecurityGroup(openstackSecurityGroup);
            }
        }catch(Exception e) {
            throw new OperationException("updateOpenstackSecurityGroupToDB failed!");
        }
        return true;
    }

    @Override
    public OpenstackNetworks createUserNetwork(Network network, Integer tenantId) throws ParseException, OperationException {
        OpenstackNetworks openstackNetworks = new OpenstackNetworks();
        openstackNetworks.setNetworkId(network.getId());
        openstackNetworks.setProjectId(network.getProjectId());
        openstackNetworks.setNetworkName(network.getName());
        openstackNetworks.setNetworkType(network.getNetworkType());
        openstackNetworks.setAdminStateUp(network.getAdminStateUp());
        //.setDsnDomain(network.getDsnDomain());
        openstackNetworks.setIsDefault(network.getIsDefault());
        openstackNetworks.setShared(network.getIsShared());
        String dateCreate = network.getCreated().replace("T", " ").replace("Z", "");
        String dateUpdate = network.getUpdated().replace("T", " ").replace("Z", "");
        if (network.getCreated() == null) {
            openstackNetworks.setCreateAt(null);
        } else {
            openstackNetworks.setCreateAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateCreate));
        }
        if (network.getUpdated() == null) {
            openstackNetworks.setUpdatedAt(null);
        } else {
            openstackNetworks.setUpdatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateUpdate));
        }
        openstackNetworks.setSegmentationId(null);
        openstackNetworks.setTenantId(tenantId);
        iOpenstackNetworksService.insertOpenstackNetwork(openstackNetworks);
        return openstackNetworks;
    }

    @Override
    public List<OpenstackSubnets> getSubnetsByTenantId(Integer tenantId){ return iOpenstackSubnetsService.getSubnets(tenantId); }

    @Override
    public List<OpenstackRouters> getRoutersByTenantId(Integer tenantId) { return iOpenstackRouterService.getRouters(tenantId); }

    @Override
    public OpenstackSubnets createUserSubnet(Subnet subnet, Integer tenantId) throws ParseException, OperationException {
        OpenstackSubnets openstackSubnets = new OpenstackSubnets();
        openstackSubnets.setSubnetId(subnet.getId());
        openstackSubnets.setProjectId(subnet.getProjectId());
        openstackSubnets.setTenantId(tenantId);
        openstackSubnets.setCidr(subnet.getCidr());
        openstackSubnets.setDnsNameservers(JSONObject.toJSONString(subnet.getDnsNameservers()));
        openstackSubnets.setGatewayId(subnet.getGatewayIp());
        openstackSubnets.setNetworkId(subnet.getNetworkId());
        openstackSubnets.setSubnetName(subnet.getName());
        openstackSubnets.setSegmentId(null);
        String dateCreate = subnet.getCreated().replace("T", " ").replace("Z", "");
        String dateUpdate = subnet.getUpdated().replace("T", " ").replace("Z", "");
        if (subnet.getCreated() == null) {
            openstackSubnets.setCreateAt(null);
        } else {
            openstackSubnets.setCreateAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateCreate));
        }
        if (subnet.getUpdated() == null) {
            openstackSubnets.setUpdatedAt(null);
        } else {
            openstackSubnets.setUpdatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateUpdate));
        }
        iOpenstackSubnetsService.insertOpenstackSubnets(openstackSubnets);
        return openstackSubnets;
    }

    @Override
    public List<OpenstackSubnets> getAllSubnets(){
        return iOpenstackSubnetsService.getAllSubnets();
    }

    @Override
    public OpenstackRouters createUserRouter(Router router, Integer tenantId) throws ParseException, OperationException {
        OpenstackRouters openstackRouters = new OpenstackRouters();
        openstackRouters.setRouterId(router.getId());
        openstackRouters.setAdminStateUp(router.getAdmin_state_up());
        openstackRouters.setProjectId(router.getProject_id());
        openstackRouters.setTenantId(tenantId);
        openstackRouters.setFlavorId(null);
        openstackRouters.setStatus(router.getStatus());
        openstackRouters.setRouterName(router.getName());
        //openstackRouters.setExternalGatewayInfo(router.getExternal_gateway_info().toString());
        openstackRouters.setExternalGatewayInfo(null);
        String dateCreate = router.getCreated_at().replace("T", " ").replace("Z", "");
        String dateUpdate = router.getUpdated_at().replace("T", " ").replace("Z", "");
        if (router.getCreated_at() == null) {
            openstackRouters.setCreateAt(null);
        } else {
            openstackRouters.setCreateAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateCreate));
        }
        if (router.getUpdated_at() == null) {
            openstackRouters.setUpdatedAt(null);
        } else {
            openstackRouters.setUpdatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateUpdate));
        }
        Map<String, Object> extraInfo = new HashMap<>();
        extraInfo.put("subnet_ids", router.getSubnetId().toString());
        extraInfo.put("port_id", router.getPortId());
        JSONObject json = new JSONObject(extraInfo);
        openstackRouters.setExternalGatewayInfo(json.toJSONString());
        iOpenstackRouterService.insertOpenstackRouters(openstackRouters);
        return openstackRouters;
    }
    @Override
    public void updateFloatIpStatusByIp(String floatIp, String status, Integer detailId, String orderId) throws ServiceException {
        iOpenstackFloatIpService.updateFloatIpStatusByIp(floatIp, status, detailId, orderId);
    }

    @Override
    public OpenstackNetworks createNetwork(Integer tenantId)  {
        try{
            OpenstackUsers openstackUsers = iOpenstackIdentityService.getUserByTenantId(tenantId);
            boolean valid = iOpenstackIdentityService.userConnectOpenstack(openstackUsers.getUserName(),
                    openstackUsers.getUserName(), new String(Base64.getDecoder().decode(openstackUsers.getPassword())));
            if (!valid) {
                throw new OperationException("OpenStack connect failed!");
            }
            final Neutron neutron = iOpenstackIdentityService.getNeutron(openstackUsers.getUserName());
            //该用户没有内网，创建内网
            Network network = new Network();
            network.setName(OpenstackConstants.NETWORK_NAME);
            network.setProjectId(openstackUsers.getDefaultProjectId());
            network.setAdminStateUp(true);
            List<String> zoneHints = new ArrayList<>();
            zoneHints.add(OpenstackConstants.NETWORK_ZONE_HINT);
            network.setAvailabilityZoneHints(zoneHints);
            network.setPortSecurityEnabled(true);
            network.setIsShared(false);
            //network.setMtu(OpenstackConstants.NETWORK_MTU);
            Network retNetwork = neutron.networks.create(network);
            if (retNetwork == null) {
                return null;
            }
            //同步到数据库
            OpenstackNetworks openstackNetworks = this.createUserNetwork(retNetwork, tenantId);
            return openstackNetworks;
        } catch (OperationException opErr) {
            opErr.printStackTrace();
            //throw new OperationException(opErr.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            //throw new ServiceException(e.getMessage());
        }
        return null;
    }

    private Subnet getSubnetPrefix(String projectId, String networkId) {
        Subnet subnet = new Subnet();
        subnet.setProjectId(projectId);
//        List<String> subArray = new ArrayList<>();
//        subArray.add(OpenstackConstants.SUBNET_CIDR);
        subnet.setNetworkId(networkId);
        subnet.setName(OpenstackConstants.SUBNET_NAME);
        subnet.setIpvVersion(OpenstackConstants.SUBNET_IP_VERSION);
        subnet.setCidr(OpenstackConstants.SUBNET_CIDR);
        subnet.setGatewayIp(OpenstackConstants.NETWORK_GATEWAY);
        List<String> dsnServer = new ArrayList<>();
        dsnServer.add(OpenstackConstants.NETWORK_DNS);
        subnet.setDnsNameservers(dsnServer);
        subnet.setEnableDhcp(OpenstackConstants.NETWORK_DHCP);
        return subnet;
    }

    private Boolean checkSubnetRepeat(List<Subnet> subnets, Subnet subnet) {
        String newCidr = subnet.getCidr();
        String newSubnetSegment = null;
        String[] newSegment = newCidr.split("\\.");
        if (newSegment.length < 4) { return false; }
        if (newCidr.contains("24")) {
            newSubnetSegment = newSegment[0] + "." + newSegment[1] + "." + newSegment[2];
        }else if (newCidr.contains("16")) {
            newSubnetSegment = newSegment[0] + "." + newSegment[1];
        }
        for(Subnet existSubnet : subnets) {
            String cidr = existSubnet.getCidr();
            String[] cidrArray = cidr.split("\\.");
            String subnetSegment = null;
            if (cidrArray.length < 4) { return false; }
            if (cidr.contains("24")) {
                subnetSegment = cidrArray[0] + "." + cidrArray[1] + "." + cidrArray[2];
            }else if (cidr.contains("16")) {
                subnetSegment = cidrArray[0] + "." + cidrArray[1];
            }
            if (newSubnetSegment.equals(subnetSegment)) { return false; }
        }
        return true;
    }

    @Override
    public OpenstackSubnets createSubnet(Integer tenantId, String networkId, Subnet subnet) throws OperationException {
        try{
            OpenstackUsers openstackUsers = iOpenstackIdentityService.getUserByTenantId(tenantId);
            boolean valid = iOpenstackIdentityService.userConnectOpenstack(openstackUsers.getUserName(), openstackUsers
                    .getUserName(), new String(Base64.getDecoder().decode(openstackUsers.getPassword())));
            if (!valid) {
                throw new OperationException("OpenStack connect failed!");
            }
            final Neutron neutron = iOpenstackIdentityService.getNeutron(openstackUsers.getUserName());
            List<Subnet> subnets = neutron.subnets.list();
            if (subnet == null) {
                subnet = this.getSubnetPrefix(openstackUsers.getDefaultProjectId(), networkId);
            }
            if (subnet != null) {
                Boolean subnetStatus = checkSubnetRepeat(subnets, subnet);
                if (!subnetStatus) {
                    throw new OperationException("子网网段冲突");
                }
                Subnet retSubnet = neutron.subnets.create(subnet);
                if (retSubnet == null) {
                    return null;
                }
                return this.createUserSubnet(retSubnet, tenantId);
            }
        }catch (OperationException opErr) {
            opErr.printStackTrace();
            throw new OperationException(opErr.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            throw new OperationException(e.getMessage());
        }
        return null;
    }

    @Override
    public OpenstackRouters createRouter(Integer tenantId, String subnetId) {
        try{
            OpenstackUsers openstackUsers = iOpenstackIdentityService.getUserByTenantId(tenantId);
            boolean valid = iOpenstackIdentityService.userConnectOpenstack(openstackUsers.getUserName(),
                    openstackUsers.getUserName(), new String(Base64.getDecoder().decode(openstackUsers.getPassword())));
            if (!valid) {
                throw new OperationException("OpenStack connect failed!");
            }
            final Neutron neutron = iOpenstackIdentityService.getNeutron(openstackUsers.getUserName());
            Router router = new Router();
            router.setAdmin_state_up(true);
            router.setName(OpenstackConstants.ROUTER_NAME);
            Router.GatewayInfo gatewayInfo = new Router.GatewayInfo();
            gatewayInfo.setNetworkId(OpenstackConstants.NETWORK_OUTSIDE);
            router.setExternal_gateway_info(gatewayInfo);
            Router retRouter = neutron.routers.create(router);
            if (retRouter == null) {
                return null;
            }
            Router routerInterface = neutron.routers.addRouterInterface(retRouter.getId(), subnetId);
            if(routerInterface==null) {
                neutron.routers.delete(retRouter.getId());
                return null;
            }
            retRouter.setSubnetId(routerInterface.getSubnetId());
            retRouter.setPortId(routerInterface.getPortId());
            return this.createUserRouter(retRouter, tenantId);
        } catch (OperationException opErr) {
            opErr.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String addFloatIpToInstance(String serverId, String floatIp, String internalIp, Integer tenantId,
                                       Integer detailId, String orderId) throws OperationException {
        try {
            OpenstackUsers openstackUsers = iOpenstackIdentityService.getUserByTenantId(tenantId);
            final Nova nova = iOpenstackIdentityService.getNova(openstackUsers.getUserName());
            nova.servers.addFloatingIp(serverId, floatIp, internalIp);
            this.updateFloatIpStatusByIp(floatIp, NetworkConstants.NETWORK_ACTIVE_NAME, detailId, orderId);
            return ServerInstanceConstant.ADD_FLOAT_IP_SUCCESS;
        }catch (Exception e) {
            e.printStackTrace();
            throw new OperationException(e.getMessage());
        }
    }

    @Override
    public synchronized void initNetworkSubnetRouter(Integer tenantId, Boolean netNeed) throws ServiceException {
        try{
            List<OpenstackNetworks> networkId = new ArrayList<>();
            if(netNeed) {
                OpenstackNetworks newNet = this.createNetwork(tenantId);
                if(newNet==null) {
                    for(int i=0; i<5; ++i){
                        Thread.sleep(3000);
                        newNet = this.createNetwork(tenantId);
                        if(newNet!=null){ break; }
                    }
                    if(newNet == null) {
                        throw new ServiceException("Network Create Failed!");
                    }
                }
                networkId.add(newNet);
            }else {
                networkId.addAll(iOpenstackNetworksService.getNetworks(tenantId));
            }

            if (networkId.size() != 0) {
                List<OpenstackSubnets> openstackSubnets = this.getSubnetsByTenantId(tenantId);
                if (openstackSubnets.size() == 0) {
                    //创建子网
                    OpenstackSubnets newSubnet = this.createSubnet(tenantId,
                            networkId.get(0).getNetworkId(), null);
                    if(newSubnet==null) {
                        for(int i=0; i<5; ++i) {
                            Thread.sleep(2000);
                            newSubnet = this.createSubnet(tenantId,
                                    networkId.get(0).getNetworkId(), null);
                            if(newSubnet!=null) { break; }
                        }
                        if(newSubnet==null){
                            throw new ServiceException("Subnet Create Failed!");
                        }
                    }else {
                        OpenstackVpcs openstackVpcs = new OpenstackVpcs();
                        openstackVpcs.setName("vpc-default");
                        openstackVpcs.setSegment(OpenstackConstants.SUBNET_CIDR);
                        openstackVpcs.setRegion("华南一区");
                        openstackVpcs.setStatus("0");
                        openstackVpcs.setRouterName(OpenstackConstants.ROUTER_NAME);
                        openstackVpcs.setTenantId(tenantId);
                        iOpenstackVPCService.insertVPC(openstackVpcs);
                    }
                    openstackSubnets.add(newSubnet);
                }
                List<OpenstackRouters> openstackRouters = this.getRoutersByTenantId(tenantId);
                if (openstackRouters.size() == 0) {
                    OpenstackRouters newRouter = this.createRouter(tenantId, openstackSubnets.get(0).getSubnetId());
                    if(newRouter==null){
                        for(int i=0; i<5; ++i){
                            Thread.sleep(3000);
                            newRouter = this.createRouter(tenantId, null);
                            if(newRouter!=null) { break; }
                        }
                        if(newRouter==null){
                            throw new ServiceException("Router Create Failed!");
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public String createFloatIp(Integer tenantId, Integer detailId, String orderId) throws OperationException {
        OpenstackUsers openstackUsers = iOpenstackIdentityService.getUserByTenantId(tenantId);
        boolean valid = iOpenstackIdentityService.userConnectOpenstack(openstackUsers.getUserName(), openstackUsers.getUserName(),
                new String(Base64.getDecoder().decode(openstackUsers.getPassword())));
        if (!valid) {
            throw new OperationException("OpenStack connect failed!");
        }

        final Neutron neutron = iOpenstackIdentityService.getNeutron(openstackUsers.getUserName());
        FloatIp floatIp = new FloatIp();
        floatIp.setProject_id(openstackUsers.getDefaultProjectId());
        floatIp.setFloating_network_id(OpenstackConstants.NETWORK_OUTSIDE);
        floatIp.setDescription("Floating ip for " + openstackUsers.getUserName());
        FloatIp retFloatIp = neutron.floatIps.create(floatIp);
        if(retFloatIp ==null || retFloatIp.getId() == null) {
            return null;
        }
        OpenstackFloatips openstackFloatips = new OpenstackFloatips();
        openstackFloatips.setTenantId(tenantId);
        openstackFloatips.setStatus(floatIp.getStatus());
        openstackFloatips.setFloatipId(floatIp.getId());
        openstackFloatips.setFloatNetworkId(floatIp.getFloating_network_id());
        openstackFloatips.setFixedIpAddress(floatIp.getFloating_ip_address());
        openstackFloatips.setDetailId(detailId);
        openstackFloatips.setOrderId(orderId);
        iOpenstackFloatIpService.insertOpenstackFloatIp(openstackFloatips);
        return retFloatIp.getId();
    }

    @Override
    public int countTenantFloatIp(Integer tenantId) {
        return iOpenstackFloatIpService.countFloatIpByTenantId(tenantId);
    }

    @Override
    public void deleteFloatIpByAddr(Integer tenantId, String floatIp) throws OperationException {
        try {
            OpenstackUsers openstackUsers = iOpenstackIdentityService.getUserByTenantId(tenantId);
            boolean valid = iOpenstackIdentityService.userConnectOpenstack(openstackUsers.getUserName(),
                    openstackUsers.getUserName(), new String(Base64.getDecoder().decode(openstackUsers.getPassword())));
            if (!valid) {
                throw new OperationException("OpenStack connect failed!");
            }
            final Neutron neutron = iOpenstackIdentityService.getNeutron(openstackUsers.getUserName());
            List<OpenstackFloatips> openstackFloatips = iOpenstackFloatIpService.getFloatIpByTenantIdAndIP(tenantId, floatIp);
            if(openstackFloatips!=null && openstackFloatips.size()==1) {
                neutron.floatIps.delete(openstackFloatips.get(0).getFloatipId());
            }
            iOpenstackFloatIpService.deleteFloatIp(tenantId, openstackFloatips.get(0).getDetailId(), openstackFloatips.get(0).getOrderId());
        }catch (Exception e) {
            throw new OperationException(e.getMessage());
        }
    }

    @Override
    public String getFloatIdByOrderId(Integer tenantId, String orderId) throws OperationException {
        List<OpenstackFloatips> floatips = iOpenstackFloatIpService.getFloatIpByTenantAndOrderId(tenantId, null, orderId);
        if(floatips.size()>0){
            return floatips.get(0).getFloatipId();
        }else {
            throw new OperationException("FloatIP number is error!");
        }
    }

    @Override
    public void insertSecurityGroupRules(List<SecurityGroupRule> securityGroupRules, Integer tenantId) throws ServiceException {
        List<OpenstackSecurityGroupRules> openstackSecurityGroupRulesList = new ArrayList<>();
        for (SecurityGroupRule rule : securityGroupRules) {
            OpenstackSecurityGroupRules openstackSecurityGroupRules = new OpenstackSecurityGroupRules();
            openstackSecurityGroupRules.setDirection(rule.getDirection());
            openstackSecurityGroupRules.setProtocol(rule.getProtocol());
            openstackSecurityGroupRules.setSecurityGroupId(rule.getSecurityGroupId());
            openstackSecurityGroupRules.setSecurityGroupRuleId(rule.getId());
            openstackSecurityGroupRules.setEtherType(rule.getEthertype());
            openstackSecurityGroupRules.setPortRangeMin(rule.getPortRangeMin());
            openstackSecurityGroupRules.setPortRangeMax(rule.getPortRangeMax());
            openstackSecurityGroupRules.setTenantId(tenantId);
            openstackSecurityGroupRulesList.add(openstackSecurityGroupRules);
        }
        iOpenstackSecurityGroupRuleService.batchInsertSecurityGroupRules(openstackSecurityGroupRulesList);
    }

    @Override
    public void addSecurityRoleGroup(Integer tenantId) throws ServiceException {
        try {
            OpenstackUsers openstackUsers = iOpenstackIdentityService.getUserByTenantId(tenantId);
            boolean valid = iOpenstackIdentityService.userConnectOpenstack(openstackUsers.getUserName(),
                    openstackUsers.getUserName(), new String(Base64.getDecoder().decode(openstackUsers.getPassword())));
            if (!valid) {
                throw new OperationException("OpenStack connect failed!");
            }
            //添加安全组规则
            final Neutron neutron = iOpenstackIdentityService.getNeutron(openstackUsers.getUserName());
            Optional<SecurityGroup> securityGroups = neutron.securityGroups.list().stream().findFirst();
            List<SecurityGroupRule> securityGroupRules = new ArrayList<>();
            if(securityGroups.isPresent()) {
                SecurityGroup securityGroup = securityGroups.get();
                OpenstackSecurityGroup openstackSecurityGroup = new OpenstackSecurityGroup();
                openstackSecurityGroup.setTemplateName("default");
                openstackSecurityGroup.setSecurityGroupId(securityGroup.getId());
                openstackSecurityGroup.setSecurityGroupName(securityGroup.getName());
                openstackSecurityGroup.setSecurityGroupTenantId(securityGroup.getTenantId());
                openstackSecurityGroup.setTenantId(tenantId);
                iOpenstackSecurityGroupService.insertOpenstackSecurityGroup(openstackSecurityGroup);
                SecurityGroupRuleDO securityGroupRuleDO = new SecurityGroupRuleDO(securityGroup.getId(),"egress","IPv4",  "icmp", null, null);
                SecurityGroupRule egressRule = neutron.securityGroupRules.create(this.generateSecurityGroupRule(securityGroupRuleDO));
                securityGroupRules.add(egressRule);
                securityGroupRuleDO = new SecurityGroupRuleDO(securityGroup.getId(),"ingress","IPv4",  "icmp", null, null);
                SecurityGroupRule ingressRule = neutron.securityGroupRules.create(this.generateSecurityGroupRule(securityGroupRuleDO));
                securityGroupRules.add(ingressRule);
                securityGroupRuleDO = new SecurityGroupRuleDO(securityGroup.getId(),"ingress","IPv4",  "tcp", 3389, 3389);
                SecurityGroupRule sshRule = neutron.securityGroupRules.create(this.generateSecurityGroupRule(securityGroupRuleDO));
                securityGroupRules.add(sshRule);
                securityGroupRuleDO = new SecurityGroupRuleDO(securityGroup.getId(),"ingress","IPv4",  "icmp", 22, 22);
                SecurityGroupRule rdpRule= neutron.securityGroupRules.create(this.generateSecurityGroupRule(securityGroupRuleDO));
                securityGroupRules.add(rdpRule);
            }
            insertSecurityGroupRules(securityGroupRules, tenantId);
        } catch (OperationException | ServiceException e) {
            e.printStackTrace();
            throw new ServiceException("Security Group Rules Failed!");
        }
    }

    @Override
    public List<SecurityGroup> listSecurityGroup(Integer tenantId) {
        try {
            OpenstackUsers openstackUsers = iOpenstackIdentityService.getUserByTenantId(tenantId);
            boolean valid = iOpenstackIdentityService.userConnectOpenstack(openstackUsers.getUserName(),
                    openstackUsers.getUserName(), new String(Base64.getDecoder().decode(openstackUsers.getPassword())));
            if (!valid) {
                throw new OperationException("OpenStack connect failed!");
            }
            //添加安全组规则
            final Neutron neutron = iOpenstackIdentityService.getNeutron(openstackUsers.getUserName());
            List<SecurityGroup> securityGroups = neutron.securityGroups.list();
            return securityGroups;
        } catch (OperationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteFloatIp(Integer tenantId,String orderId) throws OperationException {
        try {
            iOpenstackFloatIpService.deleteFloatIp(tenantId, null, orderId);
        } catch (Exception e) {
            throw new OperationException(e.getMessage());
        }
    }

    @Override
    public SecurityGroupRule generateSecurityGroupRule(SecurityGroupRuleDO securityGroupRuleDO) {
        if (securityGroupRuleDO.getSecurityGroupId() == null ||
                securityGroupRuleDO.getDirection() == null ||
                securityGroupRuleDO.getProtocal() == null ||
                securityGroupRuleDO.getEthertype() == null) {
            return null;
        }
        SecurityGroupRule securityGroupRule = new SecurityGroupRule();
        securityGroupRule.setSecurityGroupId(securityGroupRuleDO.getSecurityGroupId());
        securityGroupRule.setDirection(securityGroupRuleDO.getDirection());
        securityGroupRule.setEthertype(securityGroupRuleDO.getEthertype());
        securityGroupRule.setProtocol(securityGroupRuleDO.getProtocal());
        if (securityGroupRuleDO.getPortRangeMin() != null) {
            securityGroupRule.setPortRangeMin(securityGroupRuleDO.getPortRangeMin());
        }
        if (securityGroupRuleDO.getPortRangeMax() != null) {
            securityGroupRule.setPortRangeMax(securityGroupRuleDO.getPortRangeMax());
        }
        return securityGroupRule;
    }

//    @Override
//    public SecurityGroupRule getEgressSecurityGroupRule(Integer tenantId, String securityGroupId) {
//        SecurityGroupRule securityGroupRule = new SecurityGroupRule();
//        securityGroupRule.setSecurity_group_id(securityGroupId);
//        securityGroupRule.setDirection("egress");
//        securityGroupRule.setEthertype("IPv4");
//        securityGroupRule.setProtocol("icmp");
//        return securityGroupRule;
//    }
//
//    @Override
//    public SecurityGroupRule getIngressSecurityGroupRule(Integer tenantId, String securityGroupId) {
//        SecurityGroupRule securityGroupRule = new SecurityGroupRule();
//        securityGroupRule.setSecurity_group_id(securityGroupId);
//        securityGroupRule.setDirection("ingress");
//        securityGroupRule.setEthertype("IPv4");
//        securityGroupRule.setProtocol("icmp");
//        return securityGroupRule;
//    }
//
//    @Override
//    public SecurityGroupRule getRDPSecurityGroupRule(Integer tenantId, String securityGroupId) {
//        SecurityGroupRule securityGroupRule = new SecurityGroupRule();
//        securityGroupRule.setSecurity_group_id(securityGroupId);
//        securityGroupRule.setDirection("ingress");
//        securityGroupRule.setPort_range_min(3389);
//        securityGroupRule.setPort_range_max(3389);
//        securityGroupRule.setProtocol("tcp");
//        return securityGroupRule;
//    }
//
//    @Override
//    public SecurityGroupRule getSshSecurityGroupRule(Integer tenantId, String securityGroupId) {
//        SecurityGroupRule securityGroupRule = new SecurityGroupRule();
//        securityGroupRule.setSecurity_group_id(securityGroupId);
//        securityGroupRule.setDirection("ingress");
//        securityGroupRule.setEthertype("IPv4");
//        securityGroupRule.setProtocol("tcp");
//        securityGroupRule.setPort_range_max(22);
//        securityGroupRule.setPort_range_min(22);
//        return securityGroupRule;
//    }

    @Override
    public List<String> getFloatIpByTenantId(Integer tenantId) {
        return iOpenstackFloatIpService.getFloatIpByTenantId(tenantId);
    }

    @Override
    public List<String> getFloatIpByTenantAndOrderId(Integer tenantId, Integer detailId, String orderId) {
        return iOpenstackFloatIpService.getFloatIpByTenantAndOrderId(tenantId, detailId, orderId).stream().map(
                OpenstackFloatips::getFixedIpAddress).collect(Collectors.toList());
    }

    @Override
    public String releaseTenantNetwork(Integer tenantId) {
        AtomicReference<String> releaseStatus = new AtomicReference<>(NetworkConstants.NETWORK_GENERIC_SUCCESS);
        try {
            OpenstackUsers openstackUsers = iOpenstackIdentityService.getUserByTenantId(tenantId);
            boolean valid = iOpenstackIdentityService.userConnectOpenstack(openstackUsers.getUserName(), openstackUsers.getUserName(),
                    new String(Base64.getDecoder().decode(openstackUsers.getPassword())));
            if (!valid) {
                throw new OperationException("OpenStack connect failed!");
            }
            Neutron neutron = iOpenstackIdentityService.getNeutron(openstackUsers.getUserName());

            List<OpenstackFloatips> floatips = iOpenstackFloatIpService.getFloatIpsByTenantId(tenantId);
            List<String> recordIps = new ArrayList<>();
            for(OpenstackFloatips floatip : floatips){
                try {
                    recordIps.add(floatip.getFloatipId());
                    neutron.floatIps.delete(floatip.getFloatipId());
                    iOpenstackFloatIpService.deleteFloatIp(tenantId, null,null);
                } catch (OperationException e) {
                    releaseStatus.set(NetworkConstants.FLOAT_IP_RELEASE_FAILED);
                    e.printStackTrace();
                }
            }
            List<FloatIp> extraIps = neutron.floatIps.list();
            extraIps = extraIps.stream().filter(ip->!recordIps.contains(ip.getFixed_ip_address())).collect(Collectors.toList());
            if(extraIps.size()!=0){ releaseStatus.set(NetworkConstants.FLOAT_IP_RELEASE_FAILED); }
            List<OpenstackRouters> routers = iOpenstackRouterService.getRouters(tenantId);
            //List<String> recordRouter = new ArrayList<>();
            routers.forEach(router->{
                try {
                    String extraInfo = router.getExternalGatewayInfo();
                    JSONObject json = JSONObject.parseObject(extraInfo);
                    String subnetId = json.getString("subnet_ids");
                    subnetId = subnetId.substring(1, subnetId.length()-1);
                    String portId = json.getString("port_id");
                    portId = portId.substring(2, portId.length()-2);
                    if(subnetId!=null && portId != null) {
                        try {
                            //recordRouter.add(router.getRouterId());
                            neutron.routers.removeRouterInterface(router.getRouterId(), subnetId, portId);
                        } catch (OperationException e) {
                            e.printStackTrace();
                        }
                    }
                    neutron.routers.delete(router.getRouterId());
                    iOpenstackRouterService.deleteRouter(tenantId, router.getRouterId());
                } catch (OperationException e) {
                    releaseStatus.set(NetworkConstants.ROUTER_RELEASE_FAILED);
                    e.printStackTrace();
                }
            });
            List<OpenstackSubnets> subnets = iOpenstackSubnetsService.getSubnets(tenantId);
            subnets.forEach(subnet->{
                try {
                    neutron.subnets.delete(subnet.getSubnetId());
                    iOpenstackSubnetsService.deleteSubnet(tenantId, subnet.getSubnetId());
                } catch (OperationException e) {
                    releaseStatus.set(NetworkConstants.SUBNET_RELEASE_FAILED);
                    e.printStackTrace();
                }
            });
            List<OpenstackNetworks> networks = iOpenstackNetworksService.getNetworks(tenantId);
            networks.forEach(network->{
                try {
                    neutron.networks.delete(network.getNetworkId());
                    iOpenstackNetworksService.deleteNetwork(tenantId, network.getNetworkId());
                } catch (OperationException e) {
                    releaseStatus.set(NetworkConstants.NETWORK_RELEASE_FAILED);
                    e.printStackTrace();
                }
            });
        } catch (OperationException e) {
            e.printStackTrace();
            releaseStatus.set(NetworkConstants.NETWORK_RELEASE_FAILED);
        }
        return releaseStatus.get();
    }

    @Override
    public List<SecurityGroupRuleVO> listSecurityGroupRules(Integer tenantId, String securityGroupId) {
        List<OpenstackSecurityGroupRules> openstackSecurityGroupRules = iOpenstackSecurityGroupRuleService.getSecurityGroupRules(tenantId, securityGroupId);
        List<SecurityGroupRuleVO> securityGroupRuleVOS = new ArrayList<>();
        for (OpenstackSecurityGroupRules rule : openstackSecurityGroupRules) {
            SecurityGroupRuleVO securityGroupRuleVO = new SecurityGroupRuleVO();
            securityGroupRuleVO.setEtherType(rule.getEtherType());
            securityGroupRuleVO.setDirection(rule.getDirection());
            securityGroupRuleVO.setProtocol(rule.getProtocol());
            securityGroupRuleVO.setPortRangeMin(rule.getPortRangeMin());
            securityGroupRuleVO.setPortRangeMax(rule.getPortRangeMax());
            securityGroupRuleVO.setAction(rule.getAction());
            securityGroupRuleVOS.add(securityGroupRuleVO);
        }
        return securityGroupRuleVOS;
    }

    @Override
    public void removeFloatIps(Integer tenantId, List<String> floatIps) throws ServiceException {
        try {
            OpenstackUsers openstackUsers = iOpenstackIdentityService.getUserByTenantId(tenantId);
            boolean valid = iOpenstackIdentityService.userConnectOpenstack(openstackUsers.getUserName(), openstackUsers.getUserName(),
                    new String(Base64.getDecoder().decode(openstackUsers.getPassword())));
            if (!valid) {
                throw new OperationException("OpenStack connect failed!");
            }
            Neutron neutron = iOpenstackIdentityService.getNeutron(openstackUsers.getUserName());
            List<OpenstackFloatips> openstackFloatips = new ArrayList<>();
            for (String ip : floatIps) {
                List<OpenstackFloatips> openstackFloatipsList = iOpenstackFloatIpService.getFloatIpByTenantIdAndIP(tenantId, ip);
                openstackFloatips.addAll(openstackFloatipsList);
            }
            for(OpenstackFloatips floatip : openstackFloatips){
                neutron.floatIps.delete(floatip.getFloatipId());
                iOpenstackFloatIpService.deleteFloatIp(tenantId, null,null);
            }
        }catch (Exception e) {
            throw new ServiceException("删除公网IP失败");
        }
    }

    @Override
    public void addSecurityGroup(Integer tenantId, SecurityGroupDO securityGroupDO) throws OperationException {
        try {
            OpenstackUsers openstackUsers = iOpenstackIdentityService.getUserByTenantId(tenantId);
            boolean valid = iOpenstackIdentityService.userConnectOpenstack(openstackUsers.getUserName(), openstackUsers.getUserName(),
                    new String(Base64.getDecoder().decode(openstackUsers.getPassword())));
            if (!valid) {
                throw new OperationException("OpenStack connect failed!");
            }
            Neutron neutron = iOpenstackIdentityService.getNeutron(openstackUsers.getUserName());
            /** 向底层发送创建安全组的请求 */
            //SecurityGroup retSecurityGroup = neutron.securityGroups.create(securityGroupDO.getName(), securityGroupDO.getDescription());
            SecurityGroup securityGroup = new SecurityGroup();
            securityGroup.setName(securityGroupDO.getName());
            securityGroup.setDescription(securityGroupDO.getDescription());
            SecurityGroup retSecurityGroup = neutron.securityGroups.create(securityGroup);
            if (retSecurityGroup != null) {
                /** 将新创建的安全组插入数据库 */
                OpenstackSecurityGroup openstackSecurityGroup = new OpenstackSecurityGroup();
                openstackSecurityGroup.setTemplateName(securityGroupDO.getTemplateName());
                openstackSecurityGroup.setSecurityGroupId(retSecurityGroup.getId());
                openstackSecurityGroup.setSecurityGroupName(retSecurityGroup.getName());
                openstackSecurityGroup.setSecurityGroupTenantId(retSecurityGroup.getTenantId());
                openstackSecurityGroup.setTenantId(tenantId);
                iOpenstackSecurityGroupService.insertOpenstackSecurityGroup(openstackSecurityGroup);
            }
            if (securityGroupDO.getTemplateName() != null) {
                SecurityGroupRuleTemplateDO securityGroupRuleTemplateDO = securityGroupRuleTemplateMapper
                        .getSecurityGroupTemplateByName(securityGroupDO.getTemplateName());
                if(securityGroupRuleTemplateDO != null) {
                    Map<String, Object> securityTemplate = new TreeMap<>(JSON.parseObject(securityGroupRuleTemplateDO.getContext()));
                    if (securityTemplate.containsKey("context")) {
                        List<SecurityGroupRuleDO> securityGroupRuleDOS = JSONArray.parseArray(securityTemplate.get("context").toString(), SecurityGroupRuleDO.class);
                        List<SecurityGroupRule> securityGroupRules = new ArrayList<>();
                        for (SecurityGroupRuleDO securityGroupRuleDO : securityGroupRuleDOS) {
                            securityGroupRuleDO.setSecurityGroupId(retSecurityGroup.getId());
                            SecurityGroupRule generateRule = this.generateSecurityGroupRule(securityGroupRuleDO);
                            SecurityGroupRule securityGroupRule = neutron.securityGroupRules.create(generateRule);
                            securityGroupRules.add(securityGroupRule);
                        }
                        insertSecurityGroupRules(securityGroupRules, tenantId);
                    }
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            throw new OperationException(e.getMessage());
        }
    }

    @Override
    public void addSecurityGroupRules(Integer tenantId, List<SecurityGroupRuleDO> securityGroupRuleList) throws OperationException, ServiceException {
        OpenstackUsers openstackUsers = iOpenstackIdentityService.getUserByTenantId(tenantId);
        boolean valid = iOpenstackIdentityService.userConnectOpenstack(openstackUsers.getUserName(), openstackUsers.getUserName(),
                new String(Base64.getDecoder().decode(openstackUsers.getPassword())));
        if (!valid) {
            throw new OperationException("OpenStack connect failed!");
        }
        Neutron neutron = iOpenstackIdentityService.getNeutron(openstackUsers.getUserName());
        List<SecurityGroupRule> securityGroupRules = new ArrayList<>();
        for (SecurityGroupRuleDO rule : securityGroupRuleList) {
            SecurityGroupRule securityGroupRule = this.generateSecurityGroupRule(rule);
            /** 向底层发送创建安全组规则的请求 */
            SecurityGroupRule retSecurityGroupRule = neutron.securityGroupRules.create(securityGroupRule);
            if (retSecurityGroupRule != null) {
                securityGroupRules.add(retSecurityGroupRule);
            }
        }
        if (securityGroupRules.size() > 0) {
            /** 将新创建的安全组规则批量插入数据库 */
            insertSecurityGroupRules(securityGroupRules, tenantId);
        }
    }

    @Override
    public List<SecurityGroupVO> listSecurityGroups(Integer tenantId) {
        List<OpenstackSecurityGroup> openstackSecurityGroups = iOpenstackSecurityGroupService.getSecurityGroupByTenantId(tenantId);
        List<SecurityGroupVO> securityGroupVOS = new ArrayList<>();
        for (OpenstackSecurityGroup securityGroup : openstackSecurityGroups) {
            SecurityGroupVO securityGroupVO = new SecurityGroupVO();
            securityGroupVO.setName(securityGroup.getSecurityGroupName());
            securityGroupVO.setSecurityId(securityGroup.getSecurityGroupId());
            securityGroupVOS.add(securityGroupVO);
        }
        return securityGroupVOS;
    }

    @Override
    public List<OpenstackNetworks> listUserNetwork(Integer tenantId) {
        List<OpenstackNetworks> openstackNetworks = iOpenstackNetworksService.getNetworks(tenantId);
        return openstackNetworks;
    }

    /**
     * 创建虚拟私有云
     * 1. 创建虚拟私有云
     * 2. 创建子网
     * 3. 绑定路由-添加路由接口
     * 4. 更新虚拟私有云的创建状态 0（创建中）；1（创建成功）；2（创建失败）
     * */
    @Override
    public Boolean createVPC(VpcDTO vpcDTO) {
        OpenstackVpcs openstackVpcs = new OpenstackVpcs();
        openstackVpcs.setName(vpcDTO.getName());
        openstackVpcs.setSegment(vpcDTO.getSegment());
        openstackVpcs.setRegion(vpcDTO.getRegion());
        openstackVpcs.setStatus("0");
        openstackVpcs.setTenantId(vpcDTO.getTenantId());
        int vpcId = iOpenstackVPCService.insertVPC(openstackVpcs);
        if (vpcId <=0 ) { return false; }
        /** 获取默认的虚拟交换机 */

        Optional<OpenstackNetworks> networks = this.listUserNetwork(vpcDTO.getTenantId()).stream().findFirst();
        if (!networks.isPresent()) {
            return false;
        }
        OpenstackNetworks defaultNetwork = networks.get();
        if (defaultNetwork.getNetworkId() == null && defaultNetwork.getProjectId() == null) {
            return false;
        }

        Subnet subnet = new Subnet();
        subnet.setProjectId(defaultNetwork.getProjectId());
        subnet.setNetworkId(defaultNetwork.getNetworkId());
        subnet.setName(vpcDTO.getSubnetDTO().getSubnetName());
        subnet.setIpvVersion(OpenstackConstants.SUBNET_IP_VERSION);
        subnet.setCidr(vpcDTO.getSubnetDTO().getCidr());
        if (vpcDTO.getSubnetDTO().getNetworkGateway() != null) {
            subnet.setGatewayIp(vpcDTO.getSubnetDTO().getNetworkGateway());
        } else {
            subnet.setGatewayIp(OpenstackConstants.NETWORK_GATEWAY);
        }
        List<String> dsnServer = new ArrayList<>();
        if (vpcDTO.getSubnetDTO().getDnsNameservers() != null) {
            dsnServer.add(vpcDTO.getSubnetDTO().getDnsNameservers());
        }else {
            dsnServer.add(OpenstackConstants.NETWORK_DNS);
        }
        subnet.setDnsNameservers(dsnServer);
        subnet.setEnableDhcp(OpenstackConstants.NETWORK_DHCP);
        OpenstackSubnets openstackSubnets = null;
        try {
            openstackSubnets = this.createSubnet(vpcDTO.getTenantId(),
                    defaultNetwork.getNetworkId(), subnet);
            if (openstackSubnets == null) {
                /** 创建子网失败，更新虚拟私有云的状态 */
                iOpenstackVPCService.updateStatus(vpcId, NetworkConstants.NETWORK_DOWN_NAME);
            }
        } catch (OperationException e) {
            e.printStackTrace();
            iOpenstackVPCService.updateStatus(vpcId, NetworkConstants.NETWORK_DOWN_NAME);
            return false;
        }

        /** 获取添加的路由Id */
        String routerId = null;
        if (vpcDTO.getRouterName() != null) {
            openstackVpcs.setRouterName(vpcDTO.getRouterName());
            OpenstackRouters routers = this.getRouterByName(vpcDTO.getRouterName());
            routerId = routers.getRouterId();
        } else {
            Optional<OpenstackRouters> defaultRouter = this.getRoutersByTenantId(vpcDTO.getTenantId()).stream().findFirst();
            if (defaultRouter.isPresent()) {
                openstackVpcs.setRouterName(defaultRouter.get().getRouterName());
                routerId = defaultRouter.get().getRouterId();
            }
        }
        if (routerId != null) {
            /** 添加路由接口 */
            Router router = this.addRouterInterface(vpcDTO.getUserName(), routerId, openstackSubnets.getSubnetId());
            if (router != null) {
                VpcDTO updateVpc = new VpcDTO();
                updateVpc.setRouterName(router.getName());
                updateVpc.setStatus(defaultNetwork.getStatus());
                updateVpc.setSubnetId(openstackSubnets.getSubnetId());
                iOpenstackVPCService.update(updateVpc, vpcId);
                return true;
            }
        }
        iOpenstackVPCService.updateStatus(vpcId, NetworkConstants.NETWORK_DOWN_NAME);
        return false;
    }

    @Override
    public OpenstackRouters getRouterByName(String name) {
        return iOpenstackRouterService.getRouterByName(name);
    }

    @Override
    public Router addRouterInterface(String userName, String routerId, String subnetId) {
        try {
            OpenstackUsers openstackUsers = iOpenstackIdentityService.getUserByName(userName);
            boolean valid = iOpenstackIdentityService.userConnectOpenstack(userName, userName,
                    new String(Base64.getDecoder().decode(openstackUsers.getPassword())));
            if (!valid) {
                throw new OperationException("OpenStack connect failed!");
            }
            Neutron neutron = iOpenstackIdentityService.getNeutron(userName);
            Router router = neutron.routers.addRouterInterface(routerId, subnetId);
            /** 更新路由表 */
            //        Map<String, Object> extraInfo = new HashMap<>();
            //        extraInfo.put("subnet_ids", router.getSubnetId().toString());
            //        extraInfo.put("port_id", router.getPortId());
            //        JSONObject json = new JSONObject(extraInfo);
            //        openstackRouters.setExternalGatewayInfo(json.toJSONString());
            iOpenstackRouterService.updateGatewayInfo(router.getId(), (String) JSON.toJSON(router.getExternal_gateway_info()));
            return router;
        } catch (OperationException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取用户的虚拟私有云
     * 1. 获取DB中的虚拟私有云
     * 2. 根据每个私有云查询对应的服务器数量和子网数
     * */
    @Override
    public List<VpcsVO> getVpcs(Integer tenantId) {
        List<VpcsVO> vpcsVOS = new ArrayList<>();
        try {
            OpenstackUsers openstackUsers = iOpenstackIdentityService.getUserByTenantId(tenantId);
            boolean valid = iOpenstackIdentityService.userConnectOpenstack(openstackUsers.getUserName(), openstackUsers.getUserName(),
                    new String(Base64.getDecoder().decode(openstackUsers.getPassword())));
            if (!valid) {
                throw new OperationException("OpenStack connect failed!");
            }
            List<OpenstackVpcs> vpcDTOS = iOpenstackVPCService.getVpcsByTenantId(tenantId);
            if (vpcDTOS.size() == 0) {
                return vpcsVOS;
            }
            Neutron neutron = iOpenstackIdentityService.getNeutron(openstackUsers.getUserName());
            /** 同一个网络中的不同虚拟私有云 */
            Optional<OpenstackNetworks> networks = iOpenstackNetworksService.getNetworks(tenantId).stream().findFirst();
            if (networks.isPresent()) {
                Network network = neutron.networks.get(networks.get().getNetworkId());
                List<String> subnets = network.getSubnets();
                List<String> cidrs = new ArrayList<>();
                for (int i=0; i<subnets.size(); i++) {
                    String subnetId = subnets.get(i);
                    Subnet subnet = neutron.subnets.get(subnetId);
                    cidrs.add(subnet.getCidr());
                }
                /** 子网网段-数量的map映射 */
                Map<String, Integer> cidrMap = new HashMap();
                for (String cidr : cidrs) {
                    Integer count = cidrMap.get(cidr);
                    cidrMap.put(cidr, (count == null) ? 1 : count + 1);
                }

                List<Port> ports = neutron.ports.listPorts();
                ports = ports.stream().filter(port -> port.getProjectId().equals(openstackUsers.getDefaultProjectId())
                        && port.getNetworkId().equals(networks.get().getNetworkId())).collect(Collectors.toList());

                for (OpenstackVpcs vpc : vpcDTOS) {
                    VpcsVO vpcsVO = new VpcsVO();
                    vpcsVO.setName(vpc.getName());
                    vpcsVO.setRouterName(vpc.getRouterName());
                    vpcsVO.setStatus(vpc.getStatus());
                    vpcsVO.setSubnetNum(cidrMap.get(vpc.getSegment()));
                    vpcsVO.setInstanceNum(ports.size());
                    vpcsVOS.add(vpcsVO);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vpcsVOS;
    }

    @Override
    public List<SecurityGroupRuleTemplateVO> getSecurityGroupRuleTemplate() {
        List<SecurityGroupRuleTemplateDO> securityGroupRuleDOS = securityGroupRuleTemplateMapper.listSecurityGroupRuleTemplate();
        List<SecurityGroupRuleTemplateVO> securityGroupRuleTemplateVOS = new ArrayList<>();
        for (SecurityGroupRuleTemplateDO template : securityGroupRuleDOS) {
            SecurityGroupRuleTemplateVO securityGroupRuleTemplateVO = new SecurityGroupRuleTemplateVO();
            securityGroupRuleTemplateVO.setName(template.getName());
            securityGroupRuleTemplateVO.setDescription(template.getDescription());
            securityGroupRuleTemplateVOS.add(securityGroupRuleTemplateVO);
        }
        return securityGroupRuleTemplateVOS;
    }

    @Override
    public Boolean removeSecurityGroupRules(Integer tenantId, List<String> securityGroupRuleIds) {
        try {
            OpenstackUsers openstackUsers = iOpenstackIdentityService.getUserByTenantId(tenantId);
            boolean valid = iOpenstackIdentityService.userConnectOpenstack(openstackUsers.getUserName(), openstackUsers.getUserName(),
                    new String(Base64.getDecoder().decode(openstackUsers.getPassword())));
            if (!valid) {
                return false;
            }
            Neutron neutron = iOpenstackIdentityService.getNeutron(openstackUsers.getUserName());
            for (String id : securityGroupRuleIds) {
                neutron.securityGroups.delete(id);
                iOpenstackSecurityGroupRuleService.removeSecurityGroupRule(id);
            }
            //iOpenstackSecurityGroupRuleService.batchDeleteSecurityGroupRules();
            return true;
        } catch (OperationException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void addExtraSecurityGroupRule(Integer tenantId, String securityGroupId) {
        OpenstackSecurityGroup openstackSecurityGroup = iOpenstackSecurityGroupService.getSecurityGroupBySecurityGroupId(securityGroupId);
        SecurityGroupRuleTemplateDO securityGroupRuleTemplateDO = securityGroupRuleTemplateMapper
                .getSecurityGroupTemplateByName(openstackSecurityGroup.getTemplateName());
        List<OpenstackSecurityGroupRules> openstackSecurityGroupRules = iOpenstackSecurityGroupRuleService.getSecurityGroupRules(tenantId, securityGroupId);
        List<SecurityGroupRuleDO> portList = generatePortMapping(openstackSecurityGroupRules, securityGroupId, securityGroupRuleTemplateDO.getTemplateId());
        try {
            OpenstackUsers openstackUsers = iOpenstackIdentityService.getUserByTenantId(tenantId);
            boolean valid = iOpenstackIdentityService.userConnectOpenstack(openstackUsers.getUserName(), openstackUsers.getUserName(),
                    new String(Base64.getDecoder().decode(openstackUsers.getPassword())));
            if (!valid) {
                throw new OperationException("OpenStack connect failed!");
            }
            Neutron neutron = iOpenstackIdentityService.getNeutron(openstackUsers.getUserName());
            List<SecurityGroupRule> securityGroupRules = new ArrayList<>();
            for (SecurityGroupRuleDO securityGroupRuleDO : portList) {
                SecurityGroupRule generateRule = this.generateSecurityGroupRule(securityGroupRuleDO);
                SecurityGroupRule securityGroupRule = neutron.securityGroupRules.create(generateRule);
                securityGroupRules.add(securityGroupRule);
            }
            insertSecurityGroupRules(securityGroupRules, tenantId);
        } catch (OperationException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return;
    }

    private List<SecurityGroupRuleDO> generatePortMapping(List<OpenstackSecurityGroupRules> openstackSecurityGroupRules,
                                                          String securityGroupId, Integer templateId) {
        List<SecurityGroupRuleDO> portList = new ArrayList<>();
        if (templateId == 2) {
            List<OpenstackSecurityGroupRules> filterFour = openstackSecurityGroupRules.stream().filter(rule -> rule.getEtherType()
                    .equals("IPv4")).collect(Collectors.toList());
            if (filterFour.size() == 0) {
                SecurityGroupRuleDO ipvFourDO = new SecurityGroupRuleDO(securityGroupId, "ingress",
                        "IPv4", "tcp", null, null);
                portList.add(ipvFourDO);
            }
            List<OpenstackSecurityGroupRules> filterSix = openstackSecurityGroupRules.stream().filter(rule -> rule.getEtherType()
                    .equals("IPv6")).collect(Collectors.toList());
            if (filterSix.size() == 0) {
                SecurityGroupRuleDO ipvSixDO = new SecurityGroupRuleDO(securityGroupId, "ingress",
                        "IPv6", "tcp", null, null);
                portList.add(ipvSixDO);
            }
        }else {
            List<OpenstackSecurityGroupRules> filterEgress = openstackSecurityGroupRules.stream().filter(rule -> rule.getDirection()
                    .equals("egress")).collect(Collectors.toList());
            if (filterEgress.size() == 0) {
                SecurityGroupRuleDO icmpEgress = new SecurityGroupRuleDO(securityGroupId, "egress",
                        "IPv4", "icmp", null, null);
                portList.add(icmpEgress);
            }
            List<OpenstackSecurityGroupRules> filterIcmp = openstackSecurityGroupRules.stream().filter(rule -> rule.getDirection()
                    .equals("ingress") && rule.getProtocol().equals("icmp")).collect(Collectors.toList());
            if (filterIcmp.size() == 0) {
                SecurityGroupRuleDO icmpIgress = new SecurityGroupRuleDO(securityGroupId, "ingress",
                        "IPv4", "icmp", null, null);
                portList.add(icmpIgress);
            }
            List<OpenstackSecurityGroupRules> filterRdp = openstackSecurityGroupRules.stream().filter(rule ->
                    rule.getPortRangeMax() == 3389).collect(Collectors.toList());
            if (filterRdp.size() == 0) {
                SecurityGroupRuleDO rdp = new SecurityGroupRuleDO(securityGroupId, "ingress",
                        "IPv4", "tcp", 3389, 3389);
                portList.add(rdp);
            }
            List<OpenstackSecurityGroupRules> filterSSH = openstackSecurityGroupRules.stream().filter(rule ->
                    rule.getPortRangeMax() == 22).collect(Collectors.toList());
            if (filterSSH.size() == 0) {
                SecurityGroupRuleDO ssh = new SecurityGroupRuleDO(securityGroupId, "ingress",
                        "IPv4", "tcp", 22, 22);
                portList.add(ssh);
            }
            List<OpenstackSecurityGroupRules> filterWeb = openstackSecurityGroupRules.stream().filter(rule ->
                    rule.getPortRangeMax() == 80).collect(Collectors.toList());
            if (filterWeb.size() == 0) {
                SecurityGroupRuleDO web = new SecurityGroupRuleDO(securityGroupId, "ingress",
                        "IPv4", "tcp", 80, 80);
                portList.add(web);
            }
            List<OpenstackSecurityGroupRules> filterPing = openstackSecurityGroupRules.stream().filter(rule ->
                    rule.getPortRangeMax() == 443).collect(Collectors.toList());
            if (filterPing.size() == 0) {
                SecurityGroupRuleDO ping = new SecurityGroupRuleDO(securityGroupId, "ingress",
                        "IPv4", "tcp", 443, 443);
                portList.add(ping);
            }
            List<OpenstackSecurityGroupRules> filterFtp = openstackSecurityGroupRules.stream().filter(rule ->
                    rule.getPortRangeMax() == 443).collect(Collectors.toList());
            if (filterFtp.size() == 0) {
                SecurityGroupRuleDO ftp = new SecurityGroupRuleDO(securityGroupId, "ingress",
                        "IPv4", "tcp", 21, 20);
                portList.add(ftp);
            }
        }
        return portList;
    }
}
