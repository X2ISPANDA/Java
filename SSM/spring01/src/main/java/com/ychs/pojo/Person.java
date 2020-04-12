package com.ychs.pojo;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/4/6 12:51
 */
public class Person {
    private int id;
    private String name;
    private int age;
    private Phone phone;

    public Person() {
        System.out.println("初始化person");
    }

    public Person(int id, String name, int age) {
        System.out.println("有参的构造方法"+id+name+age);
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

    public void init(){
        System.out.println("初始化。。。");
    }
    public void destory(){
        System.out.println("destory....");
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
