/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.thread;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/01 10:08
 */
public class ThreadDemo4 implements Runnable {
    private int i;

    @Override
    public  void run() {
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+","+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+","+i);
            if (i == 20) {
                ThreadDemo4 threadDemo4 = new ThreadDemo4();
                new Thread(threadDemo4,"新线程1").start();
                new Thread(threadDemo4,"新线程2").start();
            }
        }
    }
}
