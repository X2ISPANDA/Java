package com.ychs.demo;

import java.util.Locale;

public class StringDemo {
    public static void main(String[] args) {
        //创建一个字符串
        String str = "abc";
        String str2 = new String("abcdefabcghijk");
        System.out.println("长度："+str.length());
        //截取字符串
        System.out.println(str2.substring(2));
        System.out.println(str2.substring(2,4));
        System.out.println(str2.substring(2,str2.length()-1));
        //是否以某字符串开始
        System.out.println(str2.startsWith("abc"));
        System.out.println(str2.endsWith("jk"));
        //判断包含字符串
        System.out.println(str2.indexOf("fabc"));
        System.out.println(str2.contains("fab"));
        System.out.println(str2.toCharArray());
        byte[] bytes = str2.getBytes();
        for (byte aByte : bytes) {
            System.out.println((char)aByte);
        }
        String str3 = "   abc  def abv   ";
        String date = "19811004";
        System.out.println(str3.trim());

        System.out.println(String.format(Locale.CHINA,"20190929,%s",date));

        System.out.println("abcdef\nabcdef");
        System.out.println("abcdef\\abcdef");





    }
}
