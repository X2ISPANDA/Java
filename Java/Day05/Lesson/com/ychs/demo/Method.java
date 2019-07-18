/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

import java.util.Scanner;

/**
 * @Description:方法学习
 * @Author Mingyu Xiong
 * @Date 2019/07/11 09:27
 */
public class Method {

    public static void main(String[] args) {
        Method method = new Method();
        method.recPrint();
        System.out.println("請輸入要輸出的字符串：");
        System.out.println(method.getString());
        method.printSquare(55, 44);
        System.out.println(method.getAvg(9,4,5));
    }

    /**
     * 定义无返回值无参数方法，打印三行三列矩阵
     */
    public void recPrint() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    /**
     * 定义有返回值无参数方法，获取键盘录入的字符串
     * @return 返回一个字符串
     */
    public String getString() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        return str;
    }

    /**
     * 定義無返回值有參數的方法，打印指定行列的矩形
     * @param row 行
     * @param col 列
     */
    public void printSquare(int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    /**
     * 定義一個有參數有返回值的方法，獲取三個書數的平均數
     * @param a 第一個數
     * @param b 第二個數
     * @param c 第三個數
     * @return 平均值
     */
    public double getAvg(double a,double b,double c) {
        return (a + b + c) / 3;
    }
}
