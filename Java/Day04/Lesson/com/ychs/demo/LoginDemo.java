/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

import java.util.Scanner;

/**
 * @Description:
 * @Author Mingyu Xiong
 * @Date 2019/07/10 16:37
 */
public class LoginDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String username = "admin";
        String password = "123456";
        System.out.print("请输入用户名：");
        String name = sc.nextLine();
        System.out.print("请输入密码：");
        String pwd = sc.nextLine();


        //==只可以比较基本的数据类型，否则比较的是在内存中的地址
//        if (name == username && pwd == password) {
//            System.out.println("success");
//        } else {
//            System.out.println("fail");
//        }

        System.out.println(name);
        System.out.println(pwd);
        if (name.equals(username) && pwd.equals(password)) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
    }
}
