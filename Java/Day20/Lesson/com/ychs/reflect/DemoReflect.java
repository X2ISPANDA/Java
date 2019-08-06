/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/05 09:55
 */
public class DemoReflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取类对象
        final Class<?> c = Class.forName("com.ychs.reflect.Person");
        //获取类中的所有构造方法
        final Constructor<?>[] cons = c.getConstructors();
        for (Constructor<?> con : cons) {
            System.out.println(con);
        }

        //获取某一个无参构造方法
        final Constructor<?> con1 = c.getConstructor();
        System.out.println(con1);
        //获取有参数的构造方法,只能获取public修饰的
        final Constructor<?> con2 = c.getConstructor(String.class, int.class);
        System.out.println(con2);

        //获取私有构造方法
        Constructor<?> con3 = c.getDeclaredConstructor(String.class);
        System.out.println(con3);

        //创建对象
        Person p = (Person) con1.newInstance();
        System.out.println(p);

        //创建私有对象
        con3.setAccessible(true);
        Person father = (Person) con3.newInstance("FATHER");
        System.out.println(father);
    }
}
