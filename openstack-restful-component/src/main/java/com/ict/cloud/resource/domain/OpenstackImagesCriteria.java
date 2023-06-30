package com.ict.cloud.resource.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpenstackImagesCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public OpenstackImagesCriteria() {
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

    public OpenstackImagesCriteria limit(Integer rows) {
        this.rows = rows;
        return this;
    }

    public OpenstackImagesCriteria limit(Integer offset, Integer rows) {
        this.offset = offset;
        this.rows = rows;
        return this;
    }

    public OpenstackImagesCriteria page(Integer page, Integer pageSize) {
        this.offset = (page - 1) * pageSize;
        this.rows = pageSize;
        return this;
    }

    /**
     * openstack_images
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

        public Criteria andImageSizeIsNull() {
            addCriterion("image_size is null");
            return (Criteria) this;
        }

        public Criteria andImageSizeIsNotNull() {
            addCriterion("image_size is not null");
            return (Criteria) this;
        }

        public Criteria andImageSizeEqualTo(String value) {
            addCriterion("image_size =", value, "imageSize");
            return (Criteria) this;
        }

        public Criteria andImageSizeNotEqualTo(String value) {
            addCriterion("image_size <>", value, "imageSize");
            return (Criteria) this;
        }

        public Criteria andImageSizeGreaterThan(String value) {
            addCriterion("image_size >", value, "imageSize");
            return (Criteria) this;
        }

        public Criteria andImageSizeGreaterThanOrEqualTo(String value) {
            addCriterion("image_size >=", value, "imageSize");
            return (Criteria) this;
        }

        public Criteria andImageSizeLessThan(String value) {
            addCriterion("image_size <", value, "imageSize");
            return (Criteria) this;
        }

        public Criteria andImageSizeLessThanOrEqualTo(String value) {
            addCriterion("image_size <=", value, "imageSize");
            return (Criteria) this;
        }

        public Criteria andImageSizeIn(List<String> values) {
            addCriterion("image_size in", values, "imageSize");
            return (Criteria) this;
        }

        public Criteria andImageSizeNotIn(List<String> values) {
            addCriterion("image_size not in", values, "imageSize");
            return (Criteria) this;
        }

        public Criteria andImageSizeBetween(String value1, String value2) {
            addCriterion("image_size between", value1, value2, "imageSize");
            return (Criteria) this;
        }

        public Criteria andImageSizeNotBetween(String value1, String value2) {
            addCriterion("image_size not between", value1, value2, "imageSize");
            return (Criteria) this;
        }

        public Criteria andImageVisibilityIsNull() {
            addCriterion("visibility is null");
            return (Criteria) this;
        }

        public Criteria andImageVisibilityIsNotNull() {
            addCriterion("visibility is not null");
            return (Criteria) this;
        }

        public Criteria andImageVisibilityEqualTo(String value) {
            addCriterion("visibility =", value, "imageVisibility");
            return (Criteria) this;
        }

        public Criteria andImageVisibilityNotEqualTo(String value) {
            addCriterion("visibility <>", value, "imageVisibility");
            return (Criteria) this;
        }

        public Criteria andImageVisibilityGreaterThan(String value) {
            addCriterion("visibility >", value, "imageVisibility");
            return (Criteria) this;
        }

        public Criteria andImageVisibilityGreaterThanOrEqualTo(String value) {
            addCriterion("visibility >=", value, "imageVisibility");
            return (Criteria) this;
        }

        public Criteria andImageVisibilityLessThan(String value) {
            addCriterion("visibility <", value, "imageVisibility");
            return (Criteria) this;
        }

        public Criteria andImageVisibilityLessThanOrEqualTo(String value) {
            addCriterion("visibility <=", value, "imageVisibility");
            return (Criteria) this;
        }

        public Criteria andImageVisibilityIn(List<String> values) {
            addCriterion("visibility in", values, "imageVisibility");
            return (Criteria) this;
        }

        public Criteria andImageVisibilityNotIn(List<String> values) {
            addCriterion("visibility not in", values, "imageVisibility");
            return (Criteria) this;
        }

        public Criteria andImageVisibilityBetween(String value1, String value2) {
            addCriterion("visibility between", value1, value2, "imageVisibility");
            return (Criteria) this;
        }

        public Criteria andImageVisibilityNotBetween(String value1, String value2) {
            addCriterion("visibility not between", value1, value2, "imageVisibility");
            return (Criteria) this;
        }

        public Criteria andProtectedFlagIsNull() {
            addCriterion("protected is null");
            return (Criteria) this;
        }

        public Criteria andProtectedFlagIsNotNull() {
            addCriterion("protected is not null");
            return (Criteria) this;
        }

        public Criteria andProtectedFlagEqualTo(Boolean value) {
            addCriterion("protected =", value, "protectedFlag");
            return (Criteria) this;
        }

        public Criteria andProtectedFlagNotEqualTo(Boolean value) {
            addCriterion("protected <>", value, "protectedFlag");
            return (Criteria) this;
        }

        public Criteria andProtectedFlagGreaterThan(Boolean value) {
            addCriterion("protected >", value, "protectedFlag");
            return (Criteria) this;
        }

        public Criteria andProtectedFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("protected >=", value, "protectedFlag");
            return (Criteria) this;
        }

        public Criteria andProtectedFlagLessThan(Boolean value) {
            addCriterion("protected <", value, "protectedFlag");
            return (Criteria) this;
        }

        public Criteria andProtectedFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("protected <=", value, "protectedFlag");
            return (Criteria) this;
        }

        public Criteria andProtectedFlagIn(List<Boolean> values) {
            addCriterion("protected in", values, "protectedFlag");
            return (Criteria) this;
        }

        public Criteria andProtectedFlagNotIn(List<Boolean> values) {
            addCriterion("protected not in", values, "protectedFlag");
            return (Criteria) this;
        }

        public Criteria andProtectedFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("protected between", value1, value2, "protectedFlag");
            return (Criteria) this;
        }

        public Criteria andProtectedFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("protected not between", value1, value2, "protectedFlag");
            return (Criteria) this;
        }

        public Criteria andDiskFormatIsNull() {
            addCriterion("disk_format is null");
            return (Criteria) this;
        }

        public Criteria andDiskFormatIsNotNull() {
            addCriterion("disk_format is not null");
            return (Criteria) this;
        }

        public Criteria andDiskFormatEqualTo(String value) {
            addCriterion("disk_format =", value, "diskFormat");
            return (Criteria) this;
        }

        public Criteria andDiskFormatNotEqualTo(String value) {
            addCriterion("disk_format <>", value, "diskFormat");
            return (Criteria) this;
        }

        public Criteria andDiskFormatGreaterThan(String value) {
            addCriterion("disk_format >", value, "diskFormat");
            return (Criteria) this;
        }

        public Criteria andDiskFormatGreaterThanOrEqualTo(String value) {
            addCriterion("disk_format >=", value, "diskFormat");
            return (Criteria) this;
        }

        public Criteria andDiskFormatLessThan(String value) {
            addCriterion("disk_format <", value, "diskFormat");
            return (Criteria) this;
        }

        public Criteria andDiskFormatLessThanOrEqualTo(String value) {
            addCriterion("disk_format <=", value, "diskFormat");
            return (Criteria) this;
        }

        public Criteria andDiskFormatIn(List<String> values) {
            addCriterion("disk_format in", values, "diskFormat");
            return (Criteria) this;
        }

        public Criteria andDiskFormatNotIn(List<String> values) {
            addCriterion("disk_format not in", values, "diskFormat");
            return (Criteria) this;
        }

        public Criteria andDiskFormatBetween(String value1, String value2) {
            addCriterion("disk_format between", value1, value2, "diskFormat");
            return (Criteria) this;
        }

        public Criteria andDiskFormatNotBetween(String value1, String value2) {
            addCriterion("disk_format not between", value1, value2, "diskFormat");
            return (Criteria) this;
        }

        public Criteria andOsAdminUserIsNull() {
            addCriterion("os_admin_user is null");
            return (Criteria) this;
        }

        public Criteria andOsAdminUserIsNotNull() {
            addCriterion("os_admin_user is not null");
            return (Criteria) this;
        }

        public Criteria andOsAdminUserEqualTo(Double value) {
            addCriterion("os_admin_user =", value, "osAdminUser");
            return (Criteria) this;
        }

        public Criteria andOsAdminUserNotEqualTo(Double value) {
            addCriterion("os_admin_user <>", value, "osAdminUser");
            return (Criteria) this;
        }

        public Criteria andOsAdminUserGreaterThan(Double value) {
            addCriterion("os_admin_user >", value, "osAdminUser");
            return (Criteria) this;
        }

        public Criteria andOsAdminUserGreaterThanOrEqualTo(Double value) {
            addCriterion("os_admin_user >=", value, "osAdminUser");
            return (Criteria) this;
        }

        public Criteria andOsAdminUserLessThan(Double value) {
            addCriterion("os_admin_user <", value, "osAdminUser");
            return (Criteria) this;
        }

        public Criteria andOsAdminUserLessThanOrEqualTo(Double value) {
            addCriterion("os_admin_user <=", value, "osAdminUser");
            return (Criteria) this;
        }

        public Criteria andOsAdminUserIn(List<Double> values) {
            addCriterion("os_admin_user in", values, "osAdminUser");
            return (Criteria) this;
        }

        public Criteria andOsAdminUserNotIn(List<Double> values) {
            addCriterion("os_admin_user not in", values, "osAdminUser");
            return (Criteria) this;
        }

        public Criteria andOsAdminUserBetween(Double value1, Double value2) {
            addCriterion("os_admin_user between", value1, value2, "osAdminUser");
            return (Criteria) this;
        }

        public Criteria andOsAdminUserNotBetween(Double value1, Double value2) {
            addCriterion("os_admin_user not between", value1, value2, "osAdminUser");
            return (Criteria) this;
        }

        public Criteria andImageIdIsNull() {
            addCriterion("image_id is null");
            return (Criteria) this;
        }

        public Criteria andImageIdIsNotNull() {
            addCriterion("image_id is not null");
            return (Criteria) this;
        }

        public Criteria andImageIdEqualTo(String value) {
            addCriterion("image_id =", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotEqualTo(String value) {
            addCriterion("image_id <>", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdGreaterThan(String value) {
            addCriterion("image_id >", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdGreaterThanOrEqualTo(String value) {
            addCriterion("image_id >=", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLessThan(String value) {
            addCriterion("image_id <", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLessThanOrEqualTo(String value) {
            addCriterion("image_id <=", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLike(String value) {
            addCriterion("image_id like", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotLike(String value) {
            addCriterion("image_id not like", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdIn(List<String> values) {
            addCriterion("image_id in", values, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotIn(List<String> values) {
            addCriterion("image_id not in", values, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdBetween(String value1, String value2) {
            addCriterion("image_id between", value1, value2, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotBetween(String value1, String value2) {
            addCriterion("image_id not between", value1, value2, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageNameIsNull() {
            addCriterion("image_name is null");
            return (Criteria) this;
        }

        public Criteria andImageNameIsNotNull() {
            addCriterion("image_name is not null");
            return (Criteria) this;
        }

        public Criteria andImageNameEqualTo(String value) {
            addCriterion("image_name =", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameNotEqualTo(String value) {
            addCriterion("image_name <>", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameGreaterThan(String value) {
            addCriterion("image_name >", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameGreaterThanOrEqualTo(String value) {
            addCriterion("image_name >=", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameLessThan(String value) {
            addCriterion("image_name <", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameLessThanOrEqualTo(String value) {
            addCriterion("image_name <=", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameLike(String value) {
            addCriterion("image_name like", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameNotLike(String value) {
            addCriterion("image_name not like", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameIn(List<String> values) {
            addCriterion("image_name in", values, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameNotIn(List<String> values) {
            addCriterion("image_name not in", values, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameBetween(String value1, String value2) {
            addCriterion("image_name between", value1, value2, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameNotBetween(String value1, String value2) {
            addCriterion("image_name not between", value1, value2, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageStatusIsNull() {
            addCriterion("image_status is null");
            return (Criteria) this;
        }

        public Criteria andImageStatusIsNotNull() {
            addCriterion("image_status is not null");
            return (Criteria) this;
        }

        public Criteria andImageStatusEqualTo(String value) {
            addCriterion("image_status =", value, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusNotEqualTo(String value) {
            addCriterion("image_status <>", value, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusGreaterThan(String value) {
            addCriterion("image_status >", value, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusGreaterThanOrEqualTo(String value) {
            addCriterion("image_status >=", value, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusLessThan(String value) {
            addCriterion("image_status <", value, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusLessThanOrEqualTo(String value) {
            addCriterion("image_status <=", value, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusLike(String value) {
            addCriterion("image_status like", value, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusNotLike(String value) {
            addCriterion("image_status not like", value, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusIn(List<String> values) {
            addCriterion("image_status in", values, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusNotIn(List<String> values) {
            addCriterion("image_status not in", values, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusBetween(String value1, String value2) {
            addCriterion("image_status between", value1, value2, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusNotBetween(String value1, String value2) {
            addCriterion("image_status not between", value1, value2, "imageStatus");
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

        public Criteria andImageVersionIsNull() {
            addCriterion("image_version is null");
            return (Criteria) this;
        }

        public Criteria andImageVersionIsNotNull() {
            addCriterion("image_version is not null");
            return (Criteria) this;
        }

        public Criteria andImageVersionEqualTo(String value) {
            addCriterion("image_version =", value, "imageVersion");
            return (Criteria) this;
        }

        public Criteria andImageVersionNotEqualTo(String value) {
            addCriterion("image_version <>", value, "imageVersion");
            return (Criteria) this;
        }

        public Criteria andImageVersionGreaterThan(String value) {
            addCriterion("image_version >", value, "imageVersion");
            return (Criteria) this;
        }

        public Criteria andImageVersionGreaterThanOrEqualTo(String value) {
            addCriterion("image_version >=", value, "imageVersion");
            return (Criteria) this;
        }

        public Criteria andImageVersionLessThan(String value) {
            addCriterion("image_version <", value, "imageVersion");
            return (Criteria) this;
        }

        public Criteria andImageVersionLessThanOrEqualTo(String value) {
            addCriterion("image_version <=", value, "imageVersion");
            return (Criteria) this;
        }

        public Criteria andImageVersionLike(String value) {
            addCriterion("image_version like", value, "imageVersion");
            return (Criteria) this;
        }

        public Criteria andImageVersionNotLike(String value) {
            addCriterion("image_version not like", value, "imageVersion");
            return (Criteria) this;
        }

        public Criteria andImageVersionIn(List<String> values) {
            addCriterion("image_version in", values, "imageVersion");
            return (Criteria) this;
        }

        public Criteria andImageVersionNotIn(List<String> values) {
            addCriterion("image_version not in", values, "imageVersion");
            return (Criteria) this;
        }

        public Criteria andImageVersionBetween(String value1, String value2) {
            addCriterion("image_version between", value1, value2, "imageVersion");
            return (Criteria) this;
        }

        public Criteria andImageVersionNotBetween(String value1, String value2) {
            addCriterion("image_version not between", value1, value2, "imageVersion");
            return (Criteria) this;
        }

        public Criteria andImageArchIsNull() {
            addCriterion("image_arch is null");
            return (Criteria) this;
        }

        public Criteria andImageArchIsNotNull() {
            addCriterion("image_arch is not null");
            return (Criteria) this;
        }

        public Criteria andImageArchEqualTo(String value) {
            addCriterion("image_arch =", value, "imageArch");
            return (Criteria) this;
        }

        public Criteria andImageArchNotEqualTo(String value) {
            addCriterion("image_arch <>", value, "imageArch");
            return (Criteria) this;
        }

        public Criteria andImageArchGreaterThan(String value) {
            addCriterion("image_arch >", value, "imageArch");
            return (Criteria) this;
        }

        public Criteria andImageArchGreaterThanOrEqualTo(String value) {
            addCriterion("image_arch >=", value, "imageArch");
            return (Criteria) this;
        }

        public Criteria andImageArchLessThan(String value) {
            addCriterion("image_arch <", value, "imageArch");
            return (Criteria) this;
        }

        public Criteria andImageArchLessThanOrEqualTo(String value) {
            addCriterion("image_arch <=", value, "imageArch");
            return (Criteria) this;
        }

        public Criteria andImageArchLike(String value) {
            addCriterion("image_arch like", value, "imageArch");
            return (Criteria) this;
        }

        public Criteria andImageArchNotLike(String value) {
            addCriterion("image_arch not like", value, "imageArch");
            return (Criteria) this;
        }

        public Criteria andImageArchIn(List<String> values) {
            addCriterion("image_arch in", values, "imageArch");
            return (Criteria) this;
        }

        public Criteria andImageArchNotIn(List<String> values) {
            addCriterion("image_arch not in", values, "imageArch");
            return (Criteria) this;
        }

        public Criteria andImageArchBetween(String value1, String value2) {
            addCriterion("image_arch between", value1, value2, "imageArch");
            return (Criteria) this;
        }

        public Criteria andImageArchNotBetween(String value1, String value2) {
            addCriterion("image_arch not between", value1, value2, "imageArch");
            return (Criteria) this;
        }

        public Criteria andImageTypeIsNull() {
            addCriterion("image_type is null");
            return (Criteria) this;
        }

        public Criteria andImageTypeIsNotNull() {
            addCriterion("image_type is not null");
            return (Criteria) this;
        }

        public Criteria andImageTypeEqualTo(String value) {
            addCriterion("image_type =", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeNotEqualTo(String value) {
            addCriterion("image_type <>", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeGreaterThan(String value) {
            addCriterion("image_type >", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeGreaterThanOrEqualTo(String value) {
            addCriterion("image_type >=", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeLessThan(String value) {
            addCriterion("image_type <", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeLessThanOrEqualTo(String value) {
            addCriterion("image_type <=", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeLike(String value) {
            addCriterion("image_type like", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeNotLike(String value) {
            addCriterion("image_type not like", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeIn(List<String> values) {
            addCriterion("image_type in", values, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeNotIn(List<String> values) {
            addCriterion("image_type not in", values, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeBetween(String value1, String value2) {
            addCriterion("image_type between", value1, value2, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeNotBetween(String value1, String value2) {
            addCriterion("image_type not between", value1, value2, "imageType");
            return (Criteria) this;
        }
    }

    /**
     * openstack_images
     **/
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * openstack_images
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