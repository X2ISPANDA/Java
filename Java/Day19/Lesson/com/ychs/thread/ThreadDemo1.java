/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.thread;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/01 09:28
 */
public class ThreadDemo1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+","+i);
        }
    }
}

class Test{
    public static void main(String[] args) {
        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        threadDemo1.start();//启动线程,自动调用里面的run方法
        threadDemo1.run();//直接调用run方法是相当于普通方法的调用,并没有开启一个线程

        for (int i = 0; i < 100; i++) {
            //Thread.currentThread() 获取党强线程
            // getName() 获取线程名称
            System.out.println(Thread.currentThread().getName()+","+i);
        }
    }
}