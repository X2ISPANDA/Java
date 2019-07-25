/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/25 11:29
 */
public class TestPerson {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        Person person = new Person("zs", 12);
        Person person1 = new Person("ls", 15);
        Person person2 = new Person("ww", 16);
        list.add(person);
        list.add(person1);
        list.add(person2);
        Collections.sort(list);
        System.out.println(list);
    }
}
