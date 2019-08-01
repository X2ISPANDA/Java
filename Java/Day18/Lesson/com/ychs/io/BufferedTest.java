/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.io;

import java.io.*;

/**
 * @author Mingyu Xiong
 * @description:缓冲流
 * @date 2019/07/31 13:26
 */
public class BufferedTest {
    public static void main(String[] args) {
        copy("C:/Users/XMY/Pictures/Snipaste_2019-06-26_22-44-44.png", "dest.png");
    }

    /**
     * 文件的拷贝
     * @param srcPath 文件源
     * @param descPath 目的文件路径
     */
    public static void copy(String srcPath,String descPath) {
        //1.创建源
        File src = new File(srcPath);
        File dest = new File(descPath);
        //2.选择流
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new BufferedInputStream(new FileInputStream(src));
            os= new BufferedOutputStream(new FileOutputStream(dest));
            //3.操作
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                os.write(flush, 0,len);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.释放资源,先打开的后关闭
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
