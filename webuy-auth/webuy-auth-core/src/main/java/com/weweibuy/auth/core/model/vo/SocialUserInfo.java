package com.weweibuy.auth.core.model.vo;

import lombok.Data;

/**
 * 社交用户信息
 * @ClassName SocialUserInfo
 * @Description
 * @Author durenhao
 * @Date 2018/12/23 21:12
 **/
@Data
public class SocialUserInfo {

    private String providerId;

    private String providerUserId;

    private String nickname;

    private String headimg;
}
