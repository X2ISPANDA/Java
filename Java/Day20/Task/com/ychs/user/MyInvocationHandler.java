/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.user;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/05 15:56
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object obj;
    public MyInvocationHandler(Object obj) {
        super();
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        User user = (User) args[0];
        if( user.getPassword().length() < 6) {
            throw new IllegalPasswordException("密码不能小于6位");
        }
        Boolean r = (Boolean) method.invoke(obj, user);
        return r;
    }
}
