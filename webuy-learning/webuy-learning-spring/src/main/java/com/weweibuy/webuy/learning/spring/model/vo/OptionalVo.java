package com.weweibuy.webuy.learning.spring.model.vo;

import lombok.Data;
import lombok.ToString;

import java.util.Optional;

/**
 * @author durenhao
 * @date 2019/8/12 21:40
 **/
@Data
@ToString
public class OptionalVo {

    private Optional<String> name = Optional.empty();

    private Optional<Integer> age = Optional.empty();


}
