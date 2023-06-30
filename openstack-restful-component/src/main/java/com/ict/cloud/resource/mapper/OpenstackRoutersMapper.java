package com.ict.cloud.resource.mapper;

import com.ict.cloud.resource.domain.OpenstackRouters;
import com.ict.cloud.resource.domain.OpenstackRoutersCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface OpenstackRoutersMapper {
    long countByExample(OpenstackRoutersCriteria example);

    int deleteByExample(OpenstackRoutersCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(OpenstackRouters record);

    int insertSelective(OpenstackRouters record);

    OpenstackRouters selectOneByExample(OpenstackRoutersCriteria example);

    List<OpenstackRouters> selectByExample(OpenstackRoutersCriteria example);

    OpenstackRouters selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OpenstackRouters record, @Param("example") OpenstackRoutersCriteria example);

    int updateByExample(@Param("record") OpenstackRouters record, @Param("example") OpenstackRoutersCriteria example);

    int updateByPrimaryKeySelective(OpenstackRouters record);

    int updateByPrimaryKey(OpenstackRouters record);

    @Update({
        "update openstack_routers set",
        "external_gateway_info=#{gatewayInfo} where router_id=#{routerId}"
    })
    void updateGatewayInfo(@Param("routerId") String routerId, @Param("gatewayInfo") String gatewayInfo);
}
