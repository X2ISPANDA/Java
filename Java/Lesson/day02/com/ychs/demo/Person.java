package com.ychs.demo;

/**
 * @Description:人类
 * @Author Mingyu Xiong
 * @Date 2019/07/08 20:22
 */
public class Person {
    //人的属性
    public String name;
    public byte height;
    public short weight;
    public int age;
    public long idCard;
    public float salary;
    public double yearSalary;
    public char sex;
    public boolean isYear;

    //定义一个方法
    public String showPerson() {
        return "Person [name=" + name + ", height=" + height + ", weight=" + weight + ", age=" + age + ", idCard="
                + idCard + ", salary=" + salary + ", yearSalary=" + yearSalary + ", sex=" + sex + ", isYear=" + isYear
                + "]";
    }
}
