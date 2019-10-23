package com.weweibuy.webuy.learning.event.model.po;

import java.time.LocalDateTime;

public class BizEventConfig {
    private Long id;

    private String eventType;

    private Byte triggerType;

    private Integer blockThreshold;

    private String retryRule;

    private String alarmRule;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType == null ? null : eventType.trim();
    }

    public Byte getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(Byte triggerType) {
        this.triggerType = triggerType;
    }

    public Integer getBlockThreshold() {
        return blockThreshold;
    }

    public void setBlockThreshold(Integer blockThreshold) {
        this.blockThreshold = blockThreshold;
    }

    public String getRetryRule() {
        return retryRule;
    }

    public void setRetryRule(String retryRule) {
        this.retryRule = retryRule == null ? null : retryRule.trim();
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