/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:final關鍵字的作用
 * @date 2019/07/17 09:19
 */
public final class FinalDemo1 {
    //常量一般定义：public static final double PI = 3.14
    private final double PI = 3.14;

    private final int[] a= {1,3,4};

    /**
     * 修改PI的值
     */
    public void edit() {
//        PI = 3.1415;
        a[0]=5;
    }

}

//class superFinal extends FinalDemo1 {
//
//}