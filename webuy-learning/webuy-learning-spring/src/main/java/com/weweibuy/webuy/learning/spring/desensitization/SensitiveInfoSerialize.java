package com.weweibuy.webuy.learning.spring.desensitization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author durenhao
 * @date 2019/9/12 22:19
 **/
@Slf4j
public class SensitiveInfoSerialize extends JsonSerializer<String> implements ContextualSerializer {

    @Override
    public void serialize(String value, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
        log.info("serialize");
        jsonGenerator.writeString("******");
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        log.info("createContextual");
        if (beanProperty != null) { // 为空直接跳过
            return new SensitiveInfoSerialize();
        }
        return serializerProvider.findNullValueSerializer(beanProperty);

    }
}
