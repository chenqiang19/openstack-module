package com.ict.cloud.wapper.Impl;

import com.ict.cloud.baremetal.BareMetal;
import com.ict.cloud.baremetal.model.Node;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.resource.domain.OpenstackNodes;
import com.ict.cloud.resource.service.IOpenstackNodesService;
import com.ict.cloud.wapper.IOpenstackBareMetalService;
import com.ict.cloud.wapper.IOpenstackIdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Service("bare_metal")
public class OpenstackBareMetalServiceImpl implements IOpenstackBareMetalService {
    @Autowired
    private IOpenstackNodesService openstackNodesService;
    @Resource
    private IOpenstackIdentityService iOpenstackIdentityService;

    @Override
    public List<OpenstackNodes> getOpenstackNodes() {
        return openstackNodesService.getOpenstackNodes();
    }

    @Override
    public boolean updateOpenstackNodeToDB() throws OperationException {
        boolean valid = iOpenstackIdentityService.connectOpenstack();
        if(!valid){
            throw new OperationException("Openstack Connect failed!");
        }
        try{
            final BareMetal bareMetal = iOpenstackIdentityService.getAdminBareMetal();
            List<Node> nodes = bareMetal.nodes.list("node");
            OpenstackNodes openstackNodes = new OpenstackNodes();
            //这里需要删除多余的记录
            List<OpenstackNodes> nodeDB = openstackNodesService.getOpenstackNodes();
            for(OpenstackNodes selectNodes : nodeDB){
                AtomicBoolean flag = new AtomicBoolean(false);
                nodes.forEach(node ->{
                    if(node.getUuid().equals(selectNodes.getUuid())){
                        flag.set(true);
                    }
                });
                if(!flag.get()){
                    openstackNodesService.removeNodeByUuid(selectNodes.getId());
                }
            }
            for(Node node : nodes) {
                Node nodeInfo = bareMetal.nodes.get(node.getUuid());
                openstackNodes.setInstanceUuid(node.getInstance_uuid());
                openstackNodes.setUuid(node.getUuid());
                openstackNodes.setPowerState(node.getPowerState());
                openstackNodes.setProvisionState(node.getProvision_state());
                if(nodeInfo!=null){
                    Node.Properties properties = nodeInfo.getProperties();
                    openstackNodes.setMemoryMb(properties.getMemoryMb());
                    openstackNodes.setLocalGb(properties.getLocalGb());
                    openstackNodes.setVcpus(properties.getCpuNum());
                    openstackNodes.setCpuArch(properties.getCpuArch());
                    openstackNodes.setGpuFlag(properties.getGpuFlag());
                    openstackNodes.setMachineFlag(properties.getBrand());
                }
                openstackNodesService.insertOpenstackNodes(openstackNodes);
            }
        }catch(Exception e) {
            throw new OperationException("updateOpenstackNodeToDB failed!\n" + e.toString());
        }
        return true;
    }

    @Override
    public  List<OpenstackNodes> getOpenstackNodesByArch(String arch, String gpuFlag) {
        return openstackNodesService.getOpenstackNodesByArch(arch, gpuFlag);
    }
}
