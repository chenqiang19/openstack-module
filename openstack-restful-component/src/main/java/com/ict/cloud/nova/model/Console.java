package com.ict.cloud.nova.model;

import com.ict.cloud.common.annotation.Entity;
import com.ict.cloud.common.annotation.Property;
import com.ict.cloud.common.model.AbstractEntity;
import org.json.JSONObject;

@Entity("console")
public class Console extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -399886903935656981L;
	@Property
	private String url;
	@Property
	private String type;
	public Console(JSONObject json) {
		super(json);
	}
	public Console(Object obj) {
		this(new JSONObject(obj.toString()));
	}
	public Console(JSONObject header, JSONObject body) {
		JSONObject volume = body.getJSONObject("console");
		if(volume.has("type")) {
			this.type = volume.getString("type");
		}
		if(volume.has("url")) {
			this.url = volume.getString("url");
		}
	}
	@Override
	public boolean isValid() {
		return url != null;
	}
	public String getUrl() {
		return url;
	}
	public String getType() {
		return type;
	}
	
}
