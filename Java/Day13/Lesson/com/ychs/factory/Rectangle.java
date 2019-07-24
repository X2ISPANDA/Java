/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.factory;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/23 16:09
 */
public class Rectangle implements IShape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
