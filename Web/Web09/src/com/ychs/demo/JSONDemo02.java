/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/12/21 15:09
 */
public class JSONDemo02 {
    public static void main(String[] args) {
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("zs");
        jsonArray.add(10);
        System.out.println(jsonArray.toString());

        List list = new ArrayList<>();
        list.add("1");
        list.add("2");
        JSONArray jsonArray1 = JSONArray.fromObject(list);
        System.out.println(jsonArray1.toString());

        String[] a = {"zs", "lisi", "ww"};
    }
}
