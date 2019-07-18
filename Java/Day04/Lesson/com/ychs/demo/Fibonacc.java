/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @Description:输出斐波那契数列的前40项
 * @Author Mingyu Xiong
 * @Date 2019/07/10 15:07
 */
public class Fibonacc {
    public static void main(String[] args) {
        System.out.println(0);
        System.out.println(1);
        for (int i = 0, j = 1, k = 1; k <= 19; k++) {
            i = i + j;
            System.out.println(i);
            j = i + j;
            System.out.println(j);
        }
    }
}
