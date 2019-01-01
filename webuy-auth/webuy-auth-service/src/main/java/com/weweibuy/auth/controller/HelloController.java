package com.weweibuy.auth.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName HelloController
 * @Description
 * @Author durenhao
 * @Date 2018/12/15 10:53
 **/
@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "authHello...";
    }

    @GetMapping("/helloRedirect")
    public String helloRedirect(){
        return "redirect:localhost/auth/hello";
    }

    @GetMapping("/helloauth")
    @ResponseBody
    public String helloAuth(){
        return "helloauth";
    }



    /**
     * 解析jwt测试
     * @param user
     * @param request
     * @return
     */
    @GetMapping("/hellojwt")
    public String helloJwt(Authentication user, HttpServletRequest request){
        String authorization = request.getHeader("Authorization");
        String bearer = StringUtils.substringAfter(authorization, "bearer");
        // 验证签名， 解析扩展字段
        Claims webuy = Jwts.parser().setSigningKey("webuy").parseClaimsJws(bearer).getBody();
        Object name = webuy.get("name");

        return "";

    }

}
