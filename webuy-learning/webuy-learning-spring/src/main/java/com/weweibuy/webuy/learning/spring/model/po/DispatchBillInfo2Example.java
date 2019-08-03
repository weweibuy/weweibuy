package com.weweibuy.webuy.learning.spring.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DispatchBillInfo2Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DispatchBillInfo2Example() {
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

        public Criteria andBillTypeIsNull() {
            addCriterion("bill_type is null");
            return (Criteria) this;
        }

        public Criteria andBillTypeIsNotNull() {
            addCriterion("bill_type is not null");
            return (Criteria) this;
        }

        public Criteria andBillTypeEqualTo(String value) {
            addCriterion("bill_type =", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotEqualTo(String value) {
            addCriterion("bill_type <>", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeGreaterThan(String value) {
            addCriterion("bill_type >", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeGreaterThanOrEqualTo(String value) {
            addCriterion("bill_type >=", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeLessThan(String value) {
            addCriterion("bill_type <", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeLessThanOrEqualTo(String value) {
            addCriterion("bill_type <=", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeLike(String value) {
            addCriterion("bill_type like", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotLike(String value) {
            addCriterion("bill_type not like", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeIn(List<String> values) {
            addCriterion("bill_type in", values, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotIn(List<String> values) {
            addCriterion("bill_type not in", values, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeBetween(String value1, String value2) {
            addCriterion("bill_type between", value1, value2, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotBetween(String value1, String value2) {
            addCriterion("bill_type not between", value1, value2, "billType");
            return (Criteria) this;
        }

        public Criteria andBizTypeIsNull() {
            addCriterion("biz_type is null");
            return (Criteria) this;
        }

        public Criteria andBizTypeIsNotNull() {
            addCriterion("biz_type is not null");
            return (Criteria) this;
        }

        public Criteria andBizTypeEqualTo(String value) {
            addCriterion("biz_type =", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeNotEqualTo(String value) {
            addCriterion("biz_type <>", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeGreaterThan(String value) {
            addCriterion("biz_type >", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeGreaterThanOrEqualTo(String value) {
            addCriterion("biz_type >=", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeLessThan(String value) {
            addCriterion("biz_type <", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeLessThanOrEqualTo(String value) {
            addCriterion("biz_type <=", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeLike(String value) {
            addCriterion("biz_type like", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeNotLike(String value) {
            addCriterion("biz_type not like", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeIn(List<String> values) {
            addCriterion("biz_type in", values, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeNotIn(List<String> values) {
            addCriterion("biz_type not in", values, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeBetween(String value1, String value2) {
            addCriterion("biz_type between", value1, value2, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeNotBetween(String value1, String value2) {
            addCriterion("biz_type not between", value1, value2, "bizType");
            return (Criteria) this;
        }

        public Criteria andBillSourceIsNull() {
            addCriterion("bill_source is null");
            return (Criteria) this;
        }

        public Criteria andBillSourceIsNotNull() {
            addCriterion("bill_source is not null");
            return (Criteria) this;
        }

        public Criteria andBillSourceEqualTo(String value) {
            addCriterion("bill_source =", value, "billSource");
            return (Criteria) this;
        }

        public Criteria andBillSourceNotEqualTo(String value) {
            addCriterion("bill_source <>", value, "billSource");
            return (Criteria) this;
        }

        public Criteria andBillSourceGreaterThan(String value) {
            addCriterion("bill_source >", value, "billSource");
            return (Criteria) this;
        }

        public Criteria andBillSourceGreaterThanOrEqualTo(String value) {
            addCriterion("bill_source >=", value, "billSource");
            return (Criteria) this;
        }

        public Criteria andBillSourceLessThan(String value) {
            addCriterion("bill_source <", value, "billSource");
            return (Criteria) this;
        }

        public Criteria andBillSourceLessThanOrEqualTo(String value) {
            addCriterion("bill_source <=", value, "billSource");
            return (Criteria) this;
        }

        public Criteria andBillSourceLike(String value) {
            addCriterion("bill_source like", value, "billSource");
            return (Criteria) this;
        }

        public Criteria andBillSourceNotLike(String value) {
            addCriterion("bill_source not like", value, "billSource");
            return (Criteria) this;
        }

        public Criteria andBillSourceIn(List<String> values) {
            addCriterion("bill_source in", values, "billSource");
            return (Criteria) this;
        }

        public Criteria andBillSourceNotIn(List<String> values) {
            addCriterion("bill_source not in", values, "billSource");
            return (Criteria) this;
        }

        public Criteria andBillSourceBetween(String value1, String value2) {
            addCriterion("bill_source between", value1, value2, "billSource");
            return (Criteria) this;
        }

        public Criteria andBillSourceNotBetween(String value1, String value2) {
            addCriterion("bill_source not between", value1, value2, "billSource");
            return (Criteria) this;
        }

        public Criteria andBillStatusIsNull() {
            addCriterion("bill_status is null");
            return (Criteria) this;
        }

        public Criteria andBillStatusIsNotNull() {
            addCriterion("bill_status is not null");
            return (Criteria) this;
        }

        public Criteria andBillStatusEqualTo(String value) {
            addCriterion("bill_status =", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotEqualTo(String value) {
            addCriterion("bill_status <>", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusGreaterThan(String value) {
            addCriterion("bill_status >", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusGreaterThanOrEqualTo(String value) {
            addCriterion("bill_status >=", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusLessThan(String value) {
            addCriterion("bill_status <", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusLessThanOrEqualTo(String value) {
            addCriterion("bill_status <=", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusLike(String value) {
            addCriterion("bill_status like", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotLike(String value) {
            addCriterion("bill_status not like", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusIn(List<String> values) {
            addCriterion("bill_status in", values, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotIn(List<String> values) {
            addCriterion("bill_status not in", values, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusBetween(String value1, String value2) {
            addCriterion("bill_status between", value1, value2, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotBetween(String value1, String value2) {
            addCriterion("bill_status not between", value1, value2, "billStatus");
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

        public Criteria andChannelCodeIsNull() {
            addCriterion("channel_code is null");
            return (Criteria) this;
        }

        public Criteria andChannelCodeIsNotNull() {
            addCriterion("channel_code is not null");
            return (Criteria) this;
        }

        public Criteria andChannelCodeEqualTo(String value) {
            addCriterion("channel_code =", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotEqualTo(String value) {
            addCriterion("channel_code <>", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeGreaterThan(String value) {
            addCriterion("channel_code >", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeGreaterThanOrEqualTo(String value) {
            addCriterion("channel_code >=", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeLessThan(String value) {
            addCriterion("channel_code <", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeLessThanOrEqualTo(String value) {
            addCriterion("channel_code <=", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeLike(String value) {
            addCriterion("channel_code like", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotLike(String value) {
            addCriterion("channel_code not like", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeIn(List<String> values) {
            addCriterion("channel_code in", values, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotIn(List<String> values) {
            addCriterion("channel_code not in", values, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeBetween(String value1, String value2) {
            addCriterion("channel_code between", value1, value2, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotBetween(String value1, String value2) {
            addCriterion("channel_code not between", value1, value2, "channelCode");
            return (Criteria) this;
        }

        public Criteria andSourceBilllNoIsNull() {
            addCriterion("source_billl_no is null");
            return (Criteria) this;
        }

        public Criteria andSourceBilllNoIsNotNull() {
            addCriterion("source_billl_no is not null");
            return (Criteria) this;
        }

        public Criteria andSourceBilllNoEqualTo(String value) {
            addCriterion("source_billl_no =", value, "sourceBilllNo");
            return (Criteria) this;
        }

        public Criteria andSourceBilllNoNotEqualTo(String value) {
            addCriterion("source_billl_no <>", value, "sourceBilllNo");
            return (Criteria) this;
        }

        public Criteria andSourceBilllNoGreaterThan(String value) {
            addCriterion("source_billl_no >", value, "sourceBilllNo");
            return (Criteria) this;
        }

        public Criteria andSourceBilllNoGreaterThanOrEqualTo(String value) {
            addCriterion("source_billl_no >=", value, "sourceBilllNo");
            return (Criteria) this;
        }

        public Criteria andSourceBilllNoLessThan(String value) {
            addCriterion("source_billl_no <", value, "sourceBilllNo");
            return (Criteria) this;
        }

        public Criteria andSourceBilllNoLessThanOrEqualTo(String value) {
            addCriterion("source_billl_no <=", value, "sourceBilllNo");
            return (Criteria) this;
        }

        public Criteria andSourceBilllNoLike(String value) {
            addCriterion("source_billl_no like", value, "sourceBilllNo");
            return (Criteria) this;
        }

        public Criteria andSourceBilllNoNotLike(String value) {
            addCriterion("source_billl_no not like", value, "sourceBilllNo");
            return (Criteria) this;
        }

        public Criteria andSourceBilllNoIn(List<String> values) {
            addCriterion("source_billl_no in", values, "sourceBilllNo");
            return (Criteria) this;
        }

        public Criteria andSourceBilllNoNotIn(List<String> values) {
            addCriterion("source_billl_no not in", values, "sourceBilllNo");
            return (Criteria) this;
        }

        public Criteria andSourceBilllNoBetween(String value1, String value2) {
            addCriterion("source_billl_no between", value1, value2, "sourceBilllNo");
            return (Criteria) this;
        }

        public Criteria andSourceBilllNoNotBetween(String value1, String value2) {
            addCriterion("source_billl_no not between", value1, value2, "sourceBilllNo");
            return (Criteria) this;
        }

        public Criteria andManualBillNoIsNull() {
            addCriterion("manual_bill_no is null");
            return (Criteria) this;
        }

        public Criteria andManualBillNoIsNotNull() {
            addCriterion("manual_bill_no is not null");
            return (Criteria) this;
        }

        public Criteria andManualBillNoEqualTo(String value) {
            addCriterion("manual_bill_no =", value, "manualBillNo");
            return (Criteria) this;
        }

        public Criteria andManualBillNoNotEqualTo(String value) {
            addCriterion("manual_bill_no <>", value, "manualBillNo");
            return (Criteria) this;
        }

        public Criteria andManualBillNoGreaterThan(String value) {
            addCriterion("manual_bill_no >", value, "manualBillNo");
            return (Criteria) this;
        }

        public Criteria andManualBillNoGreaterThanOrEqualTo(String value) {
            addCriterion("manual_bill_no >=", value, "manualBillNo");
            return (Criteria) this;
        }

        public Criteria andManualBillNoLessThan(String value) {
            addCriterion("manual_bill_no <", value, "manualBillNo");
            return (Criteria) this;
        }

        public Criteria andManualBillNoLessThanOrEqualTo(String value) {
            addCriterion("manual_bill_no <=", value, "manualBillNo");
            return (Criteria) this;
        }

        public Criteria andManualBillNoLike(String value) {
            addCriterion("manual_bill_no like", value, "manualBillNo");
            return (Criteria) this;
        }

        public Criteria andManualBillNoNotLike(String value) {
            addCriterion("manual_bill_no not like", value, "manualBillNo");
            return (Criteria) this;
        }

        public Criteria andManualBillNoIn(List<String> values) {
            addCriterion("manual_bill_no in", values, "manualBillNo");
            return (Criteria) this;
        }

        public Criteria andManualBillNoNotIn(List<String> values) {
            addCriterion("manual_bill_no not in", values, "manualBillNo");
            return (Criteria) this;
        }

        public Criteria andManualBillNoBetween(String value1, String value2) {
            addCriterion("manual_bill_no between", value1, value2, "manualBillNo");
            return (Criteria) this;
        }

        public Criteria andManualBillNoNotBetween(String value1, String value2) {
            addCriterion("manual_bill_no not between", value1, value2, "manualBillNo");
            return (Criteria) this;
        }

        public Criteria andPrefinishBillNoIsNull() {
            addCriterion("prefinish_bill_no is null");
            return (Criteria) this;
        }

        public Criteria andPrefinishBillNoIsNotNull() {
            addCriterion("prefinish_bill_no is not null");
            return (Criteria) this;
        }

        public Criteria andPrefinishBillNoEqualTo(String value) {
            addCriterion("prefinish_bill_no =", value, "prefinishBillNo");
            return (Criteria) this;
        }

        public Criteria andPrefinishBillNoNotEqualTo(String value) {
            addCriterion("prefinish_bill_no <>", value, "prefinishBillNo");
            return (Criteria) this;
        }

        public Criteria andPrefinishBillNoGreaterThan(String value) {
            addCriterion("prefinish_bill_no >", value, "prefinishBillNo");
            return (Criteria) this;
        }

        public Criteria andPrefinishBillNoGreaterThanOrEqualTo(String value) {
            addCriterion("prefinish_bill_no >=", value, "prefinishBillNo");
            return (Criteria) this;
        }

        public Criteria andPrefinishBillNoLessThan(String value) {
            addCriterion("prefinish_bill_no <", value, "prefinishBillNo");
            return (Criteria) this;
        }

        public Criteria andPrefinishBillNoLessThanOrEqualTo(String value) {
            addCriterion("prefinish_bill_no <=", value, "prefinishBillNo");
            return (Criteria) this;
        }

        public Criteria andPrefinishBillNoLike(String value) {
            addCriterion("prefinish_bill_no like", value, "prefinishBillNo");
            return (Criteria) this;
        }

        public Criteria andPrefinishBillNoNotLike(String value) {
            addCriterion("prefinish_bill_no not like", value, "prefinishBillNo");
            return (Criteria) this;
        }

        public Criteria andPrefinishBillNoIn(List<String> values) {
            addCriterion("prefinish_bill_no in", values, "prefinishBillNo");
            return (Criteria) this;
        }

        public Criteria andPrefinishBillNoNotIn(List<String> values) {
            addCriterion("prefinish_bill_no not in", values, "prefinishBillNo");
            return (Criteria) this;
        }

        public Criteria andPrefinishBillNoBetween(String value1, String value2) {
            addCriterion("prefinish_bill_no between", value1, value2, "prefinishBillNo");
            return (Criteria) this;
        }

        public Criteria andPrefinishBillNoNotBetween(String value1, String value2) {
            addCriterion("prefinish_bill_no not between", value1, value2, "prefinishBillNo");
            return (Criteria) this;
        }

        public Criteria andVendcustIdIsNull() {
            addCriterion("vendcust_id is null");
            return (Criteria) this;
        }

        public Criteria andVendcustIdIsNotNull() {
            addCriterion("vendcust_id is not null");
            return (Criteria) this;
        }

        public Criteria andVendcustIdEqualTo(String value) {
            addCriterion("vendcust_id =", value, "vendcustId");
            return (Criteria) this;
        }

        public Criteria andVendcustIdNotEqualTo(String value) {
            addCriterion("vendcust_id <>", value, "vendcustId");
            return (Criteria) this;
        }

        public Criteria andVendcustIdGreaterThan(String value) {
            addCriterion("vendcust_id >", value, "vendcustId");
            return (Criteria) this;
        }

        public Criteria andVendcustIdGreaterThanOrEqualTo(String value) {
            addCriterion("vendcust_id >=", value, "vendcustId");
            return (Criteria) this;
        }

        public Criteria andVendcustIdLessThan(String value) {
            addCriterion("vendcust_id <", value, "vendcustId");
            return (Criteria) this;
        }

        public Criteria andVendcustIdLessThanOrEqualTo(String value) {
            addCriterion("vendcust_id <=", value, "vendcustId");
            return (Criteria) this;
        }

        public Criteria andVendcustIdLike(String value) {
            addCriterion("vendcust_id like", value, "vendcustId");
            return (Criteria) this;
        }

        public Criteria andVendcustIdNotLike(String value) {
            addCriterion("vendcust_id not like", value, "vendcustId");
            return (Criteria) this;
        }

        public Criteria andVendcustIdIn(List<String> values) {
            addCriterion("vendcust_id in", values, "vendcustId");
            return (Criteria) this;
        }

        public Criteria andVendcustIdNotIn(List<String> values) {
            addCriterion("vendcust_id not in", values, "vendcustId");
            return (Criteria) this;
        }

        public Criteria andVendcustIdBetween(String value1, String value2) {
            addCriterion("vendcust_id between", value1, value2, "vendcustId");
            return (Criteria) this;
        }

        public Criteria andVendcustIdNotBetween(String value1, String value2) {
            addCriterion("vendcust_id not between", value1, value2, "vendcustId");
            return (Criteria) this;
        }

        public Criteria andVendcustCodeIsNull() {
            addCriterion("vendcust_code is null");
            return (Criteria) this;
        }

        public Criteria andVendcustCodeIsNotNull() {
            addCriterion("vendcust_code is not null");
            return (Criteria) this;
        }

        public Criteria andVendcustCodeEqualTo(String value) {
            addCriterion("vendcust_code =", value, "vendcustCode");
            return (Criteria) this;
        }

        public Criteria andVendcustCodeNotEqualTo(String value) {
            addCriterion("vendcust_code <>", value, "vendcustCode");
            return (Criteria) this;
        }

        public Criteria andVendcustCodeGreaterThan(String value) {
            addCriterion("vendcust_code >", value, "vendcustCode");
            return (Criteria) this;
        }

        public Criteria andVendcustCodeGreaterThanOrEqualTo(String value) {
            addCriterion("vendcust_code >=", value, "vendcustCode");
            return (Criteria) this;
        }

        public Criteria andVendcustCodeLessThan(String value) {
            addCriterion("vendcust_code <", value, "vendcustCode");
            return (Criteria) this;
        }

        public Criteria andVendcustCodeLessThanOrEqualTo(String value) {
            addCriterion("vendcust_code <=", value, "vendcustCode");
            return (Criteria) this;
        }

        public Criteria andVendcustCodeLike(String value) {
            addCriterion("vendcust_code like", value, "vendcustCode");
            return (Criteria) this;
        }

        public Criteria andVendcustCodeNotLike(String value) {
            addCriterion("vendcust_code not like", value, "vendcustCode");
            return (Criteria) this;
        }

        public Criteria andVendcustCodeIn(List<String> values) {
            addCriterion("vendcust_code in", values, "vendcustCode");
            return (Criteria) this;
        }

        public Criteria andVendcustCodeNotIn(List<String> values) {
            addCriterion("vendcust_code not in", values, "vendcustCode");
            return (Criteria) this;
        }

        public Criteria andVendcustCodeBetween(String value1, String value2) {
            addCriterion("vendcust_code between", value1, value2, "vendcustCode");
            return (Criteria) this;
        }

        public Criteria andVendcustCodeNotBetween(String value1, String value2) {
            addCriterion("vendcust_code not between", value1, value2, "vendcustCode");
            return (Criteria) this;
        }

        public Criteria andVendcustNameIsNull() {
            addCriterion("vendcust_name is null");
            return (Criteria) this;
        }

        public Criteria andVendcustNameIsNotNull() {
            addCriterion("vendcust_name is not null");
            return (Criteria) this;
        }

        public Criteria andVendcustNameEqualTo(String value) {
            addCriterion("vendcust_name =", value, "vendcustName");
            return (Criteria) this;
        }

        public Criteria andVendcustNameNotEqualTo(String value) {
            addCriterion("vendcust_name <>", value, "vendcustName");
            return (Criteria) this;
        }

        public Criteria andVendcustNameGreaterThan(String value) {
            addCriterion("vendcust_name >", value, "vendcustName");
            return (Criteria) this;
        }

        public Criteria andVendcustNameGreaterThanOrEqualTo(String value) {
            addCriterion("vendcust_name >=", value, "vendcustName");
            return (Criteria) this;
        }

        public Criteria andVendcustNameLessThan(String value) {
            addCriterion("vendcust_name <", value, "vendcustName");
            return (Criteria) this;
        }

        public Criteria andVendcustNameLessThanOrEqualTo(String value) {
            addCriterion("vendcust_name <=", value, "vendcustName");
            return (Criteria) this;
        }

        public Criteria andVendcustNameLike(String value) {
            addCriterion("vendcust_name like", value, "vendcustName");
            return (Criteria) this;
        }

        public Criteria andVendcustNameNotLike(String value) {
            addCriterion("vendcust_name not like", value, "vendcustName");
            return (Criteria) this;
        }

        public Criteria andVendcustNameIn(List<String> values) {
            addCriterion("vendcust_name in", values, "vendcustName");
            return (Criteria) this;
        }

        public Criteria andVendcustNameNotIn(List<String> values) {
            addCriterion("vendcust_name not in", values, "vendcustName");
            return (Criteria) this;
        }

        public Criteria andVendcustNameBetween(String value1, String value2) {
            addCriterion("vendcust_name between", value1, value2, "vendcustName");
            return (Criteria) this;
        }

        public Criteria andVendcustNameNotBetween(String value1, String value2) {
            addCriterion("vendcust_name not between", value1, value2, "vendcustName");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNull() {
            addCriterion("batch_no is null");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNotNull() {
            addCriterion("batch_no is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNoEqualTo(String value) {
            addCriterion("batch_no =", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotEqualTo(String value) {
            addCriterion("batch_no <>", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThan(String value) {
            addCriterion("batch_no >", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("batch_no >=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThan(String value) {
            addCriterion("batch_no <", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThanOrEqualTo(String value) {
            addCriterion("batch_no <=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLike(String value) {
            addCriterion("batch_no like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotLike(String value) {
            addCriterion("batch_no not like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoIn(List<String> values) {
            addCriterion("batch_no in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotIn(List<String> values) {
            addCriterion("batch_no not in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoBetween(String value1, String value2) {
            addCriterion("batch_no between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotBetween(String value1, String value2) {
            addCriterion("batch_no not between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchMarkIsNull() {
            addCriterion("batch_mark is null");
            return (Criteria) this;
        }

        public Criteria andBatchMarkIsNotNull() {
            addCriterion("batch_mark is not null");
            return (Criteria) this;
        }

        public Criteria andBatchMarkEqualTo(String value) {
            addCriterion("batch_mark =", value, "batchMark");
            return (Criteria) this;
        }

        public Criteria andBatchMarkNotEqualTo(String value) {
            addCriterion("batch_mark <>", value, "batchMark");
            return (Criteria) this;
        }

        public Criteria andBatchMarkGreaterThan(String value) {
            addCriterion("batch_mark >", value, "batchMark");
            return (Criteria) this;
        }

        public Criteria andBatchMarkGreaterThanOrEqualTo(String value) {
            addCriterion("batch_mark >=", value, "batchMark");
            return (Criteria) this;
        }

        public Criteria andBatchMarkLessThan(String value) {
            addCriterion("batch_mark <", value, "batchMark");
            return (Criteria) this;
        }

        public Criteria andBatchMarkLessThanOrEqualTo(String value) {
            addCriterion("batch_mark <=", value, "batchMark");
            return (Criteria) this;
        }

        public Criteria andBatchMarkLike(String value) {
            addCriterion("batch_mark like", value, "batchMark");
            return (Criteria) this;
        }

        public Criteria andBatchMarkNotLike(String value) {
            addCriterion("batch_mark not like", value, "batchMark");
            return (Criteria) this;
        }

        public Criteria andBatchMarkIn(List<String> values) {
            addCriterion("batch_mark in", values, "batchMark");
            return (Criteria) this;
        }

        public Criteria andBatchMarkNotIn(List<String> values) {
            addCriterion("batch_mark not in", values, "batchMark");
            return (Criteria) this;
        }

        public Criteria andBatchMarkBetween(String value1, String value2) {
            addCriterion("batch_mark between", value1, value2, "batchMark");
            return (Criteria) this;
        }

        public Criteria andBatchMarkNotBetween(String value1, String value2) {
            addCriterion("batch_mark not between", value1, value2, "batchMark");
            return (Criteria) this;
        }

        public Criteria andDispatchReasonIsNull() {
            addCriterion("dispatch_reason is null");
            return (Criteria) this;
        }

        public Criteria andDispatchReasonIsNotNull() {
            addCriterion("dispatch_reason is not null");
            return (Criteria) this;
        }

        public Criteria andDispatchReasonEqualTo(Integer value) {
            addCriterion("dispatch_reason =", value, "dispatchReason");
            return (Criteria) this;
        }

        public Criteria andDispatchReasonNotEqualTo(Integer value) {
            addCriterion("dispatch_reason <>", value, "dispatchReason");
            return (Criteria) this;
        }

        public Criteria andDispatchReasonGreaterThan(Integer value) {
            addCriterion("dispatch_reason >", value, "dispatchReason");
            return (Criteria) this;
        }

        public Criteria andDispatchReasonGreaterThanOrEqualTo(Integer value) {
            addCriterion("dispatch_reason >=", value, "dispatchReason");
            return (Criteria) this;
        }

        public Criteria andDispatchReasonLessThan(Integer value) {
            addCriterion("dispatch_reason <", value, "dispatchReason");
            return (Criteria) this;
        }

        public Criteria andDispatchReasonLessThanOrEqualTo(Integer value) {
            addCriterion("dispatch_reason <=", value, "dispatchReason");
            return (Criteria) this;
        }

        public Criteria andDispatchReasonIn(List<Integer> values) {
            addCriterion("dispatch_reason in", values, "dispatchReason");
            return (Criteria) this;
        }

        public Criteria andDispatchReasonNotIn(List<Integer> values) {
            addCriterion("dispatch_reason not in", values, "dispatchReason");
            return (Criteria) this;
        }

        public Criteria andDispatchReasonBetween(Integer value1, Integer value2) {
            addCriterion("dispatch_reason between", value1, value2, "dispatchReason");
            return (Criteria) this;
        }

        public Criteria andDispatchReasonNotBetween(Integer value1, Integer value2) {
            addCriterion("dispatch_reason not between", value1, value2, "dispatchReason");
            return (Criteria) this;
        }

        public Criteria andExpectArrivalTimeIsNull() {
            addCriterion("expect_arrival_time is null");
            return (Criteria) this;
        }

        public Criteria andExpectArrivalTimeIsNotNull() {
            addCriterion("expect_arrival_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpectArrivalTimeEqualTo(Date value) {
            addCriterion("expect_arrival_time =", value, "expectArrivalTime");
            return (Criteria) this;
        }

        public Criteria andExpectArrivalTimeNotEqualTo(Date value) {
            addCriterion("expect_arrival_time <>", value, "expectArrivalTime");
            return (Criteria) this;
        }

        public Criteria andExpectArrivalTimeGreaterThan(Date value) {
            addCriterion("expect_arrival_time >", value, "expectArrivalTime");
            return (Criteria) this;
        }

        public Criteria andExpectArrivalTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("expect_arrival_time >=", value, "expectArrivalTime");
            return (Criteria) this;
        }

        public Criteria andExpectArrivalTimeLessThan(Date value) {
            addCriterion("expect_arrival_time <", value, "expectArrivalTime");
            return (Criteria) this;
        }

        public Criteria andExpectArrivalTimeLessThanOrEqualTo(Date value) {
            addCriterion("expect_arrival_time <=", value, "expectArrivalTime");
            return (Criteria) this;
        }

        public Criteria andExpectArrivalTimeIn(List<Date> values) {
            addCriterion("expect_arrival_time in", values, "expectArrivalTime");
            return (Criteria) this;
        }

        public Criteria andExpectArrivalTimeNotIn(List<Date> values) {
            addCriterion("expect_arrival_time not in", values, "expectArrivalTime");
            return (Criteria) this;
        }

        public Criteria andExpectArrivalTimeBetween(Date value1, Date value2) {
            addCriterion("expect_arrival_time between", value1, value2, "expectArrivalTime");
            return (Criteria) this;
        }

        public Criteria andExpectArrivalTimeNotBetween(Date value1, Date value2) {
            addCriterion("expect_arrival_time not between", value1, value2, "expectArrivalTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeIsNull() {
            addCriterion("departure_time is null");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeIsNotNull() {
            addCriterion("departure_time is not null");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeEqualTo(Date value) {
            addCriterion("departure_time =", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeNotEqualTo(Date value) {
            addCriterion("departure_time <>", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeGreaterThan(Date value) {
            addCriterion("departure_time >", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("departure_time >=", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeLessThan(Date value) {
            addCriterion("departure_time <", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeLessThanOrEqualTo(Date value) {
            addCriterion("departure_time <=", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeIn(List<Date> values) {
            addCriterion("departure_time in", values, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeNotIn(List<Date> values) {
            addCriterion("departure_time not in", values, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeBetween(Date value1, Date value2) {
            addCriterion("departure_time between", value1, value2, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeNotBetween(Date value1, Date value2) {
            addCriterion("departure_time not between", value1, value2, "departureTime");
            return (Criteria) this;
        }

        public Criteria andShopBillNoIsNull() {
            addCriterion("shop_bill_no is null");
            return (Criteria) this;
        }

        public Criteria andShopBillNoIsNotNull() {
            addCriterion("shop_bill_no is not null");
            return (Criteria) this;
        }

        public Criteria andShopBillNoEqualTo(String value) {
            addCriterion("shop_bill_no =", value, "shopBillNo");
            return (Criteria) this;
        }

        public Criteria andShopBillNoNotEqualTo(String value) {
            addCriterion("shop_bill_no <>", value, "shopBillNo");
            return (Criteria) this;
        }

        public Criteria andShopBillNoGreaterThan(String value) {
            addCriterion("shop_bill_no >", value, "shopBillNo");
            return (Criteria) this;
        }

        public Criteria andShopBillNoGreaterThanOrEqualTo(String value) {
            addCriterion("shop_bill_no >=", value, "shopBillNo");
            return (Criteria) this;
        }

        public Criteria andShopBillNoLessThan(String value) {
            addCriterion("shop_bill_no <", value, "shopBillNo");
            return (Criteria) this;
        }

        public Criteria andShopBillNoLessThanOrEqualTo(String value) {
            addCriterion("shop_bill_no <=", value, "shopBillNo");
            return (Criteria) this;
        }

        public Criteria andShopBillNoLike(String value) {
            addCriterion("shop_bill_no like", value, "shopBillNo");
            return (Criteria) this;
        }

        public Criteria andShopBillNoNotLike(String value) {
            addCriterion("shop_bill_no not like", value, "shopBillNo");
            return (Criteria) this;
        }

        public Criteria andShopBillNoIn(List<String> values) {
            addCriterion("shop_bill_no in", values, "shopBillNo");
            return (Criteria) this;
        }

        public Criteria andShopBillNoNotIn(List<String> values) {
            addCriterion("shop_bill_no not in", values, "shopBillNo");
            return (Criteria) this;
        }

        public Criteria andShopBillNoBetween(String value1, String value2) {
            addCriterion("shop_bill_no between", value1, value2, "shopBillNo");
            return (Criteria) this;
        }

        public Criteria andShopBillNoNotBetween(String value1, String value2) {
            addCriterion("shop_bill_no not between", value1, value2, "shopBillNo");
            return (Criteria) this;
        }

        public Criteria andBuyerUserNameIsNull() {
            addCriterion("buyer_user_name is null");
            return (Criteria) this;
        }

        public Criteria andBuyerUserNameIsNotNull() {
            addCriterion("buyer_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerUserNameEqualTo(String value) {
            addCriterion("buyer_user_name =", value, "buyerUserName");
            return (Criteria) this;
        }

        public Criteria andBuyerUserNameNotEqualTo(String value) {
            addCriterion("buyer_user_name <>", value, "buyerUserName");
            return (Criteria) this;
        }

        public Criteria andBuyerUserNameGreaterThan(String value) {
            addCriterion("buyer_user_name >", value, "buyerUserName");
            return (Criteria) this;
        }

        public Criteria andBuyerUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("buyer_user_name >=", value, "buyerUserName");
            return (Criteria) this;
        }

        public Criteria andBuyerUserNameLessThan(String value) {
            addCriterion("buyer_user_name <", value, "buyerUserName");
            return (Criteria) this;
        }

        public Criteria andBuyerUserNameLessThanOrEqualTo(String value) {
            addCriterion("buyer_user_name <=", value, "buyerUserName");
            return (Criteria) this;
        }

        public Criteria andBuyerUserNameLike(String value) {
            addCriterion("buyer_user_name like", value, "buyerUserName");
            return (Criteria) this;
        }

        public Criteria andBuyerUserNameNotLike(String value) {
            addCriterion("buyer_user_name not like", value, "buyerUserName");
            return (Criteria) this;
        }

        public Criteria andBuyerUserNameIn(List<String> values) {
            addCriterion("buyer_user_name in", values, "buyerUserName");
            return (Criteria) this;
        }

        public Criteria andBuyerUserNameNotIn(List<String> values) {
            addCriterion("buyer_user_name not in", values, "buyerUserName");
            return (Criteria) this;
        }

        public Criteria andBuyerUserNameBetween(String value1, String value2) {
            addCriterion("buyer_user_name between", value1, value2, "buyerUserName");
            return (Criteria) this;
        }

        public Criteria andBuyerUserNameNotBetween(String value1, String value2) {
            addCriterion("buyer_user_name not between", value1, value2, "buyerUserName");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("contact is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("contact is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("contact =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("contact <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("contact >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("contact >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("contact <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("contact <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("contact like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("contact not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("contact in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("contact not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("contact between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("contact not between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andExpectAmountIsNull() {
            addCriterion("expect_amount is null");
            return (Criteria) this;
        }

        public Criteria andExpectAmountIsNotNull() {
            addCriterion("expect_amount is not null");
            return (Criteria) this;
        }

        public Criteria andExpectAmountEqualTo(Integer value) {
            addCriterion("expect_amount =", value, "expectAmount");
            return (Criteria) this;
        }

        public Criteria andExpectAmountNotEqualTo(Integer value) {
            addCriterion("expect_amount <>", value, "expectAmount");
            return (Criteria) this;
        }

        public Criteria andExpectAmountGreaterThan(Integer value) {
            addCriterion("expect_amount >", value, "expectAmount");
            return (Criteria) this;
        }

        public Criteria andExpectAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("expect_amount >=", value, "expectAmount");
            return (Criteria) this;
        }

        public Criteria andExpectAmountLessThan(Integer value) {
            addCriterion("expect_amount <", value, "expectAmount");
            return (Criteria) this;
        }

        public Criteria andExpectAmountLessThanOrEqualTo(Integer value) {
            addCriterion("expect_amount <=", value, "expectAmount");
            return (Criteria) this;
        }

        public Criteria andExpectAmountIn(List<Integer> values) {
            addCriterion("expect_amount in", values, "expectAmount");
            return (Criteria) this;
        }

        public Criteria andExpectAmountNotIn(List<Integer> values) {
            addCriterion("expect_amount not in", values, "expectAmount");
            return (Criteria) this;
        }

        public Criteria andExpectAmountBetween(Integer value1, Integer value2) {
            addCriterion("expect_amount between", value1, value2, "expectAmount");
            return (Criteria) this;
        }

        public Criteria andExpectAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("expect_amount not between", value1, value2, "expectAmount");
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

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andPrintInvoiceFlagIsNull() {
            addCriterion("print_invoice_flag is null");
            return (Criteria) this;
        }

        public Criteria andPrintInvoiceFlagIsNotNull() {
            addCriterion("print_invoice_flag is not null");
            return (Criteria) this;
        }

        public Criteria andPrintInvoiceFlagEqualTo(Boolean value) {
            addCriterion("print_invoice_flag =", value, "printInvoiceFlag");
            return (Criteria) this;
        }

        public Criteria andPrintInvoiceFlagNotEqualTo(Boolean value) {
            addCriterion("print_invoice_flag <>", value, "printInvoiceFlag");
            return (Criteria) this;
        }

        public Criteria andPrintInvoiceFlagGreaterThan(Boolean value) {
            addCriterion("print_invoice_flag >", value, "printInvoiceFlag");
            return (Criteria) this;
        }

        public Criteria andPrintInvoiceFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("print_invoice_flag >=", value, "printInvoiceFlag");
            return (Criteria) this;
        }

        public Criteria andPrintInvoiceFlagLessThan(Boolean value) {
            addCriterion("print_invoice_flag <", value, "printInvoiceFlag");
            return (Criteria) this;
        }

        public Criteria andPrintInvoiceFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("print_invoice_flag <=", value, "printInvoiceFlag");
            return (Criteria) this;
        }

        public Criteria andPrintInvoiceFlagIn(List<Boolean> values) {
            addCriterion("print_invoice_flag in", values, "printInvoiceFlag");
            return (Criteria) this;
        }

        public Criteria andPrintInvoiceFlagNotIn(List<Boolean> values) {
            addCriterion("print_invoice_flag not in", values, "printInvoiceFlag");
            return (Criteria) this;
        }

        public Criteria andPrintInvoiceFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("print_invoice_flag between", value1, value2, "printInvoiceFlag");
            return (Criteria) this;
        }

        public Criteria andPrintInvoiceFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("print_invoice_flag not between", value1, value2, "printInvoiceFlag");
            return (Criteria) this;
        }

        public Criteria andWithInvoiceFlagIsNull() {
            addCriterion("with_invoice_flag is null");
            return (Criteria) this;
        }

        public Criteria andWithInvoiceFlagIsNotNull() {
            addCriterion("with_invoice_flag is not null");
            return (Criteria) this;
        }

        public Criteria andWithInvoiceFlagEqualTo(Boolean value) {
            addCriterion("with_invoice_flag =", value, "withInvoiceFlag");
            return (Criteria) this;
        }

        public Criteria andWithInvoiceFlagNotEqualTo(Boolean value) {
            addCriterion("with_invoice_flag <>", value, "withInvoiceFlag");
            return (Criteria) this;
        }

        public Criteria andWithInvoiceFlagGreaterThan(Boolean value) {
            addCriterion("with_invoice_flag >", value, "withInvoiceFlag");
            return (Criteria) this;
        }

        public Criteria andWithInvoiceFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("with_invoice_flag >=", value, "withInvoiceFlag");
            return (Criteria) this;
        }

        public Criteria andWithInvoiceFlagLessThan(Boolean value) {
            addCriterion("with_invoice_flag <", value, "withInvoiceFlag");
            return (Criteria) this;
        }

        public Criteria andWithInvoiceFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("with_invoice_flag <=", value, "withInvoiceFlag");
            return (Criteria) this;
        }

        public Criteria andWithInvoiceFlagIn(List<Boolean> values) {
            addCriterion("with_invoice_flag in", values, "withInvoiceFlag");
            return (Criteria) this;
        }

        public Criteria andWithInvoiceFlagNotIn(List<Boolean> values) {
            addCriterion("with_invoice_flag not in", values, "withInvoiceFlag");
            return (Criteria) this;
        }

        public Criteria andWithInvoiceFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("with_invoice_flag between", value1, value2, "withInvoiceFlag");
            return (Criteria) this;
        }

        public Criteria andWithInvoiceFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("with_invoice_flag not between", value1, value2, "withInvoiceFlag");
            return (Criteria) this;
        }

        public Criteria andAllowReceiptFlagIsNull() {
            addCriterion("allow_receipt_flag is null");
            return (Criteria) this;
        }

        public Criteria andAllowReceiptFlagIsNotNull() {
            addCriterion("allow_receipt_flag is not null");
            return (Criteria) this;
        }

        public Criteria andAllowReceiptFlagEqualTo(Boolean value) {
            addCriterion("allow_receipt_flag =", value, "allowReceiptFlag");
            return (Criteria) this;
        }

        public Criteria andAllowReceiptFlagNotEqualTo(Boolean value) {
            addCriterion("allow_receipt_flag <>", value, "allowReceiptFlag");
            return (Criteria) this;
        }

        public Criteria andAllowReceiptFlagGreaterThan(Boolean value) {
            addCriterion("allow_receipt_flag >", value, "allowReceiptFlag");
            return (Criteria) this;
        }

        public Criteria andAllowReceiptFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("allow_receipt_flag >=", value, "allowReceiptFlag");
            return (Criteria) this;
        }

        public Criteria andAllowReceiptFlagLessThan(Boolean value) {
            addCriterion("allow_receipt_flag <", value, "allowReceiptFlag");
            return (Criteria) this;
        }

        public Criteria andAllowReceiptFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("allow_receipt_flag <=", value, "allowReceiptFlag");
            return (Criteria) this;
        }

        public Criteria andAllowReceiptFlagIn(List<Boolean> values) {
            addCriterion("allow_receipt_flag in", values, "allowReceiptFlag");
            return (Criteria) this;
        }

        public Criteria andAllowReceiptFlagNotIn(List<Boolean> values) {
            addCriterion("allow_receipt_flag not in", values, "allowReceiptFlag");
            return (Criteria) this;
        }

        public Criteria andAllowReceiptFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("allow_receipt_flag between", value1, value2, "allowReceiptFlag");
            return (Criteria) this;
        }

        public Criteria andAllowReceiptFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("allow_receipt_flag not between", value1, value2, "allowReceiptFlag");
            return (Criteria) this;
        }

        public Criteria andAllowPartialDeliveryFlagIsNull() {
            addCriterion("allow_partial_delivery_flag is null");
            return (Criteria) this;
        }

        public Criteria andAllowPartialDeliveryFlagIsNotNull() {
            addCriterion("allow_partial_delivery_flag is not null");
            return (Criteria) this;
        }

        public Criteria andAllowPartialDeliveryFlagEqualTo(Boolean value) {
            addCriterion("allow_partial_delivery_flag =", value, "allowPartialDeliveryFlag");
            return (Criteria) this;
        }

        public Criteria andAllowPartialDeliveryFlagNotEqualTo(Boolean value) {
            addCriterion("allow_partial_delivery_flag <>", value, "allowPartialDeliveryFlag");
            return (Criteria) this;
        }

        public Criteria andAllowPartialDeliveryFlagGreaterThan(Boolean value) {
            addCriterion("allow_partial_delivery_flag >", value, "allowPartialDeliveryFlag");
            return (Criteria) this;
        }

        public Criteria andAllowPartialDeliveryFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("allow_partial_delivery_flag >=", value, "allowPartialDeliveryFlag");
            return (Criteria) this;
        }

        public Criteria andAllowPartialDeliveryFlagLessThan(Boolean value) {
            addCriterion("allow_partial_delivery_flag <", value, "allowPartialDeliveryFlag");
            return (Criteria) this;
        }

        public Criteria andAllowPartialDeliveryFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("allow_partial_delivery_flag <=", value, "allowPartialDeliveryFlag");
            return (Criteria) this;
        }

        public Criteria andAllowPartialDeliveryFlagIn(List<Boolean> values) {
            addCriterion("allow_partial_delivery_flag in", values, "allowPartialDeliveryFlag");
            return (Criteria) this;
        }

        public Criteria andAllowPartialDeliveryFlagNotIn(List<Boolean> values) {
            addCriterion("allow_partial_delivery_flag not in", values, "allowPartialDeliveryFlag");
            return (Criteria) this;
        }

        public Criteria andAllowPartialDeliveryFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("allow_partial_delivery_flag between", value1, value2, "allowPartialDeliveryFlag");
            return (Criteria) this;
        }

        public Criteria andAllowPartialDeliveryFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("allow_partial_delivery_flag not between", value1, value2, "allowPartialDeliveryFlag");
            return (Criteria) this;
        }

        public Criteria andDispatchImmediatelyFlagIsNull() {
            addCriterion("dispatch_immediately_flag is null");
            return (Criteria) this;
        }

        public Criteria andDispatchImmediatelyFlagIsNotNull() {
            addCriterion("dispatch_immediately_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDispatchImmediatelyFlagEqualTo(Boolean value) {
            addCriterion("dispatch_immediately_flag =", value, "dispatchImmediatelyFlag");
            return (Criteria) this;
        }

        public Criteria andDispatchImmediatelyFlagNotEqualTo(Boolean value) {
            addCriterion("dispatch_immediately_flag <>", value, "dispatchImmediatelyFlag");
            return (Criteria) this;
        }

        public Criteria andDispatchImmediatelyFlagGreaterThan(Boolean value) {
            addCriterion("dispatch_immediately_flag >", value, "dispatchImmediatelyFlag");
            return (Criteria) this;
        }

        public Criteria andDispatchImmediatelyFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("dispatch_immediately_flag >=", value, "dispatchImmediatelyFlag");
            return (Criteria) this;
        }

        public Criteria andDispatchImmediatelyFlagLessThan(Boolean value) {
            addCriterion("dispatch_immediately_flag <", value, "dispatchImmediatelyFlag");
            return (Criteria) this;
        }

        public Criteria andDispatchImmediatelyFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("dispatch_immediately_flag <=", value, "dispatchImmediatelyFlag");
            return (Criteria) this;
        }

        public Criteria andDispatchImmediatelyFlagIn(List<Boolean> values) {
            addCriterion("dispatch_immediately_flag in", values, "dispatchImmediatelyFlag");
            return (Criteria) this;
        }

        public Criteria andDispatchImmediatelyFlagNotIn(List<Boolean> values) {
            addCriterion("dispatch_immediately_flag not in", values, "dispatchImmediatelyFlag");
            return (Criteria) this;
        }

        public Criteria andDispatchImmediatelyFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("dispatch_immediately_flag between", value1, value2, "dispatchImmediatelyFlag");
            return (Criteria) this;
        }

        public Criteria andDispatchImmediatelyFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("dispatch_immediately_flag not between", value1, value2, "dispatchImmediatelyFlag");
            return (Criteria) this;
        }

        public Criteria andShardingKeyIsNull() {
            addCriterion("sharding_key is null");
            return (Criteria) this;
        }

        public Criteria andShardingKeyIsNotNull() {
            addCriterion("sharding_key is not null");
            return (Criteria) this;
        }

        public Criteria andShardingKeyEqualTo(Integer value) {
            addCriterion("sharding_key =", value, "shardingKey");
            return (Criteria) this;
        }

        public Criteria andShardingKeyNotEqualTo(Integer value) {
            addCriterion("sharding_key <>", value, "shardingKey");
            return (Criteria) this;
        }

        public Criteria andShardingKeyGreaterThan(Integer value) {
            addCriterion("sharding_key >", value, "shardingKey");
            return (Criteria) this;
        }

        public Criteria andShardingKeyGreaterThanOrEqualTo(Integer value) {
            addCriterion("sharding_key >=", value, "shardingKey");
            return (Criteria) this;
        }

        public Criteria andShardingKeyLessThan(Integer value) {
            addCriterion("sharding_key <", value, "shardingKey");
            return (Criteria) this;
        }

        public Criteria andShardingKeyLessThanOrEqualTo(Integer value) {
            addCriterion("sharding_key <=", value, "shardingKey");
            return (Criteria) this;
        }

        public Criteria andShardingKeyIn(List<Integer> values) {
            addCriterion("sharding_key in", values, "shardingKey");
            return (Criteria) this;
        }

        public Criteria andShardingKeyNotIn(List<Integer> values) {
            addCriterion("sharding_key not in", values, "shardingKey");
            return (Criteria) this;
        }

        public Criteria andShardingKeyBetween(Integer value1, Integer value2) {
            addCriterion("sharding_key between", value1, value2, "shardingKey");
            return (Criteria) this;
        }

        public Criteria andShardingKeyNotBetween(Integer value1, Integer value2) {
            addCriterion("sharding_key not between", value1, value2, "shardingKey");
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