package com.weweibuy.learning.es.rest.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author durenhao
 * @date 2020/2/8 14:13
 **/
@Data
@ConfigurationProperties(prefix = "es")
public class EsProperties {

    private String username;

    private String host;

    private String password;

    private Integer port;

}
