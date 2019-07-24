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
public class Test {
    public static void main(String[] args) {
        Circle<Double> circle = new Circle<Double>(2.5);
        circle.cir();
        circle.area();

        Rectangle<Double,Double> rect = new Rectangle<Double,Double>(2.3,4.5);
        rect.girth();
        rect.area();
    }
}
