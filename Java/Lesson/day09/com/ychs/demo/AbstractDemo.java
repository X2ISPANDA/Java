/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/17 14:49
 */
public abstract class AbstractDemo {
    //抽象方法:只有方法的声明没有方法体

    public AbstractDemo() {
        System.out.println("抽象父类的构造方法");
    }

    /**
     * 工作抽象方法
     */
    public abstract void work();

    public void eat() {
        System.out.println("食屎啦你");
    }

}
