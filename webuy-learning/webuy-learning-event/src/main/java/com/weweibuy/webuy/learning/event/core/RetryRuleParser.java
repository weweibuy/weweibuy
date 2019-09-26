package com.weweibuy.webuy.learning.event.core;

import com.weweibuy.webuy.common.utils.DateTimeUtils;
import com.weweibuy.webuy.learning.event.model.event.biz.BizEventVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

/**
 * @author durenhao
 * @date 2019/9/22 17:49
 **/
@Slf4j
public class RetryRuleParser {


    public boolean shouldPush(BizEventVo eventVo) {
        String retryRule = eventVo.getRetryRule();
        String[] split = retryRule.split(" ");
        Integer retryCount = eventVo.getRetryCount();
        String rule = null;
        if (split.length > retryCount) {
            rule = split[split.length];
        } else {
            rule = split[retryCount];
        }
        Long aLong = ruleToTime(rule);
        LocalDateTime updateTime = eventVo.getUpdateTime();
        return eventVo.getTimestamp() - DateTimeUtils.localDateTimeToTimestamp(updateTime) > aLong
                ? true : false;
    }

    private Long ruleToTime(String str) {
        String time = str.substring(str.length() - 1, str.length());
        String count = str.substring(0, str.length() - 1);
        Integer integer = new Integer(count);
        if (StringUtils.isNotBlank(time)) {
            switch (time) {
                case "s":
                    return integer * 1000L;
                case "m":
                    return integer * 60 * 1000L;
                case "h":
                    return integer * 60 * 60 * 1000L;
                case "d":
                    return integer * 24 * 60 * 60 * 1000L;
                default:
                    return 0L;
            }
        } else {
            return 0L;
        }

    }

}
