/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @Description:方法的重载
 * @Author Mingyu Xiong
 * @Date 2019/07/11 10:08
 */
public class Overload {
    public static void main(String[] args) {

    }

    public void add(int a, int b) {
        System.out.println(a + b);
    }


    public void add(double a, double b) {
        System.out.println(a + b);
    }

    public void add(int a, int b, int c) {
        System.out.println(a + b + c);
        return;
    }

}
