package com.ict.cloud.wapper.rpcImpl;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.model.NodesDTO;
import com.ict.cloud.resource.domain.OpenstackNodes;
import com.ict.cloud.result.Result;
import com.ict.cloud.rpc.BareMetalApiService;
import com.ict.cloud.wapper.IOpenstackBareMetalService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author CQ
 * @Date 2022/06/08
 * @Description openstack服务提供的裸金属RPC接口实现类
 * */
@Service
public class BareMetalApiServiceImpl implements BareMetalApiService {
    @Resource
    private IOpenstackBareMetalService iOpenstackBareMetalService;
    @Override
    public Result<List<NodesDTO>> getOpenstackNodes() {
        List<OpenstackNodes> openstackNodes = iOpenstackBareMetalService.getOpenstackNodes();
        List<NodesDTO> nodesDTOS = new ArrayList<>();
        for (OpenstackNodes node : openstackNodes) {
            NodesDTO nodesDTO = new NodesDTO();
            if (node != null) {
                BeanUtils.copyProperties(node, nodesDTO);
            }
        }
        return Result.Success(nodesDTOS);
    }

    @Override
    public Result<Boolean> updateOpenstackNodeToDB() {
        try {
            iOpenstackBareMetalService.updateOpenstackNodeToDB();
            return Result.Success(Boolean.TRUE);
        } catch (ParseException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<List<NodesDTO>> getOpenstackNodesByArch(String arch, String gpuFlag) {
        List<OpenstackNodes> openstackNodes = iOpenstackBareMetalService.getOpenstackNodesByArch(arch, gpuFlag);
        List<NodesDTO> nodesDTOS = new ArrayList<>();
        for (OpenstackNodes node : openstackNodes) {
            NodesDTO nodesDTO = new NodesDTO();
            if (nodesDTO != null) {
                BeanUtils.copyProperties(node, nodesDTO);
            }
            nodesDTOS.add(nodesDTO);
        }
        return Result.Success(nodesDTOS);
    }
}
