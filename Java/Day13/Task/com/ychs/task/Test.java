/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.task;/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/23 15:21
 */
public class Test {
    public static void main(String[] args) {
        Student student = Student.getInstance();
        student.setName("周杰伦");
        student.setNo("502");
        Student student1 = Student.getInstance();
        System.out.println(student1);
    }
}
