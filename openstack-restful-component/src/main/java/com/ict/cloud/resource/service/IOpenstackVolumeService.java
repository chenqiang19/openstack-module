package com.ict.cloud.resource.service;

import com.ict.cloud.resource.domain.OpenstackVolumes;

import java.util.List;

public interface IOpenstackVolumeService {
    void batchInsertVolumes(List<OpenstackVolumes> openstackVolumes);
}
