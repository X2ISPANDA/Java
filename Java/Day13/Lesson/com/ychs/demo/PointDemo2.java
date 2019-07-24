/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/23 10:00
 */
public class PointDemo2<M, N, K> {
    private M x;
    private N y;
    private K z;


    public PointDemo2() {
    }

    public PointDemo2(M x, N y, K z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Gets the value of x
     *
     * @return the value of x
     */
    public M getX() {
        return x;
    }

    /**
     * Sets the x
     * You can use getX() to get the value of x
     *
     * @param x x
     */
    public void setX(M x) {
        this.x = x;
    }

    /**
     * Gets the value of y
     *
     * @return the value of y
     */
    public N getY() {
        return y;
    }

    /**
     * Sets the y
     * You can use getY() to get the value of y
     *
     * @param y y
     */
    public void setY(N y) {
        this.y = y;
    }

    /**
     * Gets the value of z
     *
     * @return the value of z
     */
    public K getZ() {
        return z;
    }

    /**
     * Sets the z
     * You can use getZ() to get the value of z
     *
     * @param z z
     */
    public void setZ(K z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "PointDemo2{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
