package com.ict.cloud.common.constants;

public enum ServerGroupAffinity {
//    ANTI_AFFINITY("反亲和性"),
//    AFFINITY("亲和性"),
    SOFT_ANTI_AFFINITY("软-反亲和性"),
    SOFT_AFFINITY("软-亲和性");

    private String name;

    ServerGroupAffinity(String name) {
        this.name = name;
    }

    public String getName() { return this.name; }

    @Override
    public String toString() {
        return name;
    }
}
