/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.test;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/16 14:37
 */
public class TestDemo3 {
    public static void main(String[] args) {
        Person p = new Person();
        p.name = "lisi";
        Student stu1 = new Student();
        stu1.name = "儿子";
        stu1.eat();
        stu1.study();
        stu1.play();
    }
}
