/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo.set;

import java.awt.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/24 15:13
 */
public class Demo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("aaa");
        set.add("bbb2");
        set.add("ccc3");
        set.add("ddd4");
        System.out.println(set);
        System.out.println("集合的大小:" + set.size());
        set.remove("ccc3");
        System.out.println(set);
        System.out.println(set.contains("eee"));
        System.out.println(set.isEmpty());
//        set.clear();
//        System.out.println(set.isEmpty());
        for (String s : set) {
            System.out.print(s+"");
        }
        System.out.println();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String s1 = iterator.next();
            System.out.print(s1+" ");
        }
    }
}
