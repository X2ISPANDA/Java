package com.yckj.ssm.day01.model;

/**
 * @author Mingyu Xiong
 * @description:老师数据模型
 * @date 2020/2/11 16:26
 */
public class Teacher {
    private int teacherId;

    private String name;

    private boolean sex;

    private int age;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}
