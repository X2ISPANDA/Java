/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.pcp;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/01 16:38
 */
public class TestPCP {
    public static void main(String[] args) {
        Product p = new Product();
        //创建生产者线程
        Producer producer = new Producer();
        producer.setProduct(p);
        Thread t1 = new Thread(producer);
        //创建消费者线程
        Consumer consumer = new Consumer();
        consumer.setProduct(p);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();
    }
}
