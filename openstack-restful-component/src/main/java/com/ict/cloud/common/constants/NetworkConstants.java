package com.ict.cloud.common.constants;

public class NetworkConstants {
    //弹性公网IP，三种模式
    public static final String BUY_IT_NOW = "1";

    public static final String USE_EXISTING = "2";

    public static final String DO_NOT_BUY = "3";


    //带块计费模式
    public static final String NETWORK_MATERIAL_MODEL = "1";
    public static final String NETWORK_MATERIAL_TRAFFIC = "2";

    //网络带宽单位
    public static final String NETWORK_BAND_WIDTH_UNIT = "Mbps";

    //网络状态
    public static final String NETWORK_DOWN = "0";  //未使用
    public static final String NETWORK_DOWN_NAME = "DOWN";

    public static final String NETWORK_ACTIVE = "1";  //运行中
    public static final String NETWORK_ACTIVE_NAME = "ACTIVE";  //运行中

    public static final String NETWORK_GENERIC_SUCCESS = "1";

    public static final String NETWORK_GENERIC_FAILED = "100";

    public static final String NETWORK_CREATE_SUCCESS = "1";
    public static final String NETWORK_CREATE_FAILED = "101";
    public static final String NETWORK_RELEASE_FAILED = "102";

    public static final String SUBNET_CREATE_SUCCESS = "1";
    public static final String SUBNET_CREATE_FAILED = "103";
    public static final String SUBNET_RELEASE_FAILED = "104";

    public static final String ROUTER_CREATE_SUCCESS = "1";
    public static final String ROUTER_CREATE_FAILED = "105";
    public static final String ROUTER_RELEASE_FAILED = "106";

    public static final String FLOAT_IP_CREATE_SUCCESS = "1";
    public static final String FLOAT_IP_CREATE_FAILED = "107";
    public static final String FLOAT_IP_RELEASE_FAILED = "108";
}
