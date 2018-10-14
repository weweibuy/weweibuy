package com.weweibuy.controller;

import com.weweibuy.mapper.TbUserMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName HelloController
 * @Description
 * @Author durenhao
 * @Date 2018/10/11 16:44
 **/
@RestController
public class HelloController {

    @Autowired
    private TbUserMapper userMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/users")
    public List helloUser(){
        return userMapper.selectByExample(null);
    }

    @RequestMapping("/queue")
    public String helloQueue(){
        rabbitTemplate.convertAndSend("fanoutExchange", "", "hello.queue1",
                new CorrelationData("111111232"));
        return "1";
    }



}
