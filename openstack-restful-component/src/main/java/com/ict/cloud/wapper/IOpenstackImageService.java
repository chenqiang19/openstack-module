package com.ict.cloud.wapper;

import com.ict.cloud.vo.ImageConfigVO;
import com.ict.cloud.vo.ImageVO;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.resource.domain.OpenstackImages;

import java.text.ParseException;
import java.util.List;

public interface IOpenstackImageService {
    List<ImageConfigVO> updateOpenstackImageToDB() throws OperationException, ParseException;

    List<OpenstackImages> getImages(String arch, String imageType);

    OpenstackImages getImageById(Integer id);

    List<ImageVO> listImages(String arch, String category, String flavor);

    boolean actionImageCommand(String imageId, String command) throws OperationException;

    boolean removeImageById(String imageId);

    boolean updateImage(ImageConfigVO imageConfigVO);

    OpenstackImages getImageByImageId(String id);
}
