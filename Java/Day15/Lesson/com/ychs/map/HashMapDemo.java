/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.map;

import java.util.*;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/25 09:31
 */
public class HashMapDemo {
    public static void main(String[] args) {
        //定义一个map
        HashMap<Integer,String> map = new HashMap<>();
        //往map里放数据,相同Key后面的会把前面的覆盖
        map.put(1, "星期一");
        map.put(2, "星期二");
        map.put(3, "星期三");
        map.put(2, "星期四");
        System.out.println(map);
        //通过key获取value
        System.out.println(map.get(3));
        //遍历map,获取key
        Set<Integer> keys = map.keySet();
        Iterator iterator = keys.iterator();
        while (iterator.hasNext()) {
            //System.out.println(iterator.next());//在同一个循环中next()不能出现两次
            System.out.println(map.get(iterator.next()));
        }
        //获取map的所有value
        Collection<String> values = map.values();
        for (String value : values) {
            System.out.println(value);
        }

        //遍历集合的2 把map转换成set,但是set里放的是map的一个内部类叫Entry
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        for (Map.Entry<Integer, String> integerStringEntry : entrySet) {
            System.out.println(integerStringEntry.getKey()+","+integerStringEntry.getValue());
        }

        Iterator<Map.Entry<Integer, String>> iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next().getKey() + "," + iterator1.next().getValue());
        }
    }


}
