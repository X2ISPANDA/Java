/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @Description:学员实体类
 * @Author Mingyu Xiong
 * @Date 2019/07/15 10:49
 */
public class Trainee {
    private String name;
    private int age;
    private String clazz;
    private String hobby;

    public void show() {
        System.out.println(name);
        System.out.println("年龄：" + age);
        System.out.println("班级：" + clazz);
        System.out.println("爱好：" + hobby);
    }


    public int cacu(int a, int b) {
        return a + b;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
