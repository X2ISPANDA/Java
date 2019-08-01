/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.thread;

/**
 * @author Mingyu Xiong
 * @description:实现Runnable接口
 * @date 2019/08/01 09:48
 */
public class ThreadDemo2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}

class Test1 {
    public static void main(String[] args) {
        ThreadDemo2 threadDemo2 = new ThreadDemo2();
        Thread thread = new Thread(threadDemo2);
        thread.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName()+","+i);
        }
    }
}
