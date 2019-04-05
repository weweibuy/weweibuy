package com.weweibuy.webuy.auth.core.model.vo;

import lombok.Data;

/**
 * 微信使用code换取token返回值
 * @ClassName WeiXinTokenResponse
 * @Description
 * @Author durenhao
 * @Date 2018/12/23 23:34
 **/
@Data
public class WeiXinTokenResponse {

    /** 接口调用凭证 */
    private String access_token;

    /** access_token接口调用凭证超时时间，单位（秒） */
    private Long expires_in;

    /** 用户刷新access_token */
    private String refresh_token;

    /** 授权用户唯一标识 */
    private String openid;

    /** 用户授权的作用域，使用逗号（,）分隔 */
    private String scope;

    /** 当且仅当该网站应用已获得该用户的userinfo授权时，才会出现该字段。 */
    private String unionid;


}
