package com.ict.cloud.baremetal.model;

import com.ict.cloud.common.annotation.Entity;
import com.ict.cloud.common.annotation.Property;
import com.ict.cloud.common.model.AbstractEntity;
import org.json.JSONObject;

@Entity("node")
public class Node extends AbstractEntity {
    @Property("OS-EXT-STS:power_state")
    private String power_state;
    @Property
    private String uuid;
    @Property
    private String name;
    @Property
    private String driver;
    @Property
    private String power_interface;
    @Property
    private String resource_class;
    @Property
    private String ipmi_username;
    @Property
    private String ipmi_password;
    @Property
    private boolean maintenance;
    @Property
    private boolean boot;
    @Property
    private boolean console;
    @Property
    private boolean deploy;
    @Property
    private boolean inspect;
    @Property
    private boolean management;
    @Property
    private boolean network;
    @Property
    private boolean power;
    @Property
    private boolean raid;
    @Property
    private boolean rescue;
    @Property
    private boolean storage;
    @Property
    private String instance_uuid;
    @Property
    private String provision_state;
    @Property
    private Properties properties;
    @Property
    private String machine_flag;
    private int count = 1;
    @Property("min_count")
    private int minCount = 1;
    @Property("max_count")
    private int maxCount = 1;
    @Property("instance_info")
    private InstanceInfo instanceInfo;
    public Node() {
        super();
    }
    public Node(JSONObject body) {
        super(body);
        if (body.has("driver")) {
            driver = body.getString("driver");
        }

        if (body.has("name")) {
            name = body.getString("name");
        }
        if (body.has("resource_class")) {
            resource_class = body.getString("resource_class");
        }
        if (body.has("power_interface")) {
            power_interface = body.getString("power_interface");
        }

        if(body.has("driver_info")) {
            JSONObject driver_info = body.getJSONObject("driver_info");
            ipmi_username = driver_info.getString("ipmi_username");
            ipmi_password = driver_info.getString("ipmi_password");
        }

        if(body.has("uuid")) {
            uuid = body.getString("uuid");
        }

        if(body.has("properties")){
            JSONObject propertiesInfo = body.getJSONObject("properties");
            this.properties = new Properties();
            this.properties.setMemoryMb(propertiesInfo.getInt("memory_mb"));
            this.properties.setCpuArch(propertiesInfo.getString("cpu_arch"));
            this.properties.setLocalGb(propertiesInfo.getInt("local_gb"));
            this.properties.setCpuNum(propertiesInfo.getInt("cpus"));
            this.properties.setBrand(propertiesInfo.getString("brand"));
            if(propertiesInfo.has("gpus")){
                this.properties.setGpuFlag(propertiesInfo.getInt("gpus"));
            }else{
                this.properties.setGpuFlag(null);
            }
        }

        if(body.has("instance_info")){
            JSONObject instanceInfos = body.getJSONObject("instance_info");
            this.instanceInfo = new InstanceInfo();
            if(instanceInfos.has("display_name")) {
                this.instanceInfo.setDisplayName(instanceInfos.getString("display_name"));
            }
            if(instanceInfos.has("image_source")){
                this.instanceInfo.setImageSource(instanceInfos.getString("image_source"));
            }
            if(instanceInfos.has("nova_host_id")) {
                this.instanceInfo.setNovaHostId(instanceInfos.getString("nova_host_id"));
            }
            if(instanceInfos.has("memory_mb")) {
                this.instanceInfo.setMemoryMb(instanceInfos.getInt("memory_mb"));
            }
            if(instanceInfos.has("local_gb")) {
                this.instanceInfo.setLocalGb(instanceInfos.getInt("local_gb"));
            }
            if(instanceInfos.has("vcpus")) {
                this.instanceInfo.setVcpus(instanceInfos.getInt("vcpus"));
            }
            if(instanceInfos.has("swap_mb")) {
                this.instanceInfo.setVcpus(instanceInfos.getInt("vcpus"));
            }
            if(instanceInfos.has("root_gb")) {
                this.instanceInfo.setSwapMB(instanceInfos.getInt("swap_mb"));
            }
        }
        if(body.has("power_state")) {
            if(body.get("power_state").equals(null)){
                this.power_state = null;
            }else {
                this.power_state = body.getString("power_state");
            }
        }
        if(body.has("resource_class")){
            this.machine_flag = body.getString("resource_class");
        }
        if(body.has("provision_state") && body.getString("provision_state")!=null){
            this.provision_state = body.getString("provision_state");
        }
    }

    public Node(Object obj) {
        this(new JSONObject(obj.toString()));
    }
    public Node(String s) {
        this(new JSONObject(s));
    }

    public Node setCount(int count) {
        this.count = count;
        this.minCount = 1;
        this.maxCount = count;
        return this;
    }
    public String getMachineFlag() { return this.machine_flag; }
    public void setMachineFlag(String machine_flag) { this.machine_flag = machine_flag; }

    public String getUuid() { return this.uuid; }
    public void setUuid(String uuid) { this.uuid=uuid; }

    public String getName() { return this.name; }
    public void setName(String name) { this.name=name; }

    public String getDriver() { return this.driver; }
    public void setDriver(String driver) { this.driver=driver; }

    public String getPowerState() { return this.power_state; }
    public void setPowerState(String state) { this.power_state=state; }

    public String getPowerInterface() { return this.power_interface; }
    public void setPowerInterface(String power_interface) { this.power_interface=power_interface; }

    public String getResourceClass() { return this.resource_class; }
    public void setResourceClass(String resource_class) { this.resource_class=resource_class; }

    public String getIpmiUsername() { return this.ipmi_username; }
    public void setIpmiUsername(String ipmi_username) { this.ipmi_username=ipmi_username; }

    public String getIpmiPassword() { return this.ipmi_password; }
    public void setIpmiPassword(String ipmi_password) { this.ipmi_password=ipmi_password; }

    public boolean getMaintenance() { return this.maintenance; }
    public void setMaintenance(boolean maintenance) { this.maintenance=maintenance; }

    public boolean getBoot() { return this.boot; }
    public void setBoot(boolean boot) { this.boot=boot; }

    public boolean getConsole() { return this.console; }
    public void setConsole(boolean console) { this.console=console; }

    public boolean getDeploy() { return this.deploy; }
    public void setDeploy(boolean deploy) { this.deploy=deploy; }

    public boolean getInspect() { return this.inspect; }
    public void setInspect(boolean inspect) { this.inspect=inspect; }

    public boolean getManagement() { return this.management; }
    public void setManagement(boolean management) { this.management=management; }

    public boolean getNetwork() { return this.network; }
    public void setNetwork(boolean network) { this.network=network; }

    public boolean getPower() { return this.power; }
    public void setPower(boolean power) { this.power=power; }

    public boolean getRaid() { return this.raid; }
    public void setRaid(boolean raid) { this.raid=raid; }

    public boolean getRescue() { return this.rescue; }
    public void setRescue(boolean rescue) { this.rescue=rescue; }

    public boolean getStorage() { return this.storage; }
    public void setStorage(boolean storage) { this.storage=storage; }

    public String getProvision_state() { return this.provision_state; }
    public void setProvision_state(String provision_state) { this.provision_state=provision_state; }

    public String getInstance_uuid() { return this.instance_uuid; }
    public void setInstance_uuid(String instance_uuid) { this.instance_uuid=instance_uuid; }

    public Properties getProperties() { return this.properties; }
    public void setProperties(Properties properties) { this.properties=properties; }

    public boolean isValid() {
        if ((this.minCount < 1) || (this.maxCount < 1)
                || (this.minCount > this.maxCount))
            return false;
        if ((this.name == null) || (this.name.length() < 1))
            return false;
        return true;
    }

    public static class InstanceInfo extends AbstractEntity {
        private static final long serialVersionUID = 1L;
        private Integer root_gb;
        private Integer memory_mb;
        private Integer swap_mb;
        private Integer local_gb;
        private Integer vcpus;
        private String display_name;
        private String image_source;
        private String nova_host_id;
        public InstanceInfo() {}
        public InstanceInfo(JSONObject entity) {
            super(entity);
        }
        public InstanceInfo(Object obj) {
            super(obj);
        }
        @Override
        public boolean isValid() {
            return false;
        }
        @Override
        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }

        public Integer getMemoryMb() { return this.memory_mb; }
        public void setMemoryMb(Integer memory_mb) {
            this.memory_mb=memory_mb;
        }

        public Integer getLocalGb() { return  this.local_gb; }
        public void setLocalGb(Integer local_gb) { this.local_gb=local_gb; }

        public Integer getVcpus() { return this.vcpus; }
        public void setVcpus(Integer vcpus) { this.vcpus= vcpus; }

        public Integer getRootGB() { return this.root_gb; }
        public void setRootGB(Integer root_gb) { this.root_gb = root_gb; }

        public Integer getSwapMB() { return this.swap_mb; }
        public void setSwapMB(Integer swap_mb) { this.swap_mb = swap_mb; }

        public String getDisplayName() { return this.display_name; }
        public void setDisplayName(String display_name) { this.display_name = display_name; }

        public String getImageSource() { return this.image_source; }
        public void setImageSource(String image_source) { this.image_source = image_source; }

        public String getNovaHostId() { return this.nova_host_id; }
        public void setNovaHostId(String nova_host_id) { this.nova_host_id=nova_host_id;}

        @Override
        public String toString() {
            JSONObject json = new JSONObject();
            json.put("memory_mb", this.memory_mb);
            json.put("vcpus", this.vcpus);
            json.put("local_gb", this.local_gb);
            json.put("root_gb", this.root_gb);
            json.put("swap_mb", this.swap_mb);
            json.put("display_name", this.display_name);
            json.put("image_source", this.image_source);
            json.put("nova_host_id", this.nova_host_id);
            return json.toString();
        }
    }

    public static class Properties extends AbstractEntity {
        private static final long serialVersionUID = 1L;
        private Integer memory_mb;
        private String cpu_arch;
        private Integer local_gb;
        private Integer cpu_num;
        private Integer gpu_flag;
        private String brand;
        public Properties() {}
        public Properties(Integer memory_mb,String cpu_arch, Integer local_gb, Integer cpu_num, Integer gpu_flag, String brand) {
            this.memory_mb = memory_mb;
            this.cpu_arch = cpu_arch;
            this.local_gb = local_gb;
            this.cpu_num = cpu_num;
            this.gpu_flag = gpu_flag;
            this.brand = brand;
        }
        public Properties(JSONObject entity) {
            super(entity);
        }
        public Properties(Object obj) {
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

        public Integer getMemoryMb() { return this.memory_mb; }
        public void setMemoryMb(Integer memory_mb) {
            this.memory_mb=memory_mb;
        }

        public Integer getLocalGb() { return  this.local_gb; }
        public void setLocalGb(Integer local_gb) { this.local_gb=local_gb; }

        public Integer getCpuNum() { return this.cpu_num; }
        public void setCpuNum(Integer cpu_num) { this.cpu_num= cpu_num; }

        public String getCpuArch() { return this.cpu_arch; }
        public void setCpuArch(String cpu_arch) { this.cpu_arch=cpu_arch; }

        public Integer getGpuFlag() { return this.gpu_flag; }
        public void setGpuFlag(Integer gpu_flag) { this.gpu_flag = gpu_flag; }

        public String getBrand() { return this.brand; }
        public void setBrand(String brand) { this.brand = brand; }

        @Override
        public String toString() {
            JSONObject json = new JSONObject();
            json.put("memory_mb", this.memory_mb);
            json.put("cpu_arch", this.cpu_arch);
            json.put("local_gb", this.local_gb);
            json.put("cpus", this.cpu_num);
            json.put("gpu_flag", this.gpu_flag);
            json.put("brand", this.brand);
            return json.toString();
        }
    }
}
