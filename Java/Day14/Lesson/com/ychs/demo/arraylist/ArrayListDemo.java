/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo.arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/24 09:35
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        //特点:可以重复,有序
        //查询快 增删慢
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(5);
        list.add(0, 0);
        System.out.println(list);

        System.out.println("===========存储五个学生===============");

        List<Student> studentList = new ArrayList<>();
        Student student = new Student();
        student.setSno("1000");
        student.setAge(100);
        student.setName("陈奕迅");
        Student student1 = new Student();
        student1.setSno("1001");
        student1.setAge(150);
        student1.setName("萧亚轩");
        Student student2 = new Student();
        student2.setSno("1002");
        student2.setAge(30);
        student2.setName("张国荣");
        Student student3 = new Student();
        student3.setSno("1003");
        student3.setAge(50);
        student3.setName("梅艳芳");
        Student student4 = new Student();
        student4.setSno("1004");
        student4.setAge(60);
        student4.setName("王俊凯");

        studentList.add(student);
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student1);
        studentList.add(student1);

        System.out.println(studentList);

    }

}
