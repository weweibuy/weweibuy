package com.weweibuy.webuy.message.config;

import com.weweibuy.webuy.message.config.properties.xxljob.XxlJobProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName BeanConfig
 * @Description
 * @Author durenhao
 * @Date 2019/1/20 20:37
 **/
@Configuration
@EnableConfigurationProperties(XxlJobProperties.class)
public class BeanConfig {
}
