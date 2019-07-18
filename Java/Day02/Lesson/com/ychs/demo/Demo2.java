package com.ychs.demo;

/**
 * @Description:测试以下代码是否编译通过
 * @Author Mingyu Xiong
 * @Date 2019/07/08 18:56
 */
public class Demo2 {
    public static void main(String[] args) {
        byte b1 = 12;
        byte b2 = 1;
        byte b3 = (byte)(b1+b2);
//		byte b4 = 128;

        short s1 = 78;
        short s2 = 1;
//		short s3 = s1+s2;

        System.out.println(3+1);

        //定义一个long类型一般需要加L或l
        long l1 = 123;
        long l2 = 2147483648L;
        System.out.println(l2);
        System.out.println(20+5L);

//		float f1 = 3.14;
        float f2 = 8.6f;

        float x = 3.14f , y = 3.14f , z = 3.14f;
        System.out.println(x);

        char c = 97;
        System.out.println(c);
        int i = 'A';
        System.out.println(i);
        System.out.println("==========");
        System.out.println("输出");
        System.out.print("我是\"换行\n转义");
        char c4='\u0011';
        System.out.println(c4);

        boolean b = true;


    }
}
