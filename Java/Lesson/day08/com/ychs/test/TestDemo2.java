/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.test;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/16 11:10
 */
public class TestDemo2 {
    public static void main(String[] args) {
        System.out.println(Staticdemo2.j);
        Staticdemo2.f1();

        Staticdemo2 demo2 = new Staticdemo2();
        demo2.f();
        demo2.f1();
        System.out.println(demo2.j);
    }

    public void f() {
        System.out.println("测试");
        System.out.println(Staticdemo2.j);
    }

}
