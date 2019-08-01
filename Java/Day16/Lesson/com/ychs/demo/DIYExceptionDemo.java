/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:自定义异常
 * @date 2019/07/29 14:50
 */
public class DIYExceptionDemo {
    public static void main(String[] args) throws IllegalAgeException {
        Person person = new Person();
        person.setAge(-10);
    }
}

class Person{
    private int age;

    /**
     * Gets the value of age
     *
     * @return the value of age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age
     * You can use getAge() to get the value of age
     *
     * @param age age
     */
    public void setAge(int age) throws IllegalAgeException {
        if (age < 0) {
            throw new IllegalAgeException("年龄不能为负数");
        }
        this.age = age;
    }
}

class IllegalAgeException extends Exception {
    public IllegalAgeException() {

    }

    public IllegalAgeException(String msg) {
        super(msg);
    }
}
