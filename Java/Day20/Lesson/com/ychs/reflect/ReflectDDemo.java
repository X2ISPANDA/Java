/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/05 10:34
 */
public class ReflectDDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取类对象
        Class<?> c = Class.forName("com.ychs.reflect.Person");
        //获取构造方法
        Constructor<?> con = c.getConstructor();
        //通过构造方法创建对象
        Person p = (Person) con.newInstance();
        //获取所有属性
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        Field name = c.getDeclaredField("name");
        System.out.println(name);
        name.setAccessible(true);
        name.set(p, "儿子");
        System.out.println(name.get(p));

        Method m = c.getMethod("f");
        System.out.println(m);
        m.invoke(p);

        Method m1 = c.getMethod("f1", int.class, int.class);
        System.out.println("获取返回值的类型" + m1.getReturnType());

        Object obj = m1.invoke(p, 3, 4);
        System.out.println(obj);

        Method m2 = c.getMethod("setAge", int.class);
        Object obj1 = m2.invoke(p, 800);
        Method m3 = c.getMethod("getAge");
        Object obj2 = m3.invoke(p);
        System.out.println(obj2);
    }
}
