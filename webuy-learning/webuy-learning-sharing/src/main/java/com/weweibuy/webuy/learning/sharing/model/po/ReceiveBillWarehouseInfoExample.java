package com.weweibuy.webuy.learning.sharing.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReceiveBillWarehouseInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReceiveBillWarehouseInfoExample() {
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

        public Criteria andReceiveWarehouseIdIsNull() {
            addCriterion("receive_warehouse_id is null");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseIdIsNotNull() {
            addCriterion("receive_warehouse_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseIdEqualTo(String value) {
            addCriterion("receive_warehouse_id =", value, "receiveWarehouseId");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseIdNotEqualTo(String value) {
            addCriterion("receive_warehouse_id <>", value, "receiveWarehouseId");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseIdGreaterThan(String value) {
            addCriterion("receive_warehouse_id >", value, "receiveWarehouseId");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseIdGreaterThanOrEqualTo(String value) {
            addCriterion("receive_warehouse_id >=", value, "receiveWarehouseId");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseIdLessThan(String value) {
            addCriterion("receive_warehouse_id <", value, "receiveWarehouseId");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseIdLessThanOrEqualTo(String value) {
            addCriterion("receive_warehouse_id <=", value, "receiveWarehouseId");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseIdLike(String value) {
            addCriterion("receive_warehouse_id like", value, "receiveWarehouseId");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseIdNotLike(String value) {
            addCriterion("receive_warehouse_id not like", value, "receiveWarehouseId");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseIdIn(List<String> values) {
            addCriterion("receive_warehouse_id in", values, "receiveWarehouseId");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseIdNotIn(List<String> values) {
            addCriterion("receive_warehouse_id not in", values, "receiveWarehouseId");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseIdBetween(String value1, String value2) {
            addCriterion("receive_warehouse_id between", value1, value2, "receiveWarehouseId");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseIdNotBetween(String value1, String value2) {
            addCriterion("receive_warehouse_id not between", value1, value2, "receiveWarehouseId");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseCodeIsNull() {
            addCriterion("receive_warehouse_code is null");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseCodeIsNotNull() {
            addCriterion("receive_warehouse_code is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseCodeEqualTo(String value) {
            addCriterion("receive_warehouse_code =", value, "receiveWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseCodeNotEqualTo(String value) {
            addCriterion("receive_warehouse_code <>", value, "receiveWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseCodeGreaterThan(String value) {
            addCriterion("receive_warehouse_code >", value, "receiveWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("receive_warehouse_code >=", value, "receiveWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseCodeLessThan(String value) {
            addCriterion("receive_warehouse_code <", value, "receiveWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseCodeLessThanOrEqualTo(String value) {
            addCriterion("receive_warehouse_code <=", value, "receiveWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseCodeLike(String value) {
            addCriterion("receive_warehouse_code like", value, "receiveWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseCodeNotLike(String value) {
            addCriterion("receive_warehouse_code not like", value, "receiveWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseCodeIn(List<String> values) {
            addCriterion("receive_warehouse_code in", values, "receiveWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseCodeNotIn(List<String> values) {
            addCriterion("receive_warehouse_code not in", values, "receiveWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseCodeBetween(String value1, String value2) {
            addCriterion("receive_warehouse_code between", value1, value2, "receiveWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseCodeNotBetween(String value1, String value2) {
            addCriterion("receive_warehouse_code not between", value1, value2, "receiveWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseNameIsNull() {
            addCriterion("receive_warehouse_name is null");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseNameIsNotNull() {
            addCriterion("receive_warehouse_name is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseNameEqualTo(String value) {
            addCriterion("receive_warehouse_name =", value, "receiveWarehouseName");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseNameNotEqualTo(String value) {
            addCriterion("receive_warehouse_name <>", value, "receiveWarehouseName");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseNameGreaterThan(String value) {
            addCriterion("receive_warehouse_name >", value, "receiveWarehouseName");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseNameGreaterThanOrEqualTo(String value) {
            addCriterion("receive_warehouse_name >=", value, "receiveWarehouseName");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseNameLessThan(String value) {
            addCriterion("receive_warehouse_name <", value, "receiveWarehouseName");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseNameLessThanOrEqualTo(String value) {
            addCriterion("receive_warehouse_name <=", value, "receiveWarehouseName");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseNameLike(String value) {
            addCriterion("receive_warehouse_name like", value, "receiveWarehouseName");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseNameNotLike(String value) {
            addCriterion("receive_warehouse_name not like", value, "receiveWarehouseName");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseNameIn(List<String> values) {
            addCriterion("receive_warehouse_name in", values, "receiveWarehouseName");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseNameNotIn(List<String> values) {
            addCriterion("receive_warehouse_name not in", values, "receiveWarehouseName");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseNameBetween(String value1, String value2) {
            addCriterion("receive_warehouse_name between", value1, value2, "receiveWarehouseName");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseNameNotBetween(String value1, String value2) {
            addCriterion("receive_warehouse_name not between", value1, value2, "receiveWarehouseName");
            return (Criteria) this;
        }

        public Criteria andBwReceiveWarehouseCodeIsNull() {
            addCriterion("bw_receive_warehouse_code is null");
            return (Criteria) this;
        }

        public Criteria andBwReceiveWarehouseCodeIsNotNull() {
            addCriterion("bw_receive_warehouse_code is not null");
            return (Criteria) this;
        }

        public Criteria andBwReceiveWarehouseCodeEqualTo(String value) {
            addCriterion("bw_receive_warehouse_code =", value, "bwReceiveWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwReceiveWarehouseCodeNotEqualTo(String value) {
            addCriterion("bw_receive_warehouse_code <>", value, "bwReceiveWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwReceiveWarehouseCodeGreaterThan(String value) {
            addCriterion("bw_receive_warehouse_code >", value, "bwReceiveWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwReceiveWarehouseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("bw_receive_warehouse_code >=", value, "bwReceiveWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwReceiveWarehouseCodeLessThan(String value) {
            addCriterion("bw_receive_warehouse_code <", value, "bwReceiveWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwReceiveWarehouseCodeLessThanOrEqualTo(String value) {
            addCriterion("bw_receive_warehouse_code <=", value, "bwReceiveWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwReceiveWarehouseCodeLike(String value) {
            addCriterion("bw_receive_warehouse_code like", value, "bwReceiveWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwReceiveWarehouseCodeNotLike(String value) {
            addCriterion("bw_receive_warehouse_code not like", value, "bwReceiveWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwReceiveWarehouseCodeIn(List<String> values) {
            addCriterion("bw_receive_warehouse_code in", values, "bwReceiveWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwReceiveWarehouseCodeNotIn(List<String> values) {
            addCriterion("bw_receive_warehouse_code not in", values, "bwReceiveWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwReceiveWarehouseCodeBetween(String value1, String value2) {
            addCriterion("bw_receive_warehouse_code between", value1, value2, "bwReceiveWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwReceiveWarehouseCodeNotBetween(String value1, String value2) {
            addCriterion("bw_receive_warehouse_code not between", value1, value2, "bwReceiveWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseTypeIsNull() {
            addCriterion("receive_warehouse_type is null");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseTypeIsNotNull() {
            addCriterion("receive_warehouse_type is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseTypeEqualTo(Integer value) {
            addCriterion("receive_warehouse_type =", value, "receiveWarehouseType");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseTypeNotEqualTo(Integer value) {
            addCriterion("receive_warehouse_type <>", value, "receiveWarehouseType");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseTypeGreaterThan(Integer value) {
            addCriterion("receive_warehouse_type >", value, "receiveWarehouseType");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("receive_warehouse_type >=", value, "receiveWarehouseType");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseTypeLessThan(Integer value) {
            addCriterion("receive_warehouse_type <", value, "receiveWarehouseType");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseTypeLessThanOrEqualTo(Integer value) {
            addCriterion("receive_warehouse_type <=", value, "receiveWarehouseType");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseTypeIn(List<Integer> values) {
            addCriterion("receive_warehouse_type in", values, "receiveWarehouseType");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseTypeNotIn(List<Integer> values) {
            addCriterion("receive_warehouse_type not in", values, "receiveWarehouseType");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseTypeBetween(Integer value1, Integer value2) {
            addCriterion("receive_warehouse_type between", value1, value2, "receiveWarehouseType");
            return (Criteria) this;
        }

        public Criteria andReceiveWarehouseTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("receive_warehouse_type not between", value1, value2, "receiveWarehouseType");
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

        public Criteria andMoveTypeIsNull() {
            addCriterion("move_type is null");
            return (Criteria) this;
        }

        public Criteria andMoveTypeIsNotNull() {
            addCriterion("move_type is not null");
            return (Criteria) this;
        }

        public Criteria andMoveTypeEqualTo(String value) {
            addCriterion("move_type =", value, "moveType");
            return (Criteria) this;
        }

        public Criteria andMoveTypeNotEqualTo(String value) {
            addCriterion("move_type <>", value, "moveType");
            return (Criteria) this;
        }

        public Criteria andMoveTypeGreaterThan(String value) {
            addCriterion("move_type >", value, "moveType");
            return (Criteria) this;
        }

        public Criteria andMoveTypeGreaterThanOrEqualTo(String value) {
            addCriterion("move_type >=", value, "moveType");
            return (Criteria) this;
        }

        public Criteria andMoveTypeLessThan(String value) {
            addCriterion("move_type <", value, "moveType");
            return (Criteria) this;
        }

        public Criteria andMoveTypeLessThanOrEqualTo(String value) {
            addCriterion("move_type <=", value, "moveType");
            return (Criteria) this;
        }

        public Criteria andMoveTypeLike(String value) {
            addCriterion("move_type like", value, "moveType");
            return (Criteria) this;
        }

        public Criteria andMoveTypeNotLike(String value) {
            addCriterion("move_type not like", value, "moveType");
            return (Criteria) this;
        }

        public Criteria andMoveTypeIn(List<String> values) {
            addCriterion("move_type in", values, "moveType");
            return (Criteria) this;
        }

        public Criteria andMoveTypeNotIn(List<String> values) {
            addCriterion("move_type not in", values, "moveType");
            return (Criteria) this;
        }

        public Criteria andMoveTypeBetween(String value1, String value2) {
            addCriterion("move_type between", value1, value2, "moveType");
            return (Criteria) this;
        }

        public Criteria andMoveTypeNotBetween(String value1, String value2) {
            addCriterion("move_type not between", value1, value2, "moveType");
            return (Criteria) this;
        }

        public Criteria andMoveModeLevelNoIsNull() {
            addCriterion("move_mode_level_no is null");
            return (Criteria) this;
        }

        public Criteria andMoveModeLevelNoIsNotNull() {
            addCriterion("move_mode_level_no is not null");
            return (Criteria) this;
        }

        public Criteria andMoveModeLevelNoEqualTo(String value) {
            addCriterion("move_mode_level_no =", value, "moveModeLevelNo");
            return (Criteria) this;
        }

        public Criteria andMoveModeLevelNoNotEqualTo(String value) {
            addCriterion("move_mode_level_no <>", value, "moveModeLevelNo");
            return (Criteria) this;
        }

        public Criteria andMoveModeLevelNoGreaterThan(String value) {
            addCriterion("move_mode_level_no >", value, "moveModeLevelNo");
            return (Criteria) this;
        }

        public Criteria andMoveModeLevelNoGreaterThanOrEqualTo(String value) {
            addCriterion("move_mode_level_no >=", value, "moveModeLevelNo");
            return (Criteria) this;
        }

        public Criteria andMoveModeLevelNoLessThan(String value) {
            addCriterion("move_mode_level_no <", value, "moveModeLevelNo");
            return (Criteria) this;
        }

        public Criteria andMoveModeLevelNoLessThanOrEqualTo(String value) {
            addCriterion("move_mode_level_no <=", value, "moveModeLevelNo");
            return (Criteria) this;
        }

        public Criteria andMoveModeLevelNoLike(String value) {
            addCriterion("move_mode_level_no like", value, "moveModeLevelNo");
            return (Criteria) this;
        }

        public Criteria andMoveModeLevelNoNotLike(String value) {
            addCriterion("move_mode_level_no not like", value, "moveModeLevelNo");
            return (Criteria) this;
        }

        public Criteria andMoveModeLevelNoIn(List<String> values) {
            addCriterion("move_mode_level_no in", values, "moveModeLevelNo");
            return (Criteria) this;
        }

        public Criteria andMoveModeLevelNoNotIn(List<String> values) {
            addCriterion("move_mode_level_no not in", values, "moveModeLevelNo");
            return (Criteria) this;
        }

        public Criteria andMoveModeLevelNoBetween(String value1, String value2) {
            addCriterion("move_mode_level_no between", value1, value2, "moveModeLevelNo");
            return (Criteria) this;
        }

        public Criteria andMoveModeLevelNoNotBetween(String value1, String value2) {
            addCriterion("move_mode_level_no not between", value1, value2, "moveModeLevelNo");
            return (Criteria) this;
        }

        public Criteria andMoveModeCodeIsNull() {
            addCriterion("move_mode_code is null");
            return (Criteria) this;
        }

        public Criteria andMoveModeCodeIsNotNull() {
            addCriterion("move_mode_code is not null");
            return (Criteria) this;
        }

        public Criteria andMoveModeCodeEqualTo(String value) {
            addCriterion("move_mode_code =", value, "moveModeCode");
            return (Criteria) this;
        }

        public Criteria andMoveModeCodeNotEqualTo(String value) {
            addCriterion("move_mode_code <>", value, "moveModeCode");
            return (Criteria) this;
        }

        public Criteria andMoveModeCodeGreaterThan(String value) {
            addCriterion("move_mode_code >", value, "moveModeCode");
            return (Criteria) this;
        }

        public Criteria andMoveModeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("move_mode_code >=", value, "moveModeCode");
            return (Criteria) this;
        }

        public Criteria andMoveModeCodeLessThan(String value) {
            addCriterion("move_mode_code <", value, "moveModeCode");
            return (Criteria) this;
        }

        public Criteria andMoveModeCodeLessThanOrEqualTo(String value) {
            addCriterion("move_mode_code <=", value, "moveModeCode");
            return (Criteria) this;
        }

        public Criteria andMoveModeCodeLike(String value) {
            addCriterion("move_mode_code like", value, "moveModeCode");
            return (Criteria) this;
        }

        public Criteria andMoveModeCodeNotLike(String value) {
            addCriterion("move_mode_code not like", value, "moveModeCode");
            return (Criteria) this;
        }

        public Criteria andMoveModeCodeIn(List<String> values) {
            addCriterion("move_mode_code in", values, "moveModeCode");
            return (Criteria) this;
        }

        public Criteria andMoveModeCodeNotIn(List<String> values) {
            addCriterion("move_mode_code not in", values, "moveModeCode");
            return (Criteria) this;
        }

        public Criteria andMoveModeCodeBetween(String value1, String value2) {
            addCriterion("move_mode_code between", value1, value2, "moveModeCode");
            return (Criteria) this;
        }

        public Criteria andMoveModeCodeNotBetween(String value1, String value2) {
            addCriterion("move_mode_code not between", value1, value2, "moveModeCode");
            return (Criteria) this;
        }

        public Criteria andMoveModeNameIsNull() {
            addCriterion("move_mode_name is null");
            return (Criteria) this;
        }

        public Criteria andMoveModeNameIsNotNull() {
            addCriterion("move_mode_name is not null");
            return (Criteria) this;
        }

        public Criteria andMoveModeNameEqualTo(String value) {
            addCriterion("move_mode_name =", value, "moveModeName");
            return (Criteria) this;
        }

        public Criteria andMoveModeNameNotEqualTo(String value) {
            addCriterion("move_mode_name <>", value, "moveModeName");
            return (Criteria) this;
        }

        public Criteria andMoveModeNameGreaterThan(String value) {
            addCriterion("move_mode_name >", value, "moveModeName");
            return (Criteria) this;
        }

        public Criteria andMoveModeNameGreaterThanOrEqualTo(String value) {
            addCriterion("move_mode_name >=", value, "moveModeName");
            return (Criteria) this;
        }

        public Criteria andMoveModeNameLessThan(String value) {
            addCriterion("move_mode_name <", value, "moveModeName");
            return (Criteria) this;
        }

        public Criteria andMoveModeNameLessThanOrEqualTo(String value) {
            addCriterion("move_mode_name <=", value, "moveModeName");
            return (Criteria) this;
        }

        public Criteria andMoveModeNameLike(String value) {
            addCriterion("move_mode_name like", value, "moveModeName");
            return (Criteria) this;
        }

        public Criteria andMoveModeNameNotLike(String value) {
            addCriterion("move_mode_name not like", value, "moveModeName");
            return (Criteria) this;
        }

        public Criteria andMoveModeNameIn(List<String> values) {
            addCriterion("move_mode_name in", values, "moveModeName");
            return (Criteria) this;
        }

        public Criteria andMoveModeNameNotIn(List<String> values) {
            addCriterion("move_mode_name not in", values, "moveModeName");
            return (Criteria) this;
        }

        public Criteria andMoveModeNameBetween(String value1, String value2) {
            addCriterion("move_mode_name between", value1, value2, "moveModeName");
            return (Criteria) this;
        }

        public Criteria andMoveModeNameNotBetween(String value1, String value2) {
            addCriterion("move_mode_name not between", value1, value2, "moveModeName");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseIdIsNull() {
            addCriterion("delivery_warehouse_id is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseIdIsNotNull() {
            addCriterion("delivery_warehouse_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseIdEqualTo(String value) {
            addCriterion("delivery_warehouse_id =", value, "deliveryWarehouseId");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseIdNotEqualTo(String value) {
            addCriterion("delivery_warehouse_id <>", value, "deliveryWarehouseId");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseIdGreaterThan(String value) {
            addCriterion("delivery_warehouse_id >", value, "deliveryWarehouseId");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseIdGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_warehouse_id >=", value, "deliveryWarehouseId");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseIdLessThan(String value) {
            addCriterion("delivery_warehouse_id <", value, "deliveryWarehouseId");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseIdLessThanOrEqualTo(String value) {
            addCriterion("delivery_warehouse_id <=", value, "deliveryWarehouseId");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseIdLike(String value) {
            addCriterion("delivery_warehouse_id like", value, "deliveryWarehouseId");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseIdNotLike(String value) {
            addCriterion("delivery_warehouse_id not like", value, "deliveryWarehouseId");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseIdIn(List<String> values) {
            addCriterion("delivery_warehouse_id in", values, "deliveryWarehouseId");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseIdNotIn(List<String> values) {
            addCriterion("delivery_warehouse_id not in", values, "deliveryWarehouseId");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseIdBetween(String value1, String value2) {
            addCriterion("delivery_warehouse_id between", value1, value2, "deliveryWarehouseId");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseIdNotBetween(String value1, String value2) {
            addCriterion("delivery_warehouse_id not between", value1, value2, "deliveryWarehouseId");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseCodeIsNull() {
            addCriterion("delivery_warehouse_code is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseCodeIsNotNull() {
            addCriterion("delivery_warehouse_code is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseCodeEqualTo(String value) {
            addCriterion("delivery_warehouse_code =", value, "deliveryWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseCodeNotEqualTo(String value) {
            addCriterion("delivery_warehouse_code <>", value, "deliveryWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseCodeGreaterThan(String value) {
            addCriterion("delivery_warehouse_code >", value, "deliveryWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_warehouse_code >=", value, "deliveryWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseCodeLessThan(String value) {
            addCriterion("delivery_warehouse_code <", value, "deliveryWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseCodeLessThanOrEqualTo(String value) {
            addCriterion("delivery_warehouse_code <=", value, "deliveryWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseCodeLike(String value) {
            addCriterion("delivery_warehouse_code like", value, "deliveryWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseCodeNotLike(String value) {
            addCriterion("delivery_warehouse_code not like", value, "deliveryWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseCodeIn(List<String> values) {
            addCriterion("delivery_warehouse_code in", values, "deliveryWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseCodeNotIn(List<String> values) {
            addCriterion("delivery_warehouse_code not in", values, "deliveryWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseCodeBetween(String value1, String value2) {
            addCriterion("delivery_warehouse_code between", value1, value2, "deliveryWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseCodeNotBetween(String value1, String value2) {
            addCriterion("delivery_warehouse_code not between", value1, value2, "deliveryWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseNameIsNull() {
            addCriterion("delivery_warehouse_name is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseNameIsNotNull() {
            addCriterion("delivery_warehouse_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseNameEqualTo(String value) {
            addCriterion("delivery_warehouse_name =", value, "deliveryWarehouseName");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseNameNotEqualTo(String value) {
            addCriterion("delivery_warehouse_name <>", value, "deliveryWarehouseName");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseNameGreaterThan(String value) {
            addCriterion("delivery_warehouse_name >", value, "deliveryWarehouseName");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseNameGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_warehouse_name >=", value, "deliveryWarehouseName");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseNameLessThan(String value) {
            addCriterion("delivery_warehouse_name <", value, "deliveryWarehouseName");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseNameLessThanOrEqualTo(String value) {
            addCriterion("delivery_warehouse_name <=", value, "deliveryWarehouseName");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseNameLike(String value) {
            addCriterion("delivery_warehouse_name like", value, "deliveryWarehouseName");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseNameNotLike(String value) {
            addCriterion("delivery_warehouse_name not like", value, "deliveryWarehouseName");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseNameIn(List<String> values) {
            addCriterion("delivery_warehouse_name in", values, "deliveryWarehouseName");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseNameNotIn(List<String> values) {
            addCriterion("delivery_warehouse_name not in", values, "deliveryWarehouseName");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseNameBetween(String value1, String value2) {
            addCriterion("delivery_warehouse_name between", value1, value2, "deliveryWarehouseName");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseNameNotBetween(String value1, String value2) {
            addCriterion("delivery_warehouse_name not between", value1, value2, "deliveryWarehouseName");
            return (Criteria) this;
        }

        public Criteria andBwDeliveryWarehouseCodeIsNull() {
            addCriterion("bw_delivery_warehouse_code is null");
            return (Criteria) this;
        }

        public Criteria andBwDeliveryWarehouseCodeIsNotNull() {
            addCriterion("bw_delivery_warehouse_code is not null");
            return (Criteria) this;
        }

        public Criteria andBwDeliveryWarehouseCodeEqualTo(String value) {
            addCriterion("bw_delivery_warehouse_code =", value, "bwDeliveryWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwDeliveryWarehouseCodeNotEqualTo(String value) {
            addCriterion("bw_delivery_warehouse_code <>", value, "bwDeliveryWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwDeliveryWarehouseCodeGreaterThan(String value) {
            addCriterion("bw_delivery_warehouse_code >", value, "bwDeliveryWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwDeliveryWarehouseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("bw_delivery_warehouse_code >=", value, "bwDeliveryWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwDeliveryWarehouseCodeLessThan(String value) {
            addCriterion("bw_delivery_warehouse_code <", value, "bwDeliveryWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwDeliveryWarehouseCodeLessThanOrEqualTo(String value) {
            addCriterion("bw_delivery_warehouse_code <=", value, "bwDeliveryWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwDeliveryWarehouseCodeLike(String value) {
            addCriterion("bw_delivery_warehouse_code like", value, "bwDeliveryWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwDeliveryWarehouseCodeNotLike(String value) {
            addCriterion("bw_delivery_warehouse_code not like", value, "bwDeliveryWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwDeliveryWarehouseCodeIn(List<String> values) {
            addCriterion("bw_delivery_warehouse_code in", values, "bwDeliveryWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwDeliveryWarehouseCodeNotIn(List<String> values) {
            addCriterion("bw_delivery_warehouse_code not in", values, "bwDeliveryWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwDeliveryWarehouseCodeBetween(String value1, String value2) {
            addCriterion("bw_delivery_warehouse_code between", value1, value2, "bwDeliveryWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andBwDeliveryWarehouseCodeNotBetween(String value1, String value2) {
            addCriterion("bw_delivery_warehouse_code not between", value1, value2, "bwDeliveryWarehouseCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseTypeIsNull() {
            addCriterion("delivery_warehouse_type is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseTypeIsNotNull() {
            addCriterion("delivery_warehouse_type is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseTypeEqualTo(Integer value) {
            addCriterion("delivery_warehouse_type =", value, "deliveryWarehouseType");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseTypeNotEqualTo(Integer value) {
            addCriterion("delivery_warehouse_type <>", value, "deliveryWarehouseType");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseTypeGreaterThan(Integer value) {
            addCriterion("delivery_warehouse_type >", value, "deliveryWarehouseType");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("delivery_warehouse_type >=", value, "deliveryWarehouseType");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseTypeLessThan(Integer value) {
            addCriterion("delivery_warehouse_type <", value, "deliveryWarehouseType");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseTypeLessThanOrEqualTo(Integer value) {
            addCriterion("delivery_warehouse_type <=", value, "deliveryWarehouseType");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseTypeIn(List<Integer> values) {
            addCriterion("delivery_warehouse_type in", values, "deliveryWarehouseType");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseTypeNotIn(List<Integer> values) {
            addCriterion("delivery_warehouse_type not in", values, "deliveryWarehouseType");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseTypeBetween(Integer value1, Integer value2) {
            addCriterion("delivery_warehouse_type between", value1, value2, "deliveryWarehouseType");
            return (Criteria) this;
        }

        public Criteria andDeliveryWarehouseTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("delivery_warehouse_type not between", value1, value2, "deliveryWarehouseType");
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