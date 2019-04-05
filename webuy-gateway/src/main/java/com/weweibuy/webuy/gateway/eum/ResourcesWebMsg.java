package com.weweibuy.webuy.gateway.eum;

import com.weweibuy.common.response.WebCodeAndMsg;

/**
 * 资源服务器 web返回 code 和msg
 * @ClassName ResourcesWebMsg
 * @Description
 * @Author durenhao
 * @Date 2019/1/26 12:36
 **/
public enum  ResourcesWebMsg implements WebCodeAndMsg{

    UNKNOWN_WRONG(20000, "未知错误"),
    ACCESS_IS_DENIED(20001, "权限不足"),
    NEED_LOGIN(20002, "需要登录"),
    TOKEN_INVALID(20003, "token过期"),
    NET_WORK_BUSY(20004, "网络繁忙"),
    ;

    private Integer code;
    private String msg;

    private ResourcesWebMsg(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

}
