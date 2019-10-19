package com.weweibuy.webuy.learning.spring.controller;

import com.weweibuy.webuy.common.eum.CommonWebMsg;
import com.weweibuy.webuy.learning.spring.config.properties.CodeMappingProperties;
import com.weweibuy.webuy.learning.spring.model.TestListVo;
import com.weweibuy.webuy.learning.spring.model.TestUser;
import com.weweibuy.webuy.learning.spring.model.eum.SystemEum;
import com.weweibuy.webuy.learning.spring.service.TestUserService;
import com.weweibuy.webuy.learning.spring.service.TypeInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Map;
import java.util.Set;

/**
 * @author durenhao
 * @date 2019/4/7 0:10
 **/
@Slf4j
@RestController("hello")
@RequestMapping("/api/v1")
public class Hello implements TypeInterface {

    @Autowired
    private CodeMappingProperties codeMappingProperties;

    @Autowired
    private TestUserService userService;

    @RequestMapping("/hello")
    public String hello(HttpServletResponse response) {
        Cookie cookie = new Cookie("test_gateway_cookie", "test_gateway_cookie_value");
        response.addCookie(cookie);
        response.addHeader("test_gateway_header", "test_gateway_header_value");
        return "hello.. i am learn spring...";
    }

    @RequestMapping("/test/hello")
    public String hello2() {
        return "test hello.. i am learn spring...2";
    }

    @PostMapping("/test/hello3")
    public TestListVo hello3(@RequestBody @Validated TestListVo listVo, BindingResult bindingResult, HttpServletRequest request) {
        log.info("biz ..... running ");
        validate(listVo);
        return listVo;
    }

    @PostMapping("/test/hello4")
    @Cacheable(key = "'1213'")
    public TestUser hello4(@RequestBody @Validated TestUser listVo) {
        return listVo;
    }


    @RequestMapping("/test/hello5")
    public String hello5(String code) {
//        Map<SystemEum, CodeMappingProperties.CodeMapping> codeMapping = codeMappingProperties.getCodeMapping();
//        CodeMappingProperties.CodeMapping codeMapping1 = codeMapping.get(SystemEum.TEST_A);
//        CodeMappingProperties.OtherCodeAndMsg otherCodeAndMsg = codeMapping1.getOtherCodeAndMsg().get(code);
//        return otherCodeAndMsg.getMsg();

        Map<SystemEum, Map<String, CommonWebMsg>> codeMapping = codeMappingProperties.getCodeMapping();

        Map<String, CommonWebMsg> msgMap = codeMapping.get(SystemEum.TEST_A);
        CommonWebMsg commonWebMsg = msgMap.get(code);
        return commonWebMsg.getMsg();
    }

    @RequestMapping("/test/hello6")
    public ResponseEntity hello56() {
        return ResponseEntity.ok(userService.getUsers());
    }


    public void validate(@Validated @RequestBody TestListVo listVo) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<TestListVo>> validate = validator.validate(listVo);
        for (ConstraintViolation<TestListVo> violation : validate) {
            System.out.println(violation.getMessage());
        }

    }

}
