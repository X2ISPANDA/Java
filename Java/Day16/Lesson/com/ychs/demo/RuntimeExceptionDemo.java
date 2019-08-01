/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

import org.apache.log4j.Logger;

/**
 * @author Mingyu Xiong
 * @description:运行时异常
 * @date 2019/07/29 13:30
 */
public class RuntimeExceptionDemo {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(RuntimeExceptionDemo.class);
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 100);
        }
        //该句运行时发生了数组索引越界异常ArrayIndexOutOfBoundsException，由于没有处理异常，导致程序无法继续执行，程序结束。
        logger.info(arr[6]);//数组下标越界，出现异常
        logger.info("over");//前面出现异常没有处理，所以这句话不会执行
    }
}
