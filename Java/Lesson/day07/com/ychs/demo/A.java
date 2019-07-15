/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:访问权限
 * @date 2019/07/15 17:40
 */
public class A {
    private String name;
    int age;
    protected char sex;
    public String desc;

    public void show() {
        System.out.println(age);
        System.out.println(sex);
    }

}
