/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/17 11:35
 */
public class TestNoName {
    public static void main(String[] args) {
        new ExtendsNoName() {
            @Override
            public void f() {
                super.f();
                System.out.println("子类的f...");
            }
        }.f();
    }
}


