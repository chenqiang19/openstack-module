package com.ict.cloud.image.model;

import java.util.List;

import com.ict.cloud.common.annotation.Entity;
import com.ict.cloud.common.annotation.Property;
import com.ict.cloud.common.model.AbstractEntity;
import com.ict.cloud.common.model.Link;
import org.json.JSONObject;

@Entity("image")
public class Image extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	@Property
	private String status;
	@Property
	private String updated;
	@Property
	private List<Link> links;
	@Property
	private String created;
	@Property("min_disk")
	private int minDisk;
	@Property
	private int progress;
	@Property("min_ram")
	private int minRam;
	@Property
	private JSONObject metadata;
	@Property
	private Long size;
	@Property("os_admin_user")
	private String osAdminUser;
	@Property("disk_format")
	private String diskFormat;
	@Property
	private String visibility;
	@Property
	private String stores;
	@Property
	private Boolean protectedFlag;

	public Image() {
		super();
	}

	public Image(JSONObject entity) {
		super(entity);
		if (entity.has("os_admin_user")) {
			this.osAdminUser = entity.getString("os_admin_user");
		}
		if (entity.has("disk_format")) {
			this.diskFormat = entity.getString("disk_format");
		}
		if (entity.has("visibility")) {
			this.visibility = entity.getString("visibility");
		}
		if (entity.has("size")) {
			this.size = entity.getLong("size");
		}
		if (entity.has("stores")) {
			this.stores = entity.getString("stores");
		}
		if (entity.has("protected")) {
			this.protectedFlag = entity.getBoolean("protected");
		}
		if (entity.has("created_at")) {
			this.created = entity.getString("created_at");
		}
		if (entity.has("updated_at")) {
			this.updated = entity.getString("updated_at");
		}
		if (entity.has("min_ram")) {
			this.minRam = entity.getInt("min_ram");
		}
		if (entity.has("min_disk")) {
			this.minDisk = entity.getInt("min_disk");
		}
	}

	public Image(Object obj) { super(obj); }

	public Image(String s) { super(s); }

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

	public List<Link> getLinks() {
		return links;
	}

	public String getCreated() {
		return created;
	}

	public int getMinDisk() {
		return minDisk;
	}

	public void setMinDisk(int minDisk) { this.minDisk = minDisk; }

	public int getProgress() {
		return progress;
	}

	public int getMinRam() {
		return minRam;
	}

	public void setMinRam(int minRam) { this.minRam = minRam; }

	public JSONObject getMetadata() {
		return metadata;
	}

	public Long getSize() {
		return size;
	}

	public String getOsAdminUser() { return this.osAdminUser; }

	public String getDiskFormat() { return this.diskFormat; }

	public String getVisibility() { return this.visibility; }

	public void setVisibility(String visibility) { this.visibility = visibility; }

	public String getStores() { return this.stores; }

	public Boolean getProtectedFlag() { return this.protectedFlag; }

	public void setProtectedFlag(Boolean protectedFlag) { this.protectedFlag = protectedFlag; }
}
