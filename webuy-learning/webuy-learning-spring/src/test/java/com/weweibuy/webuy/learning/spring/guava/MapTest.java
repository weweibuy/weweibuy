package com.weweibuy.webuy.learning.spring.guava;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Ordering;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Map;

/**
 * @author durenhao
 * @date 2019/8/10 21:19
 **/
@Slf4j
public class MapTest {

    /**
     * 不可更改map
     */
    @Test
    public void test01() {
        Map<String, Integer> salary = ImmutableMap.<String, Integer>builder()
                .put("John", 1000)
                .put("Jane", 1500)
                .put("Adam", 2000)
                .put("Tom", 2000)
                .build();
//        salary.put("luck", 10);
    }


    /**
     * 有序map;
     */
    @Test
    public void whenUsingSortedMap_thenKeysAreSorted() {
        ImmutableSortedMap<String, Integer> salary = new ImmutableSortedMap
                .Builder<String, Integer>(Ordering.from((x, y) -> {
            return x.hashCode() - y.hashCode();
        }))
                .put("John", 1000)
                .put("Jane", 1500)
                .put("Adam", 2000)
                .put("Tom", 2000)
                .build();
    }

}
