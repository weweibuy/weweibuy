package com.weweibuy.webuy.learning.spring.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.weweibuy.webuy.learning.spring.mapper.TestDogMapper;
import com.weweibuy.webuy.learning.spring.mapper.TestUserMapper;
import com.weweibuy.webuy.learning.spring.model.dto.TestUserDto;
import com.weweibuy.webuy.learning.spring.model.po.TestDog;
import com.weweibuy.webuy.learning.spring.model.po.TestDogExample;
import com.weweibuy.webuy.learning.spring.model.po.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author durenhao
 * @date 2019/6/14 23:08
 **/
@Service
public class TestUserService  {

    @Autowired
    private TestUserMapper userMapper;

    @Autowired
    private TestDogMapper dogMapper;

    public List<TestUserDto> getUsers() {
        Page<Object> startPage = PageHelper.startPage(1, 2);
        List<TestUser> testUsers = userMapper.selectByExample(null);
        return testUsers.stream()
                .map(user -> {
                    Long id = user.getId();
                    TestDogExample example = new TestDogExample();
                    example.createCriteria()
                            .andUserIdEqualTo(id);
                    List<TestDog> testDogs = dogMapper.selectByExample(example);
                    return new TestUserDto(user.getName(), user.getAge(), testDogs);
                })
                .collect(Collectors.toList());

    }

}
