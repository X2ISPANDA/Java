/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.reflect;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/05 09:32
 */
public class ReflectDemo {
    public static void main(String[] args) {
        //1.Object里通过getClass获取类对象
        Person p = new Person();
        Class<? extends Person> c1 = p.getClass();
        System.out.println(c1);

        //2.Person类属性class获取
        Class c2 = Person.class;
        System.out.println(c2);
        
        //3.通过Class中的静态方法获取
        try {
            Class<?> c3 = Class.forName("com.ychs.reflect.Person");//全限定名:包名+类名
            System.out.println(c3);
            System.out.println(c1.equals(c3));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(c1 == c2);

    }
}
