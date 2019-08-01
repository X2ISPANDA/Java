/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.io;

import java.io.*;

/**
 * @author Mingyu Xiong
 * @description:图片读取到字节数组,字节数组写出到文件
 * @date 2019/07/30 23:08
 */
public class IOTest08 {
    public static void main(String[] args) {
        //图片转成字节数组
        byte[] datas = fileToByteArray("dest.png");
        System.out.println(datas.length);
        byteArrayToFile(datas,"copy.png");
    }

    /**
     *
     * @param filepath
     * @return
     */
    public static byte[]fileToByteArray(String filepath) {
        //1.创建源
        File src = new File(filepath);
        byte[] dest = null;
        //2.选择源
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        baos = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(src);
            //3.操作(分段读取)
            byte[] flush = new byte[1024*10];//缓冲容器,10K,不要算出来,可读性
            int len = -1;//接收长度
            while ((len = is.read(flush)) != -1) {
                //字节数组->字符串(解码)
                baos.write(flush, 0, len);
            }
            baos.flush();
            return baos.toByteArray();
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
        return null;
    }

    /**
     * 2.字节数组写出到图片
     * 1)字节数组到程序
     * 2)程序到文件
     * @param src
     * @param filepath
     */
    public static void byteArrayToFile(byte[] src,String filepath) {
        //1.创建源
        File dest = new File(filepath);
        //2.选择流
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new ByteArrayInputStream(src);
            os = new FileOutputStream(dest);
            //3.操作
            byte[] flush = new byte[5];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                os.write(flush, 0, len);
            }
            os.flush();
        }  catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != os) {
                try {
                    os.close();//没有任何实现
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
