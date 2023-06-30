package com.ict.cloud.common.constants;

public class OpenstackConstants {
    public static final String IMAGE_ARCH_X86 = "X86";
    public static final String IMAGE_ARCH_X86_64 = "X86_64";
    public static final String IMAGE_ARCH_ARM = "ARM";

    public static final String IMAGE_NAME_CENTOS = "Centos";
    public static final String IMAGE_NAME_UBUNTU = "Ubuntu";
    public static final String IMAGE_NAME_WINDOWS = "Windows";
    public static final String IMAGE_NAME_FEDORA = "Fedora";
    public static final String IMAGE_NAME_OTHERS = "Other";
    public static final String IMAGE_WINDOWS_PREFIX = "WIN";

    public static final String IMAGE_STATUS_ACTIVE = "ACTIVE";

    //虚拟机常量定义
    public static final String VCPU_NAME = "vCPUs";
    public static final String RAM_NAME = "内存";

    public static final String SUBNET_CIDR = "192.168.0.0/16";
    public static final String NETWORK_TYPE = "vlan";
    public static final String NETWORK_PHYSICAL = "physnet1";
    public static final String SUBNET_NAME = "subnet-default";
    public static final String NETWORK_GATEWAY = "192.168.0.1";
    public static final String NETWORK_DNS = "114.114.114.114";
    public static final String NETWORK_NAME = "vpc-default";
    public static final Boolean NETWORK_DHCP = true;
    public static final String NETWORK_ZONE_HINT = "nova";
    public static final Integer NETWORK_MTU = 1500;
    public static final Integer SEGMENT_ID_MIN = 3;
    public static final Integer SEGMENT_ID_MAX = 98;
    public static final String ROUTER_NAME = "rtb-vpc-default";
    public static final Integer SUBNET_IP_VERSION = 4;
    public static final String NETWORK_OUTSIDE = "0184c0ca-fa00-41b9-ad0e-c3ec32cb4edd"; //"37840a58-8cd7-417d-b0a7-ac87307b5402";
    public static final String DEFAULT_ROLE_ID = "c6500088baa84eaf81268fb5af04e5a2";
    public static final String ADMIN_PROJECT_ID = "0b6af1650944499ca197a5b39fae2da8";//"0461b22389454472923e70cd9d1f2e43";

    public static final String BARE_METAL_FLAVOR_TYPE = "physical";
    public static final String BARE_METAL_HUAWEI = "c1";
    public static final String BARE_METAL_H3H = "b1";
    public static final String VMWARE_FLAVOR_TYPE = "vm";

    public static final String CATEGORYCODE_PHYSICALSERVER = "physical_server";
    public static final String CATEGORYCODE_VMWARESERVER = "vmware_server";

    public static final String PRODUCT_IMAGE_PUBLISH = "PUBLISH";
    public static final String PRODUCT_IMAGE_DOWNLOAD = "DOWNLOAD";
}
