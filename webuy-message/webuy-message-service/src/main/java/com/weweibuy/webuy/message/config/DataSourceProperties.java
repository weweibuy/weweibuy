package com.weweibuy.webuy.message.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName DataSourceProperties
 * @Description
 * @Author durenhao
 * @Date 2019/2/28 18:45
 **/
@Data
@ConfigurationProperties(prefix = "druid.datasource")
public class DataSourceProperties {

    private String filters;

    private String connectionProperties;

    private String uiUsername = "admin";

    private String uiPassword = "admin123";

}
