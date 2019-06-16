package com.weweibuy.webuy.learning.sharing.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author durenhao
 * @date 2019/6/16 18:28
 **/
@Data
public class PageQueryVo {

    private Integer page;

    private Integer size;

    private Date startTime;

    private Date endTime;

}
