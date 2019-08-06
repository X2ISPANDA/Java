/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:泛型的擦除
 * @date 2019/08/05 14:12
 */
public class RemoveDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        //list.add("aaa");
        System.out.println(list);

        //反射
        //获取类对象
        Class<? extends List> c = list.getClass();
        //获取list中的add方法
        Method m = c.getMethod("add", Object.class);
        //调用方法
        m.invoke(list, "aaa");
        System.out.println(list);
    }
}
