package com.weweibuy.webuy.product.common.model.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WebuyItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WebuyItemExample() {
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

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(Long value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(Long value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(Long value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(Long value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(Long value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(Long value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<Long> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<Long> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(Long value1, Long value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(Long value1, Long value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNull() {
            addCriterion("item_name is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("item_name is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("item_name =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("item_name <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("item_name >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("item_name >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("item_name <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("item_name <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("item_name like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("item_name not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("item_name in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("item_name not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("item_name between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("item_name not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemTitleIsNull() {
            addCriterion("item_title is null");
            return (Criteria) this;
        }

        public Criteria andItemTitleIsNotNull() {
            addCriterion("item_title is not null");
            return (Criteria) this;
        }

        public Criteria andItemTitleEqualTo(String value) {
            addCriterion("item_title =", value, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleNotEqualTo(String value) {
            addCriterion("item_title <>", value, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleGreaterThan(String value) {
            addCriterion("item_title >", value, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleGreaterThanOrEqualTo(String value) {
            addCriterion("item_title >=", value, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleLessThan(String value) {
            addCriterion("item_title <", value, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleLessThanOrEqualTo(String value) {
            addCriterion("item_title <=", value, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleLike(String value) {
            addCriterion("item_title like", value, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleNotLike(String value) {
            addCriterion("item_title not like", value, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleIn(List<String> values) {
            addCriterion("item_title in", values, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleNotIn(List<String> values) {
            addCriterion("item_title not in", values, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleBetween(String value1, String value2) {
            addCriterion("item_title between", value1, value2, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleNotBetween(String value1, String value2) {
            addCriterion("item_title not between", value1, value2, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andSalePointIsNull() {
            addCriterion("sale_point is null");
            return (Criteria) this;
        }

        public Criteria andSalePointIsNotNull() {
            addCriterion("sale_point is not null");
            return (Criteria) this;
        }

        public Criteria andSalePointEqualTo(String value) {
            addCriterion("sale_point =", value, "salePoint");
            return (Criteria) this;
        }

        public Criteria andSalePointNotEqualTo(String value) {
            addCriterion("sale_point <>", value, "salePoint");
            return (Criteria) this;
        }

        public Criteria andSalePointGreaterThan(String value) {
            addCriterion("sale_point >", value, "salePoint");
            return (Criteria) this;
        }

        public Criteria andSalePointGreaterThanOrEqualTo(String value) {
            addCriterion("sale_point >=", value, "salePoint");
            return (Criteria) this;
        }

        public Criteria andSalePointLessThan(String value) {
            addCriterion("sale_point <", value, "salePoint");
            return (Criteria) this;
        }

        public Criteria andSalePointLessThanOrEqualTo(String value) {
            addCriterion("sale_point <=", value, "salePoint");
            return (Criteria) this;
        }

        public Criteria andSalePointLike(String value) {
            addCriterion("sale_point like", value, "salePoint");
            return (Criteria) this;
        }

        public Criteria andSalePointNotLike(String value) {
            addCriterion("sale_point not like", value, "salePoint");
            return (Criteria) this;
        }

        public Criteria andSalePointIn(List<String> values) {
            addCriterion("sale_point in", values, "salePoint");
            return (Criteria) this;
        }

        public Criteria andSalePointNotIn(List<String> values) {
            addCriterion("sale_point not in", values, "salePoint");
            return (Criteria) this;
        }

        public Criteria andSalePointBetween(String value1, String value2) {
            addCriterion("sale_point between", value1, value2, "salePoint");
            return (Criteria) this;
        }

        public Criteria andSalePointNotBetween(String value1, String value2) {
            addCriterion("sale_point not between", value1, value2, "salePoint");
            return (Criteria) this;
        }

        public Criteria andMaxPriceIsNull() {
            addCriterion("max_price is null");
            return (Criteria) this;
        }

        public Criteria andMaxPriceIsNotNull() {
            addCriterion("max_price is not null");
            return (Criteria) this;
        }

        public Criteria andMaxPriceEqualTo(BigDecimal value) {
            addCriterion("max_price =", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceNotEqualTo(BigDecimal value) {
            addCriterion("max_price <>", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceGreaterThan(BigDecimal value) {
            addCriterion("max_price >", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("max_price >=", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceLessThan(BigDecimal value) {
            addCriterion("max_price <", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("max_price <=", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceIn(List<BigDecimal> values) {
            addCriterion("max_price in", values, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceNotIn(List<BigDecimal> values) {
            addCriterion("max_price not in", values, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_price between", value1, value2, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_price not between", value1, value2, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMixPriceIsNull() {
            addCriterion("mix_price is null");
            return (Criteria) this;
        }

        public Criteria andMixPriceIsNotNull() {
            addCriterion("mix_price is not null");
            return (Criteria) this;
        }

        public Criteria andMixPriceEqualTo(BigDecimal value) {
            addCriterion("mix_price =", value, "mixPrice");
            return (Criteria) this;
        }

        public Criteria andMixPriceNotEqualTo(BigDecimal value) {
            addCriterion("mix_price <>", value, "mixPrice");
            return (Criteria) this;
        }

        public Criteria andMixPriceGreaterThan(BigDecimal value) {
            addCriterion("mix_price >", value, "mixPrice");
            return (Criteria) this;
        }

        public Criteria andMixPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("mix_price >=", value, "mixPrice");
            return (Criteria) this;
        }

        public Criteria andMixPriceLessThan(BigDecimal value) {
            addCriterion("mix_price <", value, "mixPrice");
            return (Criteria) this;
        }

        public Criteria andMixPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("mix_price <=", value, "mixPrice");
            return (Criteria) this;
        }

        public Criteria andMixPriceIn(List<BigDecimal> values) {
            addCriterion("mix_price in", values, "mixPrice");
            return (Criteria) this;
        }

        public Criteria andMixPriceNotIn(List<BigDecimal> values) {
            addCriterion("mix_price not in", values, "mixPrice");
            return (Criteria) this;
        }

        public Criteria andMixPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mix_price between", value1, value2, "mixPrice");
            return (Criteria) this;
        }

        public Criteria andMixPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mix_price not between", value1, value2, "mixPrice");
            return (Criteria) this;
        }

        public Criteria andOnSaleTimeIsNull() {
            addCriterion("on_sale_time is null");
            return (Criteria) this;
        }

        public Criteria andOnSaleTimeIsNotNull() {
            addCriterion("on_sale_time is not null");
            return (Criteria) this;
        }

        public Criteria andOnSaleTimeEqualTo(Date value) {
            addCriterion("on_sale_time =", value, "onSaleTime");
            return (Criteria) this;
        }

        public Criteria andOnSaleTimeNotEqualTo(Date value) {
            addCriterion("on_sale_time <>", value, "onSaleTime");
            return (Criteria) this;
        }

        public Criteria andOnSaleTimeGreaterThan(Date value) {
            addCriterion("on_sale_time >", value, "onSaleTime");
            return (Criteria) this;
        }

        public Criteria andOnSaleTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("on_sale_time >=", value, "onSaleTime");
            return (Criteria) this;
        }

        public Criteria andOnSaleTimeLessThan(Date value) {
            addCriterion("on_sale_time <", value, "onSaleTime");
            return (Criteria) this;
        }

        public Criteria andOnSaleTimeLessThanOrEqualTo(Date value) {
            addCriterion("on_sale_time <=", value, "onSaleTime");
            return (Criteria) this;
        }

        public Criteria andOnSaleTimeIn(List<Date> values) {
            addCriterion("on_sale_time in", values, "onSaleTime");
            return (Criteria) this;
        }

        public Criteria andOnSaleTimeNotIn(List<Date> values) {
            addCriterion("on_sale_time not in", values, "onSaleTime");
            return (Criteria) this;
        }

        public Criteria andOnSaleTimeBetween(Date value1, Date value2) {
            addCriterion("on_sale_time between", value1, value2, "onSaleTime");
            return (Criteria) this;
        }

        public Criteria andOnSaleTimeNotBetween(Date value1, Date value2) {
            addCriterion("on_sale_time not between", value1, value2, "onSaleTime");
            return (Criteria) this;
        }

        public Criteria andOffSaleTimeIsNull() {
            addCriterion("off_sale_time is null");
            return (Criteria) this;
        }

        public Criteria andOffSaleTimeIsNotNull() {
            addCriterion("off_sale_time is not null");
            return (Criteria) this;
        }

        public Criteria andOffSaleTimeEqualTo(Date value) {
            addCriterion("off_sale_time =", value, "offSaleTime");
            return (Criteria) this;
        }

        public Criteria andOffSaleTimeNotEqualTo(Date value) {
            addCriterion("off_sale_time <>", value, "offSaleTime");
            return (Criteria) this;
        }

        public Criteria andOffSaleTimeGreaterThan(Date value) {
            addCriterion("off_sale_time >", value, "offSaleTime");
            return (Criteria) this;
        }

        public Criteria andOffSaleTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("off_sale_time >=", value, "offSaleTime");
            return (Criteria) this;
        }

        public Criteria andOffSaleTimeLessThan(Date value) {
            addCriterion("off_sale_time <", value, "offSaleTime");
            return (Criteria) this;
        }

        public Criteria andOffSaleTimeLessThanOrEqualTo(Date value) {
            addCriterion("off_sale_time <=", value, "offSaleTime");
            return (Criteria) this;
        }

        public Criteria andOffSaleTimeIn(List<Date> values) {
            addCriterion("off_sale_time in", values, "offSaleTime");
            return (Criteria) this;
        }

        public Criteria andOffSaleTimeNotIn(List<Date> values) {
            addCriterion("off_sale_time not in", values, "offSaleTime");
            return (Criteria) this;
        }

        public Criteria andOffSaleTimeBetween(Date value1, Date value2) {
            addCriterion("off_sale_time between", value1, value2, "offSaleTime");
            return (Criteria) this;
        }

        public Criteria andOffSaleTimeNotBetween(Date value1, Date value2) {
            addCriterion("off_sale_time not between", value1, value2, "offSaleTime");
            return (Criteria) this;
        }

        public Criteria andIsPromoteIsNull() {
            addCriterion("is_promote is null");
            return (Criteria) this;
        }

        public Criteria andIsPromoteIsNotNull() {
            addCriterion("is_promote is not null");
            return (Criteria) this;
        }

        public Criteria andIsPromoteEqualTo(Byte value) {
            addCriterion("is_promote =", value, "isPromote");
            return (Criteria) this;
        }

        public Criteria andIsPromoteNotEqualTo(Byte value) {
            addCriterion("is_promote <>", value, "isPromote");
            return (Criteria) this;
        }

        public Criteria andIsPromoteGreaterThan(Byte value) {
            addCriterion("is_promote >", value, "isPromote");
            return (Criteria) this;
        }

        public Criteria andIsPromoteGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_promote >=", value, "isPromote");
            return (Criteria) this;
        }

        public Criteria andIsPromoteLessThan(Byte value) {
            addCriterion("is_promote <", value, "isPromote");
            return (Criteria) this;
        }

        public Criteria andIsPromoteLessThanOrEqualTo(Byte value) {
            addCriterion("is_promote <=", value, "isPromote");
            return (Criteria) this;
        }

        public Criteria andIsPromoteIn(List<Byte> values) {
            addCriterion("is_promote in", values, "isPromote");
            return (Criteria) this;
        }

        public Criteria andIsPromoteNotIn(List<Byte> values) {
            addCriterion("is_promote not in", values, "isPromote");
            return (Criteria) this;
        }

        public Criteria andIsPromoteBetween(Byte value1, Byte value2) {
            addCriterion("is_promote between", value1, value2, "isPromote");
            return (Criteria) this;
        }

        public Criteria andIsPromoteNotBetween(Byte value1, Byte value2) {
            addCriterion("is_promote not between", value1, value2, "isPromote");
            return (Criteria) this;
        }

        public Criteria andPromotePriceIsNull() {
            addCriterion("promote_price is null");
            return (Criteria) this;
        }

        public Criteria andPromotePriceIsNotNull() {
            addCriterion("promote_price is not null");
            return (Criteria) this;
        }

        public Criteria andPromotePriceEqualTo(BigDecimal value) {
            addCriterion("promote_price =", value, "promotePrice");
            return (Criteria) this;
        }

        public Criteria andPromotePriceNotEqualTo(BigDecimal value) {
            addCriterion("promote_price <>", value, "promotePrice");
            return (Criteria) this;
        }

        public Criteria andPromotePriceGreaterThan(BigDecimal value) {
            addCriterion("promote_price >", value, "promotePrice");
            return (Criteria) this;
        }

        public Criteria andPromotePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("promote_price >=", value, "promotePrice");
            return (Criteria) this;
        }

        public Criteria andPromotePriceLessThan(BigDecimal value) {
            addCriterion("promote_price <", value, "promotePrice");
            return (Criteria) this;
        }

        public Criteria andPromotePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("promote_price <=", value, "promotePrice");
            return (Criteria) this;
        }

        public Criteria andPromotePriceIn(List<BigDecimal> values) {
            addCriterion("promote_price in", values, "promotePrice");
            return (Criteria) this;
        }

        public Criteria andPromotePriceNotIn(List<BigDecimal> values) {
            addCriterion("promote_price not in", values, "promotePrice");
            return (Criteria) this;
        }

        public Criteria andPromotePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promote_price between", value1, value2, "promotePrice");
            return (Criteria) this;
        }

        public Criteria andPromotePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promote_price not between", value1, value2, "promotePrice");
            return (Criteria) this;
        }

        public Criteria andPromoteStartTimeIsNull() {
            addCriterion("promote_start_time is null");
            return (Criteria) this;
        }

        public Criteria andPromoteStartTimeIsNotNull() {
            addCriterion("promote_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andPromoteStartTimeEqualTo(Date value) {
            addCriterion("promote_start_time =", value, "promoteStartTime");
            return (Criteria) this;
        }

        public Criteria andPromoteStartTimeNotEqualTo(Date value) {
            addCriterion("promote_start_time <>", value, "promoteStartTime");
            return (Criteria) this;
        }

        public Criteria andPromoteStartTimeGreaterThan(Date value) {
            addCriterion("promote_start_time >", value, "promoteStartTime");
            return (Criteria) this;
        }

        public Criteria andPromoteStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("promote_start_time >=", value, "promoteStartTime");
            return (Criteria) this;
        }

        public Criteria andPromoteStartTimeLessThan(Date value) {
            addCriterion("promote_start_time <", value, "promoteStartTime");
            return (Criteria) this;
        }

        public Criteria andPromoteStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("promote_start_time <=", value, "promoteStartTime");
            return (Criteria) this;
        }

        public Criteria andPromoteStartTimeIn(List<Date> values) {
            addCriterion("promote_start_time in", values, "promoteStartTime");
            return (Criteria) this;
        }

        public Criteria andPromoteStartTimeNotIn(List<Date> values) {
            addCriterion("promote_start_time not in", values, "promoteStartTime");
            return (Criteria) this;
        }

        public Criteria andPromoteStartTimeBetween(Date value1, Date value2) {
            addCriterion("promote_start_time between", value1, value2, "promoteStartTime");
            return (Criteria) this;
        }

        public Criteria andPromoteStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("promote_start_time not between", value1, value2, "promoteStartTime");
            return (Criteria) this;
        }

        public Criteria andPromoteEndtTimeIsNull() {
            addCriterion("promote_endt_time is null");
            return (Criteria) this;
        }

        public Criteria andPromoteEndtTimeIsNotNull() {
            addCriterion("promote_endt_time is not null");
            return (Criteria) this;
        }

        public Criteria andPromoteEndtTimeEqualTo(Date value) {
            addCriterion("promote_endt_time =", value, "promoteEndtTime");
            return (Criteria) this;
        }

        public Criteria andPromoteEndtTimeNotEqualTo(Date value) {
            addCriterion("promote_endt_time <>", value, "promoteEndtTime");
            return (Criteria) this;
        }

        public Criteria andPromoteEndtTimeGreaterThan(Date value) {
            addCriterion("promote_endt_time >", value, "promoteEndtTime");
            return (Criteria) this;
        }

        public Criteria andPromoteEndtTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("promote_endt_time >=", value, "promoteEndtTime");
            return (Criteria) this;
        }

        public Criteria andPromoteEndtTimeLessThan(Date value) {
            addCriterion("promote_endt_time <", value, "promoteEndtTime");
            return (Criteria) this;
        }

        public Criteria andPromoteEndtTimeLessThanOrEqualTo(Date value) {
            addCriterion("promote_endt_time <=", value, "promoteEndtTime");
            return (Criteria) this;
        }

        public Criteria andPromoteEndtTimeIn(List<Date> values) {
            addCriterion("promote_endt_time in", values, "promoteEndtTime");
            return (Criteria) this;
        }

        public Criteria andPromoteEndtTimeNotIn(List<Date> values) {
            addCriterion("promote_endt_time not in", values, "promoteEndtTime");
            return (Criteria) this;
        }

        public Criteria andPromoteEndtTimeBetween(Date value1, Date value2) {
            addCriterion("promote_endt_time between", value1, value2, "promoteEndtTime");
            return (Criteria) this;
        }

        public Criteria andPromoteEndtTimeNotBetween(Date value1, Date value2) {
            addCriterion("promote_endt_time not between", value1, value2, "promoteEndtTime");
            return (Criteria) this;
        }

        public Criteria andSaleCountIsNull() {
            addCriterion("sale_count is null");
            return (Criteria) this;
        }

        public Criteria andSaleCountIsNotNull() {
            addCriterion("sale_count is not null");
            return (Criteria) this;
        }

        public Criteria andSaleCountEqualTo(Integer value) {
            addCriterion("sale_count =", value, "saleCount");
            return (Criteria) this;
        }

        public Criteria andSaleCountNotEqualTo(Integer value) {
            addCriterion("sale_count <>", value, "saleCount");
            return (Criteria) this;
        }

        public Criteria andSaleCountGreaterThan(Integer value) {
            addCriterion("sale_count >", value, "saleCount");
            return (Criteria) this;
        }

        public Criteria andSaleCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("sale_count >=", value, "saleCount");
            return (Criteria) this;
        }

        public Criteria andSaleCountLessThan(Integer value) {
            addCriterion("sale_count <", value, "saleCount");
            return (Criteria) this;
        }

        public Criteria andSaleCountLessThanOrEqualTo(Integer value) {
            addCriterion("sale_count <=", value, "saleCount");
            return (Criteria) this;
        }

        public Criteria andSaleCountIn(List<Integer> values) {
            addCriterion("sale_count in", values, "saleCount");
            return (Criteria) this;
        }

        public Criteria andSaleCountNotIn(List<Integer> values) {
            addCriterion("sale_count not in", values, "saleCount");
            return (Criteria) this;
        }

        public Criteria andSaleCountBetween(Integer value1, Integer value2) {
            addCriterion("sale_count between", value1, value2, "saleCount");
            return (Criteria) this;
        }

        public Criteria andSaleCountNotBetween(Integer value1, Integer value2) {
            addCriterion("sale_count not between", value1, value2, "saleCount");
            return (Criteria) this;
        }

        public Criteria andSellerIdIsNull() {
            addCriterion("seller_id is null");
            return (Criteria) this;
        }

        public Criteria andSellerIdIsNotNull() {
            addCriterion("seller_id is not null");
            return (Criteria) this;
        }

        public Criteria andSellerIdEqualTo(Long value) {
            addCriterion("seller_id =", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotEqualTo(Long value) {
            addCriterion("seller_id <>", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdGreaterThan(Long value) {
            addCriterion("seller_id >", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("seller_id >=", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLessThan(Long value) {
            addCriterion("seller_id <", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLessThanOrEqualTo(Long value) {
            addCriterion("seller_id <=", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdIn(List<Long> values) {
            addCriterion("seller_id in", values, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotIn(List<Long> values) {
            addCriterion("seller_id not in", values, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdBetween(Long value1, Long value2) {
            addCriterion("seller_id between", value1, value2, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotBetween(Long value1, Long value2) {
            addCriterion("seller_id not between", value1, value2, "sellerId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNull() {
            addCriterion("brand_id is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNotNull() {
            addCriterion("brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdEqualTo(Long value) {
            addCriterion("brand_id =", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotEqualTo(Long value) {
            addCriterion("brand_id <>", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThan(Long value) {
            addCriterion("brand_id >", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThanOrEqualTo(Long value) {
            addCriterion("brand_id >=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThan(Long value) {
            addCriterion("brand_id <", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThanOrEqualTo(Long value) {
            addCriterion("brand_id <=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIn(List<Long> values) {
            addCriterion("brand_id in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotIn(List<Long> values) {
            addCriterion("brand_id not in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdBetween(Long value1, Long value2) {
            addCriterion("brand_id between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotBetween(Long value1, Long value2) {
            addCriterion("brand_id not between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andCategory1IdIsNull() {
            addCriterion("category1_id is null");
            return (Criteria) this;
        }

        public Criteria andCategory1IdIsNotNull() {
            addCriterion("category1_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategory1IdEqualTo(Long value) {
            addCriterion("category1_id =", value, "category1Id");
            return (Criteria) this;
        }

        public Criteria andCategory1IdNotEqualTo(Long value) {
            addCriterion("category1_id <>", value, "category1Id");
            return (Criteria) this;
        }

        public Criteria andCategory1IdGreaterThan(Long value) {
            addCriterion("category1_id >", value, "category1Id");
            return (Criteria) this;
        }

        public Criteria andCategory1IdGreaterThanOrEqualTo(Long value) {
            addCriterion("category1_id >=", value, "category1Id");
            return (Criteria) this;
        }

        public Criteria andCategory1IdLessThan(Long value) {
            addCriterion("category1_id <", value, "category1Id");
            return (Criteria) this;
        }

        public Criteria andCategory1IdLessThanOrEqualTo(Long value) {
            addCriterion("category1_id <=", value, "category1Id");
            return (Criteria) this;
        }

        public Criteria andCategory1IdIn(List<Long> values) {
            addCriterion("category1_id in", values, "category1Id");
            return (Criteria) this;
        }

        public Criteria andCategory1IdNotIn(List<Long> values) {
            addCriterion("category1_id not in", values, "category1Id");
            return (Criteria) this;
        }

        public Criteria andCategory1IdBetween(Long value1, Long value2) {
            addCriterion("category1_id between", value1, value2, "category1Id");
            return (Criteria) this;
        }

        public Criteria andCategory1IdNotBetween(Long value1, Long value2) {
            addCriterion("category1_id not between", value1, value2, "category1Id");
            return (Criteria) this;
        }

        public Criteria andCategory2IdIsNull() {
            addCriterion("category2_id is null");
            return (Criteria) this;
        }

        public Criteria andCategory2IdIsNotNull() {
            addCriterion("category2_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategory2IdEqualTo(Long value) {
            addCriterion("category2_id =", value, "category2Id");
            return (Criteria) this;
        }

        public Criteria andCategory2IdNotEqualTo(Long value) {
            addCriterion("category2_id <>", value, "category2Id");
            return (Criteria) this;
        }

        public Criteria andCategory2IdGreaterThan(Long value) {
            addCriterion("category2_id >", value, "category2Id");
            return (Criteria) this;
        }

        public Criteria andCategory2IdGreaterThanOrEqualTo(Long value) {
            addCriterion("category2_id >=", value, "category2Id");
            return (Criteria) this;
        }

        public Criteria andCategory2IdLessThan(Long value) {
            addCriterion("category2_id <", value, "category2Id");
            return (Criteria) this;
        }

        public Criteria andCategory2IdLessThanOrEqualTo(Long value) {
            addCriterion("category2_id <=", value, "category2Id");
            return (Criteria) this;
        }

        public Criteria andCategory2IdIn(List<Long> values) {
            addCriterion("category2_id in", values, "category2Id");
            return (Criteria) this;
        }

        public Criteria andCategory2IdNotIn(List<Long> values) {
            addCriterion("category2_id not in", values, "category2Id");
            return (Criteria) this;
        }

        public Criteria andCategory2IdBetween(Long value1, Long value2) {
            addCriterion("category2_id between", value1, value2, "category2Id");
            return (Criteria) this;
        }

        public Criteria andCategory2IdNotBetween(Long value1, Long value2) {
            addCriterion("category2_id not between", value1, value2, "category2Id");
            return (Criteria) this;
        }

        public Criteria andCategory3IdIsNull() {
            addCriterion("category3_id is null");
            return (Criteria) this;
        }

        public Criteria andCategory3IdIsNotNull() {
            addCriterion("category3_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategory3IdEqualTo(Long value) {
            addCriterion("category3_id =", value, "category3Id");
            return (Criteria) this;
        }

        public Criteria andCategory3IdNotEqualTo(Long value) {
            addCriterion("category3_id <>", value, "category3Id");
            return (Criteria) this;
        }

        public Criteria andCategory3IdGreaterThan(Long value) {
            addCriterion("category3_id >", value, "category3Id");
            return (Criteria) this;
        }

        public Criteria andCategory3IdGreaterThanOrEqualTo(Long value) {
            addCriterion("category3_id >=", value, "category3Id");
            return (Criteria) this;
        }

        public Criteria andCategory3IdLessThan(Long value) {
            addCriterion("category3_id <", value, "category3Id");
            return (Criteria) this;
        }

        public Criteria andCategory3IdLessThanOrEqualTo(Long value) {
            addCriterion("category3_id <=", value, "category3Id");
            return (Criteria) this;
        }

        public Criteria andCategory3IdIn(List<Long> values) {
            addCriterion("category3_id in", values, "category3Id");
            return (Criteria) this;
        }

        public Criteria andCategory3IdNotIn(List<Long> values) {
            addCriterion("category3_id not in", values, "category3Id");
            return (Criteria) this;
        }

        public Criteria andCategory3IdBetween(Long value1, Long value2) {
            addCriterion("category3_id between", value1, value2, "category3Id");
            return (Criteria) this;
        }

        public Criteria andCategory3IdNotBetween(Long value1, Long value2) {
            addCriterion("category3_id not between", value1, value2, "category3Id");
            return (Criteria) this;
        }

        public Criteria andPreviewImgIsNull() {
            addCriterion("preview_img is null");
            return (Criteria) this;
        }

        public Criteria andPreviewImgIsNotNull() {
            addCriterion("preview_img is not null");
            return (Criteria) this;
        }

        public Criteria andPreviewImgEqualTo(String value) {
            addCriterion("preview_img =", value, "previewImg");
            return (Criteria) this;
        }

        public Criteria andPreviewImgNotEqualTo(String value) {
            addCriterion("preview_img <>", value, "previewImg");
            return (Criteria) this;
        }

        public Criteria andPreviewImgGreaterThan(String value) {
            addCriterion("preview_img >", value, "previewImg");
            return (Criteria) this;
        }

        public Criteria andPreviewImgGreaterThanOrEqualTo(String value) {
            addCriterion("preview_img >=", value, "previewImg");
            return (Criteria) this;
        }

        public Criteria andPreviewImgLessThan(String value) {
            addCriterion("preview_img <", value, "previewImg");
            return (Criteria) this;
        }

        public Criteria andPreviewImgLessThanOrEqualTo(String value) {
            addCriterion("preview_img <=", value, "previewImg");
            return (Criteria) this;
        }

        public Criteria andPreviewImgLike(String value) {
            addCriterion("preview_img like", value, "previewImg");
            return (Criteria) this;
        }

        public Criteria andPreviewImgNotLike(String value) {
            addCriterion("preview_img not like", value, "previewImg");
            return (Criteria) this;
        }

        public Criteria andPreviewImgIn(List<String> values) {
            addCriterion("preview_img in", values, "previewImg");
            return (Criteria) this;
        }

        public Criteria andPreviewImgNotIn(List<String> values) {
            addCriterion("preview_img not in", values, "previewImg");
            return (Criteria) this;
        }

        public Criteria andPreviewImgBetween(String value1, String value2) {
            addCriterion("preview_img between", value1, value2, "previewImg");
            return (Criteria) this;
        }

        public Criteria andPreviewImgNotBetween(String value1, String value2) {
            addCriterion("preview_img not between", value1, value2, "previewImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIsNull() {
            addCriterion("goods_img is null");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIsNotNull() {
            addCriterion("goods_img is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsImgEqualTo(String value) {
            addCriterion("goods_img =", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgNotEqualTo(String value) {
            addCriterion("goods_img <>", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgGreaterThan(String value) {
            addCriterion("goods_img >", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgGreaterThanOrEqualTo(String value) {
            addCriterion("goods_img >=", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgLessThan(String value) {
            addCriterion("goods_img <", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgLessThanOrEqualTo(String value) {
            addCriterion("goods_img <=", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgLike(String value) {
            addCriterion("goods_img like", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgNotLike(String value) {
            addCriterion("goods_img not like", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIn(List<String> values) {
            addCriterion("goods_img in", values, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgNotIn(List<String> values) {
            addCriterion("goods_img not in", values, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgBetween(String value1, String value2) {
            addCriterion("goods_img between", value1, value2, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgNotBetween(String value1, String value2) {
            addCriterion("goods_img not between", value1, value2, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andIsSpecIsNull() {
            addCriterion("is_spec is null");
            return (Criteria) this;
        }

        public Criteria andIsSpecIsNotNull() {
            addCriterion("is_spec is not null");
            return (Criteria) this;
        }

        public Criteria andIsSpecEqualTo(Byte value) {
            addCriterion("is_spec =", value, "isSpec");
            return (Criteria) this;
        }

        public Criteria andIsSpecNotEqualTo(Byte value) {
            addCriterion("is_spec <>", value, "isSpec");
            return (Criteria) this;
        }

        public Criteria andIsSpecGreaterThan(Byte value) {
            addCriterion("is_spec >", value, "isSpec");
            return (Criteria) this;
        }

        public Criteria andIsSpecGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_spec >=", value, "isSpec");
            return (Criteria) this;
        }

        public Criteria andIsSpecLessThan(Byte value) {
            addCriterion("is_spec <", value, "isSpec");
            return (Criteria) this;
        }

        public Criteria andIsSpecLessThanOrEqualTo(Byte value) {
            addCriterion("is_spec <=", value, "isSpec");
            return (Criteria) this;
        }

        public Criteria andIsSpecIn(List<Byte> values) {
            addCriterion("is_spec in", values, "isSpec");
            return (Criteria) this;
        }

        public Criteria andIsSpecNotIn(List<Byte> values) {
            addCriterion("is_spec not in", values, "isSpec");
            return (Criteria) this;
        }

        public Criteria andIsSpecBetween(Byte value1, Byte value2) {
            addCriterion("is_spec between", value1, value2, "isSpec");
            return (Criteria) this;
        }

        public Criteria andIsSpecNotBetween(Byte value1, Byte value2) {
            addCriterion("is_spec not between", value1, value2, "isSpec");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Byte value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Byte value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Byte value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Byte value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Byte value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Byte> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Byte> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Byte value1, Byte value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Byte value1, Byte value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andItemRemarkIsNull() {
            addCriterion("item_remark is null");
            return (Criteria) this;
        }

        public Criteria andItemRemarkIsNotNull() {
            addCriterion("item_remark is not null");
            return (Criteria) this;
        }

        public Criteria andItemRemarkEqualTo(String value) {
            addCriterion("item_remark =", value, "itemRemark");
            return (Criteria) this;
        }

        public Criteria andItemRemarkNotEqualTo(String value) {
            addCriterion("item_remark <>", value, "itemRemark");
            return (Criteria) this;
        }

        public Criteria andItemRemarkGreaterThan(String value) {
            addCriterion("item_remark >", value, "itemRemark");
            return (Criteria) this;
        }

        public Criteria andItemRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("item_remark >=", value, "itemRemark");
            return (Criteria) this;
        }

        public Criteria andItemRemarkLessThan(String value) {
            addCriterion("item_remark <", value, "itemRemark");
            return (Criteria) this;
        }

        public Criteria andItemRemarkLessThanOrEqualTo(String value) {
            addCriterion("item_remark <=", value, "itemRemark");
            return (Criteria) this;
        }

        public Criteria andItemRemarkLike(String value) {
            addCriterion("item_remark like", value, "itemRemark");
            return (Criteria) this;
        }

        public Criteria andItemRemarkNotLike(String value) {
            addCriterion("item_remark not like", value, "itemRemark");
            return (Criteria) this;
        }

        public Criteria andItemRemarkIn(List<String> values) {
            addCriterion("item_remark in", values, "itemRemark");
            return (Criteria) this;
        }

        public Criteria andItemRemarkNotIn(List<String> values) {
            addCriterion("item_remark not in", values, "itemRemark");
            return (Criteria) this;
        }

        public Criteria andItemRemarkBetween(String value1, String value2) {
            addCriterion("item_remark between", value1, value2, "itemRemark");
            return (Criteria) this;
        }

        public Criteria andItemRemarkNotBetween(String value1, String value2) {
            addCriterion("item_remark not between", value1, value2, "itemRemark");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
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