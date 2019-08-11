package com.weweibuy.learning.es.model.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author durenhao
 * @date 2019/8/11 10:42
 **/
@Data
public class DispatchPageQueryVo {

    private Integer page = 1;

    private Integer size = 10;

    private Optional<Date> startTime = Optional.empty();

    private Optional<Date> endTime = Optional.empty();

    private Optional<String> warehouseCode = Optional.empty();

    private Optional<String> channel = Optional.empty();

    private Optional<String> bizType = Optional.empty();

    private Optional<String> billSource = Optional.empty();

    private Optional<List<Order>> orderList = Optional.empty();

    @Data
    public static class Order {

        private String filed;

        private String value;

    }


}
