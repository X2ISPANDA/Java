/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.shape;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/19 16:43
 */
public class Rectangle implements Shape {
    private double a;

    private double b;
    @Override
    public double cir() {
        return a+a+b+b;
    }

    @Override
    public double area() {
        return a*b;
    }

    /**
     * Gets the value of a
     *
     * @return the value of a
     */
    public double getA() {
        return a;
    }

    /**
     * Sets the a
     * You can use getA() to get the value of a
     *
     * @param a a
     */
    public void setA(double a) {
        this.a = a;
    }

    /**
     * Gets the value of b
     *
     * @return the value of b
     */
    public double getB() {
        return b;
    }

    /**
     * Sets the b
     * You can use getB() to get the value of b
     *
     * @param b b
     */
    public void setB(double b) {
        this.b = b;
    }
}
