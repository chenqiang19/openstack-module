package com.ict.cloud.resource.mapper;

import com.ict.cloud.model.ServerGroupDTO;
import com.ict.cloud.resource.domain.OpenstackServerGroups;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface OpenstackServerGroupsMapper {
    @Insert({
            "insert into openstack_server_group ",
            "(name,policy,instance_num,members,tenant_id,server_group_id)",
            " values ",
            "(#{name},#{policy},#{instanceNum},#{members},#{tenantId},#{serverGroupId})"
    })
    int insert(OpenstackServerGroups openstackServerGroups);

    @Select({
            "select name as name, policy as policy, instance_num as instanceNum, members as members,",
            "tenant_id as tenantId, server_group_id as serverGroupId ",
            "from openstack_server_group where tenant_id=#{tenantId}"
    })
    List<ServerGroupDTO> getServerGroup(Integer tenantId);
}
