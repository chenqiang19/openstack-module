package com.ict.cloud.wapper;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.resource.domain.OpenstackNodes;

import java.text.ParseException;
import java.util.List;

public interface IOpenstackBareMetalService {
    List<OpenstackNodes> getOpenstackNodes();

    boolean updateOpenstackNodeToDB() throws OperationException, ParseException;

    List<OpenstackNodes> getOpenstackNodesByArch(String arch, String gpuFlag);
}
