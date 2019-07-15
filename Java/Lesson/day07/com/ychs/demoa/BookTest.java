/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demoa;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/15 16:41
 */
public class BookTest {
    public static void main(String[] args) {
        Book book = new Book("大话数据结构", 500);
        book.detail();
        Book book1 = new Book("阿里巴巴和四十大盗", 555, "童话");
        book1.detail();
    }
}
