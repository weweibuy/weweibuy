package com.weweibuy.webuy.learning.spring.model;

import lombok.Data;
import org.springframework.cglib.beans.BeanCopier;

import java.util.List;

/**
 * @author durenhao
 * @date 2019/6/14 22:31
 **/
@Data
public class TestVo1 {

    private static final BeanCopier copier = BeanCopier.create(TestVo1.class, TestVo2.class, false);

    private String name;

    private Integer age;

    private String billNo;

    private List<TestDog> list;

    public static TestVo2 convert(TestVo1 testVo1) {
        TestVo2 testVo2 = new TestVo2();
        copier.copy(testVo1, testVo2, null);
        return testVo2;
    }

}
