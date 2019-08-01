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
 * @description:使用throws声明异常
 * @date 2019/07/29 14:43
 */
public class ThrowsDemo {
    public static void main(String[] args) throws IOException {
        ReadMyFile();
    }

    public static void ReadMyFile() throws IOException {
        FileReader fileReader = null;
        fileReader = new FileReader("d:/a.txt");
        char c1 = (char) fileReader.read();
        if (fileReader != null) {
            fileReader.close();
        }
    }

}

