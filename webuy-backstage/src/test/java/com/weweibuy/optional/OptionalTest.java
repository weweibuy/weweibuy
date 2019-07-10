package com.weweibuy.optional;

import com.weweibuy.stream.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author durenhao
 * @date 2019/6/28 22:40
 **/
@Slf4j
public class OptionalTest {


    @Test
    public void test01() {
        Optional<Student> optional = Optional.<Student>ofNullable(null);
        Student student = new Student("tom", "jack", 12);
        // 返回第一个不为空
        Student student1 = optional.orElse(student);
        String name = student1.getName();
        System.err.println(student1.getName());
    }


    @Test
    public void test02() {
        Student student = new Student("tom", "jack", 12);
        Optional<Student> optional = Optional.<Student>ofNullable(null);

        Student student1 = optional.orElseGet(() -> {
            log.error("如果是空我就创建一个或者执行其他的业务逻辑");
            return student;
        });
        String name = student1.getName();
        System.err.println(name);

    }


    @Test
    public void test03() {
        Student student = new Student("tom", "jack", 12);
        Optional<Student> optional = Optional.<Student>ofNullable(null);
        optional.orElseThrow(() -> {
            log.error("如果是空我就跑异常");
            return new RuntimeException("对象为空");
        });
    }

    @Test
    public void test04() {
        Student student = new Student("tom", "jack", 12);
        Optional<Student> optional = Optional.<Student>ofNullable(null);
        Optional<String> s = optional.map(Student::getName);
        String s1 = s.orElse("12");
        System.err.println(s1);


        String s2 = optional.flatMap(st -> {
            return Optional.<String>ofNullable(st.getName());
        }).orElse("121");
        System.err.println(s2);
    }

    @Test
    public void test05() {
        Student student = new Student("tom", "jack", 12);
        List<Student> arrayList = new ArrayList<>();
        Student student1 = arrayList.stream()
                .findFirst()
                .orElse(student);
        String name = student1.getName();
        System.err.println(name);
    }

    @Test
    public void test06() {
        getFromRedis()
                .orElseGet(() -> {
                    return getFromDb()
                            .orElseGet(() -> {
                                return getFromRemote().orElseThrow(RuntimeException::new);
                            });
                })
                .getName();
    }

    public Optional<Student> getFromRedis() {
        Student student = new Student("tom", "jack", 12);
        log.error("从redis 中获取值");
        return Optional.ofNullable(null);
    }

    public Optional<Student> getFromDb() {
        log.error("从DB 中获取值");
        Student student = new Student("tom", "jack", 12);
        return Optional.ofNullable(null);
    }

    public Optional<Student> getFromRemote() {
        log.error("从远程 中获取值");
        Student student = new Student("tom", "jack", 12);
        return Optional.ofNullable(student);
    }


    @Test
    public void test07(){
        getFromRemote()
                .flatMap(i -> {
                    return getFromDb();
                })
                .flatMap(k ->
                     getFromRemote()
                )
                .orElseThrow(RuntimeException::new);
        ArrayList<Object> objects = new ArrayList<>();
    }


}
