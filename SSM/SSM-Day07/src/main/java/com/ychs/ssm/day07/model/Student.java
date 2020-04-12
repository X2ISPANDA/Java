package com.ychs.ssm.day07.model;

import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:学生模型,一对多映射关系
 * @date 2020/4/1 14:40
 */
public class Student {

    private int stuId;

    private String name;

    private String sex;

    private int age;

    private List<Address> addressList;

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", addressList=" + addressList +
                '}';
    }
}
