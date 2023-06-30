package com.ict.cloud.resource.service.impl;

import com.ict.cloud.common.exception.ServiceException;
import com.ict.cloud.resource.domain.OpenstackKeyPairs;
import com.ict.cloud.resource.mapper.OpenstackKeyPairsMapper;
import com.ict.cloud.resource.service.IOpenstackKeyPairService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("openstack_keypair")
public class OpenstackKeyPairImpl implements IOpenstackKeyPairService {
    @Resource
    private OpenstackKeyPairsMapper openstackKeyPairsMapper;

    @Override
    public int insert(OpenstackKeyPairs openstackKeyPairs) throws ServiceException {
        int count = openstackKeyPairsMapper.insert(openstackKeyPairs);
        if(count > 0) {
            return count;
        }
        throw new ServiceException("KeyPair数据库插入失败");
    }

    @Override
    public List<OpenstackKeyPairs> getKeyPairsByTenantId(Integer tenantId, String keyPairName) {
        return openstackKeyPairsMapper.getKeyPairsByTenantId(tenantId, keyPairName);
    }
}
