package com.weweibuy.eum;

import com.weweibuy.common.WebCodeAndMsg;

/**
 * @ClassName CommonWebMsg
 * @Description
 * @Author durenhao
 * @Date 2018/12/1 0:07
 **/
public enum CommonWebMsg implements WebCodeAndMsg {

    SUCCESS(1,"成功"),
    FAIL(0,"失败,未知错误"),
    ;

    private Integer code;
    private String msg;

    private CommonWebMsg(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public WebCodeAndMsg appendMsg(String msg){
        this.msg = this.msg + ";" + msg;
        return this;
    }

}
