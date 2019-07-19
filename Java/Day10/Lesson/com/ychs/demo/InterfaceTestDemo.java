/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/18 17:36
 */
public class InterfaceTestDemo {
    public static void main(String[] args) {
        InterfaceSonDemo1 demo1 = new InterfaceSonDemo1();
        demo1.f();
        demo1.f1();
        demo1.f2();
        demo1.fcommon();
        System.out.println(InterfaceDemo1.i);
        InterfaceDemo1.fn();
    }
}
