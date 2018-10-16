package com.weweibuy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 任务调度工程
 * @ClassName Application_Task
 * @Description
 * @Author durenhao
 * @Date 2018/10/16 15:17
 **/
@SpringBootApplication
@MapperScan(basePackages = {"com.weweibuy.dao"})
public class Application_Task {

    public static void main(String[] args) {
        SpringApplication.run(Application_Task.class);
    }

}
