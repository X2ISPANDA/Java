/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:栈溢出错误
 * @date 2019/07/29 12:15
 */
public class ErrorDemo {
    public static int fun(int x) {
        x++;
        return fun(x) * x;
    }

    public static void main(String[] args) {
        fun(10);//递归出现栈溢出错误
    }
}
