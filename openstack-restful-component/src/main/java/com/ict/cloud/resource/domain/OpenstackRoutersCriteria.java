package com.ict.cloud.resource.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpenstackRoutersCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public OpenstackRoutersCriteria() {
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

    public OpenstackRoutersCriteria limit(Integer rows) {
        this.rows = rows;
        return this;
    }

    public OpenstackRoutersCriteria limit(Integer offset, Integer rows) {
        this.offset = offset;
        this.rows = rows;
        return this;
    }

    public OpenstackRoutersCriteria page(Integer page, Integer pageSize) {
        this.offset = (page - 1) * pageSize;
        this.rows = pageSize;
        return this;
    }

    /**
     * openstack_routers
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

        public Criteria andRouterIdIsNull() {
            addCriterion("router_id is null");
            return (Criteria) this;
        }

        public Criteria andRouterIdIsNotNull() {
            addCriterion("router_id is not null");
            return (Criteria) this;
        }

        public Criteria andRouterIdEqualTo(String value) {
            addCriterion("router_id =", value, "routerId");
            return (Criteria) this;
        }

        public Criteria andRouterIdNotEqualTo(String value) {
            addCriterion("router_id <>", value, "routerId");
            return (Criteria) this;
        }

        public Criteria andRouterIdGreaterThan(String value) {
            addCriterion("router_id >", value, "routerId");
            return (Criteria) this;
        }

        public Criteria andRouterIdGreaterThanOrEqualTo(String value) {
            addCriterion("router_id >=", value, "routerId");
            return (Criteria) this;
        }

        public Criteria andRouterIdLessThan(String value) {
            addCriterion("router_id <", value, "routerId");
            return (Criteria) this;
        }

        public Criteria andRouterIdLessThanOrEqualTo(String value) {
            addCriterion("router_id <=", value, "routerId");
            return (Criteria) this;
        }

        public Criteria andRouterIdLike(String value) {
            addCriterion("router_id like", value, "routerId");
            return (Criteria) this;
        }

        public Criteria andRouterIdNotLike(String value) {
            addCriterion("router_id not like", value, "routerId");
            return (Criteria) this;
        }

        public Criteria andRouterIdIn(List<String> values) {
            addCriterion("router_id in", values, "routerId");
            return (Criteria) this;
        }

        public Criteria andRouterIdNotIn(List<String> values) {
            addCriterion("router_id not in", values, "routerId");
            return (Criteria) this;
        }

        public Criteria andRouterIdBetween(String value1, String value2) {
            addCriterion("router_id between", value1, value2, "routerId");
            return (Criteria) this;
        }

        public Criteria andRouterIdNotBetween(String value1, String value2) {
            addCriterion("router_id not between", value1, value2, "routerId");
            return (Criteria) this;
        }

        public Criteria andRouterNameIsNull() {
            addCriterion("router_name is null");
            return (Criteria) this;
        }

        public Criteria andRouterNameIsNotNull() {
            addCriterion("router_name is not null");
            return (Criteria) this;
        }

        public Criteria andRouterNameEqualTo(String value) {
            addCriterion("router_name =", value, "routerName");
            return (Criteria) this;
        }

        public Criteria andRouterNameNotEqualTo(String value) {
            addCriterion("router_name <>", value, "routerName");
            return (Criteria) this;
        }

        public Criteria andRouterNameGreaterThan(String value) {
            addCriterion("router_name >", value, "routerName");
            return (Criteria) this;
        }

        public Criteria andRouterNameGreaterThanOrEqualTo(String value) {
            addCriterion("router_name >=", value, "routerName");
            return (Criteria) this;
        }

        public Criteria andRouterNameLessThan(String value) {
            addCriterion("router_name <", value, "routerName");
            return (Criteria) this;
        }

        public Criteria andRouterNameLessThanOrEqualTo(String value) {
            addCriterion("router_name <=", value, "routerName");
            return (Criteria) this;
        }

        public Criteria andRouterNameLike(String value) {
            addCriterion("router_name like", value, "routerName");
            return (Criteria) this;
        }

        public Criteria andRouterNameNotLike(String value) {
            addCriterion("router_name not like", value, "routerName");
            return (Criteria) this;
        }

        public Criteria andRouterNameIn(List<String> values) {
            addCriterion("router_name in", values, "routerName");
            return (Criteria) this;
        }

        public Criteria andRouterNameNotIn(List<String> values) {
            addCriterion("router_name not in", values, "routerName");
            return (Criteria) this;
        }

        public Criteria andRouterNameBetween(String value1, String value2) {
            addCriterion("router_name between", value1, value2, "routerName");
            return (Criteria) this;
        }

        public Criteria andRouterNameNotBetween(String value1, String value2) {
            addCriterion("router_name not between", value1, value2, "routerName");
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

        public Criteria andExternalGatewayInfoIsNull() {
            addCriterion("external_gateway_info is null");
            return (Criteria) this;
        }

        public Criteria andExternalGatewayInfoIsNotNull() {
            addCriterion("external_gateway_info is not null");
            return (Criteria) this;
        }

        public Criteria andExternalGatewayInfoEqualTo(String value) {
            addCriterion("external_gateway_info =", value, "externalGatewayInfo");
            return (Criteria) this;
        }

        public Criteria andExternalGatewayInfoNotEqualTo(String value) {
            addCriterion("external_gateway_info <>", value, "externalGatewayInfo");
            return (Criteria) this;
        }

        public Criteria andExternalGatewayInfoGreaterThan(String value) {
            addCriterion("external_gateway_info >", value, "externalGatewayInfo");
            return (Criteria) this;
        }

        public Criteria andExternalGatewayInfoGreaterThanOrEqualTo(String value) {
            addCriterion("external_gateway_info >=", value, "externalGatewayInfo");
            return (Criteria) this;
        }

        public Criteria andExternalGatewayInfoLessThan(String value) {
            addCriterion("external_gateway_info <", value, "externalGatewayInfo");
            return (Criteria) this;
        }

        public Criteria andExternalGatewayInfoLessThanOrEqualTo(String value) {
            addCriterion("external_gateway_info <=", value, "externalGatewayInfo");
            return (Criteria) this;
        }

        public Criteria andExternalGatewayInfoLike(String value) {
            addCriterion("external_gateway_info like", value, "externalGatewayInfo");
            return (Criteria) this;
        }

        public Criteria andExternalGatewayInfoNotLike(String value) {
            addCriterion("external_gateway_info not like", value, "externalGatewayInfo");
            return (Criteria) this;
        }

        public Criteria andExternalGatewayInfoIn(List<String> values) {
            addCriterion("external_gateway_info in", values, "externalGatewayInfo");
            return (Criteria) this;
        }

        public Criteria andExternalGatewayInfoNotIn(List<String> values) {
            addCriterion("external_gateway_info not in", values, "externalGatewayInfo");
            return (Criteria) this;
        }

        public Criteria andExternalGatewayInfoBetween(String value1, String value2) {
            addCriterion("external_gateway_info between", value1, value2, "externalGatewayInfo");
            return (Criteria) this;
        }

        public Criteria andExternalGatewayInfoNotBetween(String value1, String value2) {
            addCriterion("external_gateway_info not between", value1, value2, "externalGatewayInfo");
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

        public Criteria andHaIsNull() {
            addCriterion("ha is null");
            return (Criteria) this;
        }

        public Criteria andHaIsNotNull() {
            addCriterion("ha is not null");
            return (Criteria) this;
        }

        public Criteria andHaEqualTo(Boolean value) {
            addCriterion("ha =", value, "ha");
            return (Criteria) this;
        }

        public Criteria andHaNotEqualTo(Boolean value) {
            addCriterion("ha <>", value, "ha");
            return (Criteria) this;
        }

        public Criteria andHaGreaterThan(Boolean value) {
            addCriterion("ha >", value, "ha");
            return (Criteria) this;
        }

        public Criteria andHaGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ha >=", value, "ha");
            return (Criteria) this;
        }

        public Criteria andHaLessThan(Boolean value) {
            addCriterion("ha <", value, "ha");
            return (Criteria) this;
        }

        public Criteria andHaLessThanOrEqualTo(Boolean value) {
            addCriterion("ha <=", value, "ha");
            return (Criteria) this;
        }

        public Criteria andHaIn(List<Boolean> values) {
            addCriterion("ha in", values, "ha");
            return (Criteria) this;
        }

        public Criteria andHaNotIn(List<Boolean> values) {
            addCriterion("ha not in", values, "ha");
            return (Criteria) this;
        }

        public Criteria andHaBetween(Boolean value1, Boolean value2) {
            addCriterion("ha between", value1, value2, "ha");
            return (Criteria) this;
        }

        public Criteria andHaNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ha not between", value1, value2, "ha");
            return (Criteria) this;
        }

        public Criteria andAvailalityZonesIsNull() {
            addCriterion("availality_zones is null");
            return (Criteria) this;
        }

        public Criteria andAvailalityZonesIsNotNull() {
            addCriterion("availality_zones is not null");
            return (Criteria) this;
        }

        public Criteria andAvailalityZonesEqualTo(String value) {
            addCriterion("availality_zones =", value, "availalityZones");
            return (Criteria) this;
        }

        public Criteria andAvailalityZonesNotEqualTo(String value) {
            addCriterion("availality_zones <>", value, "availalityZones");
            return (Criteria) this;
        }

        public Criteria andAvailalityZonesGreaterThan(String value) {
            addCriterion("availality_zones >", value, "availalityZones");
            return (Criteria) this;
        }

        public Criteria andAvailalityZonesGreaterThanOrEqualTo(String value) {
            addCriterion("availality_zones >=", value, "availalityZones");
            return (Criteria) this;
        }

        public Criteria andAvailalityZonesLessThan(String value) {
            addCriterion("availality_zones <", value, "availalityZones");
            return (Criteria) this;
        }

        public Criteria andAvailalityZonesLessThanOrEqualTo(String value) {
            addCriterion("availality_zones <=", value, "availalityZones");
            return (Criteria) this;
        }

        public Criteria andAvailalityZonesLike(String value) {
            addCriterion("availality_zones like", value, "availalityZones");
            return (Criteria) this;
        }

        public Criteria andAvailalityZonesNotLike(String value) {
            addCriterion("availality_zones not like", value, "availalityZones");
            return (Criteria) this;
        }

        public Criteria andAvailalityZonesIn(List<String> values) {
            addCriterion("availality_zones in", values, "availalityZones");
            return (Criteria) this;
        }

        public Criteria andAvailalityZonesNotIn(List<String> values) {
            addCriterion("availality_zones not in", values, "availalityZones");
            return (Criteria) this;
        }

        public Criteria andAvailalityZonesBetween(String value1, String value2) {
            addCriterion("availality_zones between", value1, value2, "availalityZones");
            return (Criteria) this;
        }

        public Criteria andAvailalityZonesNotBetween(String value1, String value2) {
            addCriterion("availality_zones not between", value1, value2, "availalityZones");
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
    }

    /**
     * openstack_routers
     **/
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * openstack_routers
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