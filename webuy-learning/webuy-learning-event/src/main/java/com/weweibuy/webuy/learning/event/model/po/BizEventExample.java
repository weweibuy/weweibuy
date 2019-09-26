package com.weweibuy.webuy.learning.event.model.po;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BizEventExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BizEventExample() {
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

        public Criteria andBizIdIsNull() {
            addCriterion("biz_id is null");
            return (Criteria) this;
        }

        public Criteria andBizIdIsNotNull() {
            addCriterion("biz_id is not null");
            return (Criteria) this;
        }

        public Criteria andBizIdEqualTo(String value) {
            addCriterion("biz_id =", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdNotEqualTo(String value) {
            addCriterion("biz_id <>", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdGreaterThan(String value) {
            addCriterion("biz_id >", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdGreaterThanOrEqualTo(String value) {
            addCriterion("biz_id >=", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdLessThan(String value) {
            addCriterion("biz_id <", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdLessThanOrEqualTo(String value) {
            addCriterion("biz_id <=", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdLike(String value) {
            addCriterion("biz_id like", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdNotLike(String value) {
            addCriterion("biz_id not like", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdIn(List<String> values) {
            addCriterion("biz_id in", values, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdNotIn(List<String> values) {
            addCriterion("biz_id not in", values, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdBetween(String value1, String value2) {
            addCriterion("biz_id between", value1, value2, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdNotBetween(String value1, String value2) {
            addCriterion("biz_id not between", value1, value2, "bizId");
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

        public Criteria andEventTypeIsNull() {
            addCriterion("event_type is null");
            return (Criteria) this;
        }

        public Criteria andEventTypeIsNotNull() {
            addCriterion("event_type is not null");
            return (Criteria) this;
        }

        public Criteria andEventTypeEqualTo(String value) {
            addCriterion("event_type =", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeNotEqualTo(String value) {
            addCriterion("event_type <>", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeGreaterThan(String value) {
            addCriterion("event_type >", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeGreaterThanOrEqualTo(String value) {
            addCriterion("event_type >=", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeLessThan(String value) {
            addCriterion("event_type <", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeLessThanOrEqualTo(String value) {
            addCriterion("event_type <=", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeLike(String value) {
            addCriterion("event_type like", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeNotLike(String value) {
            addCriterion("event_type not like", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeIn(List<String> values) {
            addCriterion("event_type in", values, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeNotIn(List<String> values) {
            addCriterion("event_type not in", values, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeBetween(String value1, String value2) {
            addCriterion("event_type between", value1, value2, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeNotBetween(String value1, String value2) {
            addCriterion("event_type not between", value1, value2, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventStatusIsNull() {
            addCriterion("event_status is null");
            return (Criteria) this;
        }

        public Criteria andEventStatusIsNotNull() {
            addCriterion("event_status is not null");
            return (Criteria) this;
        }

        public Criteria andEventStatusEqualTo(String value) {
            addCriterion("event_status =", value, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusNotEqualTo(String value) {
            addCriterion("event_status <>", value, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusGreaterThan(String value) {
            addCriterion("event_status >", value, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusGreaterThanOrEqualTo(String value) {
            addCriterion("event_status >=", value, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusLessThan(String value) {
            addCriterion("event_status <", value, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusLessThanOrEqualTo(String value) {
            addCriterion("event_status <=", value, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusLike(String value) {
            addCriterion("event_status like", value, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusNotLike(String value) {
            addCriterion("event_status not like", value, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusIn(List<String> values) {
            addCriterion("event_status in", values, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusNotIn(List<String> values) {
            addCriterion("event_status not in", values, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusBetween(String value1, String value2) {
            addCriterion("event_status between", value1, value2, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusNotBetween(String value1, String value2) {
            addCriterion("event_status not between", value1, value2, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeIsNull() {
            addCriterion("trigger_type is null");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeIsNotNull() {
            addCriterion("trigger_type is not null");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeEqualTo(Byte value) {
            addCriterion("trigger_type =", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeNotEqualTo(Byte value) {
            addCriterion("trigger_type <>", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeGreaterThan(Byte value) {
            addCriterion("trigger_type >", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("trigger_type >=", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeLessThan(Byte value) {
            addCriterion("trigger_type <", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeLessThanOrEqualTo(Byte value) {
            addCriterion("trigger_type <=", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeIn(List<Byte> values) {
            addCriterion("trigger_type in", values, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeNotIn(List<Byte> values) {
            addCriterion("trigger_type not in", values, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeBetween(Byte value1, Byte value2) {
            addCriterion("trigger_type between", value1, value2, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("trigger_type not between", value1, value2, "triggerType");
            return (Criteria) this;
        }

        public Criteria andBlockThresholdIsNull() {
            addCriterion("block_threshold is null");
            return (Criteria) this;
        }

        public Criteria andBlockThresholdIsNotNull() {
            addCriterion("block_threshold is not null");
            return (Criteria) this;
        }

        public Criteria andBlockThresholdEqualTo(String value) {
            addCriterion("block_threshold =", value, "blockThreshold");
            return (Criteria) this;
        }

        public Criteria andBlockThresholdNotEqualTo(String value) {
            addCriterion("block_threshold <>", value, "blockThreshold");
            return (Criteria) this;
        }

        public Criteria andBlockThresholdGreaterThan(String value) {
            addCriterion("block_threshold >", value, "blockThreshold");
            return (Criteria) this;
        }

        public Criteria andBlockThresholdGreaterThanOrEqualTo(String value) {
            addCriterion("block_threshold >=", value, "blockThreshold");
            return (Criteria) this;
        }

        public Criteria andBlockThresholdLessThan(String value) {
            addCriterion("block_threshold <", value, "blockThreshold");
            return (Criteria) this;
        }

        public Criteria andBlockThresholdLessThanOrEqualTo(String value) {
            addCriterion("block_threshold <=", value, "blockThreshold");
            return (Criteria) this;
        }

        public Criteria andBlockThresholdLike(String value) {
            addCriterion("block_threshold like", value, "blockThreshold");
            return (Criteria) this;
        }

        public Criteria andBlockThresholdNotLike(String value) {
            addCriterion("block_threshold not like", value, "blockThreshold");
            return (Criteria) this;
        }

        public Criteria andBlockThresholdIn(List<String> values) {
            addCriterion("block_threshold in", values, "blockThreshold");
            return (Criteria) this;
        }

        public Criteria andBlockThresholdNotIn(List<String> values) {
            addCriterion("block_threshold not in", values, "blockThreshold");
            return (Criteria) this;
        }

        public Criteria andBlockThresholdBetween(String value1, String value2) {
            addCriterion("block_threshold between", value1, value2, "blockThreshold");
            return (Criteria) this;
        }

        public Criteria andBlockThresholdNotBetween(String value1, String value2) {
            addCriterion("block_threshold not between", value1, value2, "blockThreshold");
            return (Criteria) this;
        }

        public Criteria andRetryRuleIsNull() {
            addCriterion("retry_rule is null");
            return (Criteria) this;
        }

        public Criteria andRetryRuleIsNotNull() {
            addCriterion("retry_rule is not null");
            return (Criteria) this;
        }

        public Criteria andRetryRuleEqualTo(String value) {
            addCriterion("retry_rule =", value, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleNotEqualTo(String value) {
            addCriterion("retry_rule <>", value, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleGreaterThan(String value) {
            addCriterion("retry_rule >", value, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleGreaterThanOrEqualTo(String value) {
            addCriterion("retry_rule >=", value, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleLessThan(String value) {
            addCriterion("retry_rule <", value, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleLessThanOrEqualTo(String value) {
            addCriterion("retry_rule <=", value, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleLike(String value) {
            addCriterion("retry_rule like", value, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleNotLike(String value) {
            addCriterion("retry_rule not like", value, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleIn(List<String> values) {
            addCriterion("retry_rule in", values, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleNotIn(List<String> values) {
            addCriterion("retry_rule not in", values, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleBetween(String value1, String value2) {
            addCriterion("retry_rule between", value1, value2, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleNotBetween(String value1, String value2) {
            addCriterion("retry_rule not between", value1, value2, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryCountIsNull() {
            addCriterion("retry_count is null");
            return (Criteria) this;
        }

        public Criteria andRetryCountIsNotNull() {
            addCriterion("retry_count is not null");
            return (Criteria) this;
        }

        public Criteria andRetryCountEqualTo(Integer value) {
            addCriterion("retry_count =", value, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountNotEqualTo(Integer value) {
            addCriterion("retry_count <>", value, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountGreaterThan(Integer value) {
            addCriterion("retry_count >", value, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("retry_count >=", value, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountLessThan(Integer value) {
            addCriterion("retry_count <", value, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountLessThanOrEqualTo(Integer value) {
            addCriterion("retry_count <=", value, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountIn(List<Integer> values) {
            addCriterion("retry_count in", values, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountNotIn(List<Integer> values) {
            addCriterion("retry_count not in", values, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountBetween(Integer value1, Integer value2) {
            addCriterion("retry_count between", value1, value2, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountNotBetween(Integer value1, Integer value2) {
            addCriterion("retry_count not between", value1, value2, "retryCount");
            return (Criteria) this;
        }

        public Criteria andAlarmRuleIsNull() {
            addCriterion("alarm_rule is null");
            return (Criteria) this;
        }

        public Criteria andAlarmRuleIsNotNull() {
            addCriterion("alarm_rule is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmRuleEqualTo(String value) {
            addCriterion("alarm_rule =", value, "alarmRule");
            return (Criteria) this;
        }

        public Criteria andAlarmRuleNotEqualTo(String value) {
            addCriterion("alarm_rule <>", value, "alarmRule");
            return (Criteria) this;
        }

        public Criteria andAlarmRuleGreaterThan(String value) {
            addCriterion("alarm_rule >", value, "alarmRule");
            return (Criteria) this;
        }

        public Criteria andAlarmRuleGreaterThanOrEqualTo(String value) {
            addCriterion("alarm_rule >=", value, "alarmRule");
            return (Criteria) this;
        }

        public Criteria andAlarmRuleLessThan(String value) {
            addCriterion("alarm_rule <", value, "alarmRule");
            return (Criteria) this;
        }

        public Criteria andAlarmRuleLessThanOrEqualTo(String value) {
            addCriterion("alarm_rule <=", value, "alarmRule");
            return (Criteria) this;
        }

        public Criteria andAlarmRuleLike(String value) {
            addCriterion("alarm_rule like", value, "alarmRule");
            return (Criteria) this;
        }

        public Criteria andAlarmRuleNotLike(String value) {
            addCriterion("alarm_rule not like", value, "alarmRule");
            return (Criteria) this;
        }

        public Criteria andAlarmRuleIn(List<String> values) {
            addCriterion("alarm_rule in", values, "alarmRule");
            return (Criteria) this;
        }

        public Criteria andAlarmRuleNotIn(List<String> values) {
            addCriterion("alarm_rule not in", values, "alarmRule");
            return (Criteria) this;
        }

        public Criteria andAlarmRuleBetween(String value1, String value2) {
            addCriterion("alarm_rule between", value1, value2, "alarmRule");
            return (Criteria) this;
        }

        public Criteria andAlarmRuleNotBetween(String value1, String value2) {
            addCriterion("alarm_rule not between", value1, value2, "alarmRule");
            return (Criteria) this;
        }

        public Criteria andAlarmCountIsNull() {
            addCriterion("alarm_count is null");
            return (Criteria) this;
        }

        public Criteria andAlarmCountIsNotNull() {
            addCriterion("alarm_count is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmCountEqualTo(Integer value) {
            addCriterion("alarm_count =", value, "alarmCount");
            return (Criteria) this;
        }

        public Criteria andAlarmCountNotEqualTo(Integer value) {
            addCriterion("alarm_count <>", value, "alarmCount");
            return (Criteria) this;
        }

        public Criteria andAlarmCountGreaterThan(Integer value) {
            addCriterion("alarm_count >", value, "alarmCount");
            return (Criteria) this;
        }

        public Criteria andAlarmCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("alarm_count >=", value, "alarmCount");
            return (Criteria) this;
        }

        public Criteria andAlarmCountLessThan(Integer value) {
            addCriterion("alarm_count <", value, "alarmCount");
            return (Criteria) this;
        }

        public Criteria andAlarmCountLessThanOrEqualTo(Integer value) {
            addCriterion("alarm_count <=", value, "alarmCount");
            return (Criteria) this;
        }

        public Criteria andAlarmCountIn(List<Integer> values) {
            addCriterion("alarm_count in", values, "alarmCount");
            return (Criteria) this;
        }

        public Criteria andAlarmCountNotIn(List<Integer> values) {
            addCriterion("alarm_count not in", values, "alarmCount");
            return (Criteria) this;
        }

        public Criteria andAlarmCountBetween(Integer value1, Integer value2) {
            addCriterion("alarm_count between", value1, value2, "alarmCount");
            return (Criteria) this;
        }

        public Criteria andAlarmCountNotBetween(Integer value1, Integer value2) {
            addCriterion("alarm_count not between", value1, value2, "alarmCount");
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

        public Criteria andCreateTimeEqualTo(LocalDateTime value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(LocalDateTime value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(LocalDateTime value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(LocalDateTime value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<LocalDateTime> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<LocalDateTime> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
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

        public Criteria andUpdateTimeEqualTo(LocalDateTime value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(LocalDateTime value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(LocalDateTime value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(LocalDateTime value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<LocalDateTime> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<LocalDateTime> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
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