/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

import org.apache.log4j.Logger;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/29 13:25
 */
public class UnchekedDemo {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(UnchekedDemo.class);
        String str = "yckj";
        logger.info(str);
        int age = 0;
        try {
            //数据类型转换,出现异常不做异常处理程序会终止，后面的代码不会执行
            age = Integer.parseInt("20L");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        logger.info(age);
        logger.info(str);
    }

}
