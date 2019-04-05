package com.weweibuy.webuy.order.common.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShippingMethodExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShippingMethodExample() {
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

        public Criteria andShippingMethodIsNull() {
            addCriterion("shipping_method is null");
            return (Criteria) this;
        }

        public Criteria andShippingMethodIsNotNull() {
            addCriterion("shipping_method is not null");
            return (Criteria) this;
        }

        public Criteria andShippingMethodEqualTo(String value) {
            addCriterion("shipping_method =", value, "shippingMethod");
            return (Criteria) this;
        }

        public Criteria andShippingMethodNotEqualTo(String value) {
            addCriterion("shipping_method <>", value, "shippingMethod");
            return (Criteria) this;
        }

        public Criteria andShippingMethodGreaterThan(String value) {
            addCriterion("shipping_method >", value, "shippingMethod");
            return (Criteria) this;
        }

        public Criteria andShippingMethodGreaterThanOrEqualTo(String value) {
            addCriterion("shipping_method >=", value, "shippingMethod");
            return (Criteria) this;
        }

        public Criteria andShippingMethodLessThan(String value) {
            addCriterion("shipping_method <", value, "shippingMethod");
            return (Criteria) this;
        }

        public Criteria andShippingMethodLessThanOrEqualTo(String value) {
            addCriterion("shipping_method <=", value, "shippingMethod");
            return (Criteria) this;
        }

        public Criteria andShippingMethodLike(String value) {
            addCriterion("shipping_method like", value, "shippingMethod");
            return (Criteria) this;
        }

        public Criteria andShippingMethodNotLike(String value) {
            addCriterion("shipping_method not like", value, "shippingMethod");
            return (Criteria) this;
        }

        public Criteria andShippingMethodIn(List<String> values) {
            addCriterion("shipping_method in", values, "shippingMethod");
            return (Criteria) this;
        }

        public Criteria andShippingMethodNotIn(List<String> values) {
            addCriterion("shipping_method not in", values, "shippingMethod");
            return (Criteria) this;
        }

        public Criteria andShippingMethodBetween(String value1, String value2) {
            addCriterion("shipping_method between", value1, value2, "shippingMethod");
            return (Criteria) this;
        }

        public Criteria andShippingMethodNotBetween(String value1, String value2) {
            addCriterion("shipping_method not between", value1, value2, "shippingMethod");
            return (Criteria) this;
        }

        public Criteria andShippingMethodNameIsNull() {
            addCriterion("shipping_method_name is null");
            return (Criteria) this;
        }

        public Criteria andShippingMethodNameIsNotNull() {
            addCriterion("shipping_method_name is not null");
            return (Criteria) this;
        }

        public Criteria andShippingMethodNameEqualTo(String value) {
            addCriterion("shipping_method_name =", value, "shippingMethodName");
            return (Criteria) this;
        }

        public Criteria andShippingMethodNameNotEqualTo(String value) {
            addCriterion("shipping_method_name <>", value, "shippingMethodName");
            return (Criteria) this;
        }

        public Criteria andShippingMethodNameGreaterThan(String value) {
            addCriterion("shipping_method_name >", value, "shippingMethodName");
            return (Criteria) this;
        }

        public Criteria andShippingMethodNameGreaterThanOrEqualTo(String value) {
            addCriterion("shipping_method_name >=", value, "shippingMethodName");
            return (Criteria) this;
        }

        public Criteria andShippingMethodNameLessThan(String value) {
            addCriterion("shipping_method_name <", value, "shippingMethodName");
            return (Criteria) this;
        }

        public Criteria andShippingMethodNameLessThanOrEqualTo(String value) {
            addCriterion("shipping_method_name <=", value, "shippingMethodName");
            return (Criteria) this;
        }

        public Criteria andShippingMethodNameLike(String value) {
            addCriterion("shipping_method_name like", value, "shippingMethodName");
            return (Criteria) this;
        }

        public Criteria andShippingMethodNameNotLike(String value) {
            addCriterion("shipping_method_name not like", value, "shippingMethodName");
            return (Criteria) this;
        }

        public Criteria andShippingMethodNameIn(List<String> values) {
            addCriterion("shipping_method_name in", values, "shippingMethodName");
            return (Criteria) this;
        }

        public Criteria andShippingMethodNameNotIn(List<String> values) {
            addCriterion("shipping_method_name not in", values, "shippingMethodName");
            return (Criteria) this;
        }

        public Criteria andShippingMethodNameBetween(String value1, String value2) {
            addCriterion("shipping_method_name between", value1, value2, "shippingMethodName");
            return (Criteria) this;
        }

        public Criteria andShippingMethodNameNotBetween(String value1, String value2) {
            addCriterion("shipping_method_name not between", value1, value2, "shippingMethodName");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyIsNull() {
            addCriterion("shipping_company is null");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyIsNotNull() {
            addCriterion("shipping_company is not null");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyEqualTo(String value) {
            addCriterion("shipping_company =", value, "shippingCompany");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyNotEqualTo(String value) {
            addCriterion("shipping_company <>", value, "shippingCompany");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyGreaterThan(String value) {
            addCriterion("shipping_company >", value, "shippingCompany");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("shipping_company >=", value, "shippingCompany");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyLessThan(String value) {
            addCriterion("shipping_company <", value, "shippingCompany");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyLessThanOrEqualTo(String value) {
            addCriterion("shipping_company <=", value, "shippingCompany");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyLike(String value) {
            addCriterion("shipping_company like", value, "shippingCompany");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyNotLike(String value) {
            addCriterion("shipping_company not like", value, "shippingCompany");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyIn(List<String> values) {
            addCriterion("shipping_company in", values, "shippingCompany");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyNotIn(List<String> values) {
            addCriterion("shipping_company not in", values, "shippingCompany");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyBetween(String value1, String value2) {
            addCriterion("shipping_company between", value1, value2, "shippingCompany");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyNotBetween(String value1, String value2) {
            addCriterion("shipping_company not between", value1, value2, "shippingCompany");
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