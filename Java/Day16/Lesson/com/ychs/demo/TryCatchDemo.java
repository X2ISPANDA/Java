/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Mingyu Xiong
 * @description:使用try-catch捕获异常
 * @date 2019/07/29 14:25
 */
public class TryCatchDemo {
    public static void main(String[] args) {
        ReadMyFile();
    }

    public static void ReadMyFile() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("d:/a.txt");
            char c1 = (char) fileReader.read();
            System.out.println(c1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件没有找到的异常");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO流异常");
        }finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
