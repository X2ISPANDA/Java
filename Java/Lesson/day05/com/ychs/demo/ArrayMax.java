/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @Description:求出数组中的最大元素
 * @Author Mingyu Xiong
 * @Date 2019/07/11 14:36
 */
public class ArrayMax {
    public static void main(String[] args) {
        int[] arr={90,34,67,78,97,67,45};
        int max = 0;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        System.out.println(max);
    }
}
