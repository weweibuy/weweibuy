package com.weweibuy.auth.core.social.qq.api;

import com.weweibuy.auth.core.model.vo.QQUserInfo;

/**
 * oath2中ServiceProvider 中所需要的的API
 * @ClassName QQ
 * @Description
 * @Author durenhao
 * @Date 2018/12/23 9:48
 **/
public interface QQ {

    QQUserInfo getUserInfo();

}
