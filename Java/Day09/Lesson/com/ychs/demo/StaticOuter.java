/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/17 11:17
 */
public class StaticOuter {
    public static class StaticInner {
        private int i = 3;

        public void show() {
            System.out.println("静态内部类的普通方法"+i);
        }

        public static void display() {
            System.out.println("静态内部类的静态方法");
        }
    }

    public static void main(String[] args) {
        //访问静态内部类的普通方法
        StaticOuter.StaticInner inner = new StaticInner();
        inner.show();

        StaticOuter.StaticInner.display();
    }
}
