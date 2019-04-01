package com.weweibuy.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName Student
 * @Description
 * @Author durenhao
 * @Date 2019/4/1 21:46
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    private String type;
    private String name;
    private Integer score;
}
