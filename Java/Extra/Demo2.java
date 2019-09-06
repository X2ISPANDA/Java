/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

/**
 * @author Mingyu Xiong
 * @description:测试赋值语句返回值
 * @date 2019/08/13 02:32
 */
public class Demo2 {
    public static void main(String[] args) {
        System.out.println(test(5));
    }
    //返回值即为赋值语句右边的值
    public static int test(int i) {
        return i=3;
    }
}
