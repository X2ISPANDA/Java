/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/25 15:34
 */
public class TestDemo {
    public static void main(String[] args) {
        List<Clazz> classList = new ArrayList();
        Clazz c1 = new Clazz();
        c1.setCno("一班");
        c1.setCname("1001");
        Student stu1 = new Student("yc001", "周杰伦", 20, 90);
        Student stu2 = new Student("yc002", "周迅", 20, 90);
        Student stu3 = new Student("yc003", "周杰", 20, 90);

        List<Student> studentList = new ArrayList<>();
        studentList.add(stu1);
        studentList.add(stu2);
        studentList.add(stu3);
        c1.setStus(studentList);

    }
}
