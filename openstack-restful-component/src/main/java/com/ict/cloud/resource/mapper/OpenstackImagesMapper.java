package com.ict.cloud.resource.mapper;

import com.ict.cloud.resource.domain.OpenstackImages;
import com.ict.cloud.resource.domain.OpenstackImagesCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OpenstackImagesMapper {
    long countByExample(OpenstackImagesCriteria example);

    int deleteByExample(OpenstackImagesCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(OpenstackImages record);

    int insertSelective(OpenstackImages record);

    OpenstackImages selectOneByExample(OpenstackImagesCriteria example);

    List<OpenstackImages> selectByExample(OpenstackImagesCriteria example);

    OpenstackImages selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OpenstackImages record, @Param("example") OpenstackImagesCriteria example);

    int updateByExample(@Param("record") OpenstackImages record, @Param("example") OpenstackImagesCriteria example);

    int updateByPrimaryKeySelective(OpenstackImages record);

    int updateByPrimaryKey(OpenstackImages record);

    List<OpenstackImages> selectAllImages();

    @Select({
            "select image_id as imageId, image_name as imageName, image_status as imageStatus,",
            "image_version as imageVersion, image_arch as imageArch, image_type as imageType ",
            "from openstack_images where 1=1 ",
            "and image_arch=#{arch} and image_type like '%${imageType}%'"
    })
    List<OpenstackImages> selectImageLikeType(@Param("arch") String arch, @Param("imageType") String imageType);
}