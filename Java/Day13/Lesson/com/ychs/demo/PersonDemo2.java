/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:饿汉式单例
 * @date 2019/07/23 14:51
 */
public class PersonDemo2 {
    private String name;
    private static PersonDemo2 personDemo2 = new PersonDemo2();

    /**
     * 构造方法私有化
     */
    private PersonDemo2() {
    }


    /**
     * 对外提供一个public方法返回实例
     * @return
     */
    public static PersonDemo2 getInstance() {
        return personDemo2;
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
