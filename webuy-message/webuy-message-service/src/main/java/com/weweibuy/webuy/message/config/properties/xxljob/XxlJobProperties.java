package com.weweibuy.webuy.message.config.properties.xxljob;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * xxlJob的配置
 * @ClassName XxlJobProperties
 * @Description
 * @Author durenhao
 * @Date 2019/1/20 20:22
 **/
@Data
@ConfigurationProperties(prefix = "xxl.job")
public class XxlJobProperties {

    private ExecutorProperties executor = new ExecutorProperties();

    private String accessToken = null;

    private AdminProperties admin = new AdminProperties();

}
