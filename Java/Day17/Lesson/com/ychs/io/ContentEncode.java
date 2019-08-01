/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.io;

import java.io.UnsupportedEncodingException;

/**
 * @author Mingyu Xiong
 * @description:字符串->字节
 * @date 2019/07/30 10:54
 */
public class ContentEncode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg = "性命 生命 使命 a";
        //编码:字节数组
        byte[] datas = msg.getBytes();
        System.out.println(datas.length);

        datas = msg.getBytes("UTF-16LE");
        System.out.println(datas.length);

        datas = msg.getBytes("GBK");
        System.out.println(datas.length);

    }
}
