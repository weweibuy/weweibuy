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
        return new WebResult();
    }

    public static WebResult success(Object data){
        return new WebResult(1, "", "", data);
    }

    public static WebResult fail(){
        return new WebResult();
    }

}