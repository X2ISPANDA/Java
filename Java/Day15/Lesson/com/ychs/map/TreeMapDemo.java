/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.map;

import com.ychs.comparable.Person;
import com.ychs.task.Student;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/25 14:32
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("aaa", 1);
        map.put("bbb", 2);
        map.put("ccc", 3);
        TreeMap<Person, String> stuMap = new TreeMap<>();
        stuMap.put(new Person("zs",1), "zs");
        stuMap.put(new Person("zs",1), "zs");
        stuMap.put(new Person("zs",1), "zs");

        TreeMap<Person, String> personStringTreeMap = new TreeMap<>(Comparator.comparing(person -> person.getAge()));

    }
}
