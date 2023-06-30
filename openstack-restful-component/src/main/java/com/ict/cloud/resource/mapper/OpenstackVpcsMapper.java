package com.ict.cloud.resource.mapper;

import com.ict.cloud.model.VpcDTO;
import com.ict.cloud.resource.domain.OpenstackVpcs;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OpenstackVpcsMapper  {
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert({
            "insert into openstack_vpcs ",
            "(name, segment, status, router_name, region, tenant_id)",
            " values ",
            "(#{name}, #{segment}, #{status}, #{routerName}, #{region}, #{tenantId})"
    })
    int insert(OpenstackVpcs openstackVpcs);

    @Update({
            "update openstack_vpcs set status =#{vpcStatus} where id=#{vpcId}"
    })
    void updateStatus(@Param("vpcId") Integer vpcId, @Param("vpcStatus") String vpcStatus);

    @Select({
            "select name as name, segment as segment, status as status, router_name as routerName, region as region ",
            "from openstack_vpcs where tenant_id = #{tenantId}"
    })
    List<OpenstackVpcs> getVpcsByTenantId(Integer tenantId);

    @Update({
            "<script>",
            "update openstack_vpcs",
            "  <set>",
            "    <if test='name != null'> name=#{name},</if>",
            "    <if test='segment != null'> segment=#{segment},</if>",
            "    <if test='status != null'> status=#{status}</if>",
            "    <if test='routerName != null'> router_name=#{routerName}</if>",
            "    <if test='region != null'> region=#{region}</if>",
            "    <if test='tenantId != null'> tenant_id=#{tenantId}</if>",
            "    <if test='subnetId !=null'> subnet_id=#{subnetId}</if>",
            "  </set>",
            "where id=#{id}",
            "</script>"
    })
    void update(VpcDTO vpcDTO, Integer id);
}

