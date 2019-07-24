/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

import java.util.Random;
import java.util.TreeSet;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/24 16:42
 */
public class RandomDemo {
    public static void main(String[] args) {
        Random  r = new Random();
        TreeSet<Integer> hs = new TreeSet();
        int a = 10;
        while (hs.size() < a) {
            int num = r.nextInt(20) + 1;
            hs.add(num);
        }
        for(Integer i :hs){
            System.out.print(i+"  ");
        }
    }

}
