/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.test;

/**
 * @author Mingyu Xiong
 * @description:单继承多实现
 * @date 2019/07/16 14:55
 */
public class C extends B {
    private int i;

    public C(int i) {
        super(i);
        System.out.println("C的构造方法");
    }

    public static void main(String[] args) {
        C c = new C(5);

    }
}
