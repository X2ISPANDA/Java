/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo.arraylist;

import java.util.Arrays;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/24 14:10
 */
public class Demo {
    public static void main(String[] args) {
        String[] i = {"aaa","sss","ddd"};

        //数组--->>List
        List<String> list = Arrays.asList(i);
        for (int j = 0; j < list.size(); j++) {
            System.out.println(list.get(j));
        }

        //list-->>数组
        String[] array = (String[]) list.toArray();

        System.out.println(Arrays.toString(array));

    }
}
