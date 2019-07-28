/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/25 20:26
 */
public class Demo {
    //懒汉模式
    private static Demo demo;

    private Demo() {

    }

    public static Demo getInstance() {
        if (demo == null) {
            new Demo();
        }
        return demo;
    }
}
//饿汉模式
class Demo1 {
    private static Demo1 demo1 = new Demo1();

    private Demo1() {

    }

    public static Demo1 getInstance() {
        return demo1;
    }
}
