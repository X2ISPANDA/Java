/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/01 15:30
 */
public class MoneyDemo implements Runnable{
    private int money = 5000;


    @Override
    public void run() {
        while (true) {
            synchronized (MoneyDemo.class) {
                if (money > 0) {
                    money -= 100;
                    System.out.println(Thread.currentThread().getName() + "取走了一百元,还剩" + money);
                }
            }
        }
    }
}

class MoneyTest {
    public static void main(String[] args) {
        MoneyDemo moneyDemo = new MoneyDemo();
        Thread thread = new Thread(moneyDemo, "甲拿着卡");
        Thread thread1 = new Thread(moneyDemo, "乙拿着存折");

        thread.start();
        thread1.start();
    }
}
