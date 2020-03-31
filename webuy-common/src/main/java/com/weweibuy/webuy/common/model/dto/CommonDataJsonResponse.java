package com.weweibuy.webuy.common.model.dto;

import com.weweibuy.webuy.common.model.ResponseCodeAndMsg;
import com.weweibuy.webuy.common.model.eum.CommonResponseEum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author durenhao
 * @date 2019/5/12 22:30
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CommonDataJsonResponse<T> extends CommonCodeJsonResponse {

    private T data;

    public CommonDataJsonResponse(ResponseCodeAndMsg codeAndMsg, T data) {
        super(codeAndMsg);
        this.data = data;
    }

    public static <T> CommonDataJsonResponse<T> success(T data) {
        return new CommonDataJsonResponse<>(CommonResponseEum.SUCCESS, data);
    }


    public static <T> CommonDataJsonResponse<T> response(ResponseCodeAndMsg codeAndMsg, T data) {
        return new CommonDataJsonResponse<>(codeAndMsg, data);
    }

}
