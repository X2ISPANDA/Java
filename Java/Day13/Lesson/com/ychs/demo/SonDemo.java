/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/23 15:41
 */
public class SonDemo extends AdaptDemo {
    @Override
    public void f() {
        System.out.println("fffff");
    }

    @Override
    public void f1() {
        System.out.println("ffffffffffff111111111111");
    }

    public static void main(String[] args) {
        SonDemo sonDemo = new SonDemo();
        sonDemo.f();
        sonDemo.f1();
    }
}
