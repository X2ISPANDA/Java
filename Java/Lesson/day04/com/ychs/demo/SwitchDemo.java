/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

import java.util.Scanner;

/**
 * @Description:利用switch完成两个数的四则运算
 * @Author Mingyu Xiong
 * @Date 2019/07/10 09:32
 */
public class SwitchDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("請輸入两个操作数：");
        double i = sc.nextDouble();
        double j = sc.nextDouble();
        System.out.println("請輸入操作符：");
        String op = sc.next();
        switch (op) {
            case "+":
                System.out.println(i+j);
                break;
            case "-":
                System.out.println(i-j);
                break;
            case "*":
                System.out.println(i*j);
                break;
            case "/":
                System.out.println(i/j);
                break;
            default:
                System.out.println("您输入的有误！");
                break;
        }
    }
}
