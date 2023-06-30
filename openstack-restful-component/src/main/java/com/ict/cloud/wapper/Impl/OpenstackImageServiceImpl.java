package com.ict.cloud.wapper.Impl;

import com.ict.cloud.vo.ImageConfigVO;
import com.ict.cloud.vo.ImageVO;
import com.ict.cloud.common.constants.OpenstackConstants;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.common.helper.RegHepler;
import com.ict.cloud.model.ImageDTO;
import com.ict.cloud.image.model.Image;
import com.ict.cloud.resource.domain.OpenstackImages;
import com.ict.cloud.resource.service.IOpenstackImagesService;
import com.ict.cloud.wapper.IOpenstackIdentityService;
import com.ict.cloud.wapper.IOpenstackImageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OpenstackImageServiceImpl implements IOpenstackImageService {
    @Autowired
    private IOpenstackImagesService openstackImagesService;
    @Resource
    private IOpenstackIdentityService iOpenstackIdentityService;
    public List<ImageConfigVO> updateOpenstackImageToDB() throws OperationException {
        boolean valid = iOpenstackIdentityService.connectOpenstack();
        if(!valid){
            throw new OperationException("Openstack Connect failed!");
        }
        List<ImageConfigVO> openstackImagesList = new ArrayList<>();
        try{
            final com.ict.cloud.image.Image imageAdmin = iOpenstackIdentityService.getAdminImage();
            //查询image和flavor到openstack_storehouse
            List<Image> images = imageAdmin.images.list();

            for (Image image : images) {
                //Image imagesDetail = nova.images.get(image.getId());
                if(!RegHepler.isIegalImage(image.getName())){
                    continue;
                }
                String [] imageArray = image.getName().split("-");
                String archName=null;
                if(imageArray[3].contains(".")){
                    archName = imageArray[3].split(".")[0];
                }else{
                    archName = imageArray[3];
                }
                List<OpenstackImages> imageInfo = openstackImagesService.getImageByDeviceType(imageArray[0], imageArray[1], imageArray[2], archName);
                String dateCreate = image.getCreated().replace("T", " ").replace("Z", "");
                String dateUpdate = image.getUpdated().replace("T", " ").replace("Z", "");
                OpenstackImages openstackImages = new OpenstackImages();
                openstackImages.setUpdatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateUpdate));
                openstackImages.setCreateAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateCreate));
                openstackImages.setImageId(image.getId());
                openstackImages.setImageStatus(image.getStatus());
                openstackImages.setImageName(imageArray[0]);
                openstackImages.setImageVersion(imageArray[1]);
                openstackImages.setImageType(imageArray[2]);
                openstackImages.setImageArch(archName);
                openstackImages.setDiskFormat(image.getDiskFormat());
                openstackImages.setImageVisibility(image.getVisibility());
                if (image.getOsAdminUser() != null){
                    openstackImages.setOsAdminUser(image.getOsAdminUser());
                }
                openstackImages.setProtectedFlag(image.getProtectedFlag());
                BigDecimal imageSizeMB = BigDecimal.valueOf(image.getSize()).divide(BigDecimal.valueOf(1024))
                        .divide(BigDecimal.valueOf(1024)).setScale(2, BigDecimal.ROUND_DOWN);
                if (imageSizeMB.compareTo(BigDecimal.valueOf(1024)) >= 0) {
                    BigDecimal imageSizeGB = imageSizeMB.divide(BigDecimal.valueOf(1024)).setScale(2, BigDecimal.ROUND_DOWN);
                    openstackImages.setImageSize(imageSizeGB + "GB");
                } else {
                    openstackImages.setImageSize(imageSizeMB + "MB");
                }

                ImageConfigVO imageConfigVO = new ImageConfigVO();
                if(imageInfo.size()==0){
                    openstackImagesService.insertOpenstackImage(openstackImages);
                    imageConfigVO.setId(openstackImages.getId());
                }else if(imageInfo.size()==1){
                    Optional<OpenstackImages> imageDB = imageInfo.stream().findFirst();
                    if (imageDB.isPresent()) {
                        openstackImages.setId(imageDB.get().getId());
                        openstackImagesService.updateOpenstackImage(openstackImages);
                        imageConfigVO.setId(imageDB.get().getId());
                    }
                }
                BeanUtils.copyProperties(openstackImages, imageConfigVO);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(openstackImages.getImageName()).append("-")
                        .append(openstackImages.getImageVersion())
                        .append("-").append(openstackImages.getImageType())
                        .append("-").append(openstackImages.getImageArch());
                imageConfigVO.setImageName(String.valueOf(stringBuilder));
                imageConfigVO.setType("镜像");
                imageConfigVO.setMaxRamSize(image.getMinRam());
                imageConfigVO.setMinDiskSize(image.getMinDisk());
                openstackImagesList.add(imageConfigVO);
            }
        }catch(Exception e) {
            throw new OperationException("updateOpenstackImageToDB failed!");
        }
        return openstackImagesList;
    }

    public List<OpenstackImages> getImages(String arch, String imageType){
        return openstackImagesService.getAllImages(arch, imageType);
    }

    public OpenstackImages getImageById(Integer id){
        return openstackImagesService.getImageById(id);
    }

    public OpenstackImages getImageByImageId(String id){
        return openstackImagesService.getImageByImageId(id);
    }

    @Override
    public List<ImageVO> listImages(String arch, String categoryCode, String flavor){
        List<OpenstackImages> openstackImages = null;
        if(categoryCode.equals(OpenstackConstants.CATEGORYCODE_VMWARESERVER)){
            openstackImages = this.getImages(arch, "gpt");
            List<OpenstackImages> openstackWindows = this.getImages(arch, "VM");
            if(openstackWindows.size()!=0) {
                openstackImages.addAll(openstackWindows);
            }
        }else if(categoryCode.equals(OpenstackConstants.CATEGORYCODE_PHYSICALSERVER)){
            openstackImages = this.getImages(arch, "efi");
            if(!flavor.equals("") && flavor!=null) {
                if (flavor.toUpperCase(Locale.ROOT).contains("C1")) {
                    List<OpenstackImages> huawei = this.getImages(arch, "HW");
                    if(huawei.size()!=0){
                        openstackImages.addAll(huawei);
                    }
                }else if(flavor.toUpperCase(Locale.ROOT).contains("B1")) {
                    List<OpenstackImages> h3c = this.getImages(arch, "H3C");
                    if(h3c.size()!=0){
                        openstackImages.addAll(h3c);
                    }
                }
            }
        }
        if(openstackImages==null || openstackImages.isEmpty()){
            return new ArrayList<>();
        }
        List<OpenstackImages> centosImage = null;
        List<OpenstackImages> ubuntuImage = null;
        List<OpenstackImages> windowsImage = null;
        List<OpenstackImages> fedoraImage = null;
        List<OpenstackImages> others = null;
        if(arch.toUpperCase(Locale.ROOT).equals(OpenstackConstants.IMAGE_ARCH_X86.toUpperCase(Locale.ROOT))){
            centosImage = openstackImages.stream().filter(a->a.getImageArch()!=null && a.getImageName()!=null &&
                    a.getImageArch().toUpperCase(Locale.ROOT).
                            equals(OpenstackConstants.IMAGE_ARCH_X86.toUpperCase(Locale.ROOT)) && a.getImageName().
                    compareToIgnoreCase(OpenstackConstants.IMAGE_NAME_CENTOS)==0).collect(Collectors.toList());

            ubuntuImage = openstackImages.stream().filter(a->a.getImageArch()!=null && a.getImageName()!=null &&
                    a.getImageArch().toUpperCase(Locale.ROOT).
                            equals(OpenstackConstants.IMAGE_ARCH_X86.toUpperCase(Locale.ROOT)) && a.getImageName().
                    compareToIgnoreCase(OpenstackConstants.IMAGE_NAME_UBUNTU)==0).collect(Collectors.toList());

            windowsImage = openstackImages.stream().filter(a->a.getImageArch()!=null && a.getImageName()!=null &&
                    a.getImageArch().toUpperCase(Locale.ROOT).
                            equals(OpenstackConstants.IMAGE_ARCH_X86.toUpperCase(Locale.ROOT)) && (a.getImageName().
                    compareToIgnoreCase(OpenstackConstants.IMAGE_NAME_WINDOWS)==0 || a.getImageName().
                    toUpperCase(Locale.ROOT).contains(OpenstackConstants.IMAGE_WINDOWS_PREFIX))).collect(Collectors.toList());
            fedoraImage = openstackImages.stream().filter(a->a.getImageArch()!=null && a.getImageName()!=null &&
                    a.getImageArch().toUpperCase(Locale.ROOT).
                            equals(OpenstackConstants.IMAGE_ARCH_X86.toUpperCase(Locale.ROOT)) && (a.getImageName().
                    compareToIgnoreCase(OpenstackConstants.IMAGE_NAME_FEDORA)==0)).collect(Collectors.toList());
        }else if(arch.toUpperCase(Locale.ROOT).equals(OpenstackConstants.IMAGE_ARCH_ARM.toUpperCase(Locale.ROOT))){
            centosImage = openstackImages.stream().filter(a->a.getImageArch()!=null && a.getImageName()!=null &&
                    a.getImageArch().toUpperCase(Locale.ROOT).
                            equals(OpenstackConstants.IMAGE_ARCH_ARM.toUpperCase(Locale.ROOT)) && a.getImageName().
                    compareToIgnoreCase(OpenstackConstants.IMAGE_NAME_CENTOS)==0).collect(Collectors.toList());

            ubuntuImage = openstackImages.stream().filter(a->a.getImageArch()!=null && a.getImageName()!=null &&
                    a.getImageArch().toUpperCase(Locale.ROOT).
                            equals(OpenstackConstants.IMAGE_ARCH_ARM.toUpperCase(Locale.ROOT)) && a.getImageName().
                    compareToIgnoreCase(OpenstackConstants.IMAGE_NAME_UBUNTU)==0).collect(Collectors.toList());

            windowsImage = openstackImages.stream().filter(a->a.getImageArch()!=null && a.getImageName()!=null &&
                    a.getImageArch().toUpperCase(Locale.ROOT).
                            equals(OpenstackConstants.IMAGE_ARCH_ARM.toUpperCase(Locale.ROOT)) && (a.getImageName().
                    compareToIgnoreCase(OpenstackConstants.IMAGE_NAME_WINDOWS)==0 || a.getImageName().
                    toUpperCase(Locale.ROOT).contains(OpenstackConstants.IMAGE_WINDOWS_PREFIX))).collect(Collectors.toList());

            fedoraImage = openstackImages.stream().filter(a->a.getImageArch()!=null && a.getImageName()!=null &&
                    a.getImageArch().toUpperCase(Locale.ROOT).
                            equals(OpenstackConstants.IMAGE_ARCH_ARM.toUpperCase(Locale.ROOT)) && (a.getImageName().
                    compareToIgnoreCase(OpenstackConstants.IMAGE_NAME_FEDORA)==0)).collect(Collectors.toList());
        }else if(arch.toUpperCase(Locale.ROOT).equals(OpenstackConstants.IMAGE_ARCH_X86_64.toUpperCase(Locale.ROOT))){
            centosImage = openstackImages.stream().filter(a->a.getImageArch()!=null && a.getImageName()!=null &&
                    a.getImageArch().toUpperCase(Locale.ROOT).
                            equals(OpenstackConstants.IMAGE_ARCH_X86_64.toUpperCase(Locale.ROOT)) && a.getImageName().
                    compareToIgnoreCase(OpenstackConstants.IMAGE_NAME_CENTOS)==0).collect(Collectors.toList());

            ubuntuImage = openstackImages.stream().filter(a->a.getImageArch()!=null && a.getImageName()!=null &&
                    a.getImageArch().toUpperCase(Locale.ROOT).
                            equals(OpenstackConstants.IMAGE_ARCH_X86_64.toUpperCase(Locale.ROOT)) && a.getImageName().
                    compareToIgnoreCase(OpenstackConstants.IMAGE_NAME_UBUNTU)==0).collect(Collectors.toList());

            windowsImage = openstackImages.stream().filter(a->a.getImageArch()!=null && a.getImageName()!=null &&
                    a.getImageArch().toUpperCase(Locale.ROOT).
                            equals(OpenstackConstants.IMAGE_ARCH_X86_64.toUpperCase(Locale.ROOT)) && (a.getImageName().
                    compareToIgnoreCase(OpenstackConstants.IMAGE_NAME_WINDOWS)==0 || a.getImageName().
                    toUpperCase(Locale.ROOT).contains(OpenstackConstants.IMAGE_WINDOWS_PREFIX))).collect(Collectors.toList());

            fedoraImage = openstackImages.stream().filter(a->a.getImageArch()!=null && a.getImageName()!=null &&
                    a.getImageArch().toUpperCase(Locale.ROOT).
                            equals(OpenstackConstants.IMAGE_ARCH_X86_64.toUpperCase(Locale.ROOT)) && (a.getImageName().
                    compareToIgnoreCase(OpenstackConstants.IMAGE_NAME_FEDORA)==0)).collect(Collectors.toList());
        }

        openstackImages.removeAll(centosImage);
        openstackImages.removeAll(ubuntuImage);
        openstackImages.removeAll(windowsImage);
        openstackImages.removeAll(fedoraImage);
        ImageVO imageCentos = null;
        if(centosImage!=null && centosImage.size()>0){
            imageCentos = new ImageVO();
            centosImage = centosImage.stream().sorted(Comparator.comparing(OpenstackImages::getImageVersion).reversed()).collect(Collectors.toList());
            List<ImageDTO> imageDTOList = new ArrayList<>();
            imageCentos.setArch(arch);
            imageCentos.setImageName(OpenstackConstants.IMAGE_NAME_CENTOS);
            for(OpenstackImages image : centosImage){
                ImageDTO imageDTO = new ImageDTO();
                imageDTO.setImageId(image.getImageId());
                imageDTO.setImageStatus(image.getImageStatus());
                imageDTO.setImageVersion(image.getImageVersion());
                imageDTO.setImageName(image.getImageName());
                imageDTOList.add(imageDTO);
            }
            imageCentos.setImageDTOList(imageDTOList);
        }

        ImageVO imageUbuntu = null;
        if(ubuntuImage!=null && ubuntuImage.size()>0){
            imageUbuntu = new ImageVO();
            ubuntuImage = ubuntuImage.stream().sorted(Comparator.comparing(OpenstackImages::getImageVersion).reversed()).collect(Collectors.toList());
            List<ImageDTO> imageDTOList = new ArrayList<>();
            imageUbuntu.setArch(arch);
            imageUbuntu.setImageName(OpenstackConstants.IMAGE_NAME_UBUNTU);
            for(OpenstackImages image : ubuntuImage){
                ImageDTO imageDTO = new ImageDTO();
                imageDTO.setImageId(image.getImageId());
                imageDTO.setImageStatus(image.getImageStatus());
                imageDTO.setImageVersion(image.getImageVersion());
                imageDTO.setImageName(image.getImageName());
                imageDTOList.add(imageDTO);
            }
            imageUbuntu.setImageDTOList(imageDTOList);
        }

        ImageVO imageWindows = null;
        if(windowsImage!=null && windowsImage.size()>0){
            imageWindows = new ImageVO();
            windowsImage = windowsImage.stream().sorted(Comparator.comparing(OpenstackImages::getImageVersion).reversed()).collect(Collectors.toList());
            List<ImageDTO> imageDTOList = new ArrayList<>();
            imageWindows.setArch(arch);
            imageWindows.setImageName(OpenstackConstants.IMAGE_NAME_WINDOWS);
            for(OpenstackImages image : windowsImage){
                ImageDTO imageDTO = new ImageDTO();
                imageDTO.setImageId(image.getImageId());
                imageDTO.setImageStatus(image.getImageStatus());
                imageDTO.setImageVersion(image.getImageVersion());
                imageDTO.setImageName(image.getImageName());
                imageDTOList.add(imageDTO);
            }
            imageWindows.setImageDTOList(imageDTOList);
        }

        ImageVO imageFedoras = null;
        if(fedoraImage!=null && fedoraImage.size()>0){
            imageFedoras = new ImageVO();
            fedoraImage = fedoraImage.stream().sorted(Comparator.comparing(OpenstackImages::getImageVersion).reversed()).collect(Collectors.toList());
            List<ImageDTO> imageDTOList = new ArrayList<>();
            imageFedoras.setArch(arch);
            imageFedoras.setImageName(OpenstackConstants.IMAGE_NAME_FEDORA);
            for(OpenstackImages image : fedoraImage){
                ImageDTO imageDTO = new ImageDTO();
                imageDTO.setImageId(image.getImageId());
                imageDTO.setImageStatus(image.getImageStatus());
                imageDTO.setImageVersion(image.getImageVersion());
                imageDTO.setImageName(image.getImageName());
                imageDTOList.add(imageDTO);
            }
            imageFedoras.setImageDTOList(imageDTOList);
        }

        ImageVO imageOthers = null;
        if(openstackImages.size()>0){
            others = openstackImages;
            if(others!=null && others.size()>0){
                imageOthers = new ImageVO();
                others = others.stream().sorted(Comparator.comparing(OpenstackImages::getImageVersion).reversed()).collect(Collectors.toList());
                List<ImageDTO> imageDTOList = new ArrayList<>();
                imageOthers.setArch(arch);
                imageOthers.setImageName(OpenstackConstants.IMAGE_NAME_OTHERS);
                for(OpenstackImages image : others){
                    ImageDTO imageDTO = new ImageDTO();
                    imageDTO.setImageId(image.getImageId());
                    imageDTO.setImageStatus(image.getImageStatus());
                    imageDTO.setImageVersion(image.getImageVersion());
                    imageDTO.setImageName(image.getImageName());
                    imageDTOList.add(imageDTO);
                }
                imageOthers.setImageDTOList(imageDTOList);
            }
        }

        List<ImageVO> imageVOS = new ArrayList<>();
        if(imageCentos!=null && imageCentos.getImageDTOList()!=null && imageCentos.getImageDTOList().size()!=0){
            imageCentos.setTag(1);
            imageVOS.add(imageCentos);
        }
        if(imageUbuntu!=null && imageUbuntu.getImageDTOList()!=null && imageUbuntu.getImageDTOList().size()!=0){
            imageUbuntu.setTag(2);
            imageVOS.add(imageUbuntu);
        }
        if(imageWindows!=null && imageWindows.getImageDTOList()!=null && imageWindows.getImageDTOList().size()!=0){
            imageWindows.setTag(3);
            imageVOS.add(imageWindows);
        }
        if(imageFedoras!=null && imageFedoras.getImageDTOList()!=null && imageFedoras.getImageDTOList().size()!=0){
            imageFedoras.setTag(4);
            imageVOS.add(imageFedoras);
        }
        if(imageOthers!=null && imageOthers.getImageDTOList()!=null && imageOthers.getImageDTOList().size()!=0){
            imageOthers.setTag(5);
            imageVOS.add(imageOthers);
        }
        return imageVOS;
    }

    @Override
    public boolean actionImageCommand(String imageId, String command) {

        try {
            boolean valid = iOpenstackIdentityService.connectOpenstack();
            if(!valid){
                 return false;
            }
            final com.ict.cloud.image.Image imageAdmin = iOpenstackIdentityService.getAdminImage();
            if (!command.isEmpty() && command.toUpperCase(Locale.ROOT).equals(OpenstackConstants.PRODUCT_IMAGE_PUBLISH)) {
                imageAdmin.images.reactivate(imageId);
            } else if(!command.isEmpty() && command.toUpperCase(Locale.ROOT).equals(OpenstackConstants.PRODUCT_IMAGE_DOWNLOAD)) {
                imageAdmin.images.deactivate(imageId);
            } else {
                return false;
            }
            return true;
        } catch (OperationException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeImageById(String imageId) {
        if (imageId == null || imageId.isEmpty()) {
            return false;
        }
        try {
            boolean valid = iOpenstackIdentityService.connectOpenstack();
            if(!valid){
                throw new OperationException("Openstack Connect failed!");
            }
            final com.ict.cloud.image.Image imageAdmin = iOpenstackIdentityService.getAdminImage();
            imageAdmin.images.delete(imageId);
            return true;
        } catch (OperationException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateImage(ImageConfigVO imageConfigVO) {
        if (imageConfigVO == null || imageConfigVO.getImageId() == null) {
            return false;
        }
        try {
            boolean valid = iOpenstackIdentityService.connectOpenstack();
            if(!valid){
                throw new OperationException("Openstack Connect failed!");
            }
            final com.ict.cloud.image.Image imageAdmin = iOpenstackIdentityService.getAdminImage();
            Image image = new Image();
            image.setId(imageConfigVO.getImageId());
            image.setName(imageConfigVO.getImageName());
            image.setMinRam(imageConfigVO.getMaxRamSize());
            image.setMinDisk(imageConfigVO.getMinDiskSize());
            image.setVisibility(imageConfigVO.getImageVisibility());
            image.setProtectedFlag(imageConfigVO.getProtectedFlag());
            Image imageUpdate = imageAdmin.images.update(image);
            if (imageUpdate != null) {
                return true;
            }
        } catch (OperationException e) {
            e.printStackTrace();
        }
        return false;
    }
}
