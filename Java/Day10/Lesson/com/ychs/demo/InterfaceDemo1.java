/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:接口
 * @date 2019/07/18 09:29
 */
public interface InterfaceDemo1 {
    public int i = 3;

    public void f();

    public void f1();

    public void f2();

    public static void fn() {
        System.out.println("静态方法");
    }
    default void fcommon() {
        System.out.println("普通方法");
    }
}
