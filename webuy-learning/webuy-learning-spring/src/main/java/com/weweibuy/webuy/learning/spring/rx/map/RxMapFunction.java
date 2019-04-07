package com.weweibuy.webuy.learning.spring.rx.map;

import io.reactivex.functions.Function;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName RxMapFunction
 * @Description
 * @Author durenhao
 * @Date 2019/3/24 22:57
 **/
@Slf4j
public class RxMapFunction implements Function<Integer, String> {

    /**
     * 把 integer 输入映射成String 输出
     * @param integer
     * @return
     * @throws Exception
     */
    @Override
    public String apply(Integer integer) throws Exception {
        log.debug("映射者 收到 integer： {}", integer);
        String s = (integer + 1213) + "_String";
        log.debug("映射者 把 integer 输入 映射为String: {}", s);
        return s;
    }
}
