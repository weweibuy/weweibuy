package com.weweibuy.learning.es.rest.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @author durenhao
 * @date 2020/2/8 18:47
 **/
@Component
public class JacksonUtils {

    private static ObjectMapper mapper;

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    public void init() {
        mapper = objectMapper;
    }


    public static String objectToString(Object o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static <T> T stringToObject(String s, Class<T> clazz) {
        try {
            return mapper.readValue(s, clazz);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
