package com.ict.cloud.nova.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ict.cloud.common.annotation.AnnotationProcessor;
import com.ict.cloud.common.annotation.Entity;
import com.ict.cloud.common.annotation.Property;
import com.ict.cloud.common.model.AbstractEntity;
import com.ict.cloud.common.model.Link;
import com.ict.cloud.neutron.model.SecurityGroup;
import com.ict.cloud.tools.Base64;
import com.ict.cloud.tools.JSONConverter;
import org.json.JSONArray;
import org.json.JSONObject;

@Entity("server")
public class Server extends AbstractEntity {
	private static final long serialVersionUID = 777913975630156176L;
	@Property("status")
	private String status;
	@Property
	private String updated;
	@Property
	private String hostId;
	@Property("OS-EXT-SRV-ATTR:host")
	private String host;
	@Property
	private List<Link> links;
	@Property("key_name")
	private String keyName;
	@Property("OS-EXT-STS:task_state")
	private String taskState;
	@Property("vm_state")
	private String vmState;
	@Property("OS-EXT-SRV-ATTR:instance_name")
	private String instanceName;
	@Property("OS-SRV-USG:launched_at")
	private String launchedAt;
	@Property("OS-EXT-SRV-ATTR:hypervisor_hostname")
	private String hypervisorHostname;
	@Property("networks")
	private List<Network> networks;
	@Property("security_groups")
	private List<Group> securityGroups;
	@Property("OS-SRV-USG:terminated_at")
	private String terminatedAt;
	@Property("block_device_mapping_v2")
	private List<SnapshotInfo> snapshots;
	@Property("availability_zone")
	private String availabilityZone;
	@Property("user_id")
	private String userId;
	@Property
	private String created;
	@Property("tenant_id")
	private String tenantId;
	@Property("OS-DCF:diskConfig")
	private String diskConfig;
	@Property("os-extended-volumes:volumes_attached")
	private List<String> volumesAttached;
	@Property
	private String accessIPv4;
	@Property
	private String accessIPv6;
	@Property("OS-EXT-STS:power_state")
	private Integer powerState;
	@Property("config_drive")
	private Boolean configDrive;
	//@Property
	//private String metadata;
	@Property
	private Metadata metadata;
	@Property
	private List<Address> addresses;
	@Property
	private String imageRef;
	@Property
	private String flavorRef;
	@Property
	private String adminPass;
	private int count = 1;
	@Property("min_count")
	private int minCount = 1;
	@Property("max_count")
	private int maxCount = 1;
	@Property("user_data")
	private String userData;
	@Property("instance_uuid")
	private String instance_uuid;
	@Property
	private List<InjectFile> personality;
	public Server() {
		super();
	}
	public Server(JSONObject instance) {
		super(instance);
		if (instance.has("image")) {
			this.imageRef = instance.optString("image", null);
			if(this.imageRef==null){
				JSONObject imageTemp = instance.optJSONObject("image");
				if(imageTemp.has("id")) {
					imageRef = imageTemp.getString("id");
				}
			}
		}
		if (instance.has("flavor")) {
			flavorRef = instance.getJSONObject("flavor").getString("id");
		}
		String addresses = AnnotationProcessor.getFieldName(getClass(), "addresses");
		assert(addresses != null);
		if (!instance.has(addresses))
			return;
		if (this.addresses == null)
			this.addresses = new ArrayList<>();
		JSONObject _addresses = instance.getJSONObject("addresses");
		for (Object netName : _addresses.keySet()) {
			JSONArray values = _addresses.getJSONArray((String)netName);
			if (values == null)
				continue;
			for (int i = 0; i < values.length(); i++) {
				Address addr = new Address(values.optJSONObject(i));
				this.addresses.add(addr);
			}
		}
		if(instance.has("status")){
			status = instance.getString("status");
		}
		if(instance.has("OS-EXT-STS:power_state")){
			//powerState = instance.getInt("power_state");
			powerState = instance.getInt("OS-EXT-STS:power_state");
		}
		if(instance.has("OS-EXT-STS:vm_state")){
			vmState = instance.getString("OS-EXT-STS:vm_state");
		}
		if(instance.has("OS-EXT-SRV-ATTR:hypervisor_hostname")) {
			hypervisorHostname = instance.getString("OS-EXT-SRV-ATTR:hypervisor_hostname");
		}if(instance.has("OS-EXT-STS:task_state")){
			Object value = instance.get("OS-EXT-STS:task_state");
			if(value.toString().equals("null")){
				taskState = "null";
			}else{
				taskState = instance.getString("OS-EXT-STS:task_state");
			}
		}
		if(instance.has("hostId")){
			hostId = instance.getString("hostId");
		}

		if(instance.has("instance_uuid")){
			instance_uuid = instance.getString("instance_uuid");
		}
	}

	public Server(JSONObject header, JSONObject body) {
		super(body);
		if (body.has("image")) {
			imageRef = body.getJSONObject("image").getString("id");
		}
		if (body.has("flavor")) {
			flavorRef = body.getJSONObject("flavor").getString("id");
		}
		String addresses = AnnotationProcessor.getFieldName(getClass(), "addresses");
		assert(addresses != null);
		if (!body.has(addresses))
			return;
		if (this.addresses == null)
			this.addresses = new ArrayList<>();
		JSONObject _addresses = body.getJSONObject("addresses");
		for (Object netName : _addresses.keySet()) {
			JSONArray values = _addresses.getJSONArray((String)netName);
			if (values == null)
				continue;
			for (int i = 0; i < values.length(); i++) {
				Address addr = new Address(values.optJSONObject(i));
				this.addresses.add(addr);
			}
		}
		if(body.has("status")){
			status = body.getString("status");
		}
		if(body.has("OS-EXT-STS:power_state")){
			powerState = body.getInt("OS-EXT-STS:power_state");
		}

	}

	public Server(Object obj) {
		this(new JSONObject(obj.toString()));
	}
	public Server(String s) {
		this(new JSONObject(s));
	}

	public Server setCount(int count) {
		this.count = count;
		this.minCount = 1;
		this.maxCount = count;
		return this;
	}
	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	public void setMetadata(Metadata metadata) {
		this.metadata=metadata;
	}

	public List<Group> getSecurityGroups() {
		if (securityGroups == null)
			securityGroups = new ArrayList<>();
		return Collections.unmodifiableList(securityGroups);
		//return securityGroups;
	}

	public void setSnapshots(List<SnapshotInfo> snapshots) {
		if(this.snapshots == null) {
			this.snapshots = new ArrayList<>();
		}
		this.snapshots.addAll(snapshots);
	}

	public void setNetworks(List<Network> networks) {
		if(this.networks == null) {
			this.networks = new ArrayList<>();
		}
		this.networks.addAll(networks);
	}

	public void setSecurityGroups(List<Group> securityGroups) {
		if (this.securityGroups == null)
			this.securityGroups = new ArrayList<>();
		this.securityGroups.addAll(securityGroups);
	}
	public void appendSecurityGroupsWithName(String name) {
		if (this.securityGroups == null)
			securityGroups = new ArrayList<>();
		securityGroups.add(new Group(name));
	}
	public void appendSecurityGroup(SecurityGroup group) {
		if (this.securityGroups == null)
			securityGroups = new ArrayList<>();
		securityGroups.add(new Group(group.getName()));
	}
	public String getDiskConfig() {
		return diskConfig;
	}

	public void setDiskConfig(String diskConfig) {
		this.diskConfig = diskConfig;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public String getInstanceUUID() { return  this.instance_uuid; }

	public void setAddresses(List<Address> addresses) {
		if (this.addresses == null)
			this.addresses = new ArrayList<>();
		this.addresses.addAll(addresses);
	}

	public String getImageRef() {
		return imageRef;
	}

	public void setImageRef(String imageRef) {
		this.imageRef = imageRef;
	}

	public String getFlavorRef() {
		return flavorRef;
	}

	public void setFlavorRef(String flavorRef) {
		this.flavorRef = flavorRef;
	}

	public List<InjectFile> getPersonality() {
		if (this.personality == null)
			this.personality = new ArrayList<>();
		return Collections.unmodifiableList(this.personality);
	}

	public void setPersonality(List<InjectFile> personality) {
		if (this.personality == null)
			this.personality = new ArrayList<>();
		this.personality.addAll(personality);
	}

	public String getStatus() {
		return status;
	}

	//public Integer getPowerStatue() { return powerState; };
	public Integer getPowerStatus() { return powerState; }

	public String getUpdated() {
		return updated;
	}

	public String getHostId() {
		return hostId;
	}

	public String getHost() {
		return host;
	}

	public List<Link> getLinks() {
		if (links == null)
			links = new ArrayList<>();
		return Collections.unmodifiableList(links);
	}

	public String getTaskState() {
		return taskState;
	}

	public String getVmState() {
		return vmState;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public String getLaunchedAt() {
		return launchedAt;
	}

	public String getHypervisorHostname() {
		return hypervisorHostname;
	}
	public String setHypervisorHostname() { return hypervisorHostname; }
	public String getTerminatedAt() {
		return terminatedAt;
	}

	public String getAvailabilityZone() {
		return availabilityZone;
	}
	public void setAvailabilityZone(String zone) {
		this.availabilityZone = zone;
	}

	public String getUserId() {
		return userId;
	}

	public String getCreated() {
		return created;
	}

	public String getTenantId() {
		return tenantId;
	}

	public List<String> getVolumesAttached() {
		if (this.volumesAttached == null)
			this.volumesAttached = new ArrayList<>();
		return Collections.unmodifiableList(this.volumesAttached);
	}

	public String getAccessIPv4() {
		return accessIPv4;
	}

	public String getAccessIPv6() {
		return accessIPv6;
	}

	public int getMinCount() {
		return minCount;
	}

	public void setMinCount(int minCount) {
		this.minCount = minCount;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	public Integer getPowerState() { return powerState; }

	public Boolean getConfigDrive() {
		return configDrive;
	}
	public void setConfigDrive(Boolean configDrive) { this.configDrive=configDrive; }
	public Metadata getMetadata() {
		return metadata;
	}

	public int getCount() {
		return count;
	}
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}

	public void setUserData(String userData) {
		this.userData = userData;
	}
	private String readFile(File file) {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				sb.append(line);
				sb.append('\n');
			}
		} catch (Exception localException) {
			if (in != null)
				try {
					in.close();
				} catch (IOException localIOException) {
				}
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException localIOException1) {
				}
		}
		return sb.toString();
	}

	public Server addInjectFile(String content, String targetPath) {
		if (this.personality == null)
			this.personality = new ArrayList<>();
		InjectFile file = new InjectFile(Base64.toBase64(content),
				targetPath);
		this.personality.add(file);
		return this;
	}

	public Server addInjectFile(File file, String targetPath) {
		String content = readFile(file);
		addInjectFile(content, targetPath);
		return this;
	}

	public String getUserData() {
		return this.userData;
	}

	@Override
	public boolean isValid() {
		if ((this.minCount < 1) || (this.maxCount < 1)
				|| (this.minCount > this.maxCount))
			return false;
		if ((this.name == null) || (this.name.length() < 1))
			return false;
		return true;
	}
	public static class Diagnostics {
		private Map<String, Integer> diagnostics;

		public Diagnostics() {
			this.diagnostics = new HashMap<>();
		}

		public Diagnostics(JSONObject json) {
			this.diagnostics = JSONConverter.jsonToMap(json);
		}

		public Diagnostics(Object obj) {
			this(new JSONObject(obj.toString()));
		}

		public Map<String, Integer> getDiagnostics() {
			return this.diagnostics;
		}

		@Override
		public String toString() {
			return JSONConverter.mapToJSON(this.diagnostics).toString();
		}

		public String toString(int i) {
			return JSONConverter.mapToJSON(this.diagnostics).toString(i);
		}

		public int get(String what) {
			return ((Integer) this.diagnostics.get(what)).intValue();
		}

		public Set<String> keySet() {
			return this.diagnostics.keySet();
		}
	}

	public static class Group extends AbstractEntity {
		private static final long serialVersionUID = -5598050879848859356L;

		public Group() {
		}
		public Group(String name) {
			this.name = name;
		}
		public Group(JSONObject entity) {
			super(entity);
		}

		public Group(Object obj) {
			super(obj);
		}
		@Override
		public boolean isValid() {
			return this.name != null;
		}

		@Override
		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public String toString() {
			JSONObject json = new JSONObject();
			json.put("name", this.name);
			return json.toString();
		}
	}

	public static class Network extends AbstractEntity {
		private static final long serialVersionUID = 1L;
		private String uuid;
		public Network() {}
		public Network(String uuid) {
			this.uuid = uuid;
		}
		public Network(JSONObject entity) {
			super(entity);
		}

		public Network(Object obj) {
			super(obj);
		}
		@Override
		public boolean isValid() {
			return this.name != null;
		}

		@Override
		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String getName() {
			return this.name;
		}

		public String getUuid() { return this.uuid; }
		public void setUuid(String uuid) {
			this.uuid=uuid;
		}
		@Override
		public String toString() {
			JSONObject json = new JSONObject();
			json.put("uuid", this.uuid);
			return json.toString();
		}
	}

	public static class AddFloatingIp extends AbstractEntity {
		private static final long serialVersionUID = 1L;
		private String address;
		private String fixed_address;
		public AddFloatingIp() {}
		public AddFloatingIp(String address) {
			this.address = address;
		}
		public AddFloatingIp(JSONObject entity) {
			super(entity);
		}
		public AddFloatingIp(Object obj) {
			super(obj);
		}
		@Override
		public boolean isValid() {
			return this.name != null;
		}

		@Override
		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String getName() {
			return this.name;
		}

		public String getAddress() { return this.address; }
		public void setAddress(String address) {
			this.address=address;
		}

		public String getFixedAddress() { return this.fixed_address; }
		public void setFixed_address(String fixed_address) { this.fixed_address = fixed_address; }
		@Override
		public String toString() {
			JSONObject json = new JSONObject();
			json.put("address", this.address);
			json.put("fixed_address", this.fixed_address);
			return json.toString();
		}
	}

	public static class Metadata extends AbstractEntity {
		private static final long serialVersionUID = 1L;
		private String admin_pass;
		public Metadata() {}
		public Metadata(String adminPass) {
			this.admin_pass = adminPass;
		}
		public Metadata(JSONObject entity) {
			super(entity);
		}
		public Metadata(Object obj) {
			super(obj);
		}
		@Override
		public boolean isValid() {
			return this.name != null;
		}

		@Override
		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String getName() {
			return this.name;
		}

		public String getAdminPass() { return this.admin_pass; }
		public void setAdminPass(String adminPass) {
			this.admin_pass=adminPass;
		}
		@Override
		public String toString() {
			JSONObject json = new JSONObject();
			json.put("admin_pass", this.admin_pass);
			return json.toString();
		}
	}

	public static class SnapshotInfo extends AbstractEntity {
		private static final long serialVersionUID = 1L;
		private String uuid;
		private Integer bootIndex;
		private String volumeSize;
		private String sourceType;
		private String destinationType;
		private Boolean deleteOnTermination;
		private String deviceType;
		private String diskBus;
		private Boolean noDevice;
		public SnapshotInfo() {}
		public SnapshotInfo(String uuid) {
			this.uuid = uuid;
		}
		public SnapshotInfo(JSONObject entity) {
			super(entity);
		}
		public SnapshotInfo(Object obj) {
			super(obj);
		}

		@Override
		public boolean isValid() {
			return this.name != null;
		}

		@Override
		public void setName(String name) { this.name = name; }

		@Override
		public String getName() {
			return this.name;
		}

		public String getUuid() { return this.uuid; }
		public void setUuid(String uuid) {
			this.uuid=uuid;
		}

		public Integer getBootIndex() { return this.bootIndex;}
		public void setBootIndex(Integer bootIndex) { this.bootIndex = bootIndex; }

		public String getVolumeSize() { return this.volumeSize; }
		public void setVolumeSize(String volumeSize) { this.volumeSize=volumeSize; }

		public String getSourceType() { return this.sourceType; }
		public void setSourceType(String sourceType) { this.sourceType = sourceType; }

		public String getDestinationType() { return this.destinationType; }
		public void setDestinationType(String destinationType) { this.destinationType = destinationType; }

		public Boolean getDeleteOnTermination() { return this.deleteOnTermination; }
		public void setDeleteOnTermination(Boolean deleteOnTermination) { this.deleteOnTermination = deleteOnTermination; }

		public String getDeviceType() { return this.deviceType; }
		public void setDeviceType(String deviceType) { this.deviceType = deviceType; }

		public String getDiskBus() { return this.diskBus; }
		public void setDiskBus(String diskBus) { this.diskBus=diskBus; }

		public Boolean getNoDevice() { return this.noDevice; }
		public void setNoDevice(Boolean noDevice) { this.noDevice=noDevice; }

		@Override
		public String toString() {
			JSONObject json = new JSONObject();
			if(this.uuid!=null){
				json.put("uuid", this.uuid);
			}
			json.put("source_type", this.sourceType);
			json.put("destination_type", this.destinationType);
			json.put("boot_index", this.bootIndex);
			json.put("delete_on_termination", this.deleteOnTermination);
			json.put("device_type", this.deviceType);
			json.put("disk_bus", this.diskBus);
			json.put("no_device", this.noDevice);
			if(this.volumeSize!=null){
				json.put("volume_size", this.volumeSize);
			}
			return json.toString();
		}
	}

	@Entity
	private class InjectFile extends AbstractEntity {
		/**
	 * 
	 */
		private static final long serialVersionUID = -6311667628963149394L;
		@Property
		private String path;
		@Property
		private String content;

		@SuppressWarnings("unused")
		public InjectFile() {
		}

		public InjectFile(String content, String target) {
			this.path = target;
			this.content = content;
		}

		@Override
		public String toString() {
			JSONObject json = new JSONObject();
			json.put("path", this.path);
			json.put("contents", this.content);
			return json.toString();
		}
		@Override
		public boolean isValid() {
			return this.path != null;
		}
	}
	@Entity("address")
	public static class Address extends AbstractEntity {
		private static final long serialVersionUID = -3311116474141575179L;
		@Property("OS-EXT-IPS-MAC:mac_addr")
		private String macAddr;
		@Property
		private String addr;
		@Property
		private int version;
		@Property("OS-EXT-IPS:type")
		private String type;

		public Address(JSONObject address) {
			super(address);
			/*
			if (address.has("OS-EXT-IPS-MAC:mac_addr")) {
				this.macAddr = address.optString("OS-EXT-IPS-MAC:mac_addr", null);
			}
			if (address.has("OS-EXT-IPS:type"))
				setType(address.optString("OS-EXT-IPS:type", null));
			 */
		}
		public Address(Object o) {
			super(o);
		}
		public Address(String s) {
			super(s);
		}
		public String getMacAddr() {
			return this.macAddr;
		}
		public String getAddr() {
			return this.addr;
		}

		public void setAddr(String addr) {
			this.addr = addr;
		}

		public int getVersion() {
			return this.version;
		}

		public void setVersion(int version) {
			this.version = version;
		}

		public String getType() {
			return this.type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public void setMacAddr(String macAddr) { this.macAddr = macAddr; }
		@Override
		public boolean isValid() {
			return true;
		}
	}

	@Entity("volumeAttachment")
	public static class VolumeAttachment extends AbstractEntity {
		private static final long serialVersionUID = -3311116474141575179L;
		@Property("volumeId")
		private String volumeId;
		@Property("device")
		private String device;
		@Property("attachment_id")
		private String attachmentId;

		public VolumeAttachment() {
		}
		public VolumeAttachment(JSONObject volume) {
			super(volume);
		}
		public VolumeAttachment(Object obj) {
			JSONObject attachment = new JSONObject(obj.toString());
			if(attachment.has("volumeId")) {
				this.volumeId = attachment.getString("volumeId");
			}
			if(attachment.has("device")) {
				this.device = attachment.getString("device");
			}
			if(attachment.has("attachment_id")) {
				this.attachmentId = attachment.getString("attachment_id");
			}
		}
		public String getVolumeId() {
			return this.volumeId;
		}
		public void setVolumeId(String volumeId) {
			this.volumeId = volumeId;
		}
		public String getDevice() {
			return this.device;
		}
		public void setDevice(String device) { this.device = device; }

		@Override
		public String toString() {
			JSONObject volumeAttach = new JSONObject();
			JSONObject json = new JSONObject();
			json.put("volumeId", this.volumeId);
			json.put("device", this.device);
			volumeAttach.put("volumeAttachment", json);
			return volumeAttach.toString();
		}

		@Override
		public boolean isValid() {
			return true;
		}
	}

	@Entity("interfaceAttachment")
	public static class InterfaceAttachment extends AbstractEntity {
		private static final long serialVersionUID = 1L;
		private String uuid;
		public InterfaceAttachment() {}
		public InterfaceAttachment(String uuid) {
			this.uuid = uuid;
		}
		public InterfaceAttachment(JSONObject entity) {
			super(entity);
		}

		public InterfaceAttachment(Object obj) {
			super(obj);
		}
		@Override
		public boolean isValid() {
			return this.name != null;
		}

		@Override
		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String getName() {
			return this.name;
		}

		public String getUuid() { return this.uuid; }
		public void setUuid(String uuid) {
			this.uuid=uuid;
		}
		@Override
		public String toString() {
			JSONObject json = new JSONObject();
			json.put("uuid", this.uuid);
			return json.toString();
		}
	}
}
