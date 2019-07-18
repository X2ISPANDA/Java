/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @Description:求100以内所有偶数的和
 * @Author Mingyu Xiong
 * @Date 2019/07/10 15:22
 */
public class Even {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i <=100; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
