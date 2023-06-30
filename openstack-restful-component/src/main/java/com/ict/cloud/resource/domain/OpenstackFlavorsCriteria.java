package com.ict.cloud.resource.domain;

import java.util.ArrayList;
import java.util.List;

public class OpenstackFlavorsCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public OpenstackFlavorsCriteria() {
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

    public OpenstackFlavorsCriteria limit(Integer rows) {
        this.rows = rows;
        return this;
    }

    public OpenstackFlavorsCriteria limit(Integer offset, Integer rows) {
        this.offset = offset;
        this.rows = rows;
        return this;
    }

    public OpenstackFlavorsCriteria page(Integer page, Integer pageSize) {
        this.offset = (page - 1) * pageSize;
        this.rows = pageSize;
        return this;
    }

    /**
            * openstack_flavors
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

        public Criteria andFlavorTypeIsNull() {
            addCriterion("flavor_type is null");
            return (Criteria) this;
        }

        public Criteria andFlavorTypeIsNotNull() {
            addCriterion("flavor_type is not null");
            return (Criteria) this;
        }

        public Criteria andFlavorTypeEqualTo(Integer value) {
            addCriterion("flavor_type =", value, "flavorType");
            return (Criteria) this;
        }

        public Criteria andFlavorTypeNotEqualTo(Integer value) {
            addCriterion("flavor_type <>", value, "flavorType");
            return (Criteria) this;
        }

        public Criteria andFlavorTypeGreaterThan(Integer value) {
            addCriterion("flavor_type >", value, "flavorType");
            return (Criteria) this;
        }

        public Criteria andFlavorTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("flavor_type >=", value, "flavorType");
            return (Criteria) this;
        }

        public Criteria andFlavorTypeLessThan(Integer value) {
            addCriterion("flavor_type <", value, "flavorType");
            return (Criteria) this;
        }

        public Criteria andFlavorTypeLessThanOrEqualTo(Integer value) {
            addCriterion("flavor_type <=", value, "flavorType");
            return (Criteria) this;
        }

        public Criteria andFlavorTypeIn(List<Integer> values) {
            addCriterion("flavor_type in", values, "flavorType");
            return (Criteria) this;
        }

        public Criteria andFlavorTypeNotIn(List<Integer> values) {
            addCriterion("flavor_type not in", values, "flavorType");
            return (Criteria) this;
        }

        public Criteria andFlavorTypeBetween(Integer value1, Integer value2) {
            addCriterion("flavor_type between", value1, value2, "flavorType");
            return (Criteria) this;
        }

        public Criteria andFlavorTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("flavor_type not between", value1, value2, "flavorType");
            return (Criteria) this;
        }

        public Criteria andFlavorIdIsNull() {
            addCriterion("flavor_id is null");
            return (Criteria) this;
        }

        public Criteria andFlavorIdIsNotNull() {
            addCriterion("flavor_id is not null");
            return (Criteria) this;
        }

        public Criteria andFlavorIdEqualTo(String value) {
            addCriterion("flavor_id =", value, "flavorId");
            return (Criteria) this;
        }

        public Criteria andFlavorIdNotEqualTo(String value) {
            addCriterion("flavor_id <>", value, "flavorId");
            return (Criteria) this;
        }

        public Criteria andFlavorIdGreaterThan(String value) {
            addCriterion("flavor_id >", value, "flavorId");
            return (Criteria) this;
        }

        public Criteria andFlavorIdGreaterThanOrEqualTo(String value) {
            addCriterion("flavor_id >=", value, "flavorId");
            return (Criteria) this;
        }

        public Criteria andFlavorIdLessThan(String value) {
            addCriterion("flavor_id <", value, "flavorId");
            return (Criteria) this;
        }

        public Criteria andFlavorIdLessThanOrEqualTo(String value) {
            addCriterion("flavor_id <=", value, "flavorId");
            return (Criteria) this;
        }

        public Criteria andFlavorIdLike(String value) {
            addCriterion("flavor_id like", value, "flavorId");
            return (Criteria) this;
        }

        public Criteria andFlavorIdNotLike(String value) {
            addCriterion("flavor_id not like", value, "flavorId");
            return (Criteria) this;
        }

        public Criteria andFlavorIdIn(List<String> values) {
            addCriterion("flavor_id in", values, "flavorId");
            return (Criteria) this;
        }

        public Criteria andFlavorIdNotIn(List<String> values) {
            addCriterion("flavor_id not in", values, "flavorId");
            return (Criteria) this;
        }

        public Criteria andFlavorIdBetween(String value1, String value2) {
            addCriterion("flavor_id between", value1, value2, "flavorId");
            return (Criteria) this;
        }

        public Criteria andFlavorIdNotBetween(String value1, String value2) {
            addCriterion("flavor_id not between", value1, value2, "flavorId");
            return (Criteria) this;
        }

        public Criteria andFlavorRamIsNull() {
            addCriterion("flavor_ram is null");
            return (Criteria) this;
        }

        public Criteria andFlavorRamIsNotNull() {
            addCriterion("flavor_ram is not null");
            return (Criteria) this;
        }

        public Criteria andFlavorRamEqualTo(Integer value) {
            addCriterion("flavor_ram =", value, "flavorRam");
            return (Criteria) this;
        }

        public Criteria andFlavorRamNotEqualTo(Integer value) {
            addCriterion("flavor_ram <>", value, "flavorRam");
            return (Criteria) this;
        }

        public Criteria andFlavorRamGreaterThan(Integer value) {
            addCriterion("flavor_ram >", value, "flavorRam");
            return (Criteria) this;
        }

        public Criteria andFlavorRamGreaterThanOrEqualTo(Integer value) {
            addCriterion("flavor_ram >=", value, "flavorRam");
            return (Criteria) this;
        }

        public Criteria andFlavorRamLessThan(Integer value) {
            addCriterion("flavor_ram <", value, "flavorRam");
            return (Criteria) this;
        }

        public Criteria andFlavorRamLessThanOrEqualTo(Integer value) {
            addCriterion("flavor_ram <=", value, "flavorRam");
            return (Criteria) this;
        }

        public Criteria andFlavorRamIn(List<Integer> values) {
            addCriterion("flavor_ram in", values, "flavorRam");
            return (Criteria) this;
        }

        public Criteria andFlavorRamNotIn(List<Integer> values) {
            addCriterion("flavor_ram not in", values, "flavorRam");
            return (Criteria) this;
        }

        public Criteria andFlavorRamBetween(Integer value1, Integer value2) {
            addCriterion("flavor_ram between", value1, value2, "flavorRam");
            return (Criteria) this;
        }

        public Criteria andFlavorRamNotBetween(Integer value1, Integer value2) {
            addCriterion("flavor_ram not between", value1, value2, "flavorRam");
            return (Criteria) this;
        }

        public Criteria andFlavorDiskIsNull() {
            addCriterion("flavor_disk is null");
            return (Criteria) this;
        }

        public Criteria andFlavorDiskIsNotNull() {
            addCriterion("flavor_disk is not null");
            return (Criteria) this;
        }

        public Criteria andFlavorDiskEqualTo(Integer value) {
            addCriterion("flavor_disk =", value, "flavorDisk");
            return (Criteria) this;
        }

        public Criteria andFlavorDiskNotEqualTo(Integer value) {
            addCriterion("flavor_disk <>", value, "flavorDisk");
            return (Criteria) this;
        }

        public Criteria andFlavorDiskGreaterThan(Integer value) {
            addCriterion("flavor_disk >", value, "flavorDisk");
            return (Criteria) this;
        }

        public Criteria andFlavorDiskGreaterThanOrEqualTo(Integer value) {
            addCriterion("flavor_disk >=", value, "flavorDisk");
            return (Criteria) this;
        }

        public Criteria andFlavorDiskLessThan(Integer value) {
            addCriterion("flavor_disk <", value, "flavorDisk");
            return (Criteria) this;
        }

        public Criteria andFlavorDiskLessThanOrEqualTo(Integer value) {
            addCriterion("flavor_disk <=", value, "flavorDisk");
            return (Criteria) this;
        }

        public Criteria andFlavorDiskIn(List<Integer> values) {
            addCriterion("flavor_disk in", values, "flavorDisk");
            return (Criteria) this;
        }

        public Criteria andFlavorDiskNotIn(List<Integer> values) {
            addCriterion("flavor_disk not in", values, "flavorDisk");
            return (Criteria) this;
        }

        public Criteria andFlavorDiskBetween(Integer value1, Integer value2) {
            addCriterion("flavor_disk between", value1, value2, "flavorDisk");
            return (Criteria) this;
        }

        public Criteria andFlavorDiskNotBetween(Integer value1, Integer value2) {
            addCriterion("flavor_disk not between", value1, value2, "flavorDisk");
            return (Criteria) this;
        }

        public Criteria andFlavorNameIsNull() {
            addCriterion("flavor_name is null");
            return (Criteria) this;
        }

        public Criteria andFlavorNameIsNotNull() {
            addCriterion("flavor_name is not null");
            return (Criteria) this;
        }

        public Criteria andFlavorNameEqualTo(String value) {
            addCriterion("flavor_name =", value, "flavorName");
            return (Criteria) this;
        }

        public Criteria andFlavorNameNotEqualTo(String value) {
            addCriterion("flavor_name <>", value, "flavorName");
            return (Criteria) this;
        }

        public Criteria andFlavorNameGreaterThan(String value) {
            addCriterion("flavor_name >", value, "flavorName");
            return (Criteria) this;
        }

        public Criteria andFlavorNameGreaterThanOrEqualTo(String value) {
            addCriterion("flavor_name >=", value, "flavorName");
            return (Criteria) this;
        }

        public Criteria andFlavorNameLessThan(String value) {
            addCriterion("flavor_name <", value, "flavorName");
            return (Criteria) this;
        }

        public Criteria andFlavorNameLessThanOrEqualTo(String value) {
            addCriterion("flavor_name <=", value, "flavorName");
            return (Criteria) this;
        }

        public Criteria andFlavorNameLike(String value) {
            addCriterion("flavor_name like", value, "flavorName");
            return (Criteria) this;
        }

        public Criteria andFlavorNameNotLike(String value) {
            addCriterion("flavor_name not like", value, "flavorName");
            return (Criteria) this;
        }

        public Criteria andFlavorNameIn(List<String> values) {
            addCriterion("flavor_name in", values, "flavorName");
            return (Criteria) this;
        }

        public Criteria andFlavorNameNotIn(List<String> values) {
            addCriterion("flavor_name not in", values, "flavorName");
            return (Criteria) this;
        }

        public Criteria andFlavorNameBetween(String value1, String value2) {
            addCriterion("flavor_name between", value1, value2, "flavorName");
            return (Criteria) this;
        }

        public Criteria andFlavorNameNotBetween(String value1, String value2) {
            addCriterion("flavor_name not between", value1, value2, "flavorName");
            return (Criteria) this;
        }

        public Criteria andFlavorVcpuIsNull() {
            addCriterion("flavor_vcpu is null");
            return (Criteria) this;
        }

        public Criteria andFlavorVcpuIsNotNull() {
            addCriterion("flavor_vcpu is not null");
            return (Criteria) this;
        }

        public Criteria andFlavorVcpuEqualTo(Integer value) {
            addCriterion("flavor_vcpu =", value, "flavorVcpu");
            return (Criteria) this;
        }

        public Criteria andFlavorVcpuNotEqualTo(Integer value) {
            addCriterion("flavor_vcpu <>", value, "flavorVcpu");
            return (Criteria) this;
        }

        public Criteria andFlavorVcpuGreaterThan(Integer value) {
            addCriterion("flavor_vcpu >", value, "flavorVcpu");
            return (Criteria) this;
        }

        public Criteria andFlavorVcpuGreaterThanOrEqualTo(Integer value) {
            addCriterion("flavor_vcpu >=", value, "flavorVcpu");
            return (Criteria) this;
        }

        public Criteria andFlavorVcpuLessThan(Integer value) {
            addCriterion("flavor_vcpu <", value, "flavorVcpu");
            return (Criteria) this;
        }

        public Criteria andFlavorVcpuLessThanOrEqualTo(Integer value) {
            addCriterion("flavor_vcpu <=", value, "flavorVcpu");
            return (Criteria) this;
        }

        public Criteria andFlavorVcpuIn(List<Integer> values) {
            addCriterion("flavor_vcpu in", values, "flavorVcpu");
            return (Criteria) this;
        }

        public Criteria andFlavorVcpuNotIn(List<Integer> values) {
            addCriterion("flavor_vcpu not in", values, "flavorVcpu");
            return (Criteria) this;
        }

        public Criteria andFlavorVcpuBetween(Integer value1, Integer value2) {
            addCriterion("flavor_vcpu between", value1, value2, "flavorVcpu");
            return (Criteria) this;
        }

        public Criteria andFlavorVcpuNotBetween(Integer value1, Integer value2) {
            addCriterion("flavor_vcpu not between", value1, value2, "flavorVcpu");
            return (Criteria) this;
        }

        public Criteria andExtraSpecsIsNull() {
            addCriterion("extra_specs is null");
            return (Criteria) this;
        }

        public Criteria andExtraSpecsIsNotNull() {
            addCriterion("extra_specs is not null");
            return (Criteria) this;
        }

        public Criteria andExtraSpecsEqualTo(String value) {
            addCriterion("extra_specs =", value, "extraSpecs");
            return (Criteria) this;
        }

        public Criteria andExtraSpecsNotEqualTo(String value) {
            addCriterion("extra_specs <>", value, "extraSpecs");
            return (Criteria) this;
        }

        public Criteria andExtraSpecsGreaterThan(String value) {
            addCriterion("extra_specs >", value, "extraSpecs");
            return (Criteria) this;
        }

        public Criteria andExtraSpecsGreaterThanOrEqualTo(String value) {
            addCriterion("extra_specs >=", value, "extraSpecs");
            return (Criteria) this;
        }

        public Criteria andExtraSpecsLessThan(String value) {
            addCriterion("extra_specs <", value, "extraSpecs");
            return (Criteria) this;
        }

        public Criteria andExtraSpecsLessThanOrEqualTo(String value) {
            addCriterion("extra_specs <=", value, "extraSpecs");
            return (Criteria) this;
        }

        public Criteria andExtraSpecsLike(String value) {
            addCriterion("extra_specs like", value, "extraSpecs");
            return (Criteria) this;
        }

        public Criteria andExtraSpecsNotLike(String value) {
            addCriterion("extra_specs not like", value, "extraSpecs");
            return (Criteria) this;
        }

        public Criteria andExtraSpecsIn(List<String> values) {
            addCriterion("extra_specs in", values, "extraSpecs");
            return (Criteria) this;
        }

        public Criteria andExtraSpecsNotIn(List<String> values) {
            addCriterion("extra_specs not in", values, "extraSpecs");
            return (Criteria) this;
        }

        public Criteria andExtraSpecsBetween(String value1, String value2) {
            addCriterion("extra_specs between", value1, value2, "extraSpecs");
            return (Criteria) this;
        }

        public Criteria andExtraSpecsNotBetween(String value1, String value2) {
            addCriterion("extra_specs not between", value1, value2, "extraSpecs");
            return (Criteria) this;
        }
    }

    /**
            * openstack_flavors
            **/
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
            * openstack_flavors
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