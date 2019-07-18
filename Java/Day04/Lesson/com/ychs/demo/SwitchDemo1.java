/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

import java.util.Scanner;

/**
 * @Description:根据月份输出天数
 * @Author Mingyu Xiong
 * @Date 2019/07/10 09:41
 */
public class SwitchDemo1 {
    public static void main(String[] args) {
        System.out.println("请输入月份：");
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("该月有31天");
                break;
            case 2:
                System.out.println("该月闰年有29天，平年有28天");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("该月有30天");
                break;
            default:
                System.out.println("您输入的有误!");
        }
    }
}
