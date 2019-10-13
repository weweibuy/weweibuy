package com.weweibuy.learning.webflux.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author durenhao
 * @date 2019/9/30 20:31
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonResponseDto<T> {

    private String code;

    private String msg;

    private T data;

    public static <T> JsonResponseDto<T> success(T data) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new JsonResponseDto("0", "成功", data);
    }

}
