package com.weweibuy.eum;

/**
 * @ClassName CommonWebMsg
 * @Description
 * @Author durenhao
 * @Date 2018/12/1 0:07
 **/
public enum CommonWebMsg {

    SUCCESS("1","成功"),
    FAIL("0","失败,未知错误"),
    ;

    private String code;
    private String msg;

    private CommonWebMsg(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
