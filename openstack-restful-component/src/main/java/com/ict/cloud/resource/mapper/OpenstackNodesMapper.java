package com.ict.cloud.resource.mapper;

import com.ict.cloud.resource.domain.OpenstackNodes;
import com.ict.cloud.resource.domain.OpenstackNodesCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;										
import org.apache.ibatis.annotations.Param;
@Mapper
public interface OpenstackNodesMapper {
    long countByExample(OpenstackNodesCriteria example);

    int deleteByExample(OpenstackNodesCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(OpenstackNodes record);

    int insertSelective(OpenstackNodes record);

    OpenstackNodes selectOneByExample(OpenstackNodesCriteria example);

    List<OpenstackNodes> selectByExample(OpenstackNodesCriteria example);

    OpenstackNodes selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OpenstackNodes record, @Param("example") OpenstackNodesCriteria example);

    int updateByExample(@Param("record") OpenstackNodes record, @Param("example") OpenstackNodesCriteria example);

    int updateByPrimaryKeySelective(OpenstackNodes record);

    int updateByPrimaryKey(OpenstackNodes record);
	List<OpenstackNodes> selectAllExample();
}