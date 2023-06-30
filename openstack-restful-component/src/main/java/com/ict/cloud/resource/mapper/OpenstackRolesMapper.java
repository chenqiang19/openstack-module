package com.ict.cloud.resource.mapper;

import com.ict.cloud.resource.domain.OpenstackRoles;
import com.ict.cloud.resource.domain.OpenstackRolesCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OpenstackRolesMapper {
    long countByExample(OpenstackRolesCriteria example);

    int deleteByExample(OpenstackRolesCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(OpenstackRoles record);

    int insertSelective(OpenstackRoles record);

    OpenstackRoles selectOneByExample(OpenstackRolesCriteria example);

    List<OpenstackRoles> selectByExample(OpenstackRolesCriteria example);

    OpenstackRoles selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OpenstackRoles record, @Param("example") OpenstackRolesCriteria example);

    int updateByExample(@Param("record") OpenstackRoles record, @Param("example") OpenstackRolesCriteria example);

    int updateByPrimaryKeySelective(OpenstackRoles record);

    int updateByPrimaryKey(OpenstackRoles record);
}