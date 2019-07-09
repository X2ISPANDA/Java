package com.ychs.demo;

/**
 * @Description:完成两个数的交换
 * @Author Mingyu Xiong
 * @Date 2019/07/09 09:41
 */
public class Exchange {
    public static void main(String[] args) {
        //用中间变量
        int i = 3;
        int j = 4;
        int k;
        k = i;
        i = j;
        j = k;

        //不用中间变量
        int a = 3;
        int b = 4;
        a = a + b;
        b = a - b;
        a = a - b;


    }
}
