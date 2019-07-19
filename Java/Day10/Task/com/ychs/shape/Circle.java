/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.shape;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/19 16:40
 */
public class Circle implements Shape {
    private int r;
    public static final double  PI = 3.1415;
    @Override
    public double cir() {
        return 2 * PI * r;
    }

    @Override
    public double area() {
        return PI * r * r;
    }

    /**
     * Gets the value of r
     *
     * @return the value of r
     */
    public int getR() {
        return r;
    }

    /**
     * Sets the r
     * You can use getR() to get the value of r
     *
     * @param r r
     */
    public void setR(int r) {
        this.r = r;
    }
}
