/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/24 10:10
 */
public class StudentTest {
    public static void main(String[] args) {
        ArrayList<Student> 对象 = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            Student[] stu = new Student[2];
            stu[i] = new Student();
            System.out.print("请输入学号:");
            String  s1 = scanner.nextLine();
            stu[i].setNo(s1);
            System.out.print("请输入姓名:");
            String  s2 = scanner.nextLine();
            stu[i].setName(s2);
            对象.add(stu[i]);
        }


        System.out.println(对象);
        Iterator iterator = 对象.iterator();
        while (iterator.hasNext()) {
            Student s =(Student) iterator.next();
            System.out.println(s);
        }
    }
}
