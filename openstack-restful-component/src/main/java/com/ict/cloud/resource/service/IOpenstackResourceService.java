package com.ict.cloud.resource.service;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.resource.domain.OpenstackResource;

import java.util.List;

/**
* @Description:    java类作用描述
* @Author:         cq
* @CreateDate:     2021/5/24 18:50
* @UpdateUser:     cq
* @UpdateDate:     2021/5/24 18:50
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public interface IOpenstackResourceService {

    /**
    * 方法实现说明
    * @author      cq
    * @param id
    * @return
    * @exception
    * @date        2021/5/24 19:23
    */
    OpenstackResource getOpenstackResourceById(Integer id);

    /**
    * 方法实现说明
    * @author      cq
    * @param resource
    * @return
    * @exception
    * @date        2021/5/25 11:38
    */
    void insertOpenstackResource(OpenstackResource resource) throws OperationException;

    /**
    * 方法实现说明
    * @author      cq
    No such property: code for class: Script1
    * @return
    * @exception
    * @date        2021/5/26 17:13
    */
    List<OpenstackResource> getOpenstackResource();
}
