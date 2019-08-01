/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.file;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

/**
 * @author Mingyu Xiong
 * @description:创建目录及遍历
 * @date 2019/07/29 19:22
 */
public class DirDemo {
    public static void main(String[] args) {
        File dir = new File(".");
        System.out.println();
        //创建目录,推荐使用mkdirs(),一劳永逸
        boolean flag = dir.mkdirs();
        System.out.println(flag);

        //列出下级名称
        String[] subNames = dir.list();
        for (String s : subNames) {
            System.out.println(s);
        }

        //下级对象
        File[] subFiles = dir.listFiles();
        for (File file : subFiles) {
            System.out.println(file.getAbsolutePath());
        }

        //所有盘符
        File[] roots = File.listRoots();
        for (File root : roots) {
            System.out.println(root.getAbsolutePath());
        }

        printName(dir);
        count(dir);
        System.out.println(len);

    }

    //递归遍历文件夹所有文件
    public static void printName(File src) {
        if (src.isFile()) {
            System.out.println(src.getName());
        }

        /*File[] dir = src.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".html");
            }
        });*/

/*        File[] dir = src.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).isDirectory() || name.toLowerCase().endsWith(".html");
            }
        });*/

        /**
         * 使用lambda表达式优化匿名内部类(接口中只有一个抽象方法)
         */
/*        File[] dir = src.listFiles((File d, String name) ->{
            return new File(d, name).isDirectory() || name.toLowerCase().endsWith(".html");
        });*/


        File[] dir = src.listFiles((d, name) -> new File(d, name).isDirectory() || name.toLowerCase().endsWith(".html"));
        if (null == src || !src.exists()) {
            return;
        } else if (src.isDirectory()) {
            for (File s : dir) {
                printName(s);
            }
        }
    }

    private static long len = 0;
    //统计文件夹的大小
    public static void count(File src) {
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

}
