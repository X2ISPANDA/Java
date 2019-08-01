/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.file;

import java.io.File;

/**
 * @author Mingyu Xiong
 * @description:使用面向对象统计文件夹的大小
 * @date 2019/07/29 22:45
 */
public class DirCountDemo {
    /**
     * 大小
     */
    private long len;
    /**
     * 文件夹路径
     */
    private String path;
    /**
     * 源
     */
    private File src;

    public DirCountDemo(String  path) {
        this.path = path;
        this.src = new File(path);
        count(this.src);
    }

    /**
     * Gets the value of len
     *
     * @return the value of len
     */
    public long getLen() {
        return len;
    }

    /**
     * Sets the len
     * You can use getLen() to get the value of len
     *
     * @param len len
     */
    public void setLen(long len) {
        this.len = len;
    }

    /**
     * 统计大小
     * @param src 源
     */
    private void count(File src) {
        if (null != src && src.exists()) {
            if (src.isFile()) {//获取大小
                len += src.length();
            } else {
                for (File s : src.listFiles()) {//遍历
                    count(s);
                }
            }
        }
    }

    public static void main(String[] args) {
        DirCountDemo dirCountDemo= new DirCountDemo(".");
        System.out.println(dirCountDemo.getLen());

        DirCountDemo dirCountDemo2= new DirCountDemo("C:/Users/XMY/Pictures");
        System.out.println(dirCountDemo2.getLen());
    }
}
