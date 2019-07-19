/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.shape;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/19 16:45
 */
public class Test {
    public static void main(String[] args) {
        Shape shape = new Circle();
        Circle circle = (Circle)shape;
        circle.setR(5);
        System.out.println("圆的面积是:" + circle.area());
        System.out.println("圆的周长是:" + circle.cir());
        Shape shape2 = new Rectangle();
        Rectangle rectangle = (Rectangle) shape2;
        rectangle.setA(5);
        rectangle.setB(6);
        System.out.println("矩形的面积是:" + rectangle.area());
        System.out.println("矩形的周长是:" + rectangle.cir());
    }
}
