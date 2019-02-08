package com.weweibuy.order.common.model.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderShippingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderShippingExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andTrackingNumberIsNull() {
            addCriterion("tracking_number is null");
            return (Criteria) this;
        }

        public Criteria andTrackingNumberIsNotNull() {
            addCriterion("tracking_number is not null");
            return (Criteria) this;
        }

        public Criteria andTrackingNumberEqualTo(Long value) {
            addCriterion("tracking_number =", value, "trackingNumber");
            return (Criteria) this;
        }

        public Criteria andTrackingNumberNotEqualTo(Long value) {
            addCriterion("tracking_number <>", value, "trackingNumber");
            return (Criteria) this;
        }

        public Criteria andTrackingNumberGreaterThan(Long value) {
            addCriterion("tracking_number >", value, "trackingNumber");
            return (Criteria) this;
        }

        public Criteria andTrackingNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("tracking_number >=", value, "trackingNumber");
            return (Criteria) this;
        }

        public Criteria andTrackingNumberLessThan(Long value) {
            addCriterion("tracking_number <", value, "trackingNumber");
            return (Criteria) this;
        }

        public Criteria andTrackingNumberLessThanOrEqualTo(Long value) {
            addCriterion("tracking_number <=", value, "trackingNumber");
            return (Criteria) this;
        }

        public Criteria andTrackingNumberIn(List<Long> values) {
            addCriterion("tracking_number in", values, "trackingNumber");
            return (Criteria) this;
        }

        public Criteria andTrackingNumberNotIn(List<Long> values) {
            addCriterion("tracking_number not in", values, "trackingNumber");
            return (Criteria) this;
        }

        public Criteria andTrackingNumberBetween(Long value1, Long value2) {
            addCriterion("tracking_number between", value1, value2, "trackingNumber");
            return (Criteria) this;
        }

        public Criteria andTrackingNumberNotBetween(Long value1, Long value2) {
            addCriterion("tracking_number not between", value1, value2, "trackingNumber");
            return (Criteria) this;
        }

        public Criteria andShippingMethodIdIsNull() {
            addCriterion("shipping_method_id is null");
            return (Criteria) this;
        }

        public Criteria andShippingMethodIdIsNotNull() {
            addCriterion("shipping_method_id is not null");
            return (Criteria) this;
        }

        public Criteria andShippingMethodIdEqualTo(Long value) {
            addCriterion("shipping_method_id =", value, "shippingMethodId");
            return (Criteria) this;
        }

        public Criteria andShippingMethodIdNotEqualTo(Long value) {
            addCriterion("shipping_method_id <>", value, "shippingMethodId");
            return (Criteria) this;
        }

        public Criteria andShippingMethodIdGreaterThan(Long value) {
            addCriterion("shipping_method_id >", value, "shippingMethodId");
            return (Criteria) this;
        }

        public Criteria andShippingMethodIdGreaterThanOrEqualTo(Long value) {
            addCriterion("shipping_method_id >=", value, "shippingMethodId");
            return (Criteria) this;
        }

        public Criteria andShippingMethodIdLessThan(Long value) {
            addCriterion("shipping_method_id <", value, "shippingMethodId");
            return (Criteria) this;
        }

        public Criteria andShippingMethodIdLessThanOrEqualTo(Long value) {
            addCriterion("shipping_method_id <=", value, "shippingMethodId");
            return (Criteria) this;
        }

        public Criteria andShippingMethodIdIn(List<Long> values) {
            addCriterion("shipping_method_id in", values, "shippingMethodId");
            return (Criteria) this;
        }

        public Criteria andShippingMethodIdNotIn(List<Long> values) {
            addCriterion("shipping_method_id not in", values, "shippingMethodId");
            return (Criteria) this;
        }

        public Criteria andShippingMethodIdBetween(Long value1, Long value2) {
            addCriterion("shipping_method_id between", value1, value2, "shippingMethodId");
            return (Criteria) this;
        }

        public Criteria andShippingMethodIdNotBetween(Long value1, Long value2) {
            addCriterion("shipping_method_id not between", value1, value2, "shippingMethodId");
            return (Criteria) this;
        }

        public Criteria andShippingAddresIdIsNull() {
            addCriterion("shipping_addres_id is null");
            return (Criteria) this;
        }

        public Criteria andShippingAddresIdIsNotNull() {
            addCriterion("shipping_addres_id is not null");
            return (Criteria) this;
        }

        public Criteria andShippingAddresIdEqualTo(Long value) {
            addCriterion("shipping_addres_id =", value, "shippingAddresId");
            return (Criteria) this;
        }

        public Criteria andShippingAddresIdNotEqualTo(Long value) {
            addCriterion("shipping_addres_id <>", value, "shippingAddresId");
            return (Criteria) this;
        }

        public Criteria andShippingAddresIdGreaterThan(Long value) {
            addCriterion("shipping_addres_id >", value, "shippingAddresId");
            return (Criteria) this;
        }

        public Criteria andShippingAddresIdGreaterThanOrEqualTo(Long value) {
            addCriterion("shipping_addres_id >=", value, "shippingAddresId");
            return (Criteria) this;
        }

        public Criteria andShippingAddresIdLessThan(Long value) {
            addCriterion("shipping_addres_id <", value, "shippingAddresId");
            return (Criteria) this;
        }

        public Criteria andShippingAddresIdLessThanOrEqualTo(Long value) {
            addCriterion("shipping_addres_id <=", value, "shippingAddresId");
            return (Criteria) this;
        }

        public Criteria andShippingAddresIdIn(List<Long> values) {
            addCriterion("shipping_addres_id in", values, "shippingAddresId");
            return (Criteria) this;
        }

        public Criteria andShippingAddresIdNotIn(List<Long> values) {
            addCriterion("shipping_addres_id not in", values, "shippingAddresId");
            return (Criteria) this;
        }

        public Criteria andShippingAddresIdBetween(Long value1, Long value2) {
            addCriterion("shipping_addres_id between", value1, value2, "shippingAddresId");
            return (Criteria) this;
        }

        public Criteria andShippingAddresIdNotBetween(Long value1, Long value2) {
            addCriterion("shipping_addres_id not between", value1, value2, "shippingAddresId");
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

        public Criteria andShippingFeeIsNull() {
            addCriterion("shipping_fee is null");
            return (Criteria) this;
        }

        public Criteria andShippingFeeIsNotNull() {
            addCriterion("shipping_fee is not null");
            return (Criteria) this;
        }

        public Criteria andShippingFeeEqualTo(BigDecimal value) {
            addCriterion("shipping_fee =", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeNotEqualTo(BigDecimal value) {
            addCriterion("shipping_fee <>", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeGreaterThan(BigDecimal value) {
            addCriterion("shipping_fee >", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_fee >=", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeLessThan(BigDecimal value) {
            addCriterion("shipping_fee <", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_fee <=", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeIn(List<BigDecimal> values) {
            addCriterion("shipping_fee in", values, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeNotIn(List<BigDecimal> values) {
            addCriterion("shipping_fee not in", values, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_fee between", value1, value2, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_fee not between", value1, value2, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andIsInsuranceIsNull() {
            addCriterion("is_insurance is null");
            return (Criteria) this;
        }

        public Criteria andIsInsuranceIsNotNull() {
            addCriterion("is_insurance is not null");
            return (Criteria) this;
        }

        public Criteria andIsInsuranceEqualTo(Byte value) {
            addCriterion("is_insurance =", value, "isInsurance");
            return (Criteria) this;
        }

        public Criteria andIsInsuranceNotEqualTo(Byte value) {
            addCriterion("is_insurance <>", value, "isInsurance");
            return (Criteria) this;
        }

        public Criteria andIsInsuranceGreaterThan(Byte value) {
            addCriterion("is_insurance >", value, "isInsurance");
            return (Criteria) this;
        }

        public Criteria andIsInsuranceGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_insurance >=", value, "isInsurance");
            return (Criteria) this;
        }

        public Criteria andIsInsuranceLessThan(Byte value) {
            addCriterion("is_insurance <", value, "isInsurance");
            return (Criteria) this;
        }

        public Criteria andIsInsuranceLessThanOrEqualTo(Byte value) {
            addCriterion("is_insurance <=", value, "isInsurance");
            return (Criteria) this;
        }

        public Criteria andIsInsuranceIn(List<Byte> values) {
            addCriterion("is_insurance in", values, "isInsurance");
            return (Criteria) this;
        }

        public Criteria andIsInsuranceNotIn(List<Byte> values) {
            addCriterion("is_insurance not in", values, "isInsurance");
            return (Criteria) this;
        }

        public Criteria andIsInsuranceBetween(Byte value1, Byte value2) {
            addCriterion("is_insurance between", value1, value2, "isInsurance");
            return (Criteria) this;
        }

        public Criteria andIsInsuranceNotBetween(Byte value1, Byte value2) {
            addCriterion("is_insurance not between", value1, value2, "isInsurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeIsNull() {
            addCriterion("insurance_fee is null");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeIsNotNull() {
            addCriterion("insurance_fee is not null");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeEqualTo(BigDecimal value) {
            addCriterion("insurance_fee =", value, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeNotEqualTo(BigDecimal value) {
            addCriterion("insurance_fee <>", value, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeGreaterThan(BigDecimal value) {
            addCriterion("insurance_fee >", value, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("insurance_fee >=", value, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeLessThan(BigDecimal value) {
            addCriterion("insurance_fee <", value, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("insurance_fee <=", value, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeIn(List<BigDecimal> values) {
            addCriterion("insurance_fee in", values, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeNotIn(List<BigDecimal> values) {
            addCriterion("insurance_fee not in", values, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("insurance_fee between", value1, value2, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("insurance_fee not between", value1, value2, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andShippingStatusIsNull() {
            addCriterion("shipping_status is null");
            return (Criteria) this;
        }

        public Criteria andShippingStatusIsNotNull() {
            addCriterion("shipping_status is not null");
            return (Criteria) this;
        }

        public Criteria andShippingStatusEqualTo(Byte value) {
            addCriterion("shipping_status =", value, "shippingStatus");
            return (Criteria) this;
        }

        public Criteria andShippingStatusNotEqualTo(Byte value) {
            addCriterion("shipping_status <>", value, "shippingStatus");
            return (Criteria) this;
        }

        public Criteria andShippingStatusGreaterThan(Byte value) {
            addCriterion("shipping_status >", value, "shippingStatus");
            return (Criteria) this;
        }

        public Criteria andShippingStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("shipping_status >=", value, "shippingStatus");
            return (Criteria) this;
        }

        public Criteria andShippingStatusLessThan(Byte value) {
            addCriterion("shipping_status <", value, "shippingStatus");
            return (Criteria) this;
        }

        public Criteria andShippingStatusLessThanOrEqualTo(Byte value) {
            addCriterion("shipping_status <=", value, "shippingStatus");
            return (Criteria) this;
        }

        public Criteria andShippingStatusIn(List<Byte> values) {
            addCriterion("shipping_status in", values, "shippingStatus");
            return (Criteria) this;
        }

        public Criteria andShippingStatusNotIn(List<Byte> values) {
            addCriterion("shipping_status not in", values, "shippingStatus");
            return (Criteria) this;
        }

        public Criteria andShippingStatusBetween(Byte value1, Byte value2) {
            addCriterion("shipping_status between", value1, value2, "shippingStatus");
            return (Criteria) this;
        }

        public Criteria andShippingStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("shipping_status not between", value1, value2, "shippingStatus");
            return (Criteria) this;
        }

        public Criteria andShipingStartTimeIsNull() {
            addCriterion("shiping_start_time is null");
            return (Criteria) this;
        }

        public Criteria andShipingStartTimeIsNotNull() {
            addCriterion("shiping_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andShipingStartTimeEqualTo(Date value) {
            addCriterion("shiping_start_time =", value, "shipingStartTime");
            return (Criteria) this;
        }

        public Criteria andShipingStartTimeNotEqualTo(Date value) {
            addCriterion("shiping_start_time <>", value, "shipingStartTime");
            return (Criteria) this;
        }

        public Criteria andShipingStartTimeGreaterThan(Date value) {
            addCriterion("shiping_start_time >", value, "shipingStartTime");
            return (Criteria) this;
        }

        public Criteria andShipingStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("shiping_start_time >=", value, "shipingStartTime");
            return (Criteria) this;
        }

        public Criteria andShipingStartTimeLessThan(Date value) {
            addCriterion("shiping_start_time <", value, "shipingStartTime");
            return (Criteria) this;
        }

        public Criteria andShipingStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("shiping_start_time <=", value, "shipingStartTime");
            return (Criteria) this;
        }

        public Criteria andShipingStartTimeIn(List<Date> values) {
            addCriterion("shiping_start_time in", values, "shipingStartTime");
            return (Criteria) this;
        }

        public Criteria andShipingStartTimeNotIn(List<Date> values) {
            addCriterion("shiping_start_time not in", values, "shipingStartTime");
            return (Criteria) this;
        }

        public Criteria andShipingStartTimeBetween(Date value1, Date value2) {
            addCriterion("shiping_start_time between", value1, value2, "shipingStartTime");
            return (Criteria) this;
        }

        public Criteria andShipingStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("shiping_start_time not between", value1, value2, "shipingStartTime");
            return (Criteria) this;
        }

        public Criteria andShipingEndTimeIsNull() {
            addCriterion("shiping_end_time is null");
            return (Criteria) this;
        }

        public Criteria andShipingEndTimeIsNotNull() {
            addCriterion("shiping_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andShipingEndTimeEqualTo(Date value) {
            addCriterion("shiping_end_time =", value, "shipingEndTime");
            return (Criteria) this;
        }

        public Criteria andShipingEndTimeNotEqualTo(Date value) {
            addCriterion("shiping_end_time <>", value, "shipingEndTime");
            return (Criteria) this;
        }

        public Criteria andShipingEndTimeGreaterThan(Date value) {
            addCriterion("shiping_end_time >", value, "shipingEndTime");
            return (Criteria) this;
        }

        public Criteria andShipingEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("shiping_end_time >=", value, "shipingEndTime");
            return (Criteria) this;
        }

        public Criteria andShipingEndTimeLessThan(Date value) {
            addCriterion("shiping_end_time <", value, "shipingEndTime");
            return (Criteria) this;
        }

        public Criteria andShipingEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("shiping_end_time <=", value, "shipingEndTime");
            return (Criteria) this;
        }

        public Criteria andShipingEndTimeIn(List<Date> values) {
            addCriterion("shiping_end_time in", values, "shipingEndTime");
            return (Criteria) this;
        }

        public Criteria andShipingEndTimeNotIn(List<Date> values) {
            addCriterion("shiping_end_time not in", values, "shipingEndTime");
            return (Criteria) this;
        }

        public Criteria andShipingEndTimeBetween(Date value1, Date value2) {
            addCriterion("shiping_end_time between", value1, value2, "shipingEndTime");
            return (Criteria) this;
        }

        public Criteria andShipingEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("shiping_end_time not between", value1, value2, "shipingEndTime");
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