/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.weweibuy.webuy.learning.spring.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author durenhao
 * @date 2019/6/24 20:26
 **/
@Data
@EqualsAndHashCode
public class UpStreamInventoryUpdateRequestVo {

    /**
     * 明细编号 云聚回执用
     */
    private String serialno;

    /**
     * 库存信息
     */
    private String stockInfo;

    /**
     * 宝唯传递类型为1
     */
    private Integer type;
}
