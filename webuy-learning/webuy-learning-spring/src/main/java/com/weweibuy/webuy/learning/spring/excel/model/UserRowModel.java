package com.weweibuy.webuy.learning.spring.excel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * @author durenhao
 * @date 2019/7/10 22:50
 **/
@Data
public class UserRowModel extends BaseRowModel {

    @ExcelProperty(index = 0, value = "姓名")
    private String userName;

    @ExcelProperty(index = 2, value = {"爱好"})
    private String like;

    @ExcelProperty(index = 1, value = "年龄")
    private Integer age;


}
