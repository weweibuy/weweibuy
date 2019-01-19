package com.weweibuy.dto;

import com.weweibuy.eum.CommonStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonJsonResponse<T> implements Serializable {

    private CommonStatus status; //状态 SUCCESS

    private Integer code; //状态码

    private String msg; //信息

    private T data; //数据


}