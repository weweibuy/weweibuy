package com.weweibuy.webuy.learning.spring.model;

import lombok.Data;

import java.util.Optional;
import java.util.Set;

/**
 * @author durenhao
 * @date 2019/10/13 21:20
 **/
@Data
public class BillQueryVo {

    private Optional<String> billNo = Optional.empty();
    private Optional<String> expressBillNo = Optional.empty();
    private Optional<Set<String>> billStatusList = Optional.empty();
    private Optional<String> other = Optional.empty();
    private Optional<Boolean> onlyDiff = Optional.empty();


}
