package com.ychs.task;/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/23 15:18
 */
public class Student {

    private String no;
    private String name;

    private static Student student = new Student();

    private Student() {

    }

    public static Student getInstance() {
        return student;
    }

    /**
     * Gets the value of no
     *
     * @return the value of no
     */
    public String getNo() {
        return no;
    }

    /**
     * Sets the no
     * You can use getNo() to get the value of no
     *
     * @param no no
     */
    public void setNo(String no) {
        this.no = no;
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

    @Override
    public String toString() {
        return "com.ychs.task.Student{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
