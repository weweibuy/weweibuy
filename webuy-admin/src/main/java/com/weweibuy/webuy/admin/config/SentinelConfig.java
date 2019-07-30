/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.weweibuy.webuy.admin.config;

import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.datasource.apollo.ApolloDataSource;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityRule;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityRuleManager;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author durenhao
 * @date 2019/7/30 12:02
 **/
@Configuration
@EnableConfigurationProperties(ApolloSentinelDatasourceProperties.class)
public class SentinelConfig {

    @Autowired
    private ApolloSentinelDatasourceProperties datasourceProperties;

    @Autowired
    private Environment environment;

    @PostConstruct
    public void init() {
        // Set up basic information, only for demo purpose. You may adjust them based on your actual environment.
        // For more information, please refer https://github.com/ctripcorp/apollo
        String appId = environment.getProperty("spring.application.name");
        String apolloMetaServerAddress = environment.getProperty("apollo.meta");

        System.setProperty("app.id", appId);
        System.setProperty("apollo.meta", apolloMetaServerAddress);

        String namespaceName = datasourceProperties.getNamespace();
        String flowRuleKey = datasourceProperties.getFlowRuleKey();
        String degradeRuleKey = datasourceProperties.getDegradeRuleKey();
        String authorityRuleKey = datasourceProperties.getAuthorityRuleKey();


        // It's better to provide a meaningful default value.
        String defaultFlowRules = "[]";
        String defaultDegradeRule = "[]";
        String defaultAuthorityRule = "[]";

        ReadableDataSource<String, List<FlowRule>> flowRuleDataSource = new ApolloDataSource<>(namespaceName,
                flowRuleKey, defaultFlowRules, source -> JSON.parseObject(source, new TypeReference<List<FlowRule>>() {
        }));

        ReadableDataSource<String, List<DegradeRule>> degradeRuleDataSource = new ApolloDataSource<>(namespaceName,
                degradeRuleKey, defaultDegradeRule, source -> JSON.parseObject(source, new TypeReference<List<DegradeRule>>() {
        }));

        ReadableDataSource<String, List<AuthorityRule>> authorityRuleDataSource = new ApolloDataSource<>(namespaceName,
                authorityRuleKey, defaultAuthorityRule, source -> JSON.parseObject(source, new TypeReference<List<AuthorityRule>>() {
        }));

        FlowRuleManager.register2Property(flowRuleDataSource.getProperty());
        DegradeRuleManager.register2Property(degradeRuleDataSource.getProperty());
        AuthorityRuleManager.register2Property(authorityRuleDataSource.getProperty());
    }
}
