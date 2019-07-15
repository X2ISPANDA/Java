/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demoa;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/15 17:03
 */
public class MyMath {
    private double a;
    private double b;

    public MyMath(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double add() {
        return a + b;
    }

    public double sub() {
        return a - b;
    }

    public double mul() {
        return a * b;
    }

    public double div() {
        return a / b;
    }
}
