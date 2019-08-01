/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.pcp;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/01 16:16
 */
public class Product {
    private int num = 0;

    //生产者往仓库放东西
    public synchronized void put() {
        if (num == 10) {
            try {
                System.out.println("仓库已满...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num++;
        System.out.println("生产产品之后的当前库存数" + num);
        notifyAll();//唤醒所有等待的线程
    }

    public synchronized void get() {
        if (num == 0) {
            System.out.println("仓库没东西,消费者需要等待");
        }
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num--;
        System.out.println("消费产品之后当前的库存数" + num);
        notifyAll();
    }
}
