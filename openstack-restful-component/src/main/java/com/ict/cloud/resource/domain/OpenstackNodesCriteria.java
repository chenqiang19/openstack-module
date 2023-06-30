package com.ict.cloud.resource.domain;

import java.util.ArrayList;
import java.util.List;

public class OpenstackNodesCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public OpenstackNodesCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
        rows = null;
        offset = null;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return this.offset;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getRows() {
        return this.rows;
    }

    public OpenstackNodesCriteria limit(Integer rows) {
        this.rows = rows;
        return this;
    }

    public OpenstackNodesCriteria limit(Integer offset, Integer rows) {
        this.offset = offset;
        this.rows = rows;
        return this;
    }

    public OpenstackNodesCriteria page(Integer page, Integer pageSize) {
        this.offset = (page - 1) * pageSize;
        this.rows = pageSize;
        return this;
    }

    /**
            * openstack_nodes
            **/
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andInstanceUuidIsNull() {
            addCriterion("instance_uuid is null");
            return (Criteria) this;
        }

        public Criteria andInstanceUuidIsNotNull() {
            addCriterion("instance_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceUuidEqualTo(String value) {
            addCriterion("instance_uuid =", value, "instanceUuid");
            return (Criteria) this;
        }

        public Criteria andInstanceUuidNotEqualTo(String value) {
            addCriterion("instance_uuid <>", value, "instanceUuid");
            return (Criteria) this;
        }

        public Criteria andInstanceUuidGreaterThan(String value) {
            addCriterion("instance_uuid >", value, "instanceUuid");
            return (Criteria) this;
        }

        public Criteria andInstanceUuidGreaterThanOrEqualTo(String value) {
            addCriterion("instance_uuid >=", value, "instanceUuid");
            return (Criteria) this;
        }

        public Criteria andInstanceUuidLessThan(String value) {
            addCriterion("instance_uuid <", value, "instanceUuid");
            return (Criteria) this;
        }

        public Criteria andInstanceUuidLessThanOrEqualTo(String value) {
            addCriterion("instance_uuid <=", value, "instanceUuid");
            return (Criteria) this;
        }

        public Criteria andInstanceUuidLike(String value) {
            addCriterion("instance_uuid like", value, "instanceUuid");
            return (Criteria) this;
        }

        public Criteria andInstanceUuidNotLike(String value) {
            addCriterion("instance_uuid not like", value, "instanceUuid");
            return (Criteria) this;
        }

        public Criteria andInstanceUuidIn(List<String> values) {
            addCriterion("instance_uuid in", values, "instanceUuid");
            return (Criteria) this;
        }

        public Criteria andInstanceUuidNotIn(List<String> values) {
            addCriterion("instance_uuid not in", values, "instanceUuid");
            return (Criteria) this;
        }

        public Criteria andInstanceUuidBetween(String value1, String value2) {
            addCriterion("instance_uuid between", value1, value2, "instanceUuid");
            return (Criteria) this;
        }

        public Criteria andInstanceUuidNotBetween(String value1, String value2) {
            addCriterion("instance_uuid not between", value1, value2, "instanceUuid");
            return (Criteria) this;
        }

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andProvisionStateIsNull() {
            addCriterion("provision_state is null");
            return (Criteria) this;
        }

        public Criteria andProvisionStateIsNotNull() {
            addCriterion("provision_state is not null");
            return (Criteria) this;
        }

        public Criteria andProvisionStateEqualTo(String value) {
            addCriterion("provision_state =", value, "provisionState");
            return (Criteria) this;
        }

        public Criteria andProvisionStateNotEqualTo(String value) {
            addCriterion("provision_state <>", value, "provisionState");
            return (Criteria) this;
        }

        public Criteria andProvisionStateGreaterThan(String value) {
            addCriterion("provision_state >", value, "provisionState");
            return (Criteria) this;
        }

        public Criteria andProvisionStateGreaterThanOrEqualTo(String value) {
            addCriterion("provision_state >=", value, "provisionState");
            return (Criteria) this;
        }

        public Criteria andProvisionStateLessThan(String value) {
            addCriterion("provision_state <", value, "provisionState");
            return (Criteria) this;
        }

        public Criteria andProvisionStateLessThanOrEqualTo(String value) {
            addCriterion("provision_state <=", value, "provisionState");
            return (Criteria) this;
        }

        public Criteria andProvisionStateLike(String value) {
            addCriterion("provision_state like", value, "provisionState");
            return (Criteria) this;
        }

        public Criteria andProvisionStateNotLike(String value) {
            addCriterion("provision_state not like", value, "provisionState");
            return (Criteria) this;
        }

        public Criteria andProvisionStateIn(List<String> values) {
            addCriterion("provision_state in", values, "provisionState");
            return (Criteria) this;
        }

        public Criteria andProvisionStateNotIn(List<String> values) {
            addCriterion("provision_state not in", values, "provisionState");
            return (Criteria) this;
        }

        public Criteria andProvisionStateBetween(String value1, String value2) {
            addCriterion("provision_state between", value1, value2, "provisionState");
            return (Criteria) this;
        }

        public Criteria andProvisionStateNotBetween(String value1, String value2) {
            addCriterion("provision_state not between", value1, value2, "provisionState");
            return (Criteria) this;
        }

        public Criteria andPowerStateIsNull() {
            addCriterion("power_state is null");
            return (Criteria) this;
        }

        public Criteria andPowerStateIsNotNull() {
            addCriterion("power_state is not null");
            return (Criteria) this;
        }

        public Criteria andPowerStateEqualTo(String value) {
            addCriterion("power_state =", value, "powerState");
            return (Criteria) this;
        }

        public Criteria andPowerStateNotEqualTo(String value) {
            addCriterion("power_state <>", value, "powerState");
            return (Criteria) this;
        }

        public Criteria andPowerStateGreaterThan(String value) {
            addCriterion("power_state >", value, "powerState");
            return (Criteria) this;
        }

        public Criteria andPowerStateGreaterThanOrEqualTo(String value) {
            addCriterion("power_state >=", value, "powerState");
            return (Criteria) this;
        }

        public Criteria andPowerStateLessThan(String value) {
            addCriterion("power_state <", value, "powerState");
            return (Criteria) this;
        }

        public Criteria andPowerStateLessThanOrEqualTo(String value) {
            addCriterion("power_state <=", value, "powerState");
            return (Criteria) this;
        }

        public Criteria andPowerStateLike(String value) {
            addCriterion("power_state like", value, "powerState");
            return (Criteria) this;
        }

        public Criteria andPowerStateNotLike(String value) {
            addCriterion("power_state not like", value, "powerState");
            return (Criteria) this;
        }

        public Criteria andPowerStateIn(List<String> values) {
            addCriterion("power_state in", values, "powerState");
            return (Criteria) this;
        }

        public Criteria andPowerStateNotIn(List<String> values) {
            addCriterion("power_state not in", values, "powerState");
            return (Criteria) this;
        }

        public Criteria andPowerStateBetween(String value1, String value2) {
            addCriterion("power_state between", value1, value2, "powerState");
            return (Criteria) this;
        }

        public Criteria andPowerStateNotBetween(String value1, String value2) {
            addCriterion("power_state not between", value1, value2, "powerState");
            return (Criteria) this;
        }

        public Criteria andVcpusIsNull() {
            addCriterion("vcpus is null");
            return (Criteria) this;
        }

        public Criteria andVcpusIsNotNull() {
            addCriterion("vcpus is not null");
            return (Criteria) this;
        }

        public Criteria andVcpusEqualTo(Integer value) {
            addCriterion("vcpus =", value, "vcpus");
            return (Criteria) this;
        }

        public Criteria andVcpusNotEqualTo(Integer value) {
            addCriterion("vcpus <>", value, "vcpus");
            return (Criteria) this;
        }

        public Criteria andVcpusGreaterThan(Integer value) {
            addCriterion("vcpus >", value, "vcpus");
            return (Criteria) this;
        }

        public Criteria andVcpusGreaterThanOrEqualTo(Integer value) {
            addCriterion("vcpus >=", value, "vcpus");
            return (Criteria) this;
        }

        public Criteria andVcpusLessThan(Integer value) {
            addCriterion("vcpus <", value, "vcpus");
            return (Criteria) this;
        }

        public Criteria andVcpusLessThanOrEqualTo(Integer value) {
            addCriterion("vcpus <=", value, "vcpus");
            return (Criteria) this;
        }

        public Criteria andVcpusIn(List<Integer> values) {
            addCriterion("vcpus in", values, "vcpus");
            return (Criteria) this;
        }

        public Criteria andVcpusNotIn(List<Integer> values) {
            addCriterion("vcpus not in", values, "vcpus");
            return (Criteria) this;
        }

        public Criteria andVcpusBetween(Integer value1, Integer value2) {
            addCriterion("vcpus between", value1, value2, "vcpus");
            return (Criteria) this;
        }

        public Criteria andVcpusNotBetween(Integer value1, Integer value2) {
            addCriterion("vcpus not between", value1, value2, "vcpus");
            return (Criteria) this;
        }

        public Criteria andMemoryMbIsNull() {
            addCriterion("memory_mb is null");
            return (Criteria) this;
        }

        public Criteria andMemoryMbIsNotNull() {
            addCriterion("memory_mb is not null");
            return (Criteria) this;
        }

        public Criteria andMemoryMbEqualTo(Integer value) {
            addCriterion("memory_mb =", value, "memoryMb");
            return (Criteria) this;
        }

        public Criteria andMemoryMbNotEqualTo(Integer value) {
            addCriterion("memory_mb <>", value, "memoryMb");
            return (Criteria) this;
        }

        public Criteria andMemoryMbGreaterThan(Integer value) {
            addCriterion("memory_mb >", value, "memoryMb");
            return (Criteria) this;
        }

        public Criteria andMemoryMbGreaterThanOrEqualTo(Integer value) {
            addCriterion("memory_mb >=", value, "memoryMb");
            return (Criteria) this;
        }

        public Criteria andMemoryMbLessThan(Integer value) {
            addCriterion("memory_mb <", value, "memoryMb");
            return (Criteria) this;
        }

        public Criteria andMemoryMbLessThanOrEqualTo(Integer value) {
            addCriterion("memory_mb <=", value, "memoryMb");
            return (Criteria) this;
        }

        public Criteria andMemoryMbIn(List<Integer> values) {
            addCriterion("memory_mb in", values, "memoryMb");
            return (Criteria) this;
        }

        public Criteria andMemoryMbNotIn(List<Integer> values) {
            addCriterion("memory_mb not in", values, "memoryMb");
            return (Criteria) this;
        }

        public Criteria andMemoryMbBetween(Integer value1, Integer value2) {
            addCriterion("memory_mb between", value1, value2, "memoryMb");
            return (Criteria) this;
        }

        public Criteria andMemoryMbNotBetween(Integer value1, Integer value2) {
            addCriterion("memory_mb not between", value1, value2, "memoryMb");
            return (Criteria) this;
        }

        public Criteria andLocalGbIsNull() {
            addCriterion("local_gb is null");
            return (Criteria) this;
        }

        public Criteria andLocalGbIsNotNull() {
            addCriterion("local_gb is not null");
            return (Criteria) this;
        }

        public Criteria andLocalGbEqualTo(Integer value) {
            addCriterion("local_gb =", value, "localGb");
            return (Criteria) this;
        }

        public Criteria andLocalGbNotEqualTo(Integer value) {
            addCriterion("local_gb <>", value, "localGb");
            return (Criteria) this;
        }

        public Criteria andLocalGbGreaterThan(Integer value) {
            addCriterion("local_gb >", value, "localGb");
            return (Criteria) this;
        }

        public Criteria andLocalGbGreaterThanOrEqualTo(Integer value) {
            addCriterion("local_gb >=", value, "localGb");
            return (Criteria) this;
        }

        public Criteria andLocalGbLessThan(Integer value) {
            addCriterion("local_gb <", value, "localGb");
            return (Criteria) this;
        }

        public Criteria andLocalGbLessThanOrEqualTo(Integer value) {
            addCriterion("local_gb <=", value, "localGb");
            return (Criteria) this;
        }

        public Criteria andLocalGbIn(List<Integer> values) {
            addCriterion("local_gb in", values, "localGb");
            return (Criteria) this;
        }

        public Criteria andLocalGbNotIn(List<Integer> values) {
            addCriterion("local_gb not in", values, "localGb");
            return (Criteria) this;
        }

        public Criteria andLocalGbBetween(Integer value1, Integer value2) {
            addCriterion("local_gb between", value1, value2, "localGb");
            return (Criteria) this;
        }

        public Criteria andLocalGbNotBetween(Integer value1, Integer value2) {
            addCriterion("local_gb not between", value1, value2, "localGb");
            return (Criteria) this;
        }

        public Criteria andCpuArchIsNull() {
            addCriterion("cpu_arch is null");
            return (Criteria) this;
        }

        public Criteria andCpuArchIsNotNull() {
            addCriterion("cpu_arch is not null");
            return (Criteria) this;
        }

        public Criteria andCpuArchEqualTo(String value) {
            addCriterion("cpu_arch =", value, "cpuArch");
            return (Criteria) this;
        }

        public Criteria andCpuArchNotEqualTo(String value) {
            addCriterion("cpu_arch <>", value, "cpuArch");
            return (Criteria) this;
        }

        public Criteria andCpuArchGreaterThan(String value) {
            addCriterion("cpu_arch >", value, "cpuArch");
            return (Criteria) this;
        }

        public Criteria andCpuArchGreaterThanOrEqualTo(String value) {
            addCriterion("cpu_arch >=", value, "cpuArch");
            return (Criteria) this;
        }

        public Criteria andCpuArchLessThan(String value) {
            addCriterion("cpu_arch <", value, "cpuArch");
            return (Criteria) this;
        }

        public Criteria andCpuArchLessThanOrEqualTo(String value) {
            addCriterion("cpu_arch <=", value, "cpuArch");
            return (Criteria) this;
        }

        public Criteria andCpuArchLike(String value) {
            addCriterion("cpu_arch like", value, "cpuArch");
            return (Criteria) this;
        }

        public Criteria andCpuArchNotLike(String value) {
            addCriterion("cpu_arch not like", value, "cpuArch");
            return (Criteria) this;
        }

        public Criteria andCpuArchIn(List<String> values) {
            addCriterion("cpu_arch in", values, "cpuArch");
            return (Criteria) this;
        }

        public Criteria andCpuArchNotIn(List<String> values) {
            addCriterion("cpu_arch not in", values, "cpuArch");
            return (Criteria) this;
        }

        public Criteria andCpuArchBetween(String value1, String value2) {
            addCriterion("cpu_arch between", value1, value2, "cpuArch");
            return (Criteria) this;
        }

        public Criteria andCpuArchNotBetween(String value1, String value2) {
            addCriterion("cpu_arch not between", value1, value2, "cpuArch");
            return (Criteria) this;
        }

        public Criteria andGpuFlagIsNull() {
            addCriterion("gpu_flag is null");
            return (Criteria) this;
        }

        public Criteria andGpuFlagIsNotNull() {
            addCriterion("gpu_flag is not null");
            return (Criteria) this;
        }

        public Criteria andGpuFlagEqualTo(Integer value) {
            addCriterion("gpu_flag =", value, "gpuFlag");
            return (Criteria) this;
        }

        public Criteria andGpuFlagNotEqualTo(Integer value) {
            addCriterion("gpu_flag <>", value, "gpuFlag");
            return (Criteria) this;
        }

        public Criteria andGpuFlagGreaterThan(Integer value) {
            addCriterion("gpu_flag >", value, "gpuFlag");
            return (Criteria) this;
        }

        public Criteria andGpuFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("gpu_flag >=", value, "gpuFlag");
            return (Criteria) this;
        }

        public Criteria andGpuFlagLessThan(Integer value) {
            addCriterion("gpu_flag <", value, "gpuFlag");
            return (Criteria) this;
        }

        public Criteria andGpuFlagLessThanOrEqualTo(Integer value) {
            addCriterion("gpu_flag <=", value, "gpuFlag");
            return (Criteria) this;
        }

        public Criteria andGpuFlagIn(List<Integer> values) {
            addCriterion("gpu_flag in", values, "gpuFlag");
            return (Criteria) this;
        }

        public Criteria andGpuFlagNotIn(List<Integer> values) {
            addCriterion("gpu_flag not in", values, "gpuFlag");
            return (Criteria) this;
        }

        public Criteria andGpuFlagBetween(Integer value1, Integer value2) {
            addCriterion("gpu_flag between", value1, value2, "gpuFlag");
            return (Criteria) this;
        }

        public Criteria andGpuFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("gpu_flag not between", value1, value2, "gpuFlag");
            return (Criteria) this;
        }

        public Criteria andMachineFlagIsNull() {
            addCriterion("machine_flag is null");
            return (Criteria) this;
        }

        public Criteria andMachineFlagIsNotNull() {
            addCriterion("machine_flag is not null");
            return (Criteria) this;
        }

        public Criteria andMachineFlagEqualTo(String value) {
            addCriterion("machine_flag =", value, "machineFlag");
            return (Criteria) this;
        }

        public Criteria andMachineFlagNotEqualTo(String value) {
            addCriterion("machine_flag <>", value, "machineFlag");
            return (Criteria) this;
        }

        public Criteria andMachineFlagGreaterThan(String value) {
            addCriterion("machine_flag >", value, "machineFlag");
            return (Criteria) this;
        }

        public Criteria andMachineFlagGreaterThanOrEqualTo(String value) {
            addCriterion("machine_flag >=", value, "machineFlag");
            return (Criteria) this;
        }

        public Criteria andMachineFlagLessThan(String value) {
            addCriterion("machine_flag <", value, "machineFlag");
            return (Criteria) this;
        }

        public Criteria andMachineFlagLessThanOrEqualTo(String value) {
            addCriterion("machine_flag <=", value, "machineFlag");
            return (Criteria) this;
        }

        public Criteria andMachineFlagLike(String value) {
            addCriterion("machine_flag like", value, "machineFlag");
            return (Criteria) this;
        }

        public Criteria andMachineFlagNotLike(String value) {
            addCriterion("machine_flag not like", value, "machineFlag");
            return (Criteria) this;
        }

        public Criteria andMachineFlagIn(List<String> values) {
            addCriterion("machine_flag in", values, "machineFlag");
            return (Criteria) this;
        }

        public Criteria andMachineFlagNotIn(List<String> values) {
            addCriterion("machine_flag not in", values, "machineFlag");
            return (Criteria) this;
        }

        public Criteria andMachineFlagBetween(String value1, String value2) {
            addCriterion("machine_flag between", value1, value2, "machineFlag");
            return (Criteria) this;
        }

        public Criteria andMachineFlagNotBetween(String value1, String value2) {
            addCriterion("machine_flag not between", value1, value2, "machineFlag");
            return (Criteria) this;
        }
    }

    /**
            * openstack_nodes
            **/
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
            * openstack_nodes
            **/
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}