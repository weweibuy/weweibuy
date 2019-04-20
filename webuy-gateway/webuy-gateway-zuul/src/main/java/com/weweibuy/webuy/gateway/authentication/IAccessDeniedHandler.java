package com.weweibuy.webuy.gateway.authentication;

import com.alibaba.fastjson.JSONObject;
import com.weweibuy.webuy.common.dto.CommonJsonResponse;
import com.weweibuy.webuy.gateway.eum.ResourcesWebMsg;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 资源服务器处理AccessDeniedException(在已经认证的情况下,权限不足,拒绝访问)
 * @ClassName IAccessDeniedHandler
 * @Description
 * @Author durenhao
 * @Date 2019/1/12 20:15
 **/
@Component
public class IAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        CommonJsonResponse fail = CommonJsonResponse.fail(ResourcesWebMsg.ACCESS_IS_DENIED);
        String jsonString = JSONObject.toJSONString(fail);
        response.getWriter().write(jsonString);
    }
}
