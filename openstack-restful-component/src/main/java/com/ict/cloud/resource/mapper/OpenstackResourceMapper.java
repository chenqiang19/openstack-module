package com.ict.cloud.resource.mapper;

import com.ict.cloud.resource.domain.OpenstackResource;
import com.ict.cloud.resource.domain.OpenstackResourceCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OpenstackResourceMapper {
    long countByExample(OpenstackResourceCriteria example);

    int deleteByExample(OpenstackResourceCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(OpenstackResource record);

    int insertSelective(OpenstackResource record);

    OpenstackResource selectOneByExample(OpenstackResourceCriteria example);

    List<OpenstackResource> selectByExample(OpenstackResourceCriteria example);

    OpenstackResource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OpenstackResource record, @Param("example") OpenstackResourceCriteria example);

    int updateByExample(@Param("record") OpenstackResource record, @Param("example") OpenstackResourceCriteria example);

    int updateByPrimaryKeySelective(OpenstackResource record);

    int updateByPrimaryKey(OpenstackResource record);

    List<OpenstackResource> selectAllExample();

}