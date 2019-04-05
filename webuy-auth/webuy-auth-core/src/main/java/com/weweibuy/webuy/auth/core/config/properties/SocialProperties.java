package com.weweibuy.webuy.auth.core.config.properties;

import lombok.Data;

/**
 * @ClassName SocialProperties
 * @Description
 * @Author durenhao
 * @Date 2018/12/23 13:00
 **/
@Data
public class SocialProperties {

    private QQProperties  qq = new QQProperties();

    private WeiXinProperties weixin = new WeiXinProperties();

}
