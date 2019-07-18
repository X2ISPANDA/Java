/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demoa;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/15 16:11
 */
public class StaticDemo {

    static {//加载类模板时运行，只运行一次
        System.out.println("bbbbbbbb");
    }

    public StaticDemo() {
        System.out.println("ccccccccc");
    }

    {//会自动加进构造方法内运行
        System.out.println("aaaaaaaaa");
    }


    public static void main(String[] args) {
        StaticDemo staticDemo = new StaticDemo();
        StaticDemo staticDemo1 = new StaticDemo();
    }
}
