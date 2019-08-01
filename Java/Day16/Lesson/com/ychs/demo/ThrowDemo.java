/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:使用throws声明异常
 * @date 2019/07/29 14:03
 */
public class ThrowDemo {
    public void show(int x) throws Exception {
        if (x > 0) {
            throw new Exception();
        } else {
            System.out.println("show run");
        }
    }
    public static int getElement(int[] arr,int index) throws NullPointerException, ArrayIndexOutOfBoundsException {
        if(arr==null){
            throw new NullPointerException("arr指向的数组不存在");
        }
        if(index<0 || index>=arr.length){
            throw new ArrayIndexOutOfBoundsException("错误的角标，"+index+"索引在数组中不存在");
        }
        int element = arr[index];
        return element;
    }
}
