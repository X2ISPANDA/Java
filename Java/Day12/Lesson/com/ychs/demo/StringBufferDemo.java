package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:StringBuffer的使用
 * @date 2019/07/22 11:42
 */
public class StringBufferDemo {
    public static void main(String[] args) {
        //用构造方法直接定义一个字符串缓冲区
//		StringBuffer sb = new StringBuffer();
//		StringBuffer sb = new StringBuffer("abc");
        StringBuilder sb = new StringBuilder("abc");

        sb.append("abc");
        sb.append("def");
        sb.append("ghi").append("123456").append("789");
        System.out.println(sb);
        sb.insert(3, "我是一个字符串缓冲区");
        System.out.println(sb);
        sb.deleteCharAt(3);
        System.out.println(sb);
        sb.delete(3, 4);
        System.out.println(sb);
        sb.replace(3, 5, "我是要替换的字符串");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        String str = sb.substring(5);
        System.out.println(str);
        System.out.println(sb);
        String str2 = sb.substring(3, 10);
        System.out.println(str2);
        System.out.println(sb);
    }
}
