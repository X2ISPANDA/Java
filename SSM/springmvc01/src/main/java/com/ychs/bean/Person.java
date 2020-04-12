package com.ychs.bean;

import java.util.Date;

public class Person {
    private int id;
    private String name;
    private int age;
    private Date curDate;

    public Person() {
    }

    public Person(int id, String name, int age, Date curDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.curDate = curDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getCurDate() {
        return curDate;
    }

    public void setCurDate(Date curDate) {
        this.curDate = curDate;
    }
}
