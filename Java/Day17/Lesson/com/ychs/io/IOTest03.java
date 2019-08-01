/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.io;

import java.io.*;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/30 17:27
 */
public class IOTest03 {
    public static void main(String[] args) {
        //1.创建源
        File dest = new File("dest.txt");
        //2.选择流
        OutputStream os = null;
        try {
            os= new FileOutputStream(dest,false);
            //3.操作
            String msg = "IO is so difficult";
            byte[] datas = msg.getBytes();//字符串->字节数组(编码)
            os.write(datas, 0, datas.length);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
