/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo.set;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/24 16:27
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet set = new TreeSet();
        set.add("aaa");
        set.add("bbb2");
        set.add("ccc3");
        set.add("ddd4");
        for (Object o : set) {
            System.out.println(o);
        }

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
