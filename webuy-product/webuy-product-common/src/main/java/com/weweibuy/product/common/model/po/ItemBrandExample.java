package com.weweibuy.product.common.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemBrandExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ItemBrandExample() {
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
    }

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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdIsNull() {
            addCriterion("item_category_id is null");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdIsNotNull() {
            addCriterion("item_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdEqualTo(Long value) {
            addCriterion("item_category_id =", value, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdNotEqualTo(Long value) {
            addCriterion("item_category_id <>", value, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdGreaterThan(Long value) {
            addCriterion("item_category_id >", value, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("item_category_id >=", value, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdLessThan(Long value) {
            addCriterion("item_category_id <", value, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdLessThanOrEqualTo(Long value) {
            addCriterion("item_category_id <=", value, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdIn(List<Long> values) {
            addCriterion("item_category_id in", values, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdNotIn(List<Long> values) {
            addCriterion("item_category_id not in", values, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdBetween(Long value1, Long value2) {
            addCriterion("item_category_id between", value1, value2, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdNotBetween(Long value1, Long value2) {
            addCriterion("item_category_id not between", value1, value2, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNull() {
            addCriterion("brand_name is null");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNotNull() {
            addCriterion("brand_name is not null");
            return (Criteria) this;
        }

        public Criteria andBrandNameEqualTo(String value) {
            addCriterion("brand_name =", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotEqualTo(String value) {
            addCriterion("brand_name <>", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThan(String value) {
            addCriterion("brand_name >", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThanOrEqualTo(String value) {
            addCriterion("brand_name >=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThan(String value) {
            addCriterion("brand_name <", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThanOrEqualTo(String value) {
            addCriterion("brand_name <=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLike(String value) {
            addCriterion("brand_name like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotLike(String value) {
            addCriterion("brand_name not like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameIn(List<String> values) {
            addCriterion("brand_name in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotIn(List<String> values) {
            addCriterion("brand_name not in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameBetween(String value1, String value2) {
            addCriterion("brand_name between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotBetween(String value1, String value2) {
            addCriterion("brand_name not between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandEnglishNameIsNull() {
            addCriterion("brand_english_name is null");
            return (Criteria) this;
        }

        public Criteria andBrandEnglishNameIsNotNull() {
            addCriterion("brand_english_name is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEnglishNameEqualTo(String value) {
            addCriterion("brand_english_name =", value, "brandEnglishName");
            return (Criteria) this;
        }

        public Criteria andBrandEnglishNameNotEqualTo(String value) {
            addCriterion("brand_english_name <>", value, "brandEnglishName");
            return (Criteria) this;
        }

        public Criteria andBrandEnglishNameGreaterThan(String value) {
            addCriterion("brand_english_name >", value, "brandEnglishName");
            return (Criteria) this;
        }

        public Criteria andBrandEnglishNameGreaterThanOrEqualTo(String value) {
            addCriterion("brand_english_name >=", value, "brandEnglishName");
            return (Criteria) this;
        }

        public Criteria andBrandEnglishNameLessThan(String value) {
            addCriterion("brand_english_name <", value, "brandEnglishName");
            return (Criteria) this;
        }

        public Criteria andBrandEnglishNameLessThanOrEqualTo(String value) {
            addCriterion("brand_english_name <=", value, "brandEnglishName");
            return (Criteria) this;
        }

        public Criteria andBrandEnglishNameLike(String value) {
            addCriterion("brand_english_name like", value, "brandEnglishName");
            return (Criteria) this;
        }

        public Criteria andBrandEnglishNameNotLike(String value) {
            addCriterion("brand_english_name not like", value, "brandEnglishName");
            return (Criteria) this;
        }

        public Criteria andBrandEnglishNameIn(List<String> values) {
            addCriterion("brand_english_name in", values, "brandEnglishName");
            return (Criteria) this;
        }

        public Criteria andBrandEnglishNameNotIn(List<String> values) {
            addCriterion("brand_english_name not in", values, "brandEnglishName");
            return (Criteria) this;
        }

        public Criteria andBrandEnglishNameBetween(String value1, String value2) {
            addCriterion("brand_english_name between", value1, value2, "brandEnglishName");
            return (Criteria) this;
        }

        public Criteria andBrandEnglishNameNotBetween(String value1, String value2) {
            addCriterion("brand_english_name not between", value1, value2, "brandEnglishName");
            return (Criteria) this;
        }

        public Criteria andFirstCaseIsNull() {
            addCriterion("first_case is null");
            return (Criteria) this;
        }

        public Criteria andFirstCaseIsNotNull() {
            addCriterion("first_case is not null");
            return (Criteria) this;
        }

        public Criteria andFirstCaseEqualTo(String value) {
            addCriterion("first_case =", value, "firstCase");
            return (Criteria) this;
        }

        public Criteria andFirstCaseNotEqualTo(String value) {
            addCriterion("first_case <>", value, "firstCase");
            return (Criteria) this;
        }

        public Criteria andFirstCaseGreaterThan(String value) {
            addCriterion("first_case >", value, "firstCase");
            return (Criteria) this;
        }

        public Criteria andFirstCaseGreaterThanOrEqualTo(String value) {
            addCriterion("first_case >=", value, "firstCase");
            return (Criteria) this;
        }

        public Criteria andFirstCaseLessThan(String value) {
            addCriterion("first_case <", value, "firstCase");
            return (Criteria) this;
        }

        public Criteria andFirstCaseLessThanOrEqualTo(String value) {
            addCriterion("first_case <=", value, "firstCase");
            return (Criteria) this;
        }

        public Criteria andFirstCaseLike(String value) {
            addCriterion("first_case like", value, "firstCase");
            return (Criteria) this;
        }

        public Criteria andFirstCaseNotLike(String value) {
            addCriterion("first_case not like", value, "firstCase");
            return (Criteria) this;
        }

        public Criteria andFirstCaseIn(List<String> values) {
            addCriterion("first_case in", values, "firstCase");
            return (Criteria) this;
        }

        public Criteria andFirstCaseNotIn(List<String> values) {
            addCriterion("first_case not in", values, "firstCase");
            return (Criteria) this;
        }

        public Criteria andFirstCaseBetween(String value1, String value2) {
            addCriterion("first_case between", value1, value2, "firstCase");
            return (Criteria) this;
        }

        public Criteria andFirstCaseNotBetween(String value1, String value2) {
            addCriterion("first_case not between", value1, value2, "firstCase");
            return (Criteria) this;
        }

        public Criteria andBrandSloganIsNull() {
            addCriterion("brand_slogan is null");
            return (Criteria) this;
        }

        public Criteria andBrandSloganIsNotNull() {
            addCriterion("brand_slogan is not null");
            return (Criteria) this;
        }

        public Criteria andBrandSloganEqualTo(String value) {
            addCriterion("brand_slogan =", value, "brandSlogan");
            return (Criteria) this;
        }

        public Criteria andBrandSloganNotEqualTo(String value) {
            addCriterion("brand_slogan <>", value, "brandSlogan");
            return (Criteria) this;
        }

        public Criteria andBrandSloganGreaterThan(String value) {
            addCriterion("brand_slogan >", value, "brandSlogan");
            return (Criteria) this;
        }

        public Criteria andBrandSloganGreaterThanOrEqualTo(String value) {
            addCriterion("brand_slogan >=", value, "brandSlogan");
            return (Criteria) this;
        }

        public Criteria andBrandSloganLessThan(String value) {
            addCriterion("brand_slogan <", value, "brandSlogan");
            return (Criteria) this;
        }

        public Criteria andBrandSloganLessThanOrEqualTo(String value) {
            addCriterion("brand_slogan <=", value, "brandSlogan");
            return (Criteria) this;
        }

        public Criteria andBrandSloganLike(String value) {
            addCriterion("brand_slogan like", value, "brandSlogan");
            return (Criteria) this;
        }

        public Criteria andBrandSloganNotLike(String value) {
            addCriterion("brand_slogan not like", value, "brandSlogan");
            return (Criteria) this;
        }

        public Criteria andBrandSloganIn(List<String> values) {
            addCriterion("brand_slogan in", values, "brandSlogan");
            return (Criteria) this;
        }

        public Criteria andBrandSloganNotIn(List<String> values) {
            addCriterion("brand_slogan not in", values, "brandSlogan");
            return (Criteria) this;
        }

        public Criteria andBrandSloganBetween(String value1, String value2) {
            addCriterion("brand_slogan between", value1, value2, "brandSlogan");
            return (Criteria) this;
        }

        public Criteria andBrandSloganNotBetween(String value1, String value2) {
            addCriterion("brand_slogan not between", value1, value2, "brandSlogan");
            return (Criteria) this;
        }

        public Criteria andBrandLogoIsNull() {
            addCriterion("brand_logo is null");
            return (Criteria) this;
        }

        public Criteria andBrandLogoIsNotNull() {
            addCriterion("brand_logo is not null");
            return (Criteria) this;
        }

        public Criteria andBrandLogoEqualTo(String value) {
            addCriterion("brand_logo =", value, "brandLogo");
            return (Criteria) this;
        }

        public Criteria andBrandLogoNotEqualTo(String value) {
            addCriterion("brand_logo <>", value, "brandLogo");
            return (Criteria) this;
        }

        public Criteria andBrandLogoGreaterThan(String value) {
            addCriterion("brand_logo >", value, "brandLogo");
            return (Criteria) this;
        }

        public Criteria andBrandLogoGreaterThanOrEqualTo(String value) {
            addCriterion("brand_logo >=", value, "brandLogo");
            return (Criteria) this;
        }

        public Criteria andBrandLogoLessThan(String value) {
            addCriterion("brand_logo <", value, "brandLogo");
            return (Criteria) this;
        }

        public Criteria andBrandLogoLessThanOrEqualTo(String value) {
            addCriterion("brand_logo <=", value, "brandLogo");
            return (Criteria) this;
        }

        public Criteria andBrandLogoLike(String value) {
            addCriterion("brand_logo like", value, "brandLogo");
            return (Criteria) this;
        }

        public Criteria andBrandLogoNotLike(String value) {
            addCriterion("brand_logo not like", value, "brandLogo");
            return (Criteria) this;
        }

        public Criteria andBrandLogoIn(List<String> values) {
            addCriterion("brand_logo in", values, "brandLogo");
            return (Criteria) this;
        }

        public Criteria andBrandLogoNotIn(List<String> values) {
            addCriterion("brand_logo not in", values, "brandLogo");
            return (Criteria) this;
        }

        public Criteria andBrandLogoBetween(String value1, String value2) {
            addCriterion("brand_logo between", value1, value2, "brandLogo");
            return (Criteria) this;
        }

        public Criteria andBrandLogoNotBetween(String value1, String value2) {
            addCriterion("brand_logo not between", value1, value2, "brandLogo");
            return (Criteria) this;
        }

        public Criteria andBrandDescIsNull() {
            addCriterion("brand_desc is null");
            return (Criteria) this;
        }

        public Criteria andBrandDescIsNotNull() {
            addCriterion("brand_desc is not null");
            return (Criteria) this;
        }

        public Criteria andBrandDescEqualTo(String value) {
            addCriterion("brand_desc =", value, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescNotEqualTo(String value) {
            addCriterion("brand_desc <>", value, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescGreaterThan(String value) {
            addCriterion("brand_desc >", value, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescGreaterThanOrEqualTo(String value) {
            addCriterion("brand_desc >=", value, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescLessThan(String value) {
            addCriterion("brand_desc <", value, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescLessThanOrEqualTo(String value) {
            addCriterion("brand_desc <=", value, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescLike(String value) {
            addCriterion("brand_desc like", value, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescNotLike(String value) {
            addCriterion("brand_desc not like", value, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescIn(List<String> values) {
            addCriterion("brand_desc in", values, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescNotIn(List<String> values) {
            addCriterion("brand_desc not in", values, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescBetween(String value1, String value2) {
            addCriterion("brand_desc between", value1, value2, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescNotBetween(String value1, String value2) {
            addCriterion("brand_desc not between", value1, value2, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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