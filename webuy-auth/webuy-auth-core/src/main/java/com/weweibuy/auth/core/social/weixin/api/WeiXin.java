package com.weweibuy.auth.core.social.weixin.api;

import com.weweibuy.auth.core.model.vo.WeiXinUserInfo;

/**
 * @ClassName WeiXin
 * @Description
 * @Author durenhao
 * @Date 2018/12/23 22:11
 **/
public interface WeiXin {

    WeiXinUserInfo getWeiXinUserInfo(String openId);
}
