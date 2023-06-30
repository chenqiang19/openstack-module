package com.ict.cloud.resource.service.impl;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.resource.domain.OpenstackImages;
import com.ict.cloud.resource.domain.OpenstackImagesCriteria;
import com.ict.cloud.resource.mapper.OpenstackImagesMapper;
import com.ict.cloud.resource.service.IOpenstackImagesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OpenstackImagesImpl implements IOpenstackImagesService {
    @Resource
    private OpenstackImagesMapper openstackImagesMapper;

    public void insertOpenstackImage(OpenstackImages resource) throws OperationException {
        int answer = openstackImagesMapper.insert(resource);
        if(answer < 0) {
            throw new OperationException("insertOpenstackImage failed！");
        }
    }

    public OpenstackImages getOpenstackImageByPrimaryKey(Integer id) {
        return openstackImagesMapper.selectByPrimaryKey(id);
    }

    public List<OpenstackImages> getAllImages(String arch, String imageType) {
        return openstackImagesMapper.selectImageLikeType(arch, imageType);
//        OpenstackImagesCriteria example = new OpenstackImagesCriteria();
//        OpenstackImagesCriteria.Criteria criteria = example.createCriteria();
//        //criteria.andImageTypeEqualTo(imageType);
//        criteria.andImageTypeLike(imageType);
//        criteria.andImageArchEqualTo(arch);
//        return openstackImagesMapper.selectByExample(example);
    }

    public List<OpenstackImages> getImageByDeviceType(String imageName, String imageVersion, String imageType, String arch) {
        OpenstackImagesCriteria example = new OpenstackImagesCriteria();
        OpenstackImagesCriteria.Criteria criteria = example.createCriteria();
        criteria.andImageNameEqualTo(imageName);
        criteria.andImageVersionEqualTo(imageVersion);
        criteria.andImageTypeEqualTo(imageType);
        criteria.andImageArchEqualTo(arch);
        return openstackImagesMapper.selectByExample(example);
    }
    public void updateOpenstackImage(OpenstackImages updateImage){
        OpenstackImagesCriteria example = new OpenstackImagesCriteria();
        OpenstackImagesCriteria.Criteria criteria = example.createCriteria();
        criteria.andImageIdEqualTo(updateImage.getImageId());
        openstackImagesMapper.updateByExample(updateImage,example);
    }

    public OpenstackImages getImageById(Integer id){
        OpenstackImagesCriteria example = new OpenstackImagesCriteria();
        OpenstackImagesCriteria.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<OpenstackImages> openstackImages = openstackImagesMapper.selectByExample(example);
        if(openstackImages.size()==1){
            return openstackImages.get(0);
        }
        return null;
    }

    public OpenstackImages getImageByImageId(String id){
        OpenstackImagesCriteria example = new OpenstackImagesCriteria();
        OpenstackImagesCriteria.Criteria criteria = example.createCriteria();
        criteria.andImageIdEqualTo(id);
        List<OpenstackImages> openstackImages = openstackImagesMapper.selectByExample(example);
        if(openstackImages.size()==1){
            return openstackImages.get(0);
        }
        return null;
    }

}
