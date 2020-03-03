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

        if (propertyNamingStrategy == null) {
            CAMEL_CASE_MAPPER = objectMapper;
            SNAKE_CASE_MAPPER = objectMapperBuilder.createXmlMapper(false)
                    .propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
                    .build();
        } else if (PropertyNamingStrategy.SNAKE_CASE.getClass().getSimpleName()
                .equals(propertyNamingStrategy.getClass().getSimpleName())) {
            SNAKE_CASE_MAPPER = objectMapper;
            CAMEL_CASE_MAPPER = objectMapperBuilder.createXmlMapper(false)
                    .propertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE)
                    .build();
        } else {
            throw new IllegalStateException("Jackson objectMapper NamingStrategy 为: " + propertyNamingStrategy.getClass().getSimpleName() + "目前不支持");
        }
    }

    public static <T> T snakeCaseReadValue(String json, Class<? extends T> clazz) {
        try {
            return MVC_OBJECT_MAPPER.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T snakeCaseReadValue(String json, JavaType javaType) {
        try {
            return MVC_OBJECT_MAPPER.readValue(json, javaType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T snakeCaseReadValue(byte[] json, Class<? extends T> clazz) {
        try {
            return MVC_OBJECT_MAPPER.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T snakeCaseReadValue(byte[] json, JavaType javaType) {
        try {
            return MVC_OBJECT_MAPPER.readValue(json, javaType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String snakeCaseWrite(Object object) {
        try {
            return MVC_OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] snakeCaseWriteAsByte(Object object) {
        try {
            return MVC_OBJECT_MAPPER.writeValueAsBytes(object);
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


    public static <T> T camelCaseReadValue(String json, Class<? extends T> clazz) {
        try {
            return MVC_OBJECT_MAPPER.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T camelCaseReadValue(String json, JavaType javaType) {
        try {
            return MVC_OBJECT_MAPPER.readValue(json, javaType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T camelCaseReadValue(byte[] json, Class<? extends T> clazz) {
        try {
            return MVC_OBJECT_MAPPER.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T camelCaseReadValue(byte[] json, JavaType javaType) {
        try {
            return MVC_OBJECT_MAPPER.readValue(json, javaType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String camelCaseWrite(Object object) {
        try {
            return MVC_OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] camelCaseWriteAsByte(Object object) {
        try {
            return MVC_OBJECT_MAPPER.writeValueAsBytes(object);
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
