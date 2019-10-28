/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.weweibuy.webuy.learning.spring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author durenhao
 * @date 2019/9/1 22:30
 **/
@Data
@AllArgsConstructor
@ToString
public class PageResult<T> {


    private Integer total;

    private List<T> list;

}
