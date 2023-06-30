package com.ict.cloud.resource.mapper;

import com.ict.cloud.resource.domain.OpenstackSubnets;
import com.ict.cloud.resource.domain.OpenstackSubnetsCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OpenstackSubnetsMapper {
    long countByExample(OpenstackSubnetsCriteria example);

    int deleteByExample(OpenstackSubnetsCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(OpenstackSubnets record);

    int insertSelective(OpenstackSubnets record);

    OpenstackSubnets selectOneByExample(OpenstackSubnetsCriteria example);

    List<OpenstackSubnets> selectByExample(OpenstackSubnetsCriteria example);

    OpenstackSubnets selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OpenstackSubnets record, @Param("example") OpenstackSubnetsCriteria example);

    int updateByExample(@Param("record") OpenstackSubnets record, @Param("example") OpenstackSubnetsCriteria example);

    int updateByPrimaryKeySelective(OpenstackSubnets record);

    int updateByPrimaryKey(OpenstackSubnets record);

    List<OpenstackSubnets> getAllSubnets();
}
