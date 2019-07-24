/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.wrapper;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/23 16:41
 */
public class Demo {
    public static void main(String[] args) {
        Integer a = new Integer(25);

        Integer b = Integer.valueOf(10);

        Integer c = 3;

        Integer d = 10;

        Integer e = 10;
        System.out.println(d == e);

        Integer f = 200;
        Integer g = 200;
        System.out.println(f == g);
    }
}
