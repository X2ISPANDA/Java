/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.io;

import java.io.*;

/**
 * @author Mingyu Xiong
 * @description:文件字符输入流
 * @date 2019/07/30 20:20
 */
public class IOTest04 {
    public static void main(String[] args) {
        //1.创建源
        File src = new File("abc.txt");
        //2.选择源
        Reader reader = null;
        try {
            reader = new FileReader(src);
            //3.操作(读取)
            char[] flush = new char[1024];
            int len = -1;
            while ((len = reader.read(flush)) != -1) {
                String str = new String(flush, 0, len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4.释放资源
            try {
                if (null != reader) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
