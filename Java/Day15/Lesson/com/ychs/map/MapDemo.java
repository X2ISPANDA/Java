/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mingyu Xiong
 * @description:map的其他方法
 * @date 2019/07/25 11:05
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "aaa");
        map.put(2, "bbb");
        map.put(3, "ccc");
        map.put(4, "ddd");

        boolean keyResult = map.containsKey(3);
        if (keyResult) {
            System.out.println("包含");
        } else {
            System.out.println("不包含");
        }

        boolean valueResult = map.containsValue("ddd");
        System.out.println(valueResult);
        System.out.println("集合的大小:" + map.size());
        System.out.println("map是否为空" + map.isEmpty());
        map.clear();
        System.out.println(map.size());

    }

}
