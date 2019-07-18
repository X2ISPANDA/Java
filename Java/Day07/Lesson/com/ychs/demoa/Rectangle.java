/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demoa;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/15 16:55
 */
public class Rectangle {
    private int a;
    private int h;

    public Rectangle(int a, int h) {
        this.a = a;
        this.h = h;
    }

    public int Cir() {
        return 2*(a+h);
    }

    public int Area() {
        return a*h;
    }
}
