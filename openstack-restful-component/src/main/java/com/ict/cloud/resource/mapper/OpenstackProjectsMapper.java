package com.ict.cloud.resource.mapper;

import com.ict.cloud.resource.domain.OpenstackProjects;
import com.ict.cloud.resource.domain.OpenstackProjectsCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OpenstackProjectsMapper {
    long countByExample(OpenstackProjectsCriteria example);

    int deleteByExample(OpenstackProjectsCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(OpenstackProjects record);

    int insertSelective(OpenstackProjects record);

    OpenstackProjects selectOneByExample(OpenstackProjectsCriteria example);

    List<OpenstackProjects> selectByExample(OpenstackProjectsCriteria example);

    OpenstackProjects selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OpenstackProjects record, @Param("example") OpenstackProjectsCriteria example);

    int updateByExample(@Param("record") OpenstackProjects record, @Param("example") OpenstackProjectsCriteria example);

    int updateByPrimaryKeySelective(OpenstackProjects record);

    int updateByPrimaryKey(OpenstackProjects record);
}