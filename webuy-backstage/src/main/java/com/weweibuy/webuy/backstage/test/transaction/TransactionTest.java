package com.weweibuy.webuy.backstage.test.transaction;

import com.weweibuy.webuy.backstage.mapper.TbUserMapper;
import com.weweibuy.webuy.backstage.po.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * @ClassName TransactionTest
 * @Description
 * @Author durenhao
 * @Date 2019/3/17 12:05
 **/
@Service
public class TransactionTest {

    @Autowired
    private TbUserMapper userMapper;

    private Random random = new Random();

    @Transactional
    public void addUser(){
        TbUser tbUser = new TbUser();
        tbUser.setUsername("zhangsan" + random.nextInt(1000));
        tbUser.setPassword("123");
        userMapper.insert(tbUser);
    }

    @Transactional
    public void addUser(String str){
        TbUser tbUser = new TbUser();
        tbUser.setUsername("zhangsan" + random.nextInt(1000));
        tbUser.setPassword("123");
        userMapper.insert(tbUser);
    }

}
