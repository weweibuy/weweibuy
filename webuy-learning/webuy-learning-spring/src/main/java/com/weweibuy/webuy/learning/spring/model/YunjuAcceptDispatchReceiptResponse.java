/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.weweibuy.webuy.learning.spring.model;

import lombok.Data;

/**
 * @author durenhao
 * @date 2019/6/24 20:26
 **/
@Data
public class YunjuAcceptDispatchReceiptResponse {
    /**
     * 0成功，1其他错误
     */
    private Integer error = 0;
    /**
     * 信息描述
     */
    private String errorInfo = "成功";

}
