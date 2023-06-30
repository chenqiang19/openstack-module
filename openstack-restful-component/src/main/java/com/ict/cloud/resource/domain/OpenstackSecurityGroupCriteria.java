package com.ict.cloud.resource.domain;

import java.util.ArrayList;
import java.util.List;

public class OpenstackSecurityGroupCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public OpenstackSecurityGroupCriteria() {
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

    public OpenstackSecurityGroupCriteria limit(Integer rows) {
        this.rows = rows;
        return this;
    }

    public OpenstackSecurityGroupCriteria limit(Integer offset, Integer rows) {
        this.offset = offset;
        this.rows = rows;
        return this;
    }

    public OpenstackSecurityGroupCriteria page(Integer page, Integer pageSize) {
        this.offset = (page - 1) * pageSize;
        this.rows = pageSize;
        return this;
    }

    /**
            * openstack_security_group
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

        public Criteria andTemplateNameIsNull() {
            addCriterion("template_name is null");
            return (Criteria) this;
        }

        public Criteria andTemplateNameIsNotNull() {
            addCriterion("template_name is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateNameEqualTo(String value) {
            addCriterion("template_name =", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotEqualTo(String value) {
            addCriterion("template_name <>", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameGreaterThan(String value) {
            addCriterion("template_name >", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameGreaterThanOrEqualTo(String value) {
            addCriterion("template_name >=", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameLessThan(String value) {
            addCriterion("template_name <", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameLessThanOrEqualTo(String value) {
            addCriterion("template_name <=", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameIn(List<String> values) {
            addCriterion("template_name in", values, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotIn(List<String> values) {
            addCriterion("template_name not in", values, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameBetween(String value1, String value2) {
            addCriterion("template_name between", value1, value2, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotBetween(String value1, String value2) {
            addCriterion("template_name not between", value1, value2, "templateName");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupIdIsNull() {
            addCriterion("security_group_id is null");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupIdIsNotNull() {
            addCriterion("security_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupIdEqualTo(String value) {
            addCriterion("security_group_id =", value, "securityGroupId");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupIdNotEqualTo(String value) {
            addCriterion("security_group_id <>", value, "securityGroupId");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupIdGreaterThan(String value) {
            addCriterion("security_group_id >", value, "securityGroupId");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("security_group_id >=", value, "securityGroupId");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupIdLessThan(String value) {
            addCriterion("security_group_id <", value, "securityGroupId");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupIdLessThanOrEqualTo(String value) {
            addCriterion("security_group_id <=", value, "securityGroupId");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupIdLike(String value) {
            addCriterion("security_group_id like", value, "securityGroupId");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupIdNotLike(String value) {
            addCriterion("security_group_id not like", value, "securityGroupId");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupIdIn(List<String> values) {
            addCriterion("security_group_id in", values, "securityGroupId");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupIdNotIn(List<String> values) {
            addCriterion("security_group_id not in", values, "securityGroupId");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupIdBetween(String value1, String value2) {
            addCriterion("security_group_id between", value1, value2, "securityGroupId");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupIdNotBetween(String value1, String value2) {
            addCriterion("security_group_id not between", value1, value2, "securityGroupId");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupNameIsNull() {
            addCriterion("security_group_name is null");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupNameIsNotNull() {
            addCriterion("security_group_name is not null");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupNameEqualTo(String value) {
            addCriterion("security_group_name =", value, "securityGroupName");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupNameNotEqualTo(String value) {
            addCriterion("security_group_name <>", value, "securityGroupName");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupNameGreaterThan(String value) {
            addCriterion("security_group_name >", value, "securityGroupName");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("security_group_name >=", value, "securityGroupName");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupNameLessThan(String value) {
            addCriterion("security_group_name <", value, "securityGroupName");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupNameLessThanOrEqualTo(String value) {
            addCriterion("security_group_name <=", value, "securityGroupName");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupNameLike(String value) {
            addCriterion("security_group_name like", value, "securityGroupName");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupNameNotLike(String value) {
            addCriterion("security_group_name not like", value, "securityGroupName");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupNameIn(List<String> values) {
            addCriterion("security_group_name in", values, "securityGroupName");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupNameNotIn(List<String> values) {
            addCriterion("security_group_name not in", values, "securityGroupName");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupNameBetween(String value1, String value2) {
            addCriterion("security_group_name between", value1, value2, "securityGroupName");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupNameNotBetween(String value1, String value2) {
            addCriterion("security_group_name not between", value1, value2, "securityGroupName");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupTenantIdIsNull() {
            addCriterion("security_group_tenant_id is null");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupTenantIdIsNotNull() {
            addCriterion("security_group_tenant_id is not null");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupTenantIdEqualTo(Integer value) {
            addCriterion("security_group_tenant_id =", value, "securityGroupTenantId");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupTenantIdNotEqualTo(Integer value) {
            addCriterion("security_group_tenant_id <>", value, "securityGroupTenantId");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupTenantIdGreaterThan(Integer value) {
            addCriterion("security_group_tenant_id >", value, "securityGroupTenantId");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupTenantIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("security_group_tenant_id >=", value, "securityGroupTenantId");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupTenantIdLessThan(Integer value) {
            addCriterion("security_group_tenant_id <", value, "securityGroupTenantId");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupTenantIdLessThanOrEqualTo(Integer value) {
            addCriterion("security_group_tenant_id <=", value, "securityGroupTenantId");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupTenantIdLike(Integer value) {
            addCriterion("security_group_tenant_id like", value, "securityGroupTenantId");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupTenantIdNotLike(Integer value) {
            addCriterion("security_group_tenant_id not like", value, "securityGroupTenantId");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupTenantIdIn(List<Integer> values) {
            addCriterion("security_group_tenant_id in", values, "securityGroupTenantId");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupTenantIdNotIn(List<Integer> values) {
            addCriterion("security_group_tenant_id not in", values, "securityGroupTenantId");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupTenantIdBetween(Integer value1, Integer value2) {
            addCriterion("security_group_tenant_id between", value1, value2, "securityGroupTenantId");
            return (Criteria) this;
        }

        public Criteria andSecurityGroupTenantIdNotBetween(Integer value1, Integer value2) {
            addCriterion("security_group_tenant_id not between", value1, value2, "securityGroupTenantId");
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

        public Criteria andtenantIdGreaterThan(Integer value) {
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
    }

    /**
            * openstack_security_group
            **/
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
            * openstack_security_group
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