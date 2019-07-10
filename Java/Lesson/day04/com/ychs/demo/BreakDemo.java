/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @Description:Break和Continue的区别
 * @Author Mingyu Xiong
 * @Date 2019/07/10 16:15
 */
public class BreakDemo {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.print(i);
            if (i == 5) {
                //break跳出循环
                //continue跳出本次循环
                //break;
                continue;
            }
            System.out.println("*");
        }
    }
}
