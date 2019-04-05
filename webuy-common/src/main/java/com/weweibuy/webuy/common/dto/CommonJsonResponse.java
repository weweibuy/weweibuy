package com.weweibuy.webuy.common.dto;

import com.weweibuy.webuy.common.eum.CommonStatus;
import com.weweibuy.webuy.common.response.WebCodeAndMsg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "json响应信息载体")
public class CommonJsonResponse<T> implements Serializable {

    @ApiModelProperty(value = "状态 SUCCESS 成功 FAIL 失败")
    private String status; //状态 SUCCESS

    @ApiModelProperty(value = "code码")
    private Integer code; //状态码

    @ApiModelProperty(value = "信息")
    private String msg; //信息

    @ApiModelProperty(value = "数据")
    private T data; //数据

    public CommonJsonResponse<T> appendMsg(String msg){
        this.msg = this.msg + ";" + msg;
        return this;
    }

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

    public static CommonJsonResponse success(){
        return new CommonJsonResponse(CommonStatus.SUCCESS.toString(), null, null, null);
    }

    public static<T> CommonJsonResponse success(T data){
        return new CommonJsonResponse<T>(CommonStatus.SUCCESS.toString(), null, null, data);
    }

}