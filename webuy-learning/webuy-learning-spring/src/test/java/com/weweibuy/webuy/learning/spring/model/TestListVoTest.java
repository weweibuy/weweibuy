package com.weweibuy.webuy.learning.spring.model;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TestListVoTest {


    @Test
    public void test(){
        List<String> list = Collections.<String>emptyList();
        List<Integer> collect = list.stream()
                .map(String::hashCode)
                .collect(Collectors.toList());
        System.err.println(Objects.isNull(collect));
    }

    @Test
    public void test02(){

        RestTemplate restTemplate = new RestTemplate();
        TestListVo testListVo = new TestListVo();
        testListVo.setAge(12);
        testListVo.setUsers(Collections.emptyList());
        TestListVo testListVo1 = restTemplate.postForObject("http://localhost:8090/api/v1/test/hello3", testListVo, TestListVo.class);


    }
}