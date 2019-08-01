/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.file;

import java.io.File;

/**
 * @author Mingyu Xiong
 * @description:File类常用API
 * @date 2019/07/29 15:51
 */
public class GetDemo {
    public static void main(String[] args) {
        File src = new File("C:/Users/XMY/Pictures/Snipaste_2019-06-26_22-44-44.png");
        System.out.println("名称:" + src.getName());
        System.out.println("路径:" + src.getPath());
        System.out.println("绝对路径:" + src.getAbsolutePath());
        System.out.println("父路径:" + src.getParent());

        System.out.println("是否存在:" + src.exists());
        System.out.println("是否是文件:" + src.isFile());
        System.out.println("是否是文件夹:" + src.isDirectory());

        src = new File("xxx");
        if (null == src ||!src.exists()) {
            System.out.println("文件不存在");
        } else {
            if (src.isFile()) {
                System.out.println("文件操作");
            } else {
                System.out.println("文件夹操作");
            }
        }

        System.out.println("长度:"+src.length());

    }
}
