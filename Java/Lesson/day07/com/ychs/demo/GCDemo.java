/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/15 17:42
 */
public class GCDemo {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("我马上就要被销毁了！");
    }

    public static void main(String[] args) {
        GCDemo gcDemo = new GCDemo();
        System.out.println(gcDemo);
        gcDemo = new GCDemo();
        System.out.println(gcDemo);
        System.gc();
//        Runtime.getRuntime().gc();

    }
}
