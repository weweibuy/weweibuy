package com.weweibuy.webuy.learning.event.event.config;

/**
 * @author durenhao
 * @date 2019/10/26 10:32
 **/
public enum  EventTypeEum implements EventConfig{
    TEST_EVENT("TEST_EVENT_TYPE", 0, -1, "1s 5s 10s end", "1s 5s 10s ..."),

    ;
    private String eventType;
    private Integer triggerType;
    private Integer blockThreshold;
    private String retryRule;
    private String alarmRule;

    EventTypeEum(String eventType, Integer triggerType, Integer blockThreshold, String retryRule, String alarmRule) {
        this.eventType = eventType;
        this.triggerType = triggerType;
        this.blockThreshold = blockThreshold;
        this.retryRule = retryRule;
        this.alarmRule = alarmRule;
    }

    public String getEventType() {
        return eventType;
    }

    public Integer getTriggerType() {
        return triggerType;
    }

    public Integer getBlockThreshold() {
        return blockThreshold;
    }

    public String getRetryRule() {
        return retryRule;
    }

    public String getAlarmRule() {
        return alarmRule;
    }
}
