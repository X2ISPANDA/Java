/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.comparable;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/25 11:22
 */
public class Person implements Comparable<Person> {
    private String name;

    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Gets the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     * You can use getName() to get the value of name
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the value of age
     *
     * @return the value of age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age
     * You can use getAge() to get the value of age
     *
     * @param age age
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        //返回的值>0 <0 =0
        return this.age-o.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
