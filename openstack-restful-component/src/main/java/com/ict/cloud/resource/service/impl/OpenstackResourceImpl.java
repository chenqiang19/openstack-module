package com.ict.cloud.resource.service.impl;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.resource.domain.OpenstackResource;
import com.ict.cloud.resource.mapper.OpenstackResourceMapper;
import com.ict.cloud.resource.service.IOpenstackResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service("openstack_resource")
public class OpenstackResourceImpl implements IOpenstackResourceService {

    @Autowired
    private OpenstackResourceMapper openstackResourcemapper;

    public OpenstackResource getOpenstackResourceById(Integer id) {
        return openstackResourcemapper.selectByPrimaryKey(id);
    }

    public void insertOpenstackResource(OpenstackResource resource) throws OperationException {
        int answer = openstackResourcemapper.insert(resource);
        if(answer < 0) {
            throw new OperationException("insertOpenstackResource failed！");
        }
    }

    public List<OpenstackResource> getOpenstackResource() {
        return openstackResourcemapper.selectAllExample();
    }
}
