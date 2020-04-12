/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.pojo;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/11/9 11:14
 */
public class Course {
    private String cno;
    private String cname;

    private SC sc;

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public SC getSc() {
        return sc;
    }

    public void setSc(SC sc) {
        this.sc = sc;
    }
}
