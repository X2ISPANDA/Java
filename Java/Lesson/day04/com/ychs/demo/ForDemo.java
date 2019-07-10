/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @Description:For循环实现1加到100
 * @Author Mingyu Xiong
 * @Date 2019/07/10 14:24
 */
public class ForDemo {
    public static void main(String[] args) {
        int i = 1;
        int sum = 0;

        //循環的條件必須返回的是boolean表達式
        for (;;) {
            if (i > 100) {
                break;
            }
            sum += i;
            i++;
        }
        System.out.println(sum);
        for (i = 1, sum = 0; i < 100 && sum < 4000; i++) {

        }
    }
}
