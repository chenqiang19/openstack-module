package com.ict.cloud.image.api;

import java.util.List;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.image.model.Image;
import com.ict.cloud.vo.ImageConfigVO;

public interface ImageManager {
	Image get(String id) throws OperationException;
	List<Image> list() throws OperationException;
	void delete(String id) throws OperationException;
	void reactivate(String id) throws OperationException;
	void deactivate(String id) throws OperationException;
	Image update(Image image) throws OperationException;
}
