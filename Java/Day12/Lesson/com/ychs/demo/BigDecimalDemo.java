/*
 * Copyright (c) 2019.
 * All Rights Reserved By Mingyu Xiong
 */

package com.ychs.demo;

import java.math.BigDecimal;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/22 16:19
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(1);
        BigDecimal b = new BigDecimal(0.9);
        System.out.println(a.subtract(b));
        System.out.println(new BigDecimal("0.09").add(new BigDecimal("0.01")));
        System.out.println(new BigDecimal("1").divide(new BigDecimal("3"),BigDecimal.ROUND_CEILING));
    }
}
