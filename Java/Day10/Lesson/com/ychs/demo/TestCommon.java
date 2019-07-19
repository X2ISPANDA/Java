/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/18 11:12
 */
public class TestCommon {
    public static void main(String[] args) {
        CommonDemo commonDemo = new CommonDemo();
        commonDemo.f();

        new InterfaceDemo2() {
            @Override
            public void f() {
                System.out.println("f1111.....");
            }
        }.f();
    }
}
