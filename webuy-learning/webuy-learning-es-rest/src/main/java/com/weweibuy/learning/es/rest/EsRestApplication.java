package com.weweibuy.learning.es.rest;

import com.weweibuy.learning.es.rest.mapper.TbItemMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author durenhao
 * @date 2020/2/8 18:56
 **/
@SpringBootApplication
@MapperScan(basePackageClasses = TbItemMapper.class)
public class EsRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsRestApplication.class, args);
    }

}
