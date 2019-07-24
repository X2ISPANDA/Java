/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:整数表示:x=10,y=20;小数表示:x=10.5,y=20.6,字符串表示方式:x="东经180度",y="北纬10度"
 * @date 2019/07/23 09:21
 */

public class TestDemo {
    public static void main(String[] args) {
        PointDemo p1 = new PointDemo();
        p1.setX(10);
        p1.setY(20);
        System.out.println(p1);
        PointDemo p2 = new PointDemo();
        p2.setX(10.5);
        p2.setY(20.6);
        System.out.println(p2);
        PointDemo p3 = new PointDemo("东经180度","北纬10度");
        System.out.println(p3.getX()+","+p3.getY());

        PointDemo1<Integer> pointDemo1 = new PointDemo1<Integer>();
        pointDemo1.setX(1);
        pointDemo1.setY(5);
        System.out.println(pointDemo1);

        PointDemo1<Double> pointDemo11 = new PointDemo1<Double>();
        pointDemo11.setX(10.5);
        pointDemo11.setY(20.6);
        System.out.println(pointDemo11);

        PointDemo1<String> pointDemo12 = new PointDemo1<String>();
        pointDemo12.setX("东经180度");
        pointDemo12.setY("北纬10度");
        System.out.println(pointDemo12);

        PointDemo2<Integer, Double, String> pointDemo2 = new PointDemo2<>();
        pointDemo2.setX(10);
        pointDemo2.setY(1.2);
        pointDemo2.setZ("杨超越");
        System.out.println(pointDemo2);

        PointDemo2<? extends Object, Integer, String> pointDemo21 = new PointDemo2<String,Integer,String>();
        //pointDemo21.setX(new String("123"));憨批


        PersonDemo personDemo = PersonDemo.getInstance();
        personDemo.setName("zs");
        PersonDemo personDemo1 = PersonDemo.getInstance();
        System.out.println(personDemo1.getName());

        PersonDemo2 personDemo2 = PersonDemo2.getInstance();
        personDemo2.setName("zs");
        PersonDemo2 personDemo21 = PersonDemo2.getInstance();
        System.out.println(personDemo21.getName());
    }
}
