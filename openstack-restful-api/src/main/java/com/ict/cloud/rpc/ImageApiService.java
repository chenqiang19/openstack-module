package com.ict.cloud.rpc;

import com.ict.cloud.model.ImageDTO;
import com.ict.cloud.result.Result;
import com.ict.cloud.vo.ImageConfigVO;
import com.ict.cloud.vo.ImageVO;

import java.util.List;

/**
 * @Author CQ
 * @Date 2022/06/08
 * @Description Openstack镜像组件对外RPC接口定义
 * */
public interface ImageApiService {
    /**
     * function: 同步底层镜像到数据库
     * */
    Result<List<ImageConfigVO>> updateOpenstackImageToDB();

    /**
     * function: 获取镜像
     * @param arch 镜像架构
     * @param imageType 镜像类型
     * */
    Result<List<ImageDTO>> getImages(String arch, String imageType);

    /**
     * function: 获取镜像
     * @param imageId 镜像id
     * */
    Result<ImageDTO> getImageById(Integer id);

    Result<ImageDTO> getImageByImageId(String imageId);
}
