/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.weweibuy.webuy.learning.spring.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author durenhao
 * @date 2019/9/1 19:10
 **/
@Data
@EqualsAndHashCode
@ToString(callSuper = true)
public class VoUser extends PoUser {

    private String name;

}
