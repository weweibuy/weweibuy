package com.weweibuy.webuy.learning.sharing.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DispatchReceiptExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DispatchReceiptExample() {
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

        public Criteria andBillNoIsNull() {
            addCriterion("bill_no is null");
            return (Criteria) this;
        }

        public Criteria andBillNoIsNotNull() {
            addCriterion("bill_no is not null");
            return (Criteria) this;
        }

        public Criteria andBillNoEqualTo(String value) {
            addCriterion("bill_no =", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotEqualTo(String value) {
            addCriterion("bill_no <>", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoGreaterThan(String value) {
            addCriterion("bill_no >", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoGreaterThanOrEqualTo(String value) {
            addCriterion("bill_no >=", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoLessThan(String value) {
            addCriterion("bill_no <", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoLessThanOrEqualTo(String value) {
            addCriterion("bill_no <=", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoLike(String value) {
            addCriterion("bill_no like", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotLike(String value) {
            addCriterion("bill_no not like", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoIn(List<String> values) {
            addCriterion("bill_no in", values, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotIn(List<String> values) {
            addCriterion("bill_no not in", values, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoBetween(String value1, String value2) {
            addCriterion("bill_no between", value1, value2, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotBetween(String value1, String value2) {
            addCriterion("bill_no not between", value1, value2, "billNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andReceiptIndexIsNull() {
            addCriterion("receipt_index is null");
            return (Criteria) this;
        }

        public Criteria andReceiptIndexIsNotNull() {
            addCriterion("receipt_index is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptIndexEqualTo(Integer value) {
            addCriterion("receipt_index =", value, "receiptIndex");
            return (Criteria) this;
        }

        public Criteria andReceiptIndexNotEqualTo(Integer value) {
            addCriterion("receipt_index <>", value, "receiptIndex");
            return (Criteria) this;
        }

        public Criteria andReceiptIndexGreaterThan(Integer value) {
            addCriterion("receipt_index >", value, "receiptIndex");
            return (Criteria) this;
        }

        public Criteria andReceiptIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("receipt_index >=", value, "receiptIndex");
            return (Criteria) this;
        }

        public Criteria andReceiptIndexLessThan(Integer value) {
            addCriterion("receipt_index <", value, "receiptIndex");
            return (Criteria) this;
        }

        public Criteria andReceiptIndexLessThanOrEqualTo(Integer value) {
            addCriterion("receipt_index <=", value, "receiptIndex");
            return (Criteria) this;
        }

        public Criteria andReceiptIndexIn(List<Integer> values) {
            addCriterion("receipt_index in", values, "receiptIndex");
            return (Criteria) this;
        }

        public Criteria andReceiptIndexNotIn(List<Integer> values) {
            addCriterion("receipt_index not in", values, "receiptIndex");
            return (Criteria) this;
        }

        public Criteria andReceiptIndexBetween(Integer value1, Integer value2) {
            addCriterion("receipt_index between", value1, value2, "receiptIndex");
            return (Criteria) this;
        }

        public Criteria andReceiptIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("receipt_index not between", value1, value2, "receiptIndex");
            return (Criteria) this;
        }

        public Criteria andProcessStatusIsNull() {
            addCriterion("process_status is null");
            return (Criteria) this;
        }

        public Criteria andProcessStatusIsNotNull() {
            addCriterion("process_status is not null");
            return (Criteria) this;
        }

        public Criteria andProcessStatusEqualTo(String value) {
            addCriterion("process_status =", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusNotEqualTo(String value) {
            addCriterion("process_status <>", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusGreaterThan(String value) {
            addCriterion("process_status >", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusGreaterThanOrEqualTo(String value) {
            addCriterion("process_status >=", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusLessThan(String value) {
            addCriterion("process_status <", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusLessThanOrEqualTo(String value) {
            addCriterion("process_status <=", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusLike(String value) {
            addCriterion("process_status like", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusNotLike(String value) {
            addCriterion("process_status not like", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusIn(List<String> values) {
            addCriterion("process_status in", values, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusNotIn(List<String> values) {
            addCriterion("process_status not in", values, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusBetween(String value1, String value2) {
            addCriterion("process_status between", value1, value2, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusNotBetween(String value1, String value2) {
            addCriterion("process_status not between", value1, value2, "processStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIsNull() {
            addCriterion("delivery_time is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIsNotNull() {
            addCriterion("delivery_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeEqualTo(Date value) {
            addCriterion("delivery_time =", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotEqualTo(Date value) {
            addCriterion("delivery_time <>", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThan(Date value) {
            addCriterion("delivery_time >", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("delivery_time >=", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThan(Date value) {
            addCriterion("delivery_time <", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThanOrEqualTo(Date value) {
            addCriterion("delivery_time <=", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIn(List<Date> values) {
            addCriterion("delivery_time in", values, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotIn(List<Date> values) {
            addCriterion("delivery_time not in", values, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeBetween(Date value1, Date value2) {
            addCriterion("delivery_time between", value1, value2, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotBetween(Date value1, Date value2) {
            addCriterion("delivery_time not between", value1, value2, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryNameIsNull() {
            addCriterion("delivery_name is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryNameIsNotNull() {
            addCriterion("delivery_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryNameEqualTo(String value) {
            addCriterion("delivery_name =", value, "deliveryName");
            return (Criteria) this;
        }

        public Criteria andDeliveryNameNotEqualTo(String value) {
            addCriterion("delivery_name <>", value, "deliveryName");
            return (Criteria) this;
        }

        public Criteria andDeliveryNameGreaterThan(String value) {
            addCriterion("delivery_name >", value, "deliveryName");
            return (Criteria) this;
        }

        public Criteria andDeliveryNameGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_name >=", value, "deliveryName");
            return (Criteria) this;
        }

        public Criteria andDeliveryNameLessThan(String value) {
            addCriterion("delivery_name <", value, "deliveryName");
            return (Criteria) this;
        }

        public Criteria andDeliveryNameLessThanOrEqualTo(String value) {
            addCriterion("delivery_name <=", value, "deliveryName");
            return (Criteria) this;
        }

        public Criteria andDeliveryNameLike(String value) {
            addCriterion("delivery_name like", value, "deliveryName");
            return (Criteria) this;
        }

        public Criteria andDeliveryNameNotLike(String value) {
            addCriterion("delivery_name not like", value, "deliveryName");
            return (Criteria) this;
        }

        public Criteria andDeliveryNameIn(List<String> values) {
            addCriterion("delivery_name in", values, "deliveryName");
            return (Criteria) this;
        }

        public Criteria andDeliveryNameNotIn(List<String> values) {
            addCriterion("delivery_name not in", values, "deliveryName");
            return (Criteria) this;
        }

        public Criteria andDeliveryNameBetween(String value1, String value2) {
            addCriterion("delivery_name between", value1, value2, "deliveryName");
            return (Criteria) this;
        }

        public Criteria andDeliveryNameNotBetween(String value1, String value2) {
            addCriterion("delivery_name not between", value1, value2, "deliveryName");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeIsNull() {
            addCriterion("arrival_time is null");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeIsNotNull() {
            addCriterion("arrival_time is not null");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeEqualTo(Date value) {
            addCriterion("arrival_time =", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeNotEqualTo(Date value) {
            addCriterion("arrival_time <>", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeGreaterThan(Date value) {
            addCriterion("arrival_time >", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("arrival_time >=", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeLessThan(Date value) {
            addCriterion("arrival_time <", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeLessThanOrEqualTo(Date value) {
            addCriterion("arrival_time <=", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeIn(List<Date> values) {
            addCriterion("arrival_time in", values, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeNotIn(List<Date> values) {
            addCriterion("arrival_time not in", values, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeBetween(Date value1, Date value2) {
            addCriterion("arrival_time between", value1, value2, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeNotBetween(Date value1, Date value2) {
            addCriterion("arrival_time not between", value1, value2, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryMethodIsNull() {
            addCriterion("delivery_method is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryMethodIsNotNull() {
            addCriterion("delivery_method is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryMethodEqualTo(String value) {
            addCriterion("delivery_method =", value, "deliveryMethod");
            return (Criteria) this;
        }

        public Criteria andDeliveryMethodNotEqualTo(String value) {
            addCriterion("delivery_method <>", value, "deliveryMethod");
            return (Criteria) this;
        }

        public Criteria andDeliveryMethodGreaterThan(String value) {
            addCriterion("delivery_method >", value, "deliveryMethod");
            return (Criteria) this;
        }

        public Criteria andDeliveryMethodGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_method >=", value, "deliveryMethod");
            return (Criteria) this;
        }

        public Criteria andDeliveryMethodLessThan(String value) {
            addCriterion("delivery_method <", value, "deliveryMethod");
            return (Criteria) this;
        }

        public Criteria andDeliveryMethodLessThanOrEqualTo(String value) {
            addCriterion("delivery_method <=", value, "deliveryMethod");
            return (Criteria) this;
        }

        public Criteria andDeliveryMethodLike(String value) {
            addCriterion("delivery_method like", value, "deliveryMethod");
            return (Criteria) this;
        }

        public Criteria andDeliveryMethodNotLike(String value) {
            addCriterion("delivery_method not like", value, "deliveryMethod");
            return (Criteria) this;
        }

        public Criteria andDeliveryMethodIn(List<String> values) {
            addCriterion("delivery_method in", values, "deliveryMethod");
            return (Criteria) this;
        }

        public Criteria andDeliveryMethodNotIn(List<String> values) {
            addCriterion("delivery_method not in", values, "deliveryMethod");
            return (Criteria) this;
        }

        public Criteria andDeliveryMethodBetween(String value1, String value2) {
            addCriterion("delivery_method between", value1, value2, "deliveryMethod");
            return (Criteria) this;
        }

        public Criteria andDeliveryMethodNotBetween(String value1, String value2) {
            addCriterion("delivery_method not between", value1, value2, "deliveryMethod");
            return (Criteria) this;
        }

        public Criteria andTotalPackageAmountIsNull() {
            addCriterion("total_package_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalPackageAmountIsNotNull() {
            addCriterion("total_package_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPackageAmountEqualTo(Integer value) {
            addCriterion("total_package_amount =", value, "totalPackageAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPackageAmountNotEqualTo(Integer value) {
            addCriterion("total_package_amount <>", value, "totalPackageAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPackageAmountGreaterThan(Integer value) {
            addCriterion("total_package_amount >", value, "totalPackageAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPackageAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_package_amount >=", value, "totalPackageAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPackageAmountLessThan(Integer value) {
            addCriterion("total_package_amount <", value, "totalPackageAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPackageAmountLessThanOrEqualTo(Integer value) {
            addCriterion("total_package_amount <=", value, "totalPackageAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPackageAmountIn(List<Integer> values) {
            addCriterion("total_package_amount in", values, "totalPackageAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPackageAmountNotIn(List<Integer> values) {
            addCriterion("total_package_amount not in", values, "totalPackageAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPackageAmountBetween(Integer value1, Integer value2) {
            addCriterion("total_package_amount between", value1, value2, "totalPackageAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPackageAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("total_package_amount not between", value1, value2, "totalPackageAmount");
            return (Criteria) this;
        }

        public Criteria andTotalBoxAmountIsNull() {
            addCriterion("total_box_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalBoxAmountIsNotNull() {
            addCriterion("total_box_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalBoxAmountEqualTo(Integer value) {
            addCriterion("total_box_amount =", value, "totalBoxAmount");
            return (Criteria) this;
        }

        public Criteria andTotalBoxAmountNotEqualTo(Integer value) {
            addCriterion("total_box_amount <>", value, "totalBoxAmount");
            return (Criteria) this;
        }

        public Criteria andTotalBoxAmountGreaterThan(Integer value) {
            addCriterion("total_box_amount >", value, "totalBoxAmount");
            return (Criteria) this;
        }

        public Criteria andTotalBoxAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_box_amount >=", value, "totalBoxAmount");
            return (Criteria) this;
        }

        public Criteria andTotalBoxAmountLessThan(Integer value) {
            addCriterion("total_box_amount <", value, "totalBoxAmount");
            return (Criteria) this;
        }

        public Criteria andTotalBoxAmountLessThanOrEqualTo(Integer value) {
            addCriterion("total_box_amount <=", value, "totalBoxAmount");
            return (Criteria) this;
        }

        public Criteria andTotalBoxAmountIn(List<Integer> values) {
            addCriterion("total_box_amount in", values, "totalBoxAmount");
            return (Criteria) this;
        }

        public Criteria andTotalBoxAmountNotIn(List<Integer> values) {
            addCriterion("total_box_amount not in", values, "totalBoxAmount");
            return (Criteria) this;
        }

        public Criteria andTotalBoxAmountBetween(Integer value1, Integer value2) {
            addCriterion("total_box_amount between", value1, value2, "totalBoxAmount");
            return (Criteria) this;
        }

        public Criteria andTotalBoxAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("total_box_amount not between", value1, value2, "totalBoxAmount");
            return (Criteria) this;
        }

        public Criteria andTotalActualShipmentIsNull() {
            addCriterion("total_actual_shipment is null");
            return (Criteria) this;
        }

        public Criteria andTotalActualShipmentIsNotNull() {
            addCriterion("total_actual_shipment is not null");
            return (Criteria) this;
        }

        public Criteria andTotalActualShipmentEqualTo(Integer value) {
            addCriterion("total_actual_shipment =", value, "totalActualShipment");
            return (Criteria) this;
        }

        public Criteria andTotalActualShipmentNotEqualTo(Integer value) {
            addCriterion("total_actual_shipment <>", value, "totalActualShipment");
            return (Criteria) this;
        }

        public Criteria andTotalActualShipmentGreaterThan(Integer value) {
            addCriterion("total_actual_shipment >", value, "totalActualShipment");
            return (Criteria) this;
        }

        public Criteria andTotalActualShipmentGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_actual_shipment >=", value, "totalActualShipment");
            return (Criteria) this;
        }

        public Criteria andTotalActualShipmentLessThan(Integer value) {
            addCriterion("total_actual_shipment <", value, "totalActualShipment");
            return (Criteria) this;
        }

        public Criteria andTotalActualShipmentLessThanOrEqualTo(Integer value) {
            addCriterion("total_actual_shipment <=", value, "totalActualShipment");
            return (Criteria) this;
        }

        public Criteria andTotalActualShipmentIn(List<Integer> values) {
            addCriterion("total_actual_shipment in", values, "totalActualShipment");
            return (Criteria) this;
        }

        public Criteria andTotalActualShipmentNotIn(List<Integer> values) {
            addCriterion("total_actual_shipment not in", values, "totalActualShipment");
            return (Criteria) this;
        }

        public Criteria andTotalActualShipmentBetween(Integer value1, Integer value2) {
            addCriterion("total_actual_shipment between", value1, value2, "totalActualShipment");
            return (Criteria) this;
        }

        public Criteria andTotalActualShipmentNotBetween(Integer value1, Integer value2) {
            addCriterion("total_actual_shipment not between", value1, value2, "totalActualShipment");
            return (Criteria) this;
        }

        public Criteria andTotalRecordNumIsNull() {
            addCriterion("total_record_num is null");
            return (Criteria) this;
        }

        public Criteria andTotalRecordNumIsNotNull() {
            addCriterion("total_record_num is not null");
            return (Criteria) this;
        }

        public Criteria andTotalRecordNumEqualTo(Integer value) {
            addCriterion("total_record_num =", value, "totalRecordNum");
            return (Criteria) this;
        }

        public Criteria andTotalRecordNumNotEqualTo(Integer value) {
            addCriterion("total_record_num <>", value, "totalRecordNum");
            return (Criteria) this;
        }

        public Criteria andTotalRecordNumGreaterThan(Integer value) {
            addCriterion("total_record_num >", value, "totalRecordNum");
            return (Criteria) this;
        }

        public Criteria andTotalRecordNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_record_num >=", value, "totalRecordNum");
            return (Criteria) this;
        }

        public Criteria andTotalRecordNumLessThan(Integer value) {
            addCriterion("total_record_num <", value, "totalRecordNum");
            return (Criteria) this;
        }

        public Criteria andTotalRecordNumLessThanOrEqualTo(Integer value) {
            addCriterion("total_record_num <=", value, "totalRecordNum");
            return (Criteria) this;
        }

        public Criteria andTotalRecordNumIn(List<Integer> values) {
            addCriterion("total_record_num in", values, "totalRecordNum");
            return (Criteria) this;
        }

        public Criteria andTotalRecordNumNotIn(List<Integer> values) {
            addCriterion("total_record_num not in", values, "totalRecordNum");
            return (Criteria) this;
        }

        public Criteria andTotalRecordNumBetween(Integer value1, Integer value2) {
            addCriterion("total_record_num between", value1, value2, "totalRecordNum");
            return (Criteria) this;
        }

        public Criteria andTotalRecordNumNotBetween(Integer value1, Integer value2) {
            addCriterion("total_record_num not between", value1, value2, "totalRecordNum");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Boolean value) {
            addCriterion("deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Boolean value) {
            addCriterion("deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Boolean value) {
            addCriterion("deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Boolean value) {
            addCriterion("deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Boolean> values) {
            addCriterion("deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Boolean> values) {
            addCriterion("deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("deleted not between", value1, value2, "deleted");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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