package com.weweibuy.product.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2Config {
    /**
     *swagger页面显示标记，true-显示服务列表；false-不显示服务列表
     */
    private final boolean swaggerShow = true;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(this.swaggerShow)
                .groupName("Du")
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
//                .apis(RequestHandlerSelectors.basePackage("com.sinosoft.lis.claim.controller"))
                //扫描多个包，包与包之间用逗号分开
                .apis(RequestHandlerSelectors.basePackage("com.weweibuy.product.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    //构建 api文档的详细信息函数
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("product项目 Restful Apis")
                //创建人
                .contact(new Contact("weweibuy", "", ""))
                //版本号
                .version("1.0")
                //描述
//                .description("API 描述")
                .build();
    }
}
