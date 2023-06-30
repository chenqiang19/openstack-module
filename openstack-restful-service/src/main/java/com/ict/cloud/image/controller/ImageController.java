package com.ict.cloud.image.controller;

import com.ict.cloud.vo.ImageConfigVO;
import com.ict.cloud.vo.ImageVO;
import com.ict.cloud.common.analzye.ApiResult;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.resource.domain.OpenstackImages;
import com.ict.cloud.wapper.IOpenstackImageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/openstack-management/image")
public class ImageController {

    @Resource
    private IOpenstackImageService iOpenstackImageService;

    @PutMapping("/updateOpenstackImageToDB")
    public ApiResult<List<ImageConfigVO>> updateOpenstackImageToDB() {
        try {
            List<ImageConfigVO> updateStatus = iOpenstackImageService.updateOpenstackImageToDB();
            return ApiResult.success(updateStatus);
        } catch (OperationException | ParseException e) {
            return ApiResult.failed(e.getMessage());
        }
    }

    @GetMapping("/getImages")
    public ApiResult<List<OpenstackImages>> getImages(@RequestParam("arch") String arch,
                                                      @RequestParam("imageType") String imageType) {
        List<OpenstackImages> images = iOpenstackImageService.getImages(arch, imageType);
        return ApiResult.success(images);
    }

    @GetMapping("/getImageByImageId/{imageId}")
    public ApiResult<OpenstackImages> getImageByImageId(@PathVariable("imageId") String imageId) {
        OpenstackImages images = iOpenstackImageService.getImageByImageId(imageId);
        return ApiResult.success(images);
    }

    @ApiOperation(value = "获取所有的底层镜像")
    @GetMapping(value = "/getAllImages")
    public ApiResult<List<ImageVO>> getAllImages(@RequestParam("arch") String arch,
                                                 @RequestParam("code") String categoryCode,
                                                 @RequestParam(value = "flavor", defaultValue = "") String flavor) {
        return ApiResult.success(iOpenstackImageService.listImages(arch, categoryCode, flavor));
    }

    @GetMapping("/getImageProducts")
    public ApiResult<List<ImageConfigVO>> getImageProducts(@RequestParam("id") String id,
                                                           @RequestParam("currentPage") Integer currentPage,
                                                           @RequestParam("pageSize") Integer pageSize) {
        try {
            List<ImageConfigVO> imageStatus = iOpenstackImageService.updateOpenstackImageToDB();
            return ApiResult.success(imageStatus);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (OperationException e) {
            e.printStackTrace();
        }
        return ApiResult.failed(-1, "获取镜像失败");
    }

    @PostMapping("/actionImageCommand")
    public ApiResult actionImageCommand(@RequestParam("imageId") String imageId,
                                        @RequestParam("command") String command) {
        try {
            boolean status = iOpenstackImageService.actionImageCommand(imageId, command);
            if (status) {
                return ApiResult.success();
            }
        } catch (OperationException e) {
            e.printStackTrace();
        }
        return ApiResult.failed(-1, "镜像操作失败！");
    }

    @DeleteMapping("/removeImageById")
    public ApiResult removeImageById(@RequestParam("imageId") String imageId) {
        boolean status = iOpenstackImageService.removeImageById(imageId);
        if (status) {
            return ApiResult.success();
        }
        return ApiResult.failed(-1, "删除镜像失败！");
    }

    @PutMapping("/updateImage")
    public ApiResult updateImage(@RequestBody ImageConfigVO imageConfigVO) {
        boolean status = iOpenstackImageService.updateImage(imageConfigVO);
        if (status) {
            return ApiResult.success("镜像成功");
        }
        return ApiResult.failed(-1, "镜像更新失败！");
    }
}
