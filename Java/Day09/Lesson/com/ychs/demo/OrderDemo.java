/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/17 09:48
 */
public class OrderDemo {
    static {
        System.out.println("父类的静态语句块");
    }

    {
        System.out.println("父类的游离语句块");
    }

    public OrderDemo() {
        System.out.println("父类的构造方法");
    }
}
