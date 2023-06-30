package com.ict.cloud.resource.service.impl;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.resource.domain.OpenstackFlavors;
import com.ict.cloud.resource.domain.OpenstackFlavorsCriteria;
import com.ict.cloud.resource.mapper.OpenstackFlavorsMapper;
import com.ict.cloud.resource.service.IOpenstackFlavorsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OpenstackFlavorsImpl implements IOpenstackFlavorsService {
    @Resource
    private OpenstackFlavorsMapper openstackFlavorsMapper;

    public OpenstackFlavors getOpenstackFlavorByPrimaryKey(Integer id) {
        return openstackFlavorsMapper.selectByPrimaryKey(id);
    }

    public void insertOpenstackFlavor(OpenstackFlavors resource) throws OperationException {
        int answer = openstackFlavorsMapper.insert(resource);
        if(answer < 0) {
            throw new OperationException("insertOpenstackFlavor failed！");
        }
    }

    public List<OpenstackFlavors> getFlavorsBySpecInfo(Integer cpuNum, Integer memory, Integer dataDisk) {
        OpenstackFlavorsCriteria example = new OpenstackFlavorsCriteria();
        OpenstackFlavorsCriteria.Criteria criteria = example.createCriteria();
        criteria.andFlavorVcpuEqualTo(cpuNum);
        criteria.andFlavorRamEqualTo(memory);
        criteria.andFlavorDiskEqualTo(dataDisk);
        return openstackFlavorsMapper.selectByExample(example);
    }

    public List<OpenstackFlavors> getFlavorsByDeviceType(String deviceType) {
        OpenstackFlavorsCriteria example = new OpenstackFlavorsCriteria();
        OpenstackFlavorsCriteria.Criteria criteria = example.createCriteria();
        criteria.andFlavorNameEqualTo(deviceType);
        return openstackFlavorsMapper.selectByExample(example);
    }

    public List<OpenstackFlavors> getFlavorsFromDB() {
        return openstackFlavorsMapper.selectAllFlavors();
    }

    public OpenstackFlavors getFlavorByFlavorId(String flavorId) {
        OpenstackFlavorsCriteria example = new OpenstackFlavorsCriteria();
        OpenstackFlavorsCriteria.Criteria criteria = example.createCriteria();
        criteria.andFlavorIdEqualTo(flavorId);
        return openstackFlavorsMapper.selectOneByExample(example);
    }

    public void updateOpenstackFlavor(OpenstackFlavors flavor) {
        OpenstackFlavorsCriteria example = new OpenstackFlavorsCriteria();
        OpenstackFlavorsCriteria.Criteria criteria = example.createCriteria();
        criteria.andFlavorIdEqualTo(flavor.getFlavorId());
        openstackFlavorsMapper.updateByExample(flavor, example);
    }

    public void deleteFlavorById(String flavorId) {
        OpenstackFlavorsCriteria example = new OpenstackFlavorsCriteria();
        OpenstackFlavorsCriteria.Criteria criteria = example.createCriteria();
        criteria.andFlavorIdEqualTo(flavorId);
        openstackFlavorsMapper.deleteByExample(example);
    }

    @Override
    public List<OpenstackFlavors> getFlavorByFlavorIds(List<String> flavorId) {
        OpenstackFlavorsCriteria example = new OpenstackFlavorsCriteria();
        OpenstackFlavorsCriteria.Criteria criteria = example.createCriteria();
        criteria.andFlavorIdIn(flavorId);
        return openstackFlavorsMapper.selectByExample(example);
    }
}
