/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/17 14:58
 */
public class AbstractTest {
    public static void main(String[] args) {
        AbstractSonDemo 大儿子 = new AbstractSonDemo();
        大儿子.work();
        大儿子.eat();

        AbstractSon2 二儿子 = new AbstractSon2();
        二儿子.work();
        二儿子.eat();
    }
}
