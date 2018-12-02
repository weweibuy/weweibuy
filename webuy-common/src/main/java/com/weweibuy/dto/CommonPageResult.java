package com.weweibuy.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CommonPageResult implements Serializable {

    private Long total;

    private List rows;

}
