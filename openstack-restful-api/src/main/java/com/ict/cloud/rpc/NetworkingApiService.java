package com.ict.cloud.rpc;

import com.ict.cloud.model.*;
import com.ict.cloud.result.Result;
import com.ict.cloud.vo.VpcsVO;

import java.util.List;

/**
 * @Author CQ
 * @Date 2022/06/08
 * @Description Openstack网络组件对外RPC接口定义
 * */
public interface NetworkingApiService {
    Result<Boolean> updateOpenstackNetworkToDB();

    Result<Boolean> updateOpenstackSecurityGroupToDB();

    Result<Result> updateFloatIpStatusByIp(String floatIp, String status, Integer detailId, String orderId);

    Result<NetworkDTO> createNetwork(Integer tenantId);

    Result<SubnetDTO> createSubnet(Integer tenantId, String networkId);

    Result<RouterDTO> createRouter(Integer tenantId, String subnetId);

    Result<String> addFloatIpToInstance(String serverId, String floatIp, String internalIp, Integer tenantId, Integer detailId, String orderId);

    Result initNetworkSubnetRouter(Integer tenantId, Boolean netNeed);

    Result<String> createFloatIp(Integer tenantId, Integer detailId, String orderId);

    Result<Integer> countTenantFloatIp(Integer tenantId);

    Result deleteFloatIpByAddr(Integer tenantId, String floatIp);

    Result<String> getFloatIdByOrderId(Integer tenantId, String orderId);

    Result addSecurityRoleGroup(Integer tenantId);

    Result deleteFloatIp(Integer tenantId, String orderId);

//    Result<SecurityGroupRuleDTO> getEgressSecurityGroupRule(Integer tenantId, String securityGroupId);
//
//    Result<SecurityGroupRuleDTO> getIngressSecurityGroupRule(Integer tenantId, String securityGroupId);
//
//    Result<SecurityGroupRuleDTO> getSshSecurityGroupRule(Integer tenantId, String securityGroupId);
//
//    Result<SecurityGroupRuleDTO> getRDPSecurityGroupRule(Integer tenantId, String securityGroupId);

    Result<List<String>> getFloatIpByTenantId(Integer tenantId);

    Result<List<String>> getFloatIpByTenantAndOrderId(Integer tenantId, Integer detailId, String orderId);

    Result<String> releaseTenantNetwork(Integer tenantId);

    Result<NetworkDTO> createUserNetwork(NetworkDTO network, Integer tenantId);

    Result<List<SubnetDTO>> getSubnetsByTenantId(Integer tenantId);

    Result<SubnetDTO> createUserSubnet(SubnetDTO subnet, Integer tenantId);

    Result<List<SubnetDTO>> getAllSubnets();

    Result<List<RouterDTO>> getRoutersByTenantId(Integer tenantId);

    Result<RouterDTO> createUserRouter(RouterDTO router, Integer tenantId);

    Result insertSecurityGroupRules(List<SecurityGroupRuleDTO> securityGroupRules, Integer tenantId);

    Result removeFloatIps(Integer tenantId, List<String> floatIps);

    Result<List<SecurityGroupRuleDTO>> listSecurityGroupRules(Integer tenantId, String securityGroupId);

//    Result addSecurityGroupRules(Integer tenantId, List<SecurityGroupRuleDTO> securityGroupRuleList);

    Result addSecurityGroup(Integer tenantId, SecurityGroupDTO securityGroup);

    Result<List<SecurityGroupDTO>> listSecurityGroups(Integer tenantId);

    Result<List<NetworkDTO>> listUserNetwork(Integer tenantId);

    Result createVPC(VpcDTO vpcDTO);

    Result<List<VpcsVO>> getVpcs(Integer tenantId);
}
