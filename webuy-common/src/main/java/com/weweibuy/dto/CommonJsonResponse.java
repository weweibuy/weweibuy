package com.weweibuy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonJsonResponse<T> implements Serializable {

    private String status; //状态 SUCCESS

    private Integer code; //状态码

    private String msg; //信息

    private T data; //数据


}