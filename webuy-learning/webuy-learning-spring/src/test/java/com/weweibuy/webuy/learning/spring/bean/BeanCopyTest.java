/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.weweibuy.webuy.learning.spring.bean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author durenhao
 * @date 2019/9/1 19:09
 **/
@Slf4j
public class BeanCopyTest {

    @Test
    public void test01() {
        PoUser poUser = new PoUser();
        poUser.setName("tom");
        poUser.setAge(12);
        DtoUser dtoUser1 = DtoUser.fromPo(poUser);

        VoUser voUser = new VoUser();
        voUser.setName("tom");
        voUser.setAge(12);
        DtoUser dtoUser = DtoUser.fromPo(voUser);

        System.err.println(dtoUser);
        System.err.println(dtoUser1);

        System.err.println(dtoUser1.equals(dtoUser));
    }


    @Test
    public void test03() {
        List<VoUser> voUserList = new ArrayList<>();
        VoUser voUser = new VoUser();
        voUser.setName("tom");
        voUser.setAge(12);
        VoUser voUser1 = new VoUser();
        voUser1.setName("jack");
        voUser1.setAge(13);
        voUserList.add(voUser);
        voUserList.add(voUser1);
        List<PoUser> poUserList = (List<PoUser>) (Object) voUserList;
        poUserList.forEach(System.out::println);


        Optional<VoUser> userOptional = Optional.of(voUser);

        Optional<PoUser> userOptional1 = (Optional<PoUser>) (Object) userOptional;

        System.err.println(userOptional1);

        PageResult<VoUser> voUserPageResult = new PageResult<>(1, voUserList);

        PageResult<PoUser> poUserPageResult = (PageResult<PoUser>) (Object) voUserPageResult;

        System.err.println(poUserPageResult);



    }

}
