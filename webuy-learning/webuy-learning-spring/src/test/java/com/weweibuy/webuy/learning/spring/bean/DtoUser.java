/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.weweibuy.webuy.learning.spring.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

/**
 * @author durenhao
 * @date 2019/9/1 19:11
 **/
@Data
@EqualsAndHashCode
public class DtoUser {

    private static final BeanCopier BEAN_COPIER = BeanCopier.create(PoUser.class, DtoUser.class, false);

    private String name;

    private Integer age;

    public static DtoUser fromPo(PoUser poUser) {
        DtoUser dtoUser = new DtoUser();
        BEAN_COPIER.copy(poUser, dtoUser, null);
        return dtoUser;
    }

    public static DtoUser fromPoBeanUtil(PoUser poUser) {
        DtoUser dtoUser = new DtoUser();
        BeanUtils.copyProperties(poUser, dtoUser);
        return dtoUser;
    }

    public class MyConverter implements Converter{

        @Override
        public Object convert(Object o, Class aClass, Object o1) {
            return null;
        }
    }

}
