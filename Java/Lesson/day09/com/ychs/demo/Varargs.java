/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:可变参数
 * @date 2019/07/17 09:39
 */
public class Varargs {
    public static void main(String... args) {
        f(1);
        f(1, 2, 3, 4);
        f(5, 6, 7, 8, 9, 10);
    }

    public static void f(int... arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
