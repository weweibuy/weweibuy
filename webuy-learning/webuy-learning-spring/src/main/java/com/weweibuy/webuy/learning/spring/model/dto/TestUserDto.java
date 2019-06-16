package com.weweibuy.webuy.learning.spring.model.dto;

import com.weweibuy.webuy.learning.spring.model.po.TestDog;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author durenhao
 * @date 2019/6/14 23:09
 **/
@Data
@AllArgsConstructor
public class TestUserDto {

    private String name;

    private String age;

    private List<TestDog> dogList;

}
