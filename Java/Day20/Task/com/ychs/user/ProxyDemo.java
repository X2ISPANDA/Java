/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.user;

import java.lang.reflect.Proxy;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/05 16:00
 */
public class ProxyDemo {
    public static void main(String[] args) throws IllegalPasswordException {
        User user = new User();
        user.setPassword("111");
        UserImpl userDao = new UserImpl();
        MyInvocationHandler handler = new MyInvocationHandler(userDao);
        //创建代理对象
        //第一个参数,代理类的加载器
        //第二个参数,代理类的所有接口
        //第三个参数,代理对象需要绑定的处理器
        UserDao obj = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(),
                userDao.getClass().getInterfaces(), handler);
        boolean r = obj.getUser(user);
        System.out.println(r);
    }
}
