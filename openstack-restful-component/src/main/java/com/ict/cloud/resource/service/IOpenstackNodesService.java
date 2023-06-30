package com.ict.cloud.resource.service;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.resource.domain.OpenstackNodes;

import java.util.List;

public interface IOpenstackNodesService {

    List<OpenstackNodes> getOpenstackNodes();

    void insertOpenstackNodes(OpenstackNodes resource) throws OperationException;

    void removeNodeByUuid(Integer uuid);

    List<OpenstackNodes> getOpenstackNodesByArch(String arch, String gpuFlag);
}
