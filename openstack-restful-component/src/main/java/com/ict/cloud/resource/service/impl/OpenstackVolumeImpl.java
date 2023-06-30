package com.ict.cloud.resource.service.impl;

import com.ict.cloud.resource.domain.OpenstackVolumes;
import com.ict.cloud.resource.mapper.OpenstackVolumesMapper;
import com.ict.cloud.resource.service.IOpenstackVolumeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OpenstackVolumeImpl implements IOpenstackVolumeService {

    @Resource
    private OpenstackVolumesMapper openstackVolumesMapper;

    @Override
    public void batchInsertVolumes(List<OpenstackVolumes> openstackVolumes) {
        openstackVolumesMapper.batchInsertVolumes(openstackVolumes);
    }
}
