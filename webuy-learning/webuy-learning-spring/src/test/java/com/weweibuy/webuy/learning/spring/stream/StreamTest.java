package com.weweibuy.webuy.learning.spring.stream;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
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


    @Test
    public void test02(){
        List<String> lists = Arrays.asList("A", "B", "C", "D");

        Spliterator<String> spliterator = lists.stream().spliterator();


        Spliterator<String> stringSpliterator = spliterator.trySplit();

        if (stringSpliterator != null) stringSpliterator.forEachRemaining(System.out::println);

        System.out.println("------------------");

        spliterator.forEachRemaining(System.out::println);
    }


    @Test
    public void test03(){
        List<Integer> collect = Stream.iterate(0, i -> i + 1)
                .limit(1001)
                .collect(Collectors.toList());
        Spliterator<Integer> spliterator = collect.stream().spliterator();
        long l = spliterator.estimateSize();
        System.err.println("拆分前zise: " + l);
        Spliterator<Integer> integerSpliterator = spliterator.trySplit();
        long l1 = spliterator.estimateSize();
        System.err.println("拆分后zise: " +l1);
        integerSpliterator.forEachRemaining(System.err::println);
        long l2 = spliterator.estimateSize();
        System.err.println("拆分+ 迭代后zise: " +l2);
        spliterator.forEachRemaining(System.err::println);


    }


}
