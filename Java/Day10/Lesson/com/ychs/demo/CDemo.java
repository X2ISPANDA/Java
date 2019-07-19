/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:接口的多继承
 * @date 2019/07/18 10:03
 */
public interface CDemo extends ADemo,BDemo {
    void f3();

    int i=3;

    /**
     * 静态方法测试
     */
    static void staticMethod() {
        System.out.println("我是你爸爸");
    }
}
