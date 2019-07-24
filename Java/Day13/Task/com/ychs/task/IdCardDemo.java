/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.task;

import java.util.Scanner;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/23 23:54
 */
public class IdCardDemo {
    public static void main(String[] args) {
        System.out.println("请输入你的身份证号");
        Scanner sc =new Scanner(System.in);
        String str = sc.nextLine();
        String b;
        b=str.substring(6,10);
        System.out.println(b);
        Integer x =Integer.valueOf(b);
        if(x>2001) {
            System.out.println("未成年");
        }
        else {
            System.out.println(2019-x);
        }
    }
}
