package com.weweibuy.webuy.learning.spring.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weweibuy.webuy.learning.spring.desensitization.vo.SensitiveUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;

/**
 * @author durenhao
 * @date 2019/9/13 16:33
 **/
@Slf4j
public class JsonTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void test01() throws IOException {
        String jsonStr = "{\n" +
                "\t\"userName\": \"tom\",\n" +
                "\t\"password\": \"123456\",\n" +
                "\t\"phone\": \"13800000000\",\n" +
                "\t\"age\": 12,\n" +
                "\t\"address\": \"abc 路 xx 号\",\n" +
                "\t\"city\": \"上海\",\n" +
                "\t\"birthday\": \"2019-09-10 12:00:00\"\n" +
                "}";

        SensitiveUser sensitiveUser = objectMapper.readValue(jsonStr, SensitiveUser.class);
        log.info("读取后内容 : {}", sensitiveUser);
        String s = objectMapper.writeValueAsString(sensitiveUser);
        log.info("序列化内容: {}", s);
    }


    @Test
    public void test02() throws IOException {

        String jsonStr = "{\n" +
                "\t\"userName\": \"tom\",\n" +
                "\t\"password\": \"123456\",\n" +
                "\t\"phone\": \"13800000000\",\n" +
                "\t\"age\": 12,\n" +
                "\t\"address\": \"abc 路 xx 号\",\n" +
                "\t\"city\": \"上海\",\n" +
                "\t\"birthday\": \"2019-09-10 12:00:00\"\n" +
                "}";
        byte[] bytes1 = jsonStr.getBytes();
        SensitiveUser sensitiveUser = objectMapper.readValue(bytes1, SensitiveUser.class);
        System.err.println(sensitiveUser);


    }


}
