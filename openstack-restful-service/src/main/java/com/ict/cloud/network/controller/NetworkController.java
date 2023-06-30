package com.ict.cloud.network.controller;

import com.ict.cloud.common.analzye.ApiResult;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.common.exception.ServiceException;
import com.ict.cloud.model.VpcDTO;
import com.ict.cloud.neutron.model.*;
import com.ict.cloud.resource.domain.*;
import com.ict.cloud.result.Result;
import com.ict.cloud.vo.SecurityGroupRuleTemplateVO;
import com.ict.cloud.vo.SecurityGroupRuleVO;
import com.ict.cloud.vo.SecurityGroupVO;
import com.ict.cloud.vo.VpcsVO;
import com.ict.cloud.wapper.IOpenstackNetworkingService;
import com.ict.cloud.wapper.entity.SecurityGroupDO;
import com.ict.cloud.wapper.entity.SecurityGroupRuleDO;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/openstack-management/network")
public class NetworkController {
    @Resource
    private IOpenstackNetworkingService iOpenstackNetworkingService;

    @PutMapping("/updateOpenstackNetworkToDB")
    public ApiResult<Boolean> updateOpenstackNetworkToDB() {
        try {
            iOpenstackNetworkingService.updateOpenstackNetworkToDB();
            return ApiResult.success(Boolean.TRUE);
        }catch (OperationException | ParseException e) {
            return ApiResult.failed(e.getMessage());
        }
    }

    @PutMapping("/updateOpenstackSecurityGroupToDB")
    public ApiResult<Boolean> updateOpenstackSecurityGroupToDB() {
        try {
            iOpenstackNetworkingService.updateOpenstackSecurityGroupToDB();
            return ApiResult.success(Boolean.TRUE);
        }catch (OperationException | ParseException e) {
            return ApiResult.failed(e.getMessage());
        }
    }

    @PutMapping("/updateFloatIpStatusByIp")
    public ApiResult updateFloatIpStatusByIp(@RequestParam("floatIp") String floatIp,
                                             @RequestParam("status") String status,
                                             @RequestParam("detailId") Integer detailId,
                                             @RequestParam("orderId") String orderId) {
        try {
            iOpenstackNetworkingService.updateFloatIpStatusByIp(floatIp, status, detailId, orderId);
            return ApiResult.success();
        } catch (ServiceException e) {
            return ApiResult.failed(e.getMessage());
        }
    }

    @PostMapping("/createNetwork")
    public ApiResult<OpenstackNetworks> createNetwork(@RequestParam("tenantId") Integer tenantId)  {
        try {
            OpenstackNetworks openstackNetworks = iOpenstackNetworkingService.createNetwork(tenantId);
            return ApiResult.success(openstackNetworks);
        } catch (OperationException | ParseException e) {
            return ApiResult.failed(e.getMessage());
        }
    }

    @PostMapping("/createSubnet")
    public ApiResult<OpenstackSubnets> createSubnet(@RequestParam("tenantId") Integer tenantId) {
        try {
            OpenstackSubnets subnets = iOpenstackNetworkingService.createSubnet(tenantId,null, null);
            return ApiResult.success(subnets);
        } catch (ParseException | OperationException e) {
            return ApiResult.failed(e.getMessage());
        }
    }

    @PostMapping("/createRouter")
    public ApiResult<OpenstackRouters> createRouter(@RequestParam("tenantId") Integer tenantId,
                                                    @RequestParam("subnetId") String subnetId) {
        try {
            OpenstackRouters openstackRouters = iOpenstackNetworkingService.createRouter(tenantId, subnetId);
            return ApiResult.success(openstackRouters);
        } catch (OperationException | ParseException e) {
            return ApiResult.failed(e.getMessage());
        }
    }

    @PostMapping("/addFloatIpToInstance")
    public ApiResult<String> addFloatIpToInstance(@RequestParam("serverId") String serverId,
                                                  @RequestParam("floatIp") String floatIp,
                                                  @RequestParam("internalIp") String internalIp,
                                                  @RequestParam("tenantId") Integer tenantId,
                                                  @RequestParam("detailId") Integer detailId,
                                                  @RequestParam("orderId") String orderId) {
        try {
            String addStatus = iOpenstackNetworkingService.addFloatIpToInstance(serverId, floatIp, internalIp,
                    tenantId, detailId, orderId);
            return ApiResult.success(addStatus);
        } catch (OperationException e) {
            e.printStackTrace();
            return ApiResult.failed(e.getMessage());
        }
    }

    @PostMapping("/initNetworkSubnetRouter")
    public ApiResult initNetworkSubnetRouter(@RequestParam("tenantId") Integer tenantId,
                                             @RequestParam("netNeed") Boolean netNeed) {
        try {
            iOpenstackNetworkingService.initNetworkSubnetRouter(tenantId, netNeed);
            return ApiResult.success();
        } catch (ParseException | OperationException | InterruptedException | ServiceException e) {
            return ApiResult.failed(e.getMessage());
        }

    }

    @PostMapping("/createFloatIp")
    public ApiResult createFloatIp(
                                    @RequestParam("tenantId") Integer tenantId,
                                   @RequestParam("detailId") Integer detailId,
                                   @RequestParam("orderId") String orderId) {
        try {
            iOpenstackNetworkingService.createFloatIp(tenantId, detailId, orderId);
            return ApiResult.success();
        } catch (OperationException e) {
            return ApiResult.failed(e.getMessage());
        }
    }

    @GetMapping("/countTenantFloatIp/{tenantId}")
    public ApiResult<Integer> countTenantFloatIp(@PathVariable("tenantId") Integer tenantId) {
        int count = iOpenstackNetworkingService.countTenantFloatIp(tenantId);
        return ApiResult.success(count);
    }

    @DeleteMapping("/deleteFloatIpByAddr")
    public ApiResult deleteFloatIpByAddr(@RequestParam("tenantId") Integer tenantId,
                                         @RequestParam("floatIp") String floatIp) {
        try {
            iOpenstackNetworkingService.deleteFloatIpByAddr(tenantId, floatIp);
            return ApiResult.success();
        } catch (OperationException e) {
            e.printStackTrace();
            return ApiResult.failed(e.getMessage());
        }
    }

    @GetMapping("/getFloatIdByOrderId")
    public ApiResult<String> getFloatIdByOrderId(@RequestParam("tenantId") Integer tenantId,
                                                 @RequestParam("orderId") String orderId) {
        try {
            String floatIp = iOpenstackNetworkingService.getFloatIdByOrderId(tenantId, orderId);
            return ApiResult.success(floatIp);
        } catch (OperationException e) {
            e.printStackTrace();
            return ApiResult.failed(e.getMessage());
        }
    }

    @PostMapping("/addSecurityRoleGroup")
    public ApiResult addSecurityRoleGroup(@RequestParam("tenantId") Integer tenantId) {
        try{
            iOpenstackNetworkingService.addSecurityRoleGroup(tenantId);
            return ApiResult.success();
        }catch (ServiceException e) {
            return ApiResult.failed(e.getMessage());
        }
    }

    @ApiOperation(value = "释放动态ip")
    @DeleteMapping("/deleteFloatIp")
    public ApiResult deleteFloatIp(Integer tenantId, String orderId) {
        try {
            iOpenstackNetworkingService.deleteFloatIp(tenantId, orderId);
            return ApiResult.success();
        } catch (OperationException e) {
            e.printStackTrace();
            return ApiResult.failed(e.getMessage());
        }
    }

//    @GetMapping("/getEgressSecurityGroupRule")
//    public ApiResult<SecurityGroupRule> getEgressSecurityGroupRule(Integer tenantId, String securityGroupId) {
//        SecurityGroupRule securityGroupRule = iOpenstackNetworkingService.getEgressSecurityGroupRule(tenantId, securityGroupId);
//        return ApiResult.success(securityGroupRule);
//    }
//
//    @GetMapping("/getIngressSecurityGroupRule")
//    public ApiResult<SecurityGroupRule> getIngressSecurityGroupRule(Integer tenantId, String securityGroupId) {
//        SecurityGroupRule securityGroupRule = iOpenstackNetworkingService.getIngressSecurityGroupRule(tenantId, securityGroupId);
//        return ApiResult.success(securityGroupRule);
//    }
//
//    @GetMapping("/getSshSecurityGroupRule")
//    public ApiResult<SecurityGroupRule> getSshSecurityGroupRule(Integer tenantId, String securityGroupId) {
//        SecurityGroupRule securityGroupRule = iOpenstackNetworkingService.getSshSecurityGroupRule(tenantId, securityGroupId);
//        return ApiResult.success(securityGroupRule);
//    }
//
//    @GetMapping("/getRDPSecurityGroupRule")
//    public ApiResult<SecurityGroupRule> getRDPSecurityGroupRule(Integer tenantId, String securityGroupId) {
//        SecurityGroupRule securityGroupRule = iOpenstackNetworkingService.getRDPSecurityGroupRule(tenantId, securityGroupId);
//        return ApiResult.success(securityGroupRule);
//    }

    @GetMapping("/getFloatIpByTenantId/{tenantId}")
    public ApiResult<List<String>> getFloatIpByTenantId(@PathVariable("tenantId") Integer tenantId) {
        List<String> floatIps = iOpenstackNetworkingService.getFloatIpByTenantId(tenantId);
        return ApiResult.success(floatIps);
    }

    @ApiOperation(value = "获取用户动态ip")
    @GetMapping("/getFloatIpByTenantAndOrderId")
    public ApiResult<List<String>> getFloatIpByTenantAndOrderId(Integer tenantId, Integer detailId, String orderId) {
        List<String> floatIps = iOpenstackNetworkingService.getFloatIpByTenantAndOrderId(tenantId, detailId, orderId);
        return ApiResult.success(floatIps);
    }

    @ApiOperation(value = "释放网络")
    @PostMapping("/releaseTenantNetwork")
    public ApiResult<String> releaseTenantNetwork(@RequestParam("tenantId") Integer tenantId) {
        String releaseStatus = iOpenstackNetworkingService.releaseTenantNetwork(tenantId);
        return ApiResult.success(releaseStatus);
    }

    @ApiOperation(value = "创建网络")
    @PostMapping("/createUserNetwork")
    public ApiResult<OpenstackNetworks> createUserNetwork(@RequestParam("network") Network network,
                                                          @RequestParam("tenantId") Integer tenantId) {
        try {
            OpenstackNetworks openstackNetworks = iOpenstackNetworkingService.createUserNetwork(network, tenantId);
            return ApiResult.success(openstackNetworks);
        } catch (ParseException | OperationException e) {
            return ApiResult.failed(e.getMessage());
        }
    }

    @ApiOperation(value = "获取子网")
    @GetMapping("/getSubnetsByTenantId/{tenantId}")
    public ApiResult<List<OpenstackSubnets>> getSubnetsByTenantId(Integer tenantId) {
        List<OpenstackSubnets> openstackSubnets = iOpenstackNetworkingService.getSubnetsByTenantId(tenantId);
        return ApiResult.success(openstackSubnets);
    }

    @ApiOperation(value = "创建子网")
    @PostMapping("/createUserSubnet")
    public ApiResult<OpenstackSubnets> createUserSubnet(Subnet subnet, Integer tenantId) {
        try {
            OpenstackSubnets openstackSubnets = iOpenstackNetworkingService.createUserSubnet(subnet, tenantId);
            return ApiResult.success(openstackSubnets);
        }catch (ParseException | OperationException e) {
            return ApiResult.failed(e.getMessage());
        }
    }

    @GetMapping("/getAllSubnets")
    public ApiResult<List<OpenstackSubnets>> getAllSubnets() {
        List<OpenstackSubnets> openstackSubnets = iOpenstackNetworkingService.getAllSubnets();
        return ApiResult.success(openstackSubnets);
    }

    @ApiOperation(value = "添加路由")
    @GetMapping("/getRoutersByTenantId/{tenantId}")
    public ApiResult<List<OpenstackRouters>> getRoutersByTenantId(@PathVariable("tenantId") Integer tenantId) {
        List<OpenstackRouters> openstackRouters = iOpenstackNetworkingService.getRoutersByTenantId(tenantId);
        return ApiResult.success(openstackRouters);
    }

    @ApiOperation(value = "创建用户路由")
    @PostMapping("/createUserRouter")
    public ApiResult<OpenstackRouters> createUserRouter(@RequestParam("router") Router router,
                                                        @RequestParam("tenantId") Integer tenantId) {
        try {
            OpenstackRouters openstackRouters = iOpenstackNetworkingService.createUserRouter(router, tenantId);
            return ApiResult.success(openstackRouters);
        }catch (ParseException | OperationException e) {
            return ApiResult.failed(e.getMessage());
        }
    }

    @ApiOperation(value = "插入安全组规则")
    @PostMapping("/insertSecurityGroupRules")
    public ApiResult insertSecurityGroupRules(List<SecurityGroupRule> securityGroupRules, Integer tenantId) {
        try {
            iOpenstackNetworkingService.insertSecurityGroupRules(securityGroupRules, tenantId);
            return ApiResult.success();
        } catch (ServiceException e) {
            return ApiResult.failed(e.getMessage());
        }
    }

    @ApiOperation(value = "删除用户外网ip")
    @DeleteMapping("/removeFloatIps")
    public ApiResult removeFloatIps(@RequestParam("tenantId") Integer tenantId,
                                    @RequestParam("floatIps") List<String> floatIps) {
        try {
            iOpenstackNetworkingService.removeFloatIps(tenantId, floatIps);
            return ApiResult.success();
        } catch (ServiceException e) {
            return ApiResult.failed(e.getMessage());
        }
    }

    @ApiOperation(value = "列出安全组规则")
    @GetMapping("/listSecurityGroupRules")
    public ApiResult<List<SecurityGroupRuleVO>> listSecurityGroupRules(@RequestParam("tenantId") Integer tenantId,
                                                                       @RequestParam("securityGroupId") String securityGroupId) {
        List<SecurityGroupRuleVO> rules = iOpenstackNetworkingService.listSecurityGroupRules(tenantId, securityGroupId);
        return ApiResult.success(rules);
    }

    @ApiOperation(value = "添加安全组规则")
    @PostMapping("/addSecurityGroupRules/{tenantId}")
    public ApiResult addSecurityGroupRules(@PathVariable("tenantId") Integer tenantId,
                                           @RequestBody List<SecurityGroupRuleDO> securityGroupRuleList) {
        try {
            iOpenstackNetworkingService.addSecurityGroupRules(tenantId, securityGroupRuleList);
            return ApiResult.success();
        } catch (OperationException | ServiceException e) {
            return ApiResult.failed(e.getMessage());
        }
    }

    @ApiOperation(value = "删除安全组规则")
    @DeleteMapping("/removeSecurityGroupRules/{tenantId}")
    public ApiResult removeSecurityGroupRules(@PathVariable("tenantId") Integer tenantId,
                                              @RequestBody List<String> securityGroupRuleIds) {
        Boolean status = iOpenstackNetworkingService.removeSecurityGroupRules(tenantId, securityGroupRuleIds);
        if (status) {
            return ApiResult.success("删除成功");
        }else {
            return ApiResult.failed("删除失败");
        }
    }

    @ApiOperation(value = "添加安全组")
    @PostMapping("/addSecurityGroup/{tenantId}")
    public ApiResult addSecurityGroup(@PathVariable("tenantId") Integer tenantId,
                                      @RequestBody SecurityGroupDO securityGroupDO) {
        try {
            iOpenstackNetworkingService.addSecurityGroup(tenantId, securityGroupDO);
            return ApiResult.success();
        } catch (OperationException e) {
            e.printStackTrace();
            return ApiResult.failed(e.getMessage());
        }
    }

    @ApiOperation(value = "列出安全组")
    @GetMapping("/listSecurityGroup/{tenantId}")
    public ApiResult<List<SecurityGroup>> listSecurityGroup(@PathVariable("tenantId") Integer tenantId) {
        List<SecurityGroup> securityGroups = iOpenstackNetworkingService.listSecurityGroup(tenantId);
        return ApiResult.success(securityGroups);
    }

    @ApiOperation(value = "一键放通")
    @PutMapping("/addExtraSecurityGroupRule/{tenantId}")
    public ApiResult addExtraSecurityGroupRule(@PathVariable("tenantId") Integer tenantId,
                                               @RequestParam("securityGroupId") String securityGroupId) {
        iOpenstackNetworkingService.addExtraSecurityGroupRule(tenantId, securityGroupId);
        return ApiResult.success();
    }

    @ApiOperation(value = "列出用户拥有的安全组")
    @GetMapping("/listSecurityGroups/{tenantId}")
    public ApiResult<List<SecurityGroupVO>> listSecurityGroups(@PathVariable("tenantId") Integer tenantId) {
        List<SecurityGroupVO> securityGroups = iOpenstackNetworkingService.listSecurityGroups(tenantId);
        return ApiResult.success(securityGroups);
    }

    @ApiOperation(value = "获取私有云")
    @GetMapping("/getVPCs")
    public ApiResult<List<VpcsVO>> getVpcs(@RequestParam("tenantId") Integer tenantId) throws OperationException {
        List<VpcsVO> vpcsVOS = iOpenstackNetworkingService.getVpcs(tenantId);
        return ApiResult.success(vpcsVOS);
    }

    @ApiOperation(value = "创建私有云")
    @PostMapping("/createVPC")
    public ApiResult<String> createVPC(@Validated @RequestBody VpcDTO vpcDO) {
        Boolean createStatus = iOpenstackNetworkingService.createVPC(vpcDO);
        if (createStatus) {
            return ApiResult.success("创建成功");
        }else {
            return ApiResult.success("创建失败");
        }

    }

    @ApiOperation(value = "获取安全组规则模板")
    @GetMapping("/getSecurityGroupRuleTemplate")
    public ApiResult<List<SecurityGroupRuleTemplateVO>> getSecurityGroupRuleTemplate() {
        List<SecurityGroupRuleTemplateVO> securityGroupRuleTemplateVOS = iOpenstackNetworkingService.getSecurityGroupRuleTemplate();
        return ApiResult.success(securityGroupRuleTemplateVOS);
    }


}
