package com.weweibuy.webuy.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @author durenhao
 * @date 2020/2/26 20:38
 **/
@Component
public class JackJsonUtils {

    private static ObjectMapper CAMEL_CASE_MAPPER;

    private static ObjectMapper SNAKE_CASE_MAPPER;

    private static ObjectMapper MVC_OBJECT_MAPPER;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Jackson2ObjectMapperBuilder objectMapperBuilder;

    @PostConstruct
    public void init() {
        MVC_OBJECT_MAPPER = objectMapper;
        PropertyNamingStrategy propertyNamingStrategy = objectMapper.getPropertyNamingStrategy();

        if (propertyNamingStrategy == null || PropertyNamingStrategy.LOWER_CAMEL_CASE.getClass().getSimpleName()
                .equals(propertyNamingStrategy.getClass().getSimpleName())) {
            CAMEL_CASE_MAPPER = objectMapper;
            SNAKE_CASE_MAPPER = objectMapperBuilder.createXmlMapper(false)
                    .propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
                    .build();
        } else if (PropertyNamingStrategy.SNAKE_CASE.getClass().getSimpleName()
                .equals(propertyNamingStrategy.getClass().getSimpleName())) {
            SNAKE_CASE_MAPPER = objectMapper;
            CAMEL_CASE_MAPPER = objectMapperBuilder.createXmlMapper(false)
                    .propertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE)
                    .build();
        } else {
            throw new IllegalStateException("Jackson objectMapper NamingStrategy 为: " + propertyNamingStrategy.getClass().getSimpleName() + "目前不支持");
        }
    }

    public static <T> T readSnakeCaseValue(String json, Class<? extends T> clazz) {
        try {
            return SNAKE_CASE_MAPPER.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T readSnakeCaseValue(String json, JavaType javaType) {
        try {
            return SNAKE_CASE_MAPPER.readValue(json, javaType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T readSnakeCaseValue(byte[] json, Class<? extends T> clazz) {
        try {
            return SNAKE_CASE_MAPPER.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T readSnakeCaseValue(byte[] json, JavaType javaType) {
        try {
            return SNAKE_CASE_MAPPER.readValue(json, javaType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String writeSnakeCase(Object object) {
        try {
            return SNAKE_CASE_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] writeSnakeCaseAsByte(Object object) {
        try {
            return SNAKE_CASE_MAPPER.writeValueAsBytes(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T readValue(String json, Class<? extends T> clazz) {
        try {
            return MVC_OBJECT_MAPPER.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T readValue(String json, JavaType javaType) {
        try {
            return MVC_OBJECT_MAPPER.readValue(json, javaType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T readValue(byte[] json, Class<? extends T> clazz) {
        try {
            return MVC_OBJECT_MAPPER.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T readValue(byte[] json, JavaType javaType) {
        try {
            return MVC_OBJECT_MAPPER.readValue(json, javaType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String write(Object object) {
        try {
            return MVC_OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] writeAsByte(Object object) {
        try {
            return MVC_OBJECT_MAPPER.writeValueAsBytes(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    public static <T> T readCamelCaseValue(String json, Class<? extends T> clazz) {
        try {
            return CAMEL_CASE_MAPPER.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T readCamelCaseValue(String json, JavaType javaType) {
        try {
            return CAMEL_CASE_MAPPER.readValue(json, javaType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T readCamelCaseValue(byte[] json, Class<? extends T> clazz) {
        try {
            return CAMEL_CASE_MAPPER.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T readCamelCaseValue(byte[] json, JavaType javaType) {
        try {
            return CAMEL_CASE_MAPPER.readValue(json, javaType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String writeCamelCase(Object object) {
        try {
            return CAMEL_CASE_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] writeCamelCaseAsByte(Object object) {
        try {
            return CAMEL_CASE_MAPPER.writeValueAsBytes(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    public static ObjectMapper getCamelCaseMapper() {
        return CAMEL_CASE_MAPPER;
    }

    public static ObjectMapper getSnakeCaseMapper() {
        return SNAKE_CASE_MAPPER;
    }

    public static ObjectMapper getMvcObjectMapper() {
        return MVC_OBJECT_MAPPER;
    }
}
