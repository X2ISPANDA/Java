/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.thread;

/**
 * @author Mingyu Xiong
 * @description:线程的匿名内部类的写法
 * @date 2019/08/01 11:01
 */
public class ThreadDemo5 {
    public static void main(String[] args) {
        //第一种方式
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }
            }
        }.start();

        //第二种方式
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 15; i++) {
                    System.out.println("-"+i);
                }
            }
        }).start();


    }
}
