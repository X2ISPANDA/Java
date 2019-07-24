/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo.LinkList;

import com.ychs.demo.Student;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/24 14:34
 */
public class LinkListDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("aaa");
        list.add("bbb");
        list.addFirst("ccc");
        list.addLast("ddd");
        list.add("eee");
        System.out.println(list);
        System.out.println(list.get(2));
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.remove());
        System.out.println(list);

        LinkedList<Student> linkedList = new LinkedList<>();
        Student stu = new Student();
        stu.setNo("808");
        stu.setName("公交车");
        linkedList.add(stu);
        Student stu1 = new Student();
        stu1.setNo("801");
        stu1.setName("红花会");
        linkedList.add(stu1);
        System.out.println(linkedList);
        System.out.println("==========================================");

        //LinkedList-->ArrayList 通过构造方法转换
        ArrayList<String> list1 = new ArrayList<>(list);
        System.out.println(list1);
        list1.addAll(list);
        System.out.println(list1);

        //ArrayList-->LinkedList
        LinkedList<String> list2 = new LinkedList<>(list1);
        System.out.println(list2);
        list2.addAll(list1);
        System.out.println(list2);
    }
}
