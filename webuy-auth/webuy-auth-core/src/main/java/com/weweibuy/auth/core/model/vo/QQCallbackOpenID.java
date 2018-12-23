package com.weweibuy.auth.core.model.vo;

import lombok.Data;

/**
 * @ClassName QQCallbackOpenID
 * @Description
 * @Author durenhao
 * @Date 2018/12/23 10:38
 **/
@Data
public class QQCallbackOpenID {

    /** appId */
    private String client_id;

    /** qq号 */
    private String openid;

}

