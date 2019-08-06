/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.reflect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Mingyu Xiong
 * @description:读取配置文件
 * @date 2019/08/05 14:30
 */
public class ProDemo {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("user.properties"));
        String className = prop.getProperty("className");
        String method = prop.getProperty("method");
        System.out.println(className);
        System.out.println(method);

        //
    }
}
