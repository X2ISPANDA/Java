/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/24 16:11
 */
public class LinkedHasSetDemo {
    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("aaa");
        set.add("bbb2");
        set.add("ccc3");
        set.add("ddd4");
        System.out.println(set);

        ArrayList<String> list = new ArrayList<>(set);
        System.out.println(list);
        list.addAll(set);
        System.out.println(list);

        HashSet<String> set1 = new HashSet<>(list);
        System.out.println(set1);
        set1.addAll(list);
        System.out.println(set1);
    }
}
