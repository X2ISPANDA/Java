package com.task.task;
/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */
import com.task.bean.Student;
import com.task.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/10/29 18:21
 */
public class TaskTwo {
    public static void main(String[] args) throws SQLException {
        System.out.println("欢迎进入学员管理系统,输入0添加学员信息,输入1添加班级信息,输入2修改相关信息");
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        if (nextInt == 1) {
            Student student = new Student();
            System.out.println("请输入学号:");
            Scanner scanner1 = new Scanner(System.in);
            String s = scanner1.nextLine();
            student.setSno(s);
            System.out.println("请输入姓名:");
            Scanner scanner2 = new Scanner(System.in);
            String s1 = scanner2.nextLine();
            student.setSname(s1);
            System.out.println("请输入性别:");
            Scanner scanner3 = new Scanner(System.in);
            String s2 = scanner3.nextLine();
            student.setSex(s2);
            System.out.println("请输入出生日期:");
            Scanner scanner4 = new Scanner(System.in);
            String s3 = scanner4.nextLine();
            student.setBirthday(s3);
            System.out.println("请输入联系方式:");
            Scanner scanner5 = new Scanner(System.in);
            String s4 = scanner5.nextLine();
            student.setTel(s4);
            System.out.println("请输入班级编号:");
            Scanner scanner6 = new Scanner(System.in);
            String s5 = scanner6.nextLine();
            student.setCno(s5);


        }
    }
}
