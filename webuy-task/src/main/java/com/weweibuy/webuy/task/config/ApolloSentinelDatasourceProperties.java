/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.weweibuy.webuy.task.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author durenhao
 * @date 2019/7/30 12:07
 **/
@Data
@ConfigurationProperties(prefix = "apollo.sentinel")
public class ApolloSentinelDatasourceProperties {

    private String namespace = "sentinel";

    private String flowRuleKey = "sentinel.flow-rules";

    private String degradeRuleKey = "sentinel.degrade-rules";

    private String authorityRuleKey = "sentinel.authority-rules";

}
