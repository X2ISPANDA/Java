/*
 * Copyright (c) 2019.
 * All Rights Reserved By Mingyu Xiong
 */

package com.ychs.demo;

import java.math.BigInteger;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/22 16:10
 */
public class BigIntegerDemo {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("1231546546546548665564");
        BigInteger b = new BigInteger("554554464646464565645644656");
        BigInteger r1 = a.add(b);
        System.out.println(r1);
        System.out.println(a.subtract(b));

    }
}
