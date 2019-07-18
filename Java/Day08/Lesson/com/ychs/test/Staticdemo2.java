/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.test;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/16 11:05
 */
public class Staticdemo2 {
    private int i = 3;
    public static int j = 4;//类变量

    public static void main(String[] args) {
        //System.out.println(i);
        System.out.println(j);
        //f();
        f1();
    }

    public void f() {
        System.out.println("测试");
        System.out.println(j);
    }

    //类方法
    public static void f1() {
        System.out.println("static test");
    }
    static{
        System.out.println("静态代码块");
    }
}
