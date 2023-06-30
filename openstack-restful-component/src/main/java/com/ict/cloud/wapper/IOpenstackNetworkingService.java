package com.ict.cloud.wapper;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.common.exception.ServiceException;
import com.ict.cloud.model.NetworkDTO;
import com.ict.cloud.model.VpcDTO;
import com.ict.cloud.neutron.model.*;
import com.ict.cloud.resource.domain.*;
import com.ict.cloud.vo.SecurityGroupRuleTemplateVO;
import com.ict.cloud.vo.SecurityGroupRuleVO;
import com.ict.cloud.vo.SecurityGroupVO;
import com.ict.cloud.vo.VpcsVO;
import com.ict.cloud.wapper.entity.SecurityGroupDO;
import com.ict.cloud.wapper.entity.SecurityGroupRuleDO;
import com.ict.cloud.wapper.entity.SecurityGroupRuleTemplateDO;

import java.text.ParseException;
import java.util.List;

public interface IOpenstackNetworkingService {

    boolean updateOpenstackNetworkToDB() throws OperationException, ParseException;

    boolean updateOpenstackSecurityGroupToDB() throws OperationException, ParseException;

    void updateFloatIpStatusByIp(String floatIp, String status, Integer detailId, String orderId) throws ServiceException;

    OpenstackNetworks createNetwork(Integer tenantId) throws OperationException, ParseException;

    OpenstackSubnets createSubnet(Integer tenantId, String networkId, Subnet subnet) throws ParseException, OperationException;

    OpenstackRouters createRouter(Integer tenantId, String subnetId) throws OperationException, ParseException;

    String addFloatIpToInstance(String serverId, String floatIp, String internalIp, Integer tenantId, Integer detailId, String orderId) throws OperationException;

    void initNetworkSubnetRouter(Integer tenantId, Boolean netNeed) throws ParseException, OperationException, InterruptedException, ServiceException;

    String createFloatIp(Integer tenantId, Integer detailId, String orderId) throws OperationException;

    int countTenantFloatIp(Integer tenantId);

    void deleteFloatIpByAddr(Integer tenantId, String floatIp) throws OperationException;

    String getFloatIdByOrderId(Integer tenantId, String orderId) throws OperationException;

    void addSecurityRoleGroup(Integer tenantId) throws ServiceException;

    void deleteFloatIp(Integer tenantId, String orderId) throws OperationException;

    SecurityGroupRule generateSecurityGroupRule(SecurityGroupRuleDO securityGroupRuleDO);

//    SecurityGroupRule getEgressSecurityGroupRule(Integer tenantId, String securityGroupId);
//
//    SecurityGroupRule getIngressSecurityGroupRule(Integer tenantId, String securityGroupId);
//
//    SecurityGroupRule getSshSecurityGroupRule(Integer tenantId, String securityGroupId);
//
//    SecurityGroupRule getRDPSecurityGroupRule(Integer tenantId, String securityGroupId);

    List<String> getFloatIpByTenantId(Integer tenantId);

    List<String> getFloatIpByTenantAndOrderId(Integer tenantId, Integer detailId, String orderId);

    String releaseTenantNetwork(Integer tenantId);

    OpenstackNetworks createUserNetwork(Network network, Integer tenantId) throws ParseException, OperationException;

    List<OpenstackSubnets> getSubnetsByTenantId(Integer tenantId);

    OpenstackSubnets createUserSubnet(Subnet subnet, Integer tenantId) throws ParseException, OperationException;

    List<OpenstackSubnets> getAllSubnets();

    List<OpenstackRouters> getRoutersByTenantId(Integer tenantId);

    OpenstackRouters createUserRouter(Router router, Integer tenantId) throws ParseException, OperationException;

    void insertSecurityGroupRules(List<SecurityGroupRule> securityGroupRules, Integer tenantId) throws ServiceException;

    void removeFloatIps(Integer tenantId, List<String> floatIps) throws ServiceException;

    List<SecurityGroupRuleVO> listSecurityGroupRules(Integer tenantId, String securityGroupId);

    void addSecurityGroupRules(Integer tenantId, List<SecurityGroupRuleDO> securityGroupRuleDOS) throws OperationException, ServiceException;

    void addSecurityGroup(Integer tenantId, SecurityGroupDO securityGroupDO) throws OperationException;

    List<SecurityGroupVO> listSecurityGroups(Integer tenantId);

    List<OpenstackNetworks> listUserNetwork(Integer tenantId);

    Boolean createVPC(VpcDTO vpcDTO);

    OpenstackRouters getRouterByName(String name);

    Router addRouterInterface(String userName, String routerId, String subnetId);

    List<VpcsVO> getVpcs(Integer tenantId) throws OperationException;

    List<SecurityGroupRuleTemplateVO> getSecurityGroupRuleTemplate();

    Boolean removeSecurityGroupRules(Integer tenantId, List<String> securityGroupRuleIds);

    void addExtraSecurityGroupRule(Integer tenantId, String securityGroupId);

    List<SecurityGroup> listSecurityGroup(Integer tenantId);
}
