package com.weweibuy.webuy.backstage.controller;


import com.weweibuy.webuy.backstage.po.TbUser;
import com.weweibuy.webuy.backstage.service.UserService;
import com.weweibuy.webuy.backstage.test.transaction.TransactionTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author durenhao
 * @Date 2018/9/23 13:29
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionTest transactionTest;

    @GetMapping("/users")
//    @PreAuthorize("hasAuthority('ADMIN')")
    public List<TbUser> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/user/add")
    public String userAdd(){
        transactionTest.addUser();
        return "success";
    }

    @GetMapping("/user/add2")
    public String userAdd2(){
        transactionTest.addUser("str");
        return "success";
    }



}
