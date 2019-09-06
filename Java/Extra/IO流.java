/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

import java.io.*;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/08 09:55
 */
public class IO流 {
    public static void main(String[] args) throws IOException {
        //1.创建源
        File file = new File("aaa.txt");
        //2.选择源
        OutputStream outputStream = new FileOutputStream(file, false);
        //3.操作
        String content = "HioHop";
        byte[] bytes = content.getBytes();
        outputStream.write(bytes, 0, bytes.length);
        outputStream.flush();
        outputStream.close();

    }
}
