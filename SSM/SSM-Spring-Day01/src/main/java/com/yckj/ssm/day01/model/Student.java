package com.yckj.ssm.day01.model;

/**
 * @author Mingyu Xiong
 * @description:学生数据模型
 * @date 2020/2/11 16:24
 */
public class Student
{
    private int StuId;

    private String name;

    private boolean sex;

    private int age;

    public int getStuId() {
        return StuId;
    }

    public void setStuId(int stuId) {
        StuId = stuId;
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
        return "Student{" +
                "StuId=" + StuId +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}
