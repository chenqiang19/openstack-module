package com.ict.cloud.resource.service.impl;

import com.ict.cloud.common.constants.NetworkConstants;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.common.exception.ServiceException;
import com.ict.cloud.resource.domain.OpenstackFloatips;
import com.ict.cloud.resource.domain.OpenstackFloatipsCriteria;
import com.ict.cloud.resource.mapper.OpenstackFloatIpsMapper;
import com.ict.cloud.resource.service.IOpenstackFloatIpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OpenstackFloatIpImpl implements IOpenstackFloatIpService {

    @Resource
    private OpenstackFloatIpsMapper openstackFloatIpsMapper;

    @Override
    public void insertOpenstackFloatIp(OpenstackFloatips openstackFloatips) throws OperationException {
        int answer = openstackFloatIpsMapper.insert(openstackFloatips);
        if(answer < 0) {
            throw new OperationException("insertOpenstackFloatIp failed！");
        }
    }

    @Override
    public List<OpenstackFloatips> getFloatIpsByTenantId(Integer tenantId) {
        OpenstackFloatipsCriteria example = new OpenstackFloatipsCriteria();
        OpenstackFloatipsCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(tenantId);
        criteria.andStatusEqualTo(NetworkConstants.NETWORK_DOWN_NAME);
        return openstackFloatIpsMapper.selectByExample(example);
    }


    @Override
    public List<String> getFloatIpByTenantId(Integer tenantId) {
        return this.getFloatIpsByTenantId(tenantId).stream().map(OpenstackFloatips::getFixedIpAddress).
                distinct().collect(Collectors.toList());
    }

    @Override
    public List<OpenstackFloatips> getFloatIpByTenantAndOrderId(Integer tenantId, Integer detailId, String orderId) {
        OpenstackFloatipsCriteria example = new OpenstackFloatipsCriteria();
        OpenstackFloatipsCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(tenantId);
        if(detailId!=null){
            criteria.andDetailIdEqualTo(detailId);
        }
        if(orderId!=null){
            criteria.andOrderIdEqualTo(orderId);
        }
        return openstackFloatIpsMapper.selectByExample(example);
    }

    @Override
    public void deleteFloatIp(Integer tenantId, Integer detailId, String orderId) {
        OpenstackFloatipsCriteria example = new OpenstackFloatipsCriteria();
        OpenstackFloatipsCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(tenantId);
        if(detailId!=null){
            criteria.andDetailIdEqualTo(detailId);
        }
        if(orderId!=null){
            criteria.andOrderIdEqualTo(orderId);
        }
        openstackFloatIpsMapper.deleteByExample(example);
    }

    @Override
    public void updateFloatIpStatusByIp(String floatIp, String status, Integer detailId, String orderId) throws ServiceException {
        OpenstackFloatipsCriteria example = new OpenstackFloatipsCriteria();
        OpenstackFloatipsCriteria.Criteria criteria = example.createCriteria();
        criteria.andFixedIpAddressEqualTo(floatIp);
        List<OpenstackFloatips> floatips = openstackFloatIpsMapper.selectByExample(example);
        if(floatips.size()!=1){
            throw new ServiceException("IP数量不正确, " + floatips);
        }
        OpenstackFloatips resource = floatips.get(0);
        if (detailId != null &&
            floatips.get(0).getDetailId() != null &&
            !floatips.get(0).getDetailId().equals(detailId)) {
            resource.setDetailId(detailId);
        }
        if(orderId!=null) {
            resource.setOrderId(orderId);
        }
        resource.setStatus(status);
        openstackFloatIpsMapper.updateFloatIpInfo(floatIp, status,detailId,orderId);
    }

    public int countFloatIpByTenantId(Integer tenantId) {
        return openstackFloatIpsMapper.countFloatIpByTenantId(tenantId);
    }

    public List<OpenstackFloatips> getFloatIpByTenantIdAndIP(Integer tenantId, String ip){
        OpenstackFloatipsCriteria example = new OpenstackFloatipsCriteria();
        OpenstackFloatipsCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(tenantId);
        criteria.andFixedIpAddressEqualTo(ip);
        return openstackFloatIpsMapper.selectByExample(example);
    }
}
