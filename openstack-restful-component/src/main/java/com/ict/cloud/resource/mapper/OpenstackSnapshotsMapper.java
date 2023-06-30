package com.ict.cloud.resource.mapper;

import com.ict.cloud.resource.domain.OpenstackSnapshots;
import com.ict.cloud.resource.domain.OpenstackSnapshotsCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OpenstackSnapshotsMapper {
    long countByExample(OpenstackSnapshotsCriteria example);

    int deleteByExample(OpenstackSnapshotsCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(OpenstackSnapshots record);

    int insertSelective(OpenstackSnapshots record);

    OpenstackSnapshots selectOneByExample(OpenstackSnapshotsCriteria example);

    List<OpenstackSnapshots> selectByExample(OpenstackSnapshotsCriteria example);

    OpenstackSnapshots selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OpenstackSnapshots record, @Param("example") OpenstackSnapshotsCriteria example);

    int updateByExample(@Param("record") OpenstackSnapshots record, @Param("example") OpenstackSnapshotsCriteria example);

    int updateByPrimaryKeySelective(OpenstackSnapshots record);

    int updateByPrimaryKey(OpenstackSnapshots record);

    List<OpenstackSnapshots> selectAllSnapshots();
}