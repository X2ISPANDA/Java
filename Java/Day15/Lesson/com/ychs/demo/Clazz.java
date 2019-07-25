/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;


import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/25 15:31
 */
public class Clazz {
    private String cno;
    private String cname;

    private List<Student> stus;

    /**
     * Gets the value of stus
     *
     * @return the value of stus
     */
    public List<Student> getStus() {
        return stus;
    }

    /**
     * Sets the stus
     * You can use getStus() to get the value of stus
     *
     * @param stus stus
     */
    public void setStus(List<Student> stus) {
        this.stus = stus;
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
     * Gets the value of cname
     *
     * @return the value of cname
     */
    public String getCname() {
        return cname;
    }

    /**
     * Sets the cname
     * You can use getCname() to get the value of cname
     *
     * @param cname cname
     */
    public void setCname(String cname) {
        this.cname = cname;
    }
}
