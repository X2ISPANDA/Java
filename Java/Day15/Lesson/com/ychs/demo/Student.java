/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;import java.util.*;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/25 10:10
 */
public class Student {
    private String no;
    private String name;
    private int age;
    private int grade;

    public Student() {
    }

    public Student(String no, String name, int age, int grade) {
        this.no = no;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    /**
     * Gets the value of no
     *
     * @return the value of no
     */
    public String getNo() {
        return no;
    }

    /**
     * Sets the no
     * You can use getNo() to get the value of no
     *
     * @param no no
     */
    public void setNo(String no) {
        this.no = no;
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

    /**
     * Gets the value of grade
     *
     * @return the value of grade
     */
    public int getGrade() {
        return grade;
    }

    /**
     * Sets the grade
     * You can use getGrade() to get the value of grade
     *
     * @param grade grade
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }
}

class Test {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        Student stu = new Student();
        stu.setNo("yc001");
        stu.setName("渣渣辉");
        stu.setAge(18);
        stu.setGrade(59);
        map.put(stu.getNo(), stu.toString());
        Student stu1 = new Student();
        stu1.setNo("yc002");
        stu1.setName("咕天落");
        stu1.setAge(20);
        stu1.setGrade(60);
        map.put(stu1.getNo(), stu1.toString());
        Student stu2 = new Student("yc003", "林峯", 16, 90);
        map.put(stu2.getNo(), stu2.toString());

        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> stringStringEntry : entrySet) {
            System.out.println(stringStringEntry);
        }

        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.println(map.get(s));
        }
        System.out.println("检测是否存在有一个学号为yc003的学生" + map.containsKey("yc003"));

        Collection<String> values = map.values();
        Iterator iterator = values.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }
}