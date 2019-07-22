/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:正则表达式
 * @date 2019/07/22 15:25
 */
public class RegexDemo {
    public static void main(String[] args) {
        String phone = "18374201517";
        System.out.println(phone.matches("1[345789]\\d{9}"));
        String s = "abc abc def";
        String[] s1 = s.split(" ");
        for (String s2 : s1) {
            System.out.println(s2);
        }

        String str2 = "hello12324world4546";
        String replace = str2.replace("12324", "*");
        String replaceAll = str2.replaceAll("\\d", "*");
        System.out.println(replace);
        System.out.println(replaceAll);

    }
}
