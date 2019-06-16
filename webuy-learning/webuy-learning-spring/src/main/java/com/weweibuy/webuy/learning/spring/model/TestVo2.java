package com.weweibuy.webuy.learning.spring.model;

import lombok.Data;

import java.util.List;

/**
 * @author durenhao
 * @date 2019/6/14 22:33
 **/
@Data
public class TestVo2 {

    private String name;

    private Integer age;

    private String billNo;

    private List<TestDog> list;


}
