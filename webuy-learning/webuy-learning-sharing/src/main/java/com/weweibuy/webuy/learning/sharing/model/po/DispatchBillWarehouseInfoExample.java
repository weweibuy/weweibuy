package com.weweibuy.webuy.learning.sharing.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DispatchBillWarehouseInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DispatchBillWarehouseInfoExample() {
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

        public Criteria andDispatchBillInfoIdIsNull() {
            addCriterion("dispatch_bill_info_id is null");
            return (Criteria) this;
        }

        public Criteria andDispatchBillInfoIdIsNotNull() {
            addCriterion("dispatch_bill_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andDispatchBillInfoIdEqualTo(Long value) {
            addCriterion("dispatch_bill_info_id =", value, "dispatchBillInfoId");
            return (Criteria) this;
        }

        public Criteria andDispatchBillInfoIdNotEqualTo(Long value) {
            addCriterion("dispatch_bill_info_id <>", value, "dispatchBillInfoId");
            return (Criteria) this;
        }

        public Criteria andDispatchBillInfoIdGreaterThan(Long value) {
            addCriterion("dispatch_bill_info_id >", value, "dispatchBillInfoId");
            return (Criteria) this;
        }

        public Criteria andDispatchBillInfoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("dispatch_bill_info_id >=", value, "dispatchBillInfoId");
            return (Criteria) this;
        }

        public Criteria andDispatchBillInfoIdLessThan(Long value) {
            addCriterion("dispatch_bill_info_id <", value, "dispatchBillInfoId");
            return (Criteria) this;
        }

        public Criteria andDispatchBillInfoIdLessThanOrEqualTo(Long value) {
            addCriterion("dispatch_bill_info_id <=", value, "dispatchBillInfoId");
            return (Criteria) this;
        }

        public Criteria andDispatchBillInfoIdIn(List<Long> values) {
            addCriterion("dispatch_bill_info_id in", values, "dispatchBillInfoId");
            return (Criteria) this;
        }

        public Criteria andDispatchBillInfoIdNotIn(List<Long> values) {
            addCriterion("dispatch_bill_info_id not in", values, "dispatchBillInfoId");
            return (Criteria) this;
        }

        public Criteria andDispatchBillInfoIdBetween(Long value1, Long value2) {
            addCriterion("dispatch_bill_info_id between", value1, value2, "dispatchBillInfoId");
            return (Criteria) this;
        }

        public Criteria andDispatchBillInfoIdNotBetween(Long value1, Long value2) {
            addCriterion("dispatch_bill_info_id not between", value1, value2, "dispatchBillInfoId");
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

        public Criteria andWarehouseIdIsNull() {
            addCriterion("warehouse_id is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdIsNotNull() {
            addCriterion("warehouse_id is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdEqualTo(String value) {
            addCriterion("warehouse_id =", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdNotEqualTo(String value) {
            addCriterion("warehouse_id <>", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdGreaterThan(String value) {
            addCriterion("warehouse_id >", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdGreaterThanOrEqualTo(String value) {
            addCriterion("warehouse_id >=", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdLessThan(String value) {
            addCriterion("warehouse_id <", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdLessThanOrEqualTo(String value) {
            addCriterion("warehouse_id <=", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdLike(String value) {
            addCriterion("warehouse_id like", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdNotLike(String value) {
            addCriterion("warehouse_id not like", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdIn(List<String> values) {
            addCriterion("warehouse_id in", values, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdNotIn(List<String> values) {
            addCriterion("warehouse_id not in", values, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdBetween(String value1, String value2) {
            addCriterion("warehouse_id between", value1, value2, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdNotBetween(String value1, String value2) {
            addCriterion("warehouse_id not between", value1, value2, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseCodeIsNull() {
            addCriterion("warehouse_code is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseCodeIsNotNull() {
            addCriterion("warehouse_code is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseCodeEqualTo(String value) {
            addCriterion("warehouse_code =", value, "warehouseCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseCodeNotEqualTo(String value) {
            addCriterion("warehouse_code <>", value, "warehouseCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseCodeGreaterThan(String value) {
            addCriterion("warehouse_code >", value, "warehouseCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("warehouse_code >=", value, "warehouseCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseCodeLessThan(String value) {
            addCriterion("warehouse_code <", value, "warehouseCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseCodeLessThanOrEqualTo(String value) {
            addCriterion("warehouse_code <=", value, "warehouseCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseCodeLike(String value) {
            addCriterion("warehouse_code like", value, "warehouseCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseCodeNotLike(String value) {
            addCriterion("warehouse_code not like", value, "warehouseCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseCodeIn(List<String> values) {
            addCriterion("warehouse_code in", values, "warehouseCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseCodeNotIn(List<String> values) {
            addCriterion("warehouse_code not in", values, "warehouseCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseCodeBetween(String value1, String value2) {
            addCriterion("warehouse_code between", value1, value2, "warehouseCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseCodeNotBetween(String value1, String value2) {
            addCriterion("warehouse_code not between", value1, value2, "warehouseCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameIsNull() {
            addCriterion("warehouse_name is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameIsNotNull() {
            addCriterion("warehouse_name is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameEqualTo(String value) {
            addCriterion("warehouse_name =", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameNotEqualTo(String value) {
            addCriterion("warehouse_name <>", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameGreaterThan(String value) {
            addCriterion("warehouse_name >", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameGreaterThanOrEqualTo(String value) {
            addCriterion("warehouse_name >=", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameLessThan(String value) {
            addCriterion("warehouse_name <", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameLessThanOrEqualTo(String value) {
            addCriterion("warehouse_name <=", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameLike(String value) {
            addCriterion("warehouse_name like", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameNotLike(String value) {
            addCriterion("warehouse_name not like", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameIn(List<String> values) {
            addCriterion("warehouse_name in", values, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameNotIn(List<String> values) {
            addCriterion("warehouse_name not in", values, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameBetween(String value1, String value2) {
            addCriterion("warehouse_name between", value1, value2, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameNotBetween(String value1, String value2) {
            addCriterion("warehouse_name not between", value1, value2, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andBwWarehouseCodeIsNull() {
            addCriterion("bw_warehouse_code is null");
            return (Criteria) this;
        }

        public Criteria andBwWarehouseCodeIsNotNull() {
            addCriterion("bw_warehouse_code is not null");
            return (Criteria) this;
        }

        public Criteria andBwWarehouseCodeEqualTo(String value) {
            addCriterion("bw_warehouse_code =", value, "bwWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwWarehouseCodeNotEqualTo(String value) {
            addCriterion("bw_warehouse_code <>", value, "bwWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwWarehouseCodeGreaterThan(String value) {
            addCriterion("bw_warehouse_code >", value, "bwWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwWarehouseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("bw_warehouse_code >=", value, "bwWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwWarehouseCodeLessThan(String value) {
            addCriterion("bw_warehouse_code <", value, "bwWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwWarehouseCodeLessThanOrEqualTo(String value) {
            addCriterion("bw_warehouse_code <=", value, "bwWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwWarehouseCodeLike(String value) {
            addCriterion("bw_warehouse_code like", value, "bwWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwWarehouseCodeNotLike(String value) {
            addCriterion("bw_warehouse_code not like", value, "bwWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwWarehouseCodeIn(List<String> values) {
            addCriterion("bw_warehouse_code in", values, "bwWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwWarehouseCodeNotIn(List<String> values) {
            addCriterion("bw_warehouse_code not in", values, "bwWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwWarehouseCodeBetween(String value1, String value2) {
            addCriterion("bw_warehouse_code between", value1, value2, "bwWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwWarehouseCodeNotBetween(String value1, String value2) {
            addCriterion("bw_warehouse_code not between", value1, value2, "bwWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseTypeIsNull() {
            addCriterion("warehouse_type is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseTypeIsNotNull() {
            addCriterion("warehouse_type is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseTypeEqualTo(Short value) {
            addCriterion("warehouse_type =", value, "warehouseType");
            return (Criteria) this;
        }

        public Criteria andWarehouseTypeNotEqualTo(Short value) {
            addCriterion("warehouse_type <>", value, "warehouseType");
            return (Criteria) this;
        }

        public Criteria andWarehouseTypeGreaterThan(Short value) {
            addCriterion("warehouse_type >", value, "warehouseType");
            return (Criteria) this;
        }

        public Criteria andWarehouseTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("warehouse_type >=", value, "warehouseType");
            return (Criteria) this;
        }

        public Criteria andWarehouseTypeLessThan(Short value) {
            addCriterion("warehouse_type <", value, "warehouseType");
            return (Criteria) this;
        }

        public Criteria andWarehouseTypeLessThanOrEqualTo(Short value) {
            addCriterion("warehouse_type <=", value, "warehouseType");
            return (Criteria) this;
        }

        public Criteria andWarehouseTypeIn(List<Short> values) {
            addCriterion("warehouse_type in", values, "warehouseType");
            return (Criteria) this;
        }

        public Criteria andWarehouseTypeNotIn(List<Short> values) {
            addCriterion("warehouse_type not in", values, "warehouseType");
            return (Criteria) this;
        }

        public Criteria andWarehouseTypeBetween(Short value1, Short value2) {
            addCriterion("warehouse_type between", value1, value2, "warehouseType");
            return (Criteria) this;
        }

        public Criteria andWarehouseTypeNotBetween(Short value1, Short value2) {
            addCriterion("warehouse_type not between", value1, value2, "warehouseType");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseIdIsNull() {
            addCriterion("inter_warehouse_id is null");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseIdIsNotNull() {
            addCriterion("inter_warehouse_id is not null");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseIdEqualTo(String value) {
            addCriterion("inter_warehouse_id =", value, "interWarehouseId");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseIdNotEqualTo(String value) {
            addCriterion("inter_warehouse_id <>", value, "interWarehouseId");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseIdGreaterThan(String value) {
            addCriterion("inter_warehouse_id >", value, "interWarehouseId");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseIdGreaterThanOrEqualTo(String value) {
            addCriterion("inter_warehouse_id >=", value, "interWarehouseId");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseIdLessThan(String value) {
            addCriterion("inter_warehouse_id <", value, "interWarehouseId");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseIdLessThanOrEqualTo(String value) {
            addCriterion("inter_warehouse_id <=", value, "interWarehouseId");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseIdLike(String value) {
            addCriterion("inter_warehouse_id like", value, "interWarehouseId");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseIdNotLike(String value) {
            addCriterion("inter_warehouse_id not like", value, "interWarehouseId");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseIdIn(List<String> values) {
            addCriterion("inter_warehouse_id in", values, "interWarehouseId");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseIdNotIn(List<String> values) {
            addCriterion("inter_warehouse_id not in", values, "interWarehouseId");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseIdBetween(String value1, String value2) {
            addCriterion("inter_warehouse_id between", value1, value2, "interWarehouseId");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseIdNotBetween(String value1, String value2) {
            addCriterion("inter_warehouse_id not between", value1, value2, "interWarehouseId");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseCodeIsNull() {
            addCriterion("inter_warehouse_code is null");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseCodeIsNotNull() {
            addCriterion("inter_warehouse_code is not null");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseCodeEqualTo(String value) {
            addCriterion("inter_warehouse_code =", value, "interWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseCodeNotEqualTo(String value) {
            addCriterion("inter_warehouse_code <>", value, "interWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseCodeGreaterThan(String value) {
            addCriterion("inter_warehouse_code >", value, "interWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("inter_warehouse_code >=", value, "interWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseCodeLessThan(String value) {
            addCriterion("inter_warehouse_code <", value, "interWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseCodeLessThanOrEqualTo(String value) {
            addCriterion("inter_warehouse_code <=", value, "interWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseCodeLike(String value) {
            addCriterion("inter_warehouse_code like", value, "interWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseCodeNotLike(String value) {
            addCriterion("inter_warehouse_code not like", value, "interWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseCodeIn(List<String> values) {
            addCriterion("inter_warehouse_code in", values, "interWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseCodeNotIn(List<String> values) {
            addCriterion("inter_warehouse_code not in", values, "interWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseCodeBetween(String value1, String value2) {
            addCriterion("inter_warehouse_code between", value1, value2, "interWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseCodeNotBetween(String value1, String value2) {
            addCriterion("inter_warehouse_code not between", value1, value2, "interWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseNameIsNull() {
            addCriterion("inter_warehouse_name is null");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseNameIsNotNull() {
            addCriterion("inter_warehouse_name is not null");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseNameEqualTo(String value) {
            addCriterion("inter_warehouse_name =", value, "interWarehouseName");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseNameNotEqualTo(String value) {
            addCriterion("inter_warehouse_name <>", value, "interWarehouseName");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseNameGreaterThan(String value) {
            addCriterion("inter_warehouse_name >", value, "interWarehouseName");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseNameGreaterThanOrEqualTo(String value) {
            addCriterion("inter_warehouse_name >=", value, "interWarehouseName");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseNameLessThan(String value) {
            addCriterion("inter_warehouse_name <", value, "interWarehouseName");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseNameLessThanOrEqualTo(String value) {
            addCriterion("inter_warehouse_name <=", value, "interWarehouseName");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseNameLike(String value) {
            addCriterion("inter_warehouse_name like", value, "interWarehouseName");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseNameNotLike(String value) {
            addCriterion("inter_warehouse_name not like", value, "interWarehouseName");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseNameIn(List<String> values) {
            addCriterion("inter_warehouse_name in", values, "interWarehouseName");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseNameNotIn(List<String> values) {
            addCriterion("inter_warehouse_name not in", values, "interWarehouseName");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseNameBetween(String value1, String value2) {
            addCriterion("inter_warehouse_name between", value1, value2, "interWarehouseName");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseNameNotBetween(String value1, String value2) {
            addCriterion("inter_warehouse_name not between", value1, value2, "interWarehouseName");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseTypeIsNull() {
            addCriterion("inter_warehouse_type is null");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseTypeIsNotNull() {
            addCriterion("inter_warehouse_type is not null");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseTypeEqualTo(Short value) {
            addCriterion("inter_warehouse_type =", value, "interWarehouseType");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseTypeNotEqualTo(Short value) {
            addCriterion("inter_warehouse_type <>", value, "interWarehouseType");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseTypeGreaterThan(Short value) {
            addCriterion("inter_warehouse_type >", value, "interWarehouseType");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("inter_warehouse_type >=", value, "interWarehouseType");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseTypeLessThan(Short value) {
            addCriterion("inter_warehouse_type <", value, "interWarehouseType");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseTypeLessThanOrEqualTo(Short value) {
            addCriterion("inter_warehouse_type <=", value, "interWarehouseType");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseTypeIn(List<Short> values) {
            addCriterion("inter_warehouse_type in", values, "interWarehouseType");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseTypeNotIn(List<Short> values) {
            addCriterion("inter_warehouse_type not in", values, "interWarehouseType");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseTypeBetween(Short value1, Short value2) {
            addCriterion("inter_warehouse_type between", value1, value2, "interWarehouseType");
            return (Criteria) this;
        }

        public Criteria andInterWarehouseTypeNotBetween(Short value1, Short value2) {
            addCriterion("inter_warehouse_type not between", value1, value2, "interWarehouseType");
            return (Criteria) this;
        }

        public Criteria andExpectOutTimeIsNull() {
            addCriterion("expect_out_time is null");
            return (Criteria) this;
        }

        public Criteria andExpectOutTimeIsNotNull() {
            addCriterion("expect_out_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpectOutTimeEqualTo(Date value) {
            addCriterion("expect_out_time =", value, "expectOutTime");
            return (Criteria) this;
        }

        public Criteria andExpectOutTimeNotEqualTo(Date value) {
            addCriterion("expect_out_time <>", value, "expectOutTime");
            return (Criteria) this;
        }

        public Criteria andExpectOutTimeGreaterThan(Date value) {
            addCriterion("expect_out_time >", value, "expectOutTime");
            return (Criteria) this;
        }

        public Criteria andExpectOutTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("expect_out_time >=", value, "expectOutTime");
            return (Criteria) this;
        }

        public Criteria andExpectOutTimeLessThan(Date value) {
            addCriterion("expect_out_time <", value, "expectOutTime");
            return (Criteria) this;
        }

        public Criteria andExpectOutTimeLessThanOrEqualTo(Date value) {
            addCriterion("expect_out_time <=", value, "expectOutTime");
            return (Criteria) this;
        }

        public Criteria andExpectOutTimeIn(List<Date> values) {
            addCriterion("expect_out_time in", values, "expectOutTime");
            return (Criteria) this;
        }

        public Criteria andExpectOutTimeNotIn(List<Date> values) {
            addCriterion("expect_out_time not in", values, "expectOutTime");
            return (Criteria) this;
        }

        public Criteria andExpectOutTimeBetween(Date value1, Date value2) {
            addCriterion("expect_out_time between", value1, value2, "expectOutTime");
            return (Criteria) this;
        }

        public Criteria andExpectOutTimeNotBetween(Date value1, Date value2) {
            addCriterion("expect_out_time not between", value1, value2, "expectOutTime");
            return (Criteria) this;
        }

        public Criteria andExpressTypeIsNull() {
            addCriterion("express_type is null");
            return (Criteria) this;
        }

        public Criteria andExpressTypeIsNotNull() {
            addCriterion("express_type is not null");
            return (Criteria) this;
        }

        public Criteria andExpressTypeEqualTo(String value) {
            addCriterion("express_type =", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeNotEqualTo(String value) {
            addCriterion("express_type <>", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeGreaterThan(String value) {
            addCriterion("express_type >", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeGreaterThanOrEqualTo(String value) {
            addCriterion("express_type >=", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeLessThan(String value) {
            addCriterion("express_type <", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeLessThanOrEqualTo(String value) {
            addCriterion("express_type <=", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeLike(String value) {
            addCriterion("express_type like", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeNotLike(String value) {
            addCriterion("express_type not like", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeIn(List<String> values) {
            addCriterion("express_type in", values, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeNotIn(List<String> values) {
            addCriterion("express_type not in", values, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeBetween(String value1, String value2) {
            addCriterion("express_type between", value1, value2, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeNotBetween(String value1, String value2) {
            addCriterion("express_type not between", value1, value2, "expressType");
            return (Criteria) this;
        }

        public Criteria andFreightModeFlagIsNull() {
            addCriterion("freight_mode_flag is null");
            return (Criteria) this;
        }

        public Criteria andFreightModeFlagIsNotNull() {
            addCriterion("freight_mode_flag is not null");
            return (Criteria) this;
        }

        public Criteria andFreightModeFlagEqualTo(Boolean value) {
            addCriterion("freight_mode_flag =", value, "freightModeFlag");
            return (Criteria) this;
        }

        public Criteria andFreightModeFlagNotEqualTo(Boolean value) {
            addCriterion("freight_mode_flag <>", value, "freightModeFlag");
            return (Criteria) this;
        }

        public Criteria andFreightModeFlagGreaterThan(Boolean value) {
            addCriterion("freight_mode_flag >", value, "freightModeFlag");
            return (Criteria) this;
        }

        public Criteria andFreightModeFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("freight_mode_flag >=", value, "freightModeFlag");
            return (Criteria) this;
        }

        public Criteria andFreightModeFlagLessThan(Boolean value) {
            addCriterion("freight_mode_flag <", value, "freightModeFlag");
            return (Criteria) this;
        }

        public Criteria andFreightModeFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("freight_mode_flag <=", value, "freightModeFlag");
            return (Criteria) this;
        }

        public Criteria andFreightModeFlagIn(List<Boolean> values) {
            addCriterion("freight_mode_flag in", values, "freightModeFlag");
            return (Criteria) this;
        }

        public Criteria andFreightModeFlagNotIn(List<Boolean> values) {
            addCriterion("freight_mode_flag not in", values, "freightModeFlag");
            return (Criteria) this;
        }

        public Criteria andFreightModeFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("freight_mode_flag between", value1, value2, "freightModeFlag");
            return (Criteria) this;
        }

        public Criteria andFreightModeFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("freight_mode_flag not between", value1, value2, "freightModeFlag");
            return (Criteria) this;
        }

        public Criteria andExpressBillNoIsNull() {
            addCriterion("express_bill_no is null");
            return (Criteria) this;
        }

        public Criteria andExpressBillNoIsNotNull() {
            addCriterion("express_bill_no is not null");
            return (Criteria) this;
        }

        public Criteria andExpressBillNoEqualTo(String value) {
            addCriterion("express_bill_no =", value, "expressBillNo");
            return (Criteria) this;
        }

        public Criteria andExpressBillNoNotEqualTo(String value) {
            addCriterion("express_bill_no <>", value, "expressBillNo");
            return (Criteria) this;
        }

        public Criteria andExpressBillNoGreaterThan(String value) {
            addCriterion("express_bill_no >", value, "expressBillNo");
            return (Criteria) this;
        }

        public Criteria andExpressBillNoGreaterThanOrEqualTo(String value) {
            addCriterion("express_bill_no >=", value, "expressBillNo");
            return (Criteria) this;
        }

        public Criteria andExpressBillNoLessThan(String value) {
            addCriterion("express_bill_no <", value, "expressBillNo");
            return (Criteria) this;
        }

        public Criteria andExpressBillNoLessThanOrEqualTo(String value) {
            addCriterion("express_bill_no <=", value, "expressBillNo");
            return (Criteria) this;
        }

        public Criteria andExpressBillNoLike(String value) {
            addCriterion("express_bill_no like", value, "expressBillNo");
            return (Criteria) this;
        }

        public Criteria andExpressBillNoNotLike(String value) {
            addCriterion("express_bill_no not like", value, "expressBillNo");
            return (Criteria) this;
        }

        public Criteria andExpressBillNoIn(List<String> values) {
            addCriterion("express_bill_no in", values, "expressBillNo");
            return (Criteria) this;
        }

        public Criteria andExpressBillNoNotIn(List<String> values) {
            addCriterion("express_bill_no not in", values, "expressBillNo");
            return (Criteria) this;
        }

        public Criteria andExpressBillNoBetween(String value1, String value2) {
            addCriterion("express_bill_no between", value1, value2, "expressBillNo");
            return (Criteria) this;
        }

        public Criteria andExpressBillNoNotBetween(String value1, String value2) {
            addCriterion("express_bill_no not between", value1, value2, "expressBillNo");
            return (Criteria) this;
        }

        public Criteria andFreightCompanyCodeIsNull() {
            addCriterion("freight_company_code is null");
            return (Criteria) this;
        }

        public Criteria andFreightCompanyCodeIsNotNull() {
            addCriterion("freight_company_code is not null");
            return (Criteria) this;
        }

        public Criteria andFreightCompanyCodeEqualTo(String value) {
            addCriterion("freight_company_code =", value, "freightCompanyCode");
            return (Criteria) this;
        }

        public Criteria andFreightCompanyCodeNotEqualTo(String value) {
            addCriterion("freight_company_code <>", value, "freightCompanyCode");
            return (Criteria) this;
        }

        public Criteria andFreightCompanyCodeGreaterThan(String value) {
            addCriterion("freight_company_code >", value, "freightCompanyCode");
            return (Criteria) this;
        }

        public Criteria andFreightCompanyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("freight_company_code >=", value, "freightCompanyCode");
            return (Criteria) this;
        }

        public Criteria andFreightCompanyCodeLessThan(String value) {
            addCriterion("freight_company_code <", value, "freightCompanyCode");
            return (Criteria) this;
        }

        public Criteria andFreightCompanyCodeLessThanOrEqualTo(String value) {
            addCriterion("freight_company_code <=", value, "freightCompanyCode");
            return (Criteria) this;
        }

        public Criteria andFreightCompanyCodeLike(String value) {
            addCriterion("freight_company_code like", value, "freightCompanyCode");
            return (Criteria) this;
        }

        public Criteria andFreightCompanyCodeNotLike(String value) {
            addCriterion("freight_company_code not like", value, "freightCompanyCode");
            return (Criteria) this;
        }

        public Criteria andFreightCompanyCodeIn(List<String> values) {
            addCriterion("freight_company_code in", values, "freightCompanyCode");
            return (Criteria) this;
        }

        public Criteria andFreightCompanyCodeNotIn(List<String> values) {
            addCriterion("freight_company_code not in", values, "freightCompanyCode");
            return (Criteria) this;
        }

        public Criteria andFreightCompanyCodeBetween(String value1, String value2) {
            addCriterion("freight_company_code between", value1, value2, "freightCompanyCode");
            return (Criteria) this;
        }

        public Criteria andFreightCompanyCodeNotBetween(String value1, String value2) {
            addCriterion("freight_company_code not between", value1, value2, "freightCompanyCode");
            return (Criteria) this;
        }

        public Criteria andTransportMethodCodeIsNull() {
            addCriterion("transport_method_code is null");
            return (Criteria) this;
        }

        public Criteria andTransportMethodCodeIsNotNull() {
            addCriterion("transport_method_code is not null");
            return (Criteria) this;
        }

        public Criteria andTransportMethodCodeEqualTo(String value) {
            addCriterion("transport_method_code =", value, "transportMethodCode");
            return (Criteria) this;
        }

        public Criteria andTransportMethodCodeNotEqualTo(String value) {
            addCriterion("transport_method_code <>", value, "transportMethodCode");
            return (Criteria) this;
        }

        public Criteria andTransportMethodCodeGreaterThan(String value) {
            addCriterion("transport_method_code >", value, "transportMethodCode");
            return (Criteria) this;
        }

        public Criteria andTransportMethodCodeGreaterThanOrEqualTo(String value) {
            addCriterion("transport_method_code >=", value, "transportMethodCode");
            return (Criteria) this;
        }

        public Criteria andTransportMethodCodeLessThan(String value) {
            addCriterion("transport_method_code <", value, "transportMethodCode");
            return (Criteria) this;
        }

        public Criteria andTransportMethodCodeLessThanOrEqualTo(String value) {
            addCriterion("transport_method_code <=", value, "transportMethodCode");
            return (Criteria) this;
        }

        public Criteria andTransportMethodCodeLike(String value) {
            addCriterion("transport_method_code like", value, "transportMethodCode");
            return (Criteria) this;
        }

        public Criteria andTransportMethodCodeNotLike(String value) {
            addCriterion("transport_method_code not like", value, "transportMethodCode");
            return (Criteria) this;
        }

        public Criteria andTransportMethodCodeIn(List<String> values) {
            addCriterion("transport_method_code in", values, "transportMethodCode");
            return (Criteria) this;
        }

        public Criteria andTransportMethodCodeNotIn(List<String> values) {
            addCriterion("transport_method_code not in", values, "transportMethodCode");
            return (Criteria) this;
        }

        public Criteria andTransportMethodCodeBetween(String value1, String value2) {
            addCriterion("transport_method_code between", value1, value2, "transportMethodCode");
            return (Criteria) this;
        }

        public Criteria andTransportMethodCodeNotBetween(String value1, String value2) {
            addCriterion("transport_method_code not between", value1, value2, "transportMethodCode");
            return (Criteria) this;
        }

        public Criteria andTransportMethodNameIsNull() {
            addCriterion("transport_method_name is null");
            return (Criteria) this;
        }

        public Criteria andTransportMethodNameIsNotNull() {
            addCriterion("transport_method_name is not null");
            return (Criteria) this;
        }

        public Criteria andTransportMethodNameEqualTo(String value) {
            addCriterion("transport_method_name =", value, "transportMethodName");
            return (Criteria) this;
        }

        public Criteria andTransportMethodNameNotEqualTo(String value) {
            addCriterion("transport_method_name <>", value, "transportMethodName");
            return (Criteria) this;
        }

        public Criteria andTransportMethodNameGreaterThan(String value) {
            addCriterion("transport_method_name >", value, "transportMethodName");
            return (Criteria) this;
        }

        public Criteria andTransportMethodNameGreaterThanOrEqualTo(String value) {
            addCriterion("transport_method_name >=", value, "transportMethodName");
            return (Criteria) this;
        }

        public Criteria andTransportMethodNameLessThan(String value) {
            addCriterion("transport_method_name <", value, "transportMethodName");
            return (Criteria) this;
        }

        public Criteria andTransportMethodNameLessThanOrEqualTo(String value) {
            addCriterion("transport_method_name <=", value, "transportMethodName");
            return (Criteria) this;
        }

        public Criteria andTransportMethodNameLike(String value) {
            addCriterion("transport_method_name like", value, "transportMethodName");
            return (Criteria) this;
        }

        public Criteria andTransportMethodNameNotLike(String value) {
            addCriterion("transport_method_name not like", value, "transportMethodName");
            return (Criteria) this;
        }

        public Criteria andTransportMethodNameIn(List<String> values) {
            addCriterion("transport_method_name in", values, "transportMethodName");
            return (Criteria) this;
        }

        public Criteria andTransportMethodNameNotIn(List<String> values) {
            addCriterion("transport_method_name not in", values, "transportMethodName");
            return (Criteria) this;
        }

        public Criteria andTransportMethodNameBetween(String value1, String value2) {
            addCriterion("transport_method_name between", value1, value2, "transportMethodName");
            return (Criteria) this;
        }

        public Criteria andTransportMethodNameNotBetween(String value1, String value2) {
            addCriterion("transport_method_name not between", value1, value2, "transportMethodName");
            return (Criteria) this;
        }

        public Criteria andAllocateTypeIsNull() {
            addCriterion("allocate_type is null");
            return (Criteria) this;
        }

        public Criteria andAllocateTypeIsNotNull() {
            addCriterion("allocate_type is not null");
            return (Criteria) this;
        }

        public Criteria andAllocateTypeEqualTo(String value) {
            addCriterion("allocate_type =", value, "allocateType");
            return (Criteria) this;
        }

        public Criteria andAllocateTypeNotEqualTo(String value) {
            addCriterion("allocate_type <>", value, "allocateType");
            return (Criteria) this;
        }

        public Criteria andAllocateTypeGreaterThan(String value) {
            addCriterion("allocate_type >", value, "allocateType");
            return (Criteria) this;
        }

        public Criteria andAllocateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("allocate_type >=", value, "allocateType");
            return (Criteria) this;
        }

        public Criteria andAllocateTypeLessThan(String value) {
            addCriterion("allocate_type <", value, "allocateType");
            return (Criteria) this;
        }

        public Criteria andAllocateTypeLessThanOrEqualTo(String value) {
            addCriterion("allocate_type <=", value, "allocateType");
            return (Criteria) this;
        }

        public Criteria andAllocateTypeLike(String value) {
            addCriterion("allocate_type like", value, "allocateType");
            return (Criteria) this;
        }

        public Criteria andAllocateTypeNotLike(String value) {
            addCriterion("allocate_type not like", value, "allocateType");
            return (Criteria) this;
        }

        public Criteria andAllocateTypeIn(List<String> values) {
            addCriterion("allocate_type in", values, "allocateType");
            return (Criteria) this;
        }

        public Criteria andAllocateTypeNotIn(List<String> values) {
            addCriterion("allocate_type not in", values, "allocateType");
            return (Criteria) this;
        }

        public Criteria andAllocateTypeBetween(String value1, String value2) {
            addCriterion("allocate_type between", value1, value2, "allocateType");
            return (Criteria) this;
        }

        public Criteria andAllocateTypeNotBetween(String value1, String value2) {
            addCriterion("allocate_type not between", value1, value2, "allocateType");
            return (Criteria) this;
        }

        public Criteria andAllocatePriorityIsNull() {
            addCriterion("allocate_priority is null");
            return (Criteria) this;
        }

        public Criteria andAllocatePriorityIsNotNull() {
            addCriterion("allocate_priority is not null");
            return (Criteria) this;
        }

        public Criteria andAllocatePriorityEqualTo(String value) {
            addCriterion("allocate_priority =", value, "allocatePriority");
            return (Criteria) this;
        }

        public Criteria andAllocatePriorityNotEqualTo(String value) {
            addCriterion("allocate_priority <>", value, "allocatePriority");
            return (Criteria) this;
        }

        public Criteria andAllocatePriorityGreaterThan(String value) {
            addCriterion("allocate_priority >", value, "allocatePriority");
            return (Criteria) this;
        }

        public Criteria andAllocatePriorityGreaterThanOrEqualTo(String value) {
            addCriterion("allocate_priority >=", value, "allocatePriority");
            return (Criteria) this;
        }

        public Criteria andAllocatePriorityLessThan(String value) {
            addCriterion("allocate_priority <", value, "allocatePriority");
            return (Criteria) this;
        }

        public Criteria andAllocatePriorityLessThanOrEqualTo(String value) {
            addCriterion("allocate_priority <=", value, "allocatePriority");
            return (Criteria) this;
        }

        public Criteria andAllocatePriorityLike(String value) {
            addCriterion("allocate_priority like", value, "allocatePriority");
            return (Criteria) this;
        }

        public Criteria andAllocatePriorityNotLike(String value) {
            addCriterion("allocate_priority not like", value, "allocatePriority");
            return (Criteria) this;
        }

        public Criteria andAllocatePriorityIn(List<String> values) {
            addCriterion("allocate_priority in", values, "allocatePriority");
            return (Criteria) this;
        }

        public Criteria andAllocatePriorityNotIn(List<String> values) {
            addCriterion("allocate_priority not in", values, "allocatePriority");
            return (Criteria) this;
        }

        public Criteria andAllocatePriorityBetween(String value1, String value2) {
            addCriterion("allocate_priority between", value1, value2, "allocatePriority");
            return (Criteria) this;
        }

        public Criteria andAllocatePriorityNotBetween(String value1, String value2) {
            addCriterion("allocate_priority not between", value1, value2, "allocatePriority");
            return (Criteria) this;
        }

        public Criteria andAllocateModeCodeIsNull() {
            addCriterion("allocate_mode_code is null");
            return (Criteria) this;
        }

        public Criteria andAllocateModeCodeIsNotNull() {
            addCriterion("allocate_mode_code is not null");
            return (Criteria) this;
        }

        public Criteria andAllocateModeCodeEqualTo(String value) {
            addCriterion("allocate_mode_code =", value, "allocateModeCode");
            return (Criteria) this;
        }

        public Criteria andAllocateModeCodeNotEqualTo(String value) {
            addCriterion("allocate_mode_code <>", value, "allocateModeCode");
            return (Criteria) this;
        }

        public Criteria andAllocateModeCodeGreaterThan(String value) {
            addCriterion("allocate_mode_code >", value, "allocateModeCode");
            return (Criteria) this;
        }

        public Criteria andAllocateModeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("allocate_mode_code >=", value, "allocateModeCode");
            return (Criteria) this;
        }

        public Criteria andAllocateModeCodeLessThan(String value) {
            addCriterion("allocate_mode_code <", value, "allocateModeCode");
            return (Criteria) this;
        }

        public Criteria andAllocateModeCodeLessThanOrEqualTo(String value) {
            addCriterion("allocate_mode_code <=", value, "allocateModeCode");
            return (Criteria) this;
        }

        public Criteria andAllocateModeCodeLike(String value) {
            addCriterion("allocate_mode_code like", value, "allocateModeCode");
            return (Criteria) this;
        }

        public Criteria andAllocateModeCodeNotLike(String value) {
            addCriterion("allocate_mode_code not like", value, "allocateModeCode");
            return (Criteria) this;
        }

        public Criteria andAllocateModeCodeIn(List<String> values) {
            addCriterion("allocate_mode_code in", values, "allocateModeCode");
            return (Criteria) this;
        }

        public Criteria andAllocateModeCodeNotIn(List<String> values) {
            addCriterion("allocate_mode_code not in", values, "allocateModeCode");
            return (Criteria) this;
        }

        public Criteria andAllocateModeCodeBetween(String value1, String value2) {
            addCriterion("allocate_mode_code between", value1, value2, "allocateModeCode");
            return (Criteria) this;
        }

        public Criteria andAllocateModeCodeNotBetween(String value1, String value2) {
            addCriterion("allocate_mode_code not between", value1, value2, "allocateModeCode");
            return (Criteria) this;
        }

        public Criteria andAllocateModeNameIsNull() {
            addCriterion("allocate_mode_name is null");
            return (Criteria) this;
        }

        public Criteria andAllocateModeNameIsNotNull() {
            addCriterion("allocate_mode_name is not null");
            return (Criteria) this;
        }

        public Criteria andAllocateModeNameEqualTo(String value) {
            addCriterion("allocate_mode_name =", value, "allocateModeName");
            return (Criteria) this;
        }

        public Criteria andAllocateModeNameNotEqualTo(String value) {
            addCriterion("allocate_mode_name <>", value, "allocateModeName");
            return (Criteria) this;
        }

        public Criteria andAllocateModeNameGreaterThan(String value) {
            addCriterion("allocate_mode_name >", value, "allocateModeName");
            return (Criteria) this;
        }

        public Criteria andAllocateModeNameGreaterThanOrEqualTo(String value) {
            addCriterion("allocate_mode_name >=", value, "allocateModeName");
            return (Criteria) this;
        }

        public Criteria andAllocateModeNameLessThan(String value) {
            addCriterion("allocate_mode_name <", value, "allocateModeName");
            return (Criteria) this;
        }

        public Criteria andAllocateModeNameLessThanOrEqualTo(String value) {
            addCriterion("allocate_mode_name <=", value, "allocateModeName");
            return (Criteria) this;
        }

        public Criteria andAllocateModeNameLike(String value) {
            addCriterion("allocate_mode_name like", value, "allocateModeName");
            return (Criteria) this;
        }

        public Criteria andAllocateModeNameNotLike(String value) {
            addCriterion("allocate_mode_name not like", value, "allocateModeName");
            return (Criteria) this;
        }

        public Criteria andAllocateModeNameIn(List<String> values) {
            addCriterion("allocate_mode_name in", values, "allocateModeName");
            return (Criteria) this;
        }

        public Criteria andAllocateModeNameNotIn(List<String> values) {
            addCriterion("allocate_mode_name not in", values, "allocateModeName");
            return (Criteria) this;
        }

        public Criteria andAllocateModeNameBetween(String value1, String value2) {
            addCriterion("allocate_mode_name between", value1, value2, "allocateModeName");
            return (Criteria) this;
        }

        public Criteria andAllocateModeNameNotBetween(String value1, String value2) {
            addCriterion("allocate_mode_name not between", value1, value2, "allocateModeName");
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