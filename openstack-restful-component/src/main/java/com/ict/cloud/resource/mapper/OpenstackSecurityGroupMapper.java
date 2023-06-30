package com.ict.cloud.resource.mapper;

import com.ict.cloud.resource.domain.OpenstackSecurityGroup;
import com.ict.cloud.resource.domain.OpenstackSecurityGroupCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OpenstackSecurityGroupMapper {
    long countByExample(OpenstackSecurityGroupCriteria example);

    int deleteByExample(OpenstackSecurityGroupCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(OpenstackSecurityGroup record);

    int insertSelective(OpenstackSecurityGroup record);

    OpenstackSecurityGroup selectOneByExample(OpenstackSecurityGroupCriteria example);

    List<OpenstackSecurityGroup> selectByExample(OpenstackSecurityGroupCriteria example);

    OpenstackSecurityGroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OpenstackSecurityGroup record, @Param("example") OpenstackSecurityGroupCriteria example);

    int updateByExample(@Param("record") OpenstackSecurityGroup record, @Param("example") OpenstackSecurityGroupCriteria example);

    int updateByPrimaryKeySelective(OpenstackSecurityGroup record);

    int updateByPrimaryKey(OpenstackSecurityGroup record);

    List<OpenstackSecurityGroup> selectSecurityGroupIds();
}