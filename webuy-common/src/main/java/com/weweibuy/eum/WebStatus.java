package com.weweibuy.eum;

/**
 * web响应结果枚举
 * @ClassName WebStatus
 * @Description
 * @Author durenhao
 * @Date 2018/10/14 16:36
 **/
public enum WebStatus {

    SUCCESS(0),

    FAIL(1);

    private WebStatus(int code){}

    private int code;

    public int getCode(){
        return this.code;
    }


}
