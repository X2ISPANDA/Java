/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.exercise;

import java.io.*;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/01 22:48
 */
public class Demo {
    public static void main(String[] args) {
        File src = new File("aaa.txt");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(src);
            String msg = "这是我的IO流测试";
            byte[] datas = msg.getBytes();
            fos.write(datas);
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}