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
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceProperties {

    private String type;

    private String driverClassName;

    private String url;

    private String username;
    private String password;
    private Integer initialSize;
    private Integer minIdle;
    private Integer maxActive;
    private Long maxWait;
    private Boolean poolPreparedStatements;
    private Integer maxPoolPreparedStatementPerConnectionSize;
    private String filters;

    private String connectionProperties;

    private String uiUsername = "admin";
    private String uipassword = "admin123";

}
