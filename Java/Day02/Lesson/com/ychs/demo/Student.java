package com.ychs.demo;

/**
 * @Description:学生类
 * @Author Mingyu Xiong
 * @Date 2019/07/08 20:22
 */
public class Student {
    //全局变量  一般称之为成员变量：方法的外部，类的内部
    //成员变量都有默认值   可以是基本类型也可以是复合类型
    String sno = "1001";
    String sname;
    char sex;
    int age;
    boolean isYear;
    double avgScore;
    //复合类型
    Clazz clazz;
    //定义一个常量（特点：后期不能被修改）
    public static final double PI = 3.1415926;


    //成员方法
    public void study() {
        int a=3;//局部变量
        System.out.println("学习...."+a);
    }
    public void play() {

        System.out.println("玩耍...."+PI);
    }
}
