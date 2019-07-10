package com.weweibuy.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName StreamTest
 * @Description
 * @Author durenhao
 * @Date 2019/4/1 21:45
 **/
public class StreamTest {

    private ArrayList<Student> students;

    @Before
    public void init() {
        Random random = new Random();
        students = new ArrayList<Student>() {
            {
                for (int i = 0; i < 100; i++) {
                    if (i < 50) {
                        add(new Student("1", "student" + i, random.nextInt(50) + 50));
                    }
                    add(new Student("2", "student" + i, random.nextInt(50) + 50));
                }
            }
        };
    }

    @Test
    public void test() {
        List<Student> collect = students.stream().filter(student -> student.getScore() > 85)
//                .sorted((s0, s1) -> s0.getScore() - s1.getScore())
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .collect(Collectors.toList());
        collect.forEach(student -> System.err.println(student));
    }

    @Test
    public void test2() {
        String[] arr = new String[]{"yes", "YES", "no", "NO"};
        Arrays.stream(arr).map(str -> str.toLowerCase()).forEach(System.err::println);
    }

    @Test
    public void test3() {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.stream(arr).filter(x -> x > 3 && x < 7).forEach(System.err::println);
    }

    @Test
    public void test4() {
        String[] arr1 = {"a", "b", "c", "d"};
        String[] arr2 = {"e", "f", "c", "d"};
        String[] arr3 = {"h", "j", "c", "d"};
        List<String> collect = Stream.of(arr1, arr2, arr3).flatMap(Arrays::stream)
                .collect(Collectors.toList());
        collect.forEach(System.err::println);
    }

    @Test
    public void test5() {
        String[] arr1 = {"a", "b", "c", "d"};
        String[] arr2 = {"e", "c", "c", "d"};
        Stream<String> stream = Arrays.stream(arr1);
        Stream<String> stream1 = Arrays.stream(arr2);
        List<String> collect = Stream.concat(stream, stream1).limit(7)
                .map(str -> str.toUpperCase())
                .distinct()
                .collect(Collectors.toList());
        collect.forEach(System.err::println);
    }

    @Test
    public void test6() {
        String[] arr = new String[]{"b", "ab", "abc", "abcd", "abcde"};
        Arrays.stream(arr).max((str1, str2) -> str1.length() - str2.length())
                .ifPresent(System.out::println);
        Arrays.stream(arr).max(Comparator.comparing(String::length).reversed())
                .ifPresent(System.out::println);
    }

    @Test
    public void test7() {

        long count = this.students.stream().count();
        System.err.println(count);
    }

    @Test
    public void test8() {
        students.stream().filter(student -> student.getScore() > 110)
                .findFirst().ifPresent(System.out::println);
        Student student1 = students.stream().filter(student -> student.getScore() > 90)
                .findFirst().orElse(new Student());
        System.err.println(student1);
    }

    @Test
    public void test9() {
        students.stream().filter(student -> student.getScore() > 90)
                .findAny().ifPresent(System.out::println);
    }

    @Test
    public void test10() {
        boolean b = students.stream().filter(student -> student.getScore() > 90)
                .anyMatch(student -> student.getScore() == 100);
        System.err.println(b);
    }

    @Test
    public void test11() {
        Optional<Integer> optional = Stream.of(1, 2, 3).filter(x -> x > 1).reduce((x, y) -> x + y);
        System.out.println(optional.get());
    }

    @Test
    public void test12() {
        students.stream().collect(Collectors.toMap(Student::getName, Student::getScore))
                .forEach((key, value) -> System.err.println(key + "+" + value));
    }

    @Test
    public void test13() {
        students.stream().sorted(Comparator.comparing(Student::getName).reversed())
                .collect(Collectors.toCollection(HashSet::new))
                .forEach(System.err::println);
    }


    @Test
    public void test14() {
        double average = students.stream().collect(Collectors.summarizingInt(Student::getScore))
                .getAverage();
        System.err.println(average);
    }

    @Test
    public void test15() {
        Map<String, List<Student>> collect = students.stream().collect(Collectors.groupingBy(Student::getType));
        collect.forEach((key, value) -> {
            System.err.println(key);
            value.stream().forEach(System.err::println);
        });

        Map<String, List<Student>> collect2 = students.stream().collect(Collectors.groupingBy(Student::getType));
        collect2.forEach((key, value) -> {
            System.err.println(key);
            double average = value.stream().collect(Collectors.summarizingInt(Student::getScore)).getAverage();
            System.err.println(average);
        });

    }

    @Test
    public void test16() {
        System.err.println("four".length());
        List<String> collect = Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
        collect.forEach(System.err::println);
    }


    @Test
    public void test17() {
        // 迭代器
        Stream.iterate(0, n -> n + 2)
                .limit(100)
                .forEach(i -> {
                    System.err.println(i);
                });

    }


    @Test
    public void learnStream() {
        List<Integer> lists = new ArrayList<>();
        lists.add(1);
        lists.add(2);
        lists.add(3);
        lists.add(4);
        lists.add(5);
        lists.add(6);
        Optional<Integer> sum = lists.parallelStream().reduce((a, b) -> a + b);//这里把stream()换成了parallelStream（）
        if (sum.isPresent()) System.out.println("list的总和为:" + sum.get());//21
        //<====> lists.stream().reduce((a, b) -> a + b).ifPresent(System.out::println);

        Integer sum2 = lists.stream().reduce(0, (a, b) -> a + b);//21
        System.out.println("list的总和为:" + sum2);

    }

}
