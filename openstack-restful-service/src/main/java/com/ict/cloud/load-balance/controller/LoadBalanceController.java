package com.ict.cloud.loadBalance.controller;

import com.ict.cloud.wapper.IOpenstackLoadBalancerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/v1/openstack-management/load_balance")
public class LoadBalanceController {

    @Resource
    private IOpenstackLoadBalancerService iOpenstackLoadBalancerService;
}
