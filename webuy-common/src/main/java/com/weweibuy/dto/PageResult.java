package com.weweibuy.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageResult implements Serializable {

    private Long total;

    private List rows;

}
