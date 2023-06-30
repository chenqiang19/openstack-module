package com.ict.cloud.resource.service;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.resource.domain.OpenstackImages;

import java.util.List;

public interface IOpenstackImagesService {
    /**
    * 方法实现说明
    * @author      cq
    * @param id
    * @return
    * @exception
    * @date        2021/5/25 17:52
    */
    OpenstackImages getOpenstackImageByPrimaryKey(Integer id);

    /**
    * 方法实现说明
    * @author      cq
    * @return
    * @exception
    * @date        2021/5/25 17:52
    */
    void insertOpenstackImage(OpenstackImages resource) throws OperationException;

    List<OpenstackImages> getAllImages(String arch, String imageType);

    List<OpenstackImages> getImageByDeviceType(String imageName, String imageVersion, String imageType, String arch);

    void updateOpenstackImage(OpenstackImages updateImage);

    OpenstackImages getImageById(Integer id);

    OpenstackImages getImageByImageId(String id);
}
