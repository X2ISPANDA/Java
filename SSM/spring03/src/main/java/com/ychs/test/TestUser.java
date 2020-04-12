package com.ychs.test;


import com.ychs.pojo.User;
import com.ychs.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext1.xml")
public class TestUser {
    @Resource(name = "us")
    private UserService userService;
    @Test
    public void test01(){
        User user = new User();
        user.setUsername("yyyy");
        user.setPassword("yyyy");
        userService.saveUser(user);
    }
}
