package com.ict.cloud.resource.domain;

import java.util.ArrayList;
import java.util.List;

public class OpenstackResourceCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public OpenstackResourceCriteria() {
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

    public OpenstackResourceCriteria limit(Integer rows) {
        this.rows = rows;
        return this;
    }

    public OpenstackResourceCriteria limit(Integer offset, Integer rows) {
        this.offset = offset;
        this.rows = rows;
        return this;
    }

    public OpenstackResourceCriteria page(Integer page, Integer pageSize) {
        this.offset = (page - 1) * pageSize;
        this.rows = pageSize;
        return this;
    }

    /**
            * openstack_resource
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

        public Criteria andInstanceIdIsNull() {
            addCriterion("instance_id is null");
            return (Criteria) this;
        }

        public Criteria andInstanceIdIsNotNull() {
            addCriterion("instance_id is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceIdEqualTo(Integer value) {
            addCriterion("instance_id =", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdNotEqualTo(Integer value) {
            addCriterion("instance_id <>", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdGreaterThan(Integer value) {
            addCriterion("instance_id >", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("instance_id >=", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdLessThan(Integer value) {
            addCriterion("instance_id <", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdLessThanOrEqualTo(Integer value) {
            addCriterion("instance_id <=", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdIn(List<Integer> values) {
            addCriterion("instance_id in", values, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdNotIn(List<Integer> values) {
            addCriterion("instance_id not in", values, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdBetween(Integer value1, Integer value2) {
            addCriterion("instance_id between", value1, value2, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("instance_id not between", value1, value2, "instanceId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andVcpusUsedIsNull() {
            addCriterion("vcpus_used is null");
            return (Criteria) this;
        }

        public Criteria andVcpusUsedIsNotNull() {
            addCriterion("vcpus_used is not null");
            return (Criteria) this;
        }

        public Criteria andVcpusUsedEqualTo(Integer value) {
            addCriterion("vcpus_used =", value, "vcpusUsed");
            return (Criteria) this;
        }

        public Criteria andVcpusUsedNotEqualTo(Integer value) {
            addCriterion("vcpus_used <>", value, "vcpusUsed");
            return (Criteria) this;
        }

        public Criteria andVcpusUsedGreaterThan(Integer value) {
            addCriterion("vcpus_used >", value, "vcpusUsed");
            return (Criteria) this;
        }

        public Criteria andVcpusUsedGreaterThanOrEqualTo(Integer value) {
            addCriterion("vcpus_used >=", value, "vcpusUsed");
            return (Criteria) this;
        }

        public Criteria andVcpusUsedLessThan(Integer value) {
            addCriterion("vcpus_used <", value, "vcpusUsed");
            return (Criteria) this;
        }

        public Criteria andVcpusUsedLessThanOrEqualTo(Integer value) {
            addCriterion("vcpus_used <=", value, "vcpusUsed");
            return (Criteria) this;
        }

        public Criteria andVcpusUsedIn(List<Integer> values) {
            addCriterion("vcpus_used in", values, "vcpusUsed");
            return (Criteria) this;
        }

        public Criteria andVcpusUsedNotIn(List<Integer> values) {
            addCriterion("vcpus_used not in", values, "vcpusUsed");
            return (Criteria) this;
        }

        public Criteria andVcpusUsedBetween(Integer value1, Integer value2) {
            addCriterion("vcpus_used between", value1, value2, "vcpusUsed");
            return (Criteria) this;
        }

        public Criteria andVcpusUsedNotBetween(Integer value1, Integer value2) {
            addCriterion("vcpus_used not between", value1, value2, "vcpusUsed");
            return (Criteria) this;
        }

        public Criteria andHypervisorTypeIsNull() {
            addCriterion("hypervisor_type is null");
            return (Criteria) this;
        }

        public Criteria andHypervisorTypeIsNotNull() {
            addCriterion("hypervisor_type is not null");
            return (Criteria) this;
        }

        public Criteria andHypervisorTypeEqualTo(String value) {
            addCriterion("hypervisor_type =", value, "hypervisorType");
            return (Criteria) this;
        }

        public Criteria andHypervisorTypeNotEqualTo(String value) {
            addCriterion("hypervisor_type <>", value, "hypervisorType");
            return (Criteria) this;
        }

        public Criteria andHypervisorTypeGreaterThan(String value) {
            addCriterion("hypervisor_type >", value, "hypervisorType");
            return (Criteria) this;
        }

        public Criteria andHypervisorTypeGreaterThanOrEqualTo(String value) {
            addCriterion("hypervisor_type >=", value, "hypervisorType");
            return (Criteria) this;
        }

        public Criteria andHypervisorTypeLessThan(String value) {
            addCriterion("hypervisor_type <", value, "hypervisorType");
            return (Criteria) this;
        }

        public Criteria andHypervisorTypeLessThanOrEqualTo(String value) {
            addCriterion("hypervisor_type <=", value, "hypervisorType");
            return (Criteria) this;
        }

        public Criteria andHypervisorTypeLike(String value) {
            addCriterion("hypervisor_type like", value, "hypervisorType");
            return (Criteria) this;
        }

        public Criteria andHypervisorTypeNotLike(String value) {
            addCriterion("hypervisor_type not like", value, "hypervisorType");
            return (Criteria) this;
        }

        public Criteria andHypervisorTypeIn(List<String> values) {
            addCriterion("hypervisor_type in", values, "hypervisorType");
            return (Criteria) this;
        }

        public Criteria andHypervisorTypeNotIn(List<String> values) {
            addCriterion("hypervisor_type not in", values, "hypervisorType");
            return (Criteria) this;
        }

        public Criteria andHypervisorTypeBetween(String value1, String value2) {
            addCriterion("hypervisor_type between", value1, value2, "hypervisorType");
            return (Criteria) this;
        }

        public Criteria andHypervisorTypeNotBetween(String value1, String value2) {
            addCriterion("hypervisor_type not between", value1, value2, "hypervisorType");
            return (Criteria) this;
        }

        public Criteria andLocalGbUsedIsNull() {
            addCriterion("local_gb_used is null");
            return (Criteria) this;
        }

        public Criteria andLocalGbUsedIsNotNull() {
            addCriterion("local_gb_used is not null");
            return (Criteria) this;
        }

        public Criteria andLocalGbUsedEqualTo(Integer value) {
            addCriterion("local_gb_used =", value, "localGbUsed");
            return (Criteria) this;
        }

        public Criteria andLocalGbUsedNotEqualTo(Integer value) {
            addCriterion("local_gb_used <>", value, "localGbUsed");
            return (Criteria) this;
        }

        public Criteria andLocalGbUsedGreaterThan(Integer value) {
            addCriterion("local_gb_used >", value, "localGbUsed");
            return (Criteria) this;
        }

        public Criteria andLocalGbUsedGreaterThanOrEqualTo(Integer value) {
            addCriterion("local_gb_used >=", value, "localGbUsed");
            return (Criteria) this;
        }

        public Criteria andLocalGbUsedLessThan(Integer value) {
            addCriterion("local_gb_used <", value, "localGbUsed");
            return (Criteria) this;
        }

        public Criteria andLocalGbUsedLessThanOrEqualTo(Integer value) {
            addCriterion("local_gb_used <=", value, "localGbUsed");
            return (Criteria) this;
        }

        public Criteria andLocalGbUsedIn(List<Integer> values) {
            addCriterion("local_gb_used in", values, "localGbUsed");
            return (Criteria) this;
        }

        public Criteria andLocalGbUsedNotIn(List<Integer> values) {
            addCriterion("local_gb_used not in", values, "localGbUsed");
            return (Criteria) this;
        }

        public Criteria andLocalGbUsedBetween(Integer value1, Integer value2) {
            addCriterion("local_gb_used between", value1, value2, "localGbUsed");
            return (Criteria) this;
        }

        public Criteria andLocalGbUsedNotBetween(Integer value1, Integer value2) {
            addCriterion("local_gb_used not between", value1, value2, "localGbUsed");
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

        public Criteria andHypervisorHostnameIsNull() {
            addCriterion("hypervisor_hostname is null");
            return (Criteria) this;
        }

        public Criteria andHypervisorHostnameIsNotNull() {
            addCriterion("hypervisor_hostname is not null");
            return (Criteria) this;
        }

        public Criteria andHypervisorHostnameEqualTo(String value) {
            addCriterion("hypervisor_hostname =", value, "hypervisorHostname");
            return (Criteria) this;
        }

        public Criteria andHypervisorHostnameNotEqualTo(String value) {
            addCriterion("hypervisor_hostname <>", value, "hypervisorHostname");
            return (Criteria) this;
        }

        public Criteria andHypervisorHostnameGreaterThan(String value) {
            addCriterion("hypervisor_hostname >", value, "hypervisorHostname");
            return (Criteria) this;
        }

        public Criteria andHypervisorHostnameGreaterThanOrEqualTo(String value) {
            addCriterion("hypervisor_hostname >=", value, "hypervisorHostname");
            return (Criteria) this;
        }

        public Criteria andHypervisorHostnameLessThan(String value) {
            addCriterion("hypervisor_hostname <", value, "hypervisorHostname");
            return (Criteria) this;
        }

        public Criteria andHypervisorHostnameLessThanOrEqualTo(String value) {
            addCriterion("hypervisor_hostname <=", value, "hypervisorHostname");
            return (Criteria) this;
        }

        public Criteria andHypervisorHostnameLike(String value) {
            addCriterion("hypervisor_hostname like", value, "hypervisorHostname");
            return (Criteria) this;
        }

        public Criteria andHypervisorHostnameNotLike(String value) {
            addCriterion("hypervisor_hostname not like", value, "hypervisorHostname");
            return (Criteria) this;
        }

        public Criteria andHypervisorHostnameIn(List<String> values) {
            addCriterion("hypervisor_hostname in", values, "hypervisorHostname");
            return (Criteria) this;
        }

        public Criteria andHypervisorHostnameNotIn(List<String> values) {
            addCriterion("hypervisor_hostname not in", values, "hypervisorHostname");
            return (Criteria) this;
        }

        public Criteria andHypervisorHostnameBetween(String value1, String value2) {
            addCriterion("hypervisor_hostname between", value1, value2, "hypervisorHostname");
            return (Criteria) this;
        }

        public Criteria andHypervisorHostnameNotBetween(String value1, String value2) {
            addCriterion("hypervisor_hostname not between", value1, value2, "hypervisorHostname");
            return (Criteria) this;
        }

        public Criteria andMemoryMbUsedIsNull() {
            addCriterion("memory_mb_used is null");
            return (Criteria) this;
        }

        public Criteria andMemoryMbUsedIsNotNull() {
            addCriterion("memory_mb_used is not null");
            return (Criteria) this;
        }

        public Criteria andMemoryMbUsedEqualTo(Integer value) {
            addCriterion("memory_mb_used =", value, "memoryMbUsed");
            return (Criteria) this;
        }

        public Criteria andMemoryMbUsedNotEqualTo(Integer value) {
            addCriterion("memory_mb_used <>", value, "memoryMbUsed");
            return (Criteria) this;
        }

        public Criteria andMemoryMbUsedGreaterThan(Integer value) {
            addCriterion("memory_mb_used >", value, "memoryMbUsed");
            return (Criteria) this;
        }

        public Criteria andMemoryMbUsedGreaterThanOrEqualTo(Integer value) {
            addCriterion("memory_mb_used >=", value, "memoryMbUsed");
            return (Criteria) this;
        }

        public Criteria andMemoryMbUsedLessThan(Integer value) {
            addCriterion("memory_mb_used <", value, "memoryMbUsed");
            return (Criteria) this;
        }

        public Criteria andMemoryMbUsedLessThanOrEqualTo(Integer value) {
            addCriterion("memory_mb_used <=", value, "memoryMbUsed");
            return (Criteria) this;
        }

        public Criteria andMemoryMbUsedIn(List<Integer> values) {
            addCriterion("memory_mb_used in", values, "memoryMbUsed");
            return (Criteria) this;
        }

        public Criteria andMemoryMbUsedNotIn(List<Integer> values) {
            addCriterion("memory_mb_used not in", values, "memoryMbUsed");
            return (Criteria) this;
        }

        public Criteria andMemoryMbUsedBetween(Integer value1, Integer value2) {
            addCriterion("memory_mb_used between", value1, value2, "memoryMbUsed");
            return (Criteria) this;
        }

        public Criteria andMemoryMbUsedNotBetween(Integer value1, Integer value2) {
            addCriterion("memory_mb_used not between", value1, value2, "memoryMbUsed");
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

        public Criteria andCurrentWorkloadIsNull() {
            addCriterion("current_workload is null");
            return (Criteria) this;
        }

        public Criteria andCurrentWorkloadIsNotNull() {
            addCriterion("current_workload is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentWorkloadEqualTo(Integer value) {
            addCriterion("current_workload =", value, "currentWorkload");
            return (Criteria) this;
        }

        public Criteria andCurrentWorkloadNotEqualTo(Integer value) {
            addCriterion("current_workload <>", value, "currentWorkload");
            return (Criteria) this;
        }

        public Criteria andCurrentWorkloadGreaterThan(Integer value) {
            addCriterion("current_workload >", value, "currentWorkload");
            return (Criteria) this;
        }

        public Criteria andCurrentWorkloadGreaterThanOrEqualTo(Integer value) {
            addCriterion("current_workload >=", value, "currentWorkload");
            return (Criteria) this;
        }

        public Criteria andCurrentWorkloadLessThan(Integer value) {
            addCriterion("current_workload <", value, "currentWorkload");
            return (Criteria) this;
        }

        public Criteria andCurrentWorkloadLessThanOrEqualTo(Integer value) {
            addCriterion("current_workload <=", value, "currentWorkload");
            return (Criteria) this;
        }

        public Criteria andCurrentWorkloadIn(List<Integer> values) {
            addCriterion("current_workload in", values, "currentWorkload");
            return (Criteria) this;
        }

        public Criteria andCurrentWorkloadNotIn(List<Integer> values) {
            addCriterion("current_workload not in", values, "currentWorkload");
            return (Criteria) this;
        }

        public Criteria andCurrentWorkloadBetween(Integer value1, Integer value2) {
            addCriterion("current_workload between", value1, value2, "currentWorkload");
            return (Criteria) this;
        }

        public Criteria andCurrentWorkloadNotBetween(Integer value1, Integer value2) {
            addCriterion("current_workload not between", value1, value2, "currentWorkload");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andHostIpIsNull() {
            addCriterion("host_ip is null");
            return (Criteria) this;
        }

        public Criteria andHostIpIsNotNull() {
            addCriterion("host_ip is not null");
            return (Criteria) this;
        }

        public Criteria andHostIpEqualTo(String value) {
            addCriterion("host_ip =", value, "hostIp");
            return (Criteria) this;
        }

        public Criteria andHostIpNotEqualTo(String value) {
            addCriterion("host_ip <>", value, "hostIp");
            return (Criteria) this;
        }

        public Criteria andHostIpGreaterThan(String value) {
            addCriterion("host_ip >", value, "hostIp");
            return (Criteria) this;
        }

        public Criteria andHostIpGreaterThanOrEqualTo(String value) {
            addCriterion("host_ip >=", value, "hostIp");
            return (Criteria) this;
        }

        public Criteria andHostIpLessThan(String value) {
            addCriterion("host_ip <", value, "hostIp");
            return (Criteria) this;
        }

        public Criteria andHostIpLessThanOrEqualTo(String value) {
            addCriterion("host_ip <=", value, "hostIp");
            return (Criteria) this;
        }

        public Criteria andHostIpLike(String value) {
            addCriterion("host_ip like", value, "hostIp");
            return (Criteria) this;
        }

        public Criteria andHostIpNotLike(String value) {
            addCriterion("host_ip not like", value, "hostIp");
            return (Criteria) this;
        }

        public Criteria andHostIpIn(List<String> values) {
            addCriterion("host_ip in", values, "hostIp");
            return (Criteria) this;
        }

        public Criteria andHostIpNotIn(List<String> values) {
            addCriterion("host_ip not in", values, "hostIp");
            return (Criteria) this;
        }

        public Criteria andHostIpBetween(String value1, String value2) {
            addCriterion("host_ip between", value1, value2, "hostIp");
            return (Criteria) this;
        }

        public Criteria andHostIpNotBetween(String value1, String value2) {
            addCriterion("host_ip not between", value1, value2, "hostIp");
            return (Criteria) this;
        }

        public Criteria andRunningVmsIsNull() {
            addCriterion("running_vms is null");
            return (Criteria) this;
        }

        public Criteria andRunningVmsIsNotNull() {
            addCriterion("running_vms is not null");
            return (Criteria) this;
        }

        public Criteria andRunningVmsEqualTo(Integer value) {
            addCriterion("running_vms =", value, "runningVms");
            return (Criteria) this;
        }

        public Criteria andRunningVmsNotEqualTo(Integer value) {
            addCriterion("running_vms <>", value, "runningVms");
            return (Criteria) this;
        }

        public Criteria andRunningVmsGreaterThan(Integer value) {
            addCriterion("running_vms >", value, "runningVms");
            return (Criteria) this;
        }

        public Criteria andRunningVmsGreaterThanOrEqualTo(Integer value) {
            addCriterion("running_vms >=", value, "runningVms");
            return (Criteria) this;
        }

        public Criteria andRunningVmsLessThan(Integer value) {
            addCriterion("running_vms <", value, "runningVms");
            return (Criteria) this;
        }

        public Criteria andRunningVmsLessThanOrEqualTo(Integer value) {
            addCriterion("running_vms <=", value, "runningVms");
            return (Criteria) this;
        }

        public Criteria andRunningVmsIn(List<Integer> values) {
            addCriterion("running_vms in", values, "runningVms");
            return (Criteria) this;
        }

        public Criteria andRunningVmsNotIn(List<Integer> values) {
            addCriterion("running_vms not in", values, "runningVms");
            return (Criteria) this;
        }

        public Criteria andRunningVmsBetween(Integer value1, Integer value2) {
            addCriterion("running_vms between", value1, value2, "runningVms");
            return (Criteria) this;
        }

        public Criteria andRunningVmsNotBetween(Integer value1, Integer value2) {
            addCriterion("running_vms not between", value1, value2, "runningVms");
            return (Criteria) this;
        }

        public Criteria andFreeDiskGbIsNull() {
            addCriterion("free_disk_gb is null");
            return (Criteria) this;
        }

        public Criteria andFreeDiskGbIsNotNull() {
            addCriterion("free_disk_gb is not null");
            return (Criteria) this;
        }

        public Criteria andFreeDiskGbEqualTo(Integer value) {
            addCriterion("free_disk_gb =", value, "freeDiskGb");
            return (Criteria) this;
        }

        public Criteria andFreeDiskGbNotEqualTo(Integer value) {
            addCriterion("free_disk_gb <>", value, "freeDiskGb");
            return (Criteria) this;
        }

        public Criteria andFreeDiskGbGreaterThan(Integer value) {
            addCriterion("free_disk_gb >", value, "freeDiskGb");
            return (Criteria) this;
        }

        public Criteria andFreeDiskGbGreaterThanOrEqualTo(Integer value) {
            addCriterion("free_disk_gb >=", value, "freeDiskGb");
            return (Criteria) this;
        }

        public Criteria andFreeDiskGbLessThan(Integer value) {
            addCriterion("free_disk_gb <", value, "freeDiskGb");
            return (Criteria) this;
        }

        public Criteria andFreeDiskGbLessThanOrEqualTo(Integer value) {
            addCriterion("free_disk_gb <=", value, "freeDiskGb");
            return (Criteria) this;
        }

        public Criteria andFreeDiskGbIn(List<Integer> values) {
            addCriterion("free_disk_gb in", values, "freeDiskGb");
            return (Criteria) this;
        }

        public Criteria andFreeDiskGbNotIn(List<Integer> values) {
            addCriterion("free_disk_gb not in", values, "freeDiskGb");
            return (Criteria) this;
        }

        public Criteria andFreeDiskGbBetween(Integer value1, Integer value2) {
            addCriterion("free_disk_gb between", value1, value2, "freeDiskGb");
            return (Criteria) this;
        }

        public Criteria andFreeDiskGbNotBetween(Integer value1, Integer value2) {
            addCriterion("free_disk_gb not between", value1, value2, "freeDiskGb");
            return (Criteria) this;
        }

        public Criteria andHypervisorVersionIsNull() {
            addCriterion("hypervisor_version is null");
            return (Criteria) this;
        }

        public Criteria andHypervisorVersionIsNotNull() {
            addCriterion("hypervisor_version is not null");
            return (Criteria) this;
        }

        public Criteria andHypervisorVersionEqualTo(String value) {
            addCriterion("hypervisor_version =", value, "hypervisorVersion");
            return (Criteria) this;
        }

        public Criteria andHypervisorVersionNotEqualTo(String value) {
            addCriterion("hypervisor_version <>", value, "hypervisorVersion");
            return (Criteria) this;
        }

        public Criteria andHypervisorVersionGreaterThan(String value) {
            addCriterion("hypervisor_version >", value, "hypervisorVersion");
            return (Criteria) this;
        }

        public Criteria andHypervisorVersionGreaterThanOrEqualTo(String value) {
            addCriterion("hypervisor_version >=", value, "hypervisorVersion");
            return (Criteria) this;
        }

        public Criteria andHypervisorVersionLessThan(String value) {
            addCriterion("hypervisor_version <", value, "hypervisorVersion");
            return (Criteria) this;
        }

        public Criteria andHypervisorVersionLessThanOrEqualTo(String value) {
            addCriterion("hypervisor_version <=", value, "hypervisorVersion");
            return (Criteria) this;
        }

        public Criteria andHypervisorVersionLike(String value) {
            addCriterion("hypervisor_version like", value, "hypervisorVersion");
            return (Criteria) this;
        }

        public Criteria andHypervisorVersionNotLike(String value) {
            addCriterion("hypervisor_version not like", value, "hypervisorVersion");
            return (Criteria) this;
        }

        public Criteria andHypervisorVersionIn(List<String> values) {
            addCriterion("hypervisor_version in", values, "hypervisorVersion");
            return (Criteria) this;
        }

        public Criteria andHypervisorVersionNotIn(List<String> values) {
            addCriterion("hypervisor_version not in", values, "hypervisorVersion");
            return (Criteria) this;
        }

        public Criteria andHypervisorVersionBetween(String value1, String value2) {
            addCriterion("hypervisor_version between", value1, value2, "hypervisorVersion");
            return (Criteria) this;
        }

        public Criteria andHypervisorVersionNotBetween(String value1, String value2) {
            addCriterion("hypervisor_version not between", value1, value2, "hypervisorVersion");
            return (Criteria) this;
        }

        public Criteria andDiskAvailableLeastIsNull() {
            addCriterion("disk_available_least is null");
            return (Criteria) this;
        }

        public Criteria andDiskAvailableLeastIsNotNull() {
            addCriterion("disk_available_least is not null");
            return (Criteria) this;
        }

        public Criteria andDiskAvailableLeastEqualTo(Integer value) {
            addCriterion("disk_available_least =", value, "diskAvailableLeast");
            return (Criteria) this;
        }

        public Criteria andDiskAvailableLeastNotEqualTo(Integer value) {
            addCriterion("disk_available_least <>", value, "diskAvailableLeast");
            return (Criteria) this;
        }

        public Criteria andDiskAvailableLeastGreaterThan(Integer value) {
            addCriterion("disk_available_least >", value, "diskAvailableLeast");
            return (Criteria) this;
        }

        public Criteria andDiskAvailableLeastGreaterThanOrEqualTo(Integer value) {
            addCriterion("disk_available_least >=", value, "diskAvailableLeast");
            return (Criteria) this;
        }

        public Criteria andDiskAvailableLeastLessThan(Integer value) {
            addCriterion("disk_available_least <", value, "diskAvailableLeast");
            return (Criteria) this;
        }

        public Criteria andDiskAvailableLeastLessThanOrEqualTo(Integer value) {
            addCriterion("disk_available_least <=", value, "diskAvailableLeast");
            return (Criteria) this;
        }

        public Criteria andDiskAvailableLeastIn(List<Integer> values) {
            addCriterion("disk_available_least in", values, "diskAvailableLeast");
            return (Criteria) this;
        }

        public Criteria andDiskAvailableLeastNotIn(List<Integer> values) {
            addCriterion("disk_available_least not in", values, "diskAvailableLeast");
            return (Criteria) this;
        }

        public Criteria andDiskAvailableLeastBetween(Integer value1, Integer value2) {
            addCriterion("disk_available_least between", value1, value2, "diskAvailableLeast");
            return (Criteria) this;
        }

        public Criteria andDiskAvailableLeastNotBetween(Integer value1, Integer value2) {
            addCriterion("disk_available_least not between", value1, value2, "diskAvailableLeast");
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

        public Criteria andFreeRamMbIsNull() {
            addCriterion("free_ram_mb is null");
            return (Criteria) this;
        }

        public Criteria andFreeRamMbIsNotNull() {
            addCriterion("free_ram_mb is not null");
            return (Criteria) this;
        }

        public Criteria andFreeRamMbEqualTo(Integer value) {
            addCriterion("free_ram_mb =", value, "freeRamMb");
            return (Criteria) this;
        }

        public Criteria andFreeRamMbNotEqualTo(Integer value) {
            addCriterion("free_ram_mb <>", value, "freeRamMb");
            return (Criteria) this;
        }

        public Criteria andFreeRamMbGreaterThan(Integer value) {
            addCriterion("free_ram_mb >", value, "freeRamMb");
            return (Criteria) this;
        }

        public Criteria andFreeRamMbGreaterThanOrEqualTo(Integer value) {
            addCriterion("free_ram_mb >=", value, "freeRamMb");
            return (Criteria) this;
        }

        public Criteria andFreeRamMbLessThan(Integer value) {
            addCriterion("free_ram_mb <", value, "freeRamMb");
            return (Criteria) this;
        }

        public Criteria andFreeRamMbLessThanOrEqualTo(Integer value) {
            addCriterion("free_ram_mb <=", value, "freeRamMb");
            return (Criteria) this;
        }

        public Criteria andFreeRamMbIn(List<Integer> values) {
            addCriterion("free_ram_mb in", values, "freeRamMb");
            return (Criteria) this;
        }

        public Criteria andFreeRamMbNotIn(List<Integer> values) {
            addCriterion("free_ram_mb not in", values, "freeRamMb");
            return (Criteria) this;
        }

        public Criteria andFreeRamMbBetween(Integer value1, Integer value2) {
            addCriterion("free_ram_mb between", value1, value2, "freeRamMb");
            return (Criteria) this;
        }

        public Criteria andFreeRamMbNotBetween(Integer value1, Integer value2) {
            addCriterion("free_ram_mb not between", value1, value2, "freeRamMb");
            return (Criteria) this;
        }
    }

    /**
            * openstack_resource
            **/
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
            * openstack_resource
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