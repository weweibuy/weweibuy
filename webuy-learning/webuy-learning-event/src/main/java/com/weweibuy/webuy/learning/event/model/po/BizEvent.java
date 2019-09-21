package com.weweibuy.webuy.learning.event.model.po;

import java.time.LocalDateTime;

public class BizEvent {
    private Long id;

    private String bizId;

    private String bizType;

    private String eventType;

    private String eventStatus;

    private String retryRule;

    private Byte retryCount;

    private String alarmRule;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId == null ? null : bizId.trim();
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType == null ? null : bizType.trim();
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType == null ? null : eventType.trim();
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus == null ? null : eventStatus.trim();
    }

    public String getRetryRule() {
        return retryRule;
    }

    public void setRetryRule(String retryRule) {
        this.retryRule = retryRule == null ? null : retryRule.trim();
    }

    public Byte getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(Byte retryCount) {
        this.retryCount = retryCount;
    }

    public String getAlarmRule() {
        return alarmRule;
    }

    public void setAlarmRule(String alarmRule) {
        this.alarmRule = alarmRule == null ? null : alarmRule.trim();
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}