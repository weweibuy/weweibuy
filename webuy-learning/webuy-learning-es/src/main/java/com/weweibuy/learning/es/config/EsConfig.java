package com.weweibuy.learning.es.config;

import org.elasticsearch.client.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchConverter;

/**
 * @author durenhao
 * @date 2019/8/4 11:15
 **/
@Configuration
public class EsConfig {


    @Bean
    public ElasticsearchTemplate elasticsearchTemplate(Client client,
                                                       ElasticsearchConverter converter) {
        try {
            return new ElasticsearchTemplate(client, converter, new SnackCaseEsEntityMapper());
        }
        catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }

}
