package com.ict.cloud.wapper.rpcImpl;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.common.exception.ServiceException;
import com.ict.cloud.model.*;
import com.ict.cloud.neutron.model.*;
import com.ict.cloud.resource.domain.*;
import com.ict.cloud.result.Result;
import com.ict.cloud.rpc.NetworkingApiService;
import com.ict.cloud.vo.SecurityGroupRuleVO;
import com.ict.cloud.vo.SecurityGroupVO;
import com.ict.cloud.vo.VpcsVO;
import com.ict.cloud.wapper.IOpenstackNetworkingService;
import com.ict.cloud.wapper.entity.SecurityGroupDO;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NetworkingApiServiceImpl implements NetworkingApiService {
    @Resource
    private IOpenstackNetworkingService iOpenstackNetworkingService;
    @Override
    public Result<Boolean> updateOpenstackNetworkToDB() {
        try {
            boolean updateStatus = iOpenstackNetworkingService.updateOpenstackNetworkToDB();
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
    public Result<Boolean> updateOpenstackSecurityGroupToDB() {
        try {
            boolean updateStatus = iOpenstackNetworkingService.updateOpenstackSecurityGroupToDB();
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
    public Result updateFloatIpStatusByIp(String floatIp, String status, Integer detailId, String orderId) {
        try {
            iOpenstackNetworkingService.updateFloatIpStatusByIp(floatIp, status, detailId, orderId);
            return Result.Success();
        } catch (ServiceException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<NetworkDTO> createNetwork(Integer tenantId) {
        try {
            OpenstackNetworks openstackNetworks = iOpenstackNetworkingService.createNetwork(tenantId);
            NetworkDTO networkDTO = new NetworkDTO();
            if (openstackNetworks != null) {
                BeanUtils.copyProperties(openstackNetworks, networkDTO);
            }
            return Result.Success(networkDTO);
        } catch (ParseException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<SubnetDTO> createSubnet(Integer tenantId, String networkId) {
        try {
            OpenstackSubnets openstackSubnets = iOpenstackNetworkingService.createSubnet(tenantId, networkId,  null);
            SubnetDTO subnetDTO = new SubnetDTO();
            if (openstackSubnets != null) {
                BeanUtils.copyProperties(openstackSubnets, subnetDTO);
            }
            return Result.Success(subnetDTO);
        } catch (ParseException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<RouterDTO> createRouter(Integer tenantId, String subnetId) {
        try {
            OpenstackRouters openstackRouters = iOpenstackNetworkingService.createRouter(tenantId,  subnetId);
            RouterDTO routerDTO = new RouterDTO();
            if (openstackRouters != null) {
                BeanUtils.copyProperties(openstackRouters, routerDTO);
            }
            return Result.Success(routerDTO);
        } catch (ParseException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<String> addFloatIpToInstance(String serverId, String floatIp, String internalIp, Integer tenantId, Integer detailId, String orderId) {
        try {
            String addStatus = iOpenstackNetworkingService.addFloatIpToInstance(serverId, floatIp, internalIp, tenantId, detailId, orderId);
            return Result.Success(addStatus);
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    /** 三期中改为只创建虚拟交换机和虚拟路由，子网由用户自己单独手动创建 */
    @Override
    public Result initNetworkSubnetRouter(Integer tenantId, Boolean netNeed) {
        try {
            iOpenstackNetworkingService.initNetworkSubnetRouter(tenantId, netNeed);
            return Result.Success();
        } catch (ServiceException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        } catch (ParseException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<String> createFloatIp(Integer tenantId, Integer detailId, String orderId) {
        try {
            String floatIp = iOpenstackNetworkingService.createFloatIp(tenantId, detailId, orderId);
            return Result.Success(floatIp);
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<Integer> countTenantFloatIp(Integer tenantId) {
        int count = iOpenstackNetworkingService.countTenantFloatIp(tenantId);
        if (count >= 0){
            return Result.Success(count);
        }
        return Result.Failure(-1, "CountTenantFloatIp Failed!");
    }

    @Override
    public Result deleteFloatIpByAddr(Integer tenantId, String floatIp) {
        try {
            iOpenstackNetworkingService.deleteFloatIpByAddr(tenantId, floatIp);
            return Result.Success();
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<String> getFloatIdByOrderId(Integer tenantId, String orderId) {
        try {
            String floatIp = iOpenstackNetworkingService.getFloatIdByOrderId(tenantId, orderId);
            return Result.Success(floatIp);
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }

    }

    @Override
    public Result addSecurityRoleGroup(Integer tenantId) {
        try {
            iOpenstackNetworkingService.addSecurityRoleGroup(tenantId);
            return Result.Success();
        } catch (ServiceException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result deleteFloatIp(Integer tenantId, String orderId) {
        try {
            iOpenstackNetworkingService.deleteFloatIp(tenantId, orderId);
            return Result.Success();
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

//    @Override
//    public Result<SecurityGroupRuleDTO> getEgressSecurityGroupRule(Integer tenantId, String securityGroupId) {
//        SecurityGroupRule openstackSecurityGroupRules = iOpenstackNetworkingService.getEgressSecurityGroupRule(tenantId, securityGroupId);
//        SecurityGroupRuleDTO securityGroupDTO = new SecurityGroupRuleDTO();
//        if (openstackSecurityGroupRules != null) {
//            BeanUtils.copyProperties(openstackSecurityGroupRules, securityGroupDTO);
//        }
//        return Result.Success(securityGroupDTO);
//    }
//
//    @Override
//    public Result<SecurityGroupRuleDTO> getIngressSecurityGroupRule(Integer tenantId, String securityGroupId) {
//        SecurityGroupRule openstackSecurityGroupRules = iOpenstackNetworkingService.getIngressSecurityGroupRule(tenantId, securityGroupId);
//        SecurityGroupRuleDTO securityGroupDTO = new SecurityGroupRuleDTO();
//        if (openstackSecurityGroupRules != null) {
//            BeanUtils.copyProperties(openstackSecurityGroupRules, securityGroupDTO);
//        }
//        return Result.Success(securityGroupDTO);
//    }
//
//    @Override
//    public Result<SecurityGroupRuleDTO> getSshSecurityGroupRule(Integer tenantId, String securityGroupId) {
//        SecurityGroupRule openstackSecurityGroupRules = iOpenstackNetworkingService.getSshSecurityGroupRule(tenantId, securityGroupId);
//        SecurityGroupRuleDTO securityGroupDTO = new SecurityGroupRuleDTO();
//        if (openstackSecurityGroupRules != null) {
//            BeanUtils.copyProperties(openstackSecurityGroupRules, securityGroupDTO);
//        }
//        return Result.Success(securityGroupDTO);
//    }
//
//    @Override
//    public Result<SecurityGroupRuleDTO> getRDPSecurityGroupRule(Integer tenantId, String securityGroupId) {
//        SecurityGroupRule openstackSecurityGroupRules = iOpenstackNetworkingService.getRDPSecurityGroupRule(tenantId, securityGroupId);
//        SecurityGroupRuleDTO securityGroupDTO = new SecurityGroupRuleDTO();
//        if (openstackSecurityGroupRules != null) {
//            BeanUtils.copyProperties(openstackSecurityGroupRules, securityGroupDTO);
//        }
//        return Result.Success(securityGroupDTO);
//    }

    @Override
    public Result<List<String>> getFloatIpByTenantId(Integer tenantId) {
        List<String> floatIps = iOpenstackNetworkingService.getFloatIpByTenantId(tenantId);
        return Result.Success(floatIps);
    }

    @Override
    public Result<List<String>> getFloatIpByTenantAndOrderId(Integer tenantId, Integer detailId, String orderId) {
        List<String> floatIps = iOpenstackNetworkingService.getFloatIpByTenantAndOrderId(tenantId, detailId, orderId);
        return Result.Success(floatIps);
    }

    @Override
    public Result<String> releaseTenantNetwork(Integer tenantId) {
        String releaseStatus = iOpenstackNetworkingService.releaseTenantNetwork(tenantId);
        return Result.Success(releaseStatus);
    }

    @Override
    public Result<NetworkDTO> createUserNetwork(NetworkDTO networkDTO, Integer tenantId) {
        try {
            Network network = new Network();
            if (networkDTO != null) {
                BeanUtils.copyProperties(networkDTO, network);
            }
            OpenstackNetworks openstackNetworks = iOpenstackNetworkingService.createUserNetwork(network, tenantId);
            NetworkDTO retNetwork = new NetworkDTO();
            if (openstackNetworks != null) {
                BeanUtils.copyProperties(openstackNetworks, retNetwork);
            }
            return Result.Success(retNetwork);
        } catch (ParseException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<List<SubnetDTO>> getSubnetsByTenantId(Integer tenantId) {
        List<OpenstackSubnets> openstackSubnets = iOpenstackNetworkingService.getSubnetsByTenantId(tenantId);
        List<SubnetDTO> subnetDTOS = new ArrayList<>();
        for (OpenstackSubnets subnet : openstackSubnets) {
            SubnetDTO subnetDTO = new SubnetDTO();
            if (subnet != null) {
                BeanUtils.copyProperties(subnet, subnetDTO);
            }
            subnetDTOS.add(subnetDTO);
        }
        return Result.Success(subnetDTOS);
    }

    @Override
    public Result<SubnetDTO> createUserSubnet(SubnetDTO subnetDTO, Integer tenantId) {
        try {
            Subnet subnet = new Subnet();
            if (subnetDTO != null) {
                BeanUtils.copyProperties(subnetDTO, subnet);
            }
            OpenstackSubnets subnets = iOpenstackNetworkingService.createUserSubnet(subnet,tenantId);
            SubnetDTO retSubnet = new SubnetDTO();
            if (subnets != null) {
                BeanUtils.copyProperties(subnets, retSubnet);
            }
            return Result.Success(retSubnet);
        } catch (ParseException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<List<SubnetDTO>> getAllSubnets() {
        List<OpenstackSubnets> subnetsList = iOpenstackNetworkingService.getAllSubnets();
        List<SubnetDTO> subnetDTOS = new ArrayList<>();
        for (OpenstackSubnets subnet : subnetsList) {
            SubnetDTO subnetDTO = new SubnetDTO();
            if (subnet != null) {
                BeanUtils.copyProperties(subnet, subnetDTO);
            }
            subnetDTOS.add(subnetDTO);
        }
        return Result.Success(subnetDTOS);
    }

    @Override
    public Result<List<RouterDTO>> getRoutersByTenantId(Integer tenantId) {
        List<OpenstackRouters> routersList = iOpenstackNetworkingService.getRoutersByTenantId(tenantId);
        List<RouterDTO> routerDTOS = new ArrayList<>();
        for (OpenstackRouters router : routersList) {
            RouterDTO routerDTO = new RouterDTO();
            if (router != null) {
                BeanUtils.copyProperties(router, routerDTO);
            }
            routerDTOS.add(routerDTO);
        }
        return Result.Success(routerDTOS);
    }

    @Override
    public Result<RouterDTO> createUserRouter(RouterDTO routerDTO, Integer tenantId) {
        try {
            Router router = new Router();
            if (routerDTO != null) {
                BeanUtils.copyProperties(routerDTO, router);
            }
            OpenstackRouters routers = iOpenstackNetworkingService.createUserRouter(router, tenantId);
            RouterDTO retRouter = new RouterDTO();
            if (routers != null) {
                BeanUtils.copyProperties(routers, retRouter);
            }
            return Result.Success(retRouter);
        } catch (ParseException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result insertSecurityGroupRules(List<SecurityGroupRuleDTO> securityGroupRules, Integer tenantId) {
        try {
            List<SecurityGroupRule> securityGroupRuleList = new ArrayList<>();
            for (SecurityGroupRuleDTO rule : securityGroupRules) {
                SecurityGroupRule securityGroupRule = new SecurityGroupRule();
                if (rule != null) {
                    BeanUtils.copyProperties(rule, securityGroupRule);
                }
                securityGroupRuleList.add(securityGroupRule);
            }
            iOpenstackNetworkingService.insertSecurityGroupRules(securityGroupRuleList, tenantId);
            return Result.Success();
        } catch (ServiceException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result removeFloatIps(Integer tenantId, List<String> floatIps) {
        try {
            iOpenstackNetworkingService.removeFloatIps(tenantId, floatIps);
            return Result.Success();
        } catch (ServiceException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<List<SecurityGroupRuleDTO>> listSecurityGroupRules(Integer tenantId, String securityGroupId) {
        List<SecurityGroupRuleVO> securityGroupRules = iOpenstackNetworkingService.listSecurityGroupRules(tenantId, securityGroupId);
        List<SecurityGroupRuleDTO> securityGroupRuleDTOS = new ArrayList<>();
        for (SecurityGroupRuleVO rule : securityGroupRules) {
            SecurityGroupRuleDTO securityGroupDTO = new SecurityGroupRuleDTO();
            if (rule != null) {
                BeanUtils.copyProperties(rule, securityGroupDTO);
            }
            securityGroupRuleDTOS.add(securityGroupDTO);
        }
        return Result.Success(securityGroupRuleDTOS);
    }

//    @Override
//    public Result addSecurityGroupRules(Integer tenantId,  List<SecurityGroupRuleDTO> securityGroupRuleList) {
//        try {
//            List<SecurityGroupRule> securityGroupRules = new ArrayList<>();
//            for (SecurityGroupRuleDTO rule : securityGroupRuleList) {
//                SecurityGroupRule securityGroupRule = new SecurityGroupRule();
//                if (rule != null) {
//                    BeanUtils.copyProperties(rule, securityGroupRule);
//                }
//                securityGroupRules.add(securityGroupRule);
//            }
//            iOpenstackNetworkingService.addSecurityGroupRules(tenantId, securityGroupRules);
//            return Result.Success();
//        } catch (ServiceException e) {
//            e.printStackTrace();
//            return Result.Failure(-1, e.getMessage());
//        } catch (OperationException e) {
//            e.printStackTrace();
//            return Result.Failure(-1, e.getMessage());
//        }
//    }

    @Override
    public Result addSecurityGroup(Integer tenantId, SecurityGroupDTO securityGroupDTO) {
        try {
            SecurityGroupDO securityGroup = new SecurityGroupDO();
            if (securityGroupDTO != null) {
                BeanUtils.copyProperties(securityGroupDTO, securityGroup);
            }
            iOpenstackNetworkingService.addSecurityGroup(tenantId, securityGroup);
            return Result.Success();
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<List<SecurityGroupDTO>> listSecurityGroups(Integer tenantId) {
        List<SecurityGroupVO> openstackSecurityGroups = iOpenstackNetworkingService.listSecurityGroups(tenantId);
        List<SecurityGroupDTO> securityGroupDTOS = new ArrayList<>();
        for (SecurityGroupVO group : openstackSecurityGroups) {
            SecurityGroupDTO securityGroupDTO = new SecurityGroupDTO();
            if (group != null) {
                BeanUtils.copyProperties(group, securityGroupDTO);
            }
            securityGroupDTOS.add(securityGroupDTO);
        }
        return Result.Success(securityGroupDTOS);
    }

    @Override
    public Result<List<NetworkDTO>> listUserNetwork(Integer tenantId) {
        List<OpenstackNetworks> openstackNetworks = iOpenstackNetworkingService.listUserNetwork(tenantId);
        List<NetworkDTO> networkDTOS = new ArrayList<>();
        for (OpenstackNetworks network : openstackNetworks) {
            NetworkDTO networkDTO = new NetworkDTO();
            if (network != null) {
                BeanUtils.copyProperties(network, networkDTO);
            }
            networkDTOS.add(networkDTO);
        }
        return Result.Success(networkDTOS);
    }

    @Override
    public Result createVPC(VpcDTO vpcDTO) {
        iOpenstackNetworkingService.createVPC(vpcDTO);
        return Result.Success();
    }

    @Override
    public Result<List<VpcsVO>> getVpcs(Integer tenantId) {
        try {
            List<VpcsVO> vpcsVOS = iOpenstackNetworkingService.getVpcs(tenantId);
            return Result.Success(vpcsVOS);
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }
}
