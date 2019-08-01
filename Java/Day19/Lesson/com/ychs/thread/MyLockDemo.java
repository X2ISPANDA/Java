/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.thread;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/01 15:41
 */
public class MyLockDemo implements Runnable {

    private Object lockA = new Object();
    private Object lockB = new Object();

    private int i = 0;
    @Override
    public void run() {
        while (true) {
            if (i % 2 == 0) {
                synchronized (lockA) {
                    System.out.println("我拿了A锁,接着去拿B锁");
                    synchronized (lockB) {
                        System.out.println("我拿上了B锁");
                        System.out.println("执行我的代码");
                    }
                }
            } else {
                synchronized (lockB) {
                    System.out.println("我先拿了B锁,接着去拿A锁");
                    synchronized (lockA) {
                        System.out.println("我拿上了B锁");
                        System.out.println("不执行我的代码");
                    }
                }
            }
            i++;
        }
    }
}

class TestLock {
    public static void main(String[] args) {
        MyLockDemo myLockDemo = new MyLockDemo();
        Thread t1 = new Thread(myLockDemo);
        Thread t2 = new Thread(myLockDemo);

        t1.start();
        t2.start();
    }
}
