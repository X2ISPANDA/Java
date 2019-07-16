/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.test;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/16 13:00
 */
class A3{
    B3 b3 = new B3();

    static{
        System.out.println("A3");
    }
    static C3 c4 = new C3();
}
class B3{
    static{
        System.out.println("B3");
    }
}
class C3{
    static{
        System.out.println("C3");
    }
}
public class VarTest {
    public static void main(String[] args) {
        A3 a3 = new A3();
    }
}