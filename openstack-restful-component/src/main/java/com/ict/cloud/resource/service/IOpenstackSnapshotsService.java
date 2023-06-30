package com.ict.cloud.resource.service;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.resource.domain.OpenstackSnapshots;

import java.util.List;

public interface IOpenstackSnapshotsService {
    /**
    * 方法实现说明
    * @author      cq
    No such property: code for class: Script1
    * @return
    * @exception
    * @date        2021/6/15 11:55
    */
    OpenstackSnapshots getOpenstackSnapshotById(Integer id);

    /**
    * 方法实现说明
    * @author      cq
    No such property: code for class: Script1
    * @return
    * @exception
    * @date        2021/6/15 11:55
    */
    void insertOpenstackSnapshot(OpenstackSnapshots resource) throws OperationException;

    /**
    * 方法实现说明
    * @author      cq
    No such property: code for class: Script1
    * @return
    * @exception
    * @date        2021/6/15 11:56
    */
    List<OpenstackSnapshots> getAllOpenstackSnapshots();
}
