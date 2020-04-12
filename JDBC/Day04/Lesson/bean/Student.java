/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package bean;

import java.io.Serializable;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/10/27 10:21
 */
public class Student implements Serializable {//钝化活化
    private String sno;
    private String sname;
    private int age;
    private String cno;

    private Clazz clazz;

    private String cname;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", cno='" + cno + '\'' +
                ", clazz=" + clazz +
                ", cname='" + cname + '\'' +
                '}';
    }
}
