package com.ict.cloud.resource.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpenstackNetworksCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public OpenstackNetworksCriteria() {
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

    public OpenstackNetworksCriteria limit(Integer rows) {
        this.rows = rows;
        return this;
    }

    public OpenstackNetworksCriteria limit(Integer offset, Integer rows) {
        this.offset = offset;
        this.rows = rows;
        return this;
    }

    public OpenstackNetworksCriteria page(Integer page, Integer pageSize) {
        this.offset = (page - 1) * pageSize;
        this.rows = pageSize;
        return this;
    }

    /**
     * openstack_networks
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

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(String value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(String value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(String value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(String value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(String value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLike(String value) {
            addCriterion("project_id like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotLike(String value) {
            addCriterion("project_id not like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<String> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<String> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(String value1, String value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(String value1, String value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andNetworkIdIsNull() {
            addCriterion("network_id is null");
            return (Criteria) this;
        }

        public Criteria andNetworkIdIsNotNull() {
            addCriterion("network_id is not null");
            return (Criteria) this;
        }

        public Criteria andNetworkIdEqualTo(String value) {
            addCriterion("network_id =", value, "networkId");
            return (Criteria) this;
        }

        public Criteria andNetworkIdNotEqualTo(String value) {
            addCriterion("network_id <>", value, "networkId");
            return (Criteria) this;
        }

        public Criteria andNetworkIdGreaterThan(String value) {
            addCriterion("network_id >", value, "networkId");
            return (Criteria) this;
        }

        public Criteria andNetworkIdGreaterThanOrEqualTo(String value) {
            addCriterion("network_id >=", value, "networkId");
            return (Criteria) this;
        }

        public Criteria andNetworkIdLessThan(String value) {
            addCriterion("network_id <", value, "networkId");
            return (Criteria) this;
        }

        public Criteria andNetworkIdLessThanOrEqualTo(String value) {
            addCriterion("network_id <=", value, "networkId");
            return (Criteria) this;
        }

        public Criteria andNetworkIdLike(String value) {
            addCriterion("network_id like", value, "networkId");
            return (Criteria) this;
        }

        public Criteria andNetworkIdNotLike(String value) {
            addCriterion("network_id not like", value, "networkId");
            return (Criteria) this;
        }

        public Criteria andNetworkIdIn(List<String> values) {
            addCriterion("network_id in", values, "networkId");
            return (Criteria) this;
        }

        public Criteria andNetworkIdNotIn(List<String> values) {
            addCriterion("network_id not in", values, "networkId");
            return (Criteria) this;
        }

        public Criteria andNetworkIdBetween(String value1, String value2) {
            addCriterion("network_id between", value1, value2, "networkId");
            return (Criteria) this;
        }

        public Criteria andNetworkIdNotBetween(String value1, String value2) {
            addCriterion("network_id not between", value1, value2, "networkId");
            return (Criteria) this;
        }

        public Criteria andAdminStateUpIsNull() {
            addCriterion("admin_state_up is null");
            return (Criteria) this;
        }

        public Criteria andAdminStateUpIsNotNull() {
            addCriterion("admin_state_up is not null");
            return (Criteria) this;
        }

        public Criteria andAdminStateUpEqualTo(Boolean value) {
            addCriterion("admin_state_up =", value, "adminStateUp");
            return (Criteria) this;
        }

        public Criteria andAdminStateUpNotEqualTo(Boolean value) {
            addCriterion("admin_state_up <>", value, "adminStateUp");
            return (Criteria) this;
        }

        public Criteria andAdminStateUpGreaterThan(Boolean value) {
            addCriterion("admin_state_up >", value, "adminStateUp");
            return (Criteria) this;
        }

        public Criteria andAdminStateUpGreaterThanOrEqualTo(Boolean value) {
            addCriterion("admin_state_up >=", value, "adminStateUp");
            return (Criteria) this;
        }

        public Criteria andAdminStateUpLessThan(Boolean value) {
            addCriterion("admin_state_up <", value, "adminStateUp");
            return (Criteria) this;
        }

        public Criteria andAdminStateUpLessThanOrEqualTo(Boolean value) {
            addCriterion("admin_state_up <=", value, "adminStateUp");
            return (Criteria) this;
        }

        public Criteria andAdminStateUpIn(List<Boolean> values) {
            addCriterion("admin_state_up in", values, "adminStateUp");
            return (Criteria) this;
        }

        public Criteria andAdminStateUpNotIn(List<Boolean> values) {
            addCriterion("admin_state_up not in", values, "adminStateUp");
            return (Criteria) this;
        }

        public Criteria andAdminStateUpBetween(Boolean value1, Boolean value2) {
            addCriterion("admin_state_up between", value1, value2, "adminStateUp");
            return (Criteria) this;
        }

        public Criteria andAdminStateUpNotBetween(Boolean value1, Boolean value2) {
            addCriterion("admin_state_up not between", value1, value2, "adminStateUp");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNull() {
            addCriterion("create_at is null");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNotNull() {
            addCriterion("create_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreateAtEqualTo(Date value) {
            addCriterion("create_at =", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotEqualTo(Date value) {
            addCriterion("create_at <>", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThan(Date value) {
            addCriterion("create_at >", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("create_at >=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThan(Date value) {
            addCriterion("create_at <", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThanOrEqualTo(Date value) {
            addCriterion("create_at <=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtIn(List<Date> values) {
            addCriterion("create_at in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotIn(List<Date> values) {
            addCriterion("create_at not in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtBetween(Date value1, Date value2) {
            addCriterion("create_at between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotBetween(Date value1, Date value2) {
            addCriterion("create_at not between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(Date value) {
            addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(Date value) {
            addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(Date value) {
            addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(Date value) {
            addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(Date value) {
            addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<Date> values) {
            addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<Date> values) {
            addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(Date value1, Date value2) {
            addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(Date value1, Date value2) {
            addCriterion("updated_at not between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andDsnDomainIsNull() {
            addCriterion("dsn_domain is null");
            return (Criteria) this;
        }

        public Criteria andDsnDomainIsNotNull() {
            addCriterion("dsn_domain is not null");
            return (Criteria) this;
        }

        public Criteria andDsnDomainEqualTo(String value) {
            addCriterion("dsn_domain =", value, "dsnDomain");
            return (Criteria) this;
        }

        public Criteria andDsnDomainNotEqualTo(String value) {
            addCriterion("dsn_domain <>", value, "dsnDomain");
            return (Criteria) this;
        }

        public Criteria andDsnDomainGreaterThan(String value) {
            addCriterion("dsn_domain >", value, "dsnDomain");
            return (Criteria) this;
        }

        public Criteria andDsnDomainGreaterThanOrEqualTo(String value) {
            addCriterion("dsn_domain >=", value, "dsnDomain");
            return (Criteria) this;
        }

        public Criteria andDsnDomainLessThan(String value) {
            addCriterion("dsn_domain <", value, "dsnDomain");
            return (Criteria) this;
        }

        public Criteria andDsnDomainLessThanOrEqualTo(String value) {
            addCriterion("dsn_domain <=", value, "dsnDomain");
            return (Criteria) this;
        }

        public Criteria andDsnDomainLike(String value) {
            addCriterion("dsn_domain like", value, "dsnDomain");
            return (Criteria) this;
        }

        public Criteria andDsnDomainNotLike(String value) {
            addCriterion("dsn_domain not like", value, "dsnDomain");
            return (Criteria) this;
        }

        public Criteria andDsnDomainIn(List<String> values) {
            addCriterion("dsn_domain in", values, "dsnDomain");
            return (Criteria) this;
        }

        public Criteria andDsnDomainNotIn(List<String> values) {
            addCriterion("dsn_domain not in", values, "dsnDomain");
            return (Criteria) this;
        }

        public Criteria andDsnDomainBetween(String value1, String value2) {
            addCriterion("dsn_domain between", value1, value2, "dsnDomain");
            return (Criteria) this;
        }

        public Criteria andDsnDomainNotBetween(String value1, String value2) {
            addCriterion("dsn_domain not between", value1, value2, "dsnDomain");
            return (Criteria) this;
        }

        public Criteria andNetworkNameIsNull() {
            addCriterion("network_name is null");
            return (Criteria) this;
        }

        public Criteria andNetworkNameIsNotNull() {
            addCriterion("network_name is not null");
            return (Criteria) this;
        }

        public Criteria andNetworkNameEqualTo(String value) {
            addCriterion("network_name =", value, "networkName");
            return (Criteria) this;
        }

        public Criteria andNetworkNameNotEqualTo(String value) {
            addCriterion("network_name <>", value, "networkName");
            return (Criteria) this;
        }

        public Criteria andNetworkNameGreaterThan(String value) {
            addCriterion("network_name >", value, "networkName");
            return (Criteria) this;
        }

        public Criteria andNetworkNameGreaterThanOrEqualTo(String value) {
            addCriterion("network_name >=", value, "networkName");
            return (Criteria) this;
        }

        public Criteria andNetworkNameLessThan(String value) {
            addCriterion("network_name <", value, "networkName");
            return (Criteria) this;
        }

        public Criteria andNetworkNameLessThanOrEqualTo(String value) {
            addCriterion("network_name <=", value, "networkName");
            return (Criteria) this;
        }

        public Criteria andNetworkNameLike(String value) {
            addCriterion("network_name like", value, "networkName");
            return (Criteria) this;
        }

        public Criteria andNetworkNameNotLike(String value) {
            addCriterion("network_name not like", value, "networkName");
            return (Criteria) this;
        }

        public Criteria andNetworkNameIn(List<String> values) {
            addCriterion("network_name in", values, "networkName");
            return (Criteria) this;
        }

        public Criteria andNetworkNameNotIn(List<String> values) {
            addCriterion("network_name not in", values, "networkName");
            return (Criteria) this;
        }

        public Criteria andNetworkNameBetween(String value1, String value2) {
            addCriterion("network_name between", value1, value2, "networkName");
            return (Criteria) this;
        }

        public Criteria andNetworkNameNotBetween(String value1, String value2) {
            addCriterion("network_name not between", value1, value2, "networkName");
            return (Criteria) this;
        }

        public Criteria andNetworkTypeIsNull() {
            addCriterion("network_type is null");
            return (Criteria) this;
        }

        public Criteria andNetworkTypeIsNotNull() {
            addCriterion("network_type is not null");
            return (Criteria) this;
        }

        public Criteria andNetworkTypeEqualTo(String value) {
            addCriterion("network_type =", value, "networkType");
            return (Criteria) this;
        }

        public Criteria andNetworkTypeNotEqualTo(String value) {
            addCriterion("network_type <>", value, "networkType");
            return (Criteria) this;
        }

        public Criteria andNetworkTypeGreaterThan(String value) {
            addCriterion("network_type >", value, "networkType");
            return (Criteria) this;
        }

        public Criteria andNetworkTypeGreaterThanOrEqualTo(String value) {
            addCriterion("network_type >=", value, "networkType");
            return (Criteria) this;
        }

        public Criteria andNetworkTypeLessThan(String value) {
            addCriterion("network_type <", value, "networkType");
            return (Criteria) this;
        }

        public Criteria andNetworkTypeLessThanOrEqualTo(String value) {
            addCriterion("network_type <=", value, "networkType");
            return (Criteria) this;
        }

        public Criteria andNetworkTypeLike(String value) {
            addCriterion("network_type like", value, "networkType");
            return (Criteria) this;
        }

        public Criteria andNetworkTypeNotLike(String value) {
            addCriterion("network_type not like", value, "networkType");
            return (Criteria) this;
        }

        public Criteria andNetworkTypeIn(List<String> values) {
            addCriterion("network_type in", values, "networkType");
            return (Criteria) this;
        }

        public Criteria andNetworkTypeNotIn(List<String> values) {
            addCriterion("network_type not in", values, "networkType");
            return (Criteria) this;
        }

        public Criteria andNetworkTypeBetween(String value1, String value2) {
            addCriterion("network_type between", value1, value2, "networkType");
            return (Criteria) this;
        }

        public Criteria andNetworkTypeNotBetween(String value1, String value2) {
            addCriterion("network_type not between", value1, value2, "networkType");
            return (Criteria) this;
        }

        public Criteria andSharedIsNull() {
            addCriterion("shared is null");
            return (Criteria) this;
        }

        public Criteria andSharedIsNotNull() {
            addCriterion("shared is not null");
            return (Criteria) this;
        }

        public Criteria andSharedEqualTo(Boolean value) {
            addCriterion("shared =", value, "shared");
            return (Criteria) this;
        }

        public Criteria andSharedNotEqualTo(Boolean value) {
            addCriterion("shared <>", value, "shared");
            return (Criteria) this;
        }

        public Criteria andSharedGreaterThan(Boolean value) {
            addCriterion("shared >", value, "shared");
            return (Criteria) this;
        }

        public Criteria andSharedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("shared >=", value, "shared");
            return (Criteria) this;
        }

        public Criteria andSharedLessThan(Boolean value) {
            addCriterion("shared <", value, "shared");
            return (Criteria) this;
        }

        public Criteria andSharedLessThanOrEqualTo(Boolean value) {
            addCriterion("shared <=", value, "shared");
            return (Criteria) this;
        }

        public Criteria andSharedIn(List<Boolean> values) {
            addCriterion("shared in", values, "shared");
            return (Criteria) this;
        }

        public Criteria andSharedNotIn(List<Boolean> values) {
            addCriterion("shared not in", values, "shared");
            return (Criteria) this;
        }

        public Criteria andSharedBetween(Boolean value1, Boolean value2) {
            addCriterion("shared between", value1, value2, "shared");
            return (Criteria) this;
        }

        public Criteria andSharedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("shared not between", value1, value2, "shared");
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

        public Criteria andIsDefaultIsNull() {
            addCriterion("is_default is null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNotNull() {
            addCriterion("is_default is not null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultEqualTo(Boolean value) {
            addCriterion("is_default =", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotEqualTo(Boolean value) {
            addCriterion("is_default <>", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThan(Boolean value) {
            addCriterion("is_default >", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_default >=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThan(Boolean value) {
            addCriterion("is_default <", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThanOrEqualTo(Boolean value) {
            addCriterion("is_default <=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIn(List<Boolean> values) {
            addCriterion("is_default in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotIn(List<Boolean> values) {
            addCriterion("is_default not in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultBetween(Boolean value1, Boolean value2) {
            addCriterion("is_default between", value1, value2, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_default not between", value1, value2, "isDefault");
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

        public Criteria andSegmentationIdIsNull() {
            addCriterion("segmentation_id is null");
            return (Criteria) this;
        }

        public Criteria andSegmentationIdIsNotNull() {
            addCriterion("segmentation_id is not null");
            return (Criteria) this;
        }

        public Criteria andSegmentationIdEqualTo(Integer value) {
            addCriterion("segmentation_id =", value, "segmentationId");
            return (Criteria) this;
        }

        public Criteria andSegmentationIdNotEqualTo(Integer value) {
            addCriterion("segmentation_id <>", value, "segmentationId");
            return (Criteria) this;
        }

        public Criteria andSegmentationIdGreaterThan(Integer value) {
            addCriterion("segmentation_id >", value, "segmentationId");
            return (Criteria) this;
        }

        public Criteria andSegmentationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("segmentation_id >=", value, "segmentationId");
            return (Criteria) this;
        }

        public Criteria andSegmentationIdLessThan(Integer value) {
            addCriterion("segmentation_id <", value, "segmentationId");
            return (Criteria) this;
        }

        public Criteria andSegmentationIdLessThanOrEqualTo(Integer value) {
            addCriterion("segmentation_id <=", value, "segmentationId");
            return (Criteria) this;
        }

        public Criteria andSegmentationIdIn(List<Integer> values) {
            addCriterion("segmentation_id in", values, "segmentationId");
            return (Criteria) this;
        }

        public Criteria andSegmentationIdNotIn(List<Integer> values) {
            addCriterion("segmentation_id not in", values, "segmentationId");
            return (Criteria) this;
        }

        public Criteria andSegmentationIdBetween(Integer value1, Integer value2) {
            addCriterion("segmentation_id between", value1, value2, "segmentationId");
            return (Criteria) this;
        }

        public Criteria andSegmentationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("segmentation_id not between", value1, value2, "segmentationId");
            return (Criteria) this;
        }
    }

    /**
     * openstack_networks
     **/
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * openstack_networks
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