/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.test;

import com.ychs.bean.Student;

/**
 * @author Mingyu Xiong
 * @description:学生测试类
 * @date 2019/07/16 09:58
 */
public class TestStudent {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.setSno("1001");
        stu.setSname("张三");
        stu.setAge(18);
        stu.setCno("1班");
        System.out.println(stu.toString());
        Student stu2 = new Student("1002", "法老", 38, "男德班");
        System.out.println(stu2);
    }
}
