/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.test;

/**
 * @author Mingyu Xiong
 * @description:继承自人类的学生实体类
 * @date 2019/07/16 14:32
 */
public class Student extends Person {
    private String sno;
    public String name;
    private String cno;

    public void study() {
        System.out.println(name + "学习" + super.name);
    }

    @Override
    public void eat() {
        System.out.println("吃好的");
    }
}
