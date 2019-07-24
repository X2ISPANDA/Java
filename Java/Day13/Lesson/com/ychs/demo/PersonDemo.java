/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:单例模式
 * @date 2019/07/23 14:31
 */
public class PersonDemo {
    private String name;

    /**
     * 内部提供一个private static 修饰的对象
     */
    private static PersonDemo personDemo;

    /**
     * 构造方法私有化
     */
    private PersonDemo() {

    }

    /**
     * 提供一个static的方法返回该对象,懒汉式单例
     * @return 实例对象
     */
    public static PersonDemo getInstance() {
        if (personDemo == null) {
            personDemo = new PersonDemo();
        }
        return personDemo;
    }

    /**
     * Gets the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     * You can use getName() to get the value of name
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }
}
