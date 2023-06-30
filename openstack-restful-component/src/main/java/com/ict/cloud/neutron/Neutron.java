package com.ict.cloud.neutron;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.common.Client;
import com.ict.cloud.neutron.api.*;
import com.ict.cloud.neutron.api.v2.*;


public class Neutron extends Client {

    public final NetworkManager networks;
    public final SubnetPoolsManager subnets;
    public final FloatingIPsManager floatIps;
    public final RoutersManager routers;
    public final SecurityGroupRuleManager securityGroupRules;
    public final SecurityGroupManager securityGroups;
    public final PortsManager ports;
    public Neutron(Authenticated credentical) {
        super(credentical);
        networks = new Networks(credentical);
        subnets = new Subnets(credentical);
        floatIps = new FloatIps(credentical);
        routers = new Routers(credentical);
        securityGroupRules = new SecurityGroupRules(credentical);
        securityGroups = new SecurityGroups(credentical);
        ports = new Ports(credentical);
    }
}
