/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.io;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Mingyu Xiong
 * @description:字节数组输出流
 * @date 2019/07/30 22:36
 */
public class IOTest07 {
    public static void main(String[] args) {
        //1.创建源
        byte[] dest = null;
        //2.选择流(新增方法)
        ByteArrayOutputStream baos = null;
        baos = new ByteArrayOutputStream();
        //3.操作
        try {
            String msg = "Talk is cheap,show me your code";
            byte[] datas = msg.getBytes();
            baos.write(datas, 0, datas.length);
            baos.flush();
            //获取数据
            dest = baos.toByteArray();
            System.out.println(dest.length + "-->" + new String(dest, 0, baos.size()));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null == baos) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
