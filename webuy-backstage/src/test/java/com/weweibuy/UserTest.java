package com.weweibuy;

import com.weweibuy.test.queue.Duty;
import org.junit.Test;

public class UserTest {

    @Test
    public void test1(){
        User user1 = new User("zhangsan", 12);
        User user2 = new User("zhangsan", 12);
        System.err.println(user2.equals(user1));
        System.err.println(user2.hashCode() == user1.hashCode());

        Duty duty = new Duty("");
        Duty duty2 = new Duty("");
        System.err.println(duty.equals(duty2));
        System.err.println(duty.hashCode() == duty2.hashCode());


    }

}
