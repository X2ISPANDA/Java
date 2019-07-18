/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @Description:输出九九乘法表
 * @Author Mingyu Xiong
 * @Date 2019/07/10 15:27
 */
public class NineNine {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            System.out.println("");
            for (int j = 1; j <= i; j++) {
                System.out.print(j+"*"+i+"="+i*j+"\t");
            }
        }
    }
}
