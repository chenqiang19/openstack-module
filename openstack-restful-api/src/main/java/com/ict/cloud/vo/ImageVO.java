package com.ict.cloud.vo;

import com.ict.cloud.model.ImageDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageVO {
    public Integer tag;
    public String arch;
    public String imageName;
    public List<ImageDTO> imageDTOList;
}

