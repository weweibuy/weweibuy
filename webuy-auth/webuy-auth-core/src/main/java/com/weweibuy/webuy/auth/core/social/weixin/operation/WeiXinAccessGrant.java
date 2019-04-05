package com.weweibuy.webuy.auth.core.social.weixin.operation;

import lombok.Data;
import org.springframework.social.oauth2.AccessGrant;

/**
 * 微信accessToken 数据的封装类； 主要针对openid
 * @ClassName WeiXinAccessGrant
 * @Description
 * @Author durenhao
 * @Date 2018/12/23 23:44
 **/
@Data
public class WeiXinAccessGrant extends AccessGrant {

    private String openid;

    public WeiXinAccessGrant(String accessToken, String scope, String refreshToken, Long expiresIn, String openid) {
        super(accessToken, scope, refreshToken, expiresIn);
        this.openid = openid;
    }
}
