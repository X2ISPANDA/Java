/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.thread;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/01 15:12
 */
public class TicketDemo1 implements Runnable{

    private int ticket = 20;

    private Object lock = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(5000);
                        System.out.println(Thread.currentThread().getName() + "正在卖" + ticket-- + "票");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class TicketTest1{
    public static void main(String[] args) {
        TicketDemo1 ticketDemo1 = new TicketDemo1();
        Thread thread1 = new Thread(ticketDemo1, "窗口1");
        Thread thread2 = new Thread(ticketDemo1, "窗口2");
        Thread thread3 = new Thread(ticketDemo1, "窗口3");
        Thread thread4 = new Thread(ticketDemo1, "窗口4");
        Thread thread5 = new Thread(ticketDemo1, "窗口5");
        Thread thread6 = new Thread(ticketDemo1, "窗口6");
        Thread thread7 = new Thread(ticketDemo1, "窗口7");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
    }
}
