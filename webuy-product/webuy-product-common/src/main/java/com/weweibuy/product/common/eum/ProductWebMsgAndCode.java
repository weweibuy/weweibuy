package com.weweibuy.product.common.eum;

import com.weweibuy.common.response.WebCodeAndMsg;

/**
 * @ClassName ProductWebMsgAndCode
 * @Description
 * @Author durenhao
 * @Date 2019/2/6 20:31
 **/
public enum ProductWebMsgAndCode implements WebCodeAndMsg {

    PARAM_WRONG(30004, "输入参数错误"),
    ;

    private Integer code;
    private String msg;

    private ProductWebMsgAndCode(Integer code, String msg){
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
