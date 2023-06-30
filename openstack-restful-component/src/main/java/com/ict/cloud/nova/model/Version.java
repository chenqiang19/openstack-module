package com.ict.cloud.nova.model;

import java.util.Collections;
import java.util.List;

import com.ict.cloud.common.annotation.Entity;
import com.ict.cloud.common.annotation.Property;
import com.ict.cloud.common.model.AbstractEntity;
import com.ict.cloud.common.model.Link;
import org.json.JSONObject;

@Entity("Version")
public class Version extends AbstractEntity {
	/**
	 * 
	 */
	private List<Link> links;
	private static final long serialVersionUID = 1L;
	@Property
	private String status;
	@Property
	private String updated;
	public Version(JSONObject version) {
		super(version);
	}
	public Version(Object obj) {
		this(new JSONObject(obj.toString()));
	}
	public Version(String s) {
		this(new JSONObject(s));
	}
	@Override
	public boolean isValid() {
		return true;
	}
	public String getStatus() {
		return status;
	}
	public String getUpdated() {
		return updated;
	}
	public List<Link> getlinks() {
		return Collections.unmodifiableList(links);
	}
}
