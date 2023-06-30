package com.ict.cloud.resource.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpenstackSnapshotsCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public OpenstackSnapshotsCriteria() {
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

    public OpenstackSnapshotsCriteria limit(Integer rows) {
        this.rows = rows;
        return this;
    }

    public OpenstackSnapshotsCriteria limit(Integer offset, Integer rows) {
        this.offset = offset;
        this.rows = rows;
        return this;
    }

    public OpenstackSnapshotsCriteria page(Integer page, Integer pageSize) {
        this.offset = (page - 1) * pageSize;
        this.rows = pageSize;
        return this;
    }

    /**
            * openstack_snapshots
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

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Integer value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Integer value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Integer value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Integer value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Integer> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Integer> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andSnapshotsIdIsNull() {
            addCriterion("snapshots_id is null");
            return (Criteria) this;
        }

        public Criteria andSnapshotsIdIsNotNull() {
            addCriterion("snapshots_id is not null");
            return (Criteria) this;
        }

        public Criteria andSnapshotsIdEqualTo(String value) {
            addCriterion("snapshots_id =", value, "snapshotsId");
            return (Criteria) this;
        }

        public Criteria andSnapshotsIdNotEqualTo(String value) {
            addCriterion("snapshots_id <>", value, "snapshotsId");
            return (Criteria) this;
        }

        public Criteria andSnapshotsIdGreaterThan(String value) {
            addCriterion("snapshots_id >", value, "snapshotsId");
            return (Criteria) this;
        }

        public Criteria andSnapshotsIdGreaterThanOrEqualTo(String value) {
            addCriterion("snapshots_id >=", value, "snapshotsId");
            return (Criteria) this;
        }

        public Criteria andSnapshotsIdLessThan(String value) {
            addCriterion("snapshots_id <", value, "snapshotsId");
            return (Criteria) this;
        }

        public Criteria andSnapshotsIdLessThanOrEqualTo(String value) {
            addCriterion("snapshots_id <=", value, "snapshotsId");
            return (Criteria) this;
        }

        public Criteria andSnapshotsIdLike(String value) {
            addCriterion("snapshots_id like", value, "snapshotsId");
            return (Criteria) this;
        }

        public Criteria andSnapshotsIdNotLike(String value) {
            addCriterion("snapshots_id not like", value, "snapshotsId");
            return (Criteria) this;
        }

        public Criteria andSnapshotsIdIn(List<String> values) {
            addCriterion("snapshots_id in", values, "snapshotsId");
            return (Criteria) this;
        }

        public Criteria andSnapshotsIdNotIn(List<String> values) {
            addCriterion("snapshots_id not in", values, "snapshotsId");
            return (Criteria) this;
        }

        public Criteria andSnapshotsIdBetween(String value1, String value2) {
            addCriterion("snapshots_id between", value1, value2, "snapshotsId");
            return (Criteria) this;
        }

        public Criteria andSnapshotsIdNotBetween(String value1, String value2) {
            addCriterion("snapshots_id not between", value1, value2, "snapshotsId");
            return (Criteria) this;
        }

        public Criteria andSnapshotsNameIsNull() {
            addCriterion("snapshots_name is null");
            return (Criteria) this;
        }

        public Criteria andSnapshotsNameIsNotNull() {
            addCriterion("snapshots_name is not null");
            return (Criteria) this;
        }

        public Criteria andSnapshotsNameEqualTo(String value) {
            addCriterion("snapshots_name =", value, "snapshotsName");
            return (Criteria) this;
        }

        public Criteria andSnapshotsNameNotEqualTo(String value) {
            addCriterion("snapshots_name <>", value, "snapshotsName");
            return (Criteria) this;
        }

        public Criteria andSnapshotsNameGreaterThan(String value) {
            addCriterion("snapshots_name >", value, "snapshotsName");
            return (Criteria) this;
        }

        public Criteria andSnapshotsNameGreaterThanOrEqualTo(String value) {
            addCriterion("snapshots_name >=", value, "snapshotsName");
            return (Criteria) this;
        }

        public Criteria andSnapshotsNameLessThan(String value) {
            addCriterion("snapshots_name <", value, "snapshotsName");
            return (Criteria) this;
        }

        public Criteria andSnapshotsNameLessThanOrEqualTo(String value) {
            addCriterion("snapshots_name <=", value, "snapshotsName");
            return (Criteria) this;
        }

        public Criteria andSnapshotsNameLike(String value) {
            addCriterion("snapshots_name like", value, "snapshotsName");
            return (Criteria) this;
        }

        public Criteria andSnapshotsNameNotLike(String value) {
            addCriterion("snapshots_name not like", value, "snapshotsName");
            return (Criteria) this;
        }

        public Criteria andSnapshotsNameIn(List<String> values) {
            addCriterion("snapshots_name in", values, "snapshotsName");
            return (Criteria) this;
        }

        public Criteria andSnapshotsNameNotIn(List<String> values) {
            addCriterion("snapshots_name not in", values, "snapshotsName");
            return (Criteria) this;
        }

        public Criteria andSnapshotsNameBetween(String value1, String value2) {
            addCriterion("snapshots_name between", value1, value2, "snapshotsName");
            return (Criteria) this;
        }

        public Criteria andSnapshotsNameNotBetween(String value1, String value2) {
            addCriterion("snapshots_name not between", value1, value2, "snapshotsName");
            return (Criteria) this;
        }

        public Criteria andSnapshotsStatusIsNull() {
            addCriterion("snapshots_status is null");
            return (Criteria) this;
        }

        public Criteria andSnapshotsStatusIsNotNull() {
            addCriterion("snapshots_status is not null");
            return (Criteria) this;
        }

        public Criteria andSnapshotsStatusEqualTo(String value) {
            addCriterion("snapshots_status =", value, "snapshotsStatus");
            return (Criteria) this;
        }

        public Criteria andSnapshotsStatusNotEqualTo(String value) {
            addCriterion("snapshots_status <>", value, "snapshotsStatus");
            return (Criteria) this;
        }

        public Criteria andSnapshotsStatusGreaterThan(String value) {
            addCriterion("snapshots_status >", value, "snapshotsStatus");
            return (Criteria) this;
        }

        public Criteria andSnapshotsStatusGreaterThanOrEqualTo(String value) {
            addCriterion("snapshots_status >=", value, "snapshotsStatus");
            return (Criteria) this;
        }

        public Criteria andSnapshotsStatusLessThan(String value) {
            addCriterion("snapshots_status <", value, "snapshotsStatus");
            return (Criteria) this;
        }

        public Criteria andSnapshotsStatusLessThanOrEqualTo(String value) {
            addCriterion("snapshots_status <=", value, "snapshotsStatus");
            return (Criteria) this;
        }

        public Criteria andSnapshotsStatusLike(String value) {
            addCriterion("snapshots_status like", value, "snapshotsStatus");
            return (Criteria) this;
        }

        public Criteria andSnapshotsStatusNotLike(String value) {
            addCriterion("snapshots_status not like", value, "snapshotsStatus");
            return (Criteria) this;
        }

        public Criteria andSnapshotsStatusIn(List<String> values) {
            addCriterion("snapshots_status in", values, "snapshotsStatus");
            return (Criteria) this;
        }

        public Criteria andSnapshotsStatusNotIn(List<String> values) {
            addCriterion("snapshots_status not in", values, "snapshotsStatus");
            return (Criteria) this;
        }

        public Criteria andSnapshotsStatusBetween(String value1, String value2) {
            addCriterion("snapshots_status between", value1, value2, "snapshotsStatus");
            return (Criteria) this;
        }

        public Criteria andSnapshotsStatusNotBetween(String value1, String value2) {
            addCriterion("snapshots_status not between", value1, value2, "snapshotsStatus");
            return (Criteria) this;
        }

        public Criteria andSnapshotsVolumeIdIsNull() {
            addCriterion("snapshots_volume_id is null");
            return (Criteria) this;
        }

        public Criteria andSnapshotsVolumeIdIsNotNull() {
            addCriterion("snapshots_volume_id is not null");
            return (Criteria) this;
        }

        public Criteria andSnapshotsVolumeIdEqualTo(String value) {
            addCriterion("snapshots_volume_id =", value, "snapshotsVolumeId");
            return (Criteria) this;
        }

        public Criteria andSnapshotsVolumeIdNotEqualTo(String value) {
            addCriterion("snapshots_volume_id <>", value, "snapshotsVolumeId");
            return (Criteria) this;
        }

        public Criteria andSnapshotsVolumeIdGreaterThan(String value) {
            addCriterion("snapshots_volume_id >", value, "snapshotsVolumeId");
            return (Criteria) this;
        }

        public Criteria andSnapshotsVolumeIdGreaterThanOrEqualTo(String value) {
            addCriterion("snapshots_volume_id >=", value, "snapshotsVolumeId");
            return (Criteria) this;
        }

        public Criteria andSnapshotsVolumeIdLessThan(String value) {
            addCriterion("snapshots_volume_id <", value, "snapshotsVolumeId");
            return (Criteria) this;
        }

        public Criteria andSnapshotsVolumeIdLessThanOrEqualTo(String value) {
            addCriterion("snapshots_volume_id <=", value, "snapshotsVolumeId");
            return (Criteria) this;
        }

        public Criteria andSnapshotsVolumeIdLike(String value) {
            addCriterion("snapshots_volume_id like", value, "snapshotsVolumeId");
            return (Criteria) this;
        }

        public Criteria andSnapshotsVolumeIdNotLike(String value) {
            addCriterion("snapshots_volume_id not like", value, "snapshotsVolumeId");
            return (Criteria) this;
        }

        public Criteria andSnapshotsVolumeIdIn(List<String> values) {
            addCriterion("snapshots_volume_id in", values, "snapshotsVolumeId");
            return (Criteria) this;
        }

        public Criteria andSnapshotsVolumeIdNotIn(List<String> values) {
            addCriterion("snapshots_volume_id not in", values, "snapshotsVolumeId");
            return (Criteria) this;
        }

        public Criteria andSnapshotsVolumeIdBetween(String value1, String value2) {
            addCriterion("snapshots_volume_id between", value1, value2, "snapshotsVolumeId");
            return (Criteria) this;
        }

        public Criteria andSnapshotsVolumeIdNotBetween(String value1, String value2) {
            addCriterion("snapshots_volume_id not between", value1, value2, "snapshotsVolumeId");
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

        public Criteria andMetadataAdminPassIsNull() {
            addCriterion("metadata_admin_pass is null");
            return (Criteria) this;
        }

        public Criteria andMetadataAdminPassIsNotNull() {
            addCriterion("metadata_admin_pass is not null");
            return (Criteria) this;
        }

        public Criteria andMetadataAdminPassEqualTo(String value) {
            addCriterion("metadata_admin_pass =", value, "metadataAdminPass");
            return (Criteria) this;
        }

        public Criteria andMetadataAdminPassNotEqualTo(String value) {
            addCriterion("metadata_admin_pass <>", value, "metadataAdminPass");
            return (Criteria) this;
        }

        public Criteria andMetadataAdminPassGreaterThan(String value) {
            addCriterion("metadata_admin_pass >", value, "metadataAdminPass");
            return (Criteria) this;
        }

        public Criteria andMetadataAdminPassGreaterThanOrEqualTo(String value) {
            addCriterion("metadata_admin_pass >=", value, "metadataAdminPass");
            return (Criteria) this;
        }

        public Criteria andMetadataAdminPassLessThan(String value) {
            addCriterion("metadata_admin_pass <", value, "metadataAdminPass");
            return (Criteria) this;
        }

        public Criteria andMetadataAdminPassLessThanOrEqualTo(String value) {
            addCriterion("metadata_admin_pass <=", value, "metadataAdminPass");
            return (Criteria) this;
        }

        public Criteria andMetadataAdminPassLike(String value) {
            addCriterion("metadata_admin_pass like", value, "metadataAdminPass");
            return (Criteria) this;
        }

        public Criteria andMetadataAdminPassNotLike(String value) {
            addCriterion("metadata_admin_pass not like", value, "metadataAdminPass");
            return (Criteria) this;
        }

        public Criteria andMetadataAdminPassIn(List<String> values) {
            addCriterion("metadata_admin_pass in", values, "metadataAdminPass");
            return (Criteria) this;
        }

        public Criteria andMetadataAdminPassNotIn(List<String> values) {
            addCriterion("metadata_admin_pass not in", values, "metadataAdminPass");
            return (Criteria) this;
        }

        public Criteria andMetadataAdminPassBetween(String value1, String value2) {
            addCriterion("metadata_admin_pass between", value1, value2, "metadataAdminPass");
            return (Criteria) this;
        }

        public Criteria andMetadataAdminPassNotBetween(String value1, String value2) {
            addCriterion("metadata_admin_pass not between", value1, value2, "metadataAdminPass");
            return (Criteria) this;
        }

        public Criteria andSnapshotSizeIsNull() {
            addCriterion("snapshot_size is null");
            return (Criteria) this;
        }

        public Criteria andSnapshotSizeIsNotNull() {
            addCriterion("snapshot_size is not null");
            return (Criteria) this;
        }

        public Criteria andSnapshotSizeEqualTo(Integer value) {
            addCriterion("snapshot_size =", value, "snapshotSize");
            return (Criteria) this;
        }

        public Criteria andSnapshotSizeNotEqualTo(Integer value) {
            addCriterion("snapshot_size <>", value, "snapshotSize");
            return (Criteria) this;
        }

        public Criteria andSnapshotSizeGreaterThan(Integer value) {
            addCriterion("snapshot_size >", value, "snapshotSize");
            return (Criteria) this;
        }

        public Criteria andSnapshotSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("snapshot_size >=", value, "snapshotSize");
            return (Criteria) this;
        }

        public Criteria andSnapshotSizeLessThan(Integer value) {
            addCriterion("snapshot_size <", value, "snapshotSize");
            return (Criteria) this;
        }

        public Criteria andSnapshotSizeLessThanOrEqualTo(Integer value) {
            addCriterion("snapshot_size <=", value, "snapshotSize");
            return (Criteria) this;
        }

        public Criteria andSnapshotSizeIn(List<Integer> values) {
            addCriterion("snapshot_size in", values, "snapshotSize");
            return (Criteria) this;
        }

        public Criteria andSnapshotSizeNotIn(List<Integer> values) {
            addCriterion("snapshot_size not in", values, "snapshotSize");
            return (Criteria) this;
        }

        public Criteria andSnapshotSizeBetween(Integer value1, Integer value2) {
            addCriterion("snapshot_size between", value1, value2, "snapshotSize");
            return (Criteria) this;
        }

        public Criteria andSnapshotSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("snapshot_size not between", value1, value2, "snapshotSize");
            return (Criteria) this;
        }

        public Criteria andSnapshotProjectIdIsNull() {
            addCriterion("snapshot_project_id is null");
            return (Criteria) this;
        }

        public Criteria andSnapshotProjectIdIsNotNull() {
            addCriterion("snapshot_project_id is not null");
            return (Criteria) this;
        }

        public Criteria andSnapshotProjectIdEqualTo(String value) {
            addCriterion("snapshot_project_id =", value, "snapshotProjectId");
            return (Criteria) this;
        }

        public Criteria andSnapshotProjectIdNotEqualTo(String value) {
            addCriterion("snapshot_project_id <>", value, "snapshotProjectId");
            return (Criteria) this;
        }

        public Criteria andSnapshotProjectIdGreaterThan(String value) {
            addCriterion("snapshot_project_id >", value, "snapshotProjectId");
            return (Criteria) this;
        }

        public Criteria andSnapshotProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("snapshot_project_id >=", value, "snapshotProjectId");
            return (Criteria) this;
        }

        public Criteria andSnapshotProjectIdLessThan(String value) {
            addCriterion("snapshot_project_id <", value, "snapshotProjectId");
            return (Criteria) this;
        }

        public Criteria andSnapshotProjectIdLessThanOrEqualTo(String value) {
            addCriterion("snapshot_project_id <=", value, "snapshotProjectId");
            return (Criteria) this;
        }

        public Criteria andSnapshotProjectIdLike(String value) {
            addCriterion("snapshot_project_id like", value, "snapshotProjectId");
            return (Criteria) this;
        }

        public Criteria andSnapshotProjectIdNotLike(String value) {
            addCriterion("snapshot_project_id not like", value, "snapshotProjectId");
            return (Criteria) this;
        }

        public Criteria andSnapshotProjectIdIn(List<String> values) {
            addCriterion("snapshot_project_id in", values, "snapshotProjectId");
            return (Criteria) this;
        }

        public Criteria andSnapshotProjectIdNotIn(List<String> values) {
            addCriterion("snapshot_project_id not in", values, "snapshotProjectId");
            return (Criteria) this;
        }

        public Criteria andSnapshotProjectIdBetween(String value1, String value2) {
            addCriterion("snapshot_project_id between", value1, value2, "snapshotProjectId");
            return (Criteria) this;
        }

        public Criteria andSnapshotProjectIdNotBetween(String value1, String value2) {
            addCriterion("snapshot_project_id not between", value1, value2, "snapshotProjectId");
            return (Criteria) this;
        }

        public Criteria andExtendIsNull() {
            addCriterion("extend is null");
            return (Criteria) this;
        }

        public Criteria andExtendIsNotNull() {
            addCriterion("extend is not null");
            return (Criteria) this;
        }

        public Criteria andExtendEqualTo(String value) {
            addCriterion("extend =", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotEqualTo(String value) {
            addCriterion("extend <>", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendGreaterThan(String value) {
            addCriterion("extend >", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendGreaterThanOrEqualTo(String value) {
            addCriterion("extend >=", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLessThan(String value) {
            addCriterion("extend <", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLessThanOrEqualTo(String value) {
            addCriterion("extend <=", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLike(String value) {
            addCriterion("extend like", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotLike(String value) {
            addCriterion("extend not like", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendIn(List<String> values) {
            addCriterion("extend in", values, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotIn(List<String> values) {
            addCriterion("extend not in", values, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendBetween(String value1, String value2) {
            addCriterion("extend between", value1, value2, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotBetween(String value1, String value2) {
            addCriterion("extend not between", value1, value2, "extend");
            return (Criteria) this;
        }
    }

    /**
            * openstack_snapshots
            **/
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
            * openstack_snapshots
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