/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/23 09:18
 */
public class PointDemo {
    private Object x;
    private Object y;


    public PointDemo(Object x, Object y) {
        super();
        this.x = x;
        this.y = y;
    }

    /**
     * 无参构造方法
     */
    public PointDemo() {
        super();
    }

    /**
     * Gets the value of x
     *
     * @return the value of x
     */
    public Object getX() {
        return x;
    }

    /**
     * Sets the x
     * You can use getX() to get the value of x
     *
     * @param x x
     */
    public void setX(Object x) {
        this.x = x;
    }

    /**
     * Gets the value of y
     *
     * @return the value of y
     */
    public Object getY() {
        return y;
    }

    /**
     * Sets the y
     * You can use getY() to get the value of y
     *
     * @param y y
     */
    public void setY(Object y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "PointDemo{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
