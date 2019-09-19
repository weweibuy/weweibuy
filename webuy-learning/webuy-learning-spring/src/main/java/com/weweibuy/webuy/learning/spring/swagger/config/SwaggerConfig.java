package com.weweibuy.webuy.learning.spring.swagger.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author durenhao
 * @date 2019/9/19 21:13
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * swagger页面显示标记，true-显示服务列表；false-不显示服务列表
     */
    private final boolean swaggerShow = true;

    @Bean
    public Docket createRestApi() {


        ParameterBuilder parameterBuilder = new ParameterBuilder();
        List<Parameter> parameters = Lists.newArrayList();
        parameterBuilder.name("Authorization").description("token令牌").modelRef(new ModelRef("String"))
                .parameterType("header")
                .required(true).build();
        parameters.add(parameterBuilder.build());

        List<ResponseMessage> responseMessageList = new ArrayList<>();
        responseMessageList.add(new ResponseMessageBuilder().code(400).message("业务处理异常").responseModel(new ModelRef("ApiError")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(403).message("没有权限").responseModel(new ModelRef("ApiError")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(500).message("未知异常").responseModel(new ModelRef("ApiError")).build());

        return new Docket(DocumentationType.SWAGGER_2)
                .globalResponseMessage(RequestMethod.GET, responseMessageList)
                .globalResponseMessage(RequestMethod.POST, responseMessageList)
                .globalResponseMessage(RequestMethod.PUT, responseMessageList)
                .globalResponseMessage(RequestMethod.DELETE, responseMessageList)
                .enable(this.swaggerShow)
                .globalOperationParameters(parameters)
                .groupName("Du")
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                //扫描多个包，包与包之间用逗号分开
                .apis(RequestHandlerSelectors.basePackage("com.weweibuy.webuy.learning.spring.swagger"))
                .paths(PathSelectors.any())
                .build();
    }

    //构建 api文档的详细信息函数
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("webuy-learning 项目 Restful Apis")
                //创建人
                .contact(new Contact("learning", "", ""))
                //版本号
                .version("1.0")
                //描述
//                .description("API 描述")
                .build();
    }


}
