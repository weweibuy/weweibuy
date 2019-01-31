package com.weweibuy.dto;

import com.weweibuy.common.WebCodeAndMsg;
import com.weweibuy.eum.CommonStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonJsonResponse<T> implements Serializable {

    private String status; //状态 SUCCESS

    private Integer code; //状态码

    private String msg; //信息

    private T data; //数据

    public CommonJsonResponse(String status, Integer code, String msg){
        this.status = status;
        this.code = code;
        this.msg = msg;
    }

    public static CommonJsonResponse fail(WebCodeAndMsg webMsg){
        return new CommonJsonResponse(CommonStatus.FAIL.toString(), webMsg.getCode(), webMsg.getMsg());
    }

    public static<T> CommonJsonResponse fail(WebCodeAndMsg webMsg, T data){
        return new CommonJsonResponse<T>(CommonStatus.FAIL.toString(), webMsg.getCode(), webMsg.getMsg(), data);
    }


    public static CommonJsonResponse success(WebCodeAndMsg webMsg){
        return new CommonJsonResponse(CommonStatus.SUCCESS.toString(), webMsg.getCode(), webMsg.getMsg());
    }

    public static<T> CommonJsonResponse success(WebCodeAndMsg webMsg, T data){
        return new CommonJsonResponse<T>(CommonStatus.SUCCESS.toString(), null, null, data);
    }

}