/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.test;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/16 10:19
 */
public class Demo01 {
    private String sno;
    private String sname;

    public Demo01() {
        this("1002","肖浩锋");
        System.out.println("无参的构造方法");
    }

    public Demo01(String sno, String sname) {
        //this()调用的午餐的构造方法，必须放在第一行
        //this();
        this.sno = sno;
        this.sname = sname;
        System.out.println("有参的构造方法");
    }

    public static void main(String[] args) {
        Demo01 demo01 = new Demo01("1001","张三");
    }
}
