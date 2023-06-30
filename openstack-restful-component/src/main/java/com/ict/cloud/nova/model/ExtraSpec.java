package com.ict.cloud.nova.model;

import com.ict.cloud.common.annotation.Entity;
import com.ict.cloud.common.annotation.Property;
import com.ict.cloud.common.model.AbstractEntity;
import org.json.JSONObject;

@Entity("extra_specs")
public class ExtraSpec extends AbstractEntity {
    @Property
    private String capabilitiesBootOption; //裸金属-使用本地磁盘
    @Property
    private String capabilitiesBootMode;  //裸金属-启动模式UEFI
    @Property
    private String resourcesClassEfi;  //裸金属-使用EFI模式
    @Property
    private String resourcesMemory;
    @Property
    private String extraSpecsBrand;  //裸金属-机器类型
    @Property
    private String resourcesVcpu;
    @Property
    private String resourcesDisk;
    @Property
    private String capabilitiesDiskLabel;  //裸金属-磁盘分区格式GPT
    @Property
    private String cpuInfoArch;
    @Property
    private String cpuInfoVendor;
    @Property
    private String cpuSockets;  //虚拟机-CPU套接字
    @Property
    private String cpuCores;  //虚拟机-CPU核数
    @Property
    private String cpuThreads;  //虚拟机-CPU线程数
    @Property
    private String cpuCodename;  //虚拟机-CPU名称
    @Property
    private String cpuFrequency;  //虚拟机-CPU主频
    @Property
    private String  cpuModel;  //虚拟机-CPU类型
    @Property
    private String cpuPolicy;  //虚拟机-CPU亲和性设置
    @Property
    private String nicInterface;
    @Property
    private String nicType;
    @Property
    private String nicSpeeds;
    @Property
    private String innerNetworkBW;  //虚拟机-网络带宽
    @Property
    private String outerNetworkBW;
    @Property
    private String flavorType;
    @Property
    private String aggregateInstanceExtraSpecsPinned;
    @Property
    private String cpuThreadPolicyIsolate;  //虚拟机-CPU亲和性设置
    @Property("aggregate_instance_extra_specs")
    private String aggregateInstanceExtraSpecs;

    public ExtraSpec() { super(); }
    public ExtraSpec(JSONObject extraSpec) {
        //super(extraSpec);
        if(extraSpec.has("resources:VPU")) {
            this.resourcesVcpu = extraSpec.getString("resources:VPU");
        }
        if(extraSpec.has("capabilities:disk_label")) {
            this.capabilitiesDiskLabel = extraSpec.getString("capabilities:disk_label");
        }
        if(extraSpec.has("resources:MEMORY_MB")) {
            this.resourcesMemory = extraSpec.getString("resources:MEMORY_MB");
        }
        if(extraSpec.has("capabilities:boot_mode")) {
            this.capabilitiesBootMode = extraSpec.getString("capabilities:boot_mode");
        }
        if(extraSpec.has("resources:DISK_GB")) {
            this.resourcesDisk = extraSpec.getString("resources:DISK_GB");
        }
        if(extraSpec.has("capabilities:boot_option")) {
            this.capabilitiesBootOption = extraSpec.getString("capabilities:boot_option");
        }
        if(extraSpec.has("resources:CUSTOM_H3CB1_RESOURCE_CLASS_EFI")) {
            this.resourcesClassEfi = extraSpec.getString("resources:CUSTOM_H3CB1_RESOURCE_CLASS_EFI");
        }
        if(extraSpec.has("aggregate_instance_extra_specs:brand")) {
            this.extraSpecsBrand = extraSpec.getString("aggregate_instance_extra_specs:brand");
        }
        if(extraSpec.has("cpu_model")) {
            this.cpuModel = extraSpec.getString("cpu_model");
        }
        if(extraSpec.has("cpu_policy")) {
            this.cpuPolicy = extraSpec.getString("cpu_policy");
        }
        if(extraSpec.has("Inner_network_bw")) {
            this.innerNetworkBW = extraSpec.getString("Inner_network_bw");
        }
        if(extraSpec.has("cpu_sockets")) {
            this.cpuSockets = extraSpec.getString("cpu_sockets");
        }
        if(extraSpec.has("cpu_threads")) {
            this.cpuThreads = extraSpec.getString("cpu_threads");
        }
        if(extraSpec.has("aggregate_instance_extra_specs:pinned")) {
            this.aggregateInstanceExtraSpecsPinned = extraSpec.getString("aggregate_instance_extra_specs:pinned");
        }
        if(extraSpec.has("cpu_codename")) {
            this.cpuCodename = extraSpec.getString("cpu_codename");
        }
        if(extraSpec.has("cpu_frequency")) {
            this.cpuFrequency = extraSpec.getString("cpu_frequency");
        }
        if(extraSpec.has("cpu_cores")) {
            this.cpuCores = extraSpec.getString("cpu_cores");
        }
        if(extraSpec.has("cpu_thread_policy:isolate")) {
            this.cpuThreadPolicyIsolate = extraSpec.getString("cpu_thread_policy:isolate");
        }
        if (extraSpec.has("aggregate_instance_extra_specs")) {
            this.aggregateInstanceExtraSpecs = extraSpec.getString("aggregate_instance_extra_specs");
        }
    }

    public ExtraSpec(Object obj) {
        this(new JSONObject(obj.toString()));
    }
    public ExtraSpec(JSONObject header, JSONObject body) {
        JSONObject extraSpec = body.getJSONObject("extra_specs");
        if (extraSpec.has("aggregate_instance_extra_specs")) {
            this.aggregateInstanceExtraSpecs = extraSpec.getString("aggregate_instance_extra_specs");
        }
    }

    public String getAggregateInstanceExtraSpecs() { return this.aggregateInstanceExtraSpecs; }
    public void setAggregateInstanceExtraSpecs(String aggregateInstanceExtraSpecs) { this.aggregateInstanceExtraSpecs = aggregateInstanceExtraSpecs; }
    public String getCapabilitiesBootOption() { return this.capabilitiesBootOption; }
    public String getCapabilitiesBootMode() { return this.capabilitiesBootMode; }
    public String getResourcesClassEfi() { return this.resourcesClassEfi; }
    public String getResourcesMemory() { return this.resourcesMemory; }
    public String getExtraSpecsBrand() { return this.extraSpecsBrand; }
    public String getResourcesVcpu() { return this.resourcesVcpu; }
    public String getResourcesDisk() { return this.resourcesDisk; }
    public String getCapabilitiesDiskLabel() { return this.capabilitiesDiskLabel; }
    public String getCpuInfoArch() { return this.cpuInfoArch; }
    public String getCpuInfoVendor() { return this.cpuInfoVendor; }
    public String getCpuSockets() { return this.cpuSockets; }
    public String getCpuCores() { return this.cpuCores; }
    public String getCpuThreads() { return this.cpuThreads; }
    public String getCpuCodename() { return this.cpuCodename; }
    public String getCpuFrequency() { return this.cpuFrequency; }
    public String getCpuModel() { return this.cpuModel; }
    public String getNicInterface() { return this.nicInterface; }
    public String getNicType() { return this.nicType; }
    public String getNicSpeeds() { return this.nicSpeeds; }
    public String getInnerNetworkBW() { return this.innerNetworkBW; }
    public String getOuterNetworkBW() { return this.outerNetworkBW; }
    public String getFlavorType() { return this.flavorType; }
    public String getCpuPolicy() { return this.cpuPolicy; }
    public String getAggregateInstanceExtraSpecsPinned() { return this.aggregateInstanceExtraSpecsPinned; }
    public String getCpuThreadPolicyIsolate() { return this.cpuThreadPolicyIsolate; }

    @Override
    public boolean isValid() {
        return false;
    }
}
