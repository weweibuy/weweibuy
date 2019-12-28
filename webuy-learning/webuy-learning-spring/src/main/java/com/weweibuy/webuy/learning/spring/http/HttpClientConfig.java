package com.weweibuy.webuy.learning.spring.http;

import feign.Client;
import feign.httpclient.ApacheHttpClient;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultServiceUnavailableRetryStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.StandardHttpRequestRetryHandler;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;
import java.util.concurrent.TimeUnit;

/**
 * @author durenhao
 * @date 2019/12/28 11:07
 **/
@Configuration
public class HttpClientConfig {


    @Bean
    public CloseableHttpClient httpClient() throws Exception {
        TrustStrategy acceptingTrustStrategy = new TrustAllStrategy();

        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                .loadTrustMaterial(null, acceptingTrustStrategy)
                .build();

        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
        return HttpClients.custom()
                .setSSLSocketFactory(csf)
                .setConnectionManager(httpClientConnectionManager())
                .setRetryHandler(new StandardHttpRequestRetryHandler())
                .setServiceUnavailableRetryStrategy(new DefaultServiceUnavailableRetryStrategy())
                .setDefaultRequestConfig(requestConfig())
                .build();
    }

    public RequestConfig requestConfig() {
        return RequestConfig.custom().setConnectTimeout(100)
                .setConnectionRequestTimeout(100)
                .setSocketTimeout(200)
                .build();
    }

    public HttpClientConnectionManager httpClientConnectionManager() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(900L, TimeUnit.SECONDS);
        connectionManager.setMaxTotal(300);
        connectionManager.setDefaultMaxPerRoute(50);
        return connectionManager;
    }


//    @Bean
    public Client feignClient(HttpClient httpClient) {
        return new ApacheHttpClient(httpClient);
    }


}
