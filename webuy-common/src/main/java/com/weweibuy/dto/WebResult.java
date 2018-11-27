package com.weweibuy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebResult implements Serializable {

    private Integer code; //状态码

    private String status; //状态 SUCCESS

    private String msg; //信息

    private Object data; //数据

    /**
     * TODO 状态吗没弄好
     * @return
     */
    public static WebResult paramWrong(){
        return new WebResult();
    }

    public static WebResult success(){
        return new WebResult(1, "SUCCESS", "", null);
    }

    public static WebResult success(Object data){
        return new WebResult(1, "SUCCESS", "", data);
    }

    public static WebResult success(String msg, Object data){
        return new WebResult(1, "SUCCESS", msg, data);
    }

    public static WebResult success(String msg){
        return new WebResult(1, "SUCCESS", msg, null);
    }

    public static WebResult fail(){
        return new WebResult(0, "FAIL", null, null);
    }

    public static WebResult fail(String msg){
        return new WebResult(0, "FAIL", msg, null);
    }

}