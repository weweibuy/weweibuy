package com.weweibuy.webuy.learning.spring.desensitization.logds;

import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * @author durenhao
 * @date 2019/9/13 16:42
 **/
public class LogMessageConverter extends MessageConverter {

    @Override
    public String convert(ILoggingEvent event){

        // 获取原始日志
        String requestLogMsg = event.getFormattedMessage();
        if(requestLogMsg.indexOf("password") != -1){
            return "密码脱敏后的值";
        }

        // 获取返回脱敏后的日志
        return requestLogMsg;
    }

}
