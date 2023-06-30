package com.ict.cloud.resource.mapper;

import com.ict.cloud.resource.domain.OpenstackFlavors;
import com.ict.cloud.resource.domain.OpenstackFlavorsCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OpenstackFlavorsMapper {
    long countByExample(OpenstackFlavorsCriteria example);

    int deleteByExample(OpenstackFlavorsCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(OpenstackFlavors record);

    int insertSelective(OpenstackFlavors record);

    OpenstackFlavors selectOneByExample(OpenstackFlavorsCriteria example);

    List<OpenstackFlavors> selectByExample(OpenstackFlavorsCriteria example);

    OpenstackFlavors selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OpenstackFlavors record, @Param("example") OpenstackFlavorsCriteria example);

    int updateByExample(@Param("record") OpenstackFlavors record, @Param("example") OpenstackFlavorsCriteria example);

    int updateByPrimaryKeySelective(OpenstackFlavors record);

    int updateByPrimaryKey(OpenstackFlavors record);

    List<OpenstackFlavors> selectAllFlavors();

}