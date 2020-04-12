package com.ychs.test;

import com.ychs.service.UserService;
import com.ychs.service.impl.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/4/7 21:29
 */
public class UserServiceProxyFactroy {
    private UserService userService;
    public UserService getUserServiceProxy(){

        /**
         * 第一个参数：类加载器
         * 第二参数：接口数组，生成代理类要实现的接口
         * 第三个参数：执行的handler，生成代理对象,也是要进行增强的内容
         */
        UserService usProxy = (UserService) Proxy.newProxyInstance(
                UserServiceProxyFactroy.class.getClassLoader(),
                UserServiceImpl.class.getInterfaces(),
                new InvocationHandler() {
                    /**
                     * @param proxy:当前代理对象，代理类的实例
                     * @param method 要执行的方法
                     * @param args  方法里的参数
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("before....");
                        Object o = method.invoke(userService, args);
                        System.out.println("after....");
                        return o;
                    }
                });
        return usProxy;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}