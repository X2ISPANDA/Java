/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/01 17:04
 */
public class WangzaiDemo implements Runnable{
    private int mantou = 0;


    @Override
    public void run() {
        while (true) {
                eat();
        }
    }

    public  void eat() {
        if (mantou < 100) {
            System.out.println(Thread.currentThread().getName() + "正在吃第" + ++mantou + "个馒头");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MantouTest {
    public static void main(String[] args) {
        WangzaiDemo wangzaiDemo = new WangzaiDemo();
        for (int i = 1; i <= 100; i++) {
            Thread thread = new Thread(wangzaiDemo,"第"+i+"个人");
            thread.start();
        }

    }
}
