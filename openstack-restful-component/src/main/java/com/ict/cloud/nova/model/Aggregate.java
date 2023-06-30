package com.ict.cloud.nova.model;

import com.ict.cloud.common.annotation.Entity;
import com.ict.cloud.common.annotation.Property;
import com.ict.cloud.common.model.AbstractEntity;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Entity("aggregate")
public class Aggregate extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1897765793153803288L;
	@Property("availability_zone")
	private String availabilityZone;
	@Property("created_at")
	private String createdAt;
	@Property
	private boolean deleted;
	@Property("updated_at")
	private String updatedAt;
	@Property("delete_at")
	private String deleteAt;
	@Property
	private JSONObject metadata;
	@Property
	private List<String> hosts;
	public Aggregate(JSONObject json) {
		super(json);
		if (json.has("id")) {
			this.id = String.valueOf(json.getInt("id"));
		}
	}
	public Aggregate(JSONObject header, JSONObject body) {
		JSONObject aggregate = body.getJSONObject("aggregate");
		if (aggregate.has("id")) {
			this.id = String.valueOf(aggregate.getInt("id"));
		}
		if (aggregate.has("name")) {
			this.name = aggregate.getString("name");
		}
		if (aggregate.has("availability_zone")) {
			this.availabilityZone = aggregate.getString("availability_zone");
		}
		if (aggregate.has("metadata")) {
			this.metadata = aggregate.getJSONObject("metadata");
		}
		if (aggregate.has("hosts")) {
			JSONArray array = aggregate.getJSONArray("hosts");
			hosts = new ArrayList<>();
			for (int i=0; i<array.length(); i++) {
				hosts.add((String) array.get(i));
			}
		}
	}


	@Override
	public boolean isValid() {
		return true;
	}
	public String getAvailabilityZone() {
		return this.availabilityZone;
	}
	public void setAvailabilityZone(String availabilityZone) {
		this.availabilityZone = availabilityZone;
	}
	public JSONObject getMetadata() {
		return this.metadata;
	}
	public void setMetadata(JSONObject metadata) {
		this.metadata = metadata;
	}
	public String getCreatedAt() {
		return this.createdAt;
	}
	public boolean isDeleted() {
		return this.deleted;
	}
	public String getUpdatedAt() {
		return this.updatedAt;
	}
	public String getDeleteAt() {
		return this.deleteAt;
	}
	public List<String> getHosts() { return this.hosts; }
}
