package com.weweibuy.webuy.common.exception;

import com.weweibuy.webuy.common.model.ResponseCodeAndMsg;
import com.weweibuy.webuy.common.model.eum.CommonResponseEum;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author durenhao
 * @date 2020/2/29 20:31
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Exceptions {

    public static BusinessException business(ResponseCodeAndMsg responseCodeAndMsg) {
        return new BusinessException(responseCodeAndMsg);
    }

    public static BusinessException badRequestParam() {
        return new BusinessException(CommonResponseEum.BAD_REQUEST_PARAM);
    }

    public static BusinessException business(String code, String msg) {
        return new BusinessException(new ResponseCodeAndMsg() {
            @Override
            public String getCode() {
                return code;
            }

            @Override
            public String getMsg() {
                return msg;
            }
        });
    }

    public static SystemException system(ResponseCodeAndMsg responseCodeAndMsg) {
        return new SystemException(responseCodeAndMsg);
    }

    public static SystemException system(String code, String msg) {
        return new SystemException(new ResponseCodeAndMsg() {
            @Override
            public String getCode() {
                return code;
            }

            @Override
            public String getMsg() {
                return msg;
            }
        });
    }

    public static SystemException unknown() {
        return new SystemException(CommonResponseEum.UNKNOWN_EXCEPTION);
    }


}
