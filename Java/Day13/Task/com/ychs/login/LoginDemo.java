/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.login;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/24 11:48
 */
public class LoginDemo {
    public static void main(String[] args) {

        User user = new User();
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        String password = sc.nextLine();
        if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
            long a = System.currentTimeMillis();
            Date date = new Date();
            DateFormat df = new SimpleDateFormat("yyyy年 hh时mm分");
            String str = df.format(date);
            System.out.println("欢迎" + username + "用户登录系统，系统当前时间为：" + str);


            System.out.println("是否退出系统，退出请输入0");
            int i = sc.nextInt();
            if (i == 0) {
                long b = System.currentTimeMillis();
                int c = (int) ((b - a) / 60000);
                if (c <= 0) {
                    c = c + 1;
                }
                System.out.println("您在线时间为：" + c + "分钟");
            } else {
                System.out.println("无效字符");
            }
        }
    }

}

