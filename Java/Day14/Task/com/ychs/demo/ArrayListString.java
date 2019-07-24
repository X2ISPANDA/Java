/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/24 09:58
 */
public class ArrayListString {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = (String) iterator.next();
            System.out.println(s);
        }

    }
}
