package com.ict.cloud.wapper;

import com.ict.cloud.model.BackUpDTO;

import java.util.List;

public interface IOpenstackBackUpService {
    /**
     * function: 数据盘的云备份
     * @param tenantId 租户ID，运营注册时分配
     * @param userId 底层用户ID，一个租户对应一个为一个的userID
     * @param userName
     * @param backUpDTOS
     * */
    void backUpDataVolume(Integer tenantId,String userId, String userName, List<BackUpDTO> backUpDTOS);
}
