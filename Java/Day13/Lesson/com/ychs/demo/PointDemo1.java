/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:泛型,定义类的时候用一个大写字母表示类型(变量类型或参数类型,参数返回值),一般用大写字母T,M,N,K,V,A,B表示
 * @date 2019/07/23 09:35
 */
public class PointDemo1<T> {
    private T x;
    private T y;


    public PointDemo1() {
    }

    public PointDemo1(T x, T y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the value of x
     *
     * @return the value of x
     */
    public T getX() {
        return x;
    }

    /**
     * Sets the x
     * You can use getX() to get the value of x
     *
     * @param x x
     */
    public void setX(T x) {
        this.x = x;
    }

    /**
     * Gets the value of y
     *
     * @return the value of y
     */
    public T getY() {
        return y;
    }

    /**
     * Sets the y
     * You can use getY() to get the value of y
     *
     * @param y y
     */
    public void setY(T y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "PointDemo1[" +
                "x=" + x +
                ", y=" + y +
                ']';
    }
}
