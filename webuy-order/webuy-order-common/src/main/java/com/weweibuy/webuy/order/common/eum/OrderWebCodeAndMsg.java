package com.weweibuy.webuy.order.common.eum;

import com.weweibuy.webuy.common.response.WebCodeAndMsg;

/**
 * @ClassName OrderWebCodeAndMsg
 * @Description
 * @Author durenhao
 * @Date 2019/2/8 19:09
 **/
public enum OrderWebCodeAndMsg implements WebCodeAndMsg{

    PARAM_WRONG(40001, "输入参数错误"),
    NETWORK_EXCEPTION(40002, "网路拥堵,稍后再试"),
    ;

    private Integer code;
    private String msg;

    private OrderWebCodeAndMsg(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }


    public String getMsg() {
        return this.msg;
    }

}
