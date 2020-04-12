package com.ychs.test;

import com.ychs.service.UserService;
import com.ychs.service.impl.UserServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/4/7 21:28
 */
public class UserServiceProxyFactory2 implements MethodInterceptor {

    public UserService getUserServiceProxy(){
        Enhancer en = new Enhancer();//帮我们生成代理对象
        en.setSuperclass(UserServiceImpl.class);
        en.setCallback(this);//要执行的代理方法
        UserService us = (UserService) en.create();//创建代理对象
        return us;
    }
    /**
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事务");
        Object o1 = methodProxy.invokeSuper(o,objects);
        System.out.println("关闭事务");
        return o1;
    }
}

