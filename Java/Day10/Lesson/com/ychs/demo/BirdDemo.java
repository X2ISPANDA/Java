/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/18 09:55
 */
public class BirdDemo extends AnimalDemo implements FlyDemo2 {
    @Override
    public void run() {
        System.out.println("小鸟会跑");
    }

    @Override
    public void eat() {
        System.out.println("小鸟爱拉屎到肖浩锋头上吃");
    }

    @Override
    public void fly() {
        System.out.println("小鸟会飞");
    }
}
