package com.weweibuy.auth.core.view;

import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * TODO 如何让逻辑视图返回真实的视图；(到自定义成功页面)
 * 处理社交绑定post请求和解绑delete请求(没有connection); 请求路径为：getViewPath() + providerId + "Connected"
 * @ClassName WeiXinConnectionBindView
 * @Description
 * @Author durenhao
 * @Date 2018/12/25 22:23
 **/
public class WeiXinConnectionBindView extends AbstractView {

    /**
     * 当model中没有connection时是解绑请求
     * @param map
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws Exception
     */
    @Override
    protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest httpServletRequest,
                                           HttpServletResponse httpServletResponse) throws Exception {
        if(map.get("connection") != null){
            httpServletResponse.getWriter().write("<h2>微信绑定成功</h2>");
        }else {
            httpServletResponse.getWriter().write("<h2>微信解绑成功</h2>");
        }
    }

}
