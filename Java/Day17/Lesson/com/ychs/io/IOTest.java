/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.io;

import java.io.*;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/30 16:48
 */
public class IOTest {
    public static void main(String[] args) {
        //1.创建源
        File src = new File("E:/repo/Java1014/Java/Day17/abc.txt");
        //2.选择源
        try {
            InputStream is = new FileInputStream(src);
            //3.操作(读取)
            int data1 = is.read();
            int data2 = is.read();
            int data3 = is.read();
            int data4 = is.read();//????不是数据,文件的末尾返回-1
            System.out.println((char)data1);
            System.out.println((char)data2);
            System.out.println((char)data3);
            System.out.println(data4);
            //4.释放资源
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
