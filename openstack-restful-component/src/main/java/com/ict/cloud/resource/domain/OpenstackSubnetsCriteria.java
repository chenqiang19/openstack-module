package com.ict.cloud.resource.domain;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpenstackSubnetsCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public OpenstackSubnetsCriteria() {
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

    public OpenstackSubnetsCriteria limit(Integer rows) {
        this.rows = rows;
        return this;
    }

    public OpenstackSubnetsCriteria limit(Integer offset, Integer rows) {
        this.offset = offset;
        this.rows = rows;
        return this;
    }

    public OpenstackSubnetsCriteria page(Integer page, Integer pageSize) {
        this.offset = (page - 1) * pageSize;
        this.rows = pageSize;
        return this;
    }

    /**
     * openstack_subnets
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

        public Criteria andSubnetIdIsNull() {
            addCriterion("subnet_id is null");
            return (Criteria) this;
        }

        public Criteria andSubnetIdIsNotNull() {
            addCriterion("subnet_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubnetIdEqualTo(String value) {
            addCriterion("subnet_id =", value, "subnetId");
            return (Criteria) this;
        }

        public Criteria andSubnetIdNotEqualTo(String value) {
            addCriterion("subnet_id <>", value, "subnetId");
            return (Criteria) this;
        }

        public Criteria andSubnetIdGreaterThan(String value) {
            addCriterion("subnet_id >", value, "subnetId");
            return (Criteria) this;
        }

        public Criteria andSubnetIdGreaterThanOrEqualTo(String value) {
            addCriterion("subnet_id >=", value, "subnetId");
            return (Criteria) this;
        }

        public Criteria andSubnetIdLessThan(String value) {
            addCriterion("subnet_id <", value, "subnetId");
            return (Criteria) this;
        }

        public Criteria andSubnetIdLessThanOrEqualTo(String value) {
            addCriterion("subnet_id <=", value, "subnetId");
            return (Criteria) this;
        }

        public Criteria andSubnetIdLike(String value) {
            addCriterion("subnet_id like", value, "subnetId");
            return (Criteria) this;
        }

        public Criteria andSubnetIdNotLike(String value) {
            addCriterion("subnet_id not like", value, "subnetId");
            return (Criteria) this;
        }

        public Criteria andSubnetIdIn(List<String> values) {
            addCriterion("subnet_id in", values, "subnetId");
            return (Criteria) this;
        }

        public Criteria andSubnetIdNotIn(List<String> values) {
            addCriterion("subnet_id not in", values, "subnetId");
            return (Criteria) this;
        }

        public Criteria andSubnetIdBetween(String value1, String value2) {
            addCriterion("subnet_id between", value1, value2, "subnetId");
            return (Criteria) this;
        }

        public Criteria andSubnetIdNotBetween(String value1, String value2) {
            addCriterion("subnet_id not between", value1, value2, "subnetId");
            return (Criteria) this;
        }

        public Criteria andPrefixesIsNull() {
            addCriterion("prefixes is null");
            return (Criteria) this;
        }

        public Criteria andPrefixesIsNotNull() {
            addCriterion("prefixes is not null");
            return (Criteria) this;
        }

        public Criteria andPrefixesEqualTo(String value) {
            addCriterion("prefixes =", value, "prefixes");
            return (Criteria) this;
        }

        public Criteria andPrefixesNotEqualTo(String value) {
            addCriterion("prefixes <>", value, "prefixes");
            return (Criteria) this;
        }

        public Criteria andPrefixesGreaterThan(String value) {
            addCriterion("prefixes >", value, "prefixes");
            return (Criteria) this;
        }

        public Criteria andPrefixesGreaterThanOrEqualTo(String value) {
            addCriterion("prefixes >=", value, "prefixes");
            return (Criteria) this;
        }

        public Criteria andPrefixesLessThan(String value) {
            addCriterion("prefixes <", value, "prefixes");
            return (Criteria) this;
        }

        public Criteria andPrefixesLessThanOrEqualTo(String value) {
            addCriterion("prefixes <=", value, "prefixes");
            return (Criteria) this;
        }

        public Criteria andPrefixesLike(String value) {
            addCriterion("prefixes like", value, "prefixes");
            return (Criteria) this;
        }

        public Criteria andPrefixesNotLike(String value) {
            addCriterion("prefixes not like", value, "prefixes");
            return (Criteria) this;
        }

        public Criteria andPrefixesIn(List<String> values) {
            addCriterion("prefixes in", values, "prefixes");
            return (Criteria) this;
        }

        public Criteria andPrefixesNotIn(List<String> values) {
            addCriterion("prefixes not in", values, "prefixes");
            return (Criteria) this;
        }

        public Criteria andPrefixesBetween(String value1, String value2) {
            addCriterion("prefixes between", value1, value2, "prefixes");
            return (Criteria) this;
        }

        public Criteria andPrefixesNotBetween(String value1, String value2) {
            addCriterion("prefixes not between", value1, value2, "prefixes");
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

        public Criteria andDnsNameserversIsNull() {
            addCriterion("dns_nameservers is null");
            return (Criteria) this;
        }

        public Criteria andDnsNameserversIsNotNull() {
            addCriterion("dns_nameservers is not null");
            return (Criteria) this;
        }

        public Criteria andDnsNameserversEqualTo(String value) {
            addCriterion("dns_nameservers =", value, "dnsNameservers");
            return (Criteria) this;
        }

        public Criteria andDnsNameserversNotEqualTo(String value) {
            addCriterion("dns_nameservers <>", value, "dnsNameservers");
            return (Criteria) this;
        }

        public Criteria andDnsNameserversGreaterThan(String value) {
            addCriterion("dns_nameservers >", value, "dnsNameservers");
            return (Criteria) this;
        }

        public Criteria andDnsNameserversGreaterThanOrEqualTo(String value) {
            addCriterion("dns_nameservers >=", value, "dnsNameservers");
            return (Criteria) this;
        }

        public Criteria andDnsNameserversLessThan(String value) {
            addCriterion("dns_nameservers <", value, "dnsNameservers");
            return (Criteria) this;
        }

        public Criteria andDnsNameserversLessThanOrEqualTo(String value) {
            addCriterion("dns_nameservers <=", value, "dnsNameservers");
            return (Criteria) this;
        }

        public Criteria andDnsNameserversIn(List<String> values) {
            addCriterion("dns_nameservers in", values, "dnsNameservers");
            return (Criteria) this;
        }

        public Criteria andDnsNameserversNotIn(List<String> values) {
            addCriterion("dns_nameservers not in", values, "dnsNameservers");
            return (Criteria) this;
        }

        public Criteria andDnsNameserversBetween(String value1, String value2) {
            addCriterion("dns_nameservers between", value1, value2, "dnsNameservers");
            return (Criteria) this;
        }

        public Criteria andDnsNameserversNotBetween(String value1, String value2) {
            addCriterion("dns_nameservers not between", value1, value2, "dnsNameservers");
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

        public Criteria andGatewayIdIsNull() {
            addCriterion("gateway_id is null");
            return (Criteria) this;
        }

        public Criteria andGatewayIdIsNotNull() {
            addCriterion("gateway_id is not null");
            return (Criteria) this;
        }

        public Criteria andGatewayIdEqualTo(String value) {
            addCriterion("gateway_id =", value, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdNotEqualTo(String value) {
            addCriterion("gateway_id <>", value, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdGreaterThan(String value) {
            addCriterion("gateway_id >", value, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdGreaterThanOrEqualTo(String value) {
            addCriterion("gateway_id >=", value, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdLessThan(String value) {
            addCriterion("gateway_id <", value, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdLessThanOrEqualTo(String value) {
            addCriterion("gateway_id <=", value, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdLike(String value) {
            addCriterion("gateway_id like", value, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdNotLike(String value) {
            addCriterion("gateway_id not like", value, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdIn(List<String> values) {
            addCriterion("gateway_id in", values, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdNotIn(List<String> values) {
            addCriterion("gateway_id not in", values, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdBetween(String value1, String value2) {
            addCriterion("gateway_id between", value1, value2, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdNotBetween(String value1, String value2) {
            addCriterion("gateway_id not between", value1, value2, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andCidrIsNull() {
            addCriterion("cidr is null");
            return (Criteria) this;
        }

        public Criteria andCidrIsNotNull() {
            addCriterion("cidr is not null");
            return (Criteria) this;
        }

        public Criteria andCidrEqualTo(String value) {
            addCriterion("cidr =", value, "cidr");
            return (Criteria) this;
        }

        public Criteria andCidrNotEqualTo(String value) {
            addCriterion("cidr <>", value, "cidr");
            return (Criteria) this;
        }

        public Criteria andCidrGreaterThan(String value) {
            addCriterion("cidr >", value, "cidr");
            return (Criteria) this;
        }

        public Criteria andCidrGreaterThanOrEqualTo(String value) {
            addCriterion("cidr >=", value, "cidr");
            return (Criteria) this;
        }

        public Criteria andCidrLessThan(String value) {
            addCriterion("cidr <", value, "cidr");
            return (Criteria) this;
        }

        public Criteria andCidrLessThanOrEqualTo(String value) {
            addCriterion("cidr <=", value, "cidr");
            return (Criteria) this;
        }

        public Criteria andCidrLike(String value) {
            addCriterion("cidr like", value, "cidr");
            return (Criteria) this;
        }

        public Criteria andCidrNotLike(String value) {
            addCriterion("cidr not like", value, "cidr");
            return (Criteria) this;
        }

        public Criteria andCidrIn(List<String> values) {
            addCriterion("cidr in", values, "cidr");
            return (Criteria) this;
        }

        public Criteria andCidrNotIn(List<String> values) {
            addCriterion("cidr not in", values, "cidr");
            return (Criteria) this;
        }

        public Criteria andCidrBetween(String value1, String value2) {
            addCriterion("cidr between", value1, value2, "cidr");
            return (Criteria) this;
        }

        public Criteria andCidrNotBetween(String value1, String value2) {
            addCriterion("cidr not between", value1, value2, "cidr");
            return (Criteria) this;
        }

        public Criteria andSegmentIdIsNull() {
            addCriterion("segment_id is null");
            return (Criteria) this;
        }

        public Criteria andSegmentIdIsNotNull() {
            addCriterion("segment_id is not null");
            return (Criteria) this;
        }

        public Criteria andSegmentIdEqualTo(Integer value) {
            addCriterion("segment_id =", value, "segmentId");
            return (Criteria) this;
        }

        public Criteria andSegmentIdNotEqualTo(Integer value) {
            addCriterion("segment_id <>", value, "segmentId");
            return (Criteria) this;
        }

        public Criteria andSegmentIdGreaterThan(Integer value) {
            addCriterion("segment_id >", value, "segmentId");
            return (Criteria) this;
        }

        public Criteria andSegmentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("segment_id >=", value, "segmentId");
            return (Criteria) this;
        }

        public Criteria andSegmentIdLessThan(Integer value) {
            addCriterion("segment_id <", value, "segmentId");
            return (Criteria) this;
        }

        public Criteria andSegmentIdLessThanOrEqualTo(Integer value) {
            addCriterion("segment_id <=", value, "segmentId");
            return (Criteria) this;
        }

        public Criteria andSegmentIdIn(List<Integer> values) {
            addCriterion("segment_id in", values, "segmentId");
            return (Criteria) this;
        }

        public Criteria andSegmentIdNotIn(List<Integer> values) {
            addCriterion("segment_id not in", values, "segmentId");
            return (Criteria) this;
        }

        public Criteria andSegmentIdBetween(Integer value1, Integer value2) {
            addCriterion("segment_id between", value1, value2, "segmentId");
            return (Criteria) this;
        }

        public Criteria andSegmentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("segment_id not between", value1, value2, "segmentId");
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

        public Criteria andSubnetNameIsNull() {
            addCriterion("subnet_name is null");
            return (Criteria) this;
        }

        public Criteria andSubnetNameIsNotNull() {
            addCriterion("subnet_name is not null");
            return (Criteria) this;
        }

        public Criteria andSubnetNameEqualTo(String value) {
            addCriterion("subnet_name =", value, "subnetName");
            return (Criteria) this;
        }

        public Criteria andSubnetNameNotEqualTo(String value) {
            addCriterion("subnet_name <>", value, "subnetName");
            return (Criteria) this;
        }

        public Criteria andSubnetNameGreaterThan(String value) {
            addCriterion("subnet_name >", value, "subnetName");
            return (Criteria) this;
        }

        public Criteria andSubnetNameGreaterThanOrEqualTo(String value) {
            addCriterion("subnet_name >=", value, "subnetName");
            return (Criteria) this;
        }

        public Criteria andSubnetNameLessThan(String value) {
            addCriterion("subnet_name <", value, "subnetName");
            return (Criteria) this;
        }

        public Criteria andSubnetNameLessThanOrEqualTo(String value) {
            addCriterion("subnet_name <=", value, "subnetName");
            return (Criteria) this;
        }

        public Criteria andSubnetNameLike(String value) {
            addCriterion("subnet_name like", value, "subnetName");
            return (Criteria) this;
        }

        public Criteria andSubnetNameNotLike(String value) {
            addCriterion("subnet_name not like", value, "subnetName");
            return (Criteria) this;
        }

        public Criteria andSubnetNameIn(List<String> values) {
            addCriterion("subnet_name in", values, "subnetName");
            return (Criteria) this;
        }

        public Criteria andSubnetNameNotIn(List<String> values) {
            addCriterion("subnet_name not in", values, "subnetName");
            return (Criteria) this;
        }

        public Criteria andSubnetNameBetween(String value1, String value2) {
            addCriterion("subnet_name between", value1, value2, "subnetName");
            return (Criteria) this;
        }

        public Criteria andSubnetNameNotBetween(String value1, String value2) {
            addCriterion("subnet_name not between", value1, value2, "subnetName");
            return (Criteria) this;
        }
    }

    /**
     * openstack_subnets
     **/
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * openstack_subnets
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