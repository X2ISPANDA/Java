/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.bean;

/**
 * @author Mingyu Xiong
 * @description:学生实体类
 * @date 2019/07/16 09:33
 */
public class Student {
    /**
     * 学号
     */
    private String sno;
    /**
     * 学生姓名
     */
    private String sname;
    /**
     * 年龄
     */
    private int age;
    /**
     * 班级编号
     */
    private String cno;

    /**
     * 无参构造方法
     */
    public Student() {

    }

    /**
     * 有参构造方法
     *
     * @param sno   学号
     * @param sname 学生姓名
     * @param age   年龄
     * @param cno   班级编号
     */
    public Student(String sno, String sname, int age, String cno) {
        this.sno = sno;
        this.sname = sname;
        this.age = age;
        this.cno = cno;
    }

    /**
     * Gets the value of sname
     *
     * @return the value of sname
     */
    public String getSname() {
        return sname;
    }

    /**
     * Sets the sname
     * You can use getSname() to get the value of sname
     *
     * @param sname sname
     */
    public void setSname(String sname) {
        this.sname = sname;
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
     * Gets the value of cno
     *
     * @return the value of cno
     */
    public String getCno() {
        return cno;
    }

    /**
     * Sets the cno
     * You can use getCno() to get the value of cno
     *
     * @param cno cno
     */
    public void setCno(String cno) {
        this.cno = cno;
    }

    /**
     * 取出sno的值
     *
     * @return
     */
    public String getSno() {
        return sno;
    }

    /**
     * 给成员变量sno赋值
     *
     * @param sno
     */
    public void setSno(String sno) {
        this.sno = sno;
    }

    /**
     * 显示学生信息
     * @return 学生信息
     */
    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", cno='" + cno + '\'' +
                '}';
    }
}
