/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/24 09:41
 */
public class Student {
    private String name;

    private String sno;

    private int age;

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
     * Gets the value of sno
     *
     * @return the value of sno
     */
    public String getSno() {
        return sno;
    }

    /**
     * Sets the sno
     * You can use getSno() to get the value of sno
     *
     * @param sno sno
     */
    public void setSno(String sno) {
        this.sno = sno;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sno='" + sno + '\'' +
                ", age=" + age +
                '}';
    }
}
