/*
 * Copyright (c) 2019.
 * All Rights Reserved By Mingyu Xiong
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/22 16:38
 */
public class Test1 {

    {
        a = 1;

        //System.out.println(a);
//        只有在全部满足以下4点的情况下，成员变量的声明才必须在使用之前，否则顺序无关
//
//        使用出现在该类的实例/静态变量初始化，或者该类的实例/静态初始化块中
//        使用不在赋值表达式左边
//        使用是通过简单名称
//        调用它的是包含该使用的直接类/接口
    }
    public int a = 2;

    {
        System.out.println(a);
    }
    public static void main(String[] args){
        Test1 test1 = new Test1();
        System.out.println(test1.a);
    }
}