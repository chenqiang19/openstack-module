package com.ict.cloud.rpc;

import com.ict.cloud.model.NodesDTO;
import com.ict.cloud.result.Result;

import java.util.List;

/**
 * @Author CQ
 * @Date 2022/06/08
 * @Description Openstack裸金属组件对外RPC接口定义
 * */
public interface BareMetalApiService {
    /**
     * 获取底层的裸金属结点
     * @return
     * */
    Result<List<NodesDTO>> getOpenstackNodes();

    /**
     * 同步底层的裸金属结点到数据库
     * @return
     * */
    Result<Boolean> updateOpenstackNodeToDB();

    /**
     * 通过架构信息获取裸金属结点
     * @return
     * */
    Result<List<NodesDTO>> getOpenstackNodesByArch(String arch, String gpuFlag);
}
