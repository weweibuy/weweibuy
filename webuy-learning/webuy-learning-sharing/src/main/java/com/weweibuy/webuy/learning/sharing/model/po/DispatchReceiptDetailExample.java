package com.weweibuy.webuy.learning.sharing.model.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DispatchReceiptDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DispatchReceiptDetailExample() {
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

        public Criteria andSequenceIsNull() {
            addCriterion("sequence is null");
            return (Criteria) this;
        }

        public Criteria andSequenceIsNotNull() {
            addCriterion("sequence is not null");
            return (Criteria) this;
        }

        public Criteria andSequenceEqualTo(String value) {
            addCriterion("sequence =", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotEqualTo(String value) {
            addCriterion("sequence <>", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceGreaterThan(String value) {
            addCriterion("sequence >", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceGreaterThanOrEqualTo(String value) {
            addCriterion("sequence >=", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLessThan(String value) {
            addCriterion("sequence <", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLessThanOrEqualTo(String value) {
            addCriterion("sequence <=", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLike(String value) {
            addCriterion("sequence like", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotLike(String value) {
            addCriterion("sequence not like", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceIn(List<String> values) {
            addCriterion("sequence in", values, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotIn(List<String> values) {
            addCriterion("sequence not in", values, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceBetween(String value1, String value2) {
            addCriterion("sequence between", value1, value2, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotBetween(String value1, String value2) {
            addCriterion("sequence not between", value1, value2, "sequence");
            return (Criteria) this;
        }

        public Criteria andBarCodeIsNull() {
            addCriterion("bar_code is null");
            return (Criteria) this;
        }

        public Criteria andBarCodeIsNotNull() {
            addCriterion("bar_code is not null");
            return (Criteria) this;
        }

        public Criteria andBarCodeEqualTo(String value) {
            addCriterion("bar_code =", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotEqualTo(String value) {
            addCriterion("bar_code <>", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeGreaterThan(String value) {
            addCriterion("bar_code >", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeGreaterThanOrEqualTo(String value) {
            addCriterion("bar_code >=", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeLessThan(String value) {
            addCriterion("bar_code <", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeLessThanOrEqualTo(String value) {
            addCriterion("bar_code <=", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeLike(String value) {
            addCriterion("bar_code like", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotLike(String value) {
            addCriterion("bar_code not like", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeIn(List<String> values) {
            addCriterion("bar_code in", values, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotIn(List<String> values) {
            addCriterion("bar_code not in", values, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeBetween(String value1, String value2) {
            addCriterion("bar_code between", value1, value2, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotBetween(String value1, String value2) {
            addCriterion("bar_code not between", value1, value2, "barCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeIsNull() {
            addCriterion("material_code is null");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeIsNotNull() {
            addCriterion("material_code is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeEqualTo(String value) {
            addCriterion("material_code =", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotEqualTo(String value) {
            addCriterion("material_code <>", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeGreaterThan(String value) {
            addCriterion("material_code >", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeGreaterThanOrEqualTo(String value) {
            addCriterion("material_code >=", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeLessThan(String value) {
            addCriterion("material_code <", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeLessThanOrEqualTo(String value) {
            addCriterion("material_code <=", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeLike(String value) {
            addCriterion("material_code like", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotLike(String value) {
            addCriterion("material_code not like", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeIn(List<String> values) {
            addCriterion("material_code in", values, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotIn(List<String> values) {
            addCriterion("material_code not in", values, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeBetween(String value1, String value2) {
            addCriterion("material_code between", value1, value2, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotBetween(String value1, String value2) {
            addCriterion("material_code not between", value1, value2, "materialCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryCompanyCodeIsNull() {
            addCriterion("delivery_company_code is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryCompanyCodeIsNotNull() {
            addCriterion("delivery_company_code is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryCompanyCodeEqualTo(String value) {
            addCriterion("delivery_company_code =", value, "deliveryCompanyCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryCompanyCodeNotEqualTo(String value) {
            addCriterion("delivery_company_code <>", value, "deliveryCompanyCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryCompanyCodeGreaterThan(String value) {
            addCriterion("delivery_company_code >", value, "deliveryCompanyCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryCompanyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_company_code >=", value, "deliveryCompanyCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryCompanyCodeLessThan(String value) {
            addCriterion("delivery_company_code <", value, "deliveryCompanyCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryCompanyCodeLessThanOrEqualTo(String value) {
            addCriterion("delivery_company_code <=", value, "deliveryCompanyCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryCompanyCodeLike(String value) {
            addCriterion("delivery_company_code like", value, "deliveryCompanyCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryCompanyCodeNotLike(String value) {
            addCriterion("delivery_company_code not like", value, "deliveryCompanyCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryCompanyCodeIn(List<String> values) {
            addCriterion("delivery_company_code in", values, "deliveryCompanyCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryCompanyCodeNotIn(List<String> values) {
            addCriterion("delivery_company_code not in", values, "deliveryCompanyCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryCompanyCodeBetween(String value1, String value2) {
            addCriterion("delivery_company_code between", value1, value2, "deliveryCompanyCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryCompanyCodeNotBetween(String value1, String value2) {
            addCriterion("delivery_company_code not between", value1, value2, "deliveryCompanyCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryExpressBillNoIsNull() {
            addCriterion("delivery_express_bill_no is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryExpressBillNoIsNotNull() {
            addCriterion("delivery_express_bill_no is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryExpressBillNoEqualTo(String value) {
            addCriterion("delivery_express_bill_no =", value, "deliveryExpressBillNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryExpressBillNoNotEqualTo(String value) {
            addCriterion("delivery_express_bill_no <>", value, "deliveryExpressBillNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryExpressBillNoGreaterThan(String value) {
            addCriterion("delivery_express_bill_no >", value, "deliveryExpressBillNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryExpressBillNoGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_express_bill_no >=", value, "deliveryExpressBillNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryExpressBillNoLessThan(String value) {
            addCriterion("delivery_express_bill_no <", value, "deliveryExpressBillNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryExpressBillNoLessThanOrEqualTo(String value) {
            addCriterion("delivery_express_bill_no <=", value, "deliveryExpressBillNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryExpressBillNoLike(String value) {
            addCriterion("delivery_express_bill_no like", value, "deliveryExpressBillNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryExpressBillNoNotLike(String value) {
            addCriterion("delivery_express_bill_no not like", value, "deliveryExpressBillNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryExpressBillNoIn(List<String> values) {
            addCriterion("delivery_express_bill_no in", values, "deliveryExpressBillNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryExpressBillNoNotIn(List<String> values) {
            addCriterion("delivery_express_bill_no not in", values, "deliveryExpressBillNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryExpressBillNoBetween(String value1, String value2) {
            addCriterion("delivery_express_bill_no between", value1, value2, "deliveryExpressBillNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryExpressBillNoNotBetween(String value1, String value2) {
            addCriterion("delivery_express_bill_no not between", value1, value2, "deliveryExpressBillNo");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(BigDecimal value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(BigDecimal value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(BigDecimal value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(BigDecimal value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<BigDecimal> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<BigDecimal> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andPackageNoIsNull() {
            addCriterion("package_no is null");
            return (Criteria) this;
        }

        public Criteria andPackageNoIsNotNull() {
            addCriterion("package_no is not null");
            return (Criteria) this;
        }

        public Criteria andPackageNoEqualTo(Integer value) {
            addCriterion("package_no =", value, "packageNo");
            return (Criteria) this;
        }

        public Criteria andPackageNoNotEqualTo(Integer value) {
            addCriterion("package_no <>", value, "packageNo");
            return (Criteria) this;
        }

        public Criteria andPackageNoGreaterThan(Integer value) {
            addCriterion("package_no >", value, "packageNo");
            return (Criteria) this;
        }

        public Criteria andPackageNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("package_no >=", value, "packageNo");
            return (Criteria) this;
        }

        public Criteria andPackageNoLessThan(Integer value) {
            addCriterion("package_no <", value, "packageNo");
            return (Criteria) this;
        }

        public Criteria andPackageNoLessThanOrEqualTo(Integer value) {
            addCriterion("package_no <=", value, "packageNo");
            return (Criteria) this;
        }

        public Criteria andPackageNoIn(List<Integer> values) {
            addCriterion("package_no in", values, "packageNo");
            return (Criteria) this;
        }

        public Criteria andPackageNoNotIn(List<Integer> values) {
            addCriterion("package_no not in", values, "packageNo");
            return (Criteria) this;
        }

        public Criteria andPackageNoBetween(Integer value1, Integer value2) {
            addCriterion("package_no between", value1, value2, "packageNo");
            return (Criteria) this;
        }

        public Criteria andPackageNoNotBetween(Integer value1, Integer value2) {
            addCriterion("package_no not between", value1, value2, "packageNo");
            return (Criteria) this;
        }

        public Criteria andBoxNoIsNull() {
            addCriterion("box_no is null");
            return (Criteria) this;
        }

        public Criteria andBoxNoIsNotNull() {
            addCriterion("box_no is not null");
            return (Criteria) this;
        }

        public Criteria andBoxNoEqualTo(Integer value) {
            addCriterion("box_no =", value, "boxNo");
            return (Criteria) this;
        }

        public Criteria andBoxNoNotEqualTo(Integer value) {
            addCriterion("box_no <>", value, "boxNo");
            return (Criteria) this;
        }

        public Criteria andBoxNoGreaterThan(Integer value) {
            addCriterion("box_no >", value, "boxNo");
            return (Criteria) this;
        }

        public Criteria andBoxNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("box_no >=", value, "boxNo");
            return (Criteria) this;
        }

        public Criteria andBoxNoLessThan(Integer value) {
            addCriterion("box_no <", value, "boxNo");
            return (Criteria) this;
        }

        public Criteria andBoxNoLessThanOrEqualTo(Integer value) {
            addCriterion("box_no <=", value, "boxNo");
            return (Criteria) this;
        }

        public Criteria andBoxNoIn(List<Integer> values) {
            addCriterion("box_no in", values, "boxNo");
            return (Criteria) this;
        }

        public Criteria andBoxNoNotIn(List<Integer> values) {
            addCriterion("box_no not in", values, "boxNo");
            return (Criteria) this;
        }

        public Criteria andBoxNoBetween(Integer value1, Integer value2) {
            addCriterion("box_no between", value1, value2, "boxNo");
            return (Criteria) this;
        }

        public Criteria andBoxNoNotBetween(Integer value1, Integer value2) {
            addCriterion("box_no not between", value1, value2, "boxNo");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Integer value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Integer value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Integer value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Integer value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Integer value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Integer> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Integer> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Integer value1, Integer value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andEstimateTotalAmountIsNull() {
            addCriterion("estimate_total_amount is null");
            return (Criteria) this;
        }

        public Criteria andEstimateTotalAmountIsNotNull() {
            addCriterion("estimate_total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andEstimateTotalAmountEqualTo(Integer value) {
            addCriterion("estimate_total_amount =", value, "estimateTotalAmount");
            return (Criteria) this;
        }

        public Criteria andEstimateTotalAmountNotEqualTo(Integer value) {
            addCriterion("estimate_total_amount <>", value, "estimateTotalAmount");
            return (Criteria) this;
        }

        public Criteria andEstimateTotalAmountGreaterThan(Integer value) {
            addCriterion("estimate_total_amount >", value, "estimateTotalAmount");
            return (Criteria) this;
        }

        public Criteria andEstimateTotalAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("estimate_total_amount >=", value, "estimateTotalAmount");
            return (Criteria) this;
        }

        public Criteria andEstimateTotalAmountLessThan(Integer value) {
            addCriterion("estimate_total_amount <", value, "estimateTotalAmount");
            return (Criteria) this;
        }

        public Criteria andEstimateTotalAmountLessThanOrEqualTo(Integer value) {
            addCriterion("estimate_total_amount <=", value, "estimateTotalAmount");
            return (Criteria) this;
        }

        public Criteria andEstimateTotalAmountIn(List<Integer> values) {
            addCriterion("estimate_total_amount in", values, "estimateTotalAmount");
            return (Criteria) this;
        }

        public Criteria andEstimateTotalAmountNotIn(List<Integer> values) {
            addCriterion("estimate_total_amount not in", values, "estimateTotalAmount");
            return (Criteria) this;
        }

        public Criteria andEstimateTotalAmountBetween(Integer value1, Integer value2) {
            addCriterion("estimate_total_amount between", value1, value2, "estimateTotalAmount");
            return (Criteria) this;
        }

        public Criteria andEstimateTotalAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("estimate_total_amount not between", value1, value2, "estimateTotalAmount");
            return (Criteria) this;
        }

        public Criteria andDifferenceAmountIsNull() {
            addCriterion("difference_amount is null");
            return (Criteria) this;
        }

        public Criteria andDifferenceAmountIsNotNull() {
            addCriterion("difference_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDifferenceAmountEqualTo(Integer value) {
            addCriterion("difference_amount =", value, "differenceAmount");
            return (Criteria) this;
        }

        public Criteria andDifferenceAmountNotEqualTo(Integer value) {
            addCriterion("difference_amount <>", value, "differenceAmount");
            return (Criteria) this;
        }

        public Criteria andDifferenceAmountGreaterThan(Integer value) {
            addCriterion("difference_amount >", value, "differenceAmount");
            return (Criteria) this;
        }

        public Criteria andDifferenceAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("difference_amount >=", value, "differenceAmount");
            return (Criteria) this;
        }

        public Criteria andDifferenceAmountLessThan(Integer value) {
            addCriterion("difference_amount <", value, "differenceAmount");
            return (Criteria) this;
        }

        public Criteria andDifferenceAmountLessThanOrEqualTo(Integer value) {
            addCriterion("difference_amount <=", value, "differenceAmount");
            return (Criteria) this;
        }

        public Criteria andDifferenceAmountIn(List<Integer> values) {
            addCriterion("difference_amount in", values, "differenceAmount");
            return (Criteria) this;
        }

        public Criteria andDifferenceAmountNotIn(List<Integer> values) {
            addCriterion("difference_amount not in", values, "differenceAmount");
            return (Criteria) this;
        }

        public Criteria andDifferenceAmountBetween(Integer value1, Integer value2) {
            addCriterion("difference_amount between", value1, value2, "differenceAmount");
            return (Criteria) this;
        }

        public Criteria andDifferenceAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("difference_amount not between", value1, value2, "differenceAmount");
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