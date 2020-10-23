package com.weweibuy.webuy.learning.flowable.config;

import com.weweibuy.webuy.learning.flowable.user.CustomerIdmIdentityServiceImpl;
import lombok.RequiredArgsConstructor;
import org.flowable.idm.spring.SpringIdmEngineConfiguration;
import org.flowable.spring.boot.EngineConfigurationConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author durenhao
 * @date 2020/10/23 22:27
 **/
@Configuration
@RequiredArgsConstructor
public class CustomIdmEngineConfig {

    private final SpringIdmEngineConfiguration configureEngine;


    @Bean
    public EngineConfigurationConfigurer<SpringIdmEngineConfiguration> customIdmEngineConfigurer() {
        return idmEngineConfiguration -> idmEngineConfiguration
                .setIdmIdentityService(new CustomerIdmIdentityServiceImpl(idmEngineConfiguration));
    }

}
