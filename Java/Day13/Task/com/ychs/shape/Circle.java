/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.shape;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/24 11:45
 */
public class Circle<T> extends Shape<T> {
    private double r;


    /**
     * @param r
     */
    public Circle(double r) {
        super();
        this.r = r;
    }


    public void cir() {
        System.out.println(2 * r * Math.PI);
    }


    public void area() {
        System.out.println(Math.PI*r*r);
    }

}