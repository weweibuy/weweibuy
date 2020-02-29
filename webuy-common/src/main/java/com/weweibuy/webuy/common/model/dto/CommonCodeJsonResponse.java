package com.weweibuy.webuy.common.model.dto;

import com.weweibuy.webuy.common.model.ResponseCodeAndMsg;
import com.weweibuy.webuy.common.model.eum.CommonResponseEum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author durenhao
 * @date 2019/5/12 22:19
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonCodeJsonResponse {

    private String code;

    private String msg;

    public CommonCodeJsonResponse(ResponseCodeAndMsg responseCodeAndMsg) {
        this.code = responseCodeAndMsg.getCode();
        this.msg = responseCodeAndMsg.getMsg();
    }

    public final static CommonCodeJsonResponse success() {
        return new CommonCodeJsonResponse(CommonResponseEum.SUCCESS);
    }

    public final static CommonCodeJsonResponse unknownException() {
        return new CommonCodeJsonResponse(CommonResponseEum.UNKNOWN_EXCEPTION);
    }

    public final static CommonCodeJsonResponse requestLimit() {
        return new CommonCodeJsonResponse(CommonResponseEum.TOO_MANY_REQUESTS);
    }

    public final static CommonCodeJsonResponse badRequestParam() {
        return new CommonCodeJsonResponse(CommonResponseEum.BAD_REQUEST_PARAM);
    }

    public final static CommonCodeJsonResponse UnSupportedMediaType() {
        return new CommonCodeJsonResponse(CommonResponseEum.UNSUPPORTED_MEDIA_TYPE);
    }

    public final static CommonCodeJsonResponse badRequestParam(String msg) {
        return new CommonCodeJsonResponse(CommonResponseEum.BAD_REQUEST_PARAM.getCode(), msg);
    }

    public final static CommonCodeJsonResponse badSystemRequestParam() {
        return new CommonCodeJsonResponse(CommonResponseEum.BAD_SYSTEM_REQUEST_PARAM);
    }

    public final static CommonCodeJsonResponse unauthorized() {
        return new CommonCodeJsonResponse(CommonResponseEum.UNAUTHORIZED);
    }

    public static CommonCodeJsonResponse forbidden() {
        return new CommonCodeJsonResponse(CommonResponseEum.FORBIDDEN);
    }

    public final static CommonCodeJsonResponse response(String code, String msg) {
        return new CommonCodeJsonResponse(code, msg);
    }

    public final static CommonCodeJsonResponse response(ResponseCodeAndMsg responseCodeAndMsg) {
        return new CommonCodeJsonResponse(responseCodeAndMsg);
    }

}
