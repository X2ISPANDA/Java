/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/18 17:33
 */
public class ZiDemo extends FuDemo{
    @Override
    public void f() {
        System.out.println("fzi....");
    }
    public void f2() {
        System.out.println("f2...");
    }
    public static void main(String[] args) {
        FuDemo demo = new ZiDemo();
        demo.f();
        demo.f1();
//		demo.f2();
        //instanceof 判断某个对象是否属于某个类
        System.out.println(demo instanceof ZiDemo);
        System.out.println(demo instanceof FuDemo);

    }
}
