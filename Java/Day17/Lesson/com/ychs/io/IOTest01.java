/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.io;

import java.io.*;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/30 16:57
 */
public class IOTest01 {
    public static void main(String[] args) {
        //1.创建源
        File src = new File("E:/repo/Java1014/Java/Day17/abc.txt");
        //2.选择源
        InputStream is = null;
        try {
            is = new FileInputStream(src);
            //3.操作(读取)
            int temp;
            while ((temp = is.read()) != -1) {
                System.out.println((char)temp);
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
