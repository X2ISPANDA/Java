package com.ychs.ssm.day07.model;

/**
 * @author Mingyu Xiong
 * @description:学生表数据模型
 * @date 2020/3/31 18:30
 */
public class StudentInfo {
    private int stuId;

    private String name;

    private String sex;

    private int age;

    private AddressInfo addressInfo;

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

    public AddressInfo getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(AddressInfo addressInfo) {
        this.addressInfo = addressInfo;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "stuId=" + stuId +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", addressInfo=" + addressInfo +
                '}';
    }
}
