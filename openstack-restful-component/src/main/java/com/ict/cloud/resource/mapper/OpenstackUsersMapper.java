package com.ict.cloud.resource.mapper;

import com.ict.cloud.resource.domain.OpenstackUsers;
import com.ict.cloud.resource.domain.OpenstackUsersCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OpenstackUsersMapper {
    long countByExample(OpenstackUsersCriteria example);

    int deleteByExample(OpenstackUsersCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(OpenstackUsers record);

    int insertSelective(OpenstackUsers record);

    OpenstackUsers selectOneByExample(OpenstackUsersCriteria example);

    List<OpenstackUsers> selectByExample(OpenstackUsersCriteria example);

    OpenstackUsers selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OpenstackUsers record, @Param("example") OpenstackUsersCriteria example);

    int updateByExample(@Param("record") OpenstackUsers record, @Param("example") OpenstackUsersCriteria example);

    int updateByPrimaryKeySelective(OpenstackUsers record);

    int updateByPrimaryKey(OpenstackUsers record);
}