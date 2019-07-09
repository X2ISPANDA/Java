package com.ychs.demo;

import java.util.Scanner;

/** 利用三目运算符判断输入的两个数字的大小
 * @Description:
 * @Author Mingyu Xiong
 * @Date 2019/07/09 11:48
 */
public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入的第一个数：");
        int a = scanner.nextInt();
        System.out.println("输入的第二个数：");
        int b = scanner.nextInt();
        String r = a > b ? a+">"+b : a == b ? a+"="+b : a+"<"+b;
        System.out.println(r);
    }
}
