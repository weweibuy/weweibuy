package com.weweibuy.webuy.backstage.pojo;

import lombok.Data;

/**
 * @ClassName Person
 * @Description: TODO
 * @Author durenhao  ak514250@126.com
 * @Date 2018/10/1 10:46
 */
@Data
public class Person {

    private String name;

    private Integer age;



    public void init ()  {
        this.name = "tom";
        this.age = 12;
    }

}
