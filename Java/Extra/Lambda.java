/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/12/13 11:09
 */
public class Lambda {
    public static void main(String[] args) {
        System.out.println(12.3000001f == 12.3f);

        List<String> list = Arrays.asList("xuxiaoxiao", "xudada", "xuzhongzhong");
        Map<String, String> map = new HashMap<>();
        map.put("1", "肖浩锋");
        map.put("2", "王睿希");
        map.forEach((key,value)-> System.out.println(key+value));
        list.forEach(value -> System.out.println(value));
        list.forEach(System.out::println);

        // 1使用 lambda 获得Runnable接口对象
        new Thread(()->{
            System.out.println("我去你妈的");
        }).start();

        //2使用lambda直接获得Runnable接口对象
        Runnable race = () -> System.out.println("Hello world !");

        race.run();

        String[] players = {"zhansgan", "lisi", "wangwu", "zhaoliu",  "wangmazi"};

        Arrays.sort(players, (s1, s2) -> s1.compareTo(s2));

        float f=42.0f;
        float f1[]=new float[2];
        float f2[]=new float[2];
        float[] f3=f1;
        long x=42;
        f1[0]=42.0f;
        System.out.println(f1 == f2);
        System.out.println(x == f1[0]);
        System.out.println(f1 == f3);
        System.out.println(f2);




    }
}
