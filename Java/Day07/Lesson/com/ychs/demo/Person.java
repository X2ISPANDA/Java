/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @Description:
 * @Author Mingyu Xiong
 * @Date 2019/07/15 09:40
 */
public class Person {
    //private修饰符： 私有的，只有在该类中才能访问
    //public 共有的，这个项目中任何类都能访问
    /**
     *  身份证号
     */
    private String idCard;
    /**
     * 姓名
     */
    public String name;
    /**
     * 性别
     */
    private char sex;
    /**
     * 年龄
     */
    private int age;

    //构造方法：创建对象的时候调用构造方法，系统JVM默认提供了一个无参的构造方法
    //构造方法的要求：1. 没有返回值，连void也没有 2. 方法名称和类名称一样 3. 自己写了构造方法，系统将不再提供构造方法


    public Person() {
    }

    public Person(String idCard, String name, char sex, int age) {
        this.idCard = idCard;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.age++;
    }

    public void study() {
        System.out.println(name+"在学习");
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
