package com.weweibuy.user.common.model.dto;

import com.weweibuy.eum.CommonWebStatus;
import com.weweibuy.user.common.eum.UserWebMsgEum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName UserWebResult
 * @Description
 * @Author durenhao
 * @Date 2018/12/1 9:41
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWebResult  {

    private Integer code; //状态码

    private String status; //状态 fail

    private String msg; //信息

    private Object data; //数据


    public static UserWebResult fail(){
        return new UserWebResult(UserWebMsgEum.FAIL.getCode(), CommonWebStatus.FAIL,
                UserWebMsgEum.FAIL.getMsg(), null);
    }

    public static UserWebResult fail(Object data){
        return new UserWebResult(UserWebMsgEum.FAIL.getCode(), CommonWebStatus.FAIL,
                UserWebMsgEum.FAIL.getMsg(), data);
    }

    public static UserWebResult fail(UserWebMsgEum eum){
        return new UserWebResult(eum.getCode(), CommonWebStatus.FAIL,
                eum.getMsg(), null);
    }

    public static UserWebResult fail(UserWebMsgEum eum, Object data){
        return new UserWebResult(eum.getCode(), CommonWebStatus.FAIL,
                eum.getMsg(), data);
    }

    public static UserWebResult paramWrong(){
        return new UserWebResult(UserWebMsgEum.PARAM_WRONG.getCode(), CommonWebStatus.FAIL,
                UserWebMsgEum.PARAM_WRONG.getMsg(), null);
    }

    public static UserWebResult paramBlank(){
        return new UserWebResult(UserWebMsgEum.PARAM_BLANK.getCode(), CommonWebStatus.FAIL,
                UserWebMsgEum.PARAM_BLANK.getMsg(), null);
    }

    public static UserWebResult success(){
        return new UserWebResult(UserWebMsgEum.SUCCESS.getCode(), CommonWebStatus.SUCCESS,
                UserWebMsgEum.SUCCESS.getMsg(), null);
    }

    public static UserWebResult success(Object data){
        return new UserWebResult(UserWebMsgEum.SUCCESS.getCode(), CommonWebStatus.SUCCESS,
                UserWebMsgEum.SUCCESS.getMsg(), data);
    }



}
