package com.weweibuy.webuy.learning.event.event.config;

/**
 * @author durenhao
 * @date 2019/10/26 10:30
 **/
public interface EventConfig {

    String getEventType();

    Integer getTriggerType();

    Integer getBlockThreshold();

    String getRetryRule();

    String getAlarmRule();


}
