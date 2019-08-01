/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:已检查异常
 * @date 2019/07/29 13:23
 */
public class CheckedDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
    }
}
