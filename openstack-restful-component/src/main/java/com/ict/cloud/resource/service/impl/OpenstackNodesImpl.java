package com.ict.cloud.resource.service.impl;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.resource.domain.OpenstackNodes;
import com.ict.cloud.resource.domain.OpenstackNodesCriteria;
import com.ict.cloud.resource.mapper.OpenstackNodesMapper;
import com.ict.cloud.resource.service.IOpenstackNodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("openstack_nodes")
public class OpenstackNodesImpl implements IOpenstackNodesService {
    @Autowired
    private OpenstackNodesMapper openstackNodesMapper;
    public List<OpenstackNodes> getOpenstackNodes() {
        return openstackNodesMapper.selectAllExample();
    }

    public void insertOpenstackNodes(OpenstackNodes resource) throws OperationException {
        int answer = openstackNodesMapper.insert(resource);
        if(answer < 0) {
            throw new OperationException("insertOpenstackNodes failed！");
        }
    }

    public void removeNodeByUuid(Integer id) {
        openstackNodesMapper.deleteByPrimaryKey(id);
    }

    public List<OpenstackNodes> getOpenstackNodesByArch(String arch, String gpuFlag) {
        OpenstackNodesCriteria example = new OpenstackNodesCriteria();
        OpenstackNodesCriteria.Criteria criteria = example.createCriteria();
        criteria.andCpuArchEqualTo(arch);
        if(gpuFlag.equals("GPU")) {
            criteria.andGpuFlagEqualTo(1);
        }else if(gpuFlag.equals("CPU")) {
            criteria.andGpuFlagEqualTo(0);
        }
        return openstackNodesMapper.selectByExample(example);
    }
}
