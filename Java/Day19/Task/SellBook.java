/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/01 09:57
 */
public class SellBook implements Runnable{

    private static int num = 10;
    @Override
    public void run() {
        while (true) {
            if (num > 0) {
                try {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName()+","+"正在卖第"+num--+"本书");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}

class TestSell{
    public static void main(String[] args) {
        SellBook sellBook = new SellBook();
        Thread thread = new Thread(sellBook);
        thread.setName("zs");
        thread.start();

        Thread thread1 = new Thread(sellBook);
        thread1.start();

    }
}
