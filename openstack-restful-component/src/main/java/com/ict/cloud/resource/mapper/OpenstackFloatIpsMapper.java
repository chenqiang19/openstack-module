package com.ict.cloud.resource.mapper;

import com.ict.cloud.resource.domain.OpenstackFloatips;
import com.ict.cloud.resource.domain.OpenstackFloatipsCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface OpenstackFloatIpsMapper {
    long countByExample(OpenstackFloatipsCriteria example);

    int deleteByExample(OpenstackFloatipsCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(OpenstackFloatips record);

    int insertSelective(OpenstackFloatips record);

    OpenstackFloatips selectOneByExample(OpenstackFloatipsCriteria example);

    List<OpenstackFloatips> selectByExample(OpenstackFloatipsCriteria example);

    OpenstackFloatips selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OpenstackFloatips record, @Param("example") OpenstackFloatipsCriteria example);

    int updateByExample(@Param("record") OpenstackFloatips record, @Param("example") OpenstackFloatipsCriteria example);

    int updateByPrimaryKeySelective(OpenstackFloatips record);

    int updateByPrimaryKey(OpenstackFloatips record);

    @Select({
            "SELECT DISTINCT count(1) fixed_ip_address FROM openstack_floatips ",
            "WHERE tenant_id = #{tenantId}"
    })
    int countFloatIpByTenantId(Integer tenantId);

    @Update({
            "<script>",
            "update openstack_floatips",
            "  <set>",
            "    <if test='status != null'>status=#{status},</if>",
            "    <if test='detailId != null'>detail_id=#{detailId},</if>",
            "    <if test='orderId != null'>order_id=#{orderId}</if>",
            "  </set>",
            "where fixed_ip_address=#{floatip}",
            "</script>"
    })
    void updateFloatIpInfo(@Param("floatip") String floatip, @Param("status") String status,
                           @Param("detailId") Integer detailId, @Param("orderId") String orderId);
}
