/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.factory;


/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/23 16:10
 */
public class Circle implements IShape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
