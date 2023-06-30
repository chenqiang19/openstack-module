package com.ict.cloud.resource.service;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.resource.domain.OpenstackFlavors;

import java.util.List;

public interface IOpenstackFlavorsService {
    /**
     * 方法实现说明
     * @author      cq
     * @param id
     * @return
     * @exception
     * @date        2021/5/25 17:52
     */
    OpenstackFlavors getOpenstackFlavorByPrimaryKey(Integer id);

    /**
     * 方法实现说明
     * @author      cq
     * @return
     * @exception
     * @date        2021/5/25 17:52
     */
    void insertOpenstackFlavor(OpenstackFlavors resource) throws OperationException;

    List<OpenstackFlavors> getFlavorsBySpecInfo(Integer cpuNum, Integer memory, Integer dataDisk);

    List<OpenstackFlavors> getFlavorsFromDB();

    List<OpenstackFlavors> getFlavorsByDeviceType(String deviceType);

    OpenstackFlavors getFlavorByFlavorId(String flavorId);

    void updateOpenstackFlavor(OpenstackFlavors flavor);

    void deleteFlavorById(String flavorId);

    List<OpenstackFlavors> getFlavorByFlavorIds(List<String> flavorId);
}
