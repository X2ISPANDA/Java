/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.io;

import java.io.*;

/**
 * @author Mingyu Xiong
 * @description:字节数组输入流
 * @date 2019/07/30 22:24
 */
public class IOTest06 {
    public static void main(String[] args) {
        //1.创建源
        byte[] src = "Talk is cheap,show me your code".getBytes();
        //2.选择流
        InputStream is = null;
        try {
            is= new ByteArrayInputStream(src);
            //3.操作
            byte[] flush = new byte[5];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                String str = new String(flush, 0, len);
                System.out.println(str);
            }
        }  catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != is) {
                try {
                    is.close();//没有任何实现
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
