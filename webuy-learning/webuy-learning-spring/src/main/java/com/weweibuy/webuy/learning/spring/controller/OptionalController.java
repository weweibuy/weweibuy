package com.weweibuy.webuy.learning.spring.controller;

import com.weweibuy.webuy.learning.spring.model.BillQueryVo;
import com.weweibuy.webuy.learning.spring.model.vo.OptionalVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashSet;

/**
 * @author durenhao
 * @date 2019/8/12 21:37
 **/
@Slf4j
@RestController
@RequestMapping("/optional")
public class OptionalController {

    @GetMapping("/get")
    public Object getOpt(OptionalVo optionalVo) {
        log.info("opt: {}", optionalVo);
        return optionalVo;
    }


    @PostMapping
    public Object optionRequest(@RequestBody BillQueryVo vo) {
        HashSet<String> allowStatus = new HashSet<>();
        allowStatus.add("40");
        allowStatus.add("100");


        boolean present = vo.getExpressBillNo().isPresent();

        vo.getExpressBillNo().filter(StringUtils::isNotBlank)
                .filter(i -> {
                    return vo.getBillStatusList().filter(CollectionUtils::isNotEmpty)
                            .map(sl -> {
                               return allowStatus.stream().anyMatch(sl::contains);
                            }).orElse(true);
                })
                .map(i -> {
                    log.info("用快递单号查询回执明细");
                    int i1 = RandomUtils.nextInt( 10);
                    if (i1 % 2 == 0) {
                        return Collections.singletonList("1213");
                    }
                    return Collections.<String>emptyList();
                })
                .filter(CollectionUtils::isNotEmpty)
                .flatMap(i -> {
                    return vo.getExpressBillNo();
                });



        return null;
    }


}
