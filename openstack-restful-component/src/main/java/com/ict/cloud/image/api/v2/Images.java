package com.ict.cloud.image.api.v2;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.common.exception.OperationException;

import com.ict.cloud.common.request.HTTPHeader;
import com.ict.cloud.common.request.Header;
import com.ict.cloud.common.request.HttpMethod;
import com.ict.cloud.common.request.Response;
import com.ict.cloud.image.model.Image;
import com.ict.cloud.image.api.ImageManager;
import org.json.JSONArray;
import org.json.JSONObject;

public class Images extends AbstractManager<Image> implements ImageManager {
	
	public Images(Authenticated credentical) {
		super(credentical, Image.class);
	}

	private static final String PREFIX = "/v2.1/images";

	private String  doAction(String id, String action, Map<String, ? extends Object> info) throws OperationException {
		String url = String.format(PREFIX + "/%s/actions", id);
		JSONObject body = null;
		if (info != null) {
			body = new JSONObject();
			body.put(action, new JSONObject(info));
		} else {
			url = url + "/" + action;
		}

		Response response = null;
		try {
			response = super.request(url, HttpMethod.POST, body);
		} catch(Exception e) {
			throw new OperationException(e);
		}
		if (!response.isSuccess()) {
			throw new OperationException(response.getBody());
		}

		return response.getBody();
	}

	private String doAction(String id, String action) throws OperationException {
		return doAction(id, action, null);
	}

	@Override
	public Image get(String id) throws OperationException {
		return _get(PREFIX + "/" + id);
	}

	@Override
	public List<Image> list() throws OperationException {
		//return _list(PREFIX + "/detail");
		return _list(PREFIX);
	}

	@Override
	public void delete(String id) throws OperationException {
		_delete(PREFIX + "/" + id);

	}

	@Override
	public void reactivate(String id) throws OperationException {
		doAction(id, "reactivate");
	}

	@Override
	public void deactivate(String id) throws OperationException {
		doAction(id, "deactivate");
	}

	@Override
	public Image update(Image image) throws OperationException {
		Objects.requireNonNull(image);
		Objects.requireNonNull(image.getId());
		JSONArray jsonArray = new JSONArray();

		if (image.getName() != null) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("op", "replace");
			jsonObject.put("path", "/name");
			jsonObject.put("value", image.getName());
			jsonArray.put(jsonObject);
		}
		if (image.getMinRam() >=0) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("op", "replace");
			jsonObject.put("path", "/min_ram");
			jsonObject.put("value", image.getMinRam());
			jsonArray.put(jsonObject);
		}
		if (image.getMinDisk() >=0) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("op", "replace");
			jsonObject.put("path", "/min_disk");
			jsonObject.put("value", image.getMinDisk());
			jsonArray.put(jsonObject);
		}
		if (image.getMinDisk() >=0) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("op", "replace");
			jsonObject.put("path", "/min_disk");
			jsonObject.put("value", image.getMinDisk());
			jsonArray.put(jsonObject);
		}
		if (image.getProtectedFlag() != null) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("op", "replace");
			jsonObject.put("path", "/protected");
			jsonObject.put("value", image.getProtectedFlag());
			jsonArray.put(jsonObject);
		}
		if (image.getVisibility() != null) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("op", "replace");
			jsonObject.put("path", "/visibility");
			jsonObject.put("value", image.getVisibility());
			jsonArray.put(jsonObject);
		}

		Header header = new HTTPHeader();
		header.put("Content-Type", "application/openstack-images-v2.1-json-patch");
		return _update(header, PREFIX + "/" + image.getId(), jsonArray);
	}

}
