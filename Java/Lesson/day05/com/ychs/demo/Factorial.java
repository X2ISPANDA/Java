/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

import java.util.Scanner;

/**
 * @Description:计算n的阶乘
 * @Author Mingyu Xiong
 * @Date 2019/07/11 11:02
 */
public class Factorial {
    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println(factorial.fac(5));
    }


    /**
     * 递归调用计算n的阶乘
     * @param n 参数
     * @return 计算阶乘的结果
     */
    public int fac(int n) {
        if (n == 1) {//终止条件
            return 1;
        }else{
            return n * fac(n - 1);
        }
    }
}
