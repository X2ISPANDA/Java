/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.io;

import java.io.*;

/**
 * @author Mingyu Xiong
 * @description:文件字符输出流
 * @date 2019/07/30 20:49
 */
public class IOTest05 {
    public static void main(String[] args) {
        //1.创建源
        File dest = new File("dest.txt");
        //2.选择流
        Writer writer = null;
        try {
            writer= new FileWriter(dest);
            //3.操作
            //写法一
//            String msg = "IO is so difficult,欢迎你";
//            char[] datas = msg.toCharArray();//字符串->字符数组(编码)
//            writer.write(datas, 0, datas.length);
            //写法二
//            String msg = "中北大学欢迎你";
//            writer.write(msg);
//            writer.write("add");
//            writer.flush();
            //写法三
            writer.append("IO is so difficult").append("你好菜啊");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != writer) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
