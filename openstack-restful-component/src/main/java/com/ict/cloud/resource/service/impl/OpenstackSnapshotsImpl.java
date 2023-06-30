package com.ict.cloud.resource.service.impl;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.resource.domain.OpenstackSnapshots;
import com.ict.cloud.resource.mapper.OpenstackSnapshotsMapper;
import com.ict.cloud.resource.service.IOpenstackSnapshotsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OpenstackSnapshotsImpl implements IOpenstackSnapshotsService {
    @Resource
    private OpenstackSnapshotsMapper openstackSnapshotsMapper;
    public OpenstackSnapshots getOpenstackSnapshotById(Integer id) {
        return openstackSnapshotsMapper.selectByPrimaryKey(id);
    }

    public void insertOpenstackSnapshot(OpenstackSnapshots resource) throws OperationException {
        int answer = openstackSnapshotsMapper.insert(resource);
        if(answer < 0) {
            throw new OperationException("insertOpenstackImage failed！");
        }
    }

    public List<OpenstackSnapshots> getAllOpenstackSnapshots() {
        return openstackSnapshotsMapper.selectAllSnapshots();
    }
}
