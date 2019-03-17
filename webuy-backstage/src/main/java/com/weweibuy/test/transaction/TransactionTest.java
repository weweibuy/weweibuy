package com.weweibuy.test.transaction;

import com.weweibuy.mapper.TbUserMapper;
import com.weweibuy.po.TbUser;
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

    private Random random = new Random(100);

    @Transactional
    public void addUser(){
        TbUser tbUser = new TbUser();
        tbUser.setUsername("zhangsan" + random.nextInt());
        tbUser.setPassword("123");
        userMapper.insert(tbUser);
    }
}
