/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.thread;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/01 14:38
 */
public class TicketDemo implements Runnable{

    private int ticket = 20;
    @Override
    public void run() {
        while (true) {
            sell();
        }
    }

    public synchronized void sell() {
        if (ticket > 0) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在卖" + ticket-- + "票");
        }
    }
}

class TicketTest{
    public static void main(String[] args) {
        TicketDemo ticketDemo = new TicketDemo();
        Thread thread1 = new Thread(ticketDemo, "窗口1");
        Thread thread2 = new Thread(ticketDemo, "窗口2");
        Thread thread3 = new Thread(ticketDemo, "窗口3");
        Thread thread4 = new Thread(ticketDemo, "窗口4");
        Thread thread5 = new Thread(ticketDemo, "窗口5");
        Thread thread6 = new Thread(ticketDemo, "窗口6");
        Thread thread7 = new Thread(ticketDemo, "窗口7");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
    }
}