package com.weweibuy.webuy.message.common.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WebuyMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WebuyMessageExample() {
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

        public Criteria andMessageCorrelationIdIsNull() {
            addCriterion("message_correlation_id is null");
            return (Criteria) this;
        }

        public Criteria andMessageCorrelationIdIsNotNull() {
            addCriterion("message_correlation_id is not null");
            return (Criteria) this;
        }

        public Criteria andMessageCorrelationIdEqualTo(String value) {
            addCriterion("message_correlation_id =", value, "messageCorrelationId");
            return (Criteria) this;
        }

        public Criteria andMessageCorrelationIdNotEqualTo(String value) {
            addCriterion("message_correlation_id <>", value, "messageCorrelationId");
            return (Criteria) this;
        }

        public Criteria andMessageCorrelationIdGreaterThan(String value) {
            addCriterion("message_correlation_id >", value, "messageCorrelationId");
            return (Criteria) this;
        }

        public Criteria andMessageCorrelationIdGreaterThanOrEqualTo(String value) {
            addCriterion("message_correlation_id >=", value, "messageCorrelationId");
            return (Criteria) this;
        }

        public Criteria andMessageCorrelationIdLessThan(String value) {
            addCriterion("message_correlation_id <", value, "messageCorrelationId");
            return (Criteria) this;
        }

        public Criteria andMessageCorrelationIdLessThanOrEqualTo(String value) {
            addCriterion("message_correlation_id <=", value, "messageCorrelationId");
            return (Criteria) this;
        }

        public Criteria andMessageCorrelationIdLike(String value) {
            addCriterion("message_correlation_id like", value, "messageCorrelationId");
            return (Criteria) this;
        }

        public Criteria andMessageCorrelationIdNotLike(String value) {
            addCriterion("message_correlation_id not like", value, "messageCorrelationId");
            return (Criteria) this;
        }

        public Criteria andMessageCorrelationIdIn(List<String> values) {
            addCriterion("message_correlation_id in", values, "messageCorrelationId");
            return (Criteria) this;
        }

        public Criteria andMessageCorrelationIdNotIn(List<String> values) {
            addCriterion("message_correlation_id not in", values, "messageCorrelationId");
            return (Criteria) this;
        }

        public Criteria andMessageCorrelationIdBetween(String value1, String value2) {
            addCriterion("message_correlation_id between", value1, value2, "messageCorrelationId");
            return (Criteria) this;
        }

        public Criteria andMessageCorrelationIdNotBetween(String value1, String value2) {
            addCriterion("message_correlation_id not between", value1, value2, "messageCorrelationId");
            return (Criteria) this;
        }

        public Criteria andMessageBobyIsNull() {
            addCriterion("message_boby is null");
            return (Criteria) this;
        }

        public Criteria andMessageBobyIsNotNull() {
            addCriterion("message_boby is not null");
            return (Criteria) this;
        }

        public Criteria andMessageBobyEqualTo(String value) {
            addCriterion("message_boby =", value, "messageBoby");
            return (Criteria) this;
        }

        public Criteria andMessageBobyNotEqualTo(String value) {
            addCriterion("message_boby <>", value, "messageBoby");
            return (Criteria) this;
        }

        public Criteria andMessageBobyGreaterThan(String value) {
            addCriterion("message_boby >", value, "messageBoby");
            return (Criteria) this;
        }

        public Criteria andMessageBobyGreaterThanOrEqualTo(String value) {
            addCriterion("message_boby >=", value, "messageBoby");
            return (Criteria) this;
        }

        public Criteria andMessageBobyLessThan(String value) {
            addCriterion("message_boby <", value, "messageBoby");
            return (Criteria) this;
        }

        public Criteria andMessageBobyLessThanOrEqualTo(String value) {
            addCriterion("message_boby <=", value, "messageBoby");
            return (Criteria) this;
        }

        public Criteria andMessageBobyLike(String value) {
            addCriterion("message_boby like", value, "messageBoby");
            return (Criteria) this;
        }

        public Criteria andMessageBobyNotLike(String value) {
            addCriterion("message_boby not like", value, "messageBoby");
            return (Criteria) this;
        }

        public Criteria andMessageBobyIn(List<String> values) {
            addCriterion("message_boby in", values, "messageBoby");
            return (Criteria) this;
        }

        public Criteria andMessageBobyNotIn(List<String> values) {
            addCriterion("message_boby not in", values, "messageBoby");
            return (Criteria) this;
        }

        public Criteria andMessageBobyBetween(String value1, String value2) {
            addCriterion("message_boby between", value1, value2, "messageBoby");
            return (Criteria) this;
        }

        public Criteria andMessageBobyNotBetween(String value1, String value2) {
            addCriterion("message_boby not between", value1, value2, "messageBoby");
            return (Criteria) this;
        }

        public Criteria andMessageQueueIsNull() {
            addCriterion("message_queue is null");
            return (Criteria) this;
        }

        public Criteria andMessageQueueIsNotNull() {
            addCriterion("message_queue is not null");
            return (Criteria) this;
        }

        public Criteria andMessageQueueEqualTo(String value) {
            addCriterion("message_queue =", value, "messageQueue");
            return (Criteria) this;
        }

        public Criteria andMessageQueueNotEqualTo(String value) {
            addCriterion("message_queue <>", value, "messageQueue");
            return (Criteria) this;
        }

        public Criteria andMessageQueueGreaterThan(String value) {
            addCriterion("message_queue >", value, "messageQueue");
            return (Criteria) this;
        }

        public Criteria andMessageQueueGreaterThanOrEqualTo(String value) {
            addCriterion("message_queue >=", value, "messageQueue");
            return (Criteria) this;
        }

        public Criteria andMessageQueueLessThan(String value) {
            addCriterion("message_queue <", value, "messageQueue");
            return (Criteria) this;
        }

        public Criteria andMessageQueueLessThanOrEqualTo(String value) {
            addCriterion("message_queue <=", value, "messageQueue");
            return (Criteria) this;
        }

        public Criteria andMessageQueueLike(String value) {
            addCriterion("message_queue like", value, "messageQueue");
            return (Criteria) this;
        }

        public Criteria andMessageQueueNotLike(String value) {
            addCriterion("message_queue not like", value, "messageQueue");
            return (Criteria) this;
        }

        public Criteria andMessageQueueIn(List<String> values) {
            addCriterion("message_queue in", values, "messageQueue");
            return (Criteria) this;
        }

        public Criteria andMessageQueueNotIn(List<String> values) {
            addCriterion("message_queue not in", values, "messageQueue");
            return (Criteria) this;
        }

        public Criteria andMessageQueueBetween(String value1, String value2) {
            addCriterion("message_queue between", value1, value2, "messageQueue");
            return (Criteria) this;
        }

        public Criteria andMessageQueueNotBetween(String value1, String value2) {
            addCriterion("message_queue not between", value1, value2, "messageQueue");
            return (Criteria) this;
        }

        public Criteria andMessageExchangeIsNull() {
            addCriterion("message_exchange is null");
            return (Criteria) this;
        }

        public Criteria andMessageExchangeIsNotNull() {
            addCriterion("message_exchange is not null");
            return (Criteria) this;
        }

        public Criteria andMessageExchangeEqualTo(String value) {
            addCriterion("message_exchange =", value, "messageExchange");
            return (Criteria) this;
        }

        public Criteria andMessageExchangeNotEqualTo(String value) {
            addCriterion("message_exchange <>", value, "messageExchange");
            return (Criteria) this;
        }

        public Criteria andMessageExchangeGreaterThan(String value) {
            addCriterion("message_exchange >", value, "messageExchange");
            return (Criteria) this;
        }

        public Criteria andMessageExchangeGreaterThanOrEqualTo(String value) {
            addCriterion("message_exchange >=", value, "messageExchange");
            return (Criteria) this;
        }

        public Criteria andMessageExchangeLessThan(String value) {
            addCriterion("message_exchange <", value, "messageExchange");
            return (Criteria) this;
        }

        public Criteria andMessageExchangeLessThanOrEqualTo(String value) {
            addCriterion("message_exchange <=", value, "messageExchange");
            return (Criteria) this;
        }

        public Criteria andMessageExchangeLike(String value) {
            addCriterion("message_exchange like", value, "messageExchange");
            return (Criteria) this;
        }

        public Criteria andMessageExchangeNotLike(String value) {
            addCriterion("message_exchange not like", value, "messageExchange");
            return (Criteria) this;
        }

        public Criteria andMessageExchangeIn(List<String> values) {
            addCriterion("message_exchange in", values, "messageExchange");
            return (Criteria) this;
        }

        public Criteria andMessageExchangeNotIn(List<String> values) {
            addCriterion("message_exchange not in", values, "messageExchange");
            return (Criteria) this;
        }

        public Criteria andMessageExchangeBetween(String value1, String value2) {
            addCriterion("message_exchange between", value1, value2, "messageExchange");
            return (Criteria) this;
        }

        public Criteria andMessageExchangeNotBetween(String value1, String value2) {
            addCriterion("message_exchange not between", value1, value2, "messageExchange");
            return (Criteria) this;
        }

        public Criteria andMessageRoutingKeyIsNull() {
            addCriterion("message_routing_key is null");
            return (Criteria) this;
        }

        public Criteria andMessageRoutingKeyIsNotNull() {
            addCriterion("message_routing_key is not null");
            return (Criteria) this;
        }

        public Criteria andMessageRoutingKeyEqualTo(String value) {
            addCriterion("message_routing_key =", value, "messageRoutingKey");
            return (Criteria) this;
        }

        public Criteria andMessageRoutingKeyNotEqualTo(String value) {
            addCriterion("message_routing_key <>", value, "messageRoutingKey");
            return (Criteria) this;
        }

        public Criteria andMessageRoutingKeyGreaterThan(String value) {
            addCriterion("message_routing_key >", value, "messageRoutingKey");
            return (Criteria) this;
        }

        public Criteria andMessageRoutingKeyGreaterThanOrEqualTo(String value) {
            addCriterion("message_routing_key >=", value, "messageRoutingKey");
            return (Criteria) this;
        }

        public Criteria andMessageRoutingKeyLessThan(String value) {
            addCriterion("message_routing_key <", value, "messageRoutingKey");
            return (Criteria) this;
        }

        public Criteria andMessageRoutingKeyLessThanOrEqualTo(String value) {
            addCriterion("message_routing_key <=", value, "messageRoutingKey");
            return (Criteria) this;
        }

        public Criteria andMessageRoutingKeyLike(String value) {
            addCriterion("message_routing_key like", value, "messageRoutingKey");
            return (Criteria) this;
        }

        public Criteria andMessageRoutingKeyNotLike(String value) {
            addCriterion("message_routing_key not like", value, "messageRoutingKey");
            return (Criteria) this;
        }

        public Criteria andMessageRoutingKeyIn(List<String> values) {
            addCriterion("message_routing_key in", values, "messageRoutingKey");
            return (Criteria) this;
        }

        public Criteria andMessageRoutingKeyNotIn(List<String> values) {
            addCriterion("message_routing_key not in", values, "messageRoutingKey");
            return (Criteria) this;
        }

        public Criteria andMessageRoutingKeyBetween(String value1, String value2) {
            addCriterion("message_routing_key between", value1, value2, "messageRoutingKey");
            return (Criteria) this;
        }

        public Criteria andMessageRoutingKeyNotBetween(String value1, String value2) {
            addCriterion("message_routing_key not between", value1, value2, "messageRoutingKey");
            return (Criteria) this;
        }

        public Criteria andMessageSendTimeIsNull() {
            addCriterion("message_send_time is null");
            return (Criteria) this;
        }

        public Criteria andMessageSendTimeIsNotNull() {
            addCriterion("message_send_time is not null");
            return (Criteria) this;
        }

        public Criteria andMessageSendTimeEqualTo(Byte value) {
            addCriterion("message_send_time =", value, "messageSendTime");
            return (Criteria) this;
        }

        public Criteria andMessageSendTimeNotEqualTo(Byte value) {
            addCriterion("message_send_time <>", value, "messageSendTime");
            return (Criteria) this;
        }

        public Criteria andMessageSendTimeGreaterThan(Byte value) {
            addCriterion("message_send_time >", value, "messageSendTime");
            return (Criteria) this;
        }

        public Criteria andMessageSendTimeGreaterThanOrEqualTo(Byte value) {
            addCriterion("message_send_time >=", value, "messageSendTime");
            return (Criteria) this;
        }

        public Criteria andMessageSendTimeLessThan(Byte value) {
            addCriterion("message_send_time <", value, "messageSendTime");
            return (Criteria) this;
        }

        public Criteria andMessageSendTimeLessThanOrEqualTo(Byte value) {
            addCriterion("message_send_time <=", value, "messageSendTime");
            return (Criteria) this;
        }

        public Criteria andMessageSendTimeIn(List<Byte> values) {
            addCriterion("message_send_time in", values, "messageSendTime");
            return (Criteria) this;
        }

        public Criteria andMessageSendTimeNotIn(List<Byte> values) {
            addCriterion("message_send_time not in", values, "messageSendTime");
            return (Criteria) this;
        }

        public Criteria andMessageSendTimeBetween(Byte value1, Byte value2) {
            addCriterion("message_send_time between", value1, value2, "messageSendTime");
            return (Criteria) this;
        }

        public Criteria andMessageSendTimeNotBetween(Byte value1, Byte value2) {
            addCriterion("message_send_time not between", value1, value2, "messageSendTime");
            return (Criteria) this;
        }

        public Criteria andIsDeadIsNull() {
            addCriterion("is_dead is null");
            return (Criteria) this;
        }

        public Criteria andIsDeadIsNotNull() {
            addCriterion("is_dead is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeadEqualTo(Byte value) {
            addCriterion("is_dead =", value, "isDead");
            return (Criteria) this;
        }

        public Criteria andIsDeadNotEqualTo(Byte value) {
            addCriterion("is_dead <>", value, "isDead");
            return (Criteria) this;
        }

        public Criteria andIsDeadGreaterThan(Byte value) {
            addCriterion("is_dead >", value, "isDead");
            return (Criteria) this;
        }

        public Criteria andIsDeadGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_dead >=", value, "isDead");
            return (Criteria) this;
        }

        public Criteria andIsDeadLessThan(Byte value) {
            addCriterion("is_dead <", value, "isDead");
            return (Criteria) this;
        }

        public Criteria andIsDeadLessThanOrEqualTo(Byte value) {
            addCriterion("is_dead <=", value, "isDead");
            return (Criteria) this;
        }

        public Criteria andIsDeadIn(List<Byte> values) {
            addCriterion("is_dead in", values, "isDead");
            return (Criteria) this;
        }

        public Criteria andIsDeadNotIn(List<Byte> values) {
            addCriterion("is_dead not in", values, "isDead");
            return (Criteria) this;
        }

        public Criteria andIsDeadBetween(Byte value1, Byte value2) {
            addCriterion("is_dead between", value1, value2, "isDead");
            return (Criteria) this;
        }

        public Criteria andIsDeadNotBetween(Byte value1, Byte value2) {
            addCriterion("is_dead not between", value1, value2, "isDead");
            return (Criteria) this;
        }

        public Criteria andMessageStatusIsNull() {
            addCriterion("message_status is null");
            return (Criteria) this;
        }

        public Criteria andMessageStatusIsNotNull() {
            addCriterion("message_status is not null");
            return (Criteria) this;
        }

        public Criteria andMessageStatusEqualTo(Byte value) {
            addCriterion("message_status =", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusNotEqualTo(Byte value) {
            addCriterion("message_status <>", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusGreaterThan(Byte value) {
            addCriterion("message_status >", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("message_status >=", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusLessThan(Byte value) {
            addCriterion("message_status <", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusLessThanOrEqualTo(Byte value) {
            addCriterion("message_status <=", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusIn(List<Byte> values) {
            addCriterion("message_status in", values, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusNotIn(List<Byte> values) {
            addCriterion("message_status not in", values, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusBetween(Byte value1, Byte value2) {
            addCriterion("message_status between", value1, value2, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("message_status not between", value1, value2, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andField1IsNull() {
            addCriterion("field1 is null");
            return (Criteria) this;
        }

        public Criteria andField1IsNotNull() {
            addCriterion("field1 is not null");
            return (Criteria) this;
        }

        public Criteria andField1EqualTo(String value) {
            addCriterion("field1 =", value, "field1");
            return (Criteria) this;
        }

        public Criteria andField1NotEqualTo(String value) {
            addCriterion("field1 <>", value, "field1");
            return (Criteria) this;
        }

        public Criteria andField1GreaterThan(String value) {
            addCriterion("field1 >", value, "field1");
            return (Criteria) this;
        }

        public Criteria andField1GreaterThanOrEqualTo(String value) {
            addCriterion("field1 >=", value, "field1");
            return (Criteria) this;
        }

        public Criteria andField1LessThan(String value) {
            addCriterion("field1 <", value, "field1");
            return (Criteria) this;
        }

        public Criteria andField1LessThanOrEqualTo(String value) {
            addCriterion("field1 <=", value, "field1");
            return (Criteria) this;
        }

        public Criteria andField1Like(String value) {
            addCriterion("field1 like", value, "field1");
            return (Criteria) this;
        }

        public Criteria andField1NotLike(String value) {
            addCriterion("field1 not like", value, "field1");
            return (Criteria) this;
        }

        public Criteria andField1In(List<String> values) {
            addCriterion("field1 in", values, "field1");
            return (Criteria) this;
        }

        public Criteria andField1NotIn(List<String> values) {
            addCriterion("field1 not in", values, "field1");
            return (Criteria) this;
        }

        public Criteria andField1Between(String value1, String value2) {
            addCriterion("field1 between", value1, value2, "field1");
            return (Criteria) this;
        }

        public Criteria andField1NotBetween(String value1, String value2) {
            addCriterion("field1 not between", value1, value2, "field1");
            return (Criteria) this;
        }

        public Criteria andField2IsNull() {
            addCriterion("field2 is null");
            return (Criteria) this;
        }

        public Criteria andField2IsNotNull() {
            addCriterion("field2 is not null");
            return (Criteria) this;
        }

        public Criteria andField2EqualTo(String value) {
            addCriterion("field2 =", value, "field2");
            return (Criteria) this;
        }

        public Criteria andField2NotEqualTo(String value) {
            addCriterion("field2 <>", value, "field2");
            return (Criteria) this;
        }

        public Criteria andField2GreaterThan(String value) {
            addCriterion("field2 >", value, "field2");
            return (Criteria) this;
        }

        public Criteria andField2GreaterThanOrEqualTo(String value) {
            addCriterion("field2 >=", value, "field2");
            return (Criteria) this;
        }

        public Criteria andField2LessThan(String value) {
            addCriterion("field2 <", value, "field2");
            return (Criteria) this;
        }

        public Criteria andField2LessThanOrEqualTo(String value) {
            addCriterion("field2 <=", value, "field2");
            return (Criteria) this;
        }

        public Criteria andField2Like(String value) {
            addCriterion("field2 like", value, "field2");
            return (Criteria) this;
        }

        public Criteria andField2NotLike(String value) {
            addCriterion("field2 not like", value, "field2");
            return (Criteria) this;
        }

        public Criteria andField2In(List<String> values) {
            addCriterion("field2 in", values, "field2");
            return (Criteria) this;
        }

        public Criteria andField2NotIn(List<String> values) {
            addCriterion("field2 not in", values, "field2");
            return (Criteria) this;
        }

        public Criteria andField2Between(String value1, String value2) {
            addCriterion("field2 between", value1, value2, "field2");
            return (Criteria) this;
        }

        public Criteria andField2NotBetween(String value1, String value2) {
            addCriterion("field2 not between", value1, value2, "field2");
            return (Criteria) this;
        }

        public Criteria andField3IsNull() {
            addCriterion("field3 is null");
            return (Criteria) this;
        }

        public Criteria andField3IsNotNull() {
            addCriterion("field3 is not null");
            return (Criteria) this;
        }

        public Criteria andField3EqualTo(String value) {
            addCriterion("field3 =", value, "field3");
            return (Criteria) this;
        }

        public Criteria andField3NotEqualTo(String value) {
            addCriterion("field3 <>", value, "field3");
            return (Criteria) this;
        }

        public Criteria andField3GreaterThan(String value) {
            addCriterion("field3 >", value, "field3");
            return (Criteria) this;
        }

        public Criteria andField3GreaterThanOrEqualTo(String value) {
            addCriterion("field3 >=", value, "field3");
            return (Criteria) this;
        }

        public Criteria andField3LessThan(String value) {
            addCriterion("field3 <", value, "field3");
            return (Criteria) this;
        }

        public Criteria andField3LessThanOrEqualTo(String value) {
            addCriterion("field3 <=", value, "field3");
            return (Criteria) this;
        }

        public Criteria andField3Like(String value) {
            addCriterion("field3 like", value, "field3");
            return (Criteria) this;
        }

        public Criteria andField3NotLike(String value) {
            addCriterion("field3 not like", value, "field3");
            return (Criteria) this;
        }

        public Criteria andField3In(List<String> values) {
            addCriterion("field3 in", values, "field3");
            return (Criteria) this;
        }

        public Criteria andField3NotIn(List<String> values) {
            addCriterion("field3 not in", values, "field3");
            return (Criteria) this;
        }

        public Criteria andField3Between(String value1, String value2) {
            addCriterion("field3 between", value1, value2, "field3");
            return (Criteria) this;
        }

        public Criteria andField3NotBetween(String value1, String value2) {
            addCriterion("field3 not between", value1, value2, "field3");
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

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
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