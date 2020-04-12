package com.ychs.test;

import com.ychs.pojo.User;
import com.ychs.service.UserService;
import com.ychs.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/4/7 21:27
 */
public class TestUserServiceProxy {

    @Test
    public void test01(){
        UserService us = new UserServiceImpl();
        UserServiceProxyFactroy proxyFactroy = new UserServiceProxyFactroy();
        proxyFactroy.setUserService(us);
        UserService userService = proxyFactroy.getUserServiceProxy();
        List<User> users = userService.queryUsers();
        System.out.println(users);
    }

    @Test
    public void test02(){
        UserServiceProxyFactory2 proxyFactory2 = new UserServiceProxyFactory2();
        UserService us = proxyFactory2.getUserServiceProxy();
        List<User> users = us.queryUsers();
        System.out.println(users);

        int i = us.addUser(new User());
        System.out.println(i);
    }
}
