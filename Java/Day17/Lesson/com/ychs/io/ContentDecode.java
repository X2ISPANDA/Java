/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.io;

import java.io.UnsupportedEncodingException;

/**
 * @author Mingyu Xiong
 * @description:解码
 * @date 2019/07/30 11:00
 */
public class ContentDecode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg = "性命使命生命a";
        byte[] datas = msg.getBytes();
        msg = new String(datas, 0, datas.length, "utf8");
        System.out.println(msg);

    }
}
