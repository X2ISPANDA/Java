/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @Description:数组初始化
 * @Author Mingyu Xiong
 * @Date 2019/07/11 11:31
 */
public class ArrayInit {
    public static void main(String[] args) {
        //定义一个数组方式一
        int[] a = new int[]{1,2,3,5,6};
        //定义一个数组方式二
        String[] s = {"aaa", "bbb", "ccc"};
        //定义一个数组方式三
        int[] b = new int[5];
        b[0] = 9;
        b[1] = 9;
        b[2] = 8;

        Person[] p = new Person[5];
        Person zs = new Person();
        Person ls = new Person();
        p[0] = zs;
        p[1] = ls;

        System.out.println(b[6]);//ArrayIndexOutOfBoundsException数组下标越界异常

        //遍历数组
        for (int i = 0; i < b.length; i++) {
            System.out.println(a[i]);
        }

        //增强型for循环遍历数组
        for (int i : b) {
            System.out.println(i);
        }

        for (Person person : p) {

        }

        for (Person per : p) {

            System.out.println(per);

        }


        //iter增强型for循环快捷键
        //itar普通for循环遍历快捷键
        int d[];

    }
}
