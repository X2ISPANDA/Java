/*
 * Copyright (c) 2020.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.bean;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/4/11 23:52
 */
public class Person implements HttpSessionBindingListener {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("把person对象放入session中"+event.getName()+event.getValue());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("把person对象从session中移除"+event.getName()+event.getValue());
    }
}
