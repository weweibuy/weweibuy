package com.baidu.fsg.uid.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author durenhao
 * @date 2019/4/7 12:11
 **/
@Data
@ConfigurationProperties(prefix = "uid.default")
public class DefaultUidProperties {

    private Integer timeBits = 28;

    private Integer workerBits = 22;

    private Integer seqBits = 13;

    private String epochStr = "2016-05-20";
}
