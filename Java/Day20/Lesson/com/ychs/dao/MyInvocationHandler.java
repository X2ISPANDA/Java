/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.dao;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/05 15:04
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object obj;
    public MyInvocationHandler(Object obj) {
        super();
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("检查是否有权限");
        method.invoke(obj,args);
        System.out.println("打印日志");
        return null;
    }
}
