package com.ict.cloud.wapper.rpcImpl;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.model.ImageDTO;
import com.ict.cloud.resource.domain.OpenstackImages;
import com.ict.cloud.result.Result;
import com.ict.cloud.rpc.ImageApiService;
import com.ict.cloud.vo.ImageConfigVO;
import com.ict.cloud.vo.ImageVO;
import com.ict.cloud.wapper.IOpenstackImageService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageApiServiceImpl implements ImageApiService {
    @Resource
    private IOpenstackImageService iOpenstackImageService;
    @Override
    public Result<List<ImageConfigVO>> updateOpenstackImageToDB() {
        try {
            List<ImageConfigVO> updateStatus = iOpenstackImageService.updateOpenstackImageToDB();
            return Result.Success(updateStatus);
        } catch (ParseException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        } catch (OperationException e) {
            e.printStackTrace();
            return Result.Failure(-1, e.getMessage());
        }
    }

    @Override
    public Result<List<ImageDTO>> getImages(String arch, String imageType) {
        List<OpenstackImages> openstackImagesList = iOpenstackImageService.getImages(arch, imageType);
        List<ImageDTO> imageDTOS = new ArrayList<>();
        for (OpenstackImages image : openstackImagesList) {
            ImageDTO imageDTO = new ImageDTO();
            if (image != null) {
                BeanUtils.copyProperties(image, imageDTO);
            }

            imageDTOS.add(imageDTO);
        }
        return Result.Success(imageDTOS);
    }

    @Override
    public Result<ImageDTO> getImageById(Integer imageId) {
        OpenstackImages images = iOpenstackImageService.getImageById(imageId);
        ImageDTO imageDTO = new ImageDTO();
        if (images != null) {
            BeanUtils.copyProperties(images, imageDTO);
        }
        return Result.Success(imageDTO);
    }

    @Override
    public Result<ImageDTO> getImageByImageId(String imageId) {
        OpenstackImages images = iOpenstackImageService.getImageByImageId(imageId);
        ImageDTO imageDTO = new ImageDTO();
        if (images != null) {
            BeanUtils.copyProperties(images, imageDTO);
        }
        return Result.Success(imageDTO);
    }
}
