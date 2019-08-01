/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.io;

import java.io.*;

/**
 * @author Mingyu Xiong
 * @description:分段读取
 * @date 2019/07/30 17:06
 */
public class IOTest02 {
    public static void main(String[] args) {
        //1.创建源
        File src = new File("E:/repo/Java1014/Java/Day17/abc.txt");
        //2.选择源
        InputStream is = null;
        try {
            is = new FileInputStream(src);
            //3.操作(分段读取)
            byte[] car = new byte[1024*10];//缓冲容器,10K,不要算出来,可读性
            int len = -1;//接收长度
            while ((len = is.read(car)) != -1) {
                //字节数组->字符串(解码)
                String str = new String(car,0,len);
                System.out.print(str+" ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4.释放资源
            try {
                if (null != is) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

