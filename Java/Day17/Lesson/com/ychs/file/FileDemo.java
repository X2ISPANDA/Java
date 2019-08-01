/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.file;

import java.io.File;
import java.io.IOException;

/**
 * @author Mingyu Xiong
 * @description:构建File对象
 * @date 2019/07/29 15:33
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\XMY\\Pictures\\Snipaste_2019-06-26_22-44-44.png";
        //构建File对象1
        File src = new File(path);
        System.out.println(src.length());
        //构建File对象2
        src = new File("C:\\Users\\XMY\\Pictures", "Snipaste_2019-06-26_22-44-44.png");
        src = new File("C:\\Users", "XMY\\Pictures\\Snipaste_2019-06-26_22-44-44.png");
        System.out.println(src.length());
        //构建File对象3
        src = new File(new File("C:\\Users\\XMY\\Pictures"), "Snipaste_2019-06-26_22-44-44.png");
        System.out.println(src.length());
        System.out.println(src.getAbsolutePath());

        src = new File("Snipaste_2019-06-26_22-44-44.png");
        System.out.println(src.length());
        System.out.println(src.getAbsolutePath());

        boolean flag = src.createNewFile();
        System.out.println(flag);
        flag = src.delete();
        System.out.println(flag);

    }
}
