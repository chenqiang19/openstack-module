package com.ict.cloud.resource.mapper;

import com.ict.cloud.resource.domain.OpenstackNetworks;
import com.ict.cloud.resource.domain.OpenstackNetworksCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OpenstackNetworksMapper {
    long countByExample(OpenstackNetworksCriteria example);

    int deleteByExample(OpenstackNetworksCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(OpenstackNetworks record);

    int insertSelective(OpenstackNetworks record);

    OpenstackNetworks selectOneByExample(OpenstackNetworksCriteria example);

    List<OpenstackNetworks> selectByExample(OpenstackNetworksCriteria example);

    OpenstackNetworks selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OpenstackNetworks record, @Param("example") OpenstackNetworksCriteria example);

    int updateByExample(@Param("record") OpenstackNetworks record, @Param("example") OpenstackNetworksCriteria example);

    int updateByPrimaryKeySelective(OpenstackNetworks record);

    int updateByPrimaryKey(OpenstackNetworks record);

    List<String> selectNetworksAllId();

    List<OpenstackNetworks> selectAllNetwork();
}