/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/17 09:50
 */
public class OrderSon extends OrderDemo{
    static{
        System.out.println("子类的静态语句块");
    }


    public OrderSon() {
        System.out.println("子类的构造方法");
    }

    {
        System.out.println("子类的游离语句块");
    }



}
