package com.weweibuy.webuy.auth.core.view;

import com.weweibuy.framework.common.core.utils.JackJsonUtils;
import org.springframework.social.connect.Connection;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理绑定视图;返回社交信息的绑定状态；请求路径为 getViewPath() + "status"
 * @ClassName ISocialConnectStatusView
 * @Description
 * @Author durenhao
 * @Date 2018/12/25 22:11
 **/
@Component("/connect/status")
public class ISocialConnectStatusView extends AbstractView {

    @Override
    protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest httpServletRequest,
                                           HttpServletResponse httpServletResponse) throws Exception {
        // connectionMap中封装这绑定信息；如果没有绑定择为空
        Map<String, List<Connection<?>>> connectionMap = (Map<String, List<Connection<?>>>) map.get("connectionMap");
        HashMap<String, Boolean> hashMap = new HashMap<>();
        for(String key : connectionMap.keySet()){
            hashMap.put(key, CollectionUtils.isEmpty(connectionMap.get(key)));
        }
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(JackJsonUtils.write(hashMap));
    }
}
