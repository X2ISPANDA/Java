/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:单继承多实现
 * @date 2019/07/18 09:35
 */
public class InterfaceSonDemo1 implements InterfaceDemo1,Interface2Demo1 {
    @Override
    public void f() {
        System.out.println("f....");
    }

    @Override
    public void f1() {
        System.out.println("f1....");
    }

    @Override
    public void f2() {
        System.out.println("f2...");
    }

    @Override
    public void f4() {
        System.out.println("f4...");
    }
}
