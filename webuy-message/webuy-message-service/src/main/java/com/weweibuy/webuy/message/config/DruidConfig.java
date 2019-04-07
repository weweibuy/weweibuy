package com.weweibuy.webuy.message.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import io.shardingsphere.shardingjdbc.jdbc.core.datasource.ShardingDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Map;

/**
 *
 * http://localhost:9101/druid/index.html
 * @ClassName DruidConfig
 * @Description
 * @Author durenhao
 * @Date 2019/2/28 17:19
 **/
@Slf4j
@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
public class DruidConfig implements InitializingBean {

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Autowired
    private DataSource dataSource;


    @Bean
    public FilterRegistrationBean getFilterRegistrationBean() {
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new WebStatFilter());
        filter.setName("druidWebStatFilter");
        filter.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        filter.addUrlPatterns("/*");
        return filter;
    }

    @Bean
    public ServletRegistrationBean getServletRegistrationBean() {
        ServletRegistrationBean servlet = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        servlet.setName("druidStatViewServlet");
//        servlet.addInitParameter("resetEnable", "false");
        servlet.addInitParameter("loginUsername", dataSourceProperties.getUiUsername());
        servlet.addInitParameter("loginPassword", dataSourceProperties.getUiPassword());
        return servlet;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        ShardingDataSource dataSource = (ShardingDataSource) this.dataSource;
        Map<String, DataSource> dataSourceMap = dataSource.getDataSourceMap();
        for (String name : dataSourceMap.keySet()) {
            DataSource ds = dataSourceMap.get(name);
            if (ds instanceof DruidDataSource) {
                DruidDataSource druidDataSource = (DruidDataSource) ds;
                druidDataSource.setFilters(dataSourceProperties.getFilters());
                druidDataSource.setConnectionProperties(dataSourceProperties.getConnectionProperties());
            }
        }
    }
}
