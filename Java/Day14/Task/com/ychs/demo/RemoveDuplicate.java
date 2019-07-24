/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/24 16:38
 */
public class RemoveDuplicate {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("121");
        list.add("2111");
        list.add("111");
        System.out.println(list);

        HashSet hashSet = new HashSet(list);
        List list1 = new ArrayList(hashSet);
        System.out.println(list1);
    }
}
