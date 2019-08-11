package com.weweibuy.webuy.learning.spring.stream;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author durenhao
 * @date 2019/8/10 8:49
 **/
@Slf4j
public class StreamTest {


    @Test
    public void test01() {
        List<String> list = new ArrayList<>();
        String collect = Stream.of("a", "b", "c").collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.joining(",")));

        String collect1 = Stream.of("a", "b", "c").collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.joining(",")));

        Stream.iterate(0, n ->  n + 1)
                .limit(10)
                .forEach(i -> {
                    ArrayList<Integer> list2 = new ArrayList(){{
                        add(i + 1);
                        add(i + 2);
                        add(i + 3);
                        add(i + 4);
                    }};
                    list2.stream().collect(Collectors.mapping(x -> x + "", Collectors.toList()));
                });



    }


}
