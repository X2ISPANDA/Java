/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

import org.apache.log4j.Logger;

import java.util.*;

/**
 * @author Mingyu Xiong
 * @description:集合的嵌套
 * @date 2019/07/25 15:51
 */
public class HashArrayListDemo {
    private static org.apache.log4j.Logger logger = Logger.getLogger(HashArrayListDemo.class);
    public static void main(String[] args) {
        logger.debug("aaa");
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        list.add("吕布");
        list.add("周瑜");
        hashMap.put("三国演义", list);
        list1.add("令狐冲");
        list1.add("林平之");
        hashMap.put("笑傲江湖", list1);
        list2.add("郭靖");
        list2.add("杨过");
        hashMap.put("神雕侠侣", list2);
        Set<Map.Entry<String, ArrayList<String>>> entries = hashMap.entrySet();
        for (Map.Entry<String, ArrayList<String>> entry : entries) {
            System.out.println(entry.getKey());
            System.out.print("");
            Iterator<String> iterator = entry.getValue().iterator();
            while (iterator.hasNext()) {
                System.out.print(" ");
                System.out.println(iterator.next());
            }
        }
        System.out.println(hashMap);

    }
}
