package com.ychs.demo;

/**
 * @Description:类型转换
 * @Author Mingyu Xiong
 * @Date 2019/07/08 20:12
 */
public class Demo3 {
    public static void main(String[] args) {
        int i = 2147483647;
        float f = i;
        //2.14748365E9
        System.out.println(f);

        short s = 12;
        //s+1 先提升类型为整型  然后强制成short类型
        short s1 = (short) (s+1);
        //后面1是int类型
        short s2 = 56+1;

        float f1 = 3.14f;
        float f2 = (float) (f1*3.0);

        //注意char类型能参与运算
        //byte,short,char 和数字进行计算自动转换成int类型进行计算
        char c = 'A';
        c = (char) (c+1);
        System.out.println(c);
    }
}
