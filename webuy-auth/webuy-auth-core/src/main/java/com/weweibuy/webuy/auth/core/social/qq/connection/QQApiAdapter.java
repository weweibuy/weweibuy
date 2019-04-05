package com.weweibuy.webuy.auth.core.social.qq.connection;

import com.weweibuy.webuy.auth.core.model.vo.QQUserInfo;
import com.weweibuy.webuy.auth.core.social.qq.api.QQ;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * ConnectFactory 与API的适配
 * @ClassName QQApiAdapter
 * @Description
 * @Author durenhao
 * @Date 2018/12/23 11:31
 **/
public class QQApiAdapter implements ApiAdapter<QQ> {

    /**
     * 测试服务商服务是否用于
     * @param qq
     * @return
     */
    @Override
    public boolean test(QQ qq) {
        return true;
    }

    /**
     * 设置连接信息
     * @param qq
     * @param connectionValues
     */
    @Override
    public void setConnectionValues(QQ qq, ConnectionValues connectionValues) {
        QQUserInfo userInfo = qq.getUserInfo();
        connectionValues.setDisplayName(userInfo.getNickname());
        connectionValues.setImageUrl(userInfo.getFigureurl_qq_1());
        // 设置openid
        connectionValues.setProviderUserId(userInfo.getOpenId());
        // 设置个人主页
        connectionValues.setProfileUrl(null);
    }

    @Override
    public UserProfile fetchUserProfile(QQ qq) {
        return null;
    }

    /**
     * 与个人主页有关，在这不用
     * @param qq
     * @param s
     */
    @Override
    public void updateStatus(QQ qq, String s) {

    }
}
