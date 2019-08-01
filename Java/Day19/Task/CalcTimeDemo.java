/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/01 21:15
 */
public class CalcTimeDemo {
    /**
     * 倒计时
     * @param time 计时时间
     */
    void RunTime(int time){
        int i = 0 ;
        new Thread().start();
        while (i<time) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(i>=time){
            System.out.println("执行....");
        }
    }
}

 class CalculaThread extends Thread {

    public static void main(String[] args) {
        new CalcTimeDemo().RunTime(20);
        new CalculaThread().start();
    }

    private long now = 0L;

    private long start = System.currentTimeMillis();// 程序启动时间的毫秒值

    private long time;

    @Override
    public void run() {
        while (true) {
            now = System.currentTimeMillis();// 获取一秒之后的毫秒值
            time = now - start;// 两个时间相减的到毫秒差
            System.out.format("%02d:%02d:%02d\n",
                    time / (1000 * 60 * 60) % 60/* 时 */,
                    time / (1000 * 60)% 60/* 分 */,
                    time / 1000 % 60/* 秒 */);// 格式化字符串输出
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
