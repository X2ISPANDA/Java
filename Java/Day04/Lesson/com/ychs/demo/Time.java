/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

import java.util.Scanner;

/**
 * @Description:从键盘上输入一个时间，输出这个时间的后一秒
 * @Author Mingyu Xiong
 * @Date 2019/07/10 10:04
 */
public class Time {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入时分秒：");
        int h = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt()+1;
        if (s == 60) {
            s=0;
            m=m+1;
            if (m == 60) {
                m=0;
                h = h + 1;
                if (h == 24) {
                    h = 0;
                }
            }
        }
        System.out.printf("%02d:%02d:%02d", h, m, s);
    }
}
