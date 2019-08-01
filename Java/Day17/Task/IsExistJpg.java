/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

import java.io.File;

/**
 * @author Mingyu Xiong
 * @description:判断当前目录是否存在后缀名为.html的文件
 * @date 2019/07/30 07:10
 */
public class IsExistJpg {
    public static void main(String[] args) {
        File src = new File("E:/Usual");
        judge(src);

    }

    public static void judge(File src) {
        if (src != null && src.exists()) {
            if (src.isFile()) {
                if (src.getName().endsWith(".html")) {
                    System.out.println(src.getName());
                    ;
                }
            } else {
                for (File s : src.listFiles()) {
                    judge(s);
                }
            }
        }
    }
}
