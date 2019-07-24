/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.shape;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/24 11:32
 */
public class Rectangle<T,K> extends Shape <T>{
    private double a;
    private double b;

    /**
     * @param a
     * @param b
     */
    public Rectangle(double a, double b) {
        super();
        this.a = a;
        this.b = b;
    }


    public void girth() {
        System.out.println(2*(a+b));

    }


    public void area() {
        System.out.println(a*b);

    }

}