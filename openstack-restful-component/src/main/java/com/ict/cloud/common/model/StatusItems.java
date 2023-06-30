package com.ict.cloud.common.model;

public enum StatusItems {
    //NOSTATE,ACTIVE,PAUSED,SHUTOFF,CRASHED,SUSPENDED;
    NOSTATE,RUNNING,PAUSED,SHUTDOWN,CRASHED,SUSPENDED;

    public static StatusItems of(String type) {
        return StatusItems.valueOf(type);
    }

}
