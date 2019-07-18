/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:面向对象把大象装进冰箱
 * @date 2019/07/15 17:44
 */
public class Demo2 {
    public static void main(String[] args) {
        Elephant e = new Elephant();
        Bx bx = new Bx();
        bx.open();
        e.put();
        bx.close();
    }
}
