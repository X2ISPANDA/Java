/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/24 11:32
 */
public class ColectionDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ccc");
        list.add("bbb");
        list.add("eee");
        list.add("aaa");
        list.add("bbb");
        Collections.sort(list);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -1;
            }
        });
        System.out.println(list);

        int index = Collections.binarySearch(list, "bbb");
        System.out.println(index);
        String max = Collections.max(list);
        System.out.println(max);

        Collections.shuffle(list);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);

    }
}
