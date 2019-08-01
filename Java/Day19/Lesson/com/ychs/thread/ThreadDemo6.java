/*
 * Copyright (c) 2019. 
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.thread;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/01 14:15
 */
public class ThreadDemo6 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+","+i);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadDemo6(),"线程1");
        Thread thread1 = new Thread(new ThreadDemo6(),"线程2");

        //设置优先级范围是0到10
        thread1.setPriority(10);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        thread1.start();

    }
}
