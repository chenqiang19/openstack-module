package com.ict.cloud.resource.domain;

import java.util.ArrayList;
import java.util.List;

public class OpenstackFloatipsCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public OpenstackFloatipsCriteria() {
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

    public OpenstackFloatipsCriteria limit(Integer rows) {
        this.rows = rows;
        return this;
    }

    public OpenstackFloatipsCriteria limit(Integer offset, Integer rows) {
        this.offset = offset;
        this.rows = rows;
        return this;
    }

    public OpenstackFloatipsCriteria page(Integer page, Integer pageSize) {
        this.offset = (page - 1) * pageSize;
        this.rows = pageSize;
        return this;
    }

    /**
     * openstack_floatips
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

        public Criteria andFloatipIdIsNull() {
            addCriterion("floatip_ip is null");
            return (Criteria) this;
        }

        public Criteria andFloatipIdIsNotNull() {
            addCriterion("floatip_ip is not null");
            return (Criteria) this;
        }

        public Criteria andFloatipIdEqualTo(String value) {
            addCriterion("floatip_ip =", value, "floatipId");
            return (Criteria) this;
        }

        public Criteria andFloatipIdNotEqualTo(String value) {
            addCriterion("floatip_ip <>", value, "floatipId");
            return (Criteria) this;
        }

        public Criteria andFloatipIdGreaterThan(String value) {
            addCriterion("floatip_ip >", value, "floatipId");
            return (Criteria) this;
        }

        public Criteria andFloatipIdGreaterThanOrEqualTo(String value) {
            addCriterion("floatip_ip >=", value, "floatipId");
            return (Criteria) this;
        }

        public Criteria andFloatipIdLessThan(String value) {
            addCriterion("floatip_ip <", value, "floatipId");
            return (Criteria) this;
        }

        public Criteria andFloatipIdLessThanOrEqualTo(String value) {
            addCriterion("floatip_ip <=", value, "floatipId");
            return (Criteria) this;
        }

        public Criteria andFloatipIdLike(String value) {
            addCriterion("floatip_ip like", value, "floatipId");
            return (Criteria) this;
        }

        public Criteria andFloatipIdNotLike(String value) {
            addCriterion("floatip_ip not like", value, "floatipId");
            return (Criteria) this;
        }

        public Criteria andFloatipIdIn(List<String> values) {
            addCriterion("floatip_ip in", values, "floatipId");
            return (Criteria) this;
        }

        public Criteria andFloatipIdNotIn(List<String> values) {
            addCriterion("floatip_ip not in", values, "floatipId");
            return (Criteria) this;
        }

        public Criteria andFloatipIdBetween(String value1, String value2) {
            addCriterion("floatip_ip between", value1, value2, "floatipId");
            return (Criteria) this;
        }

        public Criteria andFloatipIdNotBetween(String value1, String value2) {
            addCriterion("floatip_ip not between", value1, value2, "floatipId");
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

        public Criteria andTenantIdIsNull() {
            addCriterion("tenant_id is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("tenant_id is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(Integer value) {
            addCriterion("tenant_id =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(Integer value) {
            addCriterion("tenant_id <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(Integer value) {
            addCriterion("tenant_id >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tenant_id >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(Integer value) {
            addCriterion("tenant_id <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(Integer value) {
            addCriterion("tenant_id <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLike(Integer value) {
            addCriterion("tenant_id like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotLike(Integer value) {
            addCriterion("tenant_id not like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<Integer> values) {
            addCriterion("tenant_id in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<Integer> values) {
            addCriterion("tenant_id not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(Integer value1, Integer value2) {
            addCriterion("tenant_id between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tenant_id not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andFloatNetworkIdIsNull() {
            addCriterion("float_network_id is null");
            return (Criteria) this;
        }

        public Criteria andFloatNetworkIdIsNotNull() {
            addCriterion("float_network_id is not null");
            return (Criteria) this;
        }

        public Criteria andFloatNetworkIdEqualTo(String value) {
            addCriterion("float_network_id =", value, "floatNetworkId");
            return (Criteria) this;
        }

        public Criteria andFloatNetworkIdNotEqualTo(String value) {
            addCriterion("float_network_id <>", value, "floatNetworkId");
            return (Criteria) this;
        }

        public Criteria andFloatNetworkIdGreaterThan(String value) {
            addCriterion("float_network_id >", value, "floatNetworkId");
            return (Criteria) this;
        }

        public Criteria andFloatNetworkIdGreaterThanOrEqualTo(String value) {
            addCriterion("float_network_id >=", value, "floatNetworkId");
            return (Criteria) this;
        }

        public Criteria andFloatNetworkIdLessThan(String value) {
            addCriterion("float_network_id <", value, "floatNetworkId");
            return (Criteria) this;
        }

        public Criteria andFloatNetworkIdLessThanOrEqualTo(String value) {
            addCriterion("float_network_id <=", value, "floatNetworkId");
            return (Criteria) this;
        }

        public Criteria andFloatNetworkIdLike(String value) {
            addCriterion("float_network_id like", value, "floatNetworkId");
            return (Criteria) this;
        }

        public Criteria andFloatNetworkIdNotLike(String value) {
            addCriterion("float_network_id not like", value, "floatNetworkId");
            return (Criteria) this;
        }

        public Criteria andFloatNetworkIdIn(List<String> values) {
            addCriterion("float_network_id in", values, "floatNetworkId");
            return (Criteria) this;
        }

        public Criteria andFloatNetworkIdNotIn(List<String> values) {
            addCriterion("float_network_id not in", values, "floatNetworkId");
            return (Criteria) this;
        }

        public Criteria andFloatNetworkIdBetween(String value1, String value2) {
            addCriterion("float_network_id between", value1, value2, "floatNetworkId");
            return (Criteria) this;
        }

        public Criteria andFloatNetworkIdNotBetween(String value1, String value2) {
            addCriterion("float_network_id not between", value1, value2, "floatNetworkId");
            return (Criteria) this;
        }

        public Criteria andFixedIpAddressIsNull() {
            addCriterion("fixed_ip_address is null");
            return (Criteria) this;
        }

        public Criteria andFixedIpAddressIsNotNull() {
            addCriterion("fixed_ip_address is not null");
            return (Criteria) this;
        }

        public Criteria andFixedIpAddressEqualTo(String value) {
            addCriterion("fixed_ip_address =", value, "fixedIpAddress");
            return (Criteria) this;
        }

        public Criteria andFixedIpAddressNotEqualTo(String value) {
            addCriterion("fixed_ip_address <>", value, "fixedIpAddress");
            return (Criteria) this;
        }

        public Criteria andFixedIpAddressGreaterThan(String value) {
            addCriterion("fixed_ip_address >", value, "fixedIpAddress");
            return (Criteria) this;
        }

        public Criteria andFixedIpAddressGreaterThanOrEqualTo(String value) {
            addCriterion("fixed_ip_address >=", value, "fixedIpAddress");
            return (Criteria) this;
        }

        public Criteria andFixedIpAddressLessThan(String value) {
            addCriterion("fixed_ip_address <", value, "fixedIpAddress");
            return (Criteria) this;
        }

        public Criteria andFixedIpAddressLessThanOrEqualTo(String value) {
            addCriterion("fixed_ip_address <=", value, "fixedIpAddress");
            return (Criteria) this;
        }

        public Criteria andFixedIpAddressLike(String value) {
            addCriterion("fixed_ip_address like", value, "fixedIpAddress");
            return (Criteria) this;
        }

        public Criteria andFixedIpAddressNotLike(String value) {
            addCriterion("fixed_ip_address not like", value, "fixedIpAddress");
            return (Criteria) this;
        }

        public Criteria andFixedIpAddressIn(List<String> values) {
            addCriterion("fixed_ip_address in", values, "fixedIpAddress");
            return (Criteria) this;
        }

        public Criteria andFixedIpAddressNotIn(List<String> values) {
            addCriterion("fixed_ip_address not in", values, "fixedIpAddress");
            return (Criteria) this;
        }

        public Criteria andFixedIpAddressBetween(String value1, String value2) {
            addCriterion("fixed_ip_address between", value1, value2, "fixedIpAddress");
            return (Criteria) this;
        }

        public Criteria andFixedIpAddressNotBetween(String value1, String value2) {
            addCriterion("fixed_ip_address not between", value1, value2, "fixedIpAddress");
            return (Criteria) this;
        }

        public Criteria andDetailIdIsNull() {
            addCriterion("detail_id is null");
            return (Criteria) this;
        }

        public Criteria andDetailIdIsNotNull() {
            addCriterion("detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andDetailIdEqualTo(Integer value) {
            addCriterion("detail_id =", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotEqualTo(Integer value) {
            addCriterion("detail_id <>", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdGreaterThan(Integer value) {
            addCriterion("detail_id >", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("detail_id >=", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLessThan(Integer value) {
            addCriterion("detail_id <", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLessThanOrEqualTo(Integer value) {
            addCriterion("detail_id <=", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLike(Integer value) {
            addCriterion("detail_id like", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotLike(Integer value) {
            addCriterion("detail_id not like", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdIn(List<Integer> values) {
            addCriterion("detail_id in", values, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotIn(List<Integer> values) {
            addCriterion("detail_id not in", values, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdBetween(Integer value1, Integer value2) {
            addCriterion("detail_id between", value1, value2, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("detail_id not between", value1, value2, "detailId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id>=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }
    }

    /**
     * openstack_floatips
     **/
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * openstack_floatips
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
