/*
 * Copyright (c) 2019.
 * All Rights Reserved By Mingyu Xiong
 */

package com.ychs.demo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mingyu Xiong
 * @description:BinarySearch方法
 * @date 2019/07/22 15:31
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int index = Arrays.binarySearch(arr, 20);
    }
}
