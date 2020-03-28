package com.weweibuy.learning.es.rest.config;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author durenhao
 * @date 2020/2/8 14:12
 **/
@Configuration
@EnableConfigurationProperties({EsProperties.class})
public class ESRestClientConfig {

    private final EsProperties esProperties;

    public ESRestClientConfig(EsProperties esProperties) {
        this.esProperties = esProperties;
    }


    @Bean
    public RestHighLevelClient restHighLevelClient() {

        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                //es账号密码
                new UsernamePasswordCredentials(esProperties.getUsername(), esProperties.getPassword()));


        return new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(esProperties.getHost(), esProperties.getPort(), "http"))
                        .setHttpClientConfigCallback(httpClientBuilder -> {
                            //这里可以设置一些参数，比如cookie存储、代理等等
                            httpClientBuilder.disableAuthCaching();
                            return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
                        })
        );

    }


}
