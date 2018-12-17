package com.weweibuy.auth.core.config;

import com.weweibuy.auth.core.validate.code.SmsValidateCodeSender;
import com.weweibuy.auth.core.validate.code.impl.DefaultSmsValidateCodeSender;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName BeanConfig
 * @Description
 * @Author durenhao
 * @Date 2018/12/16 13:25
 **/
@Configuration
public class BeanConfig {


    @Bean
    @ConditionalOnBean(SmsValidateCodeSender.class)
    public SmsValidateCodeSender smsValidateCodeSender(){
        return new DefaultSmsValidateCodeSender();
    }


}
