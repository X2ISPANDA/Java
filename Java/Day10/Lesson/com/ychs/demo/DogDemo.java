/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/18 17:31
 */
public class DogDemo implements IAnimalDemo {

    @Override
    public void show() {
        System.out.println("狗");

    }
    public void bark() {
        System.out.println("狗吠。。。");
    }
}
