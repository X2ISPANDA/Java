/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @Description:二维数组初始化
 * @Author Mingyu Xiong
 * @Date 2019/07/11 15:04
 */
public class TwoArrayInit {
    public static void main(String[] args) {
        //声明并初始化一个二维数组
        int[][] a = new int[3][4];
        a[0][0] = 1;
        a[0][1] = 2;
        a[1][0] = 3;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                int anInt = a[i][j];
                System.out.print(anInt+"\t");
            }
            System.out.println();

        }

        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
    }
}
