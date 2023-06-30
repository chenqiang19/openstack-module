package com.ict.cloud.nova.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ict.cloud.common.annotation.Entity;
import com.ict.cloud.common.annotation.Property;
import com.ict.cloud.common.model.AbstractEntity;
import org.json.JSONArray;
import org.json.JSONObject;

@Entity("availabilityZoneInfo")
public class AvailableZone extends AbstractEntity {
	/**
	 * 
	 */
	@Property("hosts")
	private List<String> hosts = new ArrayList<>();
	@Property
	private boolean available;
	private static final long serialVersionUID = 1L;
	@Override
	public boolean isValid() {
		return true;
	}
	public AvailableZone(JSONObject zone) {
		this.available = zone.getJSONObject("zoneState").getBoolean("available");
		this.name = zone.getString("zoneName");
		JSONObject host = zone.optJSONObject("hosts");
		if (host != null) {
			for (Object key : host.keySet()) {
				hosts.add((String)key);
			}
		}
		this.id = "Zone@" + name;
	}
	public List<String> getHosts() {
		return Collections.unmodifiableList(hosts);
	}
	public boolean isAvailable() {
		return available;
	}
	

}
